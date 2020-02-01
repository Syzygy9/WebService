package ru.webclassfields.dao;


import ru.webclassfields.model.Customer;

import javax.ws.rs.core.Response;

public interface CustomerDAO {

    public Response getCustomer(int id);

    public Response createCustomer(Customer customer);

    public Response updateCustomer(Customer customer);

    public Response deleteCustomer(int id);

    public Response getAllCustomers();

}
