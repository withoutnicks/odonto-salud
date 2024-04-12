package wts.dev.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "citas")
public class Quotes {
	
	public enum EstCit {
		programada, activa, cancelada
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCit;
	@Temporal(TemporalType.DATE)
	private Date dateCit;
	@Column
	private String razCit;
	@ManyToOne
	private Doctors docId;
	@ManyToOne
	private Receptionists recId;
	@ManyToOne
	private Patients dniUsu;
	@Enumerated(value = EnumType.STRING)
	private EstCit estCit;
	
	public Quotes() {}
	
	public Quotes(int idCit, Date dateCit, String razCit, Doctors docId, Receptionists recId, Patients dniUsu, EstCit estCit) {
		this.idCit = idCit;
		this.dateCit = dateCit;
		this.razCit = razCit;
		this.docId = docId;
		this.recId = recId;
		this.dniUsu = dniUsu;
		this.estCit = estCit;
	}

	public int getIdCit() {
		return idCit;
	}

	public void setIdCit(int idCit) {
		this.idCit = idCit;
	}

	public Date getDateCit() {
		return dateCit;
	}

	public void setDateCit(Date dateCit) {
		this.dateCit = dateCit;
	}

	public String getRazCit() {
		return razCit;
	}

	public void setRazCit(String razCit) {
		this.razCit = razCit;
	}

	public Doctors getDocId() {
		return docId;
	}

	public void setDocId(Doctors docId) {
		this.docId = docId;
	}

	public Receptionists getRecId() {
		return recId;
	}

	public void setRecId(Receptionists recId) {
		this.recId = recId;
	}

	public Patients getDniUsu() {
		return dniUsu;
	}

	public void setDniUsu(Patients dniUsu) {
		this.dniUsu = dniUsu;
	}

	public EstCit getEstCit() {
		return estCit;
	}

	public void setEstCit(EstCit estCit) {
		this.estCit = estCit;
	}
}
