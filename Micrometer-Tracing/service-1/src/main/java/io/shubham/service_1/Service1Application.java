package io.shubham.service_1;

import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@SpringBootApplication
//@CamelOpenTracing
@EnableAsync
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor(){
		return new ThreadPoolTaskExecutor()
		{
			@Override
			protected ExecutorService initializeExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler){
				ExecutorService executorService = super.initializeExecutor(threadFactory, rejectedExecutionHandler);
				return ContextExecutorService.wrap(executorService, ContextSnapshot::captureAll);
			}

			@Override
			public void execute(Runnable task){
				super.execute(ContextSnapshot.captureAll().wrap(task));
			}
			@Override
			public Future<?> submit(Runnable task){
				return super.submit(ContextSnapshot.captureAll().wrap(task));
			}
			@Override
			public <T> Future<T> submit(Callable<T> task){
				return super.submit(ContextSnapshot.captureAll().wrap(task));
			}
		};
	}


}
