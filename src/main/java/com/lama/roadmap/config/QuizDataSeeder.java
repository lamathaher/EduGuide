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



//=======================
//Backend Quiz 1 - Java Basics
//=======================

Quiz backendQuiz1 = new Quiz();
backendQuiz1.setTitle("Java Basics");
backendQuiz1.setLevel("Beginner");
backendQuiz1.setPath("Backend Web Development");
backendQuiz1.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz1 = quizRepository.save(backendQuiz1);

//Q1
Question b1 = new Question();
b1.setQuiz(savedBackendQuiz1);
b1.setQuestionText("Which keyword is used to create a class in Java?");
b1.setOptionA("function");
b1.setOptionB("class");
b1.setOptionC("define");
b1.setOptionD("object");
b1.setCorrectAnswer("class");
b1.setCreatedAt(LocalDateTime.now());
questionRepository.save(b1);

//Q2
Question b2 = new Question();
b2.setQuiz(savedBackendQuiz1);
b2.setQuestionText("Which method is the entry point of a Java program?");
b2.setOptionA("run()");
b2.setOptionB("main()");
b2.setOptionC("start()");
b2.setOptionD("init()");
b2.setCorrectAnswer("main()");
b2.setCreatedAt(LocalDateTime.now());
questionRepository.save(b2);

//Q3
Question b3 = new Question();
b3.setQuiz(savedBackendQuiz1);
b3.setQuestionText("Which data type is used for decimal numbers?");
b3.setOptionA("int");
b3.setOptionB("char");
b3.setOptionC("double");
b3.setOptionD("boolean");
b3.setCorrectAnswer("double");
b3.setCreatedAt(LocalDateTime.now());
questionRepository.save(b3);

//Q4
Question b4 = new Question();
b4.setQuiz(savedBackendQuiz1);
b4.setQuestionText("What will System.out.println(5 + 5); print?");
b4.setOptionA("55");
b4.setOptionB("10");
b4.setOptionC("Error");
b4.setOptionD("null");
b4.setCorrectAnswer("10");
b4.setCreatedAt(LocalDateTime.now());
questionRepository.save(b4);

//Q5
Question b5 = new Question();
b5.setQuiz(savedBackendQuiz1);
b5.setQuestionText("Which symbol is used to end a statement in Java?");
b5.setOptionA(":");
b5.setOptionB(".");
b5.setOptionC(";");
b5.setOptionD(",");
b5.setCorrectAnswer(";");
b5.setCreatedAt(LocalDateTime.now());
questionRepository.save(b5);

//Q6
Question b6 = new Question();
b6.setQuiz(savedBackendQuiz1);
b6.setQuestionText("Which keyword is used to declare a constant variable?");
b6.setOptionA("final");
b6.setOptionB("static");
b6.setOptionC("const");
b6.setOptionD("fixed");
b6.setCorrectAnswer("final");
b6.setCreatedAt(LocalDateTime.now());
questionRepository.save(b6);

//Q7
Question b7 = new Question();
b7.setQuiz(savedBackendQuiz1);
b7.setQuestionText("Which loop is best when the number of iterations is known?");
b7.setOptionA("while");
b7.setOptionB("do...while");
b7.setOptionC("for");
b7.setOptionD("foreach");
b7.setCorrectAnswer("for");
b7.setCreatedAt(LocalDateTime.now());
questionRepository.save(b7);

//Q8
Question b8 = new Question();
b8.setQuiz(savedBackendQuiz1);
b8.setQuestionText("What is the result of 10 % 3 ?");
b8.setOptionA("3");
b8.setOptionB("1");
b8.setOptionC("0");
b8.setOptionD("10");
b8.setCorrectAnswer("1");
b8.setCreatedAt(LocalDateTime.now());
questionRepository.save(b8);

//Q9
Question b9 = new Question();
b9.setQuiz(savedBackendQuiz1);
b9.setQuestionText("Which keyword is used for conditional statements?");
b9.setOptionA("loop");
b9.setOptionB("if");
b9.setOptionC("switcher");
b9.setOptionD("check");
b9.setCorrectAnswer("if");
b9.setCreatedAt(LocalDateTime.now());
questionRepository.save(b9);

//Q10
Question b10 = new Question();
b10.setQuiz(savedBackendQuiz1);
b10.setQuestionText("Which of these is a boolean value in Java?");
b10.setOptionA("\"true\"");
b10.setOptionB("1");
b10.setOptionC("true");
b10.setOptionD("'true'");
b10.setCorrectAnswer("true");
b10.setCreatedAt(LocalDateTime.now());
questionRepository.save(b10);

//=======================
//Backend Quiz 2 - OOP Fundamentals
//=======================

Quiz backendQuiz2 = new Quiz();
backendQuiz2.setTitle("OOP Fundamentals");
backendQuiz2.setLevel("Beginner");
backendQuiz2.setPath("Backend Web Development");
backendQuiz2.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz2 = quizRepository.save(backendQuiz2);

//Q1
Question o1 = new Question();
o1.setQuiz(savedBackendQuiz2);
o1.setQuestionText("What does OOP stand for?");
o1.setOptionA("Object Oriented Programming");
o1.setOptionB("Online Operation Program");
o1.setOptionC("Object Organized Process");
o1.setOptionD("Open Object Programming");
o1.setCorrectAnswer("Object Oriented Programming");
o1.setCreatedAt(LocalDateTime.now());
questionRepository.save(o1);

//Q2
Question o2 = new Question();
o2.setQuiz(savedBackendQuiz2);
o2.setQuestionText("Which keyword is used to create an object in Java?");
o2.setOptionA("this");
o2.setOptionB("new");
o2.setOptionC("object");
o2.setOptionD("create");
o2.setCorrectAnswer("new");
o2.setCreatedAt(LocalDateTime.now());
questionRepository.save(o2);

//Q3
Question o3 = new Question();
o3.setQuiz(savedBackendQuiz2);
o3.setQuestionText("What is a class in Java?");
o3.setOptionA("A loop");
o3.setOptionB("A blueprint for objects");
o3.setOptionC("A database");
o3.setOptionD("A package");
o3.setCorrectAnswer("A blueprint for objects");
o3.setCreatedAt(LocalDateTime.now());
questionRepository.save(o3);

//Q4
Question o4 = new Question();
o4.setQuiz(savedBackendQuiz2);
o4.setQuestionText("Which concept allows a class to inherit properties from another class?");
o4.setOptionA("Encapsulation");
o4.setOptionB("Polymorphism");
o4.setOptionC("Inheritance");
o4.setOptionD("Abstraction");
o4.setCorrectAnswer("Inheritance");
o4.setCreatedAt(LocalDateTime.now());
questionRepository.save(o4);

//Q5
Question o5 = new Question();
o5.setQuiz(savedBackendQuiz2);
o5.setQuestionText("What does encapsulation help with?");
o5.setOptionA("Hiding internal data");
o5.setOptionB("Creating databases");
o5.setOptionC("Running loops");
o5.setOptionD("Connecting APIs");
o5.setCorrectAnswer("Hiding internal data");
o5.setCreatedAt(LocalDateTime.now());
questionRepository.save(o5);

//Q6
Question o6 = new Question();
o6.setQuiz(savedBackendQuiz2);
o6.setQuestionText("Which access modifier allows access only inside the same class?");
o6.setOptionA("public");
o6.setOptionB("protected");
o6.setOptionC("private");
o6.setOptionD("default");
o6.setCorrectAnswer("private");
o6.setCreatedAt(LocalDateTime.now());
questionRepository.save(o6);

//Q7
Question o7 = new Question();
o7.setQuiz(savedBackendQuiz2);
o7.setQuestionText("What is polymorphism in OOP?");
o7.setOptionA("Using one method in different ways");
o7.setOptionB("Creating multiple databases");
o7.setOptionC("Writing HTML inside Java");
o7.setOptionD("Storing files");
o7.setCorrectAnswer("Using one method in different ways");
o7.setCreatedAt(LocalDateTime.now());
questionRepository.save(o7);

//Q8
Question o8 = new Question();
o8.setQuiz(savedBackendQuiz2);
o8.setQuestionText("Which keyword refers to the current object?");
o8.setOptionA("super");
o8.setOptionB("self");
o8.setOptionC("this");
o8.setOptionD("current");
o8.setCorrectAnswer("this");
o8.setCreatedAt(LocalDateTime.now());
questionRepository.save(o8);

//Q9
Question o9 = new Question();
o9.setQuiz(savedBackendQuiz2);
o9.setQuestionText("What happens if a method is marked as private?");
o9.setOptionA("It can be accessed anywhere");
o9.setOptionB("It can only be used inside the same class");
o9.setOptionC("It becomes static automatically");
o9.setOptionD("It is deleted after execution");
o9.setCorrectAnswer("It can only be used inside the same class");
o9.setCreatedAt(LocalDateTime.now());
questionRepository.save(o9);

//Q10
Question o10 = new Question();
o10.setQuiz(savedBackendQuiz2);
o10.setQuestionText("Which OOP concept focuses on showing essential features only?");
o10.setOptionA("Inheritance");
o10.setOptionB("Encapsulation");
o10.setOptionC("Abstraction");
o10.setOptionD("Overloading");
o10.setCorrectAnswer("Abstraction");
o10.setCreatedAt(LocalDateTime.now());
questionRepository.save(o10);


//=======================
//Backend Quiz 3 - Spring Boot Basics
//=======================

Quiz backendQuiz3 = new Quiz();
backendQuiz3.setTitle("Spring Boot Basics");
backendQuiz3.setLevel("Intermediate");
backendQuiz3.setPath("Backend Web Development");
backendQuiz3.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz3 = quizRepository.save(backendQuiz3);

//Q1
Question s1 = new Question();
s1.setQuiz(savedBackendQuiz3);
s1.setQuestionText("What is Spring Boot mainly used for?");
s1.setOptionA("Designing UI");
s1.setOptionB("Building Java backend applications quickly");
s1.setOptionC("Managing databases only");
s1.setOptionD("Creating mobile apps");
s1.setCorrectAnswer("Building Java backend applications quickly");
s1.setCreatedAt(LocalDateTime.now());
questionRepository.save(s1);

//Q2
Question s2 = new Question();
s2.setQuiz(savedBackendQuiz3);
s2.setQuestionText("Which annotation marks the main Spring Boot application class?");
s2.setOptionA("@Controller");
s2.setOptionB("@Service");
s2.setOptionC("@SpringBootApplication");
s2.setOptionD("@Autowired");
s2.setCorrectAnswer("@SpringBootApplication");
s2.setCreatedAt(LocalDateTime.now());
questionRepository.save(s2);

//Q3
Question s3 = new Question();
s3.setQuiz(savedBackendQuiz3);
s3.setQuestionText("Which annotation is used to create a REST controller?");
s3.setOptionA("@Repository");
s3.setOptionB("@RestController");
s3.setOptionC("@Component");
s3.setOptionD("@Entity");
s3.setCorrectAnswer("@RestController");
s3.setCreatedAt(LocalDateTime.now());
questionRepository.save(s3);

//Q4
Question s4 = new Question();
s4.setQuiz(savedBackendQuiz3);
s4.setQuestionText("What does @GetMapping usually handle?");
s4.setOptionA("Deleting data");
s4.setOptionB("Updating data");
s4.setOptionC("Fetching data");
s4.setOptionD("Stopping the server");
s4.setCorrectAnswer("Fetching data");
s4.setCreatedAt(LocalDateTime.now());
questionRepository.save(s4);

//Q5
Question s5 = new Question();
s5.setQuiz(savedBackendQuiz3);
s5.setQuestionText("Which layer is responsible for business logic?");
s5.setOptionA("Controller");
s5.setOptionB("Repository");
s5.setOptionC("Service");
s5.setOptionD("Entity");
s5.setCorrectAnswer("Service");
s5.setCreatedAt(LocalDateTime.now());
questionRepository.save(s5);

//Q6
Question s6 = new Question();
s6.setQuiz(savedBackendQuiz3);
s6.setQuestionText("What is the purpose of @Autowired?");
s6.setOptionA("Connecting frontend files");
s6.setOptionB("Automatically injecting dependencies");
s6.setOptionC("Creating database tables");
s6.setOptionD("Running loops");
s6.setCorrectAnswer("Automatically injecting dependencies");
s6.setCreatedAt(LocalDateTime.now());
questionRepository.save(s6);

//Q7
Question s7 = new Question();
s7.setQuiz(savedBackendQuiz3);
s7.setQuestionText("Which annotation marks a database entity?");
s7.setOptionA("@Bean");
s7.setOptionB("@Table");
s7.setOptionC("@Entity");
s7.setOptionD("@Data");
s7.setCorrectAnswer("@Entity");
s7.setCreatedAt(LocalDateTime.now());
questionRepository.save(s7);

//Q8
Question s8 = new Question();
s8.setQuiz(savedBackendQuiz3);
s8.setQuestionText("What happens if a controller endpoint is not mapped correctly?");
s8.setOptionA("The server shuts down");
s8.setOptionB("The request may return 404");
s8.setOptionC("The database resets");
s8.setOptionD("The API becomes public");
s8.setCorrectAnswer("The request may return 404");
s8.setCreatedAt(LocalDateTime.now());
questionRepository.save(s8);

//Q9
Question s9 = new Question();
s9.setQuiz(savedBackendQuiz3);
s9.setQuestionText("Which file is commonly used for Spring Boot configuration?");
s9.setOptionA("config.html");
s9.setOptionB("application.properties");
s9.setOptionC("settings.java");
s9.setOptionD("boot.config");
s9.setCorrectAnswer("application.properties");
s9.setCreatedAt(LocalDateTime.now());
questionRepository.save(s9);

//Q10
Question s10 = new Question();
s10.setQuiz(savedBackendQuiz3);
s10.setQuestionText("Why is Spring Boot popular for backend development?");
s10.setOptionA("It removes the need for Java");
s10.setOptionB("It simplifies setup and development");
s10.setOptionC("It only works with frontend");
s10.setOptionD("It replaces databases");
s10.setCorrectAnswer("It simplifies setup and development");
s10.setCreatedAt(LocalDateTime.now());
questionRepository.save(s10);

//=======================
//Backend Quiz 4 - REST APIs
//=======================

Quiz backendQuiz4 = new Quiz();
backendQuiz4.setTitle("REST APIs");
backendQuiz4.setLevel("Intermediate");
backendQuiz4.setPath("Backend Web Development");
backendQuiz4.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz4 = quizRepository.save(backendQuiz4);

//Q1
Question r1 = new Question();
r1.setQuiz(savedBackendQuiz4);
r1.setQuestionText("What does REST stand for?");
r1.setOptionA("Remote Execution System Technology");
r1.setOptionB("Representational State Transfer");
r1.setOptionC("Responsive Server Transfer");
r1.setOptionD("Relational State Technique");
r1.setCorrectAnswer("Representational State Transfer");
r1.setCreatedAt(LocalDateTime.now());
questionRepository.save(r1);

//Q2
Question r2 = new Question();
r2.setQuiz(savedBackendQuiz4);
r2.setQuestionText("Which HTTP method is commonly used to fetch data?");
r2.setOptionA("POST");
r2.setOptionB("DELETE");
r2.setOptionC("GET");
r2.setOptionD("PUT");
r2.setCorrectAnswer("GET");
r2.setCreatedAt(LocalDateTime.now());
questionRepository.save(r2);

//Q3
Question r3 = new Question();
r3.setQuiz(savedBackendQuiz4);
r3.setQuestionText("Which HTTP method is mainly used to create new data?");
r3.setOptionA("POST");
r3.setOptionB("GET");
r3.setOptionC("DELETE");
r3.setOptionD("PATCH");
r3.setCorrectAnswer("POST");
r3.setCreatedAt(LocalDateTime.now());
questionRepository.save(r3);

//Q4
Question r4 = new Question();
r4.setQuiz(savedBackendQuiz4);
r4.setQuestionText("What status code usually means 'Not Found'?");
r4.setOptionA("200");
r4.setOptionB("201");
r4.setOptionC("404");
r4.setOptionD("500");
r4.setCorrectAnswer("404");
r4.setCreatedAt(LocalDateTime.now());
questionRepository.save(r4);

//Q5
Question r5 = new Question();
r5.setQuiz(savedBackendQuiz4);
r5.setQuestionText("Which annotation is used to map POST requests in Spring Boot?");
r5.setOptionA("@GetMapping");
r5.setOptionB("@PutMapping");
r5.setOptionC("@PostMapping");
r5.setOptionD("@RequestBody");
r5.setCorrectAnswer("@PostMapping");
r5.setCreatedAt(LocalDateTime.now());
questionRepository.save(r5);

//Q6
Question r6 = new Question();
r6.setQuiz(savedBackendQuiz4);
r6.setQuestionText("What format is commonly used in REST API responses?");
r6.setOptionA("PDF");
r6.setOptionB("XML only");
r6.setOptionC("JSON");
r6.setOptionD("TXT");
r6.setCorrectAnswer("JSON");
r6.setCreatedAt(LocalDateTime.now());
questionRepository.save(r6);

//Q7
Question r7 = new Question();
r7.setQuiz(savedBackendQuiz4);
r7.setQuestionText("What does @RequestBody do in Spring Boot?");
r7.setOptionA("Reads incoming JSON data");
r7.setOptionB("Deletes request data");
r7.setOptionC("Creates database tables");
r7.setOptionD("Secures the API");
r7.setCorrectAnswer("Reads incoming JSON data");
r7.setCreatedAt(LocalDateTime.now());
questionRepository.save(r7);

//Q8
Question r8 = new Question();
r8.setQuiz(savedBackendQuiz4);
r8.setQuestionText("Which method is usually used to update existing data?");
r8.setOptionA("GET");
r8.setOptionB("PUT");
r8.setOptionC("POST");
r8.setOptionD("OPTIONS");
r8.setCorrectAnswer("PUT");
r8.setCreatedAt(LocalDateTime.now());
questionRepository.save(r8);

//Q9
Question r9 = new Question();
r9.setQuiz(savedBackendQuiz4);
r9.setQuestionText("Why are REST APIs useful?");
r9.setOptionA("They connect frontend and backend systems");
r9.setOptionB("They replace databases");
r9.setOptionC("They only work with Java");
r9.setOptionD("They remove the need for servers");
r9.setCorrectAnswer("They connect frontend and backend systems");
r9.setCreatedAt(LocalDateTime.now());
questionRepository.save(r9);

//Q10
Question r10 = new Question();
r10.setQuiz(savedBackendQuiz4);
r10.setQuestionText("What may happen if an API endpoint URL is incorrect?");
r10.setOptionA("The database gets deleted");
r10.setOptionB("The request may fail");
r10.setOptionC("The server changes language");
r10.setOptionD("The API becomes faster");
r10.setCorrectAnswer("The request may fail");
r10.setCreatedAt(LocalDateTime.now());
questionRepository.save(r10);
//=======================
//Backend Quiz 5 - Database & JPA
//=======================

Quiz backendQuiz5 = new Quiz();
backendQuiz5.setTitle("Database & JPA");
backendQuiz5.setLevel("Intermediate");
backendQuiz5.setPath("Backend Web Development");
backendQuiz5.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz5 = quizRepository.save(backendQuiz5);

//Q1
Question f1 = new Question();
f1.setQuiz(savedBackendQuiz5);
f1.setQuestionText("What is the main purpose of a database?");
f1.setOptionA("Styling web pages");
f1.setOptionB("Storing and managing data");
f1.setOptionC("Creating animations");
f1.setOptionD("Running APIs");
f1.setCorrectAnswer("Storing and managing data");
f1.setCreatedAt(LocalDateTime.now());
questionRepository.save(f1);

//Q2
Question f2 = new Question();
f2.setQuiz(savedBackendQuiz5);
f2.setQuestionText("Which annotation marks a primary key in JPA?");
f2.setOptionA("@Column");
f2.setOptionB("@Entity");
f2.setOptionC("@Id");
f2.setOptionD("@Table");
f2.setCorrectAnswer("@Id");
f2.setCreatedAt(LocalDateTime.now());
questionRepository.save(f2);

//Q3
Question f3 = new Question();
f3.setQuiz(savedBackendQuiz5);
f3.setQuestionText("Which annotation enables automatic ID generation?");
f3.setOptionA("@GeneratedValue");
f3.setOptionB("@AutoId");
f3.setOptionC("@PrimaryKey");
f3.setOptionD("@Identity");
f3.setCorrectAnswer("@GeneratedValue");
f3.setCreatedAt(LocalDateTime.now());
questionRepository.save(f3);

//Q4
Question f4 = new Question();
f4.setQuiz(savedBackendQuiz5);
f4.setQuestionText("What does JPA mainly help developers with?");
f4.setOptionA("Designing UI");
f4.setOptionB("Managing Java objects and databases");
f4.setOptionC("Creating mobile apps");
f4.setOptionD("Running CSS files");
f4.setCorrectAnswer("Managing Java objects and databases");
f4.setCreatedAt(LocalDateTime.now());
questionRepository.save(f4);

//Q5
Question f5 = new Question();
f5.setQuiz(savedBackendQuiz5);
f5.setQuestionText("Which SQL command is used to retrieve data?");
f5.setOptionA("INSERT");
f5.setOptionB("UPDATE");
f5.setOptionC("SELECT");
f5.setOptionD("DELETE");
f5.setCorrectAnswer("SELECT");
f5.setCreatedAt(LocalDateTime.now());
questionRepository.save(f5);

//Q6
Question f6 = new Question();
f6.setQuiz(savedBackendQuiz5);
f6.setQuestionText("What is the role of a Repository in Spring Boot?");
f6.setOptionA("Handling HTTP requests");
f6.setOptionB("Managing database operations");
f6.setOptionC("Creating frontend pages");
f6.setOptionD("Styling components");
f6.setCorrectAnswer("Managing database operations");
f6.setCreatedAt(LocalDateTime.now());
questionRepository.save(f6);

//Q7
Question f7 = new Question();
f7.setQuiz(savedBackendQuiz5);
f7.setQuestionText("Which annotation maps a class to a database table?");
f7.setOptionA("@Service");
f7.setOptionB("@Controller");
f7.setOptionC("@Table");
f7.setOptionD("@JoinColumn");
f7.setCorrectAnswer("@Table");
f7.setCreatedAt(LocalDateTime.now());
questionRepository.save(f7);

//Q8
Question f8 = new Question();
f8.setQuiz(savedBackendQuiz5);
f8.setQuestionText("What may happen if an entity has no @Id field?");
f8.setOptionA("The app becomes faster");
f8.setOptionB("JPA may fail to manage the entity");
f8.setOptionC("The frontend breaks");
f8.setOptionD("The API becomes public");
f8.setCorrectAnswer("JPA may fail to manage the entity");
f8.setCreatedAt(LocalDateTime.now());
questionRepository.save(f8);

//Q9
Question f9 = new Question();
f9.setQuiz(savedBackendQuiz5);
f9.setQuestionText("Which relationship represents many records linked to one record?");
f9.setOptionA("@OneToOne");
f9.setOptionB("@ManyToOne");
f9.setOptionC("@OneToMany");
f9.setOptionD("@ManyToMany");
f9.setCorrectAnswer("@ManyToOne");
f9.setCreatedAt(LocalDateTime.now());
questionRepository.save(f9);

//Q10
Question f10 = new Question();
f10.setQuiz(savedBackendQuiz5);
f10.setQuestionText("Why is ORM useful in backend development?");
f10.setOptionA("It replaces Java completely");
f10.setOptionB("It simplifies working with databases using objects");
f10.setOptionC("It creates frontend automatically");
f10.setOptionD("It removes the need for APIs");
f10.setCorrectAnswer("It simplifies working with databases using objects");
f10.setCreatedAt(LocalDateTime.now());
questionRepository.save(f10);

//=======================
//Backend Quiz 6 - Security & Authentication
//=======================

Quiz backendQuiz6 = new Quiz();
backendQuiz6.setTitle("Security & Authentication");
backendQuiz6.setLevel("Advanced");
backendQuiz6.setPath("Backend Web Development");
backendQuiz6.setCreatedAt(LocalDateTime.now());

Quiz savedBackendQuiz6 = quizRepository.save(backendQuiz6);

//Q1
Question i1 = new Question();
i1.setQuiz(savedBackendQuiz6);
i1.setQuestionText("What is the main purpose of authentication?");
i1.setOptionA("Styling web pages");
i1.setOptionB("Verifying user identity");
i1.setOptionC("Connecting databases");
i1.setOptionD("Improving API speed");
i1.setCorrectAnswer("Verifying user identity");
i1.setCreatedAt(LocalDateTime.now());
questionRepository.save(i1);

//Q2
Question i2 = new Question();
i2.setQuiz(savedBackendQuiz6);
i2.setQuestionText("Which HTTP status code usually means 'Unauthorized'?");
i2.setOptionA("200");
i2.setOptionB("201");
i2.setOptionC("401");
i2.setOptionD("404");
i2.setCorrectAnswer("401");
i2.setCreatedAt(LocalDateTime.now());
questionRepository.save(i2);

//Q3
Question i3 = new Question();
i3.setQuiz(savedBackendQuiz6);
i3.setQuestionText("Why should passwords be hashed before storing them?");
i3.setOptionA("To reduce server size");
i3.setOptionB("To improve frontend design");
i3.setOptionC("To protect sensitive user data");
i3.setOptionD("To speed up APIs");
i3.setCorrectAnswer("To protect sensitive user data");
i3.setCreatedAt(LocalDateTime.now());
questionRepository.save(i3);

//Q4
Question i4 = new Question();
i4.setQuiz(savedBackendQuiz6);
i4.setQuestionText("Which Spring Security annotation restricts access based on roles?");
i4.setOptionA("@GetMapping");
i4.setOptionB("@Autowired");
i4.setOptionC("@PreAuthorize");
i4.setOptionD("@Entity");
i4.setCorrectAnswer("@PreAuthorize");
i4.setCreatedAt(LocalDateTime.now());
questionRepository.save(i4);

//Q5
Question i5 = new Question();
i5.setQuiz(savedBackendQuiz6);
i5.setQuestionText("What is JWT commonly used for?");
i5.setOptionA("Creating database tables");
i5.setOptionB("Managing authentication tokens");
i5.setOptionC("Styling APIs");
i5.setOptionD("Compressing files");
i5.setCorrectAnswer("Managing authentication tokens");
i5.setCreatedAt(LocalDateTime.now());
questionRepository.save(i5);

//Q6
Question i6 = new Question();
i6.setQuiz(savedBackendQuiz6);
i6.setQuestionText("What may happen if API endpoints are left unprotected?");
i6.setOptionA("Better performance");
i6.setOptionB("Unauthorized users may access data");
i6.setOptionC("The database becomes faster");
i6.setOptionD("Frontend styles may break");
i6.setCorrectAnswer("Unauthorized users may access data");
i6.setCreatedAt(LocalDateTime.now());
questionRepository.save(i6);

//Q7
Question i7 = new Question();
i7.setQuiz(savedBackendQuiz6);
i7.setQuestionText("Which practice improves backend API security?");
i7.setOptionA("Exposing database passwords publicly");
i7.setOptionB("Using HTTPS for requests");
i7.setOptionC("Removing authentication");
i7.setOptionD("Disabling validation");
i7.setCorrectAnswer("Using HTTPS for requests");
i7.setCreatedAt(LocalDateTime.now());
questionRepository.save(i7);

//Q8
Question i8 = new Question();
i8.setQuiz(savedBackendQuiz6);
i8.setQuestionText("What is authorization mainly responsible for?");
i8.setOptionA("Checking internet speed");
i8.setOptionB("Determining user permissions");
i8.setOptionC("Creating APIs");
i8.setOptionD("Building UI components");
i8.setCorrectAnswer("Determining user permissions");
i8.setCreatedAt(LocalDateTime.now());
questionRepository.save(i8);

//Q9
Question i9 = new Question();
i9.setQuiz(savedBackendQuiz6);
i9.setQuestionText("Why is input validation important in backend systems?");
i9.setOptionA("To make pages colorful");
i9.setOptionB("To prevent invalid or harmful data");
i9.setOptionC("To replace databases");
i9.setOptionD("To remove authentication");
i9.setCorrectAnswer("To prevent invalid or harmful data");
i9.setCreatedAt(LocalDateTime.now());
questionRepository.save(i9);

//Q10
Question i10 = new Question();
i10.setQuiz(savedBackendQuiz6);
i10.setQuestionText("What is one risk of storing plain text passwords?");
i10.setOptionA("Faster login");
i10.setOptionB("Easier debugging");
i10.setOptionC("User accounts can be compromised if data leaks");
i10.setOptionD("Improved database performance");
i10.setCorrectAnswer("User accounts can be compromised if data leaks");
i10.setCreatedAt(LocalDateTime.now());
questionRepository.save(i10);

//=======================
//Machine Learning Quiz 1 - Python for Machine Learning
//=======================

Quiz mlQuiz1 = new Quiz();
mlQuiz1.setTitle("Python for Machine Learning");
mlQuiz1.setLevel("Beginner");
mlQuiz1.setPath("Machine Learning");
mlQuiz1.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz1 = quizRepository.save(mlQuiz1);

//Q1
Question m1 = new Question();
m1.setQuiz(savedMlQuiz1);
m1.setQuestionText("Why is Python popular in Machine Learning?");
m1.setOptionA("It only works for web design");
m1.setOptionB("It has powerful ML libraries");
m1.setOptionC("It replaces databases");
m1.setOptionD("It is only used for mobile apps");
m1.setCorrectAnswer("It has powerful ML libraries");
m1.setCreatedAt(LocalDateTime.now());
questionRepository.save(m1);

//Q2
Question m2 = new Question();
m2.setQuiz(savedMlQuiz1);
m2.setQuestionText("Which library is commonly used for data analysis in Python?");
m2.setOptionA("React");
m2.setOptionB("NumPy");
m2.setOptionC("Flutter");
m2.setOptionD("Spring");
m2.setCorrectAnswer("NumPy");
m2.setCreatedAt(LocalDateTime.now());
questionRepository.save(m2);

//Q3
Question m3 = new Question();
m3.setQuiz(savedMlQuiz1);
m3.setQuestionText("Which Python library is widely used for data visualization?");
m3.setOptionA("TensorFlow");
m3.setOptionB("Laravel");
m3.setOptionC("Matplotlib");
m3.setOptionD("Hibernate");
m3.setCorrectAnswer("Matplotlib");
m3.setCreatedAt(LocalDateTime.now());
questionRepository.save(m3);

//Q4
Question m4 = new Question();
m4.setQuiz(savedMlQuiz1);
m4.setQuestionText("What is the purpose of a dataset in Machine Learning?");
m4.setOptionA("To style web pages");
m4.setOptionB("To train and test models");
m4.setOptionC("To create APIs");
m4.setOptionD("To manage passwords");
m4.setCorrectAnswer("To train and test models");
m4.setCreatedAt(LocalDateTime.now());
questionRepository.save(m4);

//Q5
Question m5 = new Question();
m5.setQuiz(savedMlQuiz1);
m5.setQuestionText("Which keyword is used to define a function in Python?");
m5.setOptionA("func");
m5.setOptionB("define");
m5.setOptionC("def");
m5.setOptionD("function");
m5.setCorrectAnswer("def");
m5.setCreatedAt(LocalDateTime.now());
questionRepository.save(m5);

//Q6
Question m6 = new Question();
m6.setQuiz(savedMlQuiz1);
m6.setQuestionText("Which library is commonly used for Machine Learning models?");
m6.setOptionA("Scikit-learn");
m6.setOptionB("Bootstrap");
m6.setOptionC("Tailwind");
m6.setOptionD("Vue");
m6.setCorrectAnswer("Scikit-learn");
m6.setCreatedAt(LocalDateTime.now());
questionRepository.save(m6);

//Q7
Question m7 = new Question();
m7.setQuiz(savedMlQuiz1);
m7.setQuestionText("What does a Machine Learning model learn from?");
m7.setOptionA("Random colors");
m7.setOptionB("Training data");
m7.setOptionC("HTML files");
m7.setOptionD("Server ports");
m7.setCorrectAnswer("Training data");
m7.setCreatedAt(LocalDateTime.now());
questionRepository.save(m7);

//Q8
Question m8 = new Question();
m8.setQuiz(savedMlQuiz1);
m8.setQuestionText("Which data type stores multiple values in Python?");
m8.setOptionA("list");
m8.setOptionB("float");
m8.setOptionC("boolean");
m8.setOptionD("char");
m8.setCorrectAnswer("list");
m8.setCreatedAt(LocalDateTime.now());
questionRepository.save(m8);

//Q9
Question m9 = new Question();
m9.setQuiz(savedMlQuiz1);
m9.setQuestionText("Why is cleaning data important before training a model?");
m9.setOptionA("To make the UI prettier");
m9.setOptionB("To improve model accuracy");
m9.setOptionC("To remove Python");
m9.setOptionD("To create animations");
m9.setCorrectAnswer("To improve model accuracy");
m9.setCreatedAt(LocalDateTime.now());
questionRepository.save(m9);

//Q10
Question m10 = new Question();
m10.setQuiz(savedMlQuiz1);
m10.setQuestionText("What may happen if training data contains many errors?");
m10.setOptionA("The model may perform poorly");
m10.setOptionB("The frontend becomes faster");
m10.setOptionC("The database is deleted");
m10.setOptionD("The API becomes secure");
m10.setCorrectAnswer("The model may perform poorly");
m10.setCreatedAt(LocalDateTime.now());
questionRepository.save(m10);


//=======================
//Machine Learning Quiz 2 - Machine Learning Fundamentals
//=======================

Quiz mlQuiz2 = new Quiz();
mlQuiz2.setTitle("Machine Learning Fundamentals");
mlQuiz2.setLevel("Beginner");
mlQuiz2.setPath("Machine Learning");
mlQuiz2.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz2 = quizRepository.save(mlQuiz2);

//Q1
Question n1 = new Question();
n1.setQuiz(savedMlQuiz2);
n1.setQuestionText("What is the main goal of Machine Learning?");
n1.setOptionA("Designing websites");
n1.setOptionB("Allowing systems to learn from data");
n1.setOptionC("Replacing databases");
n1.setOptionD("Creating operating systems");
n1.setCorrectAnswer("Allowing systems to learn from data");
n1.setCreatedAt(LocalDateTime.now());
questionRepository.save(n1);

//Q2
Question n2 = new Question();
n2.setQuiz(savedMlQuiz2);
n2.setQuestionText("Which type of Machine Learning uses labeled data?");
n2.setOptionA("Unsupervised Learning");
n2.setOptionB("Reinforcement Learning");
n2.setOptionC("Supervised Learning");
n2.setOptionD("Random Learning");
n2.setCorrectAnswer("Supervised Learning");
n2.setCreatedAt(LocalDateTime.now());
questionRepository.save(n2);

//Q3
Question n3 = new Question();
n3.setQuiz(savedMlQuiz2);
n3.setQuestionText("What is a feature in a dataset?");
n3.setOptionA("The final prediction only");
n3.setOptionB("An input variable used for learning");
n3.setOptionC("A programming language");
n3.setOptionD("A database table");
n3.setCorrectAnswer("An input variable used for learning");
n3.setCreatedAt(LocalDateTime.now());
questionRepository.save(n3);

//Q4
Question n4 = new Question();
n4.setQuiz(savedMlQuiz2);
n4.setQuestionText("Which algorithm is commonly used for classification tasks?");
n4.setOptionA("Linear Regression");
n4.setOptionB("K-Nearest Neighbors");
n4.setOptionC("CSS Grid");
n4.setOptionD("Flexbox");
n4.setCorrectAnswer("K-Nearest Neighbors");
n4.setCreatedAt(LocalDateTime.now());
questionRepository.save(n4);

//Q5
Question n5 = new Question();
n5.setQuiz(savedMlQuiz2);
n5.setQuestionText("What is overfitting in Machine Learning?");
n5.setOptionA("When the model performs well only on training data");
n5.setOptionB("When the model ignores all data");
n5.setOptionC("When the dataset is too small");
n5.setOptionD("When Python crashes");
n5.setCorrectAnswer("When the model performs well only on training data");
n5.setCreatedAt(LocalDateTime.now());
questionRepository.save(n5);

//Q6
Question n6 = new Question();
n6.setQuiz(savedMlQuiz2);
n6.setQuestionText("Why is splitting data into training and testing sets important?");
n6.setOptionA("To improve website styling");
n6.setOptionB("To evaluate model performance fairly");
n6.setOptionC("To reduce Python syntax");
n6.setOptionD("To create APIs");
n6.setCorrectAnswer("To evaluate model performance fairly");
n6.setCreatedAt(LocalDateTime.now());
questionRepository.save(n6);

//Q7
Question n7 = new Question();
n7.setQuiz(savedMlQuiz2);
n7.setQuestionText("Which library is commonly used for deep learning?");
n7.setOptionA("TensorFlow");
n7.setOptionB("Bootstrap");
n7.setOptionC("Tailwind");
n7.setOptionD("jQuery");
n7.setCorrectAnswer("TensorFlow");
n7.setCreatedAt(LocalDateTime.now());
questionRepository.save(n7);

//Q8
Question n8 = new Question();
n8.setQuiz(savedMlQuiz2);
n8.setQuestionText("What may happen if a dataset contains biased data?");
n8.setOptionA("The model may produce unfair predictions");
n8.setOptionB("The frontend becomes responsive");
n8.setOptionC("The server shuts down");
n8.setOptionD("The database deletes itself");
n8.setCorrectAnswer("The model may produce unfair predictions");
n8.setCreatedAt(LocalDateTime.now());
questionRepository.save(n8);

//Q9
Question n9 = new Question();
n9.setQuiz(savedMlQuiz2);
n9.setQuestionText("Which evaluation metric is commonly used for classification?");
n9.setOptionA("Accuracy");
n9.setOptionB("Font size");
n9.setOptionC("Resolution");
n9.setOptionD("Padding");
n9.setCorrectAnswer("Accuracy");
n9.setCreatedAt(LocalDateTime.now());
questionRepository.save(n9);

//Q10
Question n10 = new Question();
n10.setQuiz(savedMlQuiz2);
n10.setQuestionText("What is the purpose of preprocessing data?");
n10.setOptionA("To prepare data before training the model");
n10.setOptionB("To create HTML pages");
n10.setOptionC("To replace algorithms");
n10.setOptionD("To style dashboards");
n10.setCorrectAnswer("To prepare data before training the model");
n10.setCreatedAt(LocalDateTime.now());
questionRepository.save(n10);

//=======================
//Machine Learning Quiz 3 - Data Preprocessing & Feature Engineering
//=======================

Quiz mlQuiz3 = new Quiz();
mlQuiz3.setTitle("Data Preprocessing & Feature Engineering");
mlQuiz3.setLevel("Intermediate");
mlQuiz3.setPath("Machine Learning");
mlQuiz3.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz3 = quizRepository.save(mlQuiz3);

//Q1
Question z1 = new Question();
z1.setQuiz(savedMlQuiz3);
z1.setQuestionText("Why is data preprocessing important in Machine Learning?");
z1.setOptionA("It improves data quality before training");
z1.setOptionB("It replaces Machine Learning models");
z1.setOptionC("It creates frontend pages");
z1.setOptionD("It removes the need for datasets");
z1.setCorrectAnswer("It improves data quality before training");
z1.setCreatedAt(LocalDateTime.now());
questionRepository.save(z1);

//Q2
Question z2 = new Question();
z2.setQuiz(savedMlQuiz3);
z2.setQuestionText("What is the purpose of handling missing values?");
z2.setOptionA("To avoid inaccurate model behavior");
z2.setOptionB("To increase internet speed");
z2.setOptionC("To style charts");
z2.setOptionD("To remove algorithms");
z2.setCorrectAnswer("To avoid inaccurate model behavior");
z2.setCreatedAt(LocalDateTime.now());
questionRepository.save(z2);

//Q3
Question z3 = new Question();
z3.setQuiz(savedMlQuiz3);
z3.setQuestionText("Which technique scales numerical values into a smaller range?");
z3.setOptionA("Normalization");
z3.setOptionB("Classification");
z3.setOptionC("Regression");
z3.setOptionD("Clustering");
z3.setCorrectAnswer("Normalization");
z3.setCreatedAt(LocalDateTime.now());
questionRepository.save(z3);

//Q4
Question z4 = new Question();
z4.setQuiz(savedMlQuiz3);
z4.setQuestionText("What is feature engineering?");
z4.setOptionA("Creating or improving input features for models");
z4.setOptionB("Building frontend components");
z4.setOptionC("Deploying servers");
z4.setOptionD("Writing CSS code");
z4.setCorrectAnswer("Creating or improving input features for models");
z4.setCreatedAt(LocalDateTime.now());
questionRepository.save(z4);

//Q5
Question z5 = new Question();
z5.setQuiz(savedMlQuiz3);
z5.setQuestionText("Why can duplicate rows in a dataset be problematic?");
z5.setOptionA("They may bias the model");
z5.setOptionB("They improve model accuracy");
z5.setOptionC("They replace preprocessing");
z5.setOptionD("They reduce storage usage");
z5.setCorrectAnswer("They may bias the model");
z5.setCreatedAt(LocalDateTime.now());
questionRepository.save(z5);

//Q6
Question z6 = new Question();
z6.setQuiz(savedMlQuiz3);
z6.setQuestionText("Which preprocessing step converts text categories into numbers?");
z6.setOptionA("Encoding");
z6.setOptionB("Clustering");
z6.setOptionC("Deployment");
z6.setOptionD("Regression");
z6.setCorrectAnswer("Encoding");
z6.setCreatedAt(LocalDateTime.now());
questionRepository.save(z6);

//Q7
Question z7 = new Question();
z7.setQuiz(savedMlQuiz3);
z7.setQuestionText("What may happen if features have very different scales?");
z7.setOptionA("Some algorithms may perform poorly");
z7.setOptionB("The model becomes a database");
z7.setOptionC("The frontend stops working");
z7.setOptionD("The dataset becomes encrypted");
z7.setCorrectAnswer("Some algorithms may perform poorly");
z7.setCreatedAt(LocalDateTime.now());
questionRepository.save(z7);

//Q8
Question z8 = new Question();
z8.setQuiz(savedMlQuiz3);
z8.setQuestionText("Why is feature selection useful?");
z8.setOptionA("It helps reduce unnecessary data");
z8.setOptionB("It replaces training data");
z8.setOptionC("It creates APIs automatically");
z8.setOptionD("It improves CSS styling");
z8.setCorrectAnswer("It helps reduce unnecessary data");
z8.setCreatedAt(LocalDateTime.now());
questionRepository.save(z8);

//Q9
Question z9 = new Question();
z9.setQuiz(savedMlQuiz3);
z9.setQuestionText("What is an outlier in a dataset?");
z9.setOptionA("A value significantly different from others");
z9.setOptionB("A frontend component");
z9.setOptionC("A hidden database");
z9.setOptionD("A server request");
z9.setCorrectAnswer("A value significantly different from others");
z9.setCreatedAt(LocalDateTime.now());
questionRepository.save(z9);

//Q10
Question z10 = new Question();
z10.setQuiz(savedMlQuiz3);
z10.setQuestionText("Why should preprocessing be applied before training a model?");
z10.setOptionA("To help the model learn from cleaner data");
z10.setOptionB("To remove Machine Learning libraries");
z10.setOptionC("To replace Python");
z10.setOptionD("To generate HTML automatically");
z10.setCorrectAnswer("To help the model learn from cleaner data");
z10.setCreatedAt(LocalDateTime.now());
questionRepository.save(z10);

//=======================
//Machine Learning Quiz 4 - Model Training & Evaluation
//=======================

Quiz mlQuiz4 = new Quiz();
mlQuiz4.setTitle("Model Training & Evaluation");
mlQuiz4.setLevel("Intermediate");
mlQuiz4.setPath("Machine Learning");
mlQuiz4.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz4 = quizRepository.save(mlQuiz4);

//Q1
Question p1 = new Question();
p1.setQuiz(savedMlQuiz4);
p1.setQuestionText("What is the purpose of training a Machine Learning model?");
p1.setOptionA("To help the model learn patterns from data");
p1.setOptionB("To create frontend pages");
p1.setOptionC("To replace databases");
p1.setOptionD("To improve internet speed");
p1.setCorrectAnswer("To help the model learn patterns from data");
p1.setCreatedAt(LocalDateTime.now());
questionRepository.save(p1);

//Q2
Question p2 = new Question();
p2.setQuiz(savedMlQuiz4);
p2.setQuestionText("Which dataset is used to evaluate a trained model?");
p2.setOptionA("Training set");
p2.setOptionB("Testing set");
p2.setOptionC("CSS dataset");
p2.setOptionD("Hidden set");
p2.setCorrectAnswer("Testing set");
p2.setCreatedAt(LocalDateTime.now());
questionRepository.save(p2);

//Q3
Question p3 = new Question();
p3.setQuiz(savedMlQuiz4);
p3.setQuestionText("What does high accuracy usually indicate?");
p3.setOptionA("The model predictions are often correct");
p3.setOptionB("The frontend is responsive");
p3.setOptionC("The database is secure");
p3.setOptionD("The server is offline");
p3.setCorrectAnswer("The model predictions are often correct");
p3.setCreatedAt(LocalDateTime.now());
questionRepository.save(p3);

//Q4
Question p4 = new Question();
p4.setQuiz(savedMlQuiz4);
p4.setQuestionText("What is underfitting in Machine Learning?");
p4.setOptionA("When the model fails to learn important patterns");
p4.setOptionB("When the model memorizes all training data");
p4.setOptionC("When preprocessing is skipped");
p4.setOptionD("When the server crashes");
p4.setCorrectAnswer("When the model fails to learn important patterns");
p4.setCreatedAt(LocalDateTime.now());
questionRepository.save(p4);

//Q5
Question p5 = new Question();
p5.setQuiz(savedMlQuiz4);
p5.setQuestionText("Which metric is commonly used for regression models?");
p5.setOptionA("Mean Squared Error");
p5.setOptionB("Flexbox");
p5.setOptionC("Accuracy only");
p5.setOptionD("Dropout");
p5.setCorrectAnswer("Mean Squared Error");
p5.setCreatedAt(LocalDateTime.now());
questionRepository.save(p5);

//Q6
Question p6 = new Question();
p6.setQuiz(savedMlQuiz4);
p6.setQuestionText("Why is validation data important during training?");
p6.setOptionA("It helps monitor model performance");
p6.setOptionB("It styles charts automatically");
p6.setOptionC("It removes datasets");
p6.setOptionD("It creates APIs");
p6.setCorrectAnswer("It helps monitor model performance");
p6.setCreatedAt(LocalDateTime.now());
questionRepository.save(p6);

//Q7
Question p7 = new Question();
p7.setQuiz(savedMlQuiz4);
p7.setQuestionText("What may happen if a model overfits?");
p7.setOptionA("It performs poorly on new data");
p7.setOptionB("It deletes the dataset");
p7.setOptionC("It improves every prediction");
p7.setOptionD("It replaces preprocessing");
p7.setCorrectAnswer("It performs poorly on new data");
p7.setCreatedAt(LocalDateTime.now());
questionRepository.save(p7);

//Q8
Question p8 = new Question();
p8.setQuiz(savedMlQuiz4);
p8.setQuestionText("Which library is commonly used to train ML models in Python?");
p8.setOptionA("Scikit-learn");
p8.setOptionB("Bootstrap");
p8.setOptionC("Tailwind CSS");
p8.setOptionD("Spring Boot");
p8.setCorrectAnswer("Scikit-learn");
p8.setCreatedAt(LocalDateTime.now());
questionRepository.save(p8);

//Q9
Question p9 = new Question();
p9.setQuiz(savedMlQuiz4);
p9.setQuestionText("Why should datasets be shuffled before training?");
p9.setOptionA("To reduce biased learning patterns");
p9.setOptionB("To improve HTML rendering");
p9.setOptionC("To replace validation");
p9.setOptionD("To speed up CSS loading");
p9.setCorrectAnswer("To reduce biased learning patterns");
p9.setCreatedAt(LocalDateTime.now());
questionRepository.save(p9);

//Q10
Question p10 = new Question();
p10.setQuiz(savedMlQuiz4);
p10.setQuestionText("What is the main purpose of evaluating a model?");
p10.setOptionA("To measure how well it performs");
p10.setOptionB("To create frontend components");
p10.setOptionC("To replace Python libraries");
p10.setOptionD("To secure databases");
p10.setCorrectAnswer("To measure how well it performs");
p10.setCreatedAt(LocalDateTime.now());
questionRepository.save(p10);

//=======================
//Machine Learning Quiz 5 - Neural Networks & Deep Learning
//=======================

Quiz mlQuiz5 = new Quiz();
mlQuiz5.setTitle("Neural Networks & Deep Learning");
mlQuiz5.setLevel("Intermediate");
mlQuiz5.setPath("Machine Learning");
mlQuiz5.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz5 = quizRepository.save(mlQuiz5);

//Q1
Question w1 = new Question();
w1.setQuiz(savedMlQuiz5);
w1.setQuestionText("What is the main idea behind neural networks?");
w1.setOptionA("Simulating how the human brain processes information");
w1.setOptionB("Replacing databases completely");
w1.setOptionC("Designing web pages");
w1.setOptionD("Creating APIs automatically");
w1.setCorrectAnswer("Simulating how the human brain processes information");
w1.setCreatedAt(LocalDateTime.now());
questionRepository.save(w1);

//Q2
Question w2 = new Question();
w2.setQuiz(savedMlQuiz5);
w2.setQuestionText("What is a neuron in a neural network?");
w2.setOptionA("A database table");
w2.setOptionB("A processing unit that receives and passes data");
w2.setOptionC("A frontend component");
w2.setOptionD("A Python package");
w2.setCorrectAnswer("A processing unit that receives and passes data");
w2.setCreatedAt(LocalDateTime.now());
questionRepository.save(w2);

//Q3
Question w3 = new Question();
w3.setQuiz(savedMlQuiz5);
w3.setQuestionText("Which library is commonly used for deep learning?");
w3.setOptionA("TensorFlow");
w3.setOptionB("Bootstrap");
w3.setOptionC("Laravel");
w3.setOptionD("Tailwind");
w3.setCorrectAnswer("TensorFlow");
w3.setCreatedAt(LocalDateTime.now());
questionRepository.save(w3);

//Q4
Question w4 = new Question();
w4.setQuiz(savedMlQuiz5);
w4.setQuestionText("What is the purpose of activation functions in neural networks?");
w4.setOptionA("To add non-linearity to the model");
w4.setOptionB("To style dashboards");
w4.setOptionC("To replace datasets");
w4.setOptionD("To connect APIs");
w4.setCorrectAnswer("To add non-linearity to the model");
w4.setCreatedAt(LocalDateTime.now());
questionRepository.save(w4);

//Q5
Question w5 = new Question();
w5.setQuiz(savedMlQuiz5);
w5.setQuestionText("What does an input layer do in a neural network?");
w5.setOptionA("Receives the initial data");
w5.setOptionB("Generates frontend pages");
w5.setOptionC("Stores passwords");
w5.setOptionD("Deletes missing values");
w5.setCorrectAnswer("Receives the initial data");
w5.setCreatedAt(LocalDateTime.now());
questionRepository.save(w5);

//Q6
Question w6 = new Question();
w6.setQuiz(savedMlQuiz5);
w6.setQuestionText("Why are GPUs useful in deep learning?");
w6.setOptionA("They speed up heavy computations");
w6.setOptionB("They improve CSS rendering");
w6.setOptionC("They replace Python");
w6.setOptionD("They manage APIs");
w6.setCorrectAnswer("They speed up heavy computations");
w6.setCreatedAt(LocalDateTime.now());
questionRepository.save(w6);

//Q7
Question w7 = new Question();
w7.setQuiz(savedMlQuiz5);
w7.setQuestionText("What is the role of hidden layers in neural networks?");
w7.setOptionA("Learning complex patterns from data");
w7.setOptionB("Creating database schemas");
w7.setOptionC("Handling HTTP requests");
w7.setOptionD("Improving internet speed");
w7.setCorrectAnswer("Learning complex patterns from data");
w7.setCreatedAt(LocalDateTime.now());
questionRepository.save(w7);

//Q8
Question w8 = new Question();
w8.setQuiz(savedMlQuiz5);
w8.setQuestionText("What may happen if a neural network is too complex for the dataset?");
w8.setOptionA("The model may overfit");
w8.setOptionB("The frontend becomes responsive");
w8.setOptionC("The API becomes public");
w8.setOptionD("The dataset disappears");
w8.setCorrectAnswer("The model may overfit");
w8.setCreatedAt(LocalDateTime.now());
questionRepository.save(w8);

//Q9
Question w9 = new Question();
w9.setQuiz(savedMlQuiz5);
w9.setQuestionText("Which deep learning task is commonly used in image recognition?");
w9.setOptionA("Classification");
w9.setOptionB("Flexbox");
w9.setOptionC("Routing");
w9.setOptionD("Pagination");
w9.setCorrectAnswer("Classification");
w9.setCreatedAt(LocalDateTime.now());
questionRepository.save(w9);

//Q10
Question w10 = new Question();
w10.setQuiz(savedMlQuiz5);
w10.setQuestionText("Why is large amounts of data often important in deep learning?");
w10.setOptionA("To help models learn better patterns");
w10.setOptionB("To replace preprocessing");
w10.setOptionC("To create HTML automatically");
w10.setOptionD("To reduce model accuracy");
w10.setCorrectAnswer("To help models learn better patterns");
w10.setCreatedAt(LocalDateTime.now());
questionRepository.save(w10);

//=======================
//Machine Learning Quiz 6 - Model Deployment & AI Ethics
//=======================

Quiz mlQuiz6 = new Quiz();
mlQuiz6.setTitle("Model Deployment & AI Ethics");
mlQuiz6.setLevel("Advanced");
mlQuiz6.setPath("Machine Learning");
mlQuiz6.setCreatedAt(LocalDateTime.now());

Quiz savedMlQuiz6 = quizRepository.save(mlQuiz6);

//Q1
Question x1 = new Question();
x1.setQuiz(savedMlQuiz6);
x1.setQuestionText("What is model deployment in Machine Learning?");
x1.setOptionA("Using a trained model in a real application");
x1.setOptionB("Designing frontend pages");
x1.setOptionC("Creating datasets manually");
x1.setOptionD("Replacing APIs");
x1.setCorrectAnswer("Using a trained model in a real application");
x1.setCreatedAt(LocalDateTime.now());
questionRepository.save(x1);

//Q2
Question x2 = new Question();
x2.setQuiz(savedMlQuiz6);
x2.setQuestionText("Why is monitoring deployed models important?");
x2.setOptionA("To detect performance changes over time");
x2.setOptionB("To improve CSS styling");
x2.setOptionC("To replace preprocessing");
x2.setOptionD("To generate databases");
x2.setCorrectAnswer("To detect performance changes over time");
x2.setCreatedAt(LocalDateTime.now());
questionRepository.save(x2);

//Q3
Question x3 = new Question();
x3.setQuiz(savedMlQuiz6);
x3.setQuestionText("What is data drift in Machine Learning?");
x3.setOptionA("Changes in input data patterns over time");
x3.setOptionB("A frontend rendering issue");
x3.setOptionC("A database connection error");
x3.setOptionD("A Python syntax feature");
x3.setCorrectAnswer("Changes in input data patterns over time");
x3.setCreatedAt(LocalDateTime.now());
questionRepository.save(x3);

//Q4
Question x4 = new Question();
x4.setQuiz(savedMlQuiz6);
x4.setQuestionText("Why can biased training data be dangerous?");
x4.setOptionA("It may lead to unfair AI decisions");
x4.setOptionB("It improves model fairness");
x4.setOptionC("It reduces training time only");
x4.setOptionD("It automatically fixes outliers");
x4.setCorrectAnswer("It may lead to unfair AI decisions");
x4.setCreatedAt(LocalDateTime.now());
questionRepository.save(x4);

//Q5
Question x5 = new Question();
x5.setQuiz(savedMlQuiz6);
x5.setQuestionText("Which technology is commonly used to expose ML models through APIs?");
x5.setOptionA("Flask");
x5.setOptionB("Photoshop");
x5.setOptionC("Bootstrap");
x5.setOptionD("Tailwind");
x5.setCorrectAnswer("Flask");
x5.setCreatedAt(LocalDateTime.now());
questionRepository.save(x5);

//Q6
Question x6 = new Question();
x6.setQuiz(savedMlQuiz6);
x6.setQuestionText("What is one challenge of deploying large deep learning models?");
x6.setOptionA("High computational requirements");
x6.setOptionB("Too much HTML rendering");
x6.setOptionC("Lack of CSS support");
x6.setOptionD("Difficulty creating buttons");
x6.setCorrectAnswer("High computational requirements");
x6.setCreatedAt(LocalDateTime.now());
questionRepository.save(x6);

//Q7
Question x7 = new Question();
x7.setQuiz(savedMlQuiz6);
x7.setQuestionText("Why is explainability important in AI systems?");
x7.setOptionA("To help users understand model decisions");
x7.setOptionB("To replace datasets");
x7.setOptionC("To increase internet speed");
x7.setOptionD("To reduce frontend complexity");
x7.setCorrectAnswer("To help users understand model decisions");
x7.setCreatedAt(LocalDateTime.now());
questionRepository.save(x7);

//Q8
Question x8 = new Question();
x8.setQuiz(savedMlQuiz6);
x8.setQuestionText("What may happen if deployed models are never updated?");
x8.setOptionA("Their performance may decline over time");
x8.setOptionB("They automatically improve forever");
x8.setOptionC("The frontend stops existing");
x8.setOptionD("The database becomes faster");
x8.setCorrectAnswer("Their performance may decline over time");
x8.setCreatedAt(LocalDateTime.now());
questionRepository.save(x8);

//Q9
Question x9 = new Question();
x9.setQuiz(savedMlQuiz6);
x9.setQuestionText("Which practice helps improve AI fairness?");
x9.setOptionA("Using diverse and balanced datasets");
x9.setOptionB("Ignoring preprocessing");
x9.setOptionC("Removing evaluation metrics");
x9.setOptionD("Training on random noise");
x9.setCorrectAnswer("Using diverse and balanced datasets");
x9.setCreatedAt(LocalDateTime.now());
questionRepository.save(x9);

//Q10
Question x10 = new Question();
x10.setQuiz(savedMlQuiz6);
x10.setQuestionText("Why is scalability important when deploying ML systems?");
x10.setOptionA("To handle increasing numbers of users or requests");
x10.setOptionB("To improve font sizes");
x10.setOptionC("To replace training datasets");
x10.setOptionD("To reduce model accuracy");
x10.setCorrectAnswer("To handle increasing numbers of users or requests");
x10.setCreatedAt(LocalDateTime.now());
questionRepository.save(x10);


    }
    
    
}