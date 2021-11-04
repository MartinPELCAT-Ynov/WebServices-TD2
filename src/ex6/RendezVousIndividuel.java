package ex6;

import java.util.Date;

public class RendezVousIndividuel {

    ConseillerOrientation conseillerOrientation;
    Etudiant etudiant;
    Date dateRdv;

    public RendezVousIndividuel(ConseillerOrientation conseillerOrientation, Etudiant etudiant, Date dateRdv) {
        this.conseillerOrientation = conseillerOrientation;
        this.etudiant = etudiant;
        this.dateRdv = dateRdv;
    }


    public Utilisateur getUtilisateurAtRisk(Utilisateur utilisateur, Date riskDate) {
        boolean dateAtRisk = dateRdv.before(new Date(riskDate.getTime() - 7 * 24 * 60 * 60 * 1000));
        if (!dateAtRisk) return null;
        if (conseillerOrientation == utilisateur) return etudiant;
        if (etudiant == utilisateur) return conseillerOrientation;
        return null;
    }

}
