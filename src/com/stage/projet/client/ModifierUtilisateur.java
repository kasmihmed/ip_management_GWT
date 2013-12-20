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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.stage.projet.client.classe_java.ListePlage;
import com.stage.projet.client.classe_java.ListeUtilisateur;
import com.stage.projet.client.classe_java.Utilisateur;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.ListBox;

public class ModifierUtilisateur extends Composite implements HasText {

	private static ModifierUtilisateurUiBinder uiBinder = GWT
			.create(ModifierUtilisateurUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	interface ModifierUtilisateurUiBinder extends
			UiBinder<Widget, ModifierUtilisateur> {
	}

	public ModifierUtilisateur() {
		initWidget(uiBinder.createAndBindUi(this));
		charger_uti();
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
		
		//type.setItemText(1, "Utilisateur");
		//type.setItemText(2, "Administrateur");
		type.addItem("User");
		type.addItem("Admin");
		ma_grid.setVisible(false);
	}

	@UiField
	Button button123;
	@UiField Button ajouter_plage;
	@UiField Button button18;
	@UiField Button ajouter_uti;
	@UiField Button button_14;
	@UiField Button modif_uti1;
	@UiField  FlexTable ma_table;
	@UiField Grid ma_grid;
	@UiField TextBox nom_modifier;
	@UiField TextBox prenom_modifier;
	@UiField TextBox adresse_modifier;
	@UiField TextBox cin_modifier;
	@UiField TextBox tel_modifier;
	@UiField TextBox login_modifier;
	@UiField PasswordTextBox mdp_modifier;
	@UiField Button modifier_b;
	@UiField ListBox type;
	@UiField Label MonNom;
	private ListeUtilisateur liste_uti=new ListeUtilisateur();

	public ModifierUtilisateur(String firstName) {
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
	void charger_uti()
	{
		AsyncCallback<ListePlage> callback;
		int idX=Integer.parseInt(Cookies.getCookie("idutilisateur"));
		 greetingService.MesUtilisateur(idX,new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("failed");
			}

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				//Column<ListePlageIP, ?> X=(Column<ListePlageIP, ?>)result;
				//dataGrid.addColumn(X);
				
				//=new DataGrid<String>("Bonjour");
				
				ClickHandler click_hand=	new ClickHandler() {
				    public void onClick(ClickEvent event) {
				    	
				    	Widget sender = (Widget) event.getSource();
				    	String title=sender.getTitle();
				    	int num=Integer.parseInt(title);
				    	ma_grid.setVisible(true);
				    	nom_modifier.setText( liste_uti.getUtilisateur(num).getNomUtilisateur());
				    	prenom_modifier.setText( liste_uti.getUtilisateur(num).getPrenomUtilisateur());
				    	adresse_modifier.setText( liste_uti.getUtilisateur(num).getEmailUtilisateur());
				    	cin_modifier.setText( liste_uti.getUtilisateur(num).getMatUtilisateur());
				    	tel_modifier.setText( liste_uti.getUtilisateur(num).getTelephoneUtilisateur());
				    	login_modifier.setText( liste_uti.getUtilisateur(num).getLoginUtilisateur());
				    	mdp_modifier.setText( liste_uti.getUtilisateur(num).getMdpUtilisateur());
				    	modifier_b.setTitle(""+num);
				    	if(liste_uti.getUtilisateur(num).getTypeUtilisateur()==0)
				    	type.setSelectedIndex(0);
				    	else if(liste_uti.getUtilisateur(num).getTypeUtilisateur()==1)
				    		type.setSelectedIndex(1);
				    	if(liste_uti.getUtilisateur(num).getTypeUtilisateur()==0)
				    	{
				    		
				    	}
				    }
				  };
					ClickHandler click_modifier=	new ClickHandler() {
					    public void onClick(ClickEvent event) {
					     	Widget sender = (Widget) event.getSource();
					    	String title=sender.getTitle();
					    	int num=Integer.parseInt(title);
					    	AsyncCallback<ListePlage> callback;
					    Utilisateur uti= new Utilisateur(liste_uti.getUtilisateur(num).getIdUtilisateur(),nom_modifier.getText(),prenom_modifier.getText(),adresse_modifier.getText(),cin_modifier.getText(),login_modifier.getText(),mdp_modifier.getText(),0,tel_modifier.getText());
						uti.setTypeUtilisateur(type.getSelectedIndex());
					    greetingService.modifier_utilisateur(uti,new AsyncCallback()
							{

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Object result) {
									// TODO Auto-generated method stub
									ma_grid.setVisible(false);
									ma_table.clear();
									charger_uti();
								}});
					    	
					    }
					  };
					  
					  modifier_b.addClickHandler(click_modifier);
				ListeUtilisateur X=(ListeUtilisateur)result;
				liste_uti=X;
				ma_table.addStyleName("tweetsTable");

				ma_table.setText(0, 0, "idutilisateur");ma_table.setText(0, 1, "nom");ma_table.setText(0, 2, "prenom");ma_table.setText(0, 3, "email");ma_table.setText(0, 4, "matricule");ma_table.setText(0, 5, "login");ma_table.setText(0, 6, "mot de passe");ma_table.setText(0, 7, "type");ma_table.setText(0, 8, "telephone");
				ma_table.getRowFormatter().addStyleName(0, "tweetsTableHeader");

				int n=X.getListe().size();
				Vector<Button> butt_tab=new Vector();
				for(int i=0;i<n;i++)
				{Button x = new Button("modifier");
				x.setTitle(""+i);
				x.addClickHandler(click_hand);
				butt_tab.add(x);
					ma_table.setText(i+1, 0,""+ X.getUtilisateur(i).getIdUtilisateur());
					ma_table.setText(i+1, 1, X.getUtilisateur(i).getNomUtilisateur());
					ma_table.setText(i+1, 2, X.getUtilisateur(i).getPrenomUtilisateur());
					ma_table.setText(i+1, 3, X.getUtilisateur(i).getEmailUtilisateur());
					ma_table.setText(i+1, 4, X.getUtilisateur(i).getMatUtilisateur());
					ma_table.setText(i+1, 5, X.getUtilisateur(i).getLoginUtilisateur());
					ma_table.setText(i+1, 6, X.getUtilisateur(i).getMdpUtilisateur());
					if(X.getUtilisateur(i).getTypeUtilisateur()==0)
					{
					ma_table.setText(i+1, 7,"Utilisateur");
					}
					else if(X.getUtilisateur(i).getTypeUtilisateur()==1)
					{
						ma_table.setText(i+1, 7,"Administrateur");
					}
					ma_table.setText(i+1, 8, X.getUtilisateur(i).getTelephoneUtilisateur());
					ma_table.setWidget(i+1, 9, butt_tab.get(i));
				}
				
				
				
				//Window.alert("success"+X.getPlage(1).getChamp1plage()+"."+X.getPlage(1).getChamp2plage()+"."+X.getPlage(1).getChamp3plage()+"."+X.getPlage(1).getChamp4plage());
			}
			
		});
		
		
	}
	
	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
		
		
		
		 page_connexion	m_uti= new page_connexion();
		 
			//RootPanel.get().removeFromParent();
			RootPanel.get().clear();
			RootPanel.get().add(m_uti);
		
		
		
	}
	@UiHandler("modifier_b")
	void onModifier_bClick(ClickEvent event) {
	}
}




