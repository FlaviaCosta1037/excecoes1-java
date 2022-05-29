package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reserva(Integer roomNumber, Date checkin, Date checkout) {
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
    public void atualizacaoDatas(Date checkin, Date checkout){
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
