package test.itemTest;

import code.character.NPC;
import code.character.Player;
import code.item.Food;
import code.place.Place;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {

    Food food;

    @Before
    public void setUp() throws Exception {
        food = new Food("FoodTest", 10, 5);
    }

    @Test
    public void use() {
        Player player = new Player("Player",new Place("Place","It is a test place",new NPC("NPC")));
        player.decreaseHealth(10);
        player.addItem(food);
        food.use(player);

        assertFalse(player.getItems().contains(food));
        //assertEquals(95,player.getHealth);
    }
}