package repository;

import model.Usuario;
import util.ValidadorCPF;

import java.util.ArrayList;

public class BancoRepository {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario invalido!");
        }
        if (cpfJaCadastrado(usuario.getCpf())) {
            throw new IllegalArgumentException("CPF ja cadastrado");
        }
        usuarios.add(usuario);
    }

    public int quantidadeDeUsuarios() {
        return usuarios.size();
    }

    public boolean cpfJaCadastrado(String cpf) {
        if (cpf == null) {
            return false;
        }
        String cpfLimpo = ValidadorCPF.limparCPF(cpf);

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfLimpo)) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscarUsuarioPorCPF(String cpf) {
        if (cpf == null) {
            return null;
        }

        String cpfLimpo = ValidadorCPF.limparCPF(cpf);

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfLimpo)) {
                return usuario;
            }
        }

        return null;
    }

}
