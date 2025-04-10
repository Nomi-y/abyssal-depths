public class Skeleton extends Enemy {
    private int arrows;

    public Skeleton(int power, int movement, int defense, int xp, boolean aggressive, int arrows) throws EntityException {
        super(power, movement, defense, xp, aggressive);
        this.arrows = arrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public void rangedAttack(Entity target) {
        if (arrows > 0) {
            target.takeDamage(getPower());
            arrows--;
        } else {
            System.out.println("No arrows left.");
        }
    }

    @Override
    public void processTurn() {
        System.out.println("No Target");
    }

    public void processTurn(Entity target) {
        if (arrows > 0) {
            rangedAttack(target);
            System.out.println("Skeleton shoots an arrow.");
        } else {
            rest(1);
        }
    }

    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 1);
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 1);
            arrows += 3;
        } catch (EntityException e) {
            System.out.println("Skeleton failed to level up.");
        }
    }

    @Override
    public String toString() {
    return super.toString() + " [Arrows=" + arrows + "]";
    }

}

