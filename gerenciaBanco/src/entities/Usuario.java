package entities;
//Atributos da classe
public class Usuario {
    private String nome;
    private String sobrenome ;
    private String CPF ;
    private double Saldo ;

    public Usuario(String nome, String sobrenome, String CPF, double saldo){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.Saldo = saldo;

    }

    public double getSaldo (){
        return Saldo;
    }

    public void depositar (double valor){
        Saldo += valor;
    }

    public boolean retirar(double valor){
        if(valor <= Saldo){
            Saldo -= valor;
            return true;
        }
        return false;
    }

}
