public abstract class Enemy extends Entity {
    
    public final boolean isAgressive;
    
    public Enemy(int power, int movement, int defense, int xp, boolean agressive) {
        super(power, movement, defense, xp);
        isAgressive = agressive;
    }
    
    
}
