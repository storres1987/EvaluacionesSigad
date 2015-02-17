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

import es.open4job.model.vo.AlumnoEvaluacionVO;

public class AlumnoEvaluacionDAO implements Serializable,
		AlumnoEvaluacionInterfaz {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger
			.getLogger(AlumnoEvaluacionVO.class.getName());
	DataSource ds;

	public AlumnoEvaluacionDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// Listar todas las evaluaciones
	public ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() {
		ArrayList<AlumnoEvaluacionVO> listaEvaluaciones = new ArrayList<AlumnoEvaluacionVO>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from centro_estudio_evaluacion");
			while (rs.next()) {
				AlumnoEvaluacionVO evaluacion = new AlumnoEvaluacionVO();
				evaluacion.setId(rs.getInt("id"));
				evaluacion.setIdCentroEstudio(rs.getInt("id_centro_estudio"));
				evaluacion.setNumero(rs.getInt("numero"));
				evaluacion.setDescripcion(rs.getString("descripcion"));
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
		} finally {
			try {
				stm.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		return listaEvaluaciones;
	}

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int id) {

		ArrayList<AlumnoEvaluacionVO> detalleEvaluaciones = new ArrayList<AlumnoEvaluacionVO>();

		try {
			Connection conexion = ds.getConnection();
			PreparedStatement pstm;
			Statement stm = conexion.createStatement();
			ResultSet rs;
			String consulta = "SELECT * FROM centro_estudio_evaluacion where id =?";
			pstm = conexion.prepareStatement(consulta);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			while (rs.next()) {
				AlumnoEvaluacionVO detalleEvaluacinesVO = new AlumnoEvaluacionVO();
				detalleEvaluacinesVO.setId(rs.getInt("id"));
				detalleEvaluacinesVO.setIdCentroEstudio(rs.getInt("id_centro_estudio"));
				detalleEvaluacinesVO.setNumero(rs.getInt("numero"));
				detalleEvaluacinesVO.setDescripcion(rs.getString("descripcion"));
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

	public boolean insertarEvaluacionAlumno(int idCentroEstudio, int numero,
			String descripcion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());
			java.sql.Date fechaS = new java.sql.Date(fechaSesion.getTime());
			java.sql.Date fechaP = new java.sql.Date(fechaPublicacion.getTime());

			conn = ds.getConnection();
			String query = "insert into evaluacion (id_centro_estudio,numero,descripcion,fecha_inicio,fecha_final,fecha_sesion,fecha_publicacion) values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idCentroEstudio);
			pstm.setInt(2, numero);
			pstm.setString(3, descripcion);
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
		} finally {
			try {
				pstm.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}

	// Actualizar una evaluacion

	public boolean actualizarEvaluacionAlumno(int id,
			int idCentroEstudio, int numero, String descripcion, Date fechaInicio,
			Date fechaFin, Date fechaSesion, Date fechaPublicacion) {

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());
			java.sql.Date fechaS = new java.sql.Date(fechaSesion.getTime());
			java.sql.Date fechaP = new java.sql.Date(fechaPublicacion.getTime());

			conn = ds.getConnection();
			String query = "update centro_estudio_evaluacion set id_centro_estudio=?, numero=?, descripcion=?, fecha_inicio=?, fecha_final=?, fecha_sesion=?, fecha_publicacion=? where id=?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.setInt(2, idCentroEstudio);
			pstm.setInt(3, numero);
			pstm.setDate(4, fechaI);
			pstm.setDate(5, fechaF);
			pstm.setDate(6, fechaS);
			pstm.setDate(7, fechaP);
			pstm.setInt(8, id);

			return true;

		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoEvaluacionDAO.actualizarEvaluacionAlumno:"
							+ e.getMessage());
		} finally {
			try {
				pstm.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}

	public boolean EliminarEvaluacionAlumno(int id) {

		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			conexion = ds.getConnection();
			pstm = conexion
					.prepareStatement("DELETE FROM centro_estudio_evaluacion WHERE id=?");
			pstm.setInt(1, id);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (Exception e) {
			}
			try {
				conexion.close();
			} catch (Exception e) {
			}
		}
		return false;

	}
	public ArrayList<String> rellenarComboEnsenanza() {

		Connection con;
		ArrayList<String> listadoEnsenanzas = new ArrayList<String>();
		try {
			con = ds.getConnection();
			String seleccion = "SELECT nombre FROM ensenanza e , evaluacion ev where e.id = ev.id_ensenanza group by e.id";
			PreparedStatement ps = con.prepareStatement(seleccion);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				listadoEnsenanzas.add(rs.getString("e.nombre"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listadoEnsenanzas;

	}
}
