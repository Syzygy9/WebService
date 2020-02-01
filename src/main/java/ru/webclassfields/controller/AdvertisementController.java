package ru.webclassfields.controller;

import ru.webclassfields.dao.UserDAO;
import ru.webclassfields.dao.impl.UserDAOImpl;
import ru.webclassfields.model.User;
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
    @Path("/create/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createAdvertisement(@PathParam("email") String email, Advertisement advertisement) {

        UserDAO userDAO =  new UserDAOImpl();

        User user = userDAO.getIdUserByEmail(email);

        AdvertisementBusiness advertisementBusiness = new AdvertisementBusiness();
        Long adsId = advertisementBusiness.createAdvertisement(user, advertisement);

        return Response.status(200).entity("Advertisement with id: " + adsId + " для user id " +
                user.getUserId() + " was created").build();
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
