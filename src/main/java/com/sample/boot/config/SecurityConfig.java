package com.sample.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
@Configuration
@EnableOAuth2Client
@EnableAuthorizationServer
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        return registration;
    }

    protected void configure(HttpSecurity http) throws Exception {
       http.antMatcher("/**")
               .authorizeRequests()
               .antMatchers(HttpMethod.GET, UriConstant.FREE).permitAll()
               .antMatchers(UriConstant.SECURE).authenticated()
               .antMatchers(UriConstant.SECURE).hasAnyRole(UriConstant.ROLE_TESTER)
               .antMatchers("/", "/login**", "/webjars/**").permitAll()
               .anyRequest().authenticated().and()
               .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
               .and()
               .logout().logoutSuccessUrl("/").permitAll()
               .and()
               .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
               .and()
               .addFilterBefore(this.ssoFilter(), BasicAuthenticationFilter.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("tester").password("test").roles(UriConstant.ROLE_TESTER);
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filter.setFilters(filters);
        return filter;
    }
}
