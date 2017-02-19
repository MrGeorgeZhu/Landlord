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
				if(Main.player2.get(index).getRank()==14 || Main.player2.get(index).getRank()==15){
					System.out.println(Main.player2.get(index).getFace());
				} else {
					System.out.println(Main.player2.get(index).getFace() + " of " + Main.player2.get(index).getSuit());
				}
				System.out.println();
				Main.player2.remove(index);
				} else if (Main.a.size()==1){
				int target = Main.a.get(0).getRank();
				//int big = Main.player2.get(0).getRank();
				int index = -1;						    
				for(int i = Main.player2.size()-1; i >= 0 ; i--){
					if (Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index = i;
					        break;
					    }
				}
				if(index == -1){
					System.out.println("Player2 passes.");
					System.out.println();
					Main.pass++;
				} else {
					Main.b.add(Main.player2.get(index));
					Rules.o();
					System.out.println("Player2 put down: ");
					if(Main.player2.get(index).getRank()==14 || Main.player2.get(index).getRank()==15){
						System.out.println(Main.player2.get(index).getFace());
					} else {
						System.out.println(Main.player2.get(index).getFace() + " of " + Main.player2.get(index).getSuit());
					}
					System.out.println();
					Main.player2.remove(index);
				}
				
			   } else if (Main.a.size()==2){
				int target = Main.a.get(0).getRank();
				//int big = Main.player2.get(0).getRank();
				int index1 = -1;
				int index2 = -1;
				for(int i = Main.player2.size()-1; i >= 1 ; i--){
					if (Main.player2.get(i).getFace().equals(Main.player2.get(i-1).getFace()) && Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index1 = i;
					        index2 = i-1;
					       break;
					    }
				}
				
				if(index1==-1){
					System.out.println("Player2 passes.");
					System.out.println();
					Main.pass++;
				} else {
					Main.b.add(Main.player2.get(index1));
					Main.b.add(Main.player2.get(index2));
					Rules.o();
					System.out.println("Player2 put down:");
					System.out.println(Main.player2.get(index1).getFace() + " of " + Main.player2.get(index1).getSuit());
					System.out.println(Main.player2.get(index2).getFace() + " of " + Main.player2.get(index2).getSuit());
					System.out.println();
					Main.player2.remove(index1);
					Main.player2.remove(index2);
				}
						
			} else if (Main.a.size()==3){
				int target = Main.a.get(0).getRank();
				int index1 = -1;
				int index2 = -1;
				int index3 = -1;
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
				
				if(index1==-1){
					System.out.println("Player2 passes.");
					System.out.println();
					Main.pass++;
				} else {
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
				}
							
			} else{
				System.out.println("Player2 passes.");
				System.out.println();
				Main.pass++;
			}
			Rules.checkwin();
			//if(Main.player2.size()==0){System.out.println("Player 2 bot just won the game... Better luck next time.");}
			Rules.checkPass();				
	}
}
