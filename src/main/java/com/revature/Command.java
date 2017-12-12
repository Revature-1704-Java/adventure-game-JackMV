package com.revature;

public class Command {
	private String command;
	private String[] acceptedCommands = {"go", "describe", "get", "nothing", "quit"};

	public Command(){}

	public Command(String command) {
		this.command = command;
	}

	public boolean validateCommand() {
		for(String s : acceptedCommands){
			if(s.equals(this.command)) {
				return true;
			}
		}
		return false;
	}

	public int execute(Area area) {
		if (this.command.equals("go")) {
			System.out.println("\nWhere would you like to go?");
			System.out.println("Options are " + area.getExitsAsString());
			return 0;
		} else if (this.command.equals("describe")) {
			System.out.println(area.getDescription());
			return 1;
		} else if (this.command.equals("nothing")) {
			System.out.println("You do nothing. That won't help you find your wallet!");
			return 1;
		} else if (this.command.equals("quit")) {
			System.out.println("Bye bye!\n");
			return -1;
		} else if (this.command.equals("get")) {
			if (area instanceof ItemArea) {
				System.out.println("You found your wallet, now you can get out of here.");
				return 2;
			} else {
				System.out.println("Your wallet isn't here. Better keep looking.");
				return 1;
			}
		}
		return 1;
	}

	// public void moveTo(Area area) {

	// }
}
