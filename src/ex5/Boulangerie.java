package ex5;

import java.util.ArrayList;
import java.util.List;

public class Boulangerie {

    List<Employe> employes = new ArrayList<>();


    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public double calculAverageSalary() {
        return this.employes.stream().mapToDouble(Employe::calculerSalaire).average().getAsDouble();
    }

    public double calculerChiffreDaffaireTotal() {
        return this.employes.stream().mapToDouble(Employe::getChiffreAffaire).sum();
    }
}
