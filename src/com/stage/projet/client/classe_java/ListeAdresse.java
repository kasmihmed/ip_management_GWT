package com.stage.projet.client.classe_java;

import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ListeAdresse implements IsSerializable{

	Vector <AdresseIp> V;
	
	
	public ListeAdresse()
	{
		V=new Vector<AdresseIp>();
	}
	
	public void ajouterAdresseIP(AdresseIp X)
	{
		V.add(X);
	}

	public Vector<AdresseIp> getV() {
		return V;
	}

	public void setV(Vector<AdresseIp> v) {
		V = v;
	}
	
	
	
	

}
