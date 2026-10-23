package model;

import repository.BancoRepository;
import util.ValidadorCPF;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String senhaAcesso;
    private String senhaTransacao;


    public Usuario(String nome, String cpf, LocalDate dataNascimento, String senhaAcesso, String senhaTransacao) {
        this.nome = nome;
        // Verifica se o cpf e valido, caso nao seja, retorna um erro.
        if (ValidadorCPF.validarCPF(cpf)) {
            this.cpf = ValidadorCPF.limparCPF(cpf);
        } else {
            throw new IllegalArgumentException("CPF invalido!");
        }

        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {    // Verifica se o numero e null ou esta no futuro
            throw new IllegalArgumentException("Data de nascimento invalida!"); // Erro.
        }
        this.dataNascimento = dataNascimento;
        if (!podeAbrirConta()) {
            throw new IllegalArgumentException("Usuario deve ter pelo menos 18 anos!"); // Erro caso seja menor de idade.
        }
        this.senhaAcesso = senhaAcesso;
        this.senhaTransacao = senhaTransacao;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean podeAbrirConta() {
        return getIdade() >= 18;
    }

}
