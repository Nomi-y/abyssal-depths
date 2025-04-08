public class Item extends Entity implements Collectible, Comparable<Item> {

    private final String name;
    private final Rarity rarity;

    public Item(String name, Rarity r) throws EntityException {
        super(0, 0, 1, 20);
        if (name == null || name.isEmpty())
            throw new EntityException("Item must have a name!");
        this.name = name;
        rarity = r;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public void levelUp() {
    }

    public int compareTo(Item other) {
        return this.getName().compareToIgnoreCase(other.getName()); // or compare by rarity
    }

    @Override
    public String toString() {
        return "Item [Name=" + name + ", Rarity=" + rarity + "]";
    }

}
