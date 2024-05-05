import entities.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        banco.cadastrarUsuario("Guilherme", "Oliveira", "12345678900", 1000.0);

        System.out.println("Bem-vindo ao Banco!");

        boolean executando = true; //Loop Infinito
        while (executando) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Retirar");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o CPF:");
                    String cpfConsulta = scanner.nextLine();
                    double saldo = banco.consultarSaldo(cpfConsulta);
                    if (saldo != -1) {
                        System.out.println("Saldo: " + saldo);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o CPF:");
                    String cpfDeposito = scanner.nextLine();
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(cpfDeposito, valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o CPF:");
                    String cpfRetirada = scanner.nextLine();
                    System.out.println("Digite o valor da retirada:");
                    double valorRetirada = scanner.nextDouble();
                    banco.retirar(cpfRetirada, valorRetirada);
                    break;
                case 4:
                    executando = false;
                    System.out.println("Obrigado");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }

        scanner.close();
    }
}
