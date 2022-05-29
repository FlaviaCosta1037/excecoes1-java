package model.entities;

import model.excecoes.Excecoes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reserva(Integer roomNumber, Date checkIn, Date checkOut) throws Excecoes {
        if (!checkOut.after(checkIn)) {
            throw new Excecoes("A data do checkout tem que ser posterior a data do Checkin! ");
        }
        this.numeroQuarto = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return numeroQuarto;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.numeroQuarto = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    //Utilizar o tipo long porque o calculo da diferença entre datas retorna um tipo long
    public long duracao(){
        //Calcular a diferença entre as duas datas em milissegundos
        long diferenca = checkout.getTime() - checkin.getTime();

        //Converter milissegundos para dias
        //TimeUnit é um tipo enumerado complexo que tem algumas operações
        return TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
    }

    //Método para atualização das datas
    public void atualizacaoDatas(Date checkIn, Date checkOut) throws Excecoes{
        Date agora = new Date();
        if (checkIn.before(agora) || checkOut.before(agora)) {
            throw new Excecoes("As reservas devem ser com datas futuras! ");
        }
        if (!checkOut.after(checkIn)) {
            throw new Excecoes("A data do checkout tem que ser posterior a data do Checkin! ");
        }
        this.checkin = checkin;
        this.checkout = checkout;

    }

    @Override
    public String toString(){
        return "Quarto "
                + numeroQuarto
                + ", Check-in "
                + sdf.format(checkin)
                + ", check-out "
                + sdf.format(checkout)
                + ", "
                + duracao()
                + " noites.";
    }
}
