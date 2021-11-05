package ex6;

import ex6.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class RendezVousIndividuel {

    ConseillerOrientation conseillerOrientation;
    Etudiant etudiant;
    Date dateRdv;

    public RendezVousIndividuel(ConseillerOrientation conseillerOrientation, Etudiant etudiant, Date dateRdv) {
        this.conseillerOrientation = conseillerOrientation;
        this.etudiant = etudiant;
        this.dateRdv = dateRdv;
    }


    public Collection<Utilisateur> getUtilisateurAtRisk(Utilisateur utilisateur, Date riskDate) {

        List<Utilisateur> utilisateurs = new ArrayList<>();
        boolean dateAtRisk = DateUtils.isDateBetween(riskDate, dateRdv);
        if (!dateAtRisk) return utilisateurs;
        if (conseillerOrientation == utilisateur ||etudiant == utilisateur) {
            utilisateurs.add(utilisateur);
            utilisateurs.add(conseillerOrientation);
        }
        return utilisateurs;
    }

}
