package ex5;

public class ExerciceBoulangerie {
    public static void main(String[] args) {
        System.out.println("Bonjour, je suis le boulangerie");
        Boulangerie boulangerie = new Boulangerie();
        boulangerie.ajouterEmploye(new Vendeur("Pierre", 30000d));
        boulangerie.ajouterEmploye(new Vendeur("Jean", 22000d));
        boulangerie.ajouterEmploye(new Boulanger("Delphine"));
        boulangerie.ajouterEmploye(new Boulanger("Coraline"));
        boulangerie.ajouterEmploye(new Boulanger("Anthony"));


        System.out.println("Le salaire moyen dans la boulangerie est de " + boulangerie.calculAverageSalary());
        System.out.println("Le chiffre d'affaire est de " + boulangerie.calculerChiffreDaffaireTotal());
    }
}
