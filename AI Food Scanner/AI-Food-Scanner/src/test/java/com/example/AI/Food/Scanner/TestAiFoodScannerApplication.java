package com.example.AI.Food.Scanner;

import org.springframework.boot.SpringApplication;

public class TestAiFoodScannerApplication {

	public static void main(String[] args) {
		SpringApplication.from(AiFoodScannerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
