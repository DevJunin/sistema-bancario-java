
import model.Usuario;
import repository.BancoRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BancoRepository banco = new BancoRepository();
        Usuario usuario = new Usuario(
                "Julio Cesar Raimundo Junior",
                "104.018.046-90",
                LocalDate.of(1999,7,25),
                "senha123",
                "1234"
        );
        banco.adicionarUsuario(usuario);
        Usuario encontrado = banco.buscarUsuarioPorCPF("11144477735");
        if (encontrado != null){
            System.out.println("Usuario encontrado: " + encontrado.getNome());
        } else {
            System.out.println("Usuario nao encontrado");
        }
    }
}
