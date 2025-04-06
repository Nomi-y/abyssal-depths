public class Warrior extends Player {

    public Warrior(int power, int movement, int defense, int xp) throws  EntityException{
        super(power, movement, defense, xp);
    }

    @Override
    public void abilityOffensive() {
        System.out.println("Warrior performs a heavy strik");
        try {
            setPower(getPower() + 5);
        } catch (EntityException e) {
            System.out.println("Failed to apply heavy strike.");
        }
    }

    @Override
    public void abilitySpecial() {
        System.out.println("Warrior enters Berserk mode");
        try {
            setPower(getPower() *2);
            setDefense(getDefense() / 2);
        } catch (EntityException e) {
            System.out.println("Failed to enter Berserk mode.");
        }
    }

    @Override
    public void abilityUtility() {
        System.out.println("No Target found");
    }

    public void abilityUtility(Entity target) {
        System.out.println("Warrior uses Shield Dash!");

        target.takeDamage(2);

        try {
            int newMovement = Math.max(0, target.getMovement() - 1);
            target.setMovement(newMovement);
        } catch (EntityException e) {
            System.out.println("Shield Bash failed to apply slow.");
        }
    }

    @Override
    public void levelUp() {
        try {
            setPower(getPower() + 3);
            setMovement(getMovement() + 1);
            setDefense(getDefense() + 2);
        } catch (EntityException e) {
            System.out.println("Warrior failed to level up.");
        }
    }
}
