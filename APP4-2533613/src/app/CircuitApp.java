package app;

import electronique.Composant;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CircuitApp {
    private static final Scanner sc = new Scanner(System.in);

    static void main() {

        boolean continuer = true;

        while (continuer) {
            File donnees = new File("APP4-2533613/src/donnees/fichiers_json");
            File[] fichiers = donnees.listFiles((dir, name) -> name.endsWith(".json"));

            if(fichiers == null || fichiers.length == 0) {
                System.out.println("Aucun fichier JSON trouvé");
                return;
            }

            System.out.println("--------- Sélectionner un circuit ---------");
            for(int i = 0; i < fichiers.length; i++) {
                System.out.println("[" + (i+1) + "] " + fichiers[i].getName());
            }

            int choix = lireChoix(fichiers.length);

            File fichierChoix = fichiers[choix-1];

            try {
                CircuitBuilder cb = new CircuitBuilder();
                Composant circuit = cb.construireCircuit(fichierChoix.getPath());

                double resultat = circuit.calculerResistance();

                System.out.println("\nRésistance équivalente : " + resultat + "Ω");

            } catch (IOException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

            continuer = finCycle();
        }

        System.out.println("Programme terminé correctement !");

    }

    private static int lireChoix(int choixMax){
        int choix;

        while(true) {
            System.out.print("Votre choix : ");

            if (sc.hasNextInt()) {
                choix = sc.nextInt();
                sc.nextLine();

                if (choix >= 1  && choix <= choixMax) {
                    return choix;
                }
            } else {
                sc.nextLine();
            }

            System.out.println("Choix d'entrée invalide. Réessayez.");
        }
    }

    private static boolean finCycle() {

        while(true) {
            System.out.println("\n[R] Recommencer");
            System.out.println("[Q] Quitter");
            System.out.print("Choix : ");

            String choix = sc.nextLine().trim().toUpperCase();

            if (choix.equals("R")) {
                return true;
            } else if (choix.equals("Q")) {
                return false;
            }  else {
                System.out.println("Action invalide. ");
            }
        }
    }
}
