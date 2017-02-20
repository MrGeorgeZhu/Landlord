
public class Player3AI {
	public static void player3AI(){		
		if(Main.a.size()==0){
			int index =  Main.player3.size()-1;
//			int small = Main.player3.get(Main.player3.size()-1).getRank();
//			for(int i = Main.player3.size()-1; i >= 0; i--){
//				if(Main.player3.get(i).getRank()<small){
//					index = i;
//				}
//			}
			Main.a.add(Main.player3.get(index));
			System.out.println("Player3 put down:");
			if(Main.player3.get(index).getRank()==14 || Main.player3.get(index).getRank()==15){
				System.out.println(Main.player3.get(index).getFace());
			} else {
				System.out.println(Main.player3.get(index).getFace() + " of " + Main.player3.get(index).getSuit());
			}
			System.out.println();
			Main.player3.remove(index);
			} else if (Main.a.size()==1){
			int target = Main.a.get(0).getRank();
			//int big = Main.player3.get(0).getRank();
			int index = -1;						    
			for(int i = Main.player3.size()-1; i >= 0 ; i--){
				if (Main.player3.get(i).getRank() > target)
				    {
				        //big = Main.player3.get(i).getRank();
				        index = i;
				        break;
				    }
			}
			if(index == -1){
				System.out.println("Player3 passes.");
				System.out.println();
				Main.pass.add(3);
			} else {
				Main.b.add(Main.player3.get(index));
				Rules.o();
				System.out.println("Player3 put down: ");
				if(Main.player3.get(index).getRank()==14 || Main.player3.get(index).getRank()==15){
					System.out.println(Main.player3.get(index).getFace());
				} else {
					System.out.println(Main.player3.get(index).getFace() + " of " + Main.player3.get(index).getSuit());
				}
				System.out.println();
				Main.player3.remove(index);
			}
			
		   } else if (Main.a.size()==2){
			int target = Main.a.get(0).getRank();
			//int big = Main.player3.get(0).getRank();
			int index1 = -1;
			int index2 = -1;
			for(int i = Main.player3.size()-1; i >= 1 ; i--){
				if (Main.player3.get(i).getFace().equals(Main.player3.get(i-1).getFace()) && Main.player3.get(i).getRank() > target)
				    {
				        //big = Main.player3.get(i).getRank();
				        index1 = i;
				        index2 = i-1;
				       break;
				    }
			}
			
			if(index1==-1){
				System.out.println("Player3 passes.");
				System.out.println();
				Main.pass.add(3);
			} else {
				Main.b.add(Main.player3.get(index1));
				Main.b.add(Main.player3.get(index2));
				Rules.o();
				System.out.println("Player3 put down:");
				System.out.println(Main.player3.get(index1).getFace() + " of " + Main.player3.get(index1).getSuit());
				System.out.println(Main.player3.get(index2).getFace() + " of " + Main.player3.get(index2).getSuit());
				System.out.println();
				Main.player3.remove(index1);
				Main.player3.remove(index2);
			}
					
		} else if (Main.a.size()==3){
			int target = Main.a.get(0).getRank();
			int index1 = -1;
			int index2 = -1;
			int index3 = -1;
			for(int i = Main.player3.size()-1; i >= 2 ; i--){
				if (Main.player3.get(i).getFace().equals(Main.player3.get(i-1).getFace()) && Main.player3.get(i-1).getFace().equals(Main.player3.get(i-2).getFace()) && Main.player3.get(i).getRank() > target)
				    {
				        //big = Main.player3.get(i).getRank();
				        index1 = i;
				        index2 = i-1;
				        index3 = i-2;
				        break;
				    }
			}
			
			if(index1==-1){
				System.out.println("Player3 passes.");
				System.out.println();
				Main.pass.add(3);
			} else {
				Main.b.add(Main.player3.get(index1));
				Main.b.add(Main.player3.get(index2));
				Main.b.add(Main.player3.get(index3));
				Rules.o();
				System.out.println("Player3 put down:");
				System.out.println(Main.player3.get(index1).getFace() + " of " + Main.player3.get(index1).getSuit());
				System.out.println(Main.player3.get(index2).getFace() + " of " + Main.player3.get(index2).getSuit());
				System.out.println(Main.player3.get(index3).getFace() + " of " + Main.player3.get(index3).getSuit());
				System.out.println();
				Main.player3.remove(index1);
				Main.player3.remove(index2);
				Main.player3.remove(index3);
			}
						
		} else {
			System.out.println("Player3 passes.");
			System.out.println();
			Main.pass.add(3);
		}
		Rules.checkwin();
		//if(Main.player3.size()==0){System.out.println("Player3 bot just won the game... Better luck next time.");}
		Rules.checkPass();				
}
}
