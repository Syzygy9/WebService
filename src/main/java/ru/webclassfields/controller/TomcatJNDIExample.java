package ru.webclassfields.controller;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import ru.webclassfields.dao.CustomerDAO;
import ru.webclassfields.dao.impl.CustomerDAOImpl;
import ru.webclassfields.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("tomcat")
public class TomcatJNDIExample {
    private Logger logger = Logger.getLogger(TomcatJNDIExample.class);

    @Path("status")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getStatus() {
        logger.info("Inside getStatus()...");
        return "TomcatJNDIExample Status is OK...";
    }

    @GET
    @Path("getcustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@DefaultValue("0") @QueryParam("id") int id) {

        CustomerDAO daoImpl = new CustomerDAOImpl();
        logger.info("Inside getCustomer...");

        Response resp = daoImpl.getCustomer(id);
        return resp;
    }

    @POST
    @Path("addcustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {

        CustomerDAO daoImpl = new CustomerDAOImpl();
        logger.info("Inside createCustomer...");

        Response resp = daoImpl.createCustomer(customer);
        return resp;
    }

    @PUT
    @Path("updatecustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer customer) {

        CustomerDAO daoImpl = new CustomerDAOImpl();
        logger.info("Inside createCustomer...");

        Response resp = daoImpl.updateCustomer(customer);
        return resp;
    }

    @DELETE
    @Path("deletecustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@DefaultValue("0") @QueryParam("id") int id) {

        CustomerDAO daoImpl = new CustomerDAOImpl();
        logger.info("Inside deleteCustomer...");

        Response resp = daoImpl.deleteCustomer(id);
        return resp;
    }

    @GET
    @Path("showallcustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllCustomers() throws JsonGenerationException,
            JsonMappingException, IOException {

        CustomerDAO daoImpl = new CustomerDAOImpl();
        logger.info("Inside showAllCustomers...");
        Response resp = daoImpl.getAllCustomers();

        return resp;
    }

}
