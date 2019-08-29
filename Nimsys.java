/*
 * The University of Melbourne
 * School of Computing and Information Systems
 * COMP90041 Programming and Software Development
 * Assignment 1
 * Student Name: Dongliang Liang
 * Student ID: 962661
 * 
 * Nim is a two players game, begins with a  number of objects. 
 * Each player takes turns removing stones from the table.
 * On each turn, a player must remove at least one stone. 
 * In addition, there is an upper bound on the number of 
 * stones that can be removed in a single turn. 
 * The game ends when there are no more stones remaining. 
 * The player who removes the last stone, loses.
 * 
 */
import java.util.Scanner;

public class Nimsys {
	public static Scanner input=new Scanner(System.in);
	public static String choice;
	public static int bound;
	public static int stoneNum;
	public static int NumOfMoveStone1;
	public static int NumOfMoveStone2;
	static NimPlayer player1=new NimPlayer();
	static NimPlayer player2=new NimPlayer();
	public static void main(String[] args){
		
		
		System.out.println("Welcome to Nim");
		System.out.println();
		System.out.println("Please enter Player 1's name:");
		player1.name1=input.nextLine();
		System.out.println();
		System.out.println("Please enter Player 2's name:");
		player2.name2=input.nextLine();
		System.out.println();
		while(true){
			System.out.println("Please enter upper bound of stone removal:");
			bound=input.nextInt();
			System.out.println();
			System.out.println("Please enter initial number of stones:");
			stoneNum=input.nextInt();
			System.out.println();
			System.out.printf("%d stones left:",stoneNum);
			for(int i=0;i<stoneNum;i++){
				System.out.print(" *");
			}
			System.out.println();
			while(stoneNum>0){
				System.out.printf("%s's turn - remove how many?\n",player1.name1);
				NumOfMoveStone1=NimPlayer.removeStone(input.nextInt());
				System.out.println();
				stoneNum-=NumOfMoveStone1;
				if(stoneNum<=0){
					System.out.println("Game Over");
					System.out.println(player2.name2+" wins!");
					System.out.println();
					break;
				}
				System.out.printf("%d stones left:",stoneNum);
				for(int i=0;i<stoneNum;i++){
					System.out.print(" *");
				}
				System.out.println();
				System.out.printf("%s's turn - remove how many?\n",player2.name2);
				NumOfMoveStone2=NimPlayer.removeStone(input.nextInt());
				System.out.println();
				stoneNum-=NumOfMoveStone2;
				if(stoneNum<=0){
					System.out.println("Game Over");
					System.out.println(player1.name1+" wins!");
					System.out.println();
					break;
				}
				System.out.printf("%d stones left:",stoneNum);
				for(int i=0;i<stoneNum;i++){
					System.out.print(" *");
				}	
				System.out.println();
			}
			System.out.print("Do you want to play again (Y/N):");
			choice=input.next();
			System.out.println();
			if(choice.equalsIgnoreCase("Y")){
				continue;
			}else{
				System.exit(0);
			}
		}
	}																									
}