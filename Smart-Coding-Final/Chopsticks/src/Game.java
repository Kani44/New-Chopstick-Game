import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        /*Player p = new Player();
        System.out.println(p.getLeft().getFingers());*/
    	chopsticks();
    } 
    
    public static void chopsticks() {
    	Scanner keyboard = new Scanner(System.in);
    	Player p1 = new Player();
		Player p2 = new Player();
		askName(keyboard, p1);
		askName(keyboard, p2);
		p2.flipTurn();
		fullDisplay(p1, p2);	

		while (true) {
			
			checkWinner(p1, p2);
			if (p1.getTurn()) {
				p1.combine(p2, formPlusAskQuestion(keyboard, p1, p2));
				fullDisplay(p1, p2);
				checkWinner(p1, p2);
				p2.flipTurn();
				p1.flipTurn();

			} else if (p2.getTurn()) {
				p2.combine(p1, formPlusAskQuestion(keyboard, p2, p1));
				fullDisplay(p1, p2);
				checkWinner(p1, p2);
				p2.flipTurn();
				p1.flipTurn();

			}



		}


    }
    
    public static void askName(Scanner object, Player player) {
    	System.out.print(String.format("%s, what is your name? ", player.getName()));
    	String name = object.nextLine();
    	player.setName(name);
    	System.out.println();
    }
    public static String formPlusAskQuestion(Scanner object, Player me, Player other) {
    	ArrayList<String> choices = new ArrayList<String>(Arrays.asList("ll", "lr", "rl", "rr"));
    	ArrayList<String> longChoices = new ArrayList<String>(Arrays.asList("left-left", "left-right", "right-left", "right-right"));

    	if (!me.getLeft().getValid() || !other.getLeft().getValid()) {
    		choices.remove("ll");
    		longChoices.remove("left-left");
    	}
    	if (!me.getRight().getValid() || !other.getRight().getValid()) {
    		choices.remove("rr");
    		longChoices.remove("right-right");
    	}
    	if (!me.getLeft().getValid() || !other.getRight().getValid()) {
    		choices.remove("lr");
    		longChoices.remove("left-right");
    	}
    	if (!me.getRight().getValid() || !other.getLeft().getValid()) {
    		choices.remove("rl");
    		longChoices.remove("right-left");
    	}
    	
    	String shortPrompt = "";
    	String longPrompt = "";
    	String end = ", ";
    	String longEnd = ", ";
    	for (int i = 0; i < choices.size(); i++) {
    		if (i == choices.size() -1) {
    			end = ")";
    		}
    		shortPrompt = shortPrompt  + choices.get(i) + end; 
    	}
    	for (int i = 0; i < longChoices.size(); i++) {
    		if (i == longChoices.size() -1) {
    			longEnd = "?";
    		}
    		longPrompt = longPrompt  + longChoices.get(i) + longEnd; 
    	}
    	
    	String question = String.format("%s would you like to move %s (Type: %s ", me.getName(), longPrompt, shortPrompt);
    	System.out.print(question);
    	String ans = object.nextLine();
    	
    	//boolean checker = false; 
    	while (!choices.contains(ans.toLowerCase().strip())) {
			System.out.print(String.format("Please choose a valid option - (%s ", shortPrompt));
			ans = object.nextLine();
		} 
        
		
		return ans; 
    	
    	
    	
    	
    	//String questionPart1 = String.format("%s would you like to move ", me.getName());
    	//String questionPart2 = " (Type : "
    	
    	
	}
	public static void checkWinner(Player p1, Player p2) {
		if (p1.getLeft().getFingers() == 0 && p1.getRight().getFingers() == 0) {
			System.out.println("\n");
			System.out.println(p1.getName() + " has 0 sticks!");
			System.out.println(p2.getName() + " is the WINNER!");
			System.exit(0);
		} else if (p2.getLeft().getFingers() == 0 && p2.getRight().getFingers() == 0) {
			System.out.println("\n");
			System.out.println(p2.getName() + " has 0 sticks!");
			System.out.println(p1.getName() + " is the WINNER!");
			System.exit(0);
		}
	}
   
	public static void fullDisplay(Player p1, Player p2) {
		p2.getRight().display(p2.getLeft());
		p1.getLeft().display(p1.getRight());


	}
    
    
    
        
    

}
