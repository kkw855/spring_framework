package org.example.ch6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SingerDaoJdbcTemplateTest {
  @Test
  public void test() {
    GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);

    SingerDao singerDao = ctx.getBean("singerDao", SingerDao.class);
    assertNotNull(singerDao);
    testDao(singerDao);

    ctx.close();
  }

  private void testDao(SingerDao singerDao) {
    String fullName = singerDao.findNameById(1L);
    assertEquals("John Mayer", fullName);
  }
}
