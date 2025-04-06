package co.com.asuarezr.dataBaseConfiguration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataBaseProperties {
  private String driver;
  private String url;
  private String username;
  private String password;
}
