import java.util.*;
public class AI {
	public static void player2AI(){		
		while(!Main.win){
			
			if(Main.a.size()==0){
//				int small = Main.player2.get(0).getRank();
//				int index = 0;						    
//				for(int i = 0; i < Main.player2.size(); i++){
//					if (Main.player2.get(i).getRank() < small)
//					    {
//					        small = Main.player2.get(i).getRank();
//					        index = i;
//					    }
//				}
				Main.a.add(Main.player2.get(Main.player2.size()-1));
				System.out.println("Player2 put down" + SetDeck.deck.get(Main.player2.size()-1).getFace() + " of " + SetDeck.deck.get(Main.player2.size()-1).getSuit());
				System.out.println();
				Main.player2.remove(Main.player2.size()-1);
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
				Main.a.add(Main.player2.get(index));
				System.out.println("Player2 put down" + SetDeck.deck.get(index).getFace() + " of " + SetDeck.deck.get(index).getSuit());
				System.out.println();
				Main.player2.remove(index);
			   } else if (Main.a.size()==2){
				int target = Main.a.get(0).getRank();
				//int big = Main.player2.get(0).getRank();
				int index1 = 0;
				int index2 = 0;
				for(int i = Main.player2.size()-1; i >= 0 ; i--){
					if (Main.player2.get(i).getFace().equals(Main.player2.get(i-1).getFace()) && Main.player2.get(i).getRank() > target)
					    {
					        //big = Main.player2.get(i).getRank();
					        index1 = i;
					        index2 = i-1;
					        break;
					    }
				}
				Main.a.add(Main.player2.get(index1));
				Main.a.add(Main.player2.get(index2));
				System.out.println("Player2 put down" + SetDeck.deck.get(index1).getFace() + " of " + SetDeck.deck.get(index1).getSuit() + " & " +  SetDeck.deck.get(index1).getFace() + " of " + SetDeck.deck.get(index1).getSuit());
				System.out.println();
				Main.player2.remove(index1);
				Main.player2.remove(index2);
			} else if (Main.a.size()==3){
				
			} else{
				System.out.println("Player2 pass.");
				Main.pass++;
			}
			Rules.checkwin();
			//if(Main.player2.size()==0){System.out.println("Player 2 bot just won the game... Better luck next time.");}
			Rules.checkPass();
		}
				
	}
}
