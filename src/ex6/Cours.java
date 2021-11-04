package ex6;

import java.util.Date;
import java.util.List;

public class Cours {

    private List<Etudiant> etudiantsInscrits;
    private List<Etudiant> etudiantsAbsents;
    private Professeur professeur;
    private Date dateCours;

    public Cours(List<Etudiant> etudiantsInscrits, List<Etudiant> etudiantsAbsents, Professeur professeur,
            Date dateCours) {
        this.etudiantsInscrits = etudiantsInscrits;
        this.etudiantsAbsents = etudiantsAbsents;
        this.professeur = professeur;
        this.dateCours = dateCours;
    }

}
