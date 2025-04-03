import java.lang.classfile.instruction.ReturnInstruction;

public abstract class Entity {
    private int power;
    private int movement;
    private int defense;
    private int xp;
    private int level;
    
    public Entity(int power, int movement, int defense) {
        try {
            setPower(power);
            setMovement(movement);
            setDefense(defense);
        } catch (EntityException e) {
            return;
        }
    }
    
    public Entity(int power, int movement, int defense, int xp) {
        try {
            setPower(power);
            setMovement(movement);
            setDefense(defense);
            setXp(xp);
        } catch (EntityException e) {
            return;
        }
    }
    
    // Getters
    
    public int getPower() { return power; }
    public int getMovement() { return movement; }
    public int getDefense() { return defense; }
    public int getXp() { return xp; }
    public int getLevel() { return level; }
    
    // Setters
    public void setPower(int power) throws EntityException {
        if (power < 0) throw new EntityException("Power can't be negative");
        this.power = power;
    }
    
    public void setMovement(int movement) throws EntityException {
        if (movement < 0) throw new EntityException("Movement can't be negative");
        this.movement = movement;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public void setXp(int xp) throws EntityException {
        if (xp < 0) throw new EntityException("XP can't be negative");
        this.xp = xp;
    }
    
    // I am stupid haha
    public void calculateLevel() {
        int newLevel = (int) Math.log((double) xp / 10);
        if (newLevel > level) {
            level = newLevel;
            levelUp();
        }
    }
    
    public abstract void levelUp(); // set defense, movement + power  -  dependant on level
    
    public void takeDamage(int damage) {
        setDefense(defense - damage);
    }
    
    public void rest(int heal) {
        setDefense(defense - heal);
    }
    
    public void attack(Entity en) {
        en.takeDamage(power);
    }
}
