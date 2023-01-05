package br.com.sdconecta.api.domain.dto;


import br.com.sdconecta.api.domain.model.User;

public record UserDTO(String login, String senha) {
    public UserDTO(User user) {
       this(user.getLogin(), user.getSenha());
    }
}
