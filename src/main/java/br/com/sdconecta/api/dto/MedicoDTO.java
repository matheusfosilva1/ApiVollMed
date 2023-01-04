package br.com.sdconecta.api.dto;

import br.com.sdconecta.api.model.Endereco;
import br.com.sdconecta.api.model.Medico;
import br.com.sdconecta.api.model.components.Especialidade;

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
