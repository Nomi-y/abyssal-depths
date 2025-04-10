public abstract class Enemy extends Entity {
    
    public boolean isAgressive;
    
    public Enemy(int power, int movement, int defense, int xp, boolean agressive) throws EntityException {
        super(power, movement, defense, xp);
        isAgressive = agressive;
    }

    public boolean isAgressive() {
        return isAgressive;
    }

    public void setAgressive(boolean agressive) {
        this.isAgressive = agressive;
    }

    public abstract void processTurn();
    @Override
    public String toString() {
    return super.toString() + " [Aggressive=" + isAgressive + "]";
    }


}
