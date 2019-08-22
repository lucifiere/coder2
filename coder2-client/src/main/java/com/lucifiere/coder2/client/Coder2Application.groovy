package com.lucifiere.coder2.client

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = "com.lucifiere.coder2")
class Coder2Application {

	static void main(String[] args) {
		SpringApplication.run(Coder2Application, args)
	}

}
