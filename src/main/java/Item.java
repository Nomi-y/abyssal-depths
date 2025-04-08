import java.util.Comparator;

public class Item extends Entity implements Collectible {

    private String name;
    private final Rarity rarity;
    
    public Item(String name, Rarity r) throws EntityException {
        super(0, 0, 1, 20);
        if (name == null || name.isEmpty()) throw new EntityException("Item must have a name!");
        rarity = r;
    }
    
    public String getName() { return name; }
    public Rarity getRarity() { return rarity; }
    
    
    @Override
    public void levelUp() {}
    
    public int compareTo(Item other) {
        return this.getName().compareToIgnoreCase(other.getName()); // or compare by rarity
    }
    
}
