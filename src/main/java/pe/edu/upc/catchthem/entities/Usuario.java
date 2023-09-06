package pe.edu.upc.catchthem.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "name", length = 30,nullable = false)
    private String name;

    @Column(name = "usuario", length = 30,nullable = false)
    private String usuario;

    @Column(name = "contrasena", length = 30,nullable = false)
    private String contrasena;

    @Column(name = "correo", length = 30,nullable = false)
    private String correo;

    @Column(name = "telefono", length = 9,nullable = false)
    private int telefono;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;

    @Column(name = "nivel_acceso", length = 20,nullable = false)
    private String nivel_acceso;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private rol rol;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private Entidad entidad;

    public Usuario() {
    }

    public Usuario(int idUsuario, String name, String usuario, String contrasena, String correo, int telefono, LocalDate fecha_creacion, String nivel_acceso, rol rol, Entidad entidad) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_creacion = fecha_creacion;
        this.nivel_acceso = nivel_acceso;
        this.rol = rol;
        this.entidad = entidad;
    }
    

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

    public String getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public rol getRol() {
        return rol;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
