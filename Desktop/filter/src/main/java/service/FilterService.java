package service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import pojo.FilterRequestObject;
import pojo.Jeans;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by shiva.b on 08/11/16.
 */
@Path("/filter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilterService {
    private JestClient jestClient;

    public FilterService(JestClient jestClient) {
        this.jestClient = jestClient;
    }

    @POST
    @Path("/search")
    public List<Jeans> filtering(FilterRequestObject filterRequestObject) {

        return null;
    }

    @POST
    @Path("/add")
    public void addItem(Jeans jeans) {
        Index index = new Index.Builder(jeans).index("articles").type("jeans").id(jeans.getId()).build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
