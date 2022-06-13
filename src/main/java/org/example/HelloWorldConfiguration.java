package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
  // <bean id="provider" class="org.example.HelloWorldMessageProvider"/>
  @Bean
  public MessageProvider provider() {
    return new HelloWorldMessageProvider();
  }

  // <bean id="renderer" class="org.example.StandardOutMessageRenderer" p:messageProvider-ref="provider"/>
  @Bean MessageRenderer renderer() {
    MessageRenderer renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(provider());
    return renderer;
  }
}
