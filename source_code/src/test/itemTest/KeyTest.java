package test.itemTest;

import code.character.Player;
import code.enumeration.Level;
import code.exit.Exit;
import code.item.Key;
import code.place.Place;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KeyTest {

    Key key;

    @Before
    public void setUp(){
        key = new Key("KeyTest",5, Level.COPPER);
    }

    @Test
    public void getLevel() {
        assertEquals(Level.COPPER,key.getLevel());
    }

    @Test
    public void use() {
        List<Place> placeList = Place.generateAllPlaces();
        Exit.generateAllExits(placeList);

        Player player = new Player("Player", placeList.get(1));
        player.addItem(key);
        key.use(player);

        assertFalse(placeList.get(1).getExitList().get(1).isLock());
        assertTrue(player.getItems().isEmpty());
    }
}