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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.stage.projet.client.classe_java.ListePlage;

public class supprimer_une_plage extends Composite implements HasText {
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private static supprimer_une_plageUiBinder uiBinder = GWT
			.create(supprimer_une_plageUiBinder.class);

	interface supprimer_une_plageUiBinder extends
			UiBinder<Widget, supprimer_une_plage> {
	}

	public supprimer_une_plage() {
		initWidget(uiBinder.createAndBindUi(this));
		charger_tableau_plage();
		MonNom.setText("Vous etes :"+Cookies.getCookie("nomutilisateur")+"   "+Cookies.getCookie("prenomutilisateur"));
	}

	public void charger_tableau_plage()
	{
		AsyncCallback<ListePlage> callback;
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
				//Column<ListePlageIP, ?> X=(Column<ListePlageIP, ?>)result;
				//dataGrid.addColumn(X);
				
				//=new DataGrid<String>("Bonjour");
				
				ClickHandler click_hand=	new ClickHandler() {
				    public void onClick(ClickEvent event) {
				    	
				    	Widget sender = (Widget) event.getSource();
				    	//sender.getTitle()
				      greetingService.supprimer_plage(Integer.parseInt(sender.getTitle()), new AsyncCallback()
						{@Override
							public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("failed");
						}

						@Override
						public void onSuccess(Object result) {Window.alert("suppression avec succes");
						ma_table.removeAllRows();
						charger_tableau_plage();
						}}
							// TODO Au}
);
				    	// handle the click event
				    }
				  };
				ListePlage X=(ListePlage)result;
				ma_table.addStyleName("tweetsTable");
				ma_table.setText(0, 0, "id");ma_table.setText(0, 1, "adresse reseau");ma_table.setText(0, 2, "masque");
				ma_table.getRowFormatter().addStyleName(0, "tweetsTableHeader");
				int n=X.getListe().size();
				Vector<Button> butt_tab=new Vector();
				for(int i=0;i<n;i++)
				{Button x = new Button("supprimer");
				x.setTitle(""+X.getPlage(i).getIdPlage());
				x.addClickHandler(click_hand);
				butt_tab.add(x);
					ma_table.setText(i+1, 0, "////");
					ma_table.setText(i+1, 1, X.getPlage(i).getChamp1AdReseau()+"."+X.getPlage(i).getChamp2AdReseau()+"."+X.getPlage(i).getChamp3AdReseau()+"."+X.getPlage(i).getChamp4AdReseau());
					ma_table.setText(i+1, 2, X.getPlage(i).getChamp1masque()+"."+X.getPlage(i).getChamp2masque()+"."+X.getPlage(i).getChamp3masque()+"."+X.getPlage(i).getChamp4masque());
					ma_table.setWidget(i+1, 3, butt_tab.get(i));
				}
				
				
				
				//Window.alert("success"+X.getPlage(1).getChamp1plage()+"."+X.getPlage(1).getChamp2plage()+"."+X.getPlage(1).getChamp3plage()+"."+X.getPlage(1).getChamp4plage());
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
	@UiField FlexTable ma_table;
	@UiField Label MonNom;

	public supprimer_une_plage(String firstName) {
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
	
	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
		
		
		
		 page_connexion	m_uti= new page_connexion();
		 
			//RootPanel.get().removeFromParent();
			RootPanel.get().clear();
			RootPanel.get().add(m_uti);
		
		
	}
}
