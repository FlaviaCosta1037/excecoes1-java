package aplicacao;

import model.entities.Conta;
import model.excecoes.Excecoes;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaBanco {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try {
            System.out.print("Insira os dados da conta: ");
            int numeroConta = in.nextInt();

            System.out.print("Titular da Conta: ");
            in.next();
            String nome = in.nextLine();

            System.out.print("Saldo inicial da conta: ");
            double saldo = in.nextDouble();

            System.out.print("Limite de saque: ");
            double limiteSaque = in.nextDouble();

            Conta usuario = new Conta(numeroConta, nome, saldo, limiteSaque);

            System.out.print("Informe um valor para retirada: ");
            double saque = in.nextDouble();
            usuario.saque(saque);
            System.out.println(usuario);
        }
        catch (Excecoes e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Erro ao inserir os dados! ");
        }

    }
}
