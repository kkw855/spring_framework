package org.example.ch6;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("classpath:ch6/jdbc2.properties")
public class DbConfig {
  @Value("${driverClassName}")
  private String driverClassName;
  @Value("${url}")
  private String url;
  @Value("${dbusername}")
  private String username;
  @Value("${dbpassword}")
  private String password;

  @SuppressWarnings("unchecked")
  @Lazy
  @Bean
  public DataSource dataSource() {
    try {
      SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
      Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
      dataSource.setDriverClass(driver);
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      return dataSource;
    } catch (Exception e) {
      return null;
    }
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource());
    return jdbcTemplate;
  }

  @Bean
  public SingerDao singerDao() {
    return new SingerDaoJdbcTemplate(jdbcTemplate());
  }
}
