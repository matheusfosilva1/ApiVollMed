package br.com.sdconecta.api.rest;

import br.com.sdconecta.api.infra.security.TokenDTO;
import br.com.sdconecta.api.domain.dto.UserDTO;
import br.com.sdconecta.api.domain.model.User;
import br.com.sdconecta.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Profile("prod")
public class AutenticationRest {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticationRest(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDTO userDTO){

        var authToken = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.senha());
        var authentication = authenticationManager.authenticate(authToken);
        var token = tokenService.getToken( (User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));

    }
}
