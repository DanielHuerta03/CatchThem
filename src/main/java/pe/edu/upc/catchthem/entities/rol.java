package pe.edu.upc.catchthem.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")

public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rol", length = 20,nullable = false)
    private String rol;

    public rol() {
    }

    public rol(int id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
