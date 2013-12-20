package com.stage.projet.server;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.jar.JarEntry;

import com.stage.projet.client.GreetingService;
import com.stage.projet.client.classe_java.*;
import com.stage.projet.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String djaja) throws IllegalArgumentException {

		//Gestion_Utilisateur.ajouter_utilisateur_bd(utilisateur);
		return "success" ;
	}

	public Connection connect_to_db() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		 Connection con=null; 
		String host          = "mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/";
         String db           = "jbossews";
         String driver       = "com.mysql.jdbc.Driver";
         String user         = "adminWWdIpcA";
         String pass         = "Q5cSMzFzY6Ld";

         Class.forName(driver).newInstance();
         con = DriverManager.getConnection("jdbc:"+host+"/"+db, user, pass);
 
      
    	return con;
		
	}
	public String ajouterutilisateur(Utilisateur uti) throws IllegalArgumentException 
	{
		//Gestion_Utilisateur.ajouter_utilisateur_bd(utilisateur);
		//System.out.println("this rpc is working");
		ajouter_utilisateur_bd((Utilisateur)uti);
		return "Uti a été recu avec succes --Non: "+uti.getNomUtilisateur()+" prenom : "+uti.getPrenomUtilisateur();
		
	}
	public String ajouter_plage(PlageAdresse plage)throws IllegalArgumentException 
	{
		ajouter_plage_bd(plage);
		return "la plage a ete ajoute avec succes";
	
		
	}

	
	private void ajouter_utilisateur_bd(Utilisateur uti) {
		// TODO Auto-generated method stub
		 Connection con=null; 
		        try
		        {
		        	
		            con = connect_to_db() ;
		    
		          //  String query = "INSERT INTO employe  VALUES ("+17+")";
		            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
					String query ="INSERT INTO utilisateur( emailUtilisateur,loginUtilisateur,matUtilisateur,mdpUtilisateur,nomUtilisateur,prenomUtilisateur,telephoneUtilisateur,typeUtilisateur,flag_supp) VALUES('"+uti.getEmailUtilisateur()+"','"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+",0)";
		       	 Connection conn = con;
				 Statement update = conn.createStatement();
				 update.executeUpdate(query);
	
				 conn.close(); 
		        }
		        catch(Exception ex)
		        {
		            System.out.println( ex.toString());
		        }
        
		        
	}


	private void ajouter_plage_bd(PlageAdresse plage)
	{
		 Connection con=null; 
	        try
	        {
	            
	            con = connect_to_db();
	    
	       	String query ="INSERT INTO plageadresse (`champ1AdReseau`,`champ2AdReseau`,`champ3AdReseau`,`champ4AdReseau`,`champ1masque`,`champ2masque`,`champ3masque`,`champ4masque`,`flag_supp`) VALUES("+plage.getChamp1AdReseau()+","+plage.getChamp2AdReseau()+","+plage.getChamp3AdReseau()+","+plage.getChamp4AdReseau()+","+plage.getChamp1masque()+","+plage.getChamp2masque()+","+plage.getChamp3masque()+","+plage.getChamp4masque()+","+0+")";
	       	 Connection conn = con;
			 Statement update = conn.createStatement();
			 update.executeUpdate(query);
			 
		 conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
 	
		
	}
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}


	@Override
	public ListePlage MesPlages() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		
		int idPlage,ad1r,ad2r,ad3r,ad4r,ad1m,ad2m,ad3m,ad4m;
		ListePlage L=new ListePlage();
		
		
		 Connection con=null; 
	        try
	        {
	        	
	            con = connect_to_db();
	    
	         	 Connection conn = con;
			 Statement stm = conn.createStatement();
			String requete="select * from plageadresse where flag_supp=0";
			ResultSet rs=stm.executeQuery(requete);
			
			while(rs.next())
			{
				
				idPlage=rs.getInt(1);
				ad1r=rs.getInt(2);ad2r=rs.getInt(3);ad3r=rs.getInt(4);ad4r=rs.getInt(5);
				ad1m=rs.getInt(6);ad2m=rs.getInt(7);ad3m=rs.getInt(8);ad4m=rs.getInt(9);
				
				rs.getInt(10);
				
				
				PlageAdresse P=new PlageAdresse(idPlage,ad1r,ad2r,ad3r,ad4r,ad1m,ad2m,ad3m,ad4m);
				L.AjouterPlage(P);
			}
			
			conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
		
		
		
		
		
		return L;
	}
	@Override
	public ListeUtilisateur MesUtilisateur(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		
		int idUtilisateur,type;
		String nom,prenom,email,mat,login,mdp,telephone;
		
		ListeUtilisateur L=new ListeUtilisateur();
		
		
		 try
	        {
	        	
		    
		         	 Connection conn = connect_to_db();
				 Statement stm = conn.createStatement();
			String requete="select * from utilisateur where flag_supp=0 and idUtilisateur!="+id;
			ResultSet rs=stm.executeQuery(requete);
			
			while(rs.next())
			{
				idUtilisateur=rs.getInt(1);
				nom=rs.getString(2);
				prenom=rs.getString(3);
				email=rs.getString(4);
				mat=rs.getString(5);
				login=rs.getString(6);
				mdp=rs.getString(7);
				type=rs.getInt(8); //int
				telephone=rs.getString(9);
				rs.getInt(10);
			
								
				
				Utilisateur P=new Utilisateur(idUtilisateur,nom,prenom,email,mat,login,mdp,type,telephone);
				L.addUtilisateur(P);
			}
			
			conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
		
		
		
		
		
		return L;
	}

	@Override
	public String supprimer_plage(int id_a_supprimer) throws IllegalArgumentException {
		
		 Connection con=null; 
	        try
	        {
	           
	            con = connect_to_db();
	    
	          //  String query = "INSERT INTO employe  VALUES ("+17+")";
	            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
				String query ="update plageadresse set flag_supp=1 where idplage="+id_a_supprimer;
	       	 Connection conn = con;
			 Statement update = conn.createStatement();
			 update.executeUpdate(query);
			 
			 //get last id 
		/*	 ResultSet result = update.getGeneratedKeys(); 
			 if (result != null && result.next()) { 
			     int rsId = result.getInt(1); 
	        }
			 result.close();
			 update.close();*/
			 conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
			return "success";
 
	}
	@Override
	public String supprimer_utilisateur(int id_a_supprimer) throws IllegalArgumentException {
		
		 Connection con=null; 
	        try
	        {
	            
	            con = connect_to_db();
	    
	          //  String query = "INSERT INTO employe  VALUES ("+17+")";
	            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
				String query ="update utilisateur set flag_supp=1 where idutilisateur="+id_a_supprimer;
	       	 Connection conn = con;
			 Statement update = conn.createStatement();
			 update.executeUpdate(query);
			 
			 //get last id 
		/*	 ResultSet result = update.getGeneratedKeys(); 
			 if (result != null && result.next()) { 
			     int rsId = result.getInt(1); 
	        }
			 result.close();
			 update.close();*/
			 conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
			return "success";

	}
	public String modifier_utilisateur(Utilisateur uti) throws IllegalArgumentException{
		Connection con=null; 
        try
        {
           
            con = connect_to_db();
    
         	String query ="update utilisateur set nomutilisateur='"+uti.getNomUtilisateur()+"' , prenomutilisateur='"+uti.getPrenomUtilisateur()+"' , emailutilisateur='"+uti.getEmailUtilisateur()+"' , matutilisateur='"+uti.getMatUtilisateur()+"' , loginutilisateur='"+uti.getLoginUtilisateur()+"' , mdputilisateur='"+uti.getMdpUtilisateur()+"',telephoneutilisateur='"+uti.getTelephoneUtilisateur()+"', typeUtilisateur='"+uti.getTypeUtilisateur()+"' where idutilisateur="+uti.getIdUtilisateur()+";";
       	 Connection conn = con;
		 Statement update = conn.createStatement();
		 update.executeUpdate(query);
		 
			 conn.close(); 
        }
        catch(Exception ex)
        {
            System.out.println( ex.toString());
        }
		return "success";

}

		
	public Utilisateur connexion_acceuil(Authentification auth)throws IllegalArgumentException
	{//ici on chercher si cet utilisateur existe dans la base de donnée et avoir son type
		Utilisateur uti=new Utilisateur();
		Connection con=null; 
		int flag=0;
		int result =0;		

		try
        {
           
            con = connect_to_db();
    
          //  String query = "INSERT INTO employe  VALUES ("+17+")";
            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
			String requete ="select * from utilisateur where loginutilisateur like'"+auth.getLogin()+"' and mdputilisateur like '"+auth.getMdp()+"';";
       	 Connection conn = con;
		 Statement update = conn.createStatement();
	ResultSet rs=update.executeQuery(requete);
			while(rs.next())
			{         result ++;

			uti.setIdUtilisateur(rs.getInt(1));
			uti.setNomUtilisateur(rs.getString(2))	;
				uti.setPrenomUtilisateur(rs.getString(3)) ;
			uti.setEmailUtilisateur(rs.getString(4));
			uti.setMatUtilisateur(rs.getString(5));
			uti.setLoginUtilisateur(rs.getString(6));
				rs.getString(7);
			uti.setTypeUtilisateur(rs.getInt(8)); //int
			uti.setTelephoneUtilisateur(rs.getString(9));
			flag=rs.getInt(10);				
			}		 

		 conn.close(); 
        }
        catch(Exception ex)
        {
            System.out.println( ex.toString());
        }
        
        if(result==0)
        uti.setIdUtilisateur(-1);
        else if(flag==1)
        uti.setIdUtilisateur(-2);
       
        
		return uti;
	}

	public ListeTerminal MesTerminal(int idutilisateur1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		
		int idUtilisateur,idterminal;
		String nom;
		
		ListeTerminal L=new ListeTerminal();
		ListeTerminal M=new ListeTerminal();
		
		 Connection con=null; 
	        try
	        {
	        	 
	            con = connect_to_db();
	    
	         	 Connection conn = con;
			 Statement stm = conn.createStatement();
			 
			String requete="select * from terminal where idutilisateur="+idutilisateur1+" and flag_supp=0;";
			ResultSet rs=stm.executeQuery(requete);
			
			while(rs.next())
			{
				idterminal=rs.getInt(1);
				idUtilisateur=rs.getInt(2);
				nom=rs.getString(3);
				rs.getInt(4);
								
				
				Terminal T=new Terminal(idterminal,idUtilisateur,nom);
				L.addTerminal(T);
			}
			
			
			
			
			
			String maReq="select t.nomMachine from terminal t,affectation af where   t.idutilisateur="+idutilisateur1+" and t.flag_supp=0 and t.idterminal=af.idTerminal  and af.etat=0 and curdate() >= af.dateDebut and curdate()<= af.dateFin  ;";
		    rs=stm.executeQuery(maReq);
		       
			ListeTerminal X=new ListeTerminal();
		    while(rs.next())
			{
				String NomMa=rs.getString(1);
				
				Terminal T=new Terminal();
				T.setNomTerminal(NomMa);
				L.addTerminal(T);
				X.addTerminal(T);
			}
			
			
		    int indice=0;
		    
		    for(int i=0;i<L.getListe().size();i++)
		    {
		    	indice=0;
		    	
		    	for(int j=0;j<X.getListe().size();j++)
		    	{
		    		if(X.getListe().get(j).getNomTerminal().equals(L.getListe().get(i).getNomTerminal()))
		    			indice=1;
		    	}
		    	
		    	if(indice==0)
		    	{
		    		
		    		M.addTerminal(L.getListe().get(i));
		    		
		    	}
		    	
		    }
		    
		    
			conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
		
	        
	        
	       
		
		return M;
		
		//return L;
	}	
	public String modifier_terminal(Terminal uti) throws IllegalArgumentException{
		Connection con=null; 
        try
        {
        	 
            con = connect_to_db();
    
          //  String query = "INSERT INTO employe  VALUES ("+17+")";
            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
			String query ="update terminal set nommachine ='"+uti.getNomTerminal()+"'  where idterminal="+uti.getIdTerminal();
       	 Connection conn = con;
		 Statement update = conn.createStatement();
		 update.executeUpdate(query);
		 
		 //get last id 
	/*	 ResultSet result = update.getGeneratedKeys(); 
		 if (result != null && result.next()) { 
		     int rsId = result.getInt(1); 
        }
		 result.close();
		 update.close();*/
		 conn.close(); 
        }
        catch(Exception ex)
        {
            System.out.println( ex.toString());
        }
		return "success";

}

	@Override
	public String supprimer_terminal(int id_a_supprimer) throws IllegalArgumentException {
		
		 Connection con=null; 
	        try
	        {
	            con = connect_to_db();
	    
	          //  String query = "INSERT INTO employe  VALUES ("+17+")";
	            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
				String query ="update terminal set flag_supp=1 where idterminal="+id_a_supprimer+";";
	       	 Connection conn = con;
			 Statement update = conn.createStatement();
			 update.executeUpdate(query);
			 
			 conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
			return ""+id_a_supprimer;
 
	}
	public String ajouter_terminal(Terminal terminal)throws IllegalArgumentException{
		
		Connection con=null; 
        try
        {
        	  
            con = connect_to_db();
    
          //  String query = "INSERT INTO employe  VALUES ("+17+")";
            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
			String query ="INSERT INTO terminal (`idUtilisateur`,`nomMachine`,`flag_supp`) VALUES("+terminal.getIdUtilisateur()+",'"+terminal.getNomTerminal()+"',0);";
       	 Connection conn = con;
		 Statement update = conn.createStatement();
		 update.executeUpdate(query);
		 
		 //get last id 
	/*	 ResultSet result = update.getGeneratedKeys(); 
		 if (result != null && result.next()) { 
		     int rsId = result.getInt(1); 
        }
		 result.close();
		 update.close();*/
		 conn.close(); 
        }
        catch(Exception ex)
        {
            System.out.println( ex.toString());
        }
		return "success";
	}
	
	public Vector<AdresseIp> transform(AdresseIp ipadresse , AdresseIp  masqueadresse)
	{
		Vector<AdresseIp> mesadresse=new Vector() ;
		for(int i=0;i<255-masqueadresse.getChamp1()+1;i++)
		{	
			for(int j=0;j<255-masqueadresse.getChamp2()+1;j++)
			{	
				for(int k=0;k<255-masqueadresse.getChamp3()+1;k++)
				{
					for(int l=0;l<255-masqueadresse.getChamp4()+1;l++)
					{AdresseIp mon_adresse=new AdresseIp();
						//mon_adresse.setIdAdresse(idAdresse);
						mon_adresse.setChamp1(ipadresse.getChamp1()+i);
						mon_adresse.setChamp2(ipadresse.getChamp2()+j);
						mon_adresse.setChamp3(ipadresse.getChamp3()+k);
						mon_adresse.setChamp4(ipadresse.getChamp4()+l);
						mesadresse.add(mon_adresse);
						//System.out.println(""+mon_adresse.getChamp1()+"-"+mon_adresse.getChamp2()+"-"+mon_adresse.getChamp3()+"-"+mon_adresse.getChamp4());
					}
					
				}
				
			}
		}
	return mesadresse;	
	}
	 public Vector<AdresseIp> remove_ip(Vector<AdresseIp> adresse_base,Vector<AdresseIp> adresse_a_supprimer)
     {
        if(!adresse_a_supprimer.isEmpty())
        { int flag=0;
         new AdresseIp();
         Vector<AdresseIp> ma_liste = new Vector<AdresseIp>();
         for(int i=0;i<adresse_base.size();i++)
         {//System.out.println("-------");
             adresse_base.get(i);
         flag=0;  
         for(int j=0;j<adresse_a_supprimer.size()&&flag==0;j++)
                     {//System.out.println("++++++++");
                         
                         if(adresse_a_supprimer.get(j).equals(adresse_base.get(i)))
                         flag=1;
                    if(j==adresse_a_supprimer.size()-1&&flag==0)
                    { ma_liste.add(adresse_base.get(i));
                       //  System.out.println(""+adresse_base.get(i).getChamp1()+"-"+adresse_base.get(i).getChamp2()+"-"+adresse_base.get(i).getChamp3()+"-"+adresse_base.get(i).getChamp4());
                    }
                     }
         
             }
		return ma_liste;}
        else
        	return adresse_base;
     }	
	 
	 public Vector<AdresseIp> adresse_ip_affecte()
	 {Vector<AdresseIp> adresse_affecte=new Vector<AdresseIp>();
		int champ1,champ2,champ3,champ4;
	new Date();			
		
		 Connection con=null; 
	        try
	        {
	        	 
	            con = connect_to_db();
	    
	         	 Connection conn = con;
			 Statement stm = conn.createStatement();
			String requete="select AF.idperiode,AF.idadresse,AI.champ1,AI.champ2,AI.champ3,AI.champ4 from affectation AF,adresseip AI where curdate() >=datedebut and curdate()<=datefin and etat=0 and AI.idadresse=AF.idadresse;";
			ResultSet rs=stm.executeQuery(requete);
			
			while(rs.next())
			{
				rs.getInt(1);
				rs.getInt(2);
				champ1=rs.getInt(3);
				champ2=rs.getInt(4);
				champ3=	rs.getInt(5);			
				champ4=rs.getInt(6);
				
				AdresseIp a_ip=new AdresseIp(champ1,champ2,champ3,champ4);
				adresse_affecte.add(a_ip);
			}
			
			conn.close(); 
	        }
	        catch(Exception ex)
	        {
	            System.out.println( ex.toString());
	        }
		
		
		
		
		
		return adresse_affecte;
		 
	 }
	 public Vector<AdresseIp> adresse_a_afficher(PlageAdresse p_a)throws IllegalArgumentException
	 {
		 AdresseIp a_r=new AdresseIp();
		 AdresseIp a_m=new AdresseIp();
		Vector<AdresseIp> ma_liste_plage = new Vector<AdresseIp>();
		Vector<AdresseIp> ma_liste_affecte = new Vector<AdresseIp>();
		Vector<AdresseIp> ma_liste_resultat = new Vector<AdresseIp>();
		 a_r.setChamp1(p_a.getChamp1AdReseau());
		 a_r.setChamp2(p_a.getChamp2AdReseau());
		 a_r.setChamp3(p_a.getChamp3AdReseau());
		 a_r.setChamp4(p_a.getChamp4AdReseau());
		 a_m.setChamp1(p_a.getChamp1masque());
		 a_m.setChamp2(p_a.getChamp2masque());
		 a_m.setChamp3(p_a.getChamp3masque());
		 a_m.setChamp4(p_a.getChamp4masque());
		ma_liste_plage=transform(a_r, a_m);
		ma_liste_affecte=adresse_ip_affecte();
		ma_liste_resultat=remove_ip(ma_liste_plage, ma_liste_affecte);
		return ma_liste_resultat;
	 }
	 public void ajouter_addresse(AdresseIp a_ip)
		{
			 Connection con=null; 
		        try
		        {
		        	

		            con = connect_to_db();
		    
		          //  String query = "INSERT INTO employe  VALUES ("+17+")";
		            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
					String query ="INSERT INTO adresseip (`champ1`,`champ2`,`champ3`,`champ4`) VALUES("+a_ip.getChamp1()+","+a_ip.getChamp2()+","+a_ip.getChamp3()+","+a_ip.getChamp4()+");";
		       	 Connection conn = con;
				 Statement update = conn.createStatement();
				 update.executeUpdate(query);
	
				 conn.close(); 
		        	//String query ="INSERT INTO adresseip (`champ1`,`champ2`,`champ3`,`champ4`) VALUES("+a_ip.getChamp1()+","+a_ip.getChamp2()+","+a_ip.getChamp3()+","+a_ip.getChamp4()+");";
		     
		        }
		        catch(Exception ex)
		        {
		            System.out.println( ex.toString());
		        }
	 	
			
		}	
	 public AdresseIp ajouter_affectation(Affectation affectation)throws IllegalArgumentException
		{				AdresseIp adresse=new AdresseIp(); 

			 Connection con=null; 
		        try
		        {
		            con = connect_to_db();
		    
		          //  String query = "INSERT INTO employe  VALUES ("+17+")";
		            //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
		          	 Connection conn = con;
					 Statement update = conn.createStatement();
				 String query1 ="SELECT idadresse,champ1,champ2,champ3,champ4 from adresseip ;";
				 ResultSet rs=update.executeQuery(query1);
				while(rs.next())
					{
						rs.getInt(1);
						adresse.setChamp1(rs.getInt(2));
						adresse.setChamp2(rs.getInt(3));
						adresse.setChamp3(rs.getInt(4));			
						adresse.setChamp4(rs.getInt(5));
					}
				java.text.SimpleDateFormat monTest1=new java.text.SimpleDateFormat("yyyy-MM-dd");
			    String sqlDate1 = monTest1.format(affectation.getDateDebut());
				java.text.SimpleDateFormat monTest2=new java.text.SimpleDateFormat("yyyy-MM-dd");
			    String sqlDate2 = monTest2.format(affectation.getDateFin());
			    String query0 ="INSERT INTO adresseip (champ1,champ2,champ3,champ4,idplage) VALUES ("+affectation.getAdresseIp().getChamp1()+","+affectation.getAdresseIp().getChamp2()+","+affectation.getAdresseIp().getChamp3()+","+affectation.getAdresseIp().getChamp4()+","+affectation.getAdresseIp().getIdplage()+");";
			    update.executeUpdate(query0);
			    String query ="INSERT INTO affectation (`idadresse`,`idterminal`,`datedebut`,`datefin`,`etat`) VALUES(LAST_INSERT_ID(),"+affectation.getTerminal().getIdTerminal()+",'"+sqlDate1+"','"+sqlDate2+"',"+0+");";	
				 update.executeUpdate(query);
				 conn.close(); 
		        }
		        catch(Exception ex)
		        {
		            System.out.println( ex.toString());
		        }
	 	
			return adresse;
		}


	@Override
	public ListeAdresse AdresseU(int idUtilisateur)
			throws IllegalArgumentException {
		
	
		
ListeAdresse LA=new ListeAdresse();
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
        conn = connect_to_db();
        Connection con=conn;
        stmt = con.createStatement();
		String requete="select champ1,champ2,champ3,champ4,nomMachine,datedebut,datefin,idperiode from adresseip IP,terminal T,utilisateur U,affectation A where T.idUtilisateur="+idUtilisateur+" and A.idAdresse=IP.idAdresse and A.idTerminal=T.idTerminal and T.idUtilisateur=U.idUtilisateur and etat="+0;
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			int c1,c2,c3,c4,id;
			String NM;
			Date D=new Date();
			//SimpleDateFormat DD1=new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat DF1=new SimpleDateFormat("yyyy-MM-dd");;
			Date DD,DF;
			//Date DD,DF;
			c1=rs.getInt(1);c2=rs.getInt(2);c3=rs.getInt(3);c4=rs.getInt(4);NM=rs.getString(5);
			DD=rs.getDate(6);DF=rs.getDate(7);id=rs.getInt(8);
			AdresseIp Y=new AdresseIp();
			Y.setChamp1(c1);Y.setChamp2(c2);Y.setChamp3(c3);Y.setChamp4(c4);Y.setNomMachine(NM);
			Y.setDD(DD);Y.setDF(DF);Y.setIdPeriode(id);
			if(D.after(DD) && D.before(DF))
			LA.ajouterAdresseIP(Y);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		return LA;
		
		
		
		
		
	}


	@Override
	public String Supprimer_Affectation(int idAffectation)
			throws IllegalArgumentException {
		
		
		Connection conn=null;
		Statement stmt=null;
		try{
		
       conn = connect_to_db();

     //  String query = "INSERT INTO employe  VALUES ("+17+")";
       //+ uti.getIdUtilisateur() + ", '" + uti.getEmailUtilisateur() + "' , '"+uti.getLoginUtilisateur()+"','"+uti.getMatUtilisateur()+"','"+uti.getMdpUtilisateur()+"','"+uti.getNomUtilisateur()+"','"+uti.getPrenomUtilisateur()+"','"+uti.getTelephoneUtilisateur()+"',"+uti.getTypeUtilisateur()+")";
       Connection con=conn;
       stmt = con.createStatement();
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.text.SimpleDateFormat monTest=new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date DX=new Date();
		String sqlDate2 = monTest.format(DX);
		String requete="update affectation set dateFin='"+sqlDate2+"', etat=1 where idperiode="+idAffectation;
		
		stmt.executeUpdate(requete);
		
		
		conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		return "ok";
		
		
	}


	@Override
	public String Modifier_Affectation(int idAffectation, Date DateFin)
			throws IllegalArgumentException {
		
		
		
		
		
		
		
		
		Connection conn=null;
		Statement stmt=null;
		try{
		
		conn =  connect_to_db();
		  Connection con=conn;
	        stmt = con.createStatement();
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.text.SimpleDateFormat monTest=new java.text.SimpleDateFormat("yyyy-MM-dd");
		//Date DX=new Date();
		String sqlDate2 = monTest.format(DateFin);
		String requete="update affectation set dateFin='"+sqlDate2+"' where idperiode="+idAffectation;
		
		stmt.executeUpdate(requete);
		
		
		conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		return "ok";
		
		
		
		
		
		
	}


	@Override
	public ListeAdresse Afficher_Historique() throws IllegalArgumentException {
		
		
		
		
		
		
		
		
		
		
ListeAdresse LA=new ListeAdresse();
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
		conn =  connect_to_db();
		  Connection con=conn;
	        stmt = con.createStatement();
		String requete="select nomUtilisateur,prenomUtilisateur,champ1,champ2,champ3,champ4,nomMachine,datedebut,datefin from adresseip IP,terminal T,utilisateur U,affectation A where A.idAdresse=IP.idAdresse and A.idTerminal=T.idTerminal and T.idUtilisateur=U.idUtilisateur";
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			int c1,c2,c3,c4;
			String NU,PU;
			String NM;
			new Date();
			//SimpleDateFormat DD1=new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat DF1=new SimpleDateFormat("yyyy-MM-dd");;
			Date DD,DF;
			//Date DD,DF;
			NU=rs.getString(1);PU=rs.getString(2);
			c1=rs.getInt(3);c2=rs.getInt(4);c3=rs.getInt(5);c4=rs.getInt(6);NM=rs.getString(7);
			DD=rs.getDate(8);DF=rs.getDate(9);
			AdresseIp Y=new AdresseIp();
			Y.setChamp1(c1);Y.setChamp2(c2);Y.setChamp3(c3);Y.setChamp4(c4);Y.setNomMachine(NM);
			Y.setDD(DD);Y.setDF(DF);
			Y.setNomUtilisateur(NU);Y.setPrenonUtilisateur(PU);
			//if(D.after(DD) && D.before(DF))
			LA.ajouterAdresseIP(Y);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		return LA;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	@Override
	public ListeAdresse Afficher_Affectation_EnCours()
			throws IllegalArgumentException {
		
		
		
		
		
		
ListeAdresse LA=new ListeAdresse();
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
		conn =  connect_to_db();
		  Connection con=conn;
	        stmt = con.createStatement();
		String requete="select nomUtilisateur,prenomUtilisateur,champ1,champ2,champ3,champ4,nomMachine,datedebut,datefin from adresseip IP,terminal T,utilisateur U,affectation A where A.idAdresse=IP.idAdresse and A.idTerminal=T.idTerminal and T.idUtilisateur=U.idUtilisateur and etat="+0;
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			int c1,c2,c3,c4;
			String NU,PU;
			String NM;
			Date D=new Date();
			//SimpleDateFormat DD1=new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat DF1=new SimpleDateFormat("yyyy-MM-dd");;
			Date DD,DF;
			//Date DD,DF;
			NU=rs.getString(1);PU=rs.getString(2);
			c1=rs.getInt(3);c2=rs.getInt(4);c3=rs.getInt(5);c4=rs.getInt(6);NM=rs.getString(7);
			DD=rs.getDate(8);DF=rs.getDate(9);
			AdresseIp Y=new AdresseIp();
			Y.setChamp1(c1);Y.setChamp2(c2);Y.setChamp3(c3);Y.setChamp4(c4);Y.setNomMachine(NM);
			Y.setDD(DD);Y.setDF(DF);
			Y.setMaDD(DD.toString());Y.setMaDF(DF.toString());
			Y.setNomUtilisateur(NU);Y.setPrenonUtilisateur(PU);
			if(D.after(DD) && D.before(DF))
			LA.ajouterAdresseIP(Y);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		return LA;
		
		
		
		
		
		
		
		
		
		
	}


	@Override
	public ListeAdresse Rechercher_Affectation_EnCours(String nomU,
			String prenomU, String nomM, String DateD, String DateF, String champ1,
			String champ2, String champ3, String champ4) throws IllegalArgumentException {
		
		
		
		
		
		
		
		
		
		
		
		
ListeAdresse LA=new ListeAdresse();
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
		conn =  connect_to_db();
		  Connection con=conn;
	        stmt = con.createStatement();
		String requete="select nomUtilisateur,prenomUtilisateur,champ1,champ2,champ3,champ4,nomMachine,datedebut,datefin from adresseip IP,terminal T,utilisateur U,affectation A where A.idAdresse=IP.idAdresse and A.idTerminal=T.idTerminal and T.idUtilisateur=U.idUtilisateur and etat="+0+" and nomUtilisateur like '%"+nomU+"%' and prenomUtilisateur like '%"+prenomU+"%' and nomMachine like '%"+nomM+"%' and datedebut like '%"+DateD+"%' and datefin like '%"+DateF+"%' and champ1 like'%"+champ1+"%'  and champ2 like'%"+champ2+"%'  and champ3 like'%"+champ3+"%' and champ4 like'%"+champ4+"%'";
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			int c1,c2,c3,c4;
			String NU,PU;
			String NM;
			Date D=new Date();
			//SimpleDateFormat DD1=new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat DF1=new SimpleDateFormat("yyyy-MM-dd");;
			Date DD,DF;
			//Date DD,DF;
			NU=rs.getString(1);PU=rs.getString(2);
			c1=rs.getInt(3);c2=rs.getInt(4);c3=rs.getInt(5);c4=rs.getInt(6);NM=rs.getString(7);
			DD=rs.getDate(8);DF=rs.getDate(9);
			AdresseIp Y=new AdresseIp();
			Y.setChamp1(c1);Y.setChamp2(c2);Y.setChamp3(c3);Y.setChamp4(c4);Y.setNomMachine(NM);
			Y.setDD(DD);Y.setDF(DF);
			Y.setMaDD(DD.toString());Y.setMaDF(DF.toString());
			Y.setNomUtilisateur(NU);Y.setPrenonUtilisateur(PU);
			if(D.after(DD) && D.before(DF))
			LA.ajouterAdresseIP(Y);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		return LA;
		
		
		
		
		
		
		
		
		
	}


	@Override
	public ListeAdresse Recherche_Historique_Affectation(String nomU,
			String prenomU, String nomM, String champ1, String champ2,
			String champ3, String champ4) throws IllegalArgumentException {
		
		
		
		
		
		
		
		
ListeAdresse LA=new ListeAdresse();
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
		conn =  connect_to_db();
		  Connection con=conn;
	        stmt = con.createStatement();
		String requete="select nomUtilisateur,prenomUtilisateur,champ1,champ2,champ3,champ4,nomMachine,datedebut,datefin from adresseip IP,terminal T,utilisateur U,affectation A where A.idAdresse=IP.idAdresse and A.idTerminal=T.idTerminal and T.idUtilisateur=U.idUtilisateur and nomUtilisateur like '%"+nomU+"%' and prenomUtilisateur like '%"+prenomU+"%' and nomMachine like '%"+nomM+"%' and champ1 like'%"+champ1+"%'  and champ2 like'%"+champ2+"%'  and champ3 like'%"+champ3+"%' and champ4 like'%"+champ4+"%'";
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			int c1,c2,c3,c4;
			String NU,PU;
			String NM;
			new Date();
			new java.text.SimpleDateFormat("yyyy-MM-dd");
			new java.text.SimpleDateFormat("yyyy-MM-dd");;
			Date DD,DF;
			//Date DD,DF;
			NU=rs.getString(1);PU=rs.getString(2);
			c1=rs.getInt(3);c2=rs.getInt(4);c3=rs.getInt(5);c4=rs.getInt(6);NM=rs.getString(7);
			DD=rs.getDate(8);DF=rs.getDate(9);
			AdresseIp Y=new AdresseIp();
			Y.setChamp1(c1);Y.setChamp2(c2);Y.setChamp3(c3);Y.setChamp4(c4);Y.setNomMachine(NM);
			Y.setDD(DD);Y.setDF(DF);
			Y.setNomUtilisateur(NU);Y.setPrenonUtilisateur(PU);
			//if(D.after(DD) && D.before(DF))
			LA.ajouterAdresseIP(Y);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		return LA;
		
		
		
		
		
		
		
		
		
		
		
	}


	@Override
	public Utilisateur MonProfil(int idUtilisateur)
			throws IllegalArgumentException {


		
		
		
		Utilisateur U=new Utilisateur();
		
		
		

		Connection conn=null;
		Statement stmt=null;
		try{
		
		  Connection con=connect_to_db();
	        stmt = con.createStatement();
		String requete="SELECT nomUtilisateur, prenomUtilisateur,emailUtilisateur, matUtilisateur,loginUtilisateur,mdpUtilisateur,telephoneUtilisateur FROM stage_2.utilisateur where flag_supp=0 and idUtilisateur="+idUtilisateur;
		
		ResultSet rs=stmt.executeQuery(requete);
		
		
		while(rs.next())
		{
			
			String NU,PU,EmailU,MatU,LoginU,Mdp,telephone;
			NU=rs.getString(1);PU=rs.getString(2);EmailU=rs.getString(3);
			MatU=rs.getString(4);
			LoginU=rs.getString(5);Mdp=rs.getString(6);
			telephone=rs.getString(7);
			
			U.setNomUtilisateur(NU);U.setPrenomUtilisateur(PU);
			U.setEmailUtilisateur(EmailU);U.setMatUtilisateur(MatU);U.setLoginUtilisateur(LoginU);U.setMdpUtilisateur(Mdp);
			U.setTelephoneUtilisateur(telephone);
			
			
			
			
		}
		
		
		
		 conn.close();	 
			 
			 
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return U;
	}


	@Override
	public String ModifierMonProfil(Utilisateur uti)
			throws IllegalArgumentException {
		
		
		
		
		Connection con=null; 
        try
        {
        	  
            con = connect_to_db();
    
         	String query ="update utilisateur set nomutilisateur='"+uti.getNomUtilisateur()+"' , prenomutilisateur='"+uti.getPrenomUtilisateur()+"' , emailutilisateur='"+uti.getEmailUtilisateur()+"' , matutilisateur='"+uti.getMatUtilisateur()+"' , loginutilisateur='"+uti.getLoginUtilisateur()+"' , mdputilisateur='"+uti.getMdpUtilisateur()+"',telephoneutilisateur='"+uti.getTelephoneUtilisateur()+"' where idutilisateur="+uti.getIdUtilisateur()+";";
         	  Connection conn=con;
		 Statement update = conn.createStatement();
		 update.executeUpdate(query);
		 
			 conn.close(); 
        }
        catch(Exception ex)
        {
            System.out.println( ex.toString());
        }
		
        
        
        
        return "success";
		
		
	}


	
	
	
	
	
	
	
	


	
	


	


	
	
	}
	 
	
