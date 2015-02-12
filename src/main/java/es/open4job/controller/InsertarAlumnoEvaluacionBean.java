package es.open4job.controller;

import java.sql.Date;

import es.open4job.model.dao.AlumnoEvaluacionDAO;


public class InsertarAlumnoEvaluacionBean {
	private int idEvaluacion;
	private int idEnsenanza;
	private int idCurso;
	private int evaluacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;
	
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
	public String insertarEvaluacionAlumno(int idEvaluacion,int idEnseñanza, int idCurso, int evaluacion,
			Date fechaInicio,Date fechaFin, Date fechaSesion, Date fechaPublicacion) {
		String pagina=null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		
		if (alumnoEvaluacionDAO.insertarEvaluacionAlumno(idEvaluacion, idEnseñanza, idCurso, evaluacion, fechaInicio, fechaFin, fechaSesion, fechaPublicacion)){
			pagina = "insertarAlumnoEvaluacionExito";
		}else{
			pagina = "insertarAlumnoEvaluacionFallo";
		}
		return pagina;
	}
	
}
