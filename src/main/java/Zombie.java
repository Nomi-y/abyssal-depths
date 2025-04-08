public class Zombie extends Enemy {
    private boolean captain;

    public Zombie(int power, int movement, int defense, int xp, boolean agressive, boolean captain) throws EntityException {
        super(power, movement, defense, xp, agressive);
        this.captain = captain;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public Zombie callReinforcements() {
        try {
            return new Zombie(2, 1, 5, 0, true, false);
        } catch (EntityException e) {
            System.out.println("Reinforcement failed.");
            return null;
        }
    }


    @Override
    public void processTurn() {
        if (captain) {
            Zombie reinforcement = callReinforcements();
            if (reinforcement != null) {
                System.out.println("Captain Zombie called for reinforcements!");
            }
        } else {
            rest(1);
            System.out.println("Zombie rests.");
        }
    }


    @Override
    public void levelUp() {
        try {
            setDefense(getDefense() + 4);
            setPower(getPower() + 1);
            setMovement(getMovement() + 1);
        } catch (EntityException e) {
            System.out.println("Zombie failed to level up.");
        }
    }

    @Override
    public String toString() {
    return super.toString() + " [Captain=" + captain + "]";
    }

}
