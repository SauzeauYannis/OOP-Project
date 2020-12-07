package test.characterTest;

import code.character.Character;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    Character character1;


    @Before
    public void setUp(){
        character1 = new Character("Character1"){};
    }

    @Test
    public void getName() {
        assertEquals(character1.getName(), "Character1");
    }

    @Test
    public void testToString() {
        assertEquals(character1.toString(), "[Character1] : ");
    }
}