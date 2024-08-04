package br.com.ekan.avaliacao.ekan.config.security;

import br.com.ekan.avaliacao.ekan.security.filter.SecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  private final SecurityFilter securityFilter;

  private static final String[] SWAGGER_LIST = {
    "/swagger-ui/**",
    "/v3/api-docs/**",
    "/swagger-resources/**"
  };

  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    security.csrf(AbstractHttpConfigurer::disable)
      .headers(HeadersConfigurer::disable)
      .authorizeHttpRequests(auth -> {
        auth.requestMatchers("/h2-console/**").permitAll()
          .requestMatchers(SWAGGER_LIST).permitAll()
          .requestMatchers("/beneficiarys/auth/**").permitAll()
          .requestMatchers("/auth").permitAll()
          .requestMatchers("/beneficiarys/save").permitAll();
        auth.anyRequest().authenticated();
      }).addFilterBefore(securityFilter, BasicAuthenticationFilter.class);

    return security.build();
  }
}
