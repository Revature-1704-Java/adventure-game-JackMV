package com.revature;

import java.util.ArrayList;

public interface Area {
  public String getName();
  public void setName(String name);
  public String getDescription();
  public void setDescription(String description);
  public ArrayList<Area> getExits();
  public void addExit(Area exit);
  public String getExitsAsString();
}
