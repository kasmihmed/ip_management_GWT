package com.stage.projet.client.classe_java;

/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/


import java.util.*;



import com.google.gwt.user.client.rpc.IsSerializable;


public class Utilisateur implements IsSerializable {

   /**
	 * 
	 */

private int idUtilisateur;
   private java.lang.String nomUtilisateur;

   public Utilisateur (int id ,String nom ,String prenom , String email ,String mat,String login, String mdp,int type ,String telephone)
   {
	this.idUtilisateur=id;
	this.nomUtilisateur=nom; 
    this.prenomUtilisateur=prenom;
    this.emailUtilisateur=email;
    this.matUtilisateur=mat;
    this.loginUtilisateur=login;
    this.mdpUtilisateur=mdp;
    this.typeUtilisateur=type;
    this.telephoneUtilisateur=telephone;
   }
   public Utilisateur()
   {
   }


   public int getIdUtilisateur() {
	return idUtilisateur;
}
   
   
public void setIdUtilisateur(int idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}

public java.lang.String getNomUtilisateur() {
	return nomUtilisateur;
}

public void setNomUtilisateur(java.lang.String nomUtilisateur) {
	this.nomUtilisateur = nomUtilisateur;
}

public java.lang.String getPrenomUtilisateur() {
	return prenomUtilisateur;
}

public void setPrenomUtilisateur(java.lang.String prenomUtilisateur) {
	this.prenomUtilisateur = prenomUtilisateur;
}

public java.lang.String getEmailUtilisateur() {
	return emailUtilisateur;
}

public void setEmailUtilisateur(java.lang.String emailUtilisateur) {
	this.emailUtilisateur = emailUtilisateur;
}

public java.lang.String getMatUtilisateur() {
	return matUtilisateur;
}

public void setMatUtilisateur(java.lang.String matUtilisateur) {
	this.matUtilisateur = matUtilisateur;
}

public java.lang.String getLoginUtilisateur() {
	return loginUtilisateur;
}

public void setLoginUtilisateur(java.lang.String loginUtilisateur) {
	this.loginUtilisateur = loginUtilisateur;
}

public java.lang.String getMdpUtilisateur() {
	return mdpUtilisateur;
}

public void setMdpUtilisateur(java.lang.String mdpUtilisateur) {
	this.mdpUtilisateur = mdpUtilisateur;
}

public int getTypeUtilisateur() {
	return typeUtilisateur;
}

public void setTypeUtilisateur(int typeUtilisateur) {
	this.typeUtilisateur = typeUtilisateur;
}

public java.lang.String getTelephoneUtilisateur() {
	return telephoneUtilisateur;
}

public void setTelephoneUtilisateur(java.lang.String telephoneUtilisateur) {
	this.telephoneUtilisateur = telephoneUtilisateur;
}

/** @pdOid a5218a5e-6099-4d37-8ba1-290f17336a25 */
   private java.lang.String prenomUtilisateur;
   /** @pdOid 750caf98-d518-4f81-88b2-016c94b0a2a3 */
   private java.lang.String emailUtilisateur;
   /** @pdOid e0c5701d-e9f5-4343-bc7e-82c94a66eff6 */
   private java.lang.String matUtilisateur;
   /** @pdOid a13953e9-1c5f-4924-b97b-f37f3b12746d */
   private java.lang.String loginUtilisateur;
   /** @pdOid fa19d17f-be53-440f-9aa2-bf40a01b1e3f */
   private java.lang.String mdpUtilisateur;
   /** @pdOid 7d696d6b-5d54-4cec-990a-ae4c0ad89551 */
   private int typeUtilisateur;
   /** @pdOid 8f318aab-2923-4f6b-be77-0c6204c461d7 */
   private java.lang.String telephoneUtilisateur;
   
   /** @pdRoleInfo migr=no name=Terminal assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */


}