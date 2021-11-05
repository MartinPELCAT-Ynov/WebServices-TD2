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

        List<Utilisateur> userCoursAtRisk = this.cours.stream().map(c -> c.getUsersAtRisk(utilisateurPositif, dateTestCovid))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        utilisateursARisque.addAll(userCoursAtRisk);

        if (utilisateurPositif.isMembreDirection()) {
            System.out.println(utilisateurPositif.nom + "" + dateTestCovid.toString());
            List<MembreDuPersonnel> membresDirections = this.membresDuPersonnel
                    .stream()
                    .filter(m -> m.isMembreDirection())
                    .collect(Collectors.toList());

            List<Utilisateur> directionAtRisk = membresDirections
                    .stream()
                    .filter(m -> this.journeesAbsence
                            .stream()
                            .filter(journeeAbsence -> journeeAbsence.membre.equals(m))
                            .allMatch(journeeAbsence -> DateUtils.isDateBetween(dateTestCovid, journeeAbsence.dateAbsence))
                    ).collect(Collectors.toList());

            System.out.println(directionAtRisk);

            utilisateursARisque.addAll(directionAtRisk);

        }

        List<Utilisateur> rdvUserAtRisk = rendezVousIndividuels.stream()
                .map((rdv) -> rdv.getUtilisateurAtRisk(utilisateurPositif, dateTestCovid)).flatMap(Collection::stream).collect(Collectors.toList());

        utilisateursARisque.addAll(rdvUserAtRisk);

        return utilisateursARisque;
    }

}
