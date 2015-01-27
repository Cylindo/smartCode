package com.OrderApp.Resources;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.OrderApp.DAOimp.CustomerImplementation;
import com.OrderApp.Models.Customer;



@Path(value = "/RESTCustomer")
public class CustomerResource {

	CustomerImplementation custDAO = new CustomerImplementation();
	java.net.URI location = null;
	
	 	@POST
		@Path(value = "/login")
	 	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response logInCustomer(@FormParam("userName") String name,
									  @FormParam("password") String password)
											  		throws URISyntaxException{ 
	 		
//	 		Customer cust = custDAO.getCustomer(name);
	
//	 		if(password == cust.getPassword()){
	 		
	 			location = new java.net.URI("http://localhost:8080/RESTfulKnockout/items.jsp");
	 			return Response.seeOther(location).build();
//	 		}
//	 		else{
//	 			location = new java.net.URI("http://localhost:8080/RESTfulKnockout/Login.jsp");
//	 			return Response.seeOther(location).build();	
//	 		}
		}
	 	
	 	@POST
	 	@Path(value = "/register")
		public String login(@FormParam("name") String name, 
				@FormParam("surname") String surname,
				@FormParam("gender") String gender,
				@FormParam("address") String address,
				@FormParam("phoneNo") String phoneNo,
				@FormParam("password") String password){
						
	 		Customer cust = new Customer();
	 		cust.setName(name);
	 		cust.setSurname(surname);
	 		cust.setGender(gender);
	 		cust.setAdress(address);
	 		cust.setTelephone(phoneNo);
	 		cust.setPassword(password);
	 		
	 		custDAO.addCustomer(cust);
	 		
	 		
	 		return "Customer Succesfully registered....!";  }
	 	
}
