package com.stage.projet.client.typeutilisateur;


import java.text.ParseException;
import java.util.Date;

import com.gargoylesoftware.htmlunit.util.Cookie;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.stage.projet.client.GreetingService;
import com.stage.projet.client.GreetingServiceAsync;
import com.stage.projet.client.page_connexion;
import com.stage.projet.client.classe_java.ListeAdresse;
import com.stage.projet.server.GreetingServiceImpl;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.ibm.icu.text.SimpleDateFormat;

public class PageMesAdresses extends Composite implements HasText {

	private static PageMesAdressesUiBinder uiBinder = GWT
			.create(PageMesAdressesUiBinder.class);
	
	@UiField FlexTable MaFlexTable;
	@UiField VerticalPanel PanneauModifDate;
	@UiField TextBox NomMachine;
	@UiField TextBox AdresseAff;
	@UiField DateBox DateFin;
	@UiField TextBox DateD;
	@UiField Button BModif;
	@UiField Button MesAdresses;
	@UiField Label MonNom;
	int[] idAff=new int[50];
	
	static ListeAdresse X=new ListeAdresse();
	
	
	
	
	
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	
	
	

	interface PageMesAdressesUiBinder extends UiBinder<Widget, PageMesAdresses> {
	}
	
	
	
	
	
	ClickHandler Supprimer_Aff=	new ClickHandler() {
	    public void onClick(ClickEvent event) {
	    	
	    	Widget sender = (Widget) event.getSource();
	    	String title=sender.getTitle();
	    	final int num=Integer.parseInt(title);
	    	
	    	//Window.alert("bon Clik");
	    	
	    	greetingService.Supprimer_Affectation(num,new AsyncCallback()
			{

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(Object result) {
					Window.alert("Supprimé");
					
				//	PageMesAdresses P=new PageMesAdresses();
				//	RootPanel.get().add(P);
					
					MaFlexTable.removeAllRows();
					
					
					
					
					
					int idUtilisateur=Integer.parseInt(Cookies.getCookie("idutilisateur"));
					//AsyncCallback ASC=;
					greetingService.AdresseU(idUtilisateur,  new AsyncCallback()
					{

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("failed");
						}

						@Override
						public void onSuccess(Object result) {
							
							
							
							
							
							
							
							
							
							
							
							
									X=(ListeAdresse) result;
							MaFlexTable.setText(0, 0, "Nom Machine");
							MaFlexTable.setText(0, 1, "Adresse IP");
							MaFlexTable.setText(0, 2, "Date Debut");
							MaFlexTable.setText(0, 3, "Date Fin");

							for(int i=0;i<X.getV().size();i++)
							{
								MaFlexTable.setText(i+1, 0, X.getV().get(i).getNomMachine());
								MaFlexTable.setText(i+1, 1 , X.getV().get(i).getChamp1()+"."+X.getV().get(i).getChamp2()+"."+X.getV().get(i).getChamp3()+"."+X.getV().get(i).getChamp4());
								MaFlexTable.setText(i+1, 2, X.getV().get(i).getDD().toString());
								MaFlexTable.setText(i+1, 3, X.getV().get(i).getDF().toString());
								
								
								Button Modifier_Affectation=new Button("Modifier");
								Button Supprimer_Affectation=new Button("Liberer Adresse");
								int h=X.getV().get(i).getIdPeriode();
								Supprimer_Affectation.setTitle(""+h);
								int k=i+1;
								Modifier_Affectation.setTitle(""+k);
								Supprimer_Affectation.addClickHandler(Supprimer_Aff);
								MaFlexTable.setWidget(i+1, 4, Modifier_Affectation);
								MaFlexTable.setWidget(i+1, 5, Supprimer_Affectation);
							}
							
							
							
							
							
							// TODO Auto-generated method stub
							//Window.alert("success"+result);
						}
						
					});
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}});
	    	
	    	
	    }
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	ClickHandler Modifier_Aff=	new ClickHandler() {
	    public void onClick(ClickEvent event) {
	    	
	    	Widget sender = (Widget) event.getSource();
	    	String title=sender.getTitle();
	    	//char t=title.charAt(1);
	    	//int n=(int) t;
	    	//int x= Integer.parseInt(title.valueOf(1));
	    	
	    	
	    	
	    	
	    	 
	    	//String num1=""+title.charAt(0);
	    	//String num2=""+title.charAt(1);
	    	int num=Integer.parseInt(title);
	    	//int pos=Integer.parseInt(num2);
	    	PanneauModifDate.setVisible(true);	
	    	
	    	int id=idAff[num];
	    	
	    	NomMachine.setEnabled(false);		
	    	AdresseAff.setEnabled(false);
	    	DateD.setEnabled(false);
					
					
					
				NomMachine.setText(MaFlexTable.getText(num , 0));
				AdresseAff.setText(MaFlexTable.getText(num , 1));
				DateD.setText(MaFlexTable.getText(num , 2));
				
				
				
				//int h=X.getV().get(num-1).getIdPeriode();
				BModif.setTitle(""+id);
				
				
				
				
	    	
	    }
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public PageMesAdresses() {
		initWidget(uiBinder.createAndBindUi(this));
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
		
		
		PanneauModifDate.setVisible(false);
		
		
		int idUtilisateur=Integer.parseInt(Cookies.getCookie("idutilisateur"));
		//AsyncCallback ASC=;
		greetingService.AdresseU(idUtilisateur,  new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("failed");
			}

			@Override
			public void onSuccess(Object result) {
				
				
				
				
				
				
				
				
				
				
				
				ListeAdresse X=new ListeAdresse();

						X=(ListeAdresse) result;
						MaFlexTable.addStyleName("tweetsTable");

						MaFlexTable.setText(0, 0, "NomMachine");
						MaFlexTable.setText(0, 1, "Adresse IP");
						MaFlexTable.setText(0, 2, "Date Debut");
						MaFlexTable.setText(0, 3, "Date Fin");
						MaFlexTable.setText(0, 4, "option 1");
						MaFlexTable.setText(0, 5, "option 2");

						MaFlexTable.getRowFormatter().addStyleName(0, "tweetsTableHeader");

						for(int i=0;i<X.getV().size();i++)
				{
					MaFlexTable.setText(i+1, 0, X.getV().get(i).getNomMachine());
					MaFlexTable.setText(i+1, 1 , X.getV().get(i).getChamp1()+"."+X.getV().get(i).getChamp2()+"."+X.getV().get(i).getChamp3()+"."+X.getV().get(i).getChamp4());
					MaFlexTable.setText(i+1, 2, X.getV().get(i).getDD().toString());
					MaFlexTable.setText(i+1, 3, X.getV().get(i).getDF().toString());
					
					//idAff[i]=X.getV().get(i).getIdPeriode();
					
					Button Modifier_Affectation=new Button("Modifier");
					Button Supprimer_Affectation=new Button("Liberer Adresse");
					int h=X.getV().get(i).getIdPeriode();
					//BnonVisible.setText(""+h);
					Supprimer_Affectation.setTitle(""+h);
					int k=i+1;
					Modifier_Affectation.setTitle(""+k);
					
					idAff[k]=X.getV().get(i).getIdPeriode();
					
					Supprimer_Affectation.addClickHandler(Supprimer_Aff);
					Modifier_Affectation.addClickHandler(Modifier_Aff);
					MaFlexTable.setWidget(i+1, 4, Modifier_Affectation);
					MaFlexTable.setWidget(i+1, 5, Supprimer_Affectation);
					
				}
				
				
				
				
				
				// TODO Auto-generated method stub
				//Window.alert("success"+result);
			}
			
		});
				
		
		
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

	

	@UiHandler("BModif")
	void onBModifClick(ClickEvent event) {
		
		int n=Integer.parseInt(BModif.getTitle());
		
		
		
		
		greetingService.Modifier_Affectation(n, DateFin.getValue(), new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("failed");
			}

			@Override
			public void onSuccess(Object result) {
				
				
				
				
				
				
				
				
				
				
				
				
				
				PanneauModifDate.setVisible(false);
				
				
				int idUtilisateur=Integer.parseInt(Cookies.getCookie("idutilisateur"));
				//AsyncCallback ASC=;
				greetingService.AdresseU(idUtilisateur,  new AsyncCallback()
				{

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("failed");
					}

					@Override
					public void onSuccess(Object result) {
						
						
						
						
						
						
						
						
						
						
						
						ListeAdresse X=new ListeAdresse();
								X=(ListeAdresse) result;
						MaFlexTable.setText(0, 0, "NomMachine");MaFlexTable.setText(0, 1, "Adresse IP");MaFlexTable.setText(0, 2, "Date Debut");MaFlexTable.setText(0, 3, "Date Fin");
						for(int i=0;i<X.getV().size();i++)
						{
							MaFlexTable.setText(i+1, 0, X.getV().get(i).getNomMachine());
							MaFlexTable.setText(i+1, 1 , X.getV().get(i).getChamp1()+"."+X.getV().get(i).getChamp2()+"."+X.getV().get(i).getChamp3()+"."+X.getV().get(i).getChamp4());
							MaFlexTable.setText(i+1, 2, X.getV().get(i).getDD().toString());
							MaFlexTable.setText(i+1, 3, X.getV().get(i).getDF().toString());
							
							
							
							Button Modifier_Affectation=new Button("Modifier");
							Button Supprimer_Affectation=new Button("Liberer");
							int h=X.getV().get(i).getIdPeriode();
							//BnonVisible.setText(""+h);
							Supprimer_Affectation.setTitle(""+h);
							int k=i+1;
							Modifier_Affectation.setTitle(""+k);
							
							Supprimer_Affectation.addClickHandler(Supprimer_Aff);
							Modifier_Affectation.addClickHandler(Modifier_Aff);
							MaFlexTable.setWidget(i+1, 4, Modifier_Affectation);
							MaFlexTable.setWidget(i+1, 5, Supprimer_Affectation);
							
						}
						
						
						
						
						
						// TODO Auto-generated method stub
						//Window.alert("success"+result);
					}
					
				});
				
				
				
				
				
				
			}});
		
		
		
		
		
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
