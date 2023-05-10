package eos.lkpspring.config;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.media.Schema;

@Configuration
public class SwaggerConfig {
  static {
    var schema = new Schema<LocalTime>();
    schema.example(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    SpringDocUtils.getConfig().replaceWithSchema(LocalTime.class, schema);
  }
}
