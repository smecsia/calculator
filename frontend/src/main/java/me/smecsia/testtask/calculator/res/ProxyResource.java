package me.smecsia.testtask.calculator.res;

import com.sun.jersey.api.client.Client;
import me.smecsia.testtask.calculator.client.Expression;
import me.smecsia.testtask.calculator.client.Localhost;
import me.smecsia.testtask.calculator.client.Result;
import me.smecsia.testtask.calculator.common.components.BasicResource;
import org.apache.commons.lang.StringUtils;

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

    @QueryParam("url")
    String url;

    @POST
    @Path("/perform")
    public Result calc(Expression expression) {
        Result res = new Result();
        try {
            Client client = Client.create();
            URI uri = (StringUtils.isEmpty(url)) ? Localhost.BASE_URI : URI.create(url);
            return Localhost.calc(client, uri).bySyntaxtree().postXmlAsResult(expression);
        } catch (Exception e) {
            log(e);
            res.setMessage(e.getMessage());
            res.setSuccess(false);
        }
        return res;
    }

}
