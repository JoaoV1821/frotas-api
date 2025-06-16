package com.ufpr.frotas.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ufpr.frotas.domain.model.enums.PerfilEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnh;
    private String cpf;
    private String validadeCnh;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

    private Boolean ativo;
    private String telefone;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoModel endereco;

    @OneToMany(mappedBy = "motorista")
    private List <AgendamentoModel> agendamentos;

    @OneToMany(mappedBy = "motorista")
    private List<AbastecimentoModel> abastecimentos;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<OcorrenciaModel> ocorrencias = new ArrayList<>();


    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public PerfilEnum getPerfil() {
        return this.perfil;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getCnh() {
        return this.cnh;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getValidadeCnh() {
        return this.validadeCnh;
    }

    public EnderecoModel getEndereco() {
        return this.endereco;
    }

    public void setSenha(String value) {
        this.senha = value;
    }

    public void setAtivo(Boolean value) {
        this.ativo = value;
    }

    public void setId(Long id) {
    this.id = id;
}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setValidadeCnh(String validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }


    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
    return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil.name()));
    }

}
