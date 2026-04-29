package com.lama.roadmap.controller;

import com.lama.roadmap.dto.*;
import com.lama.roadmap.model.Quiz;
import com.lama.roadmap.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    

    // GET all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes(
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String level) {

        return quizService.getQuizzes(path, level);
    }

    // GET quiz details
    @GetMapping("/{quizId}")
    public QuizResponse getQuiz(@PathVariable Long quizId) {
        return quizService.getQuiz(quizId);
    }

    // SUBMIT quiz
    @PostMapping("/submit")
    public int submitQuiz(@RequestBody SubmitQuizRequest request) {
        return quizService.submitQuiz(request);
    }
 // get attempts
    @GetMapping("/{quizId}/attempts/{studentId}")
    public List<QuizAttemptResponse> getAttempts(
            @PathVariable Long quizId,
            @PathVariable Long studentId) {

        return quizService.getQuizAttempts(studentId, quizId);
    }

    @GetMapping("/cards")
    public List<QuizCardDTO> getQuizCards(
            @RequestParam Long studentId,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String level) {

        return quizService.getQuizCards(studentId, path, level);
    }
    
    @GetMapping("/resume")
    public ResumeQuizDTO getResume(@RequestParam Long studentId) {
        return quizService.getResumeQuiz(studentId);
    }
    @GetMapping("/recommended")
    public RecommendedQuizDTO getRecommended(@RequestParam Long studentId) {
        return quizService.getRecommendedQuiz(studentId);
    }
    // best score
    @GetMapping("/{quizId}/best-score/{studentId}")
    public int getBestScore(
            @PathVariable Long quizId,
            @PathVariable Long studentId) {

        return quizService.getBestScore(studentId, quizId);
    }
}