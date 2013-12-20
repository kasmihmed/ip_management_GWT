package com.stage.projet.client.classe_java;

/***********************************************************************
 * Module:  PlageAdresse.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class PlageAdresse
 ***********************************************************************/

import java.util.*;



import com.google.gwt.user.client.rpc.IsSerializable;

/** @pdOid 269148ae-eb82-4e67-ac23-1458c255b1a7 */

public class PlageAdresse implements IsSerializable{
   /** @pdOid 3903525c-5d6a-4a45-9aab-03e4a4265b0d */
   private int idPlage;
   public int getIdPlage() {
	return idPlage;
}

   
   
public void setIdPlage(int idPlage) {
	this.idPlage = idPlage;
}

public int getChamp1AdReseau() {
	return champ1AdReseau;
}

public void setChamp1AdReseau(int champ1AdReseau) {
	this.champ1AdReseau = champ1AdReseau;
}

public int getChamp2AdReseau() {
	return champ2AdReseau;
}

public void setChamp2AdReseau(int champ2AdReseau) {
	this.champ2AdReseau = champ2AdReseau;
}

public int getChamp3AdReseau() {
	return champ3AdReseau;
}

public void setChamp3AdReseau(int champ3AdReseau) {
	this.champ3AdReseau = champ3AdReseau;
}

public int getChamp4AdReseau() {
	return champ4AdReseau;
}

public void setChamp4AdReseau(int champ4AdReseau) {
	this.champ4AdReseau = champ4AdReseau;
}



   public int getChamp1masque() {
	return champ1masque;
}

public void setChamp1masque(int champ1masque) {
	this.champ1masque = champ1masque;
}

public int getChamp2masque() {
	return champ2masque;
}

public void setChamp2masque(int champ2masque) {
	this.champ2masque = champ2masque;
}

public int getChamp3masque() {
	return champ3masque;
}

public void setChamp3masque(int champ3masque) {
	this.champ3masque = champ3masque;
}

public int getChamp4masque() {
	return champ4masque;
}

public void setChamp4masque(int champ4masque) {
	this.champ4masque = champ4masque;
}

private int champ1AdReseau;
   private int champ2AdReseau;
   private int champ3AdReseau;
   private int champ4AdReseau;
   private int champ1masque;
   private int champ2masque;
   private int champ3masque;
   private int champ4masque;
   
 public PlageAdresse()  {}
 
 public PlageAdresse(int champ1r,int champ2r,int champ3r,int champ4r,int champ1m,int champ2m,int champ3m,int champ4m)
 { champ1AdReseau=champ1r;
  champ2AdReseau=champ2r;
  champ3AdReseau=champ3r;
  champ4AdReseau=champ4r;
  champ1masque=champ1m;
  champ2masque=champ2m;
  champ3masque=champ3m;
  champ4masque=champ4m;
	 
	 
 }
 
 
 
 public PlageAdresse(int id,int champ1r,int champ2r,int champ3r,int champ4r,int champ1m,int champ2m,int champ3m,int champ4m)
 { 
	 idPlage=id;
	 champ1AdReseau=champ1r;
  champ2AdReseau=champ2r;
  champ3AdReseau=champ3r;
  champ4AdReseau=champ4r;
  champ1masque=champ1m;
  champ2masque=champ2m;
  champ3masque=champ3m;
  champ4masque=champ4m;
	 
	 
 }
 
}