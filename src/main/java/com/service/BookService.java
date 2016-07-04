package com.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.Book;

@WebService
@Path("/BookSer")
public interface BookService {

	@GET
	@Path("/getBook")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBook();
	
	@GET
	@Path("/getBook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBookById(@PathParam("id")String id);
}
