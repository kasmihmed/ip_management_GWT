package com.stage.projet.client.classe_java;


import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.Vector;
public class ListePlageIp implements IsSerializable{
	
	
	
	Vector<PlageAdresse> Liste;
	
	
	public ListePlageIp()
	{
		Liste=new Vector<PlageAdresse>();
	}

		public PlageAdresse getPlage(int i)
		{
			return (PlageAdresse) getListe().get(i);
		}
	public Vector getListe() {
		return Liste;
	}

	public void setListe(Vector liste) {
		Liste = liste;
	}
	
	
	public void AjouterPlage(PlageAdresse P)
	{
		Liste.add(P);
	}
	

}
