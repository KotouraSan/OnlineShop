package uz.ksan.backend.auth.security.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("JWT project API")
                        .description("Документация API для проекта с JWT аутентификацией")
                        .version("1.0"));
    }
}
