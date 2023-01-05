package br.com.sdconecta.api.rest;

import br.com.sdconecta.api.auth.Autentication;
import br.com.sdconecta.api.domain.dto.UserDTO;
import br.com.sdconecta.api.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationRest {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDTO userDTO){

        var token = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.senha());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();

    }
}