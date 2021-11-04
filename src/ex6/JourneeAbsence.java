package ex6;

import java.util.Date;

public class JourneeAbsence {
  Date dateAbsence;
  MembreDuPersonnel membre;

  public JourneeAbsence(MembreDuPersonnel membre, Date dateAbsence) {
    this.dateAbsence = dateAbsence;
    this.membre = membre;
  }
}
