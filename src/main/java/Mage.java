public class Mage extends Player {
    private int mana = 10;

    public Mage(int power, int movement, int defense, int xp) throws EntityException{
        super(power, movement, defense, xp);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void abilityOffensive() {
        System.out.println("No Target");
    }

    public void abilityOffensive(Entity target) {
        int damage = getPower() * 2;

        if (mana >= 5) {
            mana -= 5;
            target.takeDamage(damage);
            System.out.println("Mage casts Fireball on target");
        } else {
            System.out.println("Not enough mana to cast Fireball.");
        }
    }

    @Override
    public void abilitySpecial() {
        int manaGain = 10;
        int selfDamage = 3;

        if (getDefense() > selfDamage) {
            setDefense(getDefense() - selfDamage);
            mana += manaGain;
            System.out.println("Mage channels Arcane Surge");
        } else {
            System.out.println("Not enough HP to channel Arcane Surge.");
        }
    }

    @Override
    public void abilityUtility() {
        System.out.println("No Target");
    }

    public void abilityUtility(Entity target) {
        int regen = 5;
        mana += regen;
        System.out.println("Mage meditates and restores " + regen + " mana.");
    }

    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 2);
            setMovement(getMovement() + 2);
            setDefense(getDefense() + 1);
            mana += 5;
        } catch (EntityException e) {
            System.out.println("Mage failed to level up.");
        }
    }

    @Override
    public String toString() {
    return super.toString() + " [Mana=" + mana + "]";
    }

}
