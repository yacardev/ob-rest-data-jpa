package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.entities.Book;

public class BookService {

    public double calculatePriceBook(Book book){
        double price = book.getPrice();
        if(book.getPages()>300){
            price += 5;
        }
        price += 2.99;
        return price;
    }
}
