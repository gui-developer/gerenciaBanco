package entities;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private final Map<String, Usuario> usuarios;

    public Banco(){
        this.usuarios = new HashMap<>();
    }
    public void cadastrarUsuario(String nome, String sobrenome, String CPF, double saldoInicial){
        Usuario novoUsuario = new Usuario(nome,sobrenome,CPF, saldoInicial);
        usuarios.put(CPF, novoUsuario);
    }
    public double consultarSaldo(String cpf) {
        Usuario usuario = usuarios.get(cpf);
        if (usuario != null) {
            return usuario.getSaldo();
        }
        return -1;
//        return -1; // Retorna -1 se o usuário não for encontrado
    }
    public void depositar(String cpf, double valor) {
        Usuario usuario = usuarios.get(cpf);
        if (usuario != null) {
            usuario.depositar(valor);
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    public void retirar(String cpf, double valor) {
        Usuario usuario = usuarios.get(cpf);
        if (usuario != null) {
            if (usuario.retirar(valor)) {
                System.out.println("Retirada de " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

}
