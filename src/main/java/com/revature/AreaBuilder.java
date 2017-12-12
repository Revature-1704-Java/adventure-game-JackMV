package com.revature;

public class AreaBuilder {
  AreaBuilder(){

  }

  public Area makeArea(String name, String description, String type) {
    if(type.equals("basic")) {
      return new BasicArea(name, description);
    } else if (type.equals("item")) {
      return new ItemArea(name, description);
    } else if (type.equals("exit")) {
      return new ExitArea(name, description);
    } return null;
  }
}
