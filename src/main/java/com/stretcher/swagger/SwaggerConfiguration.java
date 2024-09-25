package com.stretcher.swagger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI defineOpenApi() {
		Server server = new Server();
		server.setUrl("https://stretcherapi.onrender.com/");
		server.setDescription("Development");

		Contact myContact = new Contact();
		myContact.setName("Oscar Loro");
		myContact.setEmail("oscarlh1997@gmail.com");

		Info information = new Info().title("Stretcher API").version("1.0")
				.description("This API exposes endpoints to manage stretcher prices.").contact(myContact);
		return new OpenAPI().info(information).servers(List.of(server));
	}
}