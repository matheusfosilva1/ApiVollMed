package br.com.sdconecta.api.dto;

import br.com.sdconecta.api.model.Endereco;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicoDTO(
        @NotNull Long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
