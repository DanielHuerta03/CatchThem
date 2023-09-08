package pe.edu.upc.catchthem.dtos;

import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.entities.Usuario;

import java.time.LocalDate;

public class ActaInterrogatorioDTO {

    private int id_acta;
    private String detalles;
    private LocalDate fecha;
    private Usuario usuario;
    private Sospechoso sospechoso;

    public int getId_acta() {
        return id_acta;
    }

    public void setId_acta(int id_acta) {
        this.id_acta = id_acta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }
}
