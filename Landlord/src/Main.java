import java.util.*;

public class Main
	{
		static String name = "";
		static ArrayList <Card> player1 = new ArrayList <Card>();
		static ArrayList <Card> player2 = new ArrayList <Card>();
		static ArrayList <Card> player3 = new ArrayList <Card>();
		static ArrayList <Card> a = new ArrayList <Card>();
		static ArrayList <Card> b = new ArrayList <Card>();
		public static void main(String[] args)
			{
				SetDeck.generateDeck();
				Collections.shuffle(SetDeck.deck);
				deal();
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
		}
		
		public static void deal(){
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
		
		public static void play(){
			while(player1.size()>0){
				int counter = 1;
				System.out.println("Here are the cards you have rigth now:");
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
				
				if(temp.equalsIgnoreCase("pass")){} else {
					String[] input = temp.split(",");
					
					for(int i = 0; i < input.length; i++){
						if(Integer.parseInt(input[i])>=1 && Integer.parseInt(input[i])<=player1.size()){} //Need to have a solution for letters input
						else{System.out.println("Illegal input!"); play();}
					}//Check for illegal input
					
					if(a.size()==0){
						for(int i = 0; i < input.length; i++){
							a.add(player1.get(Integer.parseInt(input[i])-1));
						} //Pass selected cards to arraylist a
					} else {
						for(int i = 0; i < input.length; i++){
							b.add(player1.get(Integer.parseInt(input[i])-1));
						} //Pass selected cards to arraylist b
						
					}
					
					
					for(int i = input.length-1; i>=0; i--){
						player1.remove(Integer.parseInt(input[i])-1);
					}//remove selected cards from player arraylist
				}				
				delay();
				System.out.println();
			}
		}
		
		public static void delay(){
			try{Thread.sleep(700);}
			catch(InterruptedException e){e.printStackTrace();}
		}

	}
