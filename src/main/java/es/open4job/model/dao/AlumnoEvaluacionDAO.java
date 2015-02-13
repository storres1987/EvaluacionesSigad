package es.open4job.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int idEvaluacion) {

		ArrayList<AlumnoEvaluacionVO> detalleEvaluaciones = new ArrayList<AlumnoEvaluacionVO>();

		try {
			Connection conexion = ds.getConnection();
			PreparedStatement pstm;
			Statement stm = conexion.createStatement();
			ResultSet rs;
			String consulta = "SELECT * FROM evaluacion where id =?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setInt(1, idEvaluacion);
			rs = pstm.executeQuery();

			while (rs.next()) {
				AlumnoEvaluacionVO detalleEvaluacinesVO = new AlumnoEvaluacionVO();
				detalleEvaluacinesVO.setEvaluacion(rs.getInt("id"));
				detalleEvaluacinesVO.setIdEnsenanza(rs.getInt("id_ensenanza"));
				detalleEvaluacinesVO.setIdCurso(rs.getInt("id_curso"));
				detalleEvaluacinesVO.setEvaluacion(rs.getInt("evaluacion"));
				detalleEvaluacinesVO.setFechaInicio(rs.getDate("fecha_inicio"));
				detalleEvaluacinesVO.setFechaSesion(rs.getDate("fecha_sesion"));
				detalleEvaluacinesVO.setFechaFin(rs.getDate("fecha_final"));
				detalleEvaluacinesVO.setFechaPublicacion(rs
						.getDate("fecha_publicacion"));
				detalleEvaluaciones.add(detalleEvaluacinesVO);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		return detalleEvaluaciones;
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
			pstm.setInt(1, idEvaluacion);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
