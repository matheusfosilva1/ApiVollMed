package br.com.sdconecta.api.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateMedicoDTO(
        @NotNull Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO) {
}
