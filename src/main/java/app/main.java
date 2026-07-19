package app;

import model.*;

public class main {

    public static void main(String[] args) {

        Reserva reserva1 = new Reserva();

        Guia guia1 = new Guia("Brian Vallejos","20.647.142-7","Llanquihue Tour","Historiador");
        Vehiculo vehiculo1= new Vehiculo("HHGY-54",2015,"Hyunday","accent",5);
        Cliente cliente1 = new Cliente("Brian Vallejos","123.231.245-7","3456765434565467");
        Tour tour1=new Tour();

        tour1.registrarEnReserva(reserva1);
        guia1.registrarEnReserva(reserva1);
        vehiculo1.registrarEnReserva(reserva1);
        cliente1.registrarEnReserva(reserva1);

        System.out.println(reserva1.mostrar());



    }
}