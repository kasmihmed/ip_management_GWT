package com.stage.projet.client.classe_java;

import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ListeUtilisateur implements IsSerializable{
private Vector<Utilisateur> Liste;

public ListeUtilisateur()
{Liste=new Vector<Utilisateur>();	
}

public Vector<Utilisateur> getListe() {
	return Liste;
}

public void setListe(Vector<Utilisateur> liste) {
	Liste = liste;
}
public Utilisateur getUtilisateur(int i)
{
return (Utilisateur)getListe().get(i);	
}
public void addUtilisateur(Utilisateur uti)
{
	getListe().add(uti);
}
}
