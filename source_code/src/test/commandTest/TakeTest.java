package test.commandTest;

import code.character.Player;
import code.command.Take;
import code.place.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TakeTest {

    @Test
    public void executeCommand() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(5));
        Take take = new Take();

        take.executeCommand(player, "take apple".split(" "));
        assertEquals(player.getItems().size(), 1);
        take.executeCommand(player, "take cotton".split(" "));
        take.executeCommand(player, "take chocolate".split(" "));
        take.executeCommand(player, "take pear".split(" "));
        assertEquals(player.getItems().size(), 3);
    }
}