package test.exitTest;

import code.character.NPC;
import code.exit.Exit;
import code.place.Place;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class ExitTest {

    Exit exitA;
    Exit exitB;
    Exit exitC;
    Place place1 = new Place("place1","on est là",new NPC("NPC 1"));

    @Before
    public void setUp() {
        exitA = new Exit(place1,true);
        exitB = new Exit(place1,false);
        exitC = exitA;
    }

    @Test
    public void getPlace() {
        assertEquals(place1,exitA.getPlace());
        assertEquals(place1,exitB.getPlace());
        assertEquals(place1,exitC.getPlace());
    }

    @Test
    public void isLock() {
        assertTrue(exitA.isLock());
        assertFalse(exitB.isLock());
        assertTrue(exitC.isLock());
    }

    @Test
    public void unlock() {
        exitA.unlock();
        exitB.unlock();
        exitC.unlock();
        assertFalse(exitA.isLock());
        assertFalse(exitB.isLock());
        assertFalse(exitC.isLock());
    }

    @Test
    public void generateAllExits() {
        List<Place> placeList = Place.generateAllPlaces();
        List<Exit> exitList = Exit.generateAllExits(placeList);

        for (int i=0; i<exitList.size(); i++) {
            assertSame(exitList.get(i).getPlace(),placeList.get(i));
        }
    }
}