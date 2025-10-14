package testsFonctionnels;

import cartes.*;
import java.util.*;
import utils.GestionCartes;


public class TestGestionCartes {
	public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte c : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(c);
        }

        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println("Avant mélange : " + listeCartes);

        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println("Après mélange : " + listeCartes);

        System.out.println("Liste mélangée sans erreur ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println("Après rassemblement : " + listeCartes);

        System.out.println("Liste rassemblée sans erreur ? "
                + GestionCartes.verifierRassemblement(listeCartes));
    }
}
