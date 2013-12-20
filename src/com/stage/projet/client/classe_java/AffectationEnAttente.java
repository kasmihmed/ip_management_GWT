package com.stage.projet.client.classe_java;

/***********************************************************************
 * Module:  AffectationEnAttente.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class AffectationEnAttente
 ***********************************************************************/

import java.util.*;



import com.google.gwt.user.client.rpc.IsSerializable;


public class AffectationEnAttente implements IsSerializable{
   /** @pdOid eaece93a-3c71-46b1-b066-379ffc959c49 */
   private int idDmdAttente;
   /** @pdOid a2d83d05-c856-40ba-9e0f-8fdf1595f985 */
   private java.util.Date dateDeDemande;
   
   /** @pdRoleInfo migr=no name=Terminal assc=association5 mult=1..1 */
   public Terminal terminal;

   
public int getIdDmdAttente() {
	return idDmdAttente;
}

public void setIdDmdAttente(int idDmdAttente) {
	this.idDmdAttente = idDmdAttente;
}

public java.util.Date getDateDeDemande() {
	return dateDeDemande;
}

public void setDateDeDemande(java.util.Date dateDeDemande) {
	this.dateDeDemande = dateDeDemande;
}

public Terminal getTerminal() {
	return terminal;
}

public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
}

}