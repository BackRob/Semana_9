package model;

public class Tour {
    private String nombre;
    private boolean duracion;
    private String tipoTour;
    private String ubicacion;

    @Override
    public String toString(){
        return "\n[Tour]\n" +
                "Nombre: "+this.nombre+
                "\nDuracion"+this.duracion+
                "\nTipo de Tour: "+this.tipoTour+
                "\nUbicacion: "+this.ubicacion+"\n";
    }
}
