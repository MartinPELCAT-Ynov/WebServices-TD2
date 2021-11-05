package ex6;

import ex6.utils.DateUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Ecole {

    List<Etudiant> etudiants;
    List<MembreDuPersonnel> membresDuPersonnel;

    List<Cours> cours;

    List<RendezVousIndividuel> rendezVousIndividuels;

    List<JourneeAbsence> journeesAbsence;

    public Collection<Utilisateur> extraireUtilisateursARisque(Utilisateur utilisateurPositif, Date dateTestCovid) {
        Set<Utilisateur> utilisateursARisque = new LinkedHashSet<>();
        utilisateursARisque.add(utilisateurPositif);

        utilisateursARisque.addAll(extractCoursAtRisk(utilisateurPositif, dateTestCovid));

        utilisateursARisque.addAll(extractMembreDirectionAtRisk(utilisateurPositif, dateTestCovid));

        utilisateursARisque.addAll(extractRdvAtRisk(utilisateurPositif, dateTestCovid));

        return utilisateursARisque;
    }

    private List<Utilisateur> extractCoursAtRisk(Utilisateur utilisateurPositif, Date dateTestCovid) {
        return this.cours.stream().map(c -> c.getUsersAtRisk(utilisateurPositif, dateTestCovid))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    private List<Utilisateur> extractMembreDirectionAtRisk(Utilisateur utilisateurPositif, Date dateTestCovid) {
        if (utilisateurPositif.isMembreDirection()) {
            List<MembreDuPersonnel> membresDirections = this.membresDuPersonnel
                    .stream()
                    .filter(m -> m.isMembreDirection())
                    .collect(Collectors.toList());

            return membresDirections
                    .stream()
                    .filter(m -> this.journeesAbsence
                            .stream()
                            .filter(journeeAbsence -> journeeAbsence.membre.equals(m))
                            .allMatch(journeeAbsence -> DateUtils.isDateBetween(dateTestCovid, journeeAbsence.dateAbsence))
                    ).collect(Collectors.toList());


        }
        return new ArrayList<>();
    }

    private List<Utilisateur> extractRdvAtRisk(Utilisateur utilisateurPositif, Date dateTestCovid) {
        return rendezVousIndividuels.stream()
                .map((rdv) -> rdv.getUtilisateurAtRisk(utilisateurPositif, dateTestCovid)).flatMap(Collection::stream).collect(Collectors.toList());
    }

}
