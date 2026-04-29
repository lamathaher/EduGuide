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
        
        
     // =======================
     // Frontend Quiz 2 - HTML
     // =======================

     Quiz quiz2 = new Quiz();
     quiz2.setTitle("HTML Fundamentals");
     quiz2.setLevel("Beginner");
     quiz2.setPath("frontend");
     quiz2.setCreatedAt(LocalDateTime.now());

     Quiz savedQuiz2 = quizRepository.save(quiz2);

     // Q1
     Question h1 = new Question();
     h1.setQuiz(savedQuiz2);
     h1.setQuestionText("What does HTML stand for?");
     h1.setOptionA("Hyper Trainer Marking Language");
     h1.setOptionB("Hyper Text Markup Language");
     h1.setOptionC("Hyper Text Marketing Language");
     h1.setOptionD("Hyper Tool Markup Language");
     h1.setCorrectAnswer("Hyper Text Markup Language");
     h1.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h1);

     // Q2
     Question h2 = new Question();
     h2.setQuiz(savedQuiz2);
     h2.setQuestionText("Which tag is used for the largest heading?");
     h2.setOptionA("<h6>");
     h2.setOptionB("<heading>");
     h2.setOptionC("<h1>");
     h2.setOptionD("<head>");
     h2.setCorrectAnswer("<h1>");
     h2.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h2);

     // Q3
     Question h3 = new Question();
     h3.setQuiz(savedQuiz2);
     h3.setQuestionText("Which tag is used to create a hyperlink?");
     h3.setOptionA("<a>");
     h3.setOptionB("<link>");
     h3.setOptionC("<href>");
     h3.setOptionD("<url>");
     h3.setCorrectAnswer("<a>");
     h3.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h3);

     // Q4
     Question h4 = new Question();
     h4.setQuiz(savedQuiz2);
     h4.setQuestionText("Where should the <title> tag be placed?");
     h4.setOptionA("Inside <body>");
     h4.setOptionB("Inside <head>");
     h4.setOptionC("After </html>");
     h4.setOptionD("Inside <footer>");
     h4.setCorrectAnswer("Inside <head>");
     h4.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h4);

     // Q5
     Question h5 = new Question();
     h5.setQuiz(savedQuiz2);
     h5.setQuestionText("Which tag is used to display an image?");
     h5.setOptionA("<image>");
     h5.setOptionB("<img>");
     h5.setOptionC("<src>");
     h5.setOptionD("<pic>");
     h5.setCorrectAnswer("<img>");
     h5.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h5);

     // Q6
     Question h6 = new Question();
     h6.setQuiz(savedQuiz2);
     h6.setQuestionText("Which attribute is used for image source?");
     h6.setOptionA("link");
     h6.setOptionB("src");
     h6.setOptionC("href");
     h6.setOptionD("url");
     h6.setCorrectAnswer("src");
     h6.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h6);

     // Q7
     Question h7 = new Question();
     h7.setQuiz(savedQuiz2);
     h7.setQuestionText("Which tag is used to create a paragraph?");
     h7.setOptionA("<p>");
     h7.setOptionB("<para>");
     h7.setOptionC("<text>");
     h7.setOptionD("<pg>");
     h7.setCorrectAnswer("<p>");
     h7.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h7);

     // Q8
     Question h8 = new Question();
     h8.setQuiz(savedQuiz2);
     h8.setQuestionText("Which tag creates a line break?");
     h8.setOptionA("<break>");
     h8.setOptionB("<br>");
     h8.setOptionC("<lb>");
     h8.setOptionD("<newline>");
     h8.setCorrectAnswer("<br>");
     h8.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h8);

     // Q9
     Question h9 = new Question();
     h9.setQuiz(savedQuiz2);
     h9.setQuestionText("What does the <head> section contain?");
     h9.setOptionA("Visible page content");
     h9.setOptionB("Metadata and title");
     h9.setOptionC("Images only");
     h9.setOptionD("Footer content");
     h9.setCorrectAnswer("Metadata and title");
     h9.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h9);

     // Q10
     Question h10 = new Question();
     h10.setQuiz(savedQuiz2);
     h10.setQuestionText("Which HTML tag is used for lists?");
     h10.setOptionA("<list>");
     h10.setOptionB("<ul>");
     h10.setOptionC("<li>");
     h10.setOptionD("<dl>");
     h10.setCorrectAnswer("<ul>");
     h10.setCreatedAt(LocalDateTime.now());
     questionRepository.save(h10);
     
     
  // =======================
  // Frontend Quiz 3 - JavaScript Basics
  // =======================

  Quiz quiz3 = new Quiz();
  quiz3.setTitle("JavaScript Basics");
  quiz3.setLevel("Intermediate");
  quiz3.setPath("frontend");
  quiz3.setCreatedAt(LocalDateTime.now());

  Quiz savedQuiz3 = quizRepository.save(quiz3);

  // Q1
  Question j1 = new Question();
  j1.setQuiz(savedQuiz3);
  j1.setQuestionText("Which language is used for web page interactivity?");
  j1.setOptionA("HTML");
  j1.setOptionB("CSS");
  j1.setOptionC("JavaScript");
  j1.setOptionD("SQL");
  j1.setCorrectAnswer("JavaScript");
  j1.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j1);

  // Q2
  Question j2 = new Question();
  j2.setQuiz(savedQuiz3);
  j2.setQuestionText("How do you declare a variable in JavaScript?");
  j2.setOptionA("int x = 5;");
  j2.setOptionB("let x = 5;");
  j2.setOptionC("variable x = 5;");
  j2.setOptionD("x := 5;");
  j2.setCorrectAnswer("let x = 5;");
  j2.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j2);

  // Q3
  Question j3 = new Question();
  j3.setQuiz(savedQuiz3);
  j3.setQuestionText("What will console.log(5 + 5) output?");
  j3.setOptionA("10");
  j3.setOptionB("55");
  j3.setOptionC("Error");
  j3.setOptionD("undefined");
  j3.setCorrectAnswer("10");
  j3.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j3);

  // Q4
  Question j4 = new Question();
  j4.setQuiz(savedQuiz3);
  j4.setQuestionText("Which keyword is used to define a function?");
  j4.setOptionA("method");
  j4.setOptionB("function");
  j4.setOptionC("def");
  j4.setOptionD("func");
  j4.setCorrectAnswer("function");
  j4.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j4);

  // Q5
  Question j5 = new Question();
  j5.setQuiz(savedQuiz3);
  j5.setQuestionText("What does '===' mean in JavaScript?");
  j5.setOptionA("Assign value");
  j5.setOptionB("Compare values only");
  j5.setOptionC("Compare value and type");
  j5.setOptionD("Not equal");
  j5.setCorrectAnswer("Compare value and type");
  j5.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j5);

  // Q6
  Question j6 = new Question();
  j6.setQuiz(savedQuiz3);
  j6.setQuestionText("Which symbol is used for single-line comments?");
  j6.setOptionA("<!-- -->");
  j6.setOptionB("//");
  j6.setOptionC("#");
  j6.setOptionD("**");
  j6.setCorrectAnswer("//");
  j6.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j6);

  // Q7
  Question j7 = new Question();
  j7.setQuiz(savedQuiz3);
  j7.setQuestionText("What is the result of '2' + 2 in JavaScript?");
  j7.setOptionA("4");
  j7.setOptionB("22");
  j7.setOptionC("Error");
  j7.setOptionD("undefined");
  j7.setCorrectAnswer("22");
  j7.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j7);

  // Q8
  Question j8 = new Question();
  j8.setQuiz(savedQuiz3);
  j8.setQuestionText("Which method is used to print something in console?");
  j8.setOptionA("print()");
  j8.setOptionB("console.log()");
  j8.setOptionC("echo()");
  j8.setOptionD("log()");
  j8.setCorrectAnswer("console.log()");
  j8.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j8);

  // Q9
  Question j9 = new Question();
  j9.setQuiz(savedQuiz3);
  j9.setQuestionText("Which data type is used for true/false?");
  j9.setOptionA("String");
  j9.setOptionB("Number");
  j9.setOptionC("Boolean");
  j9.setOptionD("Array");
  j9.setCorrectAnswer("Boolean");
  j9.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j9);

  // Q10
  Question j10 = new Question();
  j10.setQuiz(savedQuiz3);
  j10.setQuestionText("What will this return? typeof 'Hello'");
  j10.setOptionA("string");
  j10.setOptionB("text");
  j10.setOptionC("word");
  j10.setOptionD("char");
  j10.setCorrectAnswer("string");
  j10.setCreatedAt(LocalDateTime.now());
  questionRepository.save(j10);
  
//=======================
//Frontend Quiz 4 - JavaScript DOM & Events
//=======================

Quiz quiz4 = new Quiz();
quiz4.setTitle("JavaScript DOM & Events");
quiz4.setLevel("Intermediate");
quiz4.setPath("frontend");
quiz4.setCreatedAt(LocalDateTime.now());

Quiz savedQuiz4 = quizRepository.save(quiz4);

//Q1
Question d1 = new Question();
d1.setQuiz(savedQuiz4);
d1.setQuestionText("What does document.getElementById('title') return?");
d1.setOptionA("All elements with id 'title'");
d1.setOptionB("The first element with id 'title'");
d1.setOptionC("A list of elements");
d1.setOptionD("Only text content");
d1.setCorrectAnswer("The first element with id 'title'");
d1.setCreatedAt(LocalDateTime.now());
questionRepository.save(d1);

//Q2
Question d2 = new Question();
d2.setQuiz(savedQuiz4);
d2.setQuestionText("Which method selects the first matching element using CSS selector?");
d2.setOptionA("getElement()");
d2.setOptionB("querySelector()");
d2.setOptionC("getByClass()");
d2.setOptionD("selectOne()");
d2.setCorrectAnswer("querySelector()");
d2.setCreatedAt(LocalDateTime.now());
questionRepository.save(d2);

//Q3
Question d3 = new Question();
d3.setQuiz(savedQuiz4);
d3.setQuestionText("What will this code do? document.getElementById('demo').innerText = 'Hello';");
d3.setOptionA("Create a new element");
d3.setOptionB("Change the text inside the element");
d3.setOptionC("Delete the element");
d3.setOptionD("Hide the element");
d3.setCorrectAnswer("Change the text inside the element");
d3.setCreatedAt(LocalDateTime.now());
questionRepository.save(d3);

//Q4
Question d4 = new Question();
d4.setQuiz(savedQuiz4);
d4.setQuestionText("Which property is used to change CSS style using JavaScript?");
d4.setOptionA("element.css");
d4.setOptionB("element.style");
d4.setOptionC("element.design");
d4.setOptionD("element.class");
d4.setCorrectAnswer("element.style");
d4.setCreatedAt(LocalDateTime.now());
questionRepository.save(d4);

//Q5
Question d5 = new Question();
d5.setQuiz(savedQuiz4);
d5.setQuestionText("What happens when a user clicks a button with onclick='myFunction()'?");
d5.setOptionA("The page reloads");
d5.setOptionB("The function is executed");
d5.setOptionC("The button disappears");
d5.setOptionD("Nothing happens");
d5.setCorrectAnswer("The function is executed");
d5.setCreatedAt(LocalDateTime.now());
questionRepository.save(d5);

//Q6
Question d6 = new Question();
d6.setQuiz(savedQuiz4);
d6.setQuestionText("What is the benefit of using addEventListener instead of onclick?");
d6.setOptionA("It is faster");
d6.setOptionB("It allows multiple events and better control");
d6.setOptionC("It uses less memory");
d6.setOptionD("It only works with buttons");
d6.setCorrectAnswer("It allows multiple events and better control");
d6.setCreatedAt(LocalDateTime.now());
questionRepository.save(d6);

//Q7
Question d7 = new Question();
d7.setQuiz(savedQuiz4);
d7.setQuestionText("Which code correctly changes the background color of an element?");
d7.setOptionA("element.bg = 'red';");
d7.setOptionB("element.style.backgroundColor = 'red';");
d7.setOptionC("element.color = 'red';");
d7.setOptionD("element.background = red;");
d7.setCorrectAnswer("element.style.backgroundColor = 'red';");
d7.setCreatedAt(LocalDateTime.now());
questionRepository.save(d7);

//Q8
Question d8 = new Question();
d8.setQuiz(savedQuiz4);
d8.setQuestionText("What does querySelectorAll('.item') return?");
d8.setOptionA("First matching element");
d8.setOptionB("A single element");
d8.setOptionC("A list of all matching elements");
d8.setOptionD("Only visible elements");
d8.setCorrectAnswer("A list of all matching elements");
d8.setCreatedAt(LocalDateTime.now());
questionRepository.save(d8);

//Q9
Question d9 = new Question();
d9.setQuiz(savedQuiz4);
d9.setQuestionText("What will happen if getElementById is used with a non-existing id?");
d9.setOptionA("Error");
d9.setOptionB("null");
d9.setOptionC("undefined");
d9.setOptionD("empty string");
d9.setCorrectAnswer("null");
d9.setCreatedAt(LocalDateTime.now());
questionRepository.save(d9);

//Q10
Question d10 = new Question();
d10.setQuiz(savedQuiz4);
d10.setQuestionText("Which event is triggered when the user types in an input field?");
d10.setOptionA("click");
d10.setOptionB("change");
d10.setOptionC("input");
d10.setOptionD("submit");
d10.setCorrectAnswer("input");
d10.setCreatedAt(LocalDateTime.now());
questionRepository.save(d10);

//=======================
//Frontend Quiz 5 - JavaScript Logic & Conditions
//=======================

Quiz quiz5 = new Quiz();
quiz5.setTitle("JavaScript Logic & Conditions");
quiz5.setLevel("Intermediate");
quiz5.setPath("frontend");
quiz5.setCreatedAt(LocalDateTime.now());

Quiz savedQuiz5 = quizRepository.save(quiz5);

//Q1
Question l1 = new Question();
l1.setQuiz(savedQuiz5);
l1.setQuestionText("What will be the output? if (5 > 3) { console.log('Yes'); }");
l1.setOptionA("Yes");
l1.setOptionB("No");
l1.setOptionC("Error");
l1.setOptionD("Nothing");
l1.setCorrectAnswer("Yes");
l1.setCreatedAt(LocalDateTime.now());
questionRepository.save(l1);

//Q2
Question l2 = new Question();
l2.setQuiz(savedQuiz5);
l2.setQuestionText("Which operator is used for 'not equal' in JavaScript?");
l2.setOptionA("!=");
l2.setOptionB("!==");
l2.setOptionC("Both are valid");
l2.setOptionD("None");
l2.setCorrectAnswer("Both are valid");
l2.setCreatedAt(LocalDateTime.now());
questionRepository.save(l2);

//Q3
Question l3 = new Question();
l3.setQuiz(savedQuiz5);
l3.setQuestionText("What will this return? Boolean(0)");
l3.setOptionA("true");
l3.setOptionB("false");
l3.setOptionC("undefined");
l3.setOptionD("error");
l3.setCorrectAnswer("false");
l3.setCreatedAt(LocalDateTime.now());
questionRepository.save(l3);

//Q4
Question l4 = new Question();
l4.setQuiz(savedQuiz5);
l4.setQuestionText("Which loop is guaranteed to run at least once?");
l4.setOptionA("for");
l4.setOptionB("while");
l4.setOptionC("do...while");
l4.setOptionD("foreach");
l4.setCorrectAnswer("do...while");
l4.setCreatedAt(LocalDateTime.now());
questionRepository.save(l4);

//Q5
Question l5 = new Question();
l5.setQuiz(savedQuiz5);
l5.setQuestionText("What will this output? console.log(2 > 3 || 5 > 2)");
l5.setOptionA("true");
l5.setOptionB("false");
l5.setOptionC("undefined");
l5.setOptionD("error");
l5.setCorrectAnswer("true");
l5.setCreatedAt(LocalDateTime.now());
questionRepository.save(l5);

//Q6
Question l6 = new Question();
l6.setQuiz(savedQuiz5);
l6.setQuestionText("What does '&&' operator do?");
l6.setOptionA("OR");
l6.setOptionB("AND");
l6.setOptionC("NOT");
l6.setOptionD("COMPARE");
l6.setCorrectAnswer("AND");
l6.setCreatedAt(LocalDateTime.now());
questionRepository.save(l6);

//Q7
Question l7 = new Question();
l7.setQuiz(savedQuiz5);
l7.setQuestionText("What will this return? !!'hello'");
l7.setOptionA("true");
l7.setOptionB("false");
l7.setOptionC("error");
l7.setOptionD("undefined");
l7.setCorrectAnswer("true");
l7.setCreatedAt(LocalDateTime.now());
questionRepository.save(l7);

//Q8
Question l8 = new Question();
l8.setQuiz(savedQuiz5);
l8.setQuestionText("Which statement is used for multiple conditions?");
l8.setOptionA("if only");
l8.setOptionB("switch");
l8.setOptionC("loop");
l8.setOptionD("function");
l8.setCorrectAnswer("switch");
l8.setCreatedAt(LocalDateTime.now());
questionRepository.save(l8);

//Q9
Question l9 = new Question();
l9.setQuiz(savedQuiz5);
l9.setQuestionText("What is the result of 5 == '5'?");
l9.setOptionA("true");
l9.setOptionB("false");
l9.setOptionC("error");
l9.setOptionD("undefined");
l9.setCorrectAnswer("true");
l9.setCreatedAt(LocalDateTime.now());
questionRepository.save(l9);

//Q10
Question l10 = new Question();
l10.setQuiz(savedQuiz5);
l10.setQuestionText("What is the result of 5 === '5'?");
l10.setOptionA("true");
l10.setOptionB("false");
l10.setOptionC("error");
l10.setOptionD("undefined");
l10.setCorrectAnswer("false");
l10.setCreatedAt(LocalDateTime.now());
questionRepository.save(l10);

//=======================
//Frontend Quiz 6 - Asynchronous JavaScript
//=======================

Quiz quiz6 = new Quiz();
quiz6.setTitle("Asynchronous JavaScript");
quiz6.setLevel("Advanced");
quiz6.setPath("frontend");
quiz6.setCreatedAt(LocalDateTime.now());

Quiz savedQuiz6 = quizRepository.save(quiz6);

//Q1
Question a1 = new Question();
a1.setQuiz(savedQuiz6);
a1.setQuestionText("What is asynchronous code?");
a1.setOptionA("Code that runs step by step only");
a1.setOptionB("Code that can run without blocking other operations");
a1.setOptionC("Code that runs only once");
a1.setOptionD("Code that never runs");
a1.setCorrectAnswer("Code that can run without blocking other operations");
a1.setCreatedAt(LocalDateTime.now());
questionRepository.save(a1);

//Q2
Question a2 = new Question();
a2.setQuiz(savedQuiz6);
a2.setQuestionText("Which function is used to delay execution?");
a2.setOptionA("setTimeout()");
a2.setOptionB("delay()");
a2.setOptionC("wait()");
a2.setOptionD("pause()");
a2.setCorrectAnswer("setTimeout()");
a2.setCreatedAt(LocalDateTime.now());
questionRepository.save(a2);

//Q3
Question a3 = new Question();
a3.setQuiz(savedQuiz6);
a3.setQuestionText("What is a Promise?");
a3.setOptionA("A variable");
a3.setOptionB("An object representing future completion of an operation");
a3.setOptionC("A loop");
a3.setOptionD("A condition");
a3.setCorrectAnswer("An object representing future completion of an operation");
a3.setCreatedAt(LocalDateTime.now());
questionRepository.save(a3);

//Q4
Question a4 = new Question();
a4.setQuiz(savedQuiz6);
a4.setQuestionText("Which method handles successful Promise result?");
a4.setOptionA("catch()");
a4.setOptionB("then()");
a4.setOptionC("final()");
a4.setOptionD("success()");
a4.setCorrectAnswer("then()");
a4.setCreatedAt(LocalDateTime.now());
questionRepository.save(a4);

//Q5
Question a5 = new Question();
a5.setQuiz(savedQuiz6);
a5.setQuestionText("Which method handles errors in Promises?");
a5.setOptionA("then()");
a5.setOptionB("error()");
a5.setOptionC("catch()");
a5.setOptionD("fail()");
a5.setCorrectAnswer("catch()");
a5.setCreatedAt(LocalDateTime.now());
questionRepository.save(a5);

//Q6
Question a6 = new Question();
a6.setQuiz(savedQuiz6);
a6.setQuestionText("What does fetch() return?");
a6.setOptionA("HTML");
a6.setOptionB("Promise");
a6.setOptionC("String");
a6.setOptionD("Number");
a6.setCorrectAnswer("Promise");
a6.setCreatedAt(LocalDateTime.now());
questionRepository.save(a6);

//Q7
Question a7 = new Question();
a7.setQuiz(savedQuiz6);
a7.setQuestionText("What happens if you don’t handle a Promise rejection?");
a7.setOptionA("Nothing");
a7.setOptionB("The program crashes always");
a7.setOptionC("An error may occur");
a7.setOptionD("It becomes synchronous");
a7.setCorrectAnswer("An error may occur");
a7.setCreatedAt(LocalDateTime.now());
questionRepository.save(a7);

//Q8
Question a8 = new Question();
a8.setQuiz(savedQuiz6);
a8.setQuestionText("Which keyword is used with async functions?");
a8.setOptionA("await");
a8.setOptionB("wait");
a8.setOptionC("pause");
a8.setOptionD("hold");
a8.setCorrectAnswer("await");
a8.setCreatedAt(LocalDateTime.now());
questionRepository.save(a8);

//Q9
Question a9 = new Question();
a9.setQuiz(savedQuiz6);
a9.setQuestionText("What does async keyword do?");
a9.setOptionA("Stops execution");
a9.setOptionB("Makes function return a Promise");
a9.setOptionC("Loops code");
a9.setOptionD("Delays code");
a9.setCorrectAnswer("Makes function return a Promise");
a9.setCreatedAt(LocalDateTime.now());
questionRepository.save(a9);

//Q10
Question a10 = new Question();
a10.setQuiz(savedQuiz6);
a10.setQuestionText("Why is asynchronous code important in web apps?");
a10.setOptionA("To make code longer");
a10.setOptionB("To avoid blocking UI");
a10.setOptionC("To remove errors");
a10.setOptionD("To simplify HTML");
a10.setCorrectAnswer("To avoid blocking UI");
a10.setCreatedAt(LocalDateTime.now());
questionRepository.save(a10);
    }
}