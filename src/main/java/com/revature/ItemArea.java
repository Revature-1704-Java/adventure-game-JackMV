package com.revature;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class ItemArea implements Area {
  private String name;
	private String description;
  private boolean item = true;
	private ArrayList<Area> exits = new ArrayList<Area>(3);

	public ItemArea(){}
	public ItemArea(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addExit(Area exit) {
		this.exits.add(exit);
	}

	public ArrayList<Area> getExits() {
		return this.exits;
	}

	public String getExitsAsString() {
		StringBuilder sb = new StringBuilder();
		ArrayList<Area> exits = this.getExits();
		for (Area a:exits) {
			sb.append(a.getName() + " ");
		}
		return sb.toString();
	}

  public void takeItem() {
    this.item = false;
  }

  public boolean haveItem() {
    return !this.item;
  }
}
