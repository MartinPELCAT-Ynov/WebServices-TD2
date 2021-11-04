package ex6;

import java.util.Date;

public class Professeur extends MembreDuPersonnel {

  public Professeur(String nom, String prenom, Date dateNaissance, String email) {
    super(nom, prenom, email, dateNaissance);
  }
}
