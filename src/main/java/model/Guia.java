package model;

public class Guia extends Persona{

    private String tipoGuia;
    private String empresa;

    //CONSTRUCTORES

    public Guia(){
        this("SINNOMBRE","SINRUT","SINEMPRESA","SINTIPOGUIA");
    }

    public Guia(String nombre, String rut, String empresa, String tipoGuia) {
        super(nombre, rut);
        this.empresa = empresa;
        this.tipoGuia = tipoGuia;
    }

    //GETS Y SETS
    public String getTipoGuia() {return tipoGuia;}
    public String getEmpresa() {return empresa;}
    public void setTipoGuia(String tipoGuia) {this.tipoGuia = tipoGuia;}
    public void setEmpresa(String empresa) {this.empresa = empresa;}


    @Override
    public String toString() {
        return "\n[Guia]\n" +
                super.toString()+
                "Tipo Guia: "+ this.tipoGuia+
                "\nEmpresa: "+ this.empresa+"\n";
    }
}
