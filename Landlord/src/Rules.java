import java.util.Scanner;

public class Rules
	{
		public static void o(){				
				if (Main.b.size()==1){
					if(Main.b.get(0).getRank()>Main.a.get(0).getRank()){
					Main.a.remove(0);
					Main.a.add(Main.b.get(0)); 
					Main.b.remove(0);
					} else {
					//sysoarray();
					System.out.println("Error code: 5b");
					illegal();
					}
				}
				if (Main.b.size()==2){
					if((Main.b.get(0).getRank() == 14 || Main.b.get(0).getRank() == 15) && ((Main.b.get(1).getRank() == 14 || Main.b.get(1).getRank() == 15))){
						System.out.println("Wow! The biggest bomb in game, you can lead the new round.");
				    	removea();
				    	removeb();
				    	Main.play();
				    } else if (Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(0).getRank()>Main.a.get(0).getRank()){
				    	removea();
						replace();
						removeb();
				    	
				    } else {
				    	//sysoarray();
				    	System.out.println("Error code: 6b");
				    	illegal();				    
				    	}
				} 
				if(Main.b.size()==3){
					if(Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) && Main.b.get(0).getRank()>Main.a.get(0).getRank()){
						removea();
						replace();
						removeb();
					} else {
						//sysoarray();
						System.out.println("Error code: 1b");
						illegal();				
					}
				}
				if(Main.b.size()==4){
					if(Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) &&  Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) && Main.b.get(2).getFace().equals(Main.b.get(3).getFace())){
						System.out.println("Wow! " + Main.b.get(0).getFace() + " bomb! You can start the new round.");
						removea();
						removeb();
						Main.play();
					} else {
						//sysoarray();
						System.out.println("Error code: 7b");
						illegal();	
					}
				}
			}
			
		public static int check(){
			if(Main.c.size()==1){
				removec();
				return 1;
			}
			if(Main.c.size()==2){
				if(Main.c.get(0).getFace().equals(Main.c.get(1).getFace())){
					removec();
					return 1;
				} else if((Main.c.get(0).getRank() == 14 || Main.c.get(0).getRank() == 15) && (Main.c.get(1).getRank() == 14 || Main.c.get(1).getRank() == 15)){
					removec();
					return 1;
				} else {
					removec();
					return 0;
				}					
			} else if (Main.c.size()==3 && Main.c.get(0).getFace().equals(Main.c.get(1).getFace()) && Main.c.get(1).getFace().equals(Main.c.get(2).getFace())){
				removec();
				return 1;			
			} else if(Main.c.size()==4 && Main.c.get(0).getFace().equals(Main.c.get(1).getFace()) && Main.c.get(1).getFace().equals(Main.c.get(2).getFace()) &&  Main.c.get(1).getFace().equals(Main.c.get(2).getFace()) && Main.c.get(2).getFace().equals(Main.c.get(3).getFace())){
				removec();
				return 1;
			} else {
				removec();
			    return 0;
			}			
		}
		
		public static void illegal(){
			System.out.println("Illegal!");
			Main.delay();
			System.out.println();
			System.out.println("Here are some suggestions:");
			System.out.println("1. Single");
			System.out.println("2. Double(2 of a kind)");
			System.out.println("3. Trio(3 of a kind)");
			System.out.println("4. Bomb(4 of a kind or 2 jokers)");
			System.out.println("The move you make have to follow the previous pattern and be bigger than it.");
			Main.delay();
			System.out.println();
			removeb();
			Main.play(); 
			System.out.println();
		}
		
		public static void removea(){
			int temp = Main.a.size();
			for(int i = 0; i < temp; i++){
	    		Main.a.remove(0);
	    	}
		}
		
		public static void removeb(){
			int temp = Main.b.size();
			for(int i = 0; i < temp; i++){
	    		Main.b.remove(0);
	    	}
		}
		
		public static void removec(){
			int temp = Main.c.size();
			for(int i = 0; i < temp; i++){
	    		Main.c.remove(0);
	    	}
		}
		
		public static void replace(){
			for(int i = 0; i < Main.b.size(); i++){
				Main.a.add(Main.b.get(i));
			}
		}
		
		public static void checkwin(){
			if(Main.player1.size()==0){
				//Main.win = true;
				
				System.out.println("Congratulations! You have no cards left, you just won the game!");		
				checkContinue();
			}
			if(Main.player2.size()==0){Main.win = true; System.out.println("Player2 bot just won the game... Better luck next time."); checkContinue();}
			if(Main.player3.size()==0){Main.win = true; System.out.println("Player3 bot just won the game... Better luck next time."); checkContinue();}
		}
		
		public static void checkContinue(){
			System.out.println("Do you want to play again? Type \"Yes\" to continue, \"No\"to exit.");
			Scanner userInput = new Scanner(System.in);
			String keepPlaying = userInput.nextLine();
			if (keepPlaying.equalsIgnoreCase("Yes")){
				Main.rerun();
			} else if (keepPlaying.equalsIgnoreCase("No")){
				System.out.println("Thanks for playing, " + Main.name + ". Hope to see you soon, bye!");
				System.exit(0);
			} else {
				System.out.println("Illegal input! Please type \"Yes\" or \"No\", " + Main.name + ".");
				checkContinue();
			}
		}
		
		public static void checkPass(){
			if(Main.pass.size()==2){
				removea();
				removeb();
				removec();
				boolean player1 = false;
				boolean player2 = false;
				boolean player3 = false;
				for(Integer s: Main.pass){
					if(s==1){player1=true;}
					if(s==2){player2=true;}
					if(s==3){player3=true;}
				}
				int temp = Main.pass.size();
				for(int i = 0; i < temp; i++){
		    		Main.pass.remove(0);
		    	} // clear the pass arraylist, so it resets
				if(player1==false){
					Main.delay();
					System.out.println("All players have passed. Nobody has bigger cards. You won this round and can lead the new round!");
					System.out.println();
					Main.delay();
					Main.play();
				} else if(player2==false){
					Main.delay();
					System.out.println("All players have passed. Nobody has bigger cards. Player2 Bot won this round and can lead the new round!");
					System.out.println();
					Main.delay();
					Player2AI.player2AI();
					Player3AI.player3AI();
					Main.play();
				} else {
					Main.delay();
					System.out.println("All players have passed. Nobody has bigger cards. Player3 Bot won this round and can lead the new round!");
					System.out.println();
					Main.delay();
					Player3AI.player3AI();
					Main.play();
				}							
			}		
		}
		
		public static void sysoarray(){
			int counter1=0;
			System.out.print("a: ");
			for (Card c: Main.a){
				if(c.getRank()==14 || c.getRank()==15){
					System.out.println(counter1 + ". " + c.getFace());
				} else {
					System.out.println(counter1 + ". " + c.getFace() + " of " + c.getSuit());
				}											
				counter1++;
			}
			counter1=0;
			System.out.print("b: ");
			for (Card c: Main.b){
				if(c.getRank()==14 || c.getRank()==15){
					System.out.println(counter1 + ". " + c.getFace());
				} else {
					System.out.println(counter1 + ". " + c.getFace() + " of " + c.getSuit());
				}											
				counter1++;
			}
			System.out.println();
		}
		
	}
	
