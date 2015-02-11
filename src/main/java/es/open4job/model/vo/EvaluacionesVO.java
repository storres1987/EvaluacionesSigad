package es.open4job.model.vo;

import java.sql.Date;

public class EvaluacionesVO {
	private int id_evaluacion;
	private int id_ensenanza;
	private int id_curso;
	private int evaluacion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_sesion;
	private Date fecha_publicacion;
	
	public EvaluacionesVO() {
		
	}
	
	public EvaluacionesVO(int id_evaluacion, int id_ensenanza, int id_curso,int evaluacion,Date fecha_inicio, Date fecha_fin, Date fecha_evaluacion, Date fecha_publicacion) {
		this.id_evaluacion = id_evaluacion;
		this.id_ensenanza = id_ensenanza;
		this.id_curso = id_curso;
		this.evaluacion=evaluacion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_sesion = fecha_evaluacion;
		this.fecha_publicacion = fecha_publicacion;
	}

	public int getId_evaluacion() {
		return id_evaluacion;
	}

	public void setId_evaluacion(int id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}

	public int getId_ensenanza() {
		return id_ensenanza;
	}

	public void setId_ensenanza(int id_ensenanza) {
		this.id_ensenanza = id_ensenanza;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Date getFecha_sesion() {
		return fecha_sesion;
	}

	public void setFecha_sesion(Date fecha_sesion) {
		this.fecha_sesion = fecha_sesion;
	}



}
