import java.util.*;
import java.util.List;

class Tic_Tac_Toe_Game{

		// to store the position od player and computer
		static ArrayList<Integer> userposition = new ArrayList<Integer>();
		static ArrayList<Integer> cpuposition = new ArrayList<Integer>();
	
	public static void main(String args[]){
		
		
		//creating the game board
		char[][] gameBoard = {
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			};
			
		printboard(gameBoard);
		
		while(true){
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("PLAYER 1");
			System.out.println("Enter the position between 1-9");
			int userPo = sc.nextInt();
			
			if(userPo < 1 || userPo > 9){
				System.out.println("The position is out of range");
				System.out.println("please enter the position between 1-9");
				userPo = sc.nextInt();
			}
			while(userposition.contains(userPo) || cpuposition.contains(userPo)){
				System.out.println("Again wrong position, Already occupied");
				System.out.println("Enter the valid position");
				userPo = sc.nextInt();
			}
			
			mark(gameBoard,userPo,"user");
			
			String result = WhoIsWineer();
			if(result.length() > 1 ){
				System.out.println(result);
				break;
			}
			//Played by cpu
			// Random rand = new Random
			// int cpupo = rand.nextInt(9)+1;// till 9 ,+1 indecate starting value
			// while(cpuposition.contains(cpupo) || userposition.contains(cpupo)){
				// cpupo = rand.nextInt(9)+1;
			// }
			
			//played by 2 player
			System.out.println("PLAYER 2");
			System.out.println("Enter the position between 1-9");
			int player2 = sc.nextInt();
			
			if(player2 < 1 || player2 > 9){
				System.out.println("The position is out of range");
				System.out.println("please enter the position between 1-9");
				player2 = sc.nextInt();
			}
			
			
			while(cpuposition.contains(player2) || userposition.contains(player2)){
				player2 = sc.nextInt();
			}
			
			mark(gameBoard,player2,"cpu");
			
			result = WhoIsWineer();
			
			if(result.length() > 1 ){
				System.out.println(result);
				break;
			}
			
			
		}
	}
	public static void printboard(char [][] gb){
		// for(int i=0;i<5;i++){
			// for(int j=0;j<5;j++){
				// System.out.print(gb[i][j]);
			// }
			// System.out.print();
		// }
		// System.out.println();
		
		for(char[] row: gb){
			for(char c:row){
				System.out.print(c);
			}
			System.out.println();
		} 
		System.out.println();
		
	}
	
	public static void mark(char[][] gameBoard,int pos,String listToMark){
		
		char symbol = ' ';
		
		if(listToMark.equals("user")){
			userposition.add(pos);
			symbol = 'X';
		}else if(listToMark.equals("cpu")){
			cpuposition.add(pos);
			symbol = 'O';
		}
		
		switch(pos){
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
				
		}
		printboard(gameBoard);
	}
	
	
	public static String WhoIsWineer(){
		
		List toprow = Arrays.asList(1,2,3);
		List midrow = Arrays.asList(4,5,6);
		List botrow = Arrays.asList(7,8,9);
		List leftcol = Arrays.asList(1,4,7);
		List midcol = Arrays.asList(2,5,8);
		List rightcol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> wineer = new ArrayList<List>();
		
		wineer.add(toprow);
		wineer.add(midrow);
		wineer.add(botrow);
		wineer.add(leftcol);
		wineer.add(midcol);
		wineer.add(rightcol);
		wineer.add(cross1);
		wineer.add(cross2);
		
		
		for(List l:wineer){
			if(userposition.containsAll(l)){
				return "PLAYER 1 WON THE GAME";
			}else if(cpuposition.containsAll(l)){
				return "PLAYER 2 WON THE GAME";
			}else	if(userposition.size() + cpuposition.size() == 9){
				return "It's a Draw";	
			}
		}
		return "";
	}
}