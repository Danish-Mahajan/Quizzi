package com.example.quizapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;






@RestController
@RequestMapping("Question")
public class QuestionController {
    
    @Autowired //we dont need to do new QuestionService
    QuestionService questionService;
    

    //to fetch all the question in our
    @GetMapping("allQuestion")    
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    

    //fetch question by category
    @GetMapping("category/{category}")
    public ResponseEntity <List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getAllQuestionsByCategory(category);
    }

    //add a question
    //from client side we recieve in json format, spring will convert data from json format to our Class format
    @PostMapping("add")    
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
    

}
