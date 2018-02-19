package pl.sdacademy.osk.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.sdacademy.osk.app.security.DummyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/login*").anonymous()
                .antMatchers("/**").authenticated()
                .and().formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main")
                    .loginProcessingUrl("/perform_login")
                    .failureUrl("/login?error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and().logout()
                    .logoutUrl("/perform_logout")
                    .logoutSuccessUrl("/login?logout");
    }

    @Profile("production")
    public void configureProduction(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
        authenticationManager.inMemoryAuthentication()
                .withUser("student").password("student").roles("STUDENT");
        authenticationManager.inMemoryAuthentication()
                .withUser("teacher").password("teacher").roles("TEACHER");
    }

    @Bean
    @Profile("development")
    public DummyAuthenticationProvider dummyAuthenticationProvider() {
        return new DummyAuthenticationProvider();
    }

    @Profile("development")
    public void configureDevelopment(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.authenticationProvider(dummyAuthenticationProvider());
    }
}
