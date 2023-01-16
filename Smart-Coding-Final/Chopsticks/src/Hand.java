
public class Hand {
	private int fingers;
	private String side;
	private boolean isValid; 
	

	public Hand(String type) {
		fingers = 1; 
		side = type; 
		isValid = true;
	}
	
	public int getFingers() {
		return fingers; 
	}
	public void setFingers(int num) {
		fingers = num; 
	}
	public String getSide() {
		return side; 
	}
	
	/** 
	 * @param hand
	 * Parameter should be right hand
	 */
	public void display(Hand hand) {
		System.out.println("");
			if (fingers > 0){
				if (hand.getFingers() == 0)
					System.out.println(" " + this.side);
				else 
					System.out.print(" " + this.side);

			}
			if (hand.getFingers() > 0) {
				for (int i = 0; i < fingers; i +=1)
					System.out.print(" ");
				System.out.println("   " + hand.getSide());
			}
			//Top of Stick 
			for (int i = 1; i <= fingers; i++) 
				System.out.print(" - ");
			System.out.print("  ");
			for (int j = 1; j <= hand.getFingers(); j++) 
				System.out.print(" - ");
			System.out.println("");
			
			//Middle of Stick
			for (int k = 1; k <= 4; k++) {
				for (int i = 1; i <= fingers; i++) 
					System.out.print(" | ");
				
				System.out.print("  ");
				for (int j = 1; j <= hand.getFingers(); j++) 
					System.out.print(" | ");
				System.out.println("");
			}
			
			//End of Stick 
			for (int i = 1; i <= fingers; i++) 
				System.out.print(" - ");
			System.out.print("  ");
			for (int j = 1; j <= hand.getFingers(); j++) 
				System.out.print(" - ");	
			System.out.println("");
	}
	/*public void reflectDisplay() {  //display() prints out the reflected current state of the  chopsticks
			
		//Prints Left and Right labels
		System.out.println("");
		if (this.right > 0)
			System.out.print(" Right");
		if (this.left > 0) {
			for (int i = 0; i <= this.right; i +=1)
				System.out.print(" ");
			System.out.println("   Left");
		}
		//Top of Stick 
		for (int i = 1; i <= this.right; i++) 
			System.out.print(" - ");
		System.out.print("  ");
		for (int j = 1; j <= this.left; j++) 
			System.out.print(" - ");
		System.out.println("");
		
		//Middle of Stick
		for (int k = 1; k <= 4; k++) {
			for (int i = 1; i <= this.right; i++) 
				System.out.print(" | ");
			
			System.out.print("  ");
			for (int j = 1; j <= this.left; j++) 
				System.out.print(" | ");
			System.out.println("");
		}
		
		//End of Stick 
		for (int i = 1; i <= this.right; i++) 
			System.out.print(" - ");
		System.out.print("  ");
		for (int j = 1; j <= this.left; j++) 
			System.out.print(" - ");	
		System.out.println("");
		
	}*/
	
	public boolean getValid( ) {
		return isValid; 
	}
	public void setValid(boolean change) {
		isValid = change; 
	}
}
