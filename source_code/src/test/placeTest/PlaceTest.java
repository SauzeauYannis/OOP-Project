package test.placeTest;

import code.character.NPC;
import code.place.exit.Exit;
import code.place.Place;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlaceTest {

    Place placeA;
    Place placeB;
    Place placeC;

    @Before
    public void setUp(){
        placeA = new Place("place A",
                "description to place A",
                new NPC("place A NPC"));
        placeB = new Place("place B",
                "description to place B",
                new NPC("place B NPC"));
        placeA.addExit(new Exit(placeB, true));
        placeB.addExit(new Exit(placeA, false));
        placeC = placeA;
    }

    @Test
    public void getName() {
        assertEquals(placeA.getName(), "place A");
        assertEquals(placeB.getName(), "place B");
        assertSame(placeA.getName(), placeC.getName());
    }

    @Test
    public void getExitList() {
        assertEquals(placeA.getExitList().get(0).getPlace(), placeB);
        assertEquals(placeB.getExitList().get(0).getPlace(), placeA);
        assertSame(placeA.getExitList(), placeC.getExitList());
    }

    @Test
    public void getNpc() {
        assertEquals(placeA.getNpc().getName(), "place A NPC");
        assertEquals(placeB.getNpc().getName(), "place B NPC");
        assertSame(placeA.getNpc(), placeC.getNpc());
    }

    @Test
    public void generateAllPlaces() {
        List<Place> placeList = Place.generateAllPlaces();

        assertSame(placeList.get(0).getNpc(), placeList.get(3).getNpc());
        assertSame(placeList.get(6).getExitList().get(0), placeList.get(7).getExitList().get(0));
        assertSame(placeList.get(9).getExitList().get(0), placeList.get(10).getExitList().get(0));
        assertSame(placeList.get(12).getExitList().get(0), placeList.get(13).getExitList().get(0));
    }
}