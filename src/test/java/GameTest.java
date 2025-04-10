import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    
    private Game game;
    
    @BeforeEach
    void setUp() {
        game = new Game();
    }
    
    @Test
    void addEnemy_shouldNotWork_emptyList_addNull_throwsException() {
        assertThrows(GameException.class, () -> game.addEnemy(null));
    }
    
    @Test
    void addEnemy_shouldWork_enemyAdded_listSizeIncreased() {
        try {
            Enemy dummyEnemy = new Slime(3,3,3,3,true,3);
            game.addEnemy(dummyEnemy);
            assertEquals(1, game.countEnemies());
        } catch(GameException | EntityException ge) {
            fail();
        }
        
    }
    
    @Test
    void changeGlobalLevel_shouldWork_givenPositiveNumber_levelIncreases() {
        int before = game.getGlobalLevel();
        game.changeGlobalLevel(3);
        assertEquals(before + 3, game.getGlobalLevel());
    }
    
    @Test
    void changeGlobalLevel_shouldWork_givenNegativeNumber_levelDecreases() {
        game.changeGlobalLevel(-1);
        assertEquals(0, game.getGlobalLevel());
    }
    
    @Test
    void updateEnemies_shouldNotFail_givenEmptyList_doesNothing() {
        assertDoesNotThrow(() -> game.updateEnemies());
    }
    
    @Test
    void collect_shouldWork_validItem_itemIsStored() {
        try {
            Item item = new Item("Potion", Rarity.COMMON);
            boolean added = game.collect(item);
            assertTrue(added);
            assertEquals(1, game.countItems());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
    
    @Test
    void sortItems_shouldWork_unsortedItems_sortedByRarityThenName() {
        try {
            game.collect(new Item("B", Rarity.COMMON));
            game.collect(new Item("A", Rarity.RARE));
            game.collect(new Item("A", Rarity.COMMON));
            game.sortItems();
            assertEquals("B", game.getItemByIndex(1).getName());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
    
    @Test
    void getAverageXpOfDefeatedEnemies_shouldWork_mixedEnemies_returns20() {
        try {
            game.setPlayer(new Warrior(99, 99, 99, 99));
            Enemy e1 = new Slime(1, 1, 5, 10, false, 0);
            Enemy e2 = new Slime(1, 1, 5, 30, false, 0);
            game.addEnemy(e1);
            game.addEnemy(e2);
            e1.takeDamage(5);
            e2.takeDamage(5);
            game.updateEnemies();
            assertEquals(20.0, game.getAverageXpOfDefeatedEnemies());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
    
    @Test
    void countEnemiesDefeated_shouldWork_mixedTypes_countsOnlySpecifiedClass() {
        try {
            game.setPlayer(new Warrior(99, 99, 99, 99));
            Enemy s1 = new Slime(1, 1, 3, 10, false, 1);
            Enemy s2 = new Slime(1, 1, 3, 10, false, 1);
            Enemy w1 = new Skeleton(2, 2, 4, 20, true, 0);
            game.addEnemy(s1);
            game.addEnemy(s2);
            game.addEnemy(w1);
            s1.takeDamage(3);
            s2.takeDamage(3);
            w1.takeDamage(4);
            game.updateEnemies();
            assertEquals(2, game.countEnemiesDefeated(Slime.class));
            assertEquals(1, game.countEnemiesDefeated(Skeleton.class));
            assertEquals(0, game.countEnemiesDefeated(Dragon.class));
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    
}
