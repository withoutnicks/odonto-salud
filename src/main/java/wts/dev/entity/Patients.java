package wts.dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Patients {

	public enum EstUsu {
		activo, inactivo
	}
	
	@Id
	private String dniUsu;
	@Column
	private String nomUsu;
	@Column
	private String telUsu;
	@Enumerated(value = EnumType.STRING)
	private EstUsu estUsu;
	
	public Patients() {}

	public Patients(String dniUsu, String nomUsu, String telUsu, EstUsu estUsu) {
		this.dniUsu = dniUsu;
		this.nomUsu = nomUsu;
		this.telUsu = telUsu;
		this.estUsu = estUsu;
	}

	public String getDniUsu() {
		return dniUsu;
	}

	public void setDniUsu(String dniUsu) {
		this.dniUsu = dniUsu;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getTelUsu() {
		return telUsu;
	}

	public void setTelUsu(String telUsu) {
		this.telUsu = telUsu;
	}

	public EstUsu getEstUsu() {
		return estUsu;
	}

	public void setEstUsu(EstUsu estUsu) {
		this.estUsu = estUsu;
	}
}
