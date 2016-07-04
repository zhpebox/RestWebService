package com.service.Impl;

import com.bean.Book;
import com.service.BookService;

public class BookServiceImpl implements BookService {

	public BookServiceImpl(){
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	@Override
	public String getBook() {
		Book one = new Book();
		one.setId("002");
		one.setName("java教程");
		return one.toString();
	}

	@Override
	public String getBookById(String id) {
		Book one = new Book();
		one.setId(id);
		one.setName("java教程_"+id);
		return one.toString();
	}


}
