package ex5;

public class Employe {
    private String nom;
    private Double salaire;
    private Double chiffreAffaire = 0.0;

    public Employe(String nom, Double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }

    public Employe(String nom, Double chiffreAffaire, Double salaire) {
        this.nom = nom;
        this.salaire = salaire;
        this.chiffreAffaire = chiffreAffaire;
    }

    public Double calculerSalaire() {
        return salaire + (chiffreAffaire * 0.1);
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }
}
