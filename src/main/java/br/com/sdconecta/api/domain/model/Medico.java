package br.com.sdconecta.api.domain.model;

import br.com.sdconecta.api.domain.dto.UpdateMedicoDTO;
import br.com.sdconecta.api.domain.model.components.Especialidade;
import br.com.sdconecta.api.domain.dto.SaveMedicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name= "Medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(SaveMedicoDTO saveMedicoDTO) {
        this.nome = saveMedicoDTO.nome();
        this.email = saveMedicoDTO.email();
        this.telefone = saveMedicoDTO.telefone();
        this.crm =  Integer.valueOf(saveMedicoDTO.crm());
        this.especialidade = saveMedicoDTO.especialidade();
        this.endereco = new Endereco(saveMedicoDTO.endereco());
        this.ativo = true;
    }

    public void updateInfo(UpdateMedicoDTO doc) {
        if (doc.nome() != null) this.nome = doc.nome();
        if (doc.telefone() != null) this.telefone = doc.telefone();
        if (doc.endereco() != null) this.endereco.updateEndereco(doc.endereco());
    }

    public void delete() {
        this.ativo = false;
    }
}
