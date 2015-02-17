package es.open4job.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.open4job.model.dao.AlumnoEvaluacionDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoEvaluacionBean {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String eliminarEvaluacionAlumno(int id) {
		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		
		if(alumnoEvaluacionDAO.EliminarEvaluacionAlumno(id)){
			pagina = "eliminarAlumnoEvaluacion";
		}else{
			pagina = "eliminarAlumnoEvaluacionFallo";
		}

		return pagina;
	}
}
