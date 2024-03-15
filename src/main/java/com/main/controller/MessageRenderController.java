package com.main.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRenderController 
{
	 @GetMapping("/wish/{name}")
     public ResponseEntity<String> showWishMessage(@PathVariable("name") String name)
     {
    	 LocalDateTime ldt = LocalDateTime.now();
    	 int hour = ldt.getHour();
    	 String msg = null;
    	 if(hour<12)
    	 {
    		 msg = "Good Morning : "+name;
    	 }
    	 else if(hour<16)
    	 {
    		 msg = "Good Afternoon : "+name;
    	 }
    	 else if(hour<18)
    	 {
    		 msg = "Good Evening : "+name;
    	 }
    	 else
    		 msg = "Good Night : "+name;
    	 
    	 return new ResponseEntity<String>(msg, HttpStatus.OK);
     }
}
