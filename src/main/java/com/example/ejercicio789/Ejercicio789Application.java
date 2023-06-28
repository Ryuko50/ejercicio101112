package com.example.ejercicio789;

import com.example.ejercicio789.model.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@OpenAPIDefinition
public class Ejercicio789Application {

	public static void main(String[] args) {
		//SpringApplication.run(Ejercicio456Application.class, args);
		ApplicationContext context = SpringApplication.run(Ejercicio789Application.class,args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(1L,"Naga","Razer");

		laptopRepository.save(laptop1);
	}



}
