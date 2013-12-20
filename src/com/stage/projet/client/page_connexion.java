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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.stage.projet.client.classe_java.Authentification;
import com.stage.projet.client.classe_java.Utilisateur;
import com.google.gwt.user.client.ui.StackLayoutPanel;

public class page_connexion extends Composite implements HasText {

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private static page_connexionUiBinder uiBinder = GWT
			.create(page_connexionUiBinder.class);
	@UiField Button button;
	@UiField TextBox login;
	@UiField PasswordTextBox mdp;
	

	interface page_connexionUiBinder extends UiBinder<Widget, page_connexion> {
	}

	public page_connexion() {
		
		
		
		
		
		initWidget(uiBinder.createAndBindUi(this));
		
	
	
	}



	public page_connexion(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
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






	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		
		Authentification auth=new Authentification();
		auth.setLogin(login.getText());
		auth.setMdp(mdp.getText());
		greetingService.connexion_acceuil(auth,
				new AsyncCallback<Utilisateur>() {
					public void onFailure(Throwable caught) {
					Window.alert("impossible de se connecter au server");
					}

					public void onSuccess(Utilisateur a) {
				if(a.getIdUtilisateur()>0)
							{Cookies.setCookie("idutilisateur",""+a.getIdUtilisateur());
						
							Cookies.setCookie("nomutilisateur",""+a.getNomUtilisateur());
							Cookies.setCookie("prenomutilisateur",""+a.getPrenomUtilisateur());
							Cookies.setCookie("typeutilisateur",""+a.getTypeUtilisateur());
								if(a.getTypeUtilisateur()==1)
											{page_acceuil pa_a=new page_acceuil();
											RootPanel.get().clear();
											RootPanel.get().add(pa_a);}
								else if(a.getTypeUtilisateur()==0)
											{ 
									//Window.alert("qdsgqdfg");
									com.stage.projet.client.typeutilisateur.page_acceuil pa_a=new com.stage.projet.client.typeutilisateur.page_acceuil();
											RootPanel.get().clear();
											RootPanel.get().add(pa_a);
													
											}
							
							}
				else if(a.getIdUtilisateur()==-1)
							{Window.alert("cette combinaison login mot de passe n existe pas");						
							}
				else if(a.getIdUtilisateur()==-2)
							{Window.alert("ce compte a ete supprime");
								
							}
							
					}
				});
	}
}
