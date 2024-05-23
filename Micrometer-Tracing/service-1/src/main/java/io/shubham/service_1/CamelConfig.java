//package io.shubham.service_1;
//
//import org.apache.camel.CamelContext;
//import org.apache.camel.opentracing.OpenTracingTracer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import brave.Tracing;
//
//@Configuration
//public class CamelConfig {
//
//    @Bean
//    public OpenTracingTracer openTracingTracer(Tracing tracing) {
//        OpenTracingTracer openTracingTracer = new OpenTracingTracer();
//        openTracingTracer(tracing);
////        openTracingTracer.setTracing(tracing);
//        return openTracingTracer;
//    }
//
//    @Bean
//    public void configureCamelContext(CamelContext camelContext, OpenTracingTracer openTracingTracer) {
////        camelContext.addTracer(openTracingTracer);
//    }
//}
