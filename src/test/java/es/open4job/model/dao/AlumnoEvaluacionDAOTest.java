package es.open4job.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.open4job.model.vo.AlumnoEvaluacionVO;

import junit.framework.TestCase;

public class AlumnoEvaluacionDAOTest extends TestCase {

	public ArrayList<AlumnoEvaluacionVO> testgetAlumnoEvaluacionListado(){
		
		return null;
		
	}
	
	public AlumnoEvaluacionVO testgetDetalleAlumnoEvaluacion(int idEvaluacion) {
		AlumnoEvaluacionDaoPoolDB alumnoDao = new  AlumnoEvaluacionDaoPoolDB();
		//ArrayList <AlumnoEvaluacionVO> alumnoNotas = alumnoDao.getDetalleAlumnoEvaluacion(1);
		
		return null;
		
	}
	
	public boolean testinsertarEvaluacionAlumno(int idEnsenanza, int idCurso,
			int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {
		
		
		
				return false;
		
	}
	public void testEliminarEvaluacionAlumno(int idEvaluacion) {
		
	}
}
