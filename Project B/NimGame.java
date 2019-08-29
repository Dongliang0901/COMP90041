/*
 * The University of Melbourne
 * School of Computing and Information Systems
 * COMP90041 Programming and Software Development
 * Assignment 2
 * Student Name: Dongliang Liang
 * Student ID: 962661
 * 
 * NimGame contains play game method used in the Nim game
 * 
 */

public class NimGame{
			
	private int theReststoneNum;

	private int upperBound;

	private NimPlayer player1;

	private NimPlayer player2;
	
	private NimPlayer chesser;
	
	public NimGame(){
		
	}
	
	public NimGame(int theReststoneNum, int upperBound, NimPlayer player1, NimPlayer player2){
		this.player1=player1;
		this.player2=player2;
		this.theReststoneNum=theReststoneNum;
		this.upperBound=upperBound;
	}

	//the playing process
	public NimPlayer PlayGame(NimGame game){
		System.out.println();
		System.out.println("Initial stone count: " + game.theReststoneNum);	
		System.out.println("Maximum stone removal: " + game.upperBound);	
		System.out.println("Player 1: "+game.player1.getGivenname()+" "+game.player1.getFamilyname());				    
		System.out.println("Player 2: "+game.player2.getGivenname()+" "+game.player2.getFamilyname());	
		System.out.println();
		chesser=game.player1;
		while(game.theReststoneNum > 0){
			chesser.printStar(game.theReststoneNum);
			System.out.println(chesser.getGivenname()+"'s turn - remove how many?");
			Integer numMove=Integer.parseInt(Nimsys.input.nextLine());
			if(numMove==0){
				if(game.theReststoneNum>game.upperBound){
					System.out.println();
					System.out.println("Invalid move. You must remove between "+1+" and "+game.upperBound+" stones.");
					System.out.println();
				}else{
					System.out.println();
					System.out.println("Invalid move. You must remove between "+1+" and "+game.theReststoneNum+" stones.");
					System.out.println();
				}
			}
			else if(numMove>game.upperBound||numMove>game.theReststoneNum){
				if(numMove>game.upperBound){
					System.out.println();
					System.out.println("Invalid move. You must remove between "+1+" and "+game.upperBound+" stones.");
					System.out.println();
				}else{
					System.out.println();
					System.out.println("Invalid move. You must remove between "+1+" and "+game.theReststoneNum+" stones.");
					System.out.println();
				}
			}else{
				game.theReststoneNum=game.theReststoneNum-numMove;
				System.out.println();
				chesser = changePlayer(chesser,game.player1, game.player2);
				if (game.theReststoneNum<=0){
					System.out.println("Game Over");
					System.out.println(chesser.getGivenname() + " " + chesser.getFamilyname() + " wins!");
					System.out.println();
				}
			}
		}
			return chesser;	
	}
	
	//switch the player play the game
	private NimPlayer changePlayer(NimPlayer chesser,NimPlayer player1,NimPlayer player2) {
		if(player1.getGivenname().equals(chesser.getGivenname())){
			return player2;
		}else{
			return player1;
		}
	}
}
