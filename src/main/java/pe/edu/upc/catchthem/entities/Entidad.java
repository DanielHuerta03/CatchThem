package pe.edu.upc.catchthem.entities;

import javax.persistence.*;

@Entity
@Table(name = "Entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entidad;
    @Column(name = "nombre",length = 30,nullable = false)
    private String nombre;
    @Column(name = "direccion",length = 30,nullable = false)
    private String direccion;
    @Column(name = "telefono",length = 9,nullable = false)
    private char telefono;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoEntidad tipoEntidad;

    public Entidad() {
    }

    public Entidad(int id_entidad, String nombre, String direccion, char telefono, TipoEntidad tipoEntidad) {
        this.id_entidad = id_entidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoEntidad = tipoEntidad;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getTelefono() {
        return telefono;
    }

    public void setTelefono(char telefono) {
        this.telefono = telefono;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}
