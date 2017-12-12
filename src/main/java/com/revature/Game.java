package com.revature;

public class Game {
	private Area currentArea;
	private ItemArea walletArea;
	private Parser p;
	private boolean gameState = true;
	private static Game game;


	public static void main(String[] args) {
		game = new Game();
		game.playGame();
	}

	public Game() {
		p = new Parser();
		setupGame();
	}

	private void playGame() {
		while(gameState) {
			if (game.checkWin()){
				break;
			}
			System.out.println("\nYou are at " + currentArea.getName() + " what would you like to do?");
			System.out.println("Options are go, describe, nothing, get and quit.");
			Command doThis = new Command(p.getInput());
			if (doThis.validateCommand()) {
				int retVal = doThis.execute(currentArea);
				if (retVal == 0) {
					boolean validLocation = false;
					while (!validLocation) {
						String desiredArea = p.getInput();
						for(Area a:currentArea.getExits()) {
							if (desiredArea.equals(a.getName())) {
								currentArea = a;
								validLocation = true;
								}
							}
							if(validLocation) {
								break;
							}
							System.out.println("\nNot a valid option.");
							System.out.println("Options are " + currentArea.getExitsAsString());
						}
				} else if (retVal == -1) {
					gameState = false;
				} else if (retVal == 2) {
					this.walletArea.takeItem();
				}
			} else {
				System.out.println("Please enter a valid option.\n");
			}
		}
		System.out.println("Congratulations, you found your wallet and got back home!");
	}

	private void setupGame(){
		AreaBuilder ab = new AreaBuilder();
		Area work = ab.makeArea("Work", "The best place on earth!", "basic");
		Area store = ab.makeArea("Store", "Time to spend that hard earned money!", "item");
		Area home = ab.makeArea("Home", "Home sweet home.", "exit");
		Area bed = ab.makeArea("Bed", "Better rest up! You have a big day tomorrow.", "basic");
		Area outside = ab.makeArea("Outside", "It's so cold, I should go somewhere else.", "basic");

		walletArea = (ItemArea) store;

		work.addExit(outside);
		store.addExit(outside);
		home.addExit(outside);
		home.addExit(bed);
		bed.addExit(home);
		outside.addExit(home);
		outside.addExit(store);
		outside.addExit(work);

		currentArea = home;

		System.out.println("It's the weekend and you forgot your wallet somewhere.");
		System.out.println("Better go find it so you can get on with your life.");
	}

	public void setCurrentArea(Area a) {
		this.currentArea = a;
	}

	public void setWalletArea(Area a) {
		this.walletArea = (ItemArea)a;
	};

	public boolean checkWin() {
		return (currentArea instanceof ExitArea && walletArea.haveItem());
	}
}
