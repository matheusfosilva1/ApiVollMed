package br.com.sdconecta.api.domain.dto;

import br.com.sdconecta.api.domain.model.components.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SaveMedicoDTO(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialidade especialidade,
        @NotNull @Valid EnderecoDTO endereco) {

}
