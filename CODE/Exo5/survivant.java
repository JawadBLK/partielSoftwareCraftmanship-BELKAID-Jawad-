public class Survivant {
    private int x;
    private int y;
    private String orientation;
    private int sante;
    private List<Ressource> inventaire;
    private Carte carte;

    public Survivant(int x, int y, String orientation, int sante, Carte carte) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.sante = sante;
        this.inventaire = new ArrayList<>();
        this.carte = carte;
    }

    public void deplacer(String direction) {
        switch (direction) {
            case "nord":
                y--;
                break;
            case "sud":
                y++;
                break;
            case "est":
                x++;
                break;
            case "ouest":
                x--;
                break;
        }
    }

    public void tourner(String direction) {
        switch (direction) {
            case "gauche":
                orientation = switch (orientation) {
                    case "nord" -> "ouest";
                    case "ouest" -> "sud";
                    case "sud" -> "est";
                    case "est" -> "nord";
                    default -> orientation;
                };
                break;
            case "droite":
                orientation = switch (orientation) {
                    case "nord" -> "est";
                    case "est" -> "sud";
                    case "sud" -> "ouest";
                    case "ouest" -> "nord";
                    default -> orientation;
                };
                break;
        }

  
    public void reduireSante(int points) {
        sante -= points;
    }

    public void collecterRessource(Ressource ressource) {
        inventaire.add(ressource);
    }
    
    public void explorer(String commande) {
        switch (commande) {
            case "avancer":
                deplacer(orientation);
                break;
            case "tourner à gauche":
                tourner("gauche");
                break;
            case "tourner à droite":
                tourner("droite");
                break;
        }
        if (!carte.estDansLaCarte(x, y)) {
            throw new RuntimeException("Le survivant a quitté la carte et est mort.");
        }

        rencontrerZombie();
        collecterRessource();
    }

    public void rencontrerZombie() {
        for (Zombie zombie : carte.getZombies()) {
            if (x == zombie.getX() && y == zombie.getY()) {
                reduireSante(10);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public List<Ressource> getInventaire() {
        return inventaire;
    }
} 
