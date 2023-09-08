package pe.edu.upc.catchthem.dtos;



import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.rol;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class UsuarioDTO {

    private int idUsuario;

    private String name;


    private String usuario;


    private String contrasena;


    private String correo;


    private int telefono;


    private LocalDate fecha_creacion;


    private pe.edu.upc.catchthem.entities.rol rol;


    private Entidad entidad;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public pe.edu.upc.catchthem.entities.rol getRol() {
        return rol;
    }

    public void setRol(pe.edu.upc.catchthem.entities.rol rol) {
        this.rol = rol;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
