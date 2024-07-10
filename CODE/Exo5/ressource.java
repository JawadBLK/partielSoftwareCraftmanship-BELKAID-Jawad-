import java.util.*;

public class Ressource {
    public enum Type {
        NOURRITURE,
        EAU,
        ARME
    }

    private final Type type;
    private final int x;
    private final int y;

    public Ressource(Type type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Type getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
