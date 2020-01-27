package ru.webclassfields.service;

import ru.webclassfields.business.AdvertisementBusiness;
import ru.webclassfields.dao.CustomerDAO;
import ru.webclassfields.dao.impl.CustomerDAOImpl;
import ru.webclassfields.model.Advertisement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value="/advertisements")
public class AdvertisementController {

    @GET
    @Path("/testme")
    public Response testme () {
        return Response.status(200).entity("Hi There").build();
    }

    @GET
    @Path("/{ad_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertisement(@PathParam("ad_id") Long id) {

        AdvertisementBusiness advertisementBusiness = new AdvertisementBusiness ();
        Advertisement advertisement = advertisementBusiness.getAdvertidementById(id);
        return Response.status(200).entity(advertisement).build();


    }
}
