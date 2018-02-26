package pl.sdacademy.osk.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sdacademy.service.security.UserDetailsService;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PlaintextPasswordEncoder passwordEncoder() {
        return new PlaintextPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/login*").anonymous()
                .antMatchers("/student/**").hasRole("STUDENT")
                .antMatchers("/teacher/**").hasRole("TEACHER")
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

    @Autowired
    protected void configureAuthenticationProviders(AuthenticationManagerBuilder authenticationManager, List<AuthenticationProvider> authenticationProviders) {
        authenticationProviders.forEach(authenticationManager::authenticationProvider);
    }

    @Bean
    @Profile("production")
    public AuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService, org.springframework.security.authentication.encoding.PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;
    }

    @Bean
    @Profile("development")
    public AuthenticationProvider dummyAuthenticationProvider() {
        return new DummyAuthenticationProvider();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
//        authenticationManager.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN")
//                .and().withUser("student").password("student").roles("STUDENT")
//                .and().withUser("teacher").password("teacher").roles("TEACHER");
//    }

}
