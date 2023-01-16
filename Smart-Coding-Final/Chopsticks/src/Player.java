public class Player {
	
	private boolean isTurn; 
	private Hand left; 
	private Hand right;
	private String name;
	private static int numPlayers; 
	
	public Player() {
		numPlayers ++;
		left = new Hand("Left"); 
		right = new Hand("Right"); 
		name = String.format("Player %d", numPlayers);
		isTurn = true;
	}
	
	public void combine(Player other, String input) {
		
		//int other.getLeft().getFingers() = other.getLeft().getFingers();
		//int other.getRight().getFingers() = other.getRight().getFingers();
		//int this.left.getFingers() = this.left.getFingers();
		//int this.right.getFingers() = this.right.getFingers();
		
		switch (input.toLowerCase().strip()) {
		
		case "ll":
			other.getLeft().setFingers(other.getLeft().getFingers() + this.left.getFingers());
			if (other.getLeft().getFingers() > 5){
				other.getLeft().setFingers(other.getLeft().getFingers() - 5);
			}
			else if (other.getLeft().getFingers() == 5){
				other.getLeft().setFingers(0);
				other.getLeft().setValid(false);
			}
			break;
		case "lr":
			other.getRight().setFingers(other.getRight().getFingers() + this.left.getFingers());
			if (other.getRight().getFingers() > 5){
				other.getRight().setFingers(other.getRight().getFingers() - 5);
			}
			else if (other.getRight().getFingers() == 5){
				other.getRight().setFingers(0);
				other.getRight().setValid(false);
			}
			break;
		case "rl":
			other.getLeft().setFingers(other.getLeft().getFingers() + this.right.getFingers());
			if (other.getLeft().getFingers() > 5){
				other.getLeft().setFingers(other.getLeft().getFingers() - 5);
			}
			else if (other.getLeft().getFingers() == 5){
				other.getLeft().setFingers(0);
				other.getLeft().setValid(false);
			}
			break;
		case "rr":
			other.getRight().setFingers(other.getRight().getFingers() + this.right.getFingers());
			if (other.getRight().getFingers() > 5){
				other.getRight().setFingers(other.getRight().getFingers() - 5);
			}
			else if (other.getRight().getFingers() == 5){
				other.getRight().setFingers(0);
				other.getRight().setValid(false);
			}
			break;
		default:
			break;
		}
	}
	
	public Hand getLeft() {
		return left;
	}
	public Hand getRight() {
		return right;
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		 this.name  = name; 
	}
	public boolean getTurn() {
		return isTurn; 
	}
	public void flipTurn() {
		 this.isTurn  = !this.isTurn; 
	}
	
	
	
	

}
