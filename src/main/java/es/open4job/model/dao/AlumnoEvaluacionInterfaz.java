package es.open4job.model.dao;

import java.util.ArrayList;

import es.open4job.model.vo.*;

public interface AlumnoEvaluacionInterfaz{
	
	 public abstract  ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() ;
	 public AlumnoEvaluacionVO getDetalleEvaluacion(int idEvaluacion);
	 public void InsertarEvaluacionesVO();
	 public abstract void EditarEvaluacionesVO();
	 public abstract void EliminarEvaluacionesVO();
	 
}
