package test.characterTest;

import code.character.NPC;
import code.character.Player;
import code.enumeration.Level;
import code.exit.Exit;
import code.item.Food;
import code.item.Item;
import code.item.Key;
import code.place.Place;
import code.place.Shop;
import code.place.game.TicTacToe;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player1;
    Player player2;
    Player player3;

    TicTacToe game;
    Place place;
    Shop shop;

    Food chocoPipe;
    Key chocoKey;

    @Before
    public void setUp(){

        game = new TicTacToe();

        place = new Place("Place",
                "NULL",
                new NPC("NPC place"));

        shop = new Shop("Shop",
                "NULL",
                new NPC("NPC shop"));

        place.addExit(new Exit(game, true));
        place.addExit(new Exit(shop, false));

        game.addExit(new Exit(place, false));
        shop.addExit(new Exit(place, false));

        chocoPipe = new Food("ChocoPipe", 60, 30);
        chocoKey = new Key("ChocoKey", 25, Level.COPPER);

        player1 = new Player("Player1", place);
        player2 = new Player("Player2", game);
        player3 = player1;
    }

    @Test
    public void getPlace() {
        assertEquals(player1.getPlace(), place);
        assertEquals(player2.getPlace(), game);
        assertSame(player1.getPlace(), player3.getPlace());
    }

    @Test
    public void getIsLose() {
        assertFalse(player1.getIsLose());

        player2.decreaseHealth(9999);
        assertTrue(player2.getIsLose());

        assertSame(player1.getIsLose(), player3.getIsLose());
    }

    @Test
    public void getItems() {
        List<Item> li1 = new ArrayList<>();
        List<Item> li2 = new ArrayList<>();
        li2.add(chocoKey);


        assertEquals(player1.getItems(), li1);

        player1.addItem(chocoPipe);
        assertEquals(player2.getItems(), li1);

        player2.addItem(chocoKey);
        assertEquals(player2.getItems(), li2);

        assertSame(player1.getItems(), player3.getItems());

    }

    @Test
    public void getGamesFinished() {

        assertEquals(player1.getGamesFinished(), 0);

        game.win(player2);
        assertEquals(player2.getGamesFinished(), 1);

        assertSame(player1.getGamesFinished(), player3.getGamesFinished());
    }

    @Test
    public void increaseHealth() {

        assertFalse(player1.increaseHealth(50));

        player2.decreaseHealth(50);
        assertTrue(player2.increaseHealth(10));
    }

    @Test
    public void earnMoney() {
    }

    @Test
    public void loseMoney() {
    }

    @Test
    public void addItem() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void increaseGameFinished() {
    }

    @Test
    public void goToPlace() {
    }
}