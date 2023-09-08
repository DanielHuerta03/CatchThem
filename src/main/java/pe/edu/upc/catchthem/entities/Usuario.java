package pe.edu.upc.catchthem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import pe.edu.upc.catchthem.entities.Entidad;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    @Column(length = 60, unique = true, nullable = false)
    private String username;
    @Column(length = 60, nullable = false)
    private String password;
    @Column(name = "correo", length = 60, nullable = false)
    private String correo;
    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private Entidad entidad;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private List<Role> roles;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String username, String password, String correo, String telefono, Entidad entidad, List<Role> roles) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.entidad = entidad;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
