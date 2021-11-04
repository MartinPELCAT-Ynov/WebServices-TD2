package ex6;

import java.util.Date;

public class RendezVousIndividuel {

  private ConseillerOrientation conseillerOrientation;
  private Etudiant etudiant;
  private Date dateRdv;

  public RendezVousIndividuel(ConseillerOrientation conseillerOrientation, Etudiant etudiant, Date dateRdv) {
    this.conseillerOrientation = conseillerOrientation;
    this.etudiant = etudiant;
    this.dateRdv = dateRdv;
  }

}
