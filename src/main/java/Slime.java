import java.util.ArrayList;

public class Slime extends Enemy {
    int splitLevel ;

    public Slime(int power, int movement, int defense, int xp, boolean agressive, int splitLevel) throws EntityException {
        super(power, movement, defense, xp, agressive);
        this.splitLevel = splitLevel;
    }

    public ArrayList<Slime> split() {
        ArrayList<Slime> clones = new ArrayList<>();
        try {
            int newPower = Math.max(1, getPower() / 2);
            int newMovement = Math.max(1, getMovement() / 2);
            int newDefense = Math.max(1, getDefense() / 2);
            int newXp = getXp() / 2;

            Slime s1 = new Slime(newPower, newMovement, newDefense, newXp, isAgressive(), this.splitLevel);
            Slime s2 = new Slime(newPower, newMovement, newDefense, newXp, isAgressive(), this.splitLevel);

            clones.add(s1);
            clones.add(s2);
        } catch (EntityException e) {
            System.out.println("Send Help");
        }
        return clones;
    }


    @Override
    public void processTurn() {
        if (getDefense() < 10 && getLevel() > splitLevel && getDefense() >= 2) {
            ArrayList<Slime> children = split();
            System.out.println("Slime split into " + children.size() + " new Slimes.");
        } else {
            rest(2);
            System.out.println("Slime rests.");
        }
    }


    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 1);
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 2);
        } catch (EntityException e) {
            System.out.println("Couldnt level up");
        }
    }

}
