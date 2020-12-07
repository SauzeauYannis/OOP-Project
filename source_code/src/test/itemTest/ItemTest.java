package test.itemTest;

import code.character.Player;
import code.item.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    Item item;

    @Before
    public void setUp() {
        item = new Item("Item Test", 10, "This is a item test") {
            @Override
            public void use(Player player) {}
        };
    }

    @Test
    public void getName() {
        assertEquals("Item Test",item.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(10,item.getPrice());
    }
}