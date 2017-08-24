package com.formation.wiki.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries ({
	@NamedQuery(name="Article.findById", query="SELECT a FROM Article WHERE a.idArticle=:id"),
	@NamedQuery(name="Article.findByAuteur", query="SELECT a FROM Article WHERE a.Auteur=:auteur")
})
public class Article {

	@Id @GeneratedValue
	private int idArticle;
	private String titre;
	private String contenu;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Utilisateur Auteur;
	private String motCles;
	
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Lob
	@Column(name="photo")
	private Serializable Photo;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToOne
	private Statut statut;
	
	/*
	 * Constructeurs
	 */
	public Article() {
		super();
	}

	public Article(String nom, String contenu, Utilisateur auteur) {
		super();
		setNom(nom);
		setContenu(contenu);
		setAuteur(auteur);
	}

	/*
	 * Getters et Setters
	 */
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Utilisateur getAuteur() {
		return Auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		Auteur = auteur;
	}

	public String getMotCles() {
		return motCles;
	}

	public void setMotCles(String motCles) {
		this.motCles = motCles;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Serializable getPhoto() {
		return Photo;
	}

	public void setPhoto(Serializable photo) {
		Photo = photo;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNom() {
		return titre;
	}

	public void setNom(String nom) {
		this.titre = nom;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
