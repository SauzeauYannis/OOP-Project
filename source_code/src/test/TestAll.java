package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.commandTest.CommandTest;
import test.commandTest.InterpreterTest;
import test.exitTest.ExitTest;
import test.placeTest.GameTest;
import test.placeTest.PlaceTest;
import test.placeTest.ShopTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlaceTest.class,
        ShopTest.class,
        GameTest.class,
        CommandTest.class,
        ExitTest.class,
        InterpreterTest.class
})
public class TestAll {
}
