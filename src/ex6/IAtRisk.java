package ex6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public interface IAtRisk {

    Collection<Utilisateur> getUsersAtRisk(Utilisateur utilisateur, Date riskDate);
}
