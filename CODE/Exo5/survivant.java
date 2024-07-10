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

}
