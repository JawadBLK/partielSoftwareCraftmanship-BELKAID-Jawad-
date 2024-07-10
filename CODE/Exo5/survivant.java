public class Survivant {
    private int x;
    private int y;
    private String orientation;
    private int sante;

    public Survivant(int x, int y, String orientation, int sante) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.sante = sante;
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
  
    public void reduireSante(int points) {
        sante -= points;
    }

    public void collecterRessource(Ressource ressource) {
        inventaire.add(ressource);
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
