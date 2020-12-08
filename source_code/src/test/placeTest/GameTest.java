package test.placeTest;

import code.character.NPC;
import code.character.Player;
import code.Level;
import code.place.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game1;
    Game game2;
    Game game3;
    Player player;

    @Before
    public void setUp() {
        game1 = new Game("game 1",
                "game 1 description",
                new NPC("game 1 npc"),
                Level.COPPER) {
            @Override
            public void play(Player player) {
                System.out.println("play game 1");
            }
        };
        game2 = new Game("game 2",
                "game 2 description",
                new NPC("game 2 npc"),
                Level.PLATINUM) {
            @Override
            public void play(Player player) {
                System.out.println("play game 2");
            }
        };
        game3 = game1;
        player = new Player("player", game1);
    }

    @Test
    public void getLevel() {
        assertEquals(game1.getLevel(), Level.COPPER);
        assertEquals(game2.getLevel(), Level.PLATINUM);
        assertEquals(game3.getLevel(), game1.getLevel());
    }

    @Test
    public void win() {
        game1.win(player);
        game2.win(player);
        game3.win(player);
        game1.win(player);
        assertEquals(2, player.getGamesFinished());
    }

    @Test
    public void lose() {
        for (int i = 0; i < 10; i++) {
            game1.lose(player);
        }
        assertTrue(player.getIsLose());
    }
}