package com.stage.projet.client;

import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.stage.projet.client.classe_java.ListePlage;
import com.stage.projet.client.classe_java.PlageAdresse;
import com.stage.projet.client.classe_java.Utilisateur;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;

public class page_acceuil extends Composite implements HasText {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static page_acceuilUiBinder uiBinder = GWT
			.create(page_acceuilUiBinder.class);
	
	//private final GreetingServiceAsync greetingService = GWT
		//	.create(GreetingService.class);
	
	
	@UiField Button button_1;
	@UiField Button button_3;
	@UiField Button button_14;
	@UiField Button button123;
	@UiField Button button18;
	@UiField Button ajouter_plage;
	@UiField Button ajouter_uti;
	@UiField Button modif_uti1;
	@UiField Hyperlink hyperlink;
	@UiField Label MonNom;


	 
	 
	interface page_acceuilUiBinder extends UiBinder<Widget, page_acceuil> {
	}
 
	public page_acceuil() {
		
		
		
		initWidget(uiBinder.createAndBindUi(this));
	
		TextColumn<PlageAdresse> nameColonne =new TextColumn<PlageAdresse>() {
			
			@Override
			public String getValue(PlageAdresse object) {
				// TODO Auto-generated method stub
				return object.getChamp1AdReseau()+"."+object.getChamp2AdReseau()+"."+object.getChamp3AdReseau()+"."+object.getChamp4AdReseau();
			}
			
		};

		
		
		
		MonNom.setText("you are  :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
		AsyncCallback<ListePlage> callback;

	}

	public page_acceuil(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}

	public void setText(String text) {
		//button.setText(text);
	}

	public String getText() {
		//return button.getText();
		return "a_changer";
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
	@UiHandler("ajouter_uti")
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
	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
	
		page_connexion	m_uti= new page_connexion();
		
		RootPanel.get().clear();
		RootPanel.get().add(m_uti);
	
	}
}
