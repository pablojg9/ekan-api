package br.com.ekan.avaliacao.ekan.security.filter;

import br.com.ekan.avaliacao.ekan.providers.JwtProvider;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  private final JwtProvider jwtProvider;
  private static final String ROLE_PREFIX = "ROLE_";

  private final List<String> endpoints = List.of("/beneficiarys", "/documents");

  public SecurityFilter(final JwtProvider jwtProvider) {
    this.jwtProvider = jwtProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    String authorization = request.getHeader("Authorization");

    if (endpoints.stream().anyMatch(x -> request.getRequestURI().startsWith(x))) {
      Optional.ofNullable(authorization).ifPresent(x -> {
        DecodedJWT decodedJWT = jwtProvider.validateToken(authorization);

        if (decodedJWT == null) {
          response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          return;
        }

        request.setAttribute("id", decodedJWT.getSubject());
        List<Object> roles = decodedJWT.getClaim("roles").asList(Object.class);

        List<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
          .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.toString().toUpperCase()))
          .toList();

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(decodedJWT.getSubject(), null, grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
      });
    }

    filterChain.doFilter(request, response);
  }
}
