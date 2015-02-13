package es.open4job.controller;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.open4job.model.dao.AlumnoEvaluacionDAO;
@ManagedBean
@RequestScoped
public class EliminarAlumnoEvaluacionBean {
	private int idEvaluacion;

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String eliminarEvaluacionAlumno(int idEvaluacion) {
		String pagina="eliminarAlumnoEvaluacion";
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		alumnoEvaluacionDAO.EliminarEvaluacionAlumno(idEvaluacion);
		
		return pagina;
	}
}