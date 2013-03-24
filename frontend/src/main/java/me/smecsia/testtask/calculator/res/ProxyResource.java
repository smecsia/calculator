package me.smecsia.testtask.calculator.res;

import com.sun.jersey.api.client.Client;
import me.smecsia.testtask.calculator.client.Expression;
import me.smecsia.testtask.calculator.client.Localhost;
import me.smecsia.testtask.calculator.client.Result;
import me.smecsia.testtask.calculator.common.components.BasicResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;

/**
 * @author Ilya Sadykov
 */
@Path("/calc")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ProxyResource extends BasicResource {

    @POST
    @Path("/perform")
    public Result calc(@QueryParam("url") String url, Expression expression) {
        Client client = Client.create();
        return Localhost.calc(client, URI.create(url)).bySyntaxtree().postXmlAsResult(expression);
    }

}
