package com.formation.wiki.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire {

	@Id @GeneratedValue
	private int idCommentaire;
	private String contenu;
	
	@Temporal(TemporalType.DATE)
	private Date commentDate;
	
	@OneToOne
	private int Auteur;

	@OneToOne
	private int Article;
	
	/*
	 * Constructeur
	 */
	public Commentaire() {
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getAuteur() {
		return Auteur;
	}

	public void setAuteur(int auteur) {
		Auteur = auteur;
	}

	public int getArticle() {
		return Article;
	}

	public void setArticle(int article) {
		Article = article;
	}	
	
}
