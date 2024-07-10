import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SurvivantTest {
    private Carte carte;
    private Survivant survivant;

    @BeforeEach
    public void setup() {
        carte = new Carte(10);
        survivant = new Survivant(0, 0, "sud", 100, carte);
    }

    @Test
    public void testDeplacerSurvivant() {
        survivant.deplacer("sud");
        assertEquals(0, survivant.getX());
        assertEquals(1, survivant.getY());
    }

    @Test
    public void testRencontrerZombieReduitSante() {
        Zombie zombie = new Zombie(0, 1);
        carte.ajouterZombie(zombie);

        survivant.explorer("avancer");

        assertEquals(90, survivant.getSante());
    }

    @Test
    public void testCollecterRessource() {
        Ressource ressource = new Ressource(Ressource.Type.NOURRITURE, 0, 1);
        carte.ajouterRessource(ressource);

        survivant.explorer("avancer");

        assertTrue(survivant.getInventaire().contains(ressource));
        assertNull(carte.trouverRessource(0, 1));
    }
}
