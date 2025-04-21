package co.com.asuarezr.corsServerConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsServerConfiguration {

  @Value("#{'${cors.allowedOrigins}'.split(',')}")
  private List<String> allowedOrigins;

  @Value("#{'${cors.allowedMethods}'.split(',')}")
  private List<String> allowedMethods;

  @Value("#{'${cors.allowedHeaders}'.split(',')}")
  private List<String> allowedHeaders;

  private List<String> removeWhiteSpace(List<String> list){
      return list.stream().map(String::trim).toList();
  }

  @Bean
  CorsWebFilter corsFilter() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(removeWhiteSpace(allowedOrigins));
    configuration.setAllowedMethods(removeWhiteSpace(allowedMethods));
    configuration.setAllowedHeaders(removeWhiteSpace(allowedHeaders));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return new CorsWebFilter(source);
  }
}
