package spring.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.components.ApplicationProperties;
import spring.components.ApplicationPropertiesYaml;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.2.3. Application Property Files
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-application-property-files
 *
 * mas nevvel : $ java -jar myproject.jar --spring.config.name=myproject ...
 *
 */

// @ConfigurationProperties(prefix="environments.dev")
@ComponentScan(basePackages = "spring")
@SpringBootApplication
public class PropertiesApplication implements CommandLineRunner
{
	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	ApplicationPropertiesYaml applicationPropertiesYaml;

	private List<String> environmentParams = new ArrayList<String>();

	public List<String> getEnvironmentParams()
	{
		return environmentParams;
	}

	@Override
	public void run( String[] args) throws Exception {
//		ApplicationProperties applicationProperties = configurableApplicationContext.getBean( ApplicationProperties.class);
		System.out.println( "PropertiesApplication::run() : applicationProperties : getProgramNeve()=" + applicationProperties.getProgramNeve() + " getProgramLeiras()=" + applicationProperties.getProgramLeiras());

//		ApplicationPropertiesYaml applicationPropertiesYaml = configurableApplicationContext.getBean( ApplicationPropertiesYaml.class);
		System.out.println( "PropertiesApplication::run() : applicationPropertiesYaml : getEnvDevName()=" + applicationPropertiesYaml.getEnvDevName() + " getProgramNeve()=" + applicationPropertiesYaml.getEnvDevUrl());
	}

	public static void main( String[] args)
	{
		System.out.println( "PropertiesApplication::main() : BEGIN" );

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run( PropertiesApplication.class, args);

		System.out.println( "PropertiesApplication::main() : END" );
	}
}
