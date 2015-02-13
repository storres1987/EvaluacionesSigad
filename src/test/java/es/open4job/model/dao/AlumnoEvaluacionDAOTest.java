package es.open4job.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.open4job.model.vo.AlumnoEvaluacionVO;

import junit.framework.TestCase;

public class AlumnoEvaluacionDAOTest extends TestCase {
	AlumnoEvaluacionDaoPoolDB evaluacionDAO = new AlumnoEvaluacionDaoPoolDB();

	public ArrayList<AlumnoEvaluacionVO> testgetAlumnoEvaluacionListado() {
		ArrayList<AlumnoEvaluacionVO> evaluaciones = evaluacionDAO
				.getAlumnoEvaluacionListado();
		assertTrue(evaluaciones.size() > 0);
		return evaluaciones;

	}

	public ArrayList<AlumnoEvaluacionVO> testgetDetalleEvaluacion(
			int idEvaluacion) {
		ArrayList<AlumnoEvaluacionVO> evaluacion = evaluacionDAO
				.getDetalleEvaluacion(1);
		return evaluacion;

	}

	public boolean testinsertarEvaluacionAlumno(int idEnsenanza, int idCurso,
			int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		boolean funciona = evaluacionDAO.insertarEvaluacionAlumno(1, 1, 3,
				sqlDate, sqlDate, sqlDate, sqlDate);
		assertTrue(funciona == true);
		return true;

	}

	public void testEliminarEvaluacionAlumno() {
		
		boolean estado=evaluacionDAO.EliminarEvaluacionAlumno(1);

		assertTrue(estado);
	}
}
