package com.revature;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class GameTest {
  ExitArea ea;
  ItemArea ia;
  BasicArea ba;
  Game g;

  @Before
  public void setup() {
    ea = new ExitArea();
    ia = new ItemArea();
    ba = new BasicArea();
    g = new Game();
  }

  @Test
  public void winInRightAreaWithItem() {
    g.setCurrentArea(ea);
    g.setWalletArea(ia);
    ia.takeItem();
    assertTrue(g.checkWin());
  }

  @Test
  public void cantWinInWrongArea() {
    g.setCurrentArea(ba);
    g.setWalletArea(ia);
    ia.takeItem();
    assertFalse(g.checkWin());
  }

  @Test
  public void cantWinWithoutWallet() {
    g.setCurrentArea(ea);
    g.setWalletArea(ia);
    assertFalse(g.checkWin());
  }
}
