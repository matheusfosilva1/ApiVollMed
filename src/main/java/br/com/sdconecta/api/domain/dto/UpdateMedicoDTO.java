package br.com.sdconecta.api.domain.dto;

import br.com.sdconecta.api.domain.model.Endereco;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicoDTO(
        @NotNull Long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
