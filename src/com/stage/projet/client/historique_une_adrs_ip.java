package com.stage.projet.client;

import java.util.Date;

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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.stage.projet.client.classe_java.ListeAdresse;

public class historique_une_adrs_ip extends Composite implements HasText {

	
	
	static ListeAdresse X;
	private static historique_une_adrs_ipUiBinder uiBinder = GWT
			.create(historique_une_adrs_ipUiBinder.class);

	interface historique_une_adrs_ipUiBinder extends
			UiBinder<Widget, historique_une_adrs_ip> {
	}
			private final GreetingServiceAsync greetingService = GWT
					.create(GreetingService.class);
	public historique_une_adrs_ip() {
		initWidget(uiBinder.createAndBindUi(this));
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
		greetingService.Afficher_Historique(new AsyncCallback<ListeAdresse>() {
			
			@Override
			public void onSuccess(ListeAdresse result) {
				// TODO Auto-generated method stub
				
				
				
				X=new ListeAdresse();
				X=result;
				
				maTable.addStyleName("tweetsTable");
				maTable.setText(0, 0, "Nom Utilisateur");
				maTable.setText(0, 1, "Prenom Utilisateur");
				maTable.setText(0, 2, "Nom Machine");
				maTable.setText(0, 3, "Adresse IP");
				maTable.setText(0, 4, "Date Debut   ");
				maTable.setText(0, 5, "Date Fin   ");
				maTable.getRowFormatter().addStyleName(0, "tweetsTableHeader");

				int n=X.getV().size();
				if(n>0)
				for(int i=0;i<n;i++)
				{
					maTable.setText(i+1, 0, X.getV().get(i).getNomUtilisateur());
					maTable.setText(i+1, 1, X.getV().get(i).getPrenonUtilisateur());
					maTable.setText(i+1, 2, X.getV().get(i).getNomMachine());
					String AD=X.getV().get(i).getChamp1()+"."+X.getV().get(i).getChamp2()+"."+X.getV().get(i).getChamp3()+"."+X.getV().get(i).getChamp4();
					maTable.setText(i+1, 3,AD );
					maTable.setText(i+1, 4,""+X.getV().get(i).getDD() );
					maTable.setText(i+1, 5,""+X.getV().get(i).getDF() );
					
				}
				
				
				
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@UiField
	Button button123;
	@UiField Button button_14;
	@UiField Button button18;
	@UiField Button ajouter_plage;
	@UiField Button ajouter_uti;
	@UiField Button modif_uti1;
	@UiField FlexTable maTable;
	@UiField TextBox champ1;
	@UiField TextBox NomU;
	@UiField TextBox PrenomU;
	@UiField TextBox champ2;
	@UiField TextBox champ3;
	@UiField Button button;
	@UiField TextBox champ4;
	@UiField TextBox NomM;
	@UiField Label MonNom;

	public historique_une_adrs_ip(String firstName) {
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
	
	
	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		
		
		
		
		
		
		
		maTable.removeAllRows();
		
		
		maTable.addStyleName("tweetsTable");

maTable.setText(0, 0, "Nom Utilisateur");maTable.setText(0, 1, "Prenom Utilisateur");
maTable.setText(0, 2, "Nom Machine");maTable.setText(0, 3, "Adresse IP");
maTable.setText(0, 4, "Date Debut   ");maTable.setText(0, 5, "Date Fin   ");
maTable.getRowFormatter().addStyleName(0, "tweetsTableHeader");

		
String Nom=NomU.getText();
String Prenom=PrenomU.getText();
String Machine=NomM.getText();
String c1=champ1.getText();String c2=champ2.getText();
String c3=champ3.getText();String c4=champ4.getText();

		
			greetingService.Recherche_Historique_Affectation(Nom, Prenom,Machine, c1, c2, c3, c4, new AsyncCallback<ListeAdresse>() {
				
				@Override
				public void onSuccess(ListeAdresse result) {
					// TODO Auto-generated method stub
					
					
					
					ListeAdresse B=new ListeAdresse();
					B=result;
					
					
					
					int n=B.getV().size();
					
					
					for(int i=0;i<=n;i++)
					{
						
						maTable.setText(i+1,0, B.getV().get(i).getNomUtilisateur() );
						maTable.setText(i+1,1, B.getV().get(i).getPrenonUtilisateur() );
						maTable.setText(i+1,2, B.getV().get(i).getNomMachine() );
						String AD_IP=B.getV().get(i).getChamp1()+"."+B.getV().get(i).getChamp2()+"."+B.getV().get(i).getChamp3()+"."+B.getV().get(i).getChamp4();
						maTable.setText(i+1,3, AD_IP );
						maTable.setText(i+1,4, ""+B.getV().get(i).getDD() );
						maTable.setText(i+1,5, ""+B.getV().get(i).getDF() );
						
					}
					
					
					
					
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			
		
		
	

	}
	
	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
	
	
		page_connexion h_ip= new page_connexion();
		RootPanel.get().clear();
		RootPanel.get().add(h_ip);
	
	
	
	}
}
