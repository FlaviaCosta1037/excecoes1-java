package aplicacao;
//VERSÃO MUITO RUIM PORQUE A LÓGICA DE PROGRAMAÇÃO DE VALIDAÇÃO DA RESERVA ESTÁ NO PROGRAMA PRINCIPAL

import model.entities.Reserva;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = in.nextInt();
        System.out.print("Data do Check-in (dd/MM/yyyy) ");
        Date checkIn = (Date) sdf.parse(in.next());
        System.out.print("Data do Check-out (dd/MM/yyyy) ");
        Date checkOut = (Date) sdf.parse(in.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: A data do checkout é inferior a data do Checkin! ");
        } else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println(reserva);
            System.out.println();
            System.out.println("Entre com as datas da reserva: ");
            System.out.print("Data do Check-in (dd/MM/yyyy) ");
            checkIn = sdf.parse(in.next());
            System.out.print("Data do Check-out (dd/MM/yyyy) ");
            checkOut = sdf.parse(in.next());

            String erro = reserva.atualizacaoDatas(checkIn, checkOut);
            if (erro != null) {
                System.out.println("Erro na reserva! " + erro);
            } else {
                System.out.println("Reserva" + reserva);
            }
        }

    }
}
