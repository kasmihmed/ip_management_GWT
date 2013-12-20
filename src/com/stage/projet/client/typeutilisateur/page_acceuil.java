package com.stage.projet.client.typeutilisateur;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.stage.projet.client.page_connexion;
import com.google.gwt.user.client.ui.Hyperlink;

public class page_acceuil extends Composite implements HasText {

	private static page_acceuilUiBinder uiBinder = GWT
			.create(page_acceuilUiBinder.class);
	@UiField Button page_acceuil;
	@UiField Button adresse_dispo;
	@UiField Button ajouter_terminal;
	@UiField Button MesAdresses;
	@UiField Label MonNom;
	@UiField Hyperlink Deconnexion;
	interface page_acceuilUiBinder extends UiBinder<Widget, page_acceuil> {
	}

	public page_acceuil() {
		initWidget(uiBinder.createAndBindUi(this));
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	
	

	@UiHandler("page_acceuil")
	void onPage_acceuilClick(ClickEvent event) {
		RootPanel.get().clear();
		page_acceuil p_a=new page_acceuil();
		RootPanel.get().add(p_a);
	}
	@UiHandler("adresse_dispo")
	void onAdresse_dispoClick(ClickEvent event) {
		RootPanel.get().clear();
		adresses_dispo p_a=new adresses_dispo();
		RootPanel.get().add(p_a);
	}
	@UiHandler("ajouter_terminal")
	void onAjouter_terminalClick(ClickEvent event) {
		RootPanel.get().clear();
		ajouter_terminal p_a=new ajouter_terminal();
		RootPanel.get().add(p_a);
	}
	@UiHandler("MesAdresses")
	void onMes_AdressesClick(ClickEvent event) {
		
		
		RootPanel.get().clear();
		PageMesAdresses p_a=new PageMesAdresses();
		RootPanel.get().add(p_a);
		
	}
	@UiHandler("Deconnexion")
	void onDeconnexionClick(ClickEvent event) {
	
	
		RootPanel.get().clear();
		page_connexion p_a=new page_connexion();
		RootPanel.get().add(p_a);
	
	}
	@UiHandler("ModifierInfos")
	void onModifierInfosClick(ClickEvent event) {
		
		
		RootPanel.get().clear();
		ModifierMesInfos p_a=new ModifierMesInfos();
		RootPanel.get().add(p_a);
		
	}
	
}
