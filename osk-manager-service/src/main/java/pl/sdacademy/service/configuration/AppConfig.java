package pl.sdacademy.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;

@Configuration
@Import(PersistenceConfig.class)
@ComponentScan(basePackages = {"pl.sdacademy.service"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(
                new ClassPathResource("persistence.properties"));

        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlaintextPasswordEncoder();
    }
}
