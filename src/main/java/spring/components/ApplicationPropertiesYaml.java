package spring.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * https://mkyong.com/spring-boot/spring-boot-configurationproperties-example/
 */
@Component
@PropertySource( value="classpath:application.yaml", factory = YamlPropertySourceFactory.class)
public class ApplicationPropertiesYaml
{
  @Value( "${environments.dev.url}")
  private String envDevUrl;

  @Value("${environments.dev.name}")
  private String envDevName;

  public String getEnvDevUrl()
  {
    return envDevUrl;
  }

  public String getEnvDevName()
  {
    return envDevName;
  }
}
