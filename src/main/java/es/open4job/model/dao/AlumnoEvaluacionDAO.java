package es.open4job.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.model.vo.*;

public class AlumnoEvaluacionDAO implements Serializable,
		AlumnoEvaluacionInterfaz {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger
			.getLogger(AlumnoEvaluacionVO.class.getName());
	private DataSource ds;

	public AlumnoEvaluacionDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/opensigad2");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// Listar todas las evaluaciones
	public ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() {
		ArrayList<AlumnoEvaluacionVO> listaEvaluaciones = new ArrayList<AlumnoEvaluacionVO>();
		try {
			Connection conexion = ds.getConnection();
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery("select * from evaluacion");
			while (rs.next()) {
				AlumnoEvaluacionVO evaluacion = new AlumnoEvaluacionVO();
				evaluacion.setIdEvaluacion(rs.getInt("id"));
				evaluacion.setIdEnsenanza(rs.getInt("id_enseñanza"));
				evaluacion.setIdCurso(rs.getInt("id_curso"));
				evaluacion.setEvaluacion(rs.getInt("evaluacion"));
				evaluacion.setFechaInicio(rs.getDate("fecha_inicio"));
				evaluacion.setFechaSesion(rs.getDate("fecha_sesion"));
				evaluacion.setFechaFin(rs.getDate("fecha_final"));
				evaluacion.setFechaPublicacion(rs.getDate("fecha_publicacion"));

				listaEvaluaciones.add(evaluacion);
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en EvaluacionesDAO.getallEvaluaciones:"
							+ e.getMessage());
		}
		return listaEvaluaciones;
	}

	public AlumnoEvaluacionVO getDetalleAlumnoEvaluacion(int idEvaluacion) {

		AlumnoEvaluacionVO evaluacionVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			new ArrayList<AlumnoEvaluacionVO>();
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM alumno where id =?");
			ps.setInt(1, idEvaluacion);

			result = ps.executeQuery();

			while (result.next()) {
				evaluacionVO = new AlumnoEvaluacionVO(
						result.getInt("idEvaluacion"),
						result.getInt("idEnseñanza"), result.getInt("idCurso"),
						result.getInt("evaluacion"),
						result.getDate("fechaInicio"),
						result.getDate("fechaFin"),
						result.getDate("fechaSesion"),
						result.getDate("fechaPublicacion"));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return evaluacionVO;
	}

	// Crear nueva evaluacion

	public boolean insertarEvaluacionAlumno(int idEnsenanza, int idCurso,
			int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {
		try {

			java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());
			java.sql.Date fechaS = new java.sql.Date(fechaSesion.getTime());
			java.sql.Date fechaP = new java.sql.Date(fechaPublicacion.getTime());

			Connection conn = ds.getConnection();
			PreparedStatement pstm;
			String query = "insert into evaluacion (id_enseñanza,id_curso,evaluacion,fecha_inicio,fecha_fin,fecha_sesion,fecha_publicacion) values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idEnsenanza);
			pstm.setInt(2, idCurso);
			pstm.setInt(3, evaluacion);
			pstm.setDate(4, fechaI);
			pstm.setDate(5, fechaF);
			pstm.setDate(6, fechaS);
			pstm.setDate(7, fechaP);
			pstm.execute();
			return true;

		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoEvaluacionDAO.insertarEvaluacionAlumno:"
							+ e.getMessage());
		}
		return false;
	}

	public void EditarEvaluacionesVO() {
		// TODO Auto-generated method stub

	}

	public void EliminarEvaluacionAlumno(int idEvaluacion) {
	
			 try { 
				 Connection conexion = ds.getConnection();
			  PreparedStatement pstm = conexion
			  .prepareStatement("DELETE FROM evaluacion WHERE id=?");
			 pstm.setInt(1,idEvaluacion); 
			 pstm.executeUpdate(); 
			 } catch (SQLException e) {
			  e.printStackTrace(); }
			 
	}

	public AlumnoEvaluacionVO getDetalleEvaluacion(int idEvaluacion) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Editar una evaluacion public void EditarEvaluacionesVO() { try
	 * {EvaluacionVO Connection conexion = ds.getConnection(); PreparedStatement
	 * pstm = conexion
	 * .prepareStatement("Update evaluacion set id = ? , id_enseñanza = ? ," +
	 * " id_curso = ?, evaluacion = ?, fecha_inicio = ?, " +
	 * "fecha_sesion = ?, fecha_final = ? , fecha_publicacion = ? Where id= ?");
	 * /*pstm.setInt(1, ); pstm.setInt(1, ); pstm.se// Editar una evaluacion
	 * tInt(1, ); pstm.setInt(2, ); pstm.setDate(1, ); pstm.setDate(1, );
	 * pstm.setDate(1, ); pstm.setDate(1, );
	 * 
	 * pstm.executeUpdate(); } catch (Exception e) {
	 * 
	 * Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage());
	 * } }
	 * 
	 *
	 */
}
