package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.characterTest.CharacterTest;
import test.characterTest.PlayerTest;
import test.commandTest.*;
import test.exitTest.ExitTest;
import test.itemTest.FoodTest;
import test.itemTest.ItemTest;
import test.itemTest.KeyTest;
import test.placeTest.GameTest;
import test.placeTest.PlaceTest;
import test.placeTest.ShopTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        //characterTest
        CharacterTest.class,
        PlayerTest.class,

        //commandTest
        CommandTest.class,
        GoTest.class,
        InterpreterTest.class,
        TakeTest.class,
        UnlockTest.class,
        UseTest.class,

        //exitTest
        ExitTest.class,

        //itemTest
        FoodTest.class,
        ItemTest.class,
        KeyTest.class,

        //placeTest
        GameTest.class,
        PlaceTest.class,
        ShopTest.class,
})
public class TestAll {
}
