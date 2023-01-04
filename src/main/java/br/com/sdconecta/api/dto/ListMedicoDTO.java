package br.com.sdconecta.api.dto;

import br.com.sdconecta.api.model.Medico;
import br.com.sdconecta.api.model.components.Especialidade;

public record ListMedicoDTO(Long Id, String name, String email, String crm, Especialidade especialidade) {

    public ListMedicoDTO(Medico medico){
        this(medico.getId() ,medico.getNome(), medico.getEmail(), String.valueOf(medico.getCrm()) , medico.getEspecialidade());
    }
}
