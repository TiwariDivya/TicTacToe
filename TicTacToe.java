import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> playermove=new ArrayList<Integer>();
	static ArrayList<Integer> systemmove=new ArrayList<Integer>();
	public static void main(String[] args) {
			
		char [][] gameboard={{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		printgameboard(gameboard);
		while(true) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter position no. you want make move");
		int pos=scan.nextInt();
		while(playermove.contains(pos)||systemmove.contains(playermove)) {
			System.out.println("position is already taken....enter another");
			pos=scan.nextInt();
		}
		
		chooseyourmove(gameboard,pos,"player");
		String result=checkwinner();
		if(result.length()>0) {
		System.out.println(result);
		break;
		}
		Random rand=new Random();
		int cpuPos=rand.nextInt(9)+1;
		while(playermove.contains(cpuPos)||systemmove.contains(systemmove)) {
			 cpuPos=rand.nextInt(9)+1;
		}
		
		chooseyourmove(gameboard,cpuPos,"system");
		
		printgameboard(gameboard);
		
		result=checkwinner();
		if(result.length()>0) {
		System.out.println(result);
		break;
		}
		}
}
	
	public static void printgameboard(char [][] gameboard) {
		for(char row[]:gameboard) {			
			for(char c:row) {
				System.out.print(c);
			}
			System.out.println();
			}
	}
	
	public static void chooseyourmove(char [][] gameboard,int pos,String user) {
		char symbol='X';
		if(user.equals("player")) {
			symbol='X';
			playermove.add(pos);}
		else if(user.equals("system")){
			symbol='O';
			systemmove.add(pos);}
		
		switch(pos) {
		case 1:
		gameboard [0][0]=symbol;
		break;
		case 2:
			gameboard [0][2]=symbol;
			break;
		case 3:
			gameboard [0][4]=symbol;
			break;
		case 4:
			gameboard [2][0]=symbol;
			break;
		case 5:
			gameboard [2][2]=symbol;
			break;
		case 6:
			gameboard [2][4]=symbol;
			break;
		case 7:
			gameboard [4][0]=symbol;
			break;
		case 8:
			gameboard [4][2]=symbol;
			break;
		case 9:
			gameboard [4][4]=symbol;
			break;
			default:
				break;
			
		}
	}
	
	public static String checkwinner() {
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
		List topCol=Arrays.asList(1,4,7);
		List midCol=Arrays.asList(2,5,6);
		List botCol=Arrays.asList(3,6,9);
		List Cross1=Arrays.asList(1,5,9);
		List Cross2=Arrays.asList(3,5,7);
		
		ArrayList<List> winner=new ArrayList<List>();
		winner.add(topRow);
		winner.add(midRow);
		winner.add(botRow);
		winner.add(topCol);
		winner.add(midCol);
		winner.add(botCol);
		winner.add(Cross1);
		winner.add(Cross2);
		
		for(List l:winner) {
			if(playermove.containsAll(l)) {
				return "Congratulations! You win...";
			}
			else if(systemmove.containsAll(l)) {
				return "Syetem win...";
			}else if(playermove.size()+systemmove.size()==9) {
				return "nobody win..its a tie";
			}
		}
		
		return "";
	}
	
	}
