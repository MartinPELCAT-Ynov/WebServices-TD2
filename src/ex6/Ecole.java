package ex6;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Ecole {

  List<Etudiant> etudiants;
  List<MembreDuPersonnel> membresDuPersonnel;

  List<Cours> cours;

  List<RendezVousIndividuel> rendezVousIndividuels;

  List<JourneeAbsence> journeesAbsence;

  public Collection<Utilisateur> extraireUtilisateursARisque(Utilisateur utilisateurPositif, Date dateTestCovid) {
    Set<Utilisateur> utilisateursARisque = new LinkedHashSet<>();

    List<Cours> coursAtRisque = this.cours.stream().filter(c -> c.isCoursAtRisk(utilisateurPositif, dateTestCovid))
        .collect(Collectors.toList());

    List<Etudiant> etudiantsAtRisque = coursAtRisque.stream().map(Cours::getEtudiantsPresents).flatMap(List::stream)
        .collect(Collectors.toList());

    List<Professeur> professorAtRisk = coursAtRisque.stream().map(c -> c.professeur).filter(Objects::nonNull)
        .collect(Collectors.toList());

    utilisateursARisque.addAll(etudiantsAtRisque);
    utilisateursARisque.addAll(professorAtRisk);

    if (utilisateurPositif.isMembreDirection()) {

      List<MembreDuPersonnel> membresDuPersonnelAtRisque = this.membresDuPersonnel.stream().filter(m -> {
        List<JourneeAbsence> journeeAbsences = this.journeesAbsence.stream().filter(j -> j.membre.equals(m))
            .collect(Collectors.toList());

        return journeeAbsences.stream()
            .anyMatch(j -> j.dateAbsence.before(new Date(dateTestCovid.getTime() - 7 * 24 * 60 * 60 * 1000)));
      }).collect(Collectors.toList());

      utilisateursARisque.addAll(membresDuPersonnelAtRisque);

    }

    List<Utilisateur> rdvUserAtRisk = rendezVousIndividuels.stream()
        .map((rdv) -> rdv.getUtilisateurAtRisk(utilisateurPositif, dateTestCovid)).filter(Objects::nonNull)
        .collect(Collectors.toList());

    utilisateursARisque.addAll(rdvUserAtRisk);

    return utilisateursARisque;
  }

}
