package spring.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperties
{
  @Value( "${program.neve}")
  private String programNeve;

  @Value("${program.leiras}")
  private String programLeiras;

  public String getProgramNeve()
  {
    return programNeve;
  }

  public String getProgramLeiras()
  {
    return programLeiras;
  }
}
