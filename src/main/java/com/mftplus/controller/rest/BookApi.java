package com.mftplus.controller.rest;

import com.google.gson.Gson;
import com.mftplus.model.bl.BookBl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooks() throws Exception {
        return new Gson().toJson(BookBl.getInstance().findAll());
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addBook(Book book) {
//
//    }
}
