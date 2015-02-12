package es.open4job.controller;

import java.sql.Date;

import es.open4job.model.dao.AlumnoEvaluacionDAO;


public class InsertarAlumnoEvaluacionBean {
	private int idEnsenanza;
	private int idCurso;
	private int evaluacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;
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
	public String insertarAlumnoEvaluacion() {
		String pagina=null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		/*
		if (alumnoNotaDAO.InsertarEvaluacionesVO()){
			pagina = "insertarAlumnoEvaluacionExito";
		}else{
			pagina = "insertarAlumnoEvaluacionFallo";
		}*/
		return pagina;
	}
	
}
