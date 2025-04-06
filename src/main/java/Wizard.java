import java.util.ArrayList;

public class Wizard extends Enemy {
    private int mana;

    public Wizard(int power, int movement, int defense, int xp, boolean aggressive, int mana) throws EntityException {
        super(power, movement, defense, xp, aggressive);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public ArrayList<Skeleton> summonCreature(int amount) {
        ArrayList<Skeleton> summoned = new ArrayList<>();
        try {
            if (mana >= amount * 5) {
                for (int i = 0; i < amount; i++) {
                    Skeleton s = new Skeleton(3, 2, 4, 0, true, 5);
                    summoned.add(s);
                }
                mana -= amount * 5;
                System.out.println("Summoned " + amount + " skeletons.");
            } else {
                System.out.println("Not enough mana to summon.");
            }
        } catch (EntityException e) {
            System.out.println("Summoning failed.");
        }
        return summoned;
    }

    @Override
    public void processTurn() {
        if (mana >= 5) {
            summonCreature(1);
        } else {
            rest(2);
            mana += 3; // Regeneriert Mana beim Ruhen
            System.out.println("Skeleton Wizard rests and regains mana.");
        }
    }

    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 1);
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 2);
            mana += 5;
        } catch (EntityException e) {
            System.out.println("Skeleton Wizard failed to level up.");
        }
    }
}
