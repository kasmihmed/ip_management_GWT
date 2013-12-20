package com.stage.projet.client.classe_java;

import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ListeTerminal implements IsSerializable{
private Vector<Terminal> Liste;

public ListeTerminal()
{Liste=new Vector<Terminal>();	
}

public Vector<Terminal> getListe() {
	return Liste;
}

public void setListe(Vector<Terminal> liste) {
	Liste = liste;
}
public Terminal getTerminal(int i)
{
return (Terminal)getListe().get(i);	
}
public void addTerminal(Terminal uti)
{
	getListe().add(uti);
}
}
