package ex6;

import java.util.Date;

public class Utilisateur {

  String nom;
  String prenom;
  String email;
  Date dateNaissance;

  public Utilisateur(String nom, String prenom, String email, Date dateNaissance) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.dateNaissance = dateNaissance;
  }

  public boolean isMembreDirection() {
    return this instanceof MembreEquipeDirection;
  }

  @Override
  public String toString() {
    return this.nom + " " + this.prenom;
  }
}
