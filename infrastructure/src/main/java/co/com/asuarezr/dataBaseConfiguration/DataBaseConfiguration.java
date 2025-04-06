package co.com.asuarezr.dataBaseConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "database")
  public DataBaseProperties getDataBaseProperties(){
    return new DataBaseProperties();
  }

  @Bean
  public DataSource buildDataSource(DataBaseProperties dataBaseProperties) {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName(dataBaseProperties.getDriver());
    dataSourceBuilder.url(dataBaseProperties.getUrl());
    dataSourceBuilder.username(dataBaseProperties.getUsername());
    dataSourceBuilder.password(dataBaseProperties.getPassword());
    return dataSourceBuilder.build();
  }

}
