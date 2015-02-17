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

	private int id;
	private int idCentroEstudio;
	private int numero;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSesion;
	private Date fechaPublicacion;

	private AlumnoEvaluacionVO alumnoEvaluacionVO;

	private ArrayList<AlumnoEvaluacionVO> alumnoEvaluacionListadoVO;
	private ArrayList<String> listadoEnsenanzas;
	

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


	public ArrayList<String> rellenarComboEnsenanza(){
			AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
			listadoEnsenanzas=new ArrayList<String>();
			return listadoEnsenanzas=alumnoEvaluacionDAO.rellenarComboEnsenanza();
		}

		public ArrayList<String> getListadoEnsenanzas() {
			return listadoEnsenanzas;
		}

		public void setListadoEnsenanzas(ArrayList<String> listadoEnsenanzas) {
			this.listadoEnsenanzas = listadoEnsenanzas;
		}

}
