package es.open4job.sigad.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.open4job.sigad.VO.EvaluacionesVO;
/*
@ManagedBean
@SessionScoped*/
public class EvaluacionesDAO {

	private DataSource ds;

	public EvaluacionesDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// Listar todas las evaluaciones
	public ArrayList<EvaluacionesVO> getallEvaluaciones() {
		ArrayList<EvaluacionesVO> listaEvaluaciones = new ArrayList<EvaluacionesVO>();
		try {
			Connection conexion = ds.getConnection();
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery("select * from evaluacion");
			while (rs.next()) {
				EvaluacionesVO evaluacion = new EvaluacionesVO();
				evaluacion.setId_evaluacion(rs.getInt("id"));
				evaluacion.setId_ensenanza(rs.getInt("id_enseñanza"));
				evaluacion.setId_curso(rs.getInt("id_curso"));
				evaluacion.setEvaluacion(rs.getInt("evaluacion"));
				evaluacion.setFecha_inicio(rs.getDate("fecha_inicio"));
				evaluacion.setFecha_sesion(rs.getDate("fecha_sesion"));
				evaluacion.setFecha_fin(rs.getDate("fecha_final"));
				evaluacion
						.setFecha_publicacion(rs.getDate("fecha_publicacion"));

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

	// Crear nueva evaluacion
	public void InsertarEvaluacionesVO() {
		try {
			EvaluacionesVO evaluacion = new EvaluacionesVO();
			Connection conexion = ds.getConnection();
			PreparedStatement pstm = conexion
					.prepareStatement("Insert into evaluacion Values (?,?,?,?,?,?,?,?)");
			pstm.setInt(1, evaluacion.getId_evaluacion());
			pstm.setInt(2, evaluacion.getId_ensenanza());
			pstm.setInt(3, evaluacion.getId_curso());
			pstm.setInt(4, evaluacion.getEvaluacion());
			pstm.setDate(5, evaluacion.getFecha_inicio());
			pstm.setDate(6, evaluacion.getFecha_sesion());
			pstm.setDate(7, evaluacion.getFecha_fin());
			pstm.setDate(8, evaluacion.getFecha_publicacion());
			pstm.execute();
		} catch (Exception e) {

			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
	}

	// Editar una evaluacion
	public void EditarEvaluacionesVO() {
		try {
			Connection conexion = ds.getConnection();
			PreparedStatement pstm = conexion
					.prepareStatement("Update evaluacion set id = ? , id_enseñanza = ? ,"
							+ " id_curso = ?, evaluacion = ?, fecha_inicio = ?, "
							+ "fecha_sesion = ?, fecha_final = ? , fecha_publicacion = ? Where id= ?");
			/*pstm.setInt(1, );
			pstm.setInt(1, );
			pstm.setInt(1, );
			pstm.setInt(2, );
			pstm.setDate(1, );
			pstm.setDate(1, );
			pstm.setDate(1, );
			pstm.setDate(1, );
			*/
			pstm.executeUpdate();
		} catch (Exception e) {
	
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
	}

	// Eliminar una evaluacion 
	public void EliminarEvaluacionesVO(){
		Connection conexion;
		try {
			conexion = ds.getConnection();
			PreparedStatement pstm = conexion
					.prepareStatement("DELETE FROM evaluacion WHERE id=?");
			//pstm.setInt(1,);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
