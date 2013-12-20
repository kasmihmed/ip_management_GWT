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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.FlexTable;
import com.stage.projet.client.GreetingService;
import com.stage.projet.client.GreetingServiceAsync;
import com.stage.projet.client.page_connexion;
import com.stage.projet.client.classe_java.AdresseIp;
import com.stage.projet.client.classe_java.Affectation;
import com.stage.projet.client.classe_java.ListePlage;
import com.stage.projet.client.classe_java.ListePlageIp;
import com.stage.projet.client.classe_java.ListeTerminal;
import com.stage.projet.client.classe_java.PlageAdresse;
import com.stage.projet.client.classe_java.Terminal;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.Hyperlink;

public class adresses_dispo extends Composite implements HasText {

	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private static adresses_dispoUiBinder uiBinder = GWT
			.create(adresses_dispoUiBinder.class);
	private Vector<AdresseIp> liste_ip= new Vector<AdresseIp>();
	@UiField FlexTable table_plage;
	@UiField FlexTable table_ip;
	@UiField TextBox adresse_selectione;
	@UiField ListBox mes_terminaux;
	//@UiField Button valider_affectation;
	@UiField DateBox date_debut ;
	@UiField DateBox date_fin;
	//mes_terminaux;
	@UiField Button valider_affectation;
	@UiField TextBox adresse_selectione2;
	@UiField TextBox adresse_selectione3;
	//@UiField TextBox adresse_selectione4;
	@UiField TextBox adresse_selectione5;
	@UiField Button MesAdresses;
	@UiField Hyperlink Deconnexion;
	@UiField Label MonNom;
	static public int id_plage;

	interface adresses_dispoUiBinder extends UiBinder<Widget, adresses_dispo> {
	}

	public adresses_dispo() {
		initWidget(uiBinder.createAndBindUi(this));
		charger_plage();
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

	@SuppressWarnings("unchecked")
	public void charger_plage()
	{
		 greetingService.MesPlages(new AsyncCallback()
			{

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("failed");
				}

				@Override
				public void onSuccess(Object result) {
					// TODO Auto-generated method stub
					final ListePlage		ma_liste=(ListePlage)result;
					table_plage.addStyleName("tweetsTable");
					table_plage.setText(0,0,"adresse du reseau");
					table_plage.setText(0,1,"masque du reseau");
					table_plage.setText(0,2,"options");
					table_plage.getRowFormatter().addStyleName(0, "tweetsTableHeader");

					Vector<Button> butt_tab=new Vector();
					final ClickHandler affichage_affectation_voulu=	new ClickHandler() {
					    public void onClick(ClickEvent event) {
					    	Widget sender = (Widget) event.getSource();
					    	String title=sender.getTitle();
					    	table_ip.setVisible(false);
					    	final int num=Integer.parseInt(title);
					    	adresse_selectione.setText(""+liste_ip.get(num).getChamp1());
					    	adresse_selectione2.setText(""+liste_ip.get(num).getChamp2());
					    	adresse_selectione3.setText(""+liste_ip.get(num).getChamp3());
					    	adresse_selectione5.setText(""+liste_ip.get(num).getChamp4());
					    	valider_affectation.setTitle(""+num);	 
					    	greetingService.MesTerminal(Integer.parseInt(Cookies.getCookie("idutilisateur")),new AsyncCallback()
								{

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}

									@Override
									public void onSuccess(Object result) {
					    	ListeTerminal l_t=(ListeTerminal) result;
					    	for(int i=0;i<l_t.getListe().size();i++)
					    	{mes_terminaux.addItem(""+l_t.getListe().get(i).getNomTerminal(),""+l_t.getListe().get(i).getIdTerminal());
					    		}
					    	}
					    });
					    }};
					ClickHandler afficher_plage=	new ClickHandler() {
					    public void onClick(ClickEvent event) {
					    	
					    	Widget sender = (Widget) event.getSource();
					    	String title=sender.getTitle();
					    	final int num=Integer.parseInt(title);
					    //	ma_grid.setVisible(false);
					    	//ajouter_terminale_grid.setVisible(false);
					    	//ma_grid_mod.setVisible(true);
					    	//nom_terminal.setText( liste_uti.getTerminal(num).getNomTerminal());
					    	//modifier_b.setTitle(""+num);
					    	PlageAdresse plage_adresse=new PlageAdresse();
					    	id_plage=ma_liste.getPlage(num).getIdPlage();
							 greetingService.adresse_a_afficher(ma_liste.getPlage(num),new AsyncCallback()
								{

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									}

									@Override
									public void onSuccess(Object result) {
										// TODO Auto-generated method stub
										table_ip.setVisible(true);
										table_ip.removeAllRows();
										
									Vector<AdresseIp> ma_liste_a_afficher=(Vector<AdresseIp>) result;
									liste_ip=ma_liste_a_afficher;
									table_ip.addStyleName("tweetsTable");
									table_ip.setText(0, 0, "adresse");
									table_ip.setText(0, 1, "options");
									table_ip.getRowFormatter().addStyleName(0, "tweetsTableHeader");

									//table_ip.setText(1, 0, "med is here");
									for(int i=0;i<ma_liste_a_afficher.size();i++)
										{Button x_affecter_a_un_terminal=new Button();
										x_affecter_a_un_terminal.setText("affecter a un terminal");
										table_ip.setText(i+1, 0, ""+ma_liste_a_afficher.get(i).toString());
										x_affecter_a_un_terminal.setTitle(""+i);
										x_affecter_a_un_terminal.addClickHandler(affichage_affectation_voulu);
										table_ip.setWidget(i+1, 1, x_affecter_a_un_terminal);
										}
									}});
					    }
					  };
				
					for(int i=0;i<ma_liste.getListe().size();i++)
					{	Button x = new Button("afficher ");
						x.setTitle(""+i);
						x.addClickHandler(afficher_plage);
						table_plage.setText(i+1, 0, ""+ma_liste.getPlage(i).getChamp1AdReseau()+"-"+ma_liste.getPlage(i).getChamp2AdReseau()+"-"+ma_liste.getPlage(i).getChamp3AdReseau()+"-"+ma_liste.getPlage(i).getChamp4AdReseau());
						table_plage.setText(i+1, 1, ""+ma_liste.getPlage(i).getChamp1masque()+"-"+ma_liste.getPlage(i).getChamp2masque()+"-"+ma_liste.getPlage(i).getChamp3masque()+"-"+ma_liste.getPlage(i).getChamp4masque());
						table_plage.setWidget(i+1, 2, x);
					}
					
					
				}
			});
			
		
	}


	@UiHandler("valider_affectation")
	void onValider_affectationClick(ClickEvent event) {
		
	Affectation af=new Affectation();
	
	af.setDateFin(date_fin.getValue());
 af.setDateDebut(date_debut.getValue());
	Terminal t=new Terminal();
	AdresseIp a=new AdresseIp();
	//af.adresseIp.setIdAdresse(Integer.parseInt(valider_affectation.getTitle()));
	a.setIdplage(id_plage);
	a.setChamp1(Integer.parseInt(adresse_selectione.getText()));
	a.setChamp2(Integer.parseInt(adresse_selectione2.getText()));
	a.setChamp3(Integer.parseInt(adresse_selectione3.getText()));
	a.setChamp4(Integer.parseInt(adresse_selectione5.getText()));
	a.setIdAdresse(Integer.parseInt(valider_affectation.getTitle()));
	t.setIdTerminal(Integer.parseInt(mes_terminaux.getValue(mes_terminaux.getSelectedIndex())));
	af.setTerminal(t);
	af.setAdresseIp(a);
	
	 greetingService.ajouter_affectation(af,new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				Window.alert("l affectation s est deroule avec succes");
				
			}});
	 
	 
	 RootPanel.get().clear();
		adresses_dispo p_a=new adresses_dispo();
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
