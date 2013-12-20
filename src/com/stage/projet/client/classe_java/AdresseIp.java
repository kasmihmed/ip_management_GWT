
/***********************************************************************
 * Module:  AdresseIp.java
 * Author:  sidi mohammed kasmi
 * Purpose: Defines the Class AdresseIp
 ***********************************************************************/
package com.stage.projet.client.classe_java;


import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;


public class AdresseIp implements IsSerializable{
   private int idPeriode;
   public int getIdPeriode() {
	return idPeriode;
}
public void setIdPeriode(int idPeriode) {
	this.idPeriode = idPeriode;
}
private int idAdresse;
   private int champ1;
   private int champ2;
   private int champ3;
   private int champ4;
   private int idplage;
   private Date DD,DF;
   private String maDD,maDF;
 
  
public String getMaDD() {
	return maDD;
}
public void setMaDD(String maDD) {
	this.maDD = maDD;
}
public String getMaDF() {
	return maDF;
}
public void setMaDF(String maDF) {
	this.maDF = maDF;
}
public Date getDD() {
	return DD;
}
public void setDD(Date dD) {
	DD = dD;
}
public Date getDF() {
	return DF;
}
public void setDF(Date dF) {
	DF = dF;
}
private String NomMachine,NomUtilisateur,PrenonUtilisateur;
   
public String getNomMachine() {
	return NomMachine;
}
public void setNomMachine(String nomMachine) {
	NomMachine = nomMachine;
}
public String getNomUtilisateur() {
	return NomUtilisateur;
}
public void setNomUtilisateur(String nomUtilisateur) {
	NomUtilisateur = nomUtilisateur;
}
public String getPrenonUtilisateur() {
	return PrenonUtilisateur;
}
public void setPrenonUtilisateur(String prenonUtilisateur) {
	PrenonUtilisateur = prenonUtilisateur;
}
public int getIdplage() {
	return idplage;
}
public void setIdplage(int idplage) {
	this.idplage = idplage;
}
public int getIdAdresse() {
	return idAdresse;
}
public void setIdAdresse(int idAdresse) {
	this.idAdresse = idAdresse;
}
public int getChamp1() {
	return champ1;
}
public void setChamp1(int champ1) {
	this.champ1 = champ1;
}
public int getChamp2() {
	return champ2;
}
public void setChamp2(int champ2) {
	this.champ2 = champ2;
}
public int getChamp3() {
	return champ3;
}
public void setChamp3(int champ3) {
	this.champ3 = champ3;
}
public int getChamp4() {
	return champ4;
}
public void setChamp4(int champ4) {
	this.champ4 = champ4;
}
public boolean equals(AdresseIp a_ip)
{if(this.getChamp1()==a_ip.getChamp1()&&this.getChamp2()==a_ip.getChamp2()&&this.getChamp3()==a_ip.getChamp3()&&this.getChamp4()==a_ip.getChamp4())
    return true;
else 
    return false;
    }
public AdresseIp(int champ1,int champ2,int champ3,int champ4)
{this.champ1=champ1;
this.champ2=champ2;
this.champ3=champ3;
this.champ4=champ4;
}
public AdresseIp()
{}
public String toString()
{
	return ""+this.getChamp1()+"-"+this.getChamp2()+"-"+this.getChamp3()+"-"+this.getChamp4();
}
}