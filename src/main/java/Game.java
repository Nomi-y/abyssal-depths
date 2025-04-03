import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    
    private Object[][] level;
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> defeatedEnemies;
    private int score;
    private int globalLevel;
    private ArrayList<Collectible> collectedItems;
    
    public Game() {
    
    }
    
    // getters
    public int getGlobalLevel() { return globalLevel; }
    
    public void changeGlobalLevel(int lvl) {
        globalLevel += lvl;
    }
    
    
}
