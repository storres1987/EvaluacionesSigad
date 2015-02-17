package es.open4job.controller;


import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.open4job.model.dao.AlumnoEvaluacionDAO;

@ManagedBean
@RequestScoped
public class ActualizarAlumnoEvaluacionBean implements Serializable{

	private int idEvaluacion;
	private int idEnsenanza;
	private int idCurso;
	private int evaluacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;

	public ActualizarAlumnoEvaluacionBean() {
	}

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public int getIdEnsenanza() {
		return idEnsenanza;
	}

	public void setIdEnsenanza(int idEnsenanza) {
		this.idEnsenanza = idEnsenanza;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
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

	public String actualizarEvaluacionAlumno(int idEvaluacion, int idEnsenanza, int idCurso, 
		int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion, Date fechaPublicacion) {

		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		if (alumnoEvaluacionDAO.actualizarEvaluacionAlumno(idEvaluacion, idEnsenanza, idCurso, evaluacion, fechaInicio, fechaFin, fechaSesion, fechaPublicacion)) {
			pagina = "actualizarAlumnoEvaluacionExito";
		} else {
			pagina = "actualizarAlumnoEvaluacionFallo";
		}
		return pagina;
	}
}
