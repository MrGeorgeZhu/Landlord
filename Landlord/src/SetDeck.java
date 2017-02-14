import java.util.ArrayList;

public class SetDeck
	{
static ArrayList <Card> deck = new ArrayList <Card>(); // create the array
		
		public static void generateDeck(){	
		for (int i = 0; i < 52 ; i++)
			{
				String suit = "";
				String face = "";
				int rank = 0;

				switch((int)Math.floor(i/13)%4)
				{
				case 0:
						{
					suit = "clubs";				
					break;
						}
				case 1:
						{
					suit = "diamonds";
					break;
						}
				case 2:
						{
					suit = "hearts";
					break;
						}
				case 3:
						{
					suit = "spades";
					break;
						}
				default:
						{
					break;
						}
				} //set the suit
				
				switch(i%13)
				{
				case 0:
					face = "ace";
					rank = 13;
					break;
				case 1:
					face = "2";
					rank = 1;
					break;
				case 2:
					face = "3";
					rank = 2;
					break;
				case 3:
					face = "4";
					rank = 3;
					break;
				case 4:
					face = "5";
					rank = 4;
					break;
				case 5:
					face = "6";
					rank = 5;
					break;
				case 6:
					face = "7";
					rank = 6;
					break;
				case 7:
					face = "8";
					rank = 7;
					break;
				case 8:
					face = "9";
					rank = 8;
					break;
				case 9:
					face = "10";
					rank = 9;
					break;
				case 10:
					face = "jack";
					rank = 10;
					break;
				case 11:
					face = "queen";
					rank = 11;
					break;
				case 12:
					face = "king";
					rank = 12;
					break;
				default:
					face = Integer.toString(i%13+1);
					rank = i%13;
					break;
				} // set the face and rank			
				deck.add(new Card(rank, suit, face)); // add each card	
			}
		        deck.add(new Card(14, "", "black-and-white joker"));
		        deck.add(new Card(15, "", "colored joker"));
	}	
	}
