package wts.dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctores")
public class Doctors {
	
	public enum EstDoc {
		activo, inactivo
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDoc;
	@Column
	private String numDoc;
	@Column
	private String nomDoc;
	@Column
	private String telDoc;
	@Column
	private Double sueDoc;
	@Enumerated(value = EnumType.STRING)
	private EstDoc estDoc;
	
	public Doctors() {}

	public Doctors(int idDoc, String numDoc, String nomDoc, String telDoc, Double sueDoc, EstDoc estDoc) {
		this.idDoc = idDoc;
		this.numDoc = numDoc;
		this.nomDoc = nomDoc;
		this.telDoc = telDoc;
		this.sueDoc = sueDoc;
		this.estDoc = estDoc;
	}

	public int getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getNomDoc() {
		return nomDoc;
	}

	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}

	public String getTelDoc() {
		return telDoc;
	}

	public void setTelDoc(String telDoc) {
		this.telDoc = telDoc;
	}

	public Double getSueDoc() {
		return sueDoc;
	}

	public void setSueDoc(Double sueDoc) {
		this.sueDoc = sueDoc;
	}

	public EstDoc getEstDoc() {
		return estDoc;
	}

	public void setEstDoc(EstDoc estDoc) {
		this.estDoc = estDoc;
	}

}
