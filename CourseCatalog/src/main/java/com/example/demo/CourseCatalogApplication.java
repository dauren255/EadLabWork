package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.service"})
public class CourseCatalogApplication {


	@Bean
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);

//		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//
//		credentialsProvider.setCredentials(AuthScope.ANY,
//				new UsernamePasswordCredentials("rest-client", "p@ssword"));
//
//		HttpClient client = HttpClientBuilder
//				.create()
//				.setDefaultCredentialsProvider(credentialsProvider)
//				.build();
//
//		requestFactory.setHttpClient(client);

		return new RestTemplate(requestFactory);
	}
		public static void main(String[] args) {
		SpringApplication.run(CourseCatalogApplication.class, args);
	}

}
