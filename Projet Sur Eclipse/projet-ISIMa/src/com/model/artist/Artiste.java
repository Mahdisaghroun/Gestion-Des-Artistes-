package com.model.artist;

import com.mysql.cj.jdbc.Blob;

public class Artiste {

	
	private String User;
	private String nom;
	private String prenom ;
	private String DateNais ;
	private String IDSpotify;
	private String IDYoutube ;
	private Blob Image;
	private String ImageString;
	private String GenreMusique;
	public Artiste() {
	}
	public Artiste(String user, String nom, String prenom, String dateNais, String iDSpotify, String iDYoutube,
			Blob image,String genre) {
	
		this.User = user;
		this.nom = nom;
		this.prenom = prenom;
		this.DateNais = dateNais;
		this.IDSpotify = iDSpotify;
		this.IDYoutube = iDYoutube;
		this.Image = image;
		this.GenreMusique=genre;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNais() {
		return DateNais;
	}
	public void setDateNais(String dateNais) {
		DateNais = dateNais;
	}
	public String getGenreMusique() {
		return GenreMusique;
	}
	public void setGenreMusique(String genreMusique) {
		GenreMusique = genreMusique;
	}
	public String getIDSpotify() {
		return IDSpotify;
	}
	public void setIDSpotify(String iDSpotify) {
		IDSpotify = iDSpotify;
	}
	public String getIDYoutube() {
		return IDYoutube;
	}
	public void setIDYoutube(String iDYoutube) {
		IDYoutube = iDYoutube;
	}
	public Blob getImage() {
		return Image;
	}
	public void setImage(Blob image) {
		Image = image;
	}
	public void setImageString(String image)
	{
		this.ImageString=image;
	}
	public String getImageString()
	{
		return this.ImageString;
	}
}

