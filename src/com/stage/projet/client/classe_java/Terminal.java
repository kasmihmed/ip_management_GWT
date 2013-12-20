package com.stage.projet.client.classe_java;

/***********************************************************************
 * Module:  Terminal.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class Terminal
 ***********************************************************************/

import java.util.*;



import com.google.gwt.user.client.rpc.IsSerializable;


public class Terminal implements IsSerializable{
   /** @pdOid 2b08310a-b928-48f8-a060-6e4956d9cac7 */
   private int idTerminal;
   private int idUtilisateur;
   private String nomTerminal;
public Terminal()
{
	;}
public Terminal(int idt,int idu,String nom)
	{this.idTerminal=idt;
	this.idUtilisateur=idu;
	this.nomTerminal=nom;
	}
   

   public int getIdUtilisateur() {
	return idUtilisateur;
}
public void setIdUtilisateur(int idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}
public String getNomTerminal() {
	return nomTerminal;
}
public void setNomTerminal(String nomTerminal) {
	this.nomTerminal = nomTerminal;
}
public int getIdTerminal() {
	return idTerminal;
}
public void setIdTerminal(int idTerminal) {
	this.idTerminal = idTerminal;
}


}
