package com.gft.inditext.pricing_server.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${bezkoder.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI openAPI() {
        final Server server = new Server();
        server.setUrl(devUrl);
        server.setDescription("OpenAPI Documentation");

        final Info info = new Info()
                .title("INDITEX Product Pricing API")
                .version("1.0")
                .description("API to get the applicable price for a product in a given timestamp");
        return new OpenAPI().info(info).servers(List.of(server));
    }

}
