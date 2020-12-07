package test.commandTest;

import code.character.Player;
import code.command.Unlock;
import code.enumeration.Level;
import code.item.Key;
import code.place.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UnlockTest {

    @Test
    public void executeCommand() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(1));
        Unlock unlock = new Unlock();

        unlock.executeCommand(player, "unlock find".split( " "));
        player.goToPlace("find");
        assertSame(player.getPlace(), placeList.get(1));

        player.addItem(new Key("Copper key", 25, Level.COPPER));
        unlock.executeCommand(player, "unlock find".split(" "));
        player.goToPlace("find");
        assertSame(player.getPlace(), placeList.get(6));
        assertEquals(player.getItems().size(), 0);
    }
}