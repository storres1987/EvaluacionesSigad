package es.open4job.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AlumnoEvaluacionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int idCentroEstudio;
	private int numero;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;

	public AlumnoEvaluacionVO() {
		super();
	}

	public AlumnoEvaluacionVO(int id, int idCentroEstudio, int numero,
			String descripcion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {
		this.id = id;
		this.idCentroEstudio = idCentroEstudio;
		this.numero = numero;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaSesion = fechaSesion;
		this.fechaPublicacion = fechaPublicacion;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCentroEstudio() {
		return idCentroEstudio;
	}

	public void setIdCentroEstudio(int idCentroEstudio) {
		this.idCentroEstudio = idCentroEstudio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaSesion() {
		return fechaSesion;
	}

	public void setFechaSesion(Date fechaSesion) {
		this.fechaSesion = fechaSesion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

}
