package MeuteLycanthropes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import MeuteLycanthropes.Meute;

public class Meute {
    
    private ArrayList<Lycanthrope> lycanthropes;
    private boolean malade;

    public Meute(boolean malade) {
        this.lycanthropes = new ArrayList<Lycanthrope>();
        this.malade = malade;
        System.out.println("Une nouvelle meute a été créée ! (malade : \"" + this.malade + "\")");
    }

    public void afficherLycanthropes() {
        System.out.println("Voici les lycanthropes de la meute :");
        for (Lycanthrope lycanthrope : lycanthropes) {
            System.out.println(lycanthrope);
        }
    }

    public void ajouterLycanthrope(Lycanthrope lycanthrope) {
        if (!this.lycanthropes.contains(lycanthrope)) {
            this.lycanthropes.add(lycanthrope);
            System.out.println(lycanthrope.getNom() + " a été ajouté à la meute");
            Lycanthrope loupOmega = Collections.min(this.lycanthropes,
                    Comparator.comparing(Lycanthrope::getRangDomination));
            loupOmega.setRangDomination(RangDomination.OMEGA);
        }
    }

    public void retirerLycanthrope(Lycanthrope lycanthrope) {
        if (this.lycanthropes.contains(lycanthrope) && this.lycanthropes.size() > 3) {
            this.lycanthropes.remove(lycanthrope);
            System.out.println(lycanthrope.getNom() + " a été retiré de la meute");
            if (lycanthrope.getRangDomination() == RangDomination.OMEGA) {
                Lycanthrope loupOmega = Collections.min(this.lycanthropes,
                        Comparator.comparing(Lycanthrope::getRangDomination));
                loupOmega.setRangDomination(RangDomination.OMEGA);
            }
        } else {
            System.out.println(
                    "Impossible de retirer " + lycanthrope.getNom() + " car la meute doit contenir au moins 3 loups.");
        }
    }

    public void retirerLycanthropeinferieura3(Lycanthrope lycanthrope) {
        if (this.lycanthropes.contains(lycanthrope) && this.lycanthropes.size() > 3) {
            this.lycanthropes.remove(lycanthrope);
            System.out.println(lycanthrope.getNom() + " a été retiré de la meute");
        } else {
            System.out.println(
                    "Impossible de retirer " + lycanthrope.getNom() + " car la meute doit contenir au moins 3 loups.");
        }
    }

    public String getmalade() {
        return malade;
    }

    public ArrayList<Lycanthrope> getLycanthropes() {
        return this.lycanthropes;
    }
/* 
    public void verifierChangementFemelleAlpha() {
        if (!femelles.contains(femelleAlpha)) {
            dechuFemelleAlpha(femelleAlpha);
            femelleAlpha = trouverNouvelleFemelleAlpha();
        }
    }

    public void ajouterFemelle(Lycanthrope nouvelleFemelle) {
        this.femelles.add(nouvelleFemelle);
        verifierChangementFemelleAlpha(); // Appel de la méthode pour vérifier la femelle alpha après l'ajout
    }
    
    public void supprimerFemelle(Lycanthrope femelleASupprimer) {
        this.femelles.remove(femelleASupprimer);
        verifierChangementFemelleAlpha(); // Appel de la méthode pour vérifier la femelle alpha après la suppression
    }
*/
}