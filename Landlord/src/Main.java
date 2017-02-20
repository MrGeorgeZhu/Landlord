import java.util.*;

public class Main
	{
		static String name = "";
		static ArrayList <Card> player1 = new ArrayList <Card>();
		static ArrayList <Card> player2 = new ArrayList <Card>();
		static ArrayList <Card> player3 = new ArrayList <Card>();
		static ArrayList <Card> a = new ArrayList <Card>();
		static ArrayList <Card> b = new ArrayList <Card>();
		static ArrayList <Card> c = new ArrayList <Card>();
		static boolean win = false;
		static ArrayList <Integer> pass = new ArrayList <Integer>();
		public static void main(String[] args)
			{		
			    greeting(); 
				play();
				
//				for(int i = 0; i < 52; i++)
//				{
//					System.out.println(i + " = " + SetDeck.deck.get(i).getFace() + " of " + SetDeck.deck.get(i).getSuit() + " rank = " + SetDeck.deck.get(i).getRank());
//				}
//			for (Card c : player1)
//		      {
//				System.out.println(c.getFace());
//			}
			}
		
		public static void rerun(){
			Rules.removea();
			Rules.removeb();
			int temp = player1.size();
			for(int i = 0; i < temp; i++){
	    		player1.remove(0);
	    	}
			temp = player2.size();
			for(int i = 0; i < temp; i++){
	    		player2.remove(0);
	    	}
			temp = player3.size();
			for(int i = 0; i < temp; i++){
	    		player3.remove(0);
	    	}
			temp = SetDeck.deck.size();
			for(int i = 0; i < temp; i++){
	    		SetDeck.deck.remove(0);
	    	}
			SetDeck.generateDeck();
			Collections.shuffle(SetDeck.deck);
			deal();
			System.out.println("You have started a new game!");
			delay();
			play();
		}
		
		public static void greeting(){
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			String phrase;
			if (hour < 12){
				phrase = "Good morning";
			} else if (hour < 17){
				phrase = "Good afternoon";
			} else {
				phrase = "Good evening";
			}
			Scanner userInput = new Scanner(System.in);
		    System.out.println(phrase + ", what is your name?");
		    name = userInput.nextLine();
		    System.out.println("Hello, " + name + "!");
		    delay();
		    System.out.println();
		    if(name.equalsIgnoreCase("George")){
		    	specialDeal();
		    } else {
		    	deal();
		    }
		}
		
		public static void deal(){
			SetDeck.generateDeck();
			Collections.shuffle(SetDeck.deck);
			for(int i = 0; i < SetDeck.deck.size(); i++){
				switch(i%3){
					case 0:{
						player1.add(SetDeck.deck.get(i));
						break;
					}
					case 1:{
						player2.add(SetDeck.deck.get(i));
						break;
					}
					case 2:{
						player3.add(SetDeck.deck.get(i));
						break;
					}
				}
			}
			Collections.sort(player1, new Sort());
			Collections.sort(player2, new Sort());
			Collections.sort(player3, new Sort());
		}
		
		public static void specialDeal(){
			SetDeck.generateDeck();
			player1.add(SetDeck.deck.get(0));
			player1.add(SetDeck.deck.get(13));
			player1.add(SetDeck.deck.get(26));
			player1.add(SetDeck.deck.get(39));
			player1.add(SetDeck.deck.get(52));
			player1.add(SetDeck.deck.get(53));
			SetDeck.deck.remove(53);
			SetDeck.deck.remove(52);
			SetDeck.deck.remove(39);
			SetDeck.deck.remove(26);
			SetDeck.deck.remove(13);
			SetDeck.deck.remove(0);
			Collections.shuffle(SetDeck.deck);
			int counter = 0;
			for(int i = 0; i < SetDeck.deck.size(); i++){
				switch(i%3){
					case 0:{
						if(counter>=4){
							player1.add(SetDeck.deck.get(i));
						} else if(i%2==0) {
							player2.add(SetDeck.deck.get(i));
							counter++;
						} else {
							player3.add(SetDeck.deck.get(i));
							counter++;
						}					
						break;
					}
					case 1:{
						player2.add(SetDeck.deck.get(i));
						break;
					}
					case 2:{
						player3.add(SetDeck.deck.get(i));
						break;
					}
				}
			}
			Collections.sort(player1, new Sort());
			Collections.sort(player2, new Sort());
			Collections.sort(player3, new Sort());
//			player2Cards();
//			System.out.println();
//			player3Cards();
//			System.out.println();
		}
		
		public static void play(){
			while(!win){
				int counter = 1;
				System.out.println("It's your turn! Here are the cards you have right now:");
				for (Card c: player1){
					if(c.getRank()==14 || c.getRank()==15){
						System.out.println(counter + ". " + c.getFace());
					} else {
						System.out.println(counter + ". " + c.getFace() + " of " + c.getSuit());
					}											
					counter++;
				}
				System.out.println("Type in the number(s) of the card you want to put down. Seperate them by \",\". Type \"pass\" to skip this round.");
				Scanner userInput = new Scanner(System.in);
				String temp = userInput.nextLine();
				
				if(temp.equalsIgnoreCase("pass")){
					System.out.println("You skipped this round.");
					System.out.println();
					pass.add(1);
					} else if(temp.equalsIgnoreCase("Get me out")){
						System.out.println("You just quit, " + name + "!");
						delay();
						System.out.println();
						System.out.println("Thanks for playing though, hope to see you soon, bye!");
						System.exit(0);
					} else {
					String[] input = temp.split(",");
					
					for(int i = 0; i < input.length; i++){
						if(Integer.parseInt(input[i])>=1 && Integer.parseInt(input[i])<=player1.size()){} //Need to have a solution for letters input
						else{
							System.out.println("Error code: 2b");
							Rules.illegal();
								
						}
					}//Check for illegal input
					
					for(int i = 0; i < input.length; i++){
						c.add(player1.get(Integer.parseInt(input[i])-1));
					}//pass cards to arraylist c
					
					if(a.size()==0){
						if(Rules.check()==1){
							for(int i = 0; i < input.length; i++){
								a.add(player1.get(Integer.parseInt(input[i])-1));
							} //Pass selected cards to arraylist a
						} else {
							System.out.println("Error code: 3b");
							Rules.illegal();
							
						}
						
					} else {
						//if(input.length==a.size() || input.length==4 || input.length==2){
							for(int i = 0; i < input.length; i++){
								b.add(player1.get(Integer.parseInt(input[i])-1));
							} //Pass selected cards to arraylist b
							Rules.o();
						//} else {
						//	System.out.println("Error code: 4b");
						//	Rules.illegal();
						//}												
					}
					
					System.out.println();
					System.out.println("You put down:");
					for(int i = 0; i < input.length; i++){
						if(player1.get(Integer.parseInt(input[i])-1).getRank()==14 || player1.get(Integer.parseInt(input[i])-1).getRank()==15){
							System.out.println(player1.get(Integer.parseInt(input[i])-1).getFace());
						} else {
							System.out.println(player1.get(Integer.parseInt(input[i])-1).getFace() + " of " + player1.get(Integer.parseInt(input[i])-1).getSuit());
						}
					} //print cards put down
					
					for(int i = input.length-1; i>=0; i--){
						player1.remove(Integer.parseInt(input[i])-1);
					}//remove selected cards from player arraylist
				}				
				delay();			
				Rules.checkwin();
				Rules.checkPass();
				System.out.println();
				//Rules.sysoarray();
				Player2AI.player2AI();
				//Rules.sysoarray();
				delay();
				Player3AI.player3AI();
				//Rules.sysoarray();
				int size = pass.size();
				for(int i = 0; i < size; i++){
		    		pass.remove(0);
		    	} // clear the pass arraylist, so it resets
			}
		}
		
		public static void delay(){
			try{Thread.sleep(700);}
			catch(InterruptedException e){e.printStackTrace();}
		}
		
		public static void player2Cards(){
			int counter = 1;
			for (Card c: player2){
				if(c.getRank()==14 || c.getRank()==15){
					System.out.println(counter + ". " + c.getFace());
				} else {
					System.out.println(counter + ". " + c.getFace() + " of " + c.getSuit());
				}											
				counter++;
			}
		}
		
		public static void player3Cards(){
			int counter = 1;
			for (Card c: player3){
				if(c.getRank()==14 || c.getRank()==15){
					System.out.println(counter + ". " + c.getFace());
				} else {
					System.out.println(counter + ". " + c.getFace() + " of " + c.getSuit());
				}											
				counter++;
		}
		}
	}
