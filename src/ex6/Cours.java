package ex6;

import ex6.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Cours implements IAtRisk {

    List<Etudiant> etudiantsInscrits = new ArrayList<>();
    List<Etudiant> etudiantsAbsents = new ArrayList<>();
    Professeur professeur;
    Date dateCours;

    public Cours(List<Etudiant> etudiantsInscrits, List<Etudiant> etudiantsAbsents, Professeur professeur,
                 Date dateCours) {
        this.etudiantsInscrits = etudiantsInscrits;
        this.etudiantsAbsents = etudiantsAbsents;
        this.professeur = professeur;
        this.dateCours = dateCours;
    }

    public List<Etudiant> getEtudiantsPresents() {
        if (etudiantsAbsents == null) {
            return etudiantsInscrits;
        } else {
            return etudiantsInscrits.stream().filter(etudiant -> !etudiantsAbsents.contains(etudiant))
                    .collect(Collectors.toList());
        }
    }

    public boolean isCoursAtRisk(Utilisateur utilisateur, Date riskDate) {
        boolean isDateAtRisk = dateCours.before(new Date(riskDate.getTime() - 7 * 24 * 60 * 60 * 1000));

        if (professeur == utilisateur && isDateAtRisk) {
            return true;
        } else {
            return this.getEtudiantsPresents().contains(utilisateur) && isDateAtRisk;
        }
    }

    public Collection<Utilisateur> getUsersAtRisk(Utilisateur utilisateur, Date riskDate) {

        List<Utilisateur> users = new ArrayList<>();
        if (!DateUtils.isDateBetween(riskDate, dateCours)) {
            return users;
        }

        List<Etudiant> presentStudents = this.getEtudiantsPresents();
        if (presentStudents.contains(utilisateur) || professeur == utilisateur) {
            users.addAll(presentStudents);
            users.add(professeur);
        }
        return users;
    }
}
