package es.open4job.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.open4job.model.dao.AlumnoEvaluacionDAO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoEvaluacionBean {

	private int idCentroEstudio;
	private int numero;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;

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

	public String insertarEvaluacionAlumno(int idCentroEstudio, int numero,
			String descripcion , Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {
		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		if (alumnoEvaluacionDAO.insertarEvaluacionAlumno(idCentroEstudio, numero,
				descripcion, fechaInicio, fechaFin, fechaSesion,
				fechaPublicacion)) {
			pagina = "insertarAlumnoEvaluacionExito";
		} else {
			pagina = "insertarAlumnoEvaluacionFallo";
		}
		return pagina;
	}

}
