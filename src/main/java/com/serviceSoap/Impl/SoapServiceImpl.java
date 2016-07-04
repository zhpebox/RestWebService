package com.serviceSoap.Impl;

import javax.jws.WebService;

import com.bean.Book;
import com.serviceSoap.ISoapService;

@WebService
public class SoapServiceImpl implements ISoapService{

	public SoapServiceImpl(){
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
	
	@Override
	public String getBook() {
		Book book = new Book();
		book.setId("1");
		book.setName("we");
		return book.toString();
	}

}
