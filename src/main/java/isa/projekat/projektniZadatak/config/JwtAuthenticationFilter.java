package isa.projekat.projektniZadatak.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final  String userEmail;
    if(authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request,response);
      return;
    }
    jwt = authHeader.substring(7); // vezano za Bearer
    userEmail = jwtService.extractUsername(jwt);
    if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){ // ako imamo user email i user nije autentifikovan
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail); //uzecemo userDetalje iz baze
      if(jwtService.isTokenValid(jwt, userDetails)){ // onda proveravamo da li je user valid ili ne
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( //ako jeste kreiramo objekat tipa UsernamePasswordAuthenticationToken
          userDetails,
          null,
          userDetails.getAuthorities()
        );
        authToken.setDetails( //damo mu detalje naseg zahteva
          new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken); //updejtujemo auth token
      }
    }
    filterChain.doFilter(request,response);
  }
}
