package org.example.ch6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class DbConfigTest {
  @Test
  public void testOne() throws SQLException {
    GenericApplicationContext ctx =
        new AnnotationConfigApplicationContext(DbConfig.class);

    DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
    assertNotNull(dataSource);
    testDataSource(dataSource);

    ctx.close();
  }

  private void testDataSource(DataSource dataSource) throws SQLException {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      PreparedStatement statement = connection.prepareStatement("SELECT 1");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int mockVal = resultSet.getInt(1);
        assertEquals(1, mockVal);
      }
      statement.close();
    } catch (Exception e) {
      System.out.println("예상치 못한 에러 발생");
      e.printStackTrace();
    } finally{
      if (connection != null) {
        connection.close();
      }
    }
  }
}
