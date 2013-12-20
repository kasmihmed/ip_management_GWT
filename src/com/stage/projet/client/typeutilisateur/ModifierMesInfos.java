package com.stage.projet.client.typeutilisateur;

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
import com.stage.projet.client.GreetingService;
import com.stage.projet.client.GreetingServiceAsync;
import com.stage.projet.client.page_connexion;
import com.stage.projet.client.classe_java.Utilisateur;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class ModifierMesInfos extends Composite implements HasText {
	
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private static ModifierMesInfosUiBinder uiBinder = GWT
			.create(ModifierMesInfosUiBinder.class);
	@UiField TextBox nom;
	@UiField TextBox prenom;
	@UiField TextBox adresse;
	@UiField TextBox cin;
	@UiField TextBox tel;
	@UiField TextBox login;
	@UiField PasswordTextBox mdp;
	@UiField Label MonNom;
	interface ModifierMesInfosUiBinder extends
			UiBinder<Widget, ModifierMesInfos> {
	}

	public ModifierMesInfos() {
		initWidget(uiBinder.createAndBindUi(this));
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
		
		greetingService.MonProfil(Integer.parseInt(Cookies.getCookie("idutilisateur")), new AsyncCallback()
		{
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				
				Utilisateur X=new Utilisateur();
				X=(Utilisateur) result;
				nom.setText(X.getNomUtilisateur());
				prenom.setText(X.getPrenomUtilisateur());
				adresse.setText(X.getEmailUtilisateur());
				cin.setText(X.getMatUtilisateur());
				tel.setText(X.getTelephoneUtilisateur());
				login.setText(X.getLoginUtilisateur());
				mdp.setText(X.getMdpUtilisateur());
				
				
				
				
			}
		}
	);
		
		
		
		
		
		
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




	@UiHandler("modifier_b")
	void onModifier_bClick(ClickEvent event) {
		
		
		String Nom=nom.getText(),Prenom=prenom.getText(),Email=adresse.getText(),Mat=cin.getText(),Login=login.getText(),MDP=mdp.getText(),Tel=tel.getText();
		Utilisateur X=new Utilisateur();
		X.setIdUtilisateur(Integer.parseInt(Cookies.getCookie("idutilisateur")));
		X.setNomUtilisateur(Nom);
		X.setPrenomUtilisateur(Prenom);
		X.setEmailUtilisateur(Email);
		X.setMatUtilisateur(Mat);
		X.setLoginUtilisateur(Login);
		X.setMdpUtilisateur(MDP);
		X.setTelephoneUtilisateur(Tel);
		
		
		greetingService.ModifierMonProfil(X,  new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				
				
				
				
				Window.alert(result);
				
				
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		RootPanel.get().clear();
		page_acceuil p_a=new page_acceuil();
		RootPanel.get().add(p_a);
		
		
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
