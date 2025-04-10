public class Tank extends Player {

    public Tank(int power, int movement, int defense, int xp) throws EntityException {
        super(power, movement, defense, xp);
    }

    @Override
    public void abilityOffensive() {
        System.out.println("No Target");
    }

    public void abilityOffensive(Entity target) {
        int damage = getPower() * 2;
        target.takeDamage(damage);
        System.out.println("Tank slams the target for " + damage + " damage!");
    }


    @Override
    public void abilitySpecial() {
        System.out.println("Tank activates Fortress Mode");
        setDefense(getDefense() + 6);
    }

    @Override
    public void abilityUtility() {
        System.out.println("No Target");
    }

    public void abilityUtility(Entity target) {
        System.out.println("Tank shields an ally: +2 Defense for the target.");
        target.setDefense(target.getDefense() + 2);
    }


    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 1);
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 4);
        } catch (EntityException e) {
            System.out.println("Tank failed to level up.");
        }
    }

    @Override
    public String toString() {
    return super.toString();
    }

}
