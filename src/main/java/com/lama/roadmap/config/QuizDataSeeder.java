package com.lama.roadmap.config;

import com.lama.roadmap.model.Question;
import com.lama.roadmap.model.Quiz;
import com.lama.roadmap.repository.QuestionRepository;
import com.lama.roadmap.repository.QuizRepositry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QuizDataSeeder implements CommandLineRunner {

    private final QuizRepositry quizRepository;
    private final QuestionRepository questionRepository;

    public QuizDataSeeder(QuizRepositry quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {

        if (quizRepository.count() > 0) return;

        Quiz quiz = new Quiz();
        quiz.setTitle("CSS Fundamentals");
        quiz.setLevel("Beginner");
        quiz.setPath("frontend");
        quiz.setCreatedAt(LocalDateTime.now());

        Quiz savedQuiz = quizRepository.save(quiz);

        // Q1
        Question q1 = new Question();
        q1.setQuiz(savedQuiz);
        q1.setQuestionText("Which property is used to change text color?");
        q1.setOptionA("font-color");
        q1.setOptionB("text-color");
        q1.setOptionC("color");
        q1.setOptionD("foreground");
        q1.setCorrectAnswer("color");
        q1.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q1);

        // Q2
        Question q2 = new Question();
        q2.setQuiz(savedQuiz);
        q2.setQuestionText("Where should you place the <link> tag?");
        q2.setOptionA("Inside <body>");
        q2.setOptionB("Inside <head>");
        q2.setOptionC("After </html>");
        q2.setOptionD("Inside <footer>");
        q2.setCorrectAnswer("Inside <head>");
        q2.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q2);

        // Q3
        Question q3 = new Question();
        q3.setQuiz(savedQuiz);
        q3.setQuestionText("Which selector selects an element with id='box'?");
        q3.setOptionA(".box");
        q3.setOptionB("#box");
        q3.setOptionC("box");
        q3.setOptionD("*box");
        q3.setCorrectAnswer("#box");
        q3.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q3);

        // Q4
        Question q4 = new Question();
        q4.setQuiz(savedQuiz);
        q4.setQuestionText("What does this do? p { text-align: center; }");
        q4.setOptionA("Centers the paragraph element");
        q4.setOptionB("Centers text inside paragraph");
        q4.setOptionC("Moves paragraph to center");
        q4.setOptionD("Makes text bold");
        q4.setCorrectAnswer("Centers text inside paragraph");
        q4.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q4);

        // Q5
        Question q5 = new Question();
        q5.setQuiz(savedQuiz);
        q5.setQuestionText("Which property sets background color?");
        q5.setOptionA("bgcolor");
        q5.setOptionB("background-color");
        q5.setOptionC("color");
        q5.setOptionD("background-style");
        q5.setCorrectAnswer("background-color");
        q5.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q5);

        // Q6
        Question q6 = new Question();
        q6.setQuiz(savedQuiz);
        q6.setQuestionText("Which is correct CSS syntax?");
        q6.setOptionA("body:color=black;");
        q6.setOptionB("{body;color:black}");
        q6.setOptionC("body {color: black;}");
        q6.setOptionD("{body:color=black}");
        q6.setCorrectAnswer("body {color: black;}");
        q6.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q6);

        // Q7
        Question q7 = new Question();
        q7.setQuiz(savedQuiz);
        q7.setQuestionText("How do you write a CSS comment?");
        q7.setOptionA("// comment");
        q7.setOptionB("/* comment */");
        q7.setOptionC("# comment");
        q7.setOptionD("** comment **");
        q7.setCorrectAnswer("/* comment */");
        q7.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q7);

        // Q8
        Question q8 = new Question();
        q8.setQuiz(savedQuiz);
        q8.setQuestionText("Which property controls spacing inside element?");
        q8.setOptionA("margin");
        q8.setOptionB("padding");
        q8.setOptionC("spacing");
        q8.setOptionD("border-spacing");
        q8.setCorrectAnswer("padding");
        q8.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q8);

        // Q9
        Question q9 = new Question();
        q9.setQuiz(savedQuiz);
        q9.setQuestionText("If two CSS rules conflict, which one is applied?");
        q9.setOptionA("First one");
        q9.setOptionB("Last one");
        q9.setOptionC("Both");
        q9.setOptionD("None");
        q9.setCorrectAnswer("Last one");
        q9.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q9);

        // Q10
        Question q10 = new Question();
        q10.setQuiz(savedQuiz);
        q10.setQuestionText("What does .container p select?");
        q10.setOptionA("All p with class container");
        q10.setOptionB("All p inside .container");
        q10.setOptionC("Only direct p children");
        q10.setOptionD("All container inside p");
        q10.setCorrectAnswer("All p inside .container");
        q10.setCreatedAt(LocalDateTime.now());
        questionRepository.save(q10);
    }
}