package es.open4job.sigad.VO;

import java.sql.Date;

public class EvaluacionesVO {
	private int id_evaluacion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_evaluacion;
	private Date fecha_publicacion;
	
	public EvaluacionesVO() {
		// TODO Auto-generated constructor stub
	}
	
	public EvaluacionesVO(int id, Date fecha_inicio, Date fecha_fin, Date fecha_evaluacion, Date fecha_publicacion) {
		this.id_evaluacion = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_evaluacion = fecha_evaluacion;
		this.fecha_publicacion = fecha_publicacion;
	}

	public int getId() {
		return id_evaluacion;
	}

	public void setId(int id) {
		this.id_evaluacion = id;
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

	public Date getFecha_evaluacion() {
		return fecha_evaluacion;
	}

	public void setFecha_evaluacion(Date fecha_evaluacion) {
		this.fecha_evaluacion = fecha_evaluacion;
	}

	public Date getFecha() {
		return fecha_publicacion;
	}

	public void setFecha(Date fecha) {
		this.fecha_publicacion = fecha;
	}
	

}
