package es.open4job.model.dao;

import java.util.ArrayList;

import es.open4job.model.vo.EvaluacionesVO;


public interface EvaluacionesInterface{
	 public abstract  ArrayList<EvaluacionesVO> getallEvaluaciones() ;
	 public abstract void InsertarEvaluacionesVO();
	 public abstract void EditarEvaluacionesVO();
	 public abstract void EliminarEvaluacionesVO();
	 
}
