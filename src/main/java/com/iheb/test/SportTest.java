package com.iheb.test;

import com.iheb.dao.SportDao;
import com.iheb.entities.Sport;

public class SportTest {
    public static void main(String[] args) {
        
        Sport s1 = new Sport();
        s1.setNomSport("Football");
        s1.setDateFondation("1872");
        s1.setDescription("Le football est un sport collectif qui oppose deux équipes de onze joueurs dans un stade.");

        Sport s2 = new Sport();
        s2.setNomSport("Basketball");
        s2.setDateFondation("1891");
        s2.setDescription("Le basketball est un sport d'équipe qui se joue avec une balle et un panier.");

        Sport s3 = new Sport();
        s3.setNomSport("Tennis");
        s3.setDateFondation("1874");
        s3.setDescription("Le tennis est un sport qui se joue en simple (deux joueurs) ou en double (quatre joueurs).");

        SportDao sportDao = new SportDao();

        sportDao.ajouter(s1);
        sportDao.ajouter(s2);
        sportDao.ajouter(s3);

        System.out.println("Appel de la méthode listerTous");
        for (Sport s : sportDao.listerTous())
            System.out.println(s.getIdSport() + " " + s.getNomSport()+" " + s.getDateFondation()+" "+s.getDescription());

        System.out.println("Appel de la méthode listerParNom");
        for (Sport s : sportDao.listerParNom("Foot"))
            System.out.println(s.getIdSport() + " " + s.getNomSport());

        System.out.println("Modification du sport s1");
        s1.setDateFondation("1875");
        sportDao.modifier(s1);

        System.out.println("Suppression du sport s2");
        sportDao.supprimer(s2);
        
        System.out.println(" aprés modification et suppression ");
        for (Sport s : sportDao.listerTous())
            System.out.println(s.getIdSport() + " " + s.getNomSport()+ " " + s.getDateFondation()+" "+s.getDescription());

        System.out.println("Consultation du sport s3 par ID");
        Sport sportConsulte = sportDao.consulter(s3.getIdSport());
        if (sportConsulte != null) {
            System.out.println("Sport trouvé : " + sportConsulte.getNomSport());
        } else {
            System.out.println("Sport non trouvé.");
        }
    }
}
