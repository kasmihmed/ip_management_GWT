package com.stage.projet.client.classe_java;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Authentification implements IsSerializable{
public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
private String login;
private String mdp;
}
