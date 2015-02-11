package es.open4job.model.vo;

public class Notas {
	private int id_nota;
	private int nota;
	private int id_ensenanza;
	private int id_curso;
	private int id_evaluacion;
	private int id_alumno;
	
	
	public Notas() {
		// TODO Auto-generated constructor stub
	}
	
	public Notas(int id, int nota, int id_ensenanza, int id_curso, int id_evaluacion, int id_alumno) {
		this.id_nota = id;
		this.nota = nota;
		this.id_ensenanza = id_ensenanza;
		this.id_curso = id_curso;
		this.id_evaluacion = id_evaluacion;
		this.id_alumno = id_alumno;
	}

	public int getId() {
		return id_nota;
	}


	public void setId(int id) {
		this.id_nota = id;
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
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


	public int getId_evaluacion() {
		return id_evaluacion;
	}


	public void setId_evaluacion(int id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}


	public int getId_alumno() {
		return id_alumno;
	}


	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	
	
	

}
