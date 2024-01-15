package cbm.itic.m12.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.GenerationType;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "oferta")
public class Oferta {
	
	private @Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) long id;

    @Column
    private String oferta;

    @Column
    private String jornada;

    @Column
    private String lloc;

    //@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empresa_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public Oferta(long id, String oferta, String jornada, String lloc, Empresa empresa) {
		super();
		this.id = id;
		this.oferta = oferta;
		this.jornada = jornada;
		this.lloc = lloc;
		this.empresa = empresa;
	}

	public Oferta() {
		super();
	}
	
    
    
}