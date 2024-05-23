package io.shubham.service_1;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.brave.bridge.BraveTracer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//import org.apache.camel.micrometer.MicrometerObservationTracer;

@Component
public class MyCamelRoute extends RouteBuilder {
    @Autowired
    RestTemplate restTemplate;



    @Override
    public void configure() throws Exception{
        restConfiguration().component("servlet");
//        restConfiguration().component("servlet").port("9999").host("localhost").bindingMode(RestBindingMode.json);


        from("timer://test-rest-api?period=60000")
                .log("REST API CALLING....")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8888/api/2")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Hello from processor");
                        restTemplate.getForObject("http://localhost:8888/api/3", Boolean.class);
                    }
                })
                ;


        // WORKING
//        from("timer:first-timer")
//                .to("log:first-timer");
    }
}
