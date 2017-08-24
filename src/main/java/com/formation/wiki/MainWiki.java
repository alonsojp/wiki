package com.formation.wiki;

import java.sql.SQLException;
import java.util.List;

import com.formation.wiki.DAO.ArticleDAO;
import com.formation.wiki.DAO.UtilisateurDAO;
import com.formation.wiki.entite.Article;
import com.formation.wiki.entite.Utilisateur;

public class MainWiki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur user = null;
		
		try {
			if (UtilisateurDAO.isUserExist("jpa", "sp6")) {
				System.out.println("Utilisateur existant. OK");
			} else {
				System.out.println("Cet utilisateur n'existe pas");
			}
		} catch (Exception e) {
			System.out.println("Erreur SQL");
		}
		
		try {
			user = UtilisateurDAO.getUser(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(user);
		
		List<Utilisateur> listUser = UtilisateurDAO.getAllUsers();
		System.out.println();
		for (Utilisateur u : listUser){
			System.out.println(u);
		}
		
		System.out.println();
		user.setLogin("toto"); user.setPassword("0");user.setNom("Al");user.setPrenom("JP");user.setEmail("a@gmail.com");user.setTel("069654");
		if (UtilisateurDAO.insertUser(user)>0) {
			System.out.println("Insertion OK");
		} else {
			System.out.println("Insertion imposssible");
		}
		listUser = UtilisateurDAO.getAllUsers();
		for (Utilisateur u : listUser){
			System.out.println(u);
		}
		
		List<Article> listArt = ArticleDAO.recupererListeArticles();
		System.out.println();
		System.out.println("-- Liste des articles --");
		for (Article a: listArt){
			System.out.println(a);
		}
	}

}
