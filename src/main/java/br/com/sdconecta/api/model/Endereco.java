package br.com.sdconecta.api.model;

import br.com.sdconecta.api.dto.EnderecoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
    }

    public void updateEndereco(Endereco endereco) {
        if (endereco.logradouro != null) this.logradouro = endereco.logradouro;
        if (endereco.numero != null) this.numero = endereco.numero;
        if (endereco.complemento != null) this.complemento = endereco.complemento;
        if (endereco.bairro != null) this.bairro = endereco.bairro;
        if (endereco.cidade!= null) this.cidade = endereco.cidade;
        if (endereco.uf != null) this.uf = endereco.uf;
        if (endereco.cep != null) this.cep = endereco.cep;
    }
}
