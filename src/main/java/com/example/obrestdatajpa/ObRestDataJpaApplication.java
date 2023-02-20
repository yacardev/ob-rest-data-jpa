package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.respositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
@EnableWebMvc
@SpringBootApplication
public class ObRestDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDataJpaApplication.class, args);
		BookRepository repo = context.getBean(BookRepository.class);
		//CRUD
		//crear libro
		Book book = new Book(null,"Yacardev","MLujan",400,31.55, LocalDate.of(2020,10,3),true);
		Book book1 = new Book(null,"Yacardev1","MLujan1",34,30.0, LocalDate.of(2021,11,4),true);
		repo.save(book);
		repo.save(book1);

		//recuperar
		System.out.println("Respository: "+repo.findAll().size());


		//borrar
	}



}
