package com.formation.wiki.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.wiki.entite.Article;
import com.formation.wiki.entite.Commentaire;

public class CommentaireDAO {

	/**
	 * ajouterCommentaire()
	 * @param contenu
	 * @param idAuteur
	 * @param idArticle
	 * @return
	 */
	public static int ajouterCommentaire(String contenu, int idAuteur, int idArticle) {
		return 0;
	}
	
	/*
	 * supprimerCommentaire()
	 */
	public static boolean supprimerCommentaire() {
		return false;
	}
	
	/*
	 * recupererCommentaireById()
	 */
	public static Article recupererCommentaireById (int id) {
		String request = "SELECT * FROM commentaire WHERE"
				+ " idComment="+id;
//		try {
//			Connection c = ConnexionManager.getConnexion();
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			if (rs.next()) {
//				Article art = new Article();
//				art.setIdArticle(rs.getInt("idArticle"));
//				art.setNom(rs.getString("nom"));
//				art.setContenu(rs.getString("contenu"));
//				art.setIdAuteur(rs.getInt("idAuteur"));
//				
//				return art;
//			} 
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
		return null;
	}
	
	/*
	 * recupererListeCommentaires()
	 */
	public static List<Commentaire> recupererListeCommentaires() {
		String request = "SELECT * FROM commentaire";
		List<Commentaire> listComment = new ArrayList<>();  
//		try {
//			Connection c = ConnexionManager.getConnexion();
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			
//			while (rs.next()) {
//				Commentaire comment = new Commentaire();
//				comment.setContenu(rs.getString("contenu"));
//				comment.setIdAuteur(rs.getInt("idAuteur"));
//				comment.setIdArticle(rs.getInt("idArticle"));
//				listComment.add(comment);
//			} 
//			
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
		return listComment;
	}
	
	/*
	 * recupererArticleByNom()
	 */
	public static Commentaire recupererCommentaireByAuteur (int idAuteur) {
		Commentaire c=null;
		return c;
	}

}
