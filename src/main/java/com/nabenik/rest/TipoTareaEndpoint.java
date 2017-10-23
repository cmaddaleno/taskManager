package com.nabenik.rest;

import com.nabenik.facade.CategoriaFacade;
import com.nabenik.facade.TipoTareaFacade;
import com.nabenik.model.Categoria;
import com.nabenik.model.TipoTarea;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

/**
 *
 */
@Stateless
@Path("/tipoTarea")
@Produces("application/json")
@Consumes("application/json")
public class TipoTareaEndpoint {

    
    TipoTareaFacade tipoTareaService;

    @POST
    public Response create(TipoTarea entity) {
        tipoTareaService.create(entity);

        return Response.created(UriBuilder.fromResource(TipoTareaEndpoint.class)
                        .path(String.valueOf(entity.getId())).build()).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Integer id) {
        tipoTareaService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response findById(@PathParam("id") Integer id) {

        TipoTarea entity = tipoTareaService.find(id);
        if (entity == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

    @GET
    public List<TipoTarea> listAll(@QueryParam("start") Integer startPosition,
            @QueryParam("max") Integer maxResult) {
        
        final List<TipoTarea> results = tipoTareaService.findAll();
        return results;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Integer id, TipoTarea entity) {
        if (entity == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        if (id == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            return Response.status(Status.CONFLICT).entity(entity).build();
        }
        if (tipoTareaService.find(id) == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        try {
            entity = tipoTareaService.edit(entity);
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(e.getEntity()).build();
        }

        return Response.ok(entity).build();
    }
}
