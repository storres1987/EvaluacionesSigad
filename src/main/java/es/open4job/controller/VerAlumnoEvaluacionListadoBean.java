package es.open4job.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.open4job.model.dao.AlumnoEvaluacionDAO;
import es.open4job.model.vo.AlumnoEvaluacionVO;



@ManagedBean
@RequestScoped
public class VerAlumnoEvaluacionListadoBean {

	private int idEvaluacion;
	private int idEnsenanza;
	private int idCurso;
	private int evaluacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;

	private AlumnoEvaluacionVO alumnoEvaluacionVO;

	private ArrayList<AlumnoEvaluacionVO> alumnoEvaluacionListadoVO;

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

	public Date gevaluacionVOetFechaInicio() {
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

	public AlumnoEvaluacionVO getAlumnoEvaluacionVO() {
		return alumnoEvaluacionVO;
	}

	public void setAlumnoEvaluacionVO(AlumnoEvaluacionVO alumnoEvaluacionVO) {
		this.alumnoEvaluacionVO = alumnoEvaluacionVO;
	}

	public ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListadoVO() {
		return alumnoEvaluacionListadoVO;
	}

	public void setAlumnoEvaluacionListadoVO(
			ArrayList<AlumnoEvaluacionVO> alumnoEvaluacionListadoVO) {
		this.alumnoEvaluacionListadoVO = alumnoEvaluacionListadoVO;
	}

	public VerAlumnoEvaluacionListadoBean() {

	}

	public String getAlumnoEvaluacionListado() {

		String pagina = "verAlumnoEvaluacion";

		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();

		alumnoEvaluacionListadoVO = alumnoEvaluacionDAO
				.getAlumnoEvaluacionListado();

		return pagina;

	}

}
