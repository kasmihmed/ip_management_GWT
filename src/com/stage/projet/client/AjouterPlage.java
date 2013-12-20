package com.stage.projet.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.stage.projet.client.classe_java.PlageAdresse;
import com.stage.projet.client.classe_java.Utilisateur;

public class AjouterPlage extends Composite implements HasText {
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private static AjouterPlageUiBinder uiBinder = GWT
			.create(AjouterPlageUiBinder.class);

	interface AjouterPlageUiBinder extends UiBinder<Widget, AjouterPlage> {
	}

	public AjouterPlage() {
		initWidget(uiBinder.createAndBindUi(this));
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
	}

	@UiField
	Button button123;
	@UiField Button button_14;
	@UiField Button button18;
	@UiField Button ajouter_plage;
	@UiField Button modif_uti1;	
	@UiField TextBox champ1ip;
	@UiField TextBox champ2ip;
	@UiField TextBox champ3ip;
	@UiField TextBox champ4ip;
	@UiField TextBox champ1masque;
	@UiField TextBox champ2masque;
	@UiField TextBox champ3masque;
	@UiField TextBox champ4masque;
	@UiField Button button;
	@UiField Button ajouter_uti1;
	@UiField Label MonNom;

	public AjouterPlage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button123.setText(firstName);
	}

	

	public void setText(String text) {
		button123.setText(text);
	}

	public String getText() {
		return button123.getText();
	}
	
	@UiHandler("button_1")
	void onButton_1Click(ClickEvent event) {
		page_acceuil pa= new page_acceuil();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(pa);
	}

	@UiHandler("button_3")
	void onButton_3Click(ClickEvent event) {
		affichage_affectation aa= new affichage_affectation();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(aa);
	}

	@UiHandler("button_14")
	void onButton_4Click(ClickEvent event) {
		supprimer_un_utilisateur su= new supprimer_un_utilisateur();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(su);
	}
	@UiHandler("button123")
	void onButton123Click(ClickEvent event) {
		supprimer_une_plage sp= new supprimer_une_plage();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(sp);
	}
	@UiHandler("button18")
	void onButton18Click(ClickEvent event) {
		historique_une_adrs_ip h_ip= new historique_une_adrs_ip();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(h_ip);
	}
	@UiHandler("ajouter_plage")
	void onAjouter_plageClick(ClickEvent event) {
		AjouterPlage ap= new AjouterPlage();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(ap);
	}
	@UiHandler("ajouter_uti1")
	void onAjouter_utiClick(ClickEvent event) {
	 AjouterUtilisateur	a_uti= new AjouterUtilisateur();
		//RootPanel.get().removeFromParent();
		RootPanel.get().clear();
		RootPanel.get().add(a_uti);
	}
	@UiHandler("modif_uti1")
	void onModif_utiClick(ClickEvent event) {
		 ModifierUtilisateur	m_uti= new ModifierUtilisateur();
			//RootPanel.get().removeFromParent();
			RootPanel.get().clear();
			RootPanel.get().add(m_uti);	
	}
	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		PlageAdresse plage = new PlageAdresse(Integer.parseInt(champ1ip.getText()),Integer.parseInt(champ2ip.getText()),Integer.parseInt(champ3ip.getText()),Integer.parseInt(champ4ip.getText()),Integer.parseInt(champ1masque.getText()),Integer.parseInt(champ2masque.getText()),Integer.parseInt(champ3masque.getText()),Integer.parseInt(champ4masque.getText()));
		
		
		
		greetingService.ajouter_plage(plage,
			new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
				Window.alert("impossible de faire ce que vous demandez");
				}

				public void onSuccess(String result) {
					Window.alert("l ajout s est effectue avec succes"+result);
				}
			});

	}
	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
		
		page_connexion	m_uti= new page_connexion();
		RootPanel.get().clear();
		RootPanel.get().add(m_uti);	
		
	}
}
