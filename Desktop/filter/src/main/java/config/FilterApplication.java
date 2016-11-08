package config;


import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.indices.CreateIndex;
import service.FilterService;
import service.TestService;

/**
 * Created by shiva.b on 22/08/16 at 7:49 PM.
 */
public class FilterApplication extends Application<FilterConfig>{

    public static void main(String args[]) throws Exception {
        new FilterApplication().run(args);
    }

    public void run(FilterConfig filterConfig, Environment environment) throws Exception {
        TestService testService = new TestService();
        environment.jersey().register(testService);
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        JestClient client = factory.getObject();
        client.execute(new CreateIndex.Builder("articles").build());
        FilterService filterService = new FilterService(client);
        environment.jersey().register(filterService);
    }
}