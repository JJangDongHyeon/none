package com.green.boardver3.comment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "Board Ver3"
                , description = "CRUD Board Study"
                , version = "0.0.3"
        )
)
public class SwaggerConfiguration {
}
