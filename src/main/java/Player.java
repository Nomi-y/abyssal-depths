public abstract class Player extends Entity {

    public Player(int power, int movement, int defense, int xp) throws EntityException {
        super(power, movement, defense, xp);
    }

    public boolean submitMoves(String action, Entity target) {
        switch (action.toLowerCase()) {
            case "attack":
                if (target != null) {
                    attack(target);
                    System.out.println("Player attacks the target.");
                    return true;
                }
                break;
            case "cast":
                abilityOffensive();
                return true;
            case "rest":
                rest(3);
                System.out.println("Player rests.");
                return true;
            default:
                System.out.println("Unknown command.");
                return false;
        }
        return false;
    }



    public abstract void abilityOffensive();
    public abstract void abilitySpecial();
    public abstract void abilityUtility();
}
