package com.stage.projet.client.typeutilisateur;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.stage.projet.client.GreetingService;
import com.stage.projet.client.GreetingServiceAsync;
import com.stage.projet.client.page_connexion;
import com.stage.projet.client.classe_java.ListePlage;
import com.stage.projet.client.classe_java.ListeTerminal;
import com.stage.projet.client.classe_java.ListeUtilisateur;
import com.stage.projet.client.classe_java.Terminal;
import com.stage.projet.client.classe_java.Utilisateur;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;

public class ajouter_terminal extends Composite implements HasText {
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private static ajouter_terminalUiBinder uiBinder = GWT
			.create(ajouter_terminalUiBinder.class);
	@UiField VerticalPanel ma_grid;
	@UiField FlexTable ma_table;
	@UiField Grid ma_grid_mod;
	@UiField TextBox nom_terminal;
	@UiField Button modifier_b;
	@UiField Button ajout_terminal;
	@UiField Grid ajouter_terminale_grid;
	@UiField Button aj_termin;
	@UiField TextBox n_terminal;
	@UiField Button MesAdresses;
	@UiField Label MonNom;
	private ListeTerminal liste_uti=new ListeTerminal();

	interface ajouter_terminalUiBinder extends
			UiBinder<Widget, ajouter_terminal> {
	}

	public ajouter_terminal() {
		initWidget(uiBinder.createAndBindUi(this));
		charger_terminal();
		ma_grid_mod.setVisible(false);
		ajouter_terminale_grid.setVisible(false);
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

	void charger_terminal()
	{
		AsyncCallback<ListePlage> callback;
		 greetingService.MesTerminal(Integer.parseInt(Cookies.getCookie("idutilisateur")),new AsyncCallback()
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
				

				ClickHandler click_modifier=	new ClickHandler() {
				    public void onClick(ClickEvent event) {
				     	Widget sender = (Widget) event.getSource();
				    	String title=sender.getTitle();
				    	int num=Integer.parseInt(title);
				    	AsyncCallback<ListePlage> callback;
				    Terminal uti= new Terminal(liste_uti.getTerminal(num).getIdTerminal(),liste_uti.getTerminal(num).getIdUtilisateur(),nom_terminal.getText());
						 greetingService.modifier_terminal(uti,new AsyncCallback()
						{

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void onSuccess(Object result) {
								// TODO Auto-generated method stub
								ma_grid_mod.setVisible(false);
								ma_table.removeAllRows();
								charger_terminal();
							}});
				    	
				    }
				  };
				  
					ClickHandler click_supprimer=	new ClickHandler() {
					    public void onClick(ClickEvent event) {
					     	Widget sender = (Widget) event.getSource();
					    	String title=sender.getTitle();
					    	int num=Integer.parseInt(title);
					    	AsyncCallback<ListePlage> callback;
							 greetingService.supprimer_terminal(liste_uti.getTerminal(num).getIdTerminal(),new AsyncCallback()
							{

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void onSuccess(Object result) {
									// TODO Auto-generated method stub
									Window.alert("suppression effectue avec succes");
									ma_table.removeAllRows();
									charger_terminal();
								}});
					    	
					    }
					  };			  
				 modifier_b.addClickHandler(click_modifier);  
					//  modifier_b.addClickHandler(click_modifier);
				ListeTerminal X=(ListeTerminal)result;
				liste_uti=X;
				ClickHandler click_hand=	new ClickHandler() {
				    public void onClick(ClickEvent event) {
				    	
				    	Widget sender = (Widget) event.getSource();
				    	String title=sender.getTitle();
				    	int num=Integer.parseInt(title);
				    //	ma_grid.setVisible(false);
				    	ajouter_terminale_grid.setVisible(false);
				    	ma_grid_mod.setVisible(true);
				    	nom_terminal.setText( liste_uti.getTerminal(num).getNomTerminal());
				    	modifier_b.setTitle(""+num);
				    	
				    }
				  };
				int n=X.getListe().size();
				Vector<Button> butt_tab=new Vector();
				Vector<Button> butt_tab_suppr=new Vector();
				ma_table.addStyleName("tweetsTable");
				ma_table.setText(0, 0, "numero terminal");
				ma_table.setText(0, 1, "nom terminal");
				ma_table.setText(0, 2, "option 1");
				ma_table.setText(0, 3, "option 2");

				ma_table.getRowFormatter().addStyleName(0, "tweetsTableHeader");

				//ma_table.setText(0, 1, "nom terminal");

				for(int i=0;i<n;i++)
				{
					Button x = new Button("modifier");
					Button x_suppr=new Button("supprimer");
				x.setTitle(""+i);
				x.addClickHandler(click_hand);
				x_suppr.setTitle(""+i);
				x_suppr.addClickHandler(click_supprimer);
				butt_tab.add(x);
				butt_tab_suppr.add(x_suppr);

					 ma_table.setText(i+1, 0,""+ X.getTerminal(i).getIdTerminal());	
					ma_table.setText(i+1, 1,""+ X.getTerminal(i).getNomTerminal());
					ma_table.setWidget(i+1, 2, butt_tab.get(i));
					ma_table.setWidget(i+1, 3, butt_tab_suppr.get(i));

				}
				
				
				
				//Window.alert("success"+X.getPlage(1).getChamp1plage()+"."+X.getPlage(1).getChamp2plage()+"."+X.getPlage(1).getChamp3plage()+"."+X.getPlage(1).getChamp4plage());
			}
			
		});
		
		
	}
	
	

	@UiHandler("ajout_terminal")
	void onAjout_terminalClick(ClickEvent event) {
		ma_grid_mod.setVisible(false);
		ajouter_terminale_grid.setVisible(true);
	}
	@UiHandler("aj_termin")
	void onAj_terminClick(ClickEvent event) {
		
		if((n_terminal.getText().equals("")))
		{
			Window.alert("veuillez saisir le nom de votre terminal!!!");
		}
		
		if(!(n_terminal.getText().equals("")))
		{
		Terminal t=new Terminal();
		t.setNomTerminal(n_terminal.getText());
		t.setIdUtilisateur(Integer.parseInt(Cookies.getCookie("idutilisateur")));
		greetingService.ajouter_terminal(t,new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				//Window.alert("ajout effectue avec succes");
				charger_terminal();
			}});
		
		
		
		}
	}

	
	
	
	
	@UiHandler("MesAdresses")
	void onMesAdressesClick(ClickEvent event) {
		
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
