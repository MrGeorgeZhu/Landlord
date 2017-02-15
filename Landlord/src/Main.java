import java.util.*;

public class Main
	{
		static String name = "";
		static ArrayList <Card> player1 = new ArrayList <Card>();
		static ArrayList <Card> player2 = new ArrayList <Card>();
		static ArrayList <Card> player3 = new ArrayList <Card>();
		static ArrayList <Card> a = new ArrayList <Card>();
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
					System.out.println(counter + ". " + c.getFace() + " of " + c.getSuit());						
					counter++;
				}
				System.out.println("Type in the number(s) of the card you want to put down. Seperate them by \",\".");
				Scanner userInput = new Scanner(System.in);
				String temp = userInput.nextLine();
				String[] b = temp.split(",");
				for(int i = 0; i < b.length; i++){
					if(Integer.parseInt(b[i])>=1 && Integer.parseInt(b[i])<=player1.size()){}
					else{System.out.println("Illegal input!"); play();}
				}
				for(int i = 0; i < b.length; i++){
					a.add(player1.get(Integer.parseInt(b[i])-1));
				}
				for(int i = b.length-1; i>=0; i--){
					player1.remove(Integer.parseInt(b[i])-1);
				}
				delay();
			}
		}
		
		public static void delay(){
			try{Thread.sleep(700);}
			catch(InterruptedException e){e.printStackTrace();}
		}

	}
