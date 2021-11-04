package ex6;

import java.util.Date;

public class Etudiant extends Utilisateur {

  public Etudiant(String nom, String prenom, Date dateNaissance,String email) {
    super(nom, prenom, email, dateNaissance);
  }
}
