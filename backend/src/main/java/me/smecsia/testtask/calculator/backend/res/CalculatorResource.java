package me.smecsia.testtask.calculator.backend.res;

import me.smecsia.testtask.calculator.common.components.BasicResource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Ilya Sadykov
 *         Date: 17.12.12
 *         Time: 9:53
 */
@Path("/calc")
@Produces("application/json")
public class CalculatorResource extends BasicResource {

    @POST
    @Path("/syntaxtree")
    public String syntaxTree(@FormParam("json") String json) {
        return null;
    }
}
