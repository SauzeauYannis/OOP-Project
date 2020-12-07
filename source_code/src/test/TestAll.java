package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.commandTest.CommandTest;
import test.placeTest.GameTest;
import test.placeTest.PlaceTest;
import test.placeTest.ShopTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlaceTest.class,
        ShopTest.class,
        GameTest.class,
        CommandTest.class
})
public class TestAll {
}
