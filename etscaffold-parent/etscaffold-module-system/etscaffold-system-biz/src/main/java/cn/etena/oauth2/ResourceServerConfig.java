package cn.etena.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security OAuth2 资源服务配置
 */
@EnableWebSecurity
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${spring.security.oauth2.resourceserver.permitUrls}")
    private String permitUrls;	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers(permitUrls.split(",")).permitAll()
			.anyRequest().authenticated()
			.and()
            .oauth2ResourceServer()
            .jwt();
	}    
}