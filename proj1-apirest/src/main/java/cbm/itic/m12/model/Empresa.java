package cbm.itic.m12.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Table(name = "empresa")
public class Empresa {
    private @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private String cif;

    @JsonManagedReference
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Oferta> ofertes;
    public Set<Oferta> getOfertes() {
        return ofertes;
    }

    public void setOfertes(Set<Oferta> ofertes) {
        this.ofertes = ofertes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Empresa(long id, String nom, String cif) {
        super();
        this.id = id;
        this.nom = nom;
        this.cif = cif;
    }

    public Empresa() {
        super();
    }
}