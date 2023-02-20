package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    void calculateBook() {
        Book book = new Book(1L,"How to meet yourself","Paula",301,-1.2, LocalDate.now(),true);
        BookService bs = new BookService();
        double price = bs.calculatePriceBook(book);
        System.out.println("Price: "+price);
        assertTrue(price > 0);


    }
}