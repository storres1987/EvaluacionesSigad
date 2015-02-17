package es.open4job.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.open4job.model.vo.*;

public interface AlumnoEvaluacionInterfaz {

	public abstract ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado();

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int idEvaluacion);

	public boolean actualizarEvaluacionAlumno(int id_evaluacion,
			int idEnsenanza, int idCurso, int evaluacion, Date fechaInicio,
			Date fechaFin, Date fechaSesion, Date fechaPublicacion);

	public boolean EliminarEvaluacionAlumno(int idEvaluacion);

}
