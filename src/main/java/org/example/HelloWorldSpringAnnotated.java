package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
    renderer.render();
  }
}
