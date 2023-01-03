package br.com.sdconecta.api.model;

import br.com.sdconecta.api.dto.DoctorDTO;
import br.com.sdconecta.api.model.components.Especialidade;
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

    public Medico(DoctorDTO doctorDTO) {
        this.nome = doctorDTO.nome();
        this.email = doctorDTO.email();
        this.telefone = doctorDTO.telefone();
        this.crm =  Integer.valueOf(doctorDTO.crm());
        this.especialidade = doctorDTO.especialidade();
        this.endereco = new Endereco(doctorDTO.endereco());
    }
}
