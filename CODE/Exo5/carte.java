import java.util.*;

public class Carte {
    private final int taille;
    private final List<Ressource> ressources;
    private final List<Zombie> zombies;

    public Carte(int taille) {
        this.taille = taille;
        this.ressources = new ArrayList<>();
        this.zombies = new ArrayList<>();
    }

    public void ajouterRessource(Ressource ressource) {
        ressources.add(ressource);
    }

    public void ajouterZombie(Zombie zombie) {
        zombies.add(zombie);
    }
  
    // Getters et Setters
}
