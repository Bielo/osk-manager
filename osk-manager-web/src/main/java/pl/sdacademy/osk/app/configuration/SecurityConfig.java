package pl.sdacademy.osk.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/resources/**").permitAll()
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

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("student").password("student").roles("STUDENT")
                .and().withUser("teacher").password("teacher").roles("TEACHER");
    }

}
