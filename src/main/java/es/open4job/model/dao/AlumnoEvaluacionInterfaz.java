package es.open4job.model.dao;

import java.util.ArrayList;

import es.open4job.model.vo.*;

public interface AlumnoEvaluacionInterfaz {

	public abstract ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado();

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int idEvaluacion);

	/*
	 * public boolean insertarEvaluacionAlumno( int idEnsenanza, int idCurso,
	 * int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,Date
	 * fechaPublicacion);
	 */public abstract void EditarEvaluacionesVO();

	public boolean EliminarEvaluacionAlumno(int idEvaluacion);

}
