package com.lama.roadmap.service;

import com.lama.roadmap.dto.*;
import com.lama.roadmap.model.Question;
import com.lama.roadmap.model.Quiz;
import com.lama.roadmap.model.QuizAttempt;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepositry quizRepository;
    private final QuestionRepository questionRepository;
    private final QuizAttemptRepository attemptRepository;
    private final StudentAnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final InstructorAssignmentRepository assignmentRepository;
    private final NotificationService notificationService;

    public QuizService(QuizRepositry quizRepository,
                       QuestionRepository questionRepository,
                       QuizAttemptRepository attemptRepository,
                       StudentAnswerRepository answerRepository,
                       UserRepository userRepository,
                       InstructorAssignmentRepository assignmentRepository,
                       NotificationService notificationService) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.attemptRepository = attemptRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.assignmentRepository = assignmentRepository;
        this.notificationService = notificationService;
    }

    // =========================
    // GET QUIZ
    // =========================
    public QuizResponse getQuiz(Long quizId) {

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<Question> questions = questionRepository.findByQuiz(quiz);
        Collections.shuffle(questions);

        List<QuestionDTO> questionDTOS = questions.stream()
                .map(q -> {
                    QuestionDTO dto = new QuestionDTO();
                    dto.setId(q.getId());
                    dto.setQuestionText(q.getQuestionText());
                    dto.setOptionA(q.getOptionA());
                    dto.setOptionB(q.getOptionB());
                    dto.setOptionC(q.getOptionC());
                    dto.setOptionD(q.getOptionD());
                    return dto;
                })
                .collect(Collectors.toList());

        QuizResponse response = new QuizResponse();
        response.setId(quiz.getId());
        response.setTitle(quiz.getTitle());
        response.setPath(quiz.getPath());
        response.setLevel(quiz.getLevel());
        response.setQuestions(questionDTOS);

        return response;
    }

    // =========================
    // GET QUIZZES
    // =========================
    public List<Quiz> getQuizzes(String path, String level) {

        if (path != null && level != null) {
            return quizRepository.findByPathAndLevel(path, level);
        }

        return quizRepository.findAll();
    }
    
    private int calculateScore(SubmitQuizRequest request) {

        int correctCount = 0;

        for (AnswerDTO answer : request.getAnswers()) {

            Question question = questionRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            if (question.getCorrectAnswer().equalsIgnoreCase(answer.getAnswer()))
            {
                correctCount++;
            }
        }

        int total = request.getAnswers().size();

        // نحسب نسبة مئوية
        return (int) (((double) correctCount / total) * 100);
    }

    // =========================
    // SUBMIT QUIZ 🔥
    // =========================
    public int submitQuiz(SubmitQuizRequest request) {

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // حساب السكور
        int score = calculateScore(request);

        int attemptNumber = attemptRepository.countByStudentAndQuiz(student, quiz) + 1;

        QuizAttempt attempt = new QuizAttempt();
        attempt.setStudent(student);
        attempt.setQuiz(quiz);
        attempt.setScore(score);
        attempt.setTotalQuestions(request.getAnswers().size());
        attempt.setAttemptNumber(attemptNumber);
        attempt.setCreatedAt(LocalDateTime.now());

        QuizAttempt savedAttempt = attemptRepository.save(attempt);

        // =========================
        // 🔔 Notification للطالب
        // =========================
        notificationService.createNotification(
                student.getId(),
                "Quiz Completed",
                "You completed '" + quiz.getTitle() + "' with score " + score + "%",
                "QUIZ_RESULT",
                savedAttempt.getId()
        );

        // =========================
        // 🔔 Notification للمدرب
        // =========================
        assignmentRepository
                .findByStudentIdAndStatus(student.getId(), "active")
                .ifPresent(assignment -> {

                    String message = student.getFullName()
                            + " completed '" + quiz.getTitle()
                            + "' with score " + score + "%";

                    notificationService.createNotification(
                            assignment.getInstructor().getId(),
                            "Student Quiz Update",
                            message,
                            "QUIZ_RESULT",
                            savedAttempt.getId()
                    );
                });

        return score;
    }

    // =========================
    // GET ATTEMPTS
    // =========================
    public List<QuizAttemptResponse> getQuizAttempts(Long studentId, Long quizId) {

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuizAttempt> attempts = attemptRepository.findByStudentAndQuiz(student, quiz);

        return attempts.stream().map(a -> {
            QuizAttemptResponse res = new QuizAttemptResponse();
            res.setScore(a.getScore());
            res.setTotalQuestions(a.getTotalQuestions());
            res.setAttemptNumber(a.getAttemptNumber());
            res.setDate(a.getCreatedAt().toString());
            return res;
        }).collect(Collectors.toList());
    }

    // =========================
    // BEST SCORE
    // =========================
    public int getBestScore(Long studentId, Long quizId) {

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuizAttempt> attempts = attemptRepository.findByStudentAndQuiz(student, quiz);

        return attempts.stream()
                .mapToInt(QuizAttempt::getScore)
                .max()
                .orElse(0);
    }
}