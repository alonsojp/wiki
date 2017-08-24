package com.formation.wiki.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.formation.wiki.entite.Article;
import com.formation.wiki.entite.Utilisateur;

@NamedQueries ({
	@NamedQuery(name="recupererArticleById", query="SELECT * FROM article WHERE"
				+ " idArticle=:id"),
	@NamedQuery(name="recupererListeArticles", query="SELECT * FROM article")
})

public class ArticleDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public ArticleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wikiDB");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	/*
	 * ajouterArticle()
	 */
	public void ajouterArticle(Article article) {
		tx.begin();
		em.persist(article);
		tx.commit();
	}
	
	/*
	 * ajouterArticle()
	 */
	public Boolean ajouterArticle(String nom, String contenu, Utilisateur auteur) {
		Article article = new Article(nom, contenu, auteur);
		Boolean supprOK = false;
		tx.begin();
		em.persist(article);
		supprOK = true;
		tx.commit();
		return supprOK;
	}
	
	/*
	 * supprimerArticle()
	 */
	public Boolean supprimerArticle(Article article) {
		Boolean supprOK = false;
		tx.begin();
		em.remove(article);
		supprOK = true;
		tx.commit();
		return supprOK;
	}
	
	/*
	 * recupererArticleById()
	 */
	public static Article recupererArticleById (int id) {
		
//		String request = "SELECT * FROM article WHERE"
//				+ " idArticle="+id;
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
	 * recupererListeArticles()
	 */
	public static List<Article> getAllArticles() {
		String request = "SELECT * FROM article";
		List<Article> listart = new ArrayList<>();  
//		try {
//			Connection c = ConnexionManager.getConnexion();
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			
//			while (rs.next()) {
//				Article art = new Article();
//				art.setIdArticle(rs.getInt("idArticle"));
//				art.setNom(rs.getString("nom"));
//				art.setContenu(rs.getString("contenu"));
//				art.setIdAuteur(rs.getInt("idAuteur"));
//				listart.add(art);
//				
//			} 
//			
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
		
		return listart;
	}
	
	/*
	 * recupererArticleByNom()
	 */
	public static Article recupererArticleByNom (String nom) {
		Article art=null;
		Query q=em.createNamedQuery("Utilisateur.findById");
		q.setParameter("id", id);
		Utilisateur user=(Utilisateur) q.getSingleResult();
		return user;
		return art;
	}
}
