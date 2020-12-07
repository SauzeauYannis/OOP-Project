package test.commandTest;

import code.character.Player;
import code.command.Go;
import code.place.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GoTest {

    @Test
    public void executeCommand() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(0));
        Go go = new Go();

        go.executeCommand(player, "go copper".split(" "));
        assertEquals(player.getPlace().getName(), placeList.get(1).getName());

        go.executeCommand(player, "go carnival".split( " "));
        assertSame(player.getPlace(), placeList.get(0));
    }
}