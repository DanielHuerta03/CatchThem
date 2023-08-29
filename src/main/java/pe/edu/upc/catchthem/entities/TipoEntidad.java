package pe.edu.upc.catchthem.entities;

import javax.persistence.*;

@Entity
@Table(name = "TipoEntidad")
public class TipoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;
    @Column(name = "sector",length = 15,nullable = false)
    private String sector;

    public TipoEntidad(int id_tipo, String sector) {
        this.id_tipo = id_tipo;
        this.sector = sector;
    }

    public TipoEntidad() {
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
