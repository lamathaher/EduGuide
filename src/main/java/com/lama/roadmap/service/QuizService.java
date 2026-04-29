package com.lama.roadmap.service;

import com.lama.roadmap.dto.*;
import com.lama.roadmap.model.*;
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
    // QUIZ CARDS
    // =========================
    public List<QuizCardDTO> getQuizCards(Long studentId, String path, String level) {

        List<Quiz> quizzes;

        if (path != null && level != null) {
            quizzes = quizRepository.findByPathAndLevel(path, level);
        } else {
            quizzes = quizRepository.findAll();
        }

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return quizzes.stream()
                .map(quiz -> {

                    List<QuizAttempt> attempts =
                            attemptRepository.findByStudentAndQuiz(student, quiz);

                    int bestScore = attempts.stream()
                            .mapToInt(QuizAttempt::getScore)
                            .max()
                            .orElse(0);

                    int attemptsCount = attempts.size();

                    return new QuizCardDTO(
                            quiz.getId(),
                            quiz.getTitle(),
                            quiz.getPath(),
                            quiz.getLevel(),
                            bestScore,
                            attemptsCount,
                            bestScore > 0
                    );
                })
                .collect(Collectors.toList());
    }

    // =========================
    // RECOMMENDED QUIZ (REAL PROGRESS 🔥)
    // =========================
    public RecommendedQuizDTO getRecommendedQuiz(Long studentId) {

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<QuizAttempt> allAttempts =
                attemptRepository.findByStudent(student);

        if (allAttempts.isEmpty()) {
            return null; // ما في ولا كويز
        }

        // آخر محاولة
        QuizAttempt lastAttempt = allAttempts.get(allAttempts.size() - 1);

        Quiz quiz = lastAttempt.getQuiz();

        // نحسب progress
        int answered = answerRepository.countByAttempt(lastAttempt);
        int total = questionRepository.findByQuiz(quiz).size();

        int progress = (int) (((double) answered / total) * 100);

        // إذا مكتمل → ما بدنا continue
        if (progress == 100) {
            return null;
        }

        return new RecommendedQuizDTO(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getDescription(),
                quiz.getPath(),
                quiz.getLevel(),
                progress
        );
    }

    public ResumeQuizDTO getResumeQuiz(Long studentId) {

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<QuizAttempt> attempts = attemptRepository.findByStudent(student);

        if (attempts.isEmpty()) return null;

        QuizAttempt lastAttempt = attempts.get(attempts.size() - 1);
        Quiz quiz = lastAttempt.getQuiz();

        int answered = answerRepository.countByAttempt(lastAttempt);
        int total = questionRepository.findByQuiz(quiz).size();

        int progress = (int) (((double) answered / total) * 100);

        if (progress == 100) return null;

        // 👇 هذا أهم سطر
        int nextQuestionIndex = answered;

        return new ResumeQuizDTO(
                quiz.getId(),
                progress,
                nextQuestionIndex
        );
    }

    // =========================
    // CALCULATE SCORE
    // =========================
    private int calculateScore(SubmitQuizRequest request) {

        int correctCount = 0;

        for (AnswerDTO answer : request.getAnswers()) {

            Question question = questionRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            if (question.getCorrectAnswer().equalsIgnoreCase(answer.getAnswer())) {
                correctCount++;
            }
        }

        int total = request.getAnswers().size();

        return (int) (((double) correctCount / total) * 100);
    }

    // =========================
    // SUBMIT QUIZ
    // =========================
    public int submitQuiz(SubmitQuizRequest request) {

        System.out.println("🔥 SUBMIT QUIZ STARTED");

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // 🔥 عدد الإجابات
        System.out.println("ANSWERS SIZE = " + request.getAnswers().size());

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

        // 🔥 حفظ الإجابات
        for (AnswerDTO answer : request.getAnswers()) {

            // 🔥 اطبع كل إجابة
            System.out.println("ANSWER: " + answer.getAnswer());

            Question question = questionRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            boolean isCorrect = question.getCorrectAnswer()
                    .equalsIgnoreCase(answer.getAnswer());

            StudentAnswer studentAnswer = new StudentAnswer();
            studentAnswer.setAttempt(savedAttempt);
            studentAnswer.setQuestion(question);
            studentAnswer.setSelectedAnswer(answer.getAnswer());
            studentAnswer.setCorrect(isCorrect);
            studentAnswer.setCreatedAt(LocalDateTime.now());

            answerRepository.save(studentAnswer);
        }

        System.out.println("✅ QUIZ SUBMITTED SUCCESSFULLY, SCORE = " + score);

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
 // GET QUIZZES (OLD - optional)
 // =========================
 public List<Quiz> getQuizzes(String path, String level) {

     if (path != null && level != null) {
         return quizRepository.findByPathAndLevel(path, level);
     }

     return quizRepository.findAll();
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