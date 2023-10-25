package com.distribuida.trabalho1;


import com.distribuida.trabalho1.tests.ClienteHttp;
import com.distribuida.trabalho1.tests.WorkerCall;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ClienteHttp.main(args);
		WorkerCall.main(args);

	}
}
