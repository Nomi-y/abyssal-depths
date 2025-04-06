public class Dragon extends Enemy {
    private int sizeClass;

    public Dragon(int power, int movement, int defense, int xp, boolean aggressive, int sizeClass) throws EntityException {
        super(power, movement, defense, xp, aggressive);
        this.sizeClass = sizeClass;
    }

    public int getSizeClass() {
        return sizeClass;
    }

    public void setSizeClass(int sizeClass) {
        this.sizeClass = sizeClass;
    }

    @Override
    public void processTurn() {
        System.out.println("No target");
    }

    public void processTurn(Entity target) {
        int damage = getPower() * sizeClass;
        target.takeDamage(damage);
        System.out.println("Dragon breathes fire and deals " + damage + " damage!");
    }


    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 3 * sizeClass);  // skalierend nach Größe
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 5);
        } catch (EntityException e) {
            System.out.println("Dragon failed to level up.");
        }
    }
}
