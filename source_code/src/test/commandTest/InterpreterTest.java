package test.commandTest;

import code.character.Player;
import code.command.Interpreter;
import code.place.Place;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InterpreterTest {

    @Test
    public void interpretCommand() {
        List<Place> placeList = Place.generateAllPlaces();
        Player player = new Player("player", placeList.get(0));
        Interpreter.interpretCommand(player, "go copper");

        assertEquals(player.getPlace().getName(), "Copper hub");
    }

    @Test
    public void getFirstWord() {
        assertEquals(Interpreter.getFirstWord("Go copper"), "go");
        assertEquals(Interpreter.getFirstWord("Copper hub"), "copper");
        assertEquals(Interpreter.getFirstWord("a b c"), "a");
    }
}