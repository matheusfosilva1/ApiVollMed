package br.com.sdconecta.api.infra.security;

import br.com.sdconecta.api.domain.repository.UserRepository;
import jakarta.persistence.Convert;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private  final TokenService tokenService;

    private  final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = requestToken(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var user = userRepository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String requestToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer", "").strip();
        }

        return null;
    }
}
