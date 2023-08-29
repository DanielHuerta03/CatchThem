package pe.edu.upc.catchthem.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Sospechoso")
public class Sospechoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sospechoso;
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    @Column(name = "alias", length = 20, nullable = false)
    private String alias;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fecha_nacimiento;
    @Column(name = "genero", length = 1, nullable = false)
    private String genero;
    @Column(name = "nacionalidad", length = 20, nullable = false)
    private String nacionalidad;
    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
    @Column(name = "historial", length = 50, nullable = false)
    private String historial;
    @Column(name = "estado", length = 1, nullable = false)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private Entidad entidad;

    public Sospechoso() {

    }
    public Sospechoso(int id_sospechoso, String nombre, String alias, LocalDate fecha_nacimiento, String genero, String nacionalidad, String descripcion, String historial, String estado, Entidad entidad) {
        this.id_sospechoso = id_sospechoso;
        this.nombre = nombre;
        this.alias = alias;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.descripcion = descripcion;
        this.historial = historial;
        this.estado = estado;
        this.entidad = entidad;
    }

    public int getId_sospechoso() {
        return id_sospechoso;
    }

    public void setId_sospechoso(int id_sospechoso) {
        this.id_sospechoso = id_sospechoso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
