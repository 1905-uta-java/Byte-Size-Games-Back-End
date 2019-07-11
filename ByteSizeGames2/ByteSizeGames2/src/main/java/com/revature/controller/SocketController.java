package com.revature.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
@RequestMapping("/socket")
public class SocketController {
	
	HashMap<Integer, String>questions = new HashMap();

	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public HashMap<Integer, String> getQuestion() {
	StringBuffer content = new StringBuffer();
	Integer num = 0;
	try {
	for(Integer i = 0; i < 6; i++) {
	URL url = new URL("https://opentdb.com/api.php?amount=1&type=multiple");
	HttpURLConnection con = (HttpURLConnection) url.openConnection();
	BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
	String input;
	
	input = in.readLine();
	questions.put(num, input);
	num++;
	System.out.println(num);
	System.out.println(questions.get(num - 1));
	content.append(input);
	System.out.println("Content: " + content);
	in.close();
	con.disconnect();
	}
	System.out.println("Question 3: " + questions.get(3));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return questions;
	}
	
	@GetMapping("/{getAll}")
	public HashMap<Integer, String>sendBackAll(){
		return questions;
	}

}
