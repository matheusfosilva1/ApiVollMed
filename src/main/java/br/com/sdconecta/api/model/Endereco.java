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
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = Integer.valueOf(endereco.numero());
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
    }

    public void updateEndereco(EnderecoDTO enderecoDTO) {
        if (enderecoDTO.logradouro() != null) this.logradouro = enderecoDTO.logradouro();
        if (enderecoDTO.numero() != null) this.numero = Integer.valueOf(enderecoDTO.numero());
        if (enderecoDTO.complemento() != null) this.complemento = enderecoDTO.complemento();
        if (enderecoDTO.bairro() != null) this.bairro = enderecoDTO.bairro();
        if (enderecoDTO.cidade() != null) this.cidade = enderecoDTO.cidade();
        if (enderecoDTO.uf() != null) this.uf = enderecoDTO.uf();
        if (enderecoDTO.cep() != null) this.cep = enderecoDTO.cep();
    }
}
