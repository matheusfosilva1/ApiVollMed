package br.com.sdconecta.api.domain.dto;

import br.com.sdconecta.api.domain.model.Medico;
import br.com.sdconecta.api.domain.model.components.Especialidade;

public record ListMedicoDTO(Long Id, String name, String email, String crm, Especialidade especialidade) {

    public ListMedicoDTO(Medico medico){
        this(medico.getId() ,medico.getNome(), medico.getEmail(), String.valueOf(medico.getCrm()) , medico.getEspecialidade());
    }
}
