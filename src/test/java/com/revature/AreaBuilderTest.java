package com.revature;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AreaBuilderTest {
  AreaBuilder ab;

  @Before
  public final void initialize() {
    ab = new AreaBuilder();
  }

  @Test
  public final void basicReturnsBasicArea() {
    Area a = ab.makeArea("","","basic");
    assertNotNull(a);
    assertTrue(a instanceof BasicArea);
  }

  @Test
  public final void exitReturnsExitArea() {
    Area a = ab.makeArea("","","exit");
    assertNotNull(a);
    assertTrue(a instanceof ExitArea);
  }

  @Test
  public final void itemReturnsItemArea() {
    Area a = ab.makeArea("","","item");
    assertNotNull(a);
    assertTrue(a instanceof ItemArea);
  }
}
