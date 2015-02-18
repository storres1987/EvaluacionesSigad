package es.open4job.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.open4job.model.vo.*;

public interface AlumnoEvaluacionDAOInterfaz {

	public abstract ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado();

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int id);

	public boolean actualizarEvaluacionAlumno(int id,
			int idCentroEstudio, int numero, String descripcion, Date fechaInicio,
			Date fechaFin, Date fechaSesion, Date fechaPublicacion);

	public boolean EliminarEvaluacionAlumno(int id);

}
