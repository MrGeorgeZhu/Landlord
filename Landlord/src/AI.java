import java.util.*;
public class AI {
	public static void player2AI(){		
			if(Main.a.size()==0){
				int index = 0;
				int small = Main.player2.get(Main.player2.size()-1).getRank();
				for(int i = Main.player2.size()-1; i >= 0; i--){
					if(Main.player2.get(i).getRank()<small){
						index = i;
					}
				}
				Main.a.add(Main.player2.get(index));
				System.out.println("Player2 put down:");
				System.out.println(Main.player2.get(index).getFace() + " of " + Main.player2.get(index).getSuit());
				System.out.println();
				Main.player2.remove(index);
				} else if (Main.a.size()==1){
				int target = Main.a.get(0).getRank();
				//int big = Main.player2.get(0).getRank();
				int index = 0;						    
				for(int i = Main.player2.size()-1; i >= 0 ; i--){
					if (Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index = i;
					        break;
					    }
				}
				Main.b.add(Main.player2.get(index));
				Rules.o();
				System.out.println("Player2 put down: ");
				System.out.println(Main.player2.get(index).getFace() + " of " + Main.player2.get(index).getSuit());
				System.out.println();
				Main.player2.remove(index);
			   } else if (Main.a.size()==2){
				int target = Main.a.get(0).getRank();
				//int big = Main.player2.get(0).getRank();
				int index1 = 0;
				int index2 = 0;
				for(int i = Main.player2.size()-1; i >= 1 ; i--){
					if (Main.player2.get(i).getFace().equals(Main.player2.get(i-1).getFace()) && Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index1 = i;
					        index2 = i-1;
					       break;
					    }
				}
				
//				System.out.println(index1);
//				System.out.println(index2);
//				int counter = 0;
//				for (Card c: Main.player2){
//					if(c.getRank()==14 || c.getRank()==15){
//						System.out.println(counter + ". " + c.getFace());
//					} else {
//						System.out.println(counter + ". " + c.getFace() + " of " + c.getSuit());
//					}											
//					counter++;
//				}
				
				Main.b.add(Main.player2.get(index1));
				Main.b.add(Main.player2.get(index2));
				Rules.o();
				System.out.println("Player2 put down:");
				System.out.println(Main.player2.get(index1).getFace() + " of " + Main.player2.get(index1).getSuit());
				System.out.println(Main.player2.get(index2).getFace() + " of " + Main.player2.get(index2).getSuit());
				System.out.println();
				Main.player2.remove(index1);
				Main.player2.remove(index2);
			} else if (Main.a.size()==3){
				int target = Main.a.get(0).getRank();
				int index1 = 0;
				int index2 = 0;
				int index3 = 0;
				for(int i = Main.player2.size()-1; i >= 2 ; i--){
					if (Main.player2.get(i).getFace().equals(Main.player2.get(i-1).getFace()) && Main.player2.get(i-1).getFace().equals(Main.player2.get(i-2).getFace()) && Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index1 = i;
					        index2 = i-1;
					        index3 = i-2;
					        break;
					    }
				}
				Main.b.add(Main.player2.get(index1));
				Main.b.add(Main.player2.get(index2));
				Main.b.add(Main.player2.get(index3));
				Rules.o();
				System.out.println("Player2 put down:");
				System.out.println(Main.player2.get(index1).getFace() + " of " + Main.player2.get(index1).getSuit());
				System.out.println(Main.player2.get(index2).getFace() + " of " + Main.player2.get(index2).getSuit());
				System.out.println(Main.player2.get(index3).getFace() + " of " + Main.player2.get(index3).getSuit());
				System.out.println();
				Main.player2.remove(index1);
				Main.player2.remove(index2);
				Main.player2.remove(index3);
			} else{
				System.out.println("Player2 passes.");
				Main.pass++;
			}
			Rules.checkwin();
			//if(Main.player2.size()==0){System.out.println("Player 2 bot just won the game... Better luck next time.");}
			Rules.checkPass();
				
	}
}
