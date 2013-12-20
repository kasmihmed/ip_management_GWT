package com.stage.projet.client;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.stage.projet.client.classe_java.*;;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String djaja) throws IllegalArgumentException;
	String ajouterutilisateur(Utilisateur uti) throws IllegalArgumentException;
	String ajouter_plage(PlageAdresse plage) throws IllegalArgumentException;
	ListePlage MesPlages() throws IllegalArgumentException;
	String supprimer_plage(int id_a_supprimer)throws IllegalArgumentException;
	 ListeUtilisateur MesUtilisateur(int id) throws IllegalArgumentException;
	 String modifier_utilisateur(Utilisateur uti) throws IllegalArgumentException;
	 String supprimer_utilisateur(int id_a_supprimer) throws IllegalArgumentException;
	 Utilisateur connexion_acceuil(Authentification auth)throws IllegalArgumentException;
	ListeTerminal MesTerminal(int iduti) throws IllegalArgumentException;
	String modifier_terminal(Terminal uti) throws IllegalArgumentException;
	String supprimer_terminal(int id_a_supprimer)throws IllegalArgumentException;
	String ajouter_terminal(Terminal terminal)throws IllegalArgumentException;
	Vector<AdresseIp> adresse_a_afficher(PlageAdresse p_a)throws IllegalArgumentException;
	AdresseIp ajouter_affectation(Affectation affectation)throws IllegalArgumentException;
    ListeAdresse AdresseU(int idUtilisateur)throws IllegalArgumentException;
    String Supprimer_Affectation(int idAffectation)throws IllegalArgumentException;
    String Modifier_Affectation(int idAffectation,Date DateFin)throws IllegalArgumentException;
    ListeAdresse Afficher_Historique()throws IllegalArgumentException;
    ListeAdresse Afficher_Affectation_EnCours()throws IllegalArgumentException;
    ListeAdresse Rechercher_Affectation_EnCours(String nomU,String prenomU,String nomM,String DD,String DF,String champ1,String champ2,String champ3,String champ4)throws IllegalArgumentException;
    ListeAdresse Recherche_Historique_Affectation(String nomU,String prenomU,String nomM,String champ1,String champ2,String champ3,String champ4)throws IllegalArgumentException;
    Utilisateur MonProfil(int idUtilisateur)throws IllegalArgumentException;
    String ModifierMonProfil(Utilisateur uti) throws IllegalArgumentException;

}
