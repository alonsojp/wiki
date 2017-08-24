package com.formation.wiki.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.entite.Utilisateur;


public class UtilisateurDAO {
	
	private EntityManager em;
	private EntityTransaction tx;
	
	public UtilisateurDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wikiDB");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	/**************************
	 * isUserExist (login, mdp)
	 ***************************/
	public String  isUserExist (String login, String mdp) {
		String role_user=null;

		Query q=em.createQuery ("select user from Utilisateur user where user.login = :login and "
				+ "user.password= : mdp");
		q.setParameter("login", login);
		q.setParameter("mdp", mdp);
		Utilisateur user_exist=(Utilisateur) q.getSingleResult();
		if(user_exist != null ) {
			role_user=user_exist.getRole().getName();
		}	
		return role_user;
		
//		String request = "SELECT * FROM utilisateur WHERE"
//				+ " login='"+login+"' AND pass='"+mdp+"'";
//		
//		try {
//			Connection  c = ConnexionManager.getConnexion();
//			if(c==null){
//				throw new ConnectException();
//				
//			}
//			else {
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			if (rs.next()) {
//				return found;
//			} 
//			}
//		} catch (SQLException e) {
//			System.out.println("isUser KO");
//			throw e;
//		} catch(Exception em) {
//			em.printStackTrace();
//			throw em;
//		}
//		return !found;
	}

	//Methode d'ajout d'utilisateur
	public void addUser(Utilisateur user) {
		tx.begin();
		em.persist(user);
		tx.commit();
		// Suppression d'un objet  : em.remove(entity);
		// Mise à jour d'un objet  : em.merge(entity);
		// Récupération d'un objet : em.find(entityClass, primaryKey);
	}
	
	/***********************
	 * getUser (id)
	 **********************/
	public Utilisateur getUser(int id) {
		Query q=em.createNamedQuery("Utilisateur.findById");
		q.setParameter("id", id);
		Utilisateur user=(Utilisateur) q.getSingleResult();
		return user;
	}
	
	/***********************
	 * getUser (id)
	 **********************/
//	public static Utilisateur getUser(int id) throws SQLException {
//		String request = "SELECT * FROM utilisateur WHERE"
//				+ " idUser="+id;
//		try {
//			Connection c = ConnexionManager.getConnexion();
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			if (rs.next()) {
//				Utilisateur user = new Utilisateur();
//				user.setIdUser(rs.getInt("idUser"));
//				user.setLogin(rs.getString("login"));
//				user.setPassword(rs.getString("pass"));
//				user.setNom(rs.getString("nom"));
//				user.setPrenom(rs.getString("prenom"));
//				user.setEmail(rs.getString("email"));
//				user.setTel(rs.getString("tel"));
//				
//				return user;
//			} 
//		} catch (SQLException e) {
//			System.out.println("getUser KO");
//			throw e;
//		} catch (Exception e) {
//			System.out.println("Probleme de connexion");
//		}
//		
//		return null;
//	}
	
	
	/**********************
	 * changerEtatUser()
	 **********************/
	public void changerEtatUser(Utilisateur user) {
		if(user.getActiver() == false) {
			user.setActiver(true);
		}
		else {
			user.setActiver(false);
		}
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
	/**********************
	 * getAllUsers()
	 **********************/
//	public static List<Utilisateur> getAllUsers() throws ConnectException {
//		List<Utilisateur> listUser = new ArrayList<Utilisateur>();
//		String request = "SELECT * FROM utilisateur";
//		try {
//			Connection c = ConnexionManager.getConnexion();
//			Statement st = c.createStatement();
//			ResultSet rs = st.executeQuery(request);
//			while (rs.next()) {
//				Utilisateur user = new Utilisateur();
//				user.setIdUser(rs.getInt("idUser"));
//				user.setLogin(rs.getString("login"));
//				user.setPassword(rs.getString("pass"));
//				user.setNom(rs.getString("nom"));
//				user.setPrenom(rs.getString("prenom"));
//				user.setEmail(rs.getString("email"));
//				user.setTel(rs.getString("tel"));
//				listUser.add(user);
//			} 
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//		return listUser;
//	}
	
}
