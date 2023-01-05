package br.com.sdconecta.api.domain.dto;

import br.com.sdconecta.api.domain.model.Endereco;
import br.com.sdconecta.api.domain.model.Medico;
import br.com.sdconecta.api.domain.model.components.Especialidade;

public record MedicoDTO(Long id,
                        String nome,
                        String telefone,
                        Especialidade especialidade,
                        String crm,
                        String email,
                        Endereco endereco) {

    public MedicoDTO(Medico medico){
        this(medico.getId(),
                medico.getNome(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                String.valueOf(medico.getCrm()),
                medico.getEmail(),
                medico.getEndereco());
    }
}
