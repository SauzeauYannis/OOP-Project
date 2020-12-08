package test.placeTest;

import code.character.NPC;
import code.Level;
import code.item.Food;
import code.item.Item;
import code.item.Key;
import code.place.Shop;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {

    Shop shopA;
    Shop shopB;
    Shop shopC;

    @Before
    public void setUp() {
        shopA = new Shop("shop A",
                "description to shop A",
                new NPC("shop A NPC"));
        shopB = new Shop("shop B",
                "description to shop B",
                new NPC("shop B NPC"));
        shopA.addItem(new Key("key 1", 1, Level.COPPER));
        shopA.addItem(new Key("key 2", 2, Level.GOLD));
        shopB.addItem(new Food("food", 1, 1));
        shopC = shopA;
    }

    @Test
    public void getItemList() {
        List<Item> shopListA = shopA.getItemList();
        List<Item> shopListB = shopB.getItemList();

        assertEquals(2, shopListA.size());
        assertEquals(1, shopListB.size());

        assertEquals(shopListA.get(1).getPrice(), 2);
        assertEquals(shopListB.get(0).getName(), "food");
    }
}