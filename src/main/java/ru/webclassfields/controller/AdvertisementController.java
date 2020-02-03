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

        AdvertisementBusiness advertisementBusiness = AdvertisementBusiness.getInstance();
        Advertisement advertisement = advertisementBusiness.getAdvertisementById(id);
        return Response.status(200).entity(advertisement).build();

    }

    @POST
    @Path("/create/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createAdvertisement(@PathParam("email") String email, Advertisement advertisement) {

        UserDAO userDAO =  new UserDAOImpl();
        User user = userDAO.getIdUserByEmail(email);

        AdvertisementBusiness advertisementBusiness = AdvertisementBusiness.getInstance();
        Long adsId = advertisementBusiness.createAdvertisement(user, advertisement);

        return Response.status(200).entity("Advertisement with id: " + adsId + " для user id " +
                user.getUserId() + " was created").build();
    }

    @PUT
    @Path("/change/{ad_id}/{e_mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response changeAdvertisement(@PathParam("ad_id") Long adId,
                                        @PathParam("e_mail") String email, Advertisement advertisement ) {

        UserDAO userDAO =  new UserDAOImpl();
        User user = userDAO.getIdUserByEmail(email);

        AdvertisementBusiness advertisementBusiness = AdvertisementBusiness.getInstance();
        advertisementBusiness.changeAdvertisement(user, advertisement);

        return Response.status(200).build();


            }


    @DELETE
    @Path("/{ad_id}/{e_mail}")
    @Produces(MediaType.TEXT_PLAIN)
        public Response deleteAdvertisementByID (@PathParam("ad_id") Long adId,
                                                 @PathParam("e_mail") String email) {

        UserDAO userDAO =  new UserDAOImpl();
        User user = userDAO.getIdUserByEmail(email);

        AdvertisementBusiness advertisementBusiness = AdvertisementBusiness.getInstance();
        int detetedRows = advertisementBusiness.deleteAdvertisementById(user.getUserId(), adId);
        return Response.status(200).entity(detetedRows + " of advertisements were deleted").build();

    }

}
