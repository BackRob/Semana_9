package model;

import util.GestorDatos;
import util.TipoDato;

public interface IRegistrable {
    String toString();
    void registrarEnReserva(Reserva reserva);
    void registrarEnGestor(GestorDatos gestorDatos);
    boolean esTipo(TipoDato tipo);
}
