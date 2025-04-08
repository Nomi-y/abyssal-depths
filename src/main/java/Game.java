import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Game {
    
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> defeatedEnemies;
    private int score;
    private int globalLevel;
    private ArrayList<Item> collectedItems;
    
    public Game() {
        enemies = new ArrayList<>();
        defeatedEnemies = new ArrayList<>();
        score = 0;
        globalLevel = 1;
        collectedItems = new ArrayList<>();
    }
    
    public void setPlayer(Player player) throws GameException {
        if (player == null) throw new GameException("Player cannot be null!");
        this.player = player;
    }
    
    public int getGlobalLevel() { return globalLevel; }
    
    
    public void changeGlobalLevel(int lvl) {
        globalLevel += lvl;
    }
    
    public void addEnemy(Enemy e) throws GameException {
        if (e == null) throw new GameException("Enemy is null");
        enemies.add(e);
    }
    
    public int countEnemies() {
        return enemies.size();
    }
    
    
    public void updateEnemies() throws EntityException {
        Iterator<Enemy> it = enemies.iterator();
        while(it.hasNext()) {
            Enemy en = it.next();
            if (en.getDefense() == 0) {
                it.remove();
                defeatedEnemies.add(en);
                score += en.getXp();
            }
            en.attack(player);
        }
    }
    
    public void fightEnemy(Enemy enemy) throws EntityException {
        if (enemy == null || !enemies.contains(enemy)) return;
        player.attack(enemy);
        if (enemy.getDefense() <= 0) {
            enemies.remove(enemy);
            defeatedEnemies.add(enemy);
            score += enemy.getXp();
            player.setXp(player.getXp() + enemy.getXp());
            player.calculateLevel();
            return;
        }
        enemy.attack(player);
        if (player.getDefense() <= 0) {
            gameOver();
        }
    }
    
    
    public boolean collect(Item c) throws GameException {
        if (c == null) throw new GameException("Trying to add an invalid Item");
        return collectedItems.add(c);
    }
    
    public void gameOver() {
    
    }
    
    public int countItems() {
        return collectedItems.size();
    }
    
    public void sortItems() {
        collectedItems.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                int rarityCompare = item.getRarity().compareTo(t1.getRarity());
                if (rarityCompare != 0) return rarityCompare;
                else return item.getName().compareTo(t1.getName());
            }
        });
    }
    
    public int countEnemiesDefeated(Class<? extends Enemy> c) {
        int count = 0;
        for (Enemy en : defeatedEnemies)
            if (c.isInstance(en)) count++;
        return count;
    }
    
    public double getAverageXpOfDefeatedEnemies() {
        if (defeatedEnemies.isEmpty()) return 0.0;
        int total = 0;
        for (Enemy en : defeatedEnemies) total += en.getXp();
        return (double) total / defeatedEnemies.size();
    }
    
    public Item getItemByName(String name) {
        for (Item item : collectedItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemByIndex(int in) throws GameException {
        if (in < 0 || in > collectedItems.size()) throw new GameException("Index out of bounds!");
        return collectedItems.get(in);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game State:\n");
        sb.append("Global Level: ").append(globalLevel).append("\n");
        sb.append("Score: ").append(score).append("\n");
        sb.append("Collected Items: ").append(collectedItems.size()).append("\n");
        sb.append("Enemies Remaining: ").append(enemies.size()).append("\n");
        sb.append("Defeated Enemies: ").append(defeatedEnemies.size()).append("\n");
        return sb.toString();
    }
    
}
