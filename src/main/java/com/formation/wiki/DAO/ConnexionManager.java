package com.formation.wiki.DAO;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {

	public static String url="jdbc:mysql://localhost:3306/wiki";
	public static String user="root";
	public static String password="";
	
	public static Connection getConnexion() throws SQLException,ConnectException {
		Connection conn=null;
		try {
			// Charge le driver en mémoire
			Class.forName("com.mysql.jdbc.Driver");
			
			// Etablit la connexion avec la base
			conn=DriverManager.getConnection(url, user, password);
			//System.out.println("Connexion établie avec succès");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur lors du chargement du Driver");
		} catch (SQLException e) {
			System.out.println("Erreur lors de la connexion à la base BDD");
			throw e;
		}
		return conn;
	}
}
