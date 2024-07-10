import java.util.*;

public class Zombie {
    private int x;
    private int y;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacerAleatoirement() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                y--;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                x++;
                break;
        }
    }

    // Getters et Setters
}
