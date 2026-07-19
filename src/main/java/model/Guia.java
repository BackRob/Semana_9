package model;

public class Guia extends Persona{

    private String tipoGuia;
    private String empresa;


    @Override
    public String toString() {
        return "\n[Guia]\n" + super.toString()+
                "Tipo Guia: "+ this.tipoGuia+
                "\nEmpresa: "+ this.empresa+"\n";
    }
}
