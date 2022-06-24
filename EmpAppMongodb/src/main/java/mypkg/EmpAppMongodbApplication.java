package mypkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpAppMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpAppMongodbApplication.class, args);
		System.out.println("Hi");
	}

}
