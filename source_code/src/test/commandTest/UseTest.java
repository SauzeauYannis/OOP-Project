package test.commandTest;

import code.character.Player;
import code.command.Unlock;
import code.command.Use;
import code.enumeration.Level;
import code.item.Food;
import code.item.Key;
import code.place.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UseTest {

    @Test
    public void executeCommand1() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(1));
        Use use = new Use();

        use.executeCommand(player, "use copper".split( " "));
        player.goToPlace("find");
        assertSame(player.getPlace(), placeList.get(1));

        player.addItem(new Key("Copper key", 25, Level.COPPER));
        use.executeCommand(player, "use copper".split(" "));
        player.goToPlace("find");
        assertSame(player.getPlace(), placeList.get(6));
        assertEquals(player.getItems().size(), 0);
    }

    @Test
    public void executeCommand2() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(0));
        Use use = new Use();

        player.addItem(new Food("Apple candy", 5, 5));
        use.executeCommand(player, "use appl".split( " "));
        use.executeCommand(player, "use apple".split( " "));
        assertEquals(player.getItems().size(), 1);

        player.decreaseHealth(5);
        use.executeCommand(player, "use apple".split( " "));
        assertEquals(player.getHealth(), 100);
        assertEquals(player.getItems().size(), 0);
    }
}