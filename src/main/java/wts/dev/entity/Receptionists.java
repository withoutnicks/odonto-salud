package wts.dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recepcionistas")
public class Receptionists {
	
	public enum EstRec {
		activo, inactivo
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRec;
	@Column
	private String nomRec;
	@Column
	private String telRec;
	@Column
	private Double sueRec;
	@Enumerated(value = EnumType.STRING)
	private EstRec estRec;
	
	public Receptionists() {}
	
	public Receptionists(int idRec, String nomRec, String telRec, Double sueRec, EstRec estRec) {
		this.idRec = idRec;
		this.nomRec = nomRec;
		this.telRec = telRec;
		this.sueRec = sueRec;
		this.estRec = estRec;
	}

	public int getIdRec() {
		return idRec;
	}

	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getNomRec() {
		return nomRec;
	}

	public void setNomRec(String nomRec) {
		this.nomRec = nomRec;
	}

	public String getTelRec() {
		return telRec;
	}

	public void setTelRec(String telRec) {
		this.telRec = telRec;
	}

	public Double getSueRec() {
		return sueRec;
	}

	public void setSueRec(Double sueRec) {
		this.sueRec = sueRec;
	}

	public EstRec getEstRec() {
		return estRec;
	}

	public void setEstRec(EstRec estRec) {
		this.estRec = estRec;
	}
	
}
