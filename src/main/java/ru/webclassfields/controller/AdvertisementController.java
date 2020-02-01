package ru.webclassfields.controller;

import ru.webclassfields.service.AdvertisementBusiness;
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

    @POST
    @Path("/create/{user_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createAdvertisement(@PathParam("user_id") Long userId, Advertisement advertisement) {
        return Response.status(200).entity("Advertisement with id: " + advertisement.getAdId() + " and user id " +
                userId+ " was created").build();
    }

    @PUT
    @Path("/change/{ad_id}/{user_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeAdvertisement(@PathParam("ad_id") Long adId,
                                        @PathParam("user_id") Long userId,
                                        Advertisement advertisement) {
        return Response.status(200).entity(advertisement).build();
    }

}
