package ex6;

import java.util.Date;

public class MembreDuPersonnel extends Utilisateur {

  public MembreDuPersonnel(String nom, String prenom, String email, Date dateNaissance) {
    super(nom, prenom, email, dateNaissance);
  }


  public boolean wasPresentTheLastWeek() {
    return false;
  }

}
