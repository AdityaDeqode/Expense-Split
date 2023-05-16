package com.example.streamAPI;

import com.example.streamAPI.utility.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiApplication {

//	@Autowired
//	static
//	UserActivity userActivity;

	public static void main(String[] args) {
		SpringApplication.run(StreamApiApplication.class, args);
		System.out.println("Start application with adding some users through post api");

//		UserActivity userActivity = SpringApplication
//				.run(StreamApiApplication.class, args)
//				.getBean(UserActivity.class);
//		userActivity.addUsers();


	}

}
