package aplicacao;
//VERSÃO MUITO RUIM PORQUE A LÓGICA DE PROGRAMAÇÃO DE VALIDAÇÃO DA RESERVA ESTÁ NO PROGRAMA PRINCIPAL

import model.entities.Reserva;
import model.excecoes.Excecoes;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = in.nextInt();
            System.out.print("Data do Check-in (dd/MM/yyyy) ");
            Date checkIn = (Date) sdf.parse(in.next());
            System.out.print("Data do Check-out (dd/MM/yyyy) ");
            Date checkOut = (Date) sdf.parse(in.next());


            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva" + reserva);

            System.out.println();
            System.out.println("Entre com as datas da reserva: ");
            System.out.print("Data do Check-in (dd/MM/yyyy) ");
            checkIn = sdf.parse(in.next());
            System.out.print("Data do Check-out (dd/MM/yyyy) ");
            checkOut = sdf.parse(in.next());

            reserva.atualizacaoDatas(checkIn, checkOut);
            System.out.println("Reserva" + reserva);
        }
        catch (ParseException e){
            System.out.println("Formato da data inválido");
        }
        catch (Excecoes e){
            System.out.println("Erro na reserva " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }
    }
}



