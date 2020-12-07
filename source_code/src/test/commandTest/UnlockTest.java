package test.commandTest;

import code.character.Player;
import code.place.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UnlockTest {

    @Test
    public void executeCommand() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(0));
    }
}