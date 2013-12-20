package com.stage.projet.client.classe_java;

/***********************************************************************
 * Module:  Affectation.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class Affectation
 ***********************************************************************/

import java.util.*;



import com.google.gwt.user.client.rpc.IsSerializable;


public class Affectation implements IsSerializable{
 
   private int idAffectation;

   private java.util.Date dateDebut;
   /** @pdOid 9fdd5be7-4607-4e29-82a1-2f449d2ed4ee */
   private java.util.Date dateFin;
   /** @pdRoleInfo migr=no name=Terminal assc=association3 mult=1..1 */
   public Terminal terminal;
   /** @pdRoleInfo migr=no name=AdresseIp assc=association4 mult=1..1 */
   public AdresseIp adresseIp;
   public int getIdAffectation() {
	return idAffectation;
}
public void setIdAffectation(int idAffectation) {
	this.idAffectation = idAffectation;
}
public java.util.Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(java.util.Date dateDebut) {
	this.dateDebut = dateDebut;
}
public java.util.Date getDateFin() {
	return dateFin;
}
public void setDateFin(java.util.Date dateFin) {
	this.dateFin = dateFin;
}
public Terminal getTerminal() {
	return terminal;
}
public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
}
public AdresseIp getAdresseIp() {
	return adresseIp;
}
public void setAdresseIp(AdresseIp adresseIp) {
	this.adresseIp = adresseIp;
}



}