package com.stage.projet.client;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.stage.projet.client.classe_java.*;;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String djaja, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void ajouterutilisateur(Utilisateur uti, AsyncCallback<String> callback);

	void ajouter_plage(PlageAdresse plage, AsyncCallback<String> callback);

	void MesPlages(AsyncCallback<ListePlage> callback);

	void supprimer_plage(int id_a_supprimer, AsyncCallback<String> callback);

	void MesUtilisateur(int id,AsyncCallback<ListeUtilisateur> callback);

	void modifier_utilisateur(Utilisateur uti, AsyncCallback<String> callback);

	void supprimer_utilisateur(int id_a_supprimer,
			AsyncCallback<String> callback);

	void connexion_acceuil(Authentification auth,
			AsyncCallback<Utilisateur> callback);

	void MesTerminal(int iduti, AsyncCallback<ListeTerminal> callback);

	void modifier_terminal(Terminal uti, AsyncCallback<String> callback);

	void supprimer_terminal(int id_a_supprimer, AsyncCallback<String> callback);

	void ajouter_terminal(Terminal terminal, AsyncCallback<String> callback);

	void adresse_a_afficher(PlageAdresse p_a,
			AsyncCallback<Vector<AdresseIp>> callback);

	void ajouter_affectation(Affectation affectation,
			AsyncCallback<AdresseIp> callback);

	void AdresseU(int idUtilisateur, AsyncCallback<ListeAdresse> callback);

	void Supprimer_Affectation(int idAffectation, AsyncCallback<String> callback);

	void Modifier_Affectation(int idAffectation, Date DateFin,
			AsyncCallback<String> callback);

	void Afficher_Historique(AsyncCallback<ListeAdresse> callback);

	void Afficher_Affectation_EnCours(AsyncCallback<ListeAdresse> callback);

	void Rechercher_Affectation_EnCours(String nomU, String prenomU,
			String nomM, String DD, String DF, String champ1, String champ2, String champ3,
			String champ4, AsyncCallback<ListeAdresse> callback);

	void Recherche_Historique_Affectation(String nomU, String prenomU,
			String nomM, String champ1, String champ2, String champ3,
			String champ4, AsyncCallback<ListeAdresse> callback);

	void MonProfil(int idUtilisateur, AsyncCallback<Utilisateur> callback);

	void ModifierMonProfil(Utilisateur uti, AsyncCallback<String> callback);

	

	

	

	





}
