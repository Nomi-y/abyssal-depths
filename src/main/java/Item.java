public class Item extends Entity implements Collectible {

    private String name;
    private final itemRarity rarity;
    public enum itemRarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY;
    }
    
    public Item(int xp, String name, itemRarity r) throws EntityException {
        super(0, 0, 1, xp);
        if (name == null || name.isEmpty()) throw new EntityException("Item must have a name!");
        rarity = r;
    }
    
    public String getName() { return name; }
    public itemRarity getRarity() { return rarity; }
    
    
    @Override
    public void levelUp() {}
}
