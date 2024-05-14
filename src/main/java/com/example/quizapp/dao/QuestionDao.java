package com.example.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Question;

import java.util.List;



//In Spring Boot, @Repository is an annotation used to indicate that a class is a Data Access Object (DAO). It is typically applied to classes that are responsible for interacting with the database or any other form of data storage.
//all this things like fetching data from db is done by data jpa
@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

    List<Question> findByCategory(String category); //data jpa is smart enough, because there is one column in our table by category
    
    @Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);
}
