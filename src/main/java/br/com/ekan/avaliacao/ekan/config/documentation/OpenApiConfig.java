package br.com.ekan.avaliacao.ekan.config.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI ekanAPI() {
    return new OpenAPI()
      .info(new Info().title("Ekan API")
        .version("0.0.1")
        .description("Development to Ekan Soluções e Sistemas.")
        .contact(new Contact()
          .name("Pablo Junior")
          .email("pablojuniorgn2@gmail.com")
          .url("https://github.com/pablojg9")));
  }

}
