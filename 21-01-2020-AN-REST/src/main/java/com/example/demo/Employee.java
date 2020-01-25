package com.example.demo;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/apis")
public class Employee {

	
		@GET
		@Produces("application/json")
		public String[] getAllUsers() {
			String str[]= {"abhijeeth","karthik"};
			return str;
		
	}
		@POST
	    //@Consumes(MediaType.APPLICATION_JSON)
	    @Produces("application/json")
	    public String createCustomer(String name) {
			String str=name+" abdul";
			
			return str;
	    }
		@PUT
		 //@Consumes(MediaType.APPLICATION_JSON)
		 public String createItem(String name) {
			arr.arrli.add(name);
			return " "+name;
		    }
		@DELETE
		public String deleteItem(int id)
		{
			String a = arr.arrli.remove(id);
			return a;
		}
}
