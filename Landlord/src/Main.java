import java.util.*;

public class Main
	{

		public static void main(String[] args)
			{
				SetDeck.generateDeck();
				Collections.shuffle(SetDeck.deck);
//				for(int i = 0; i < 52; i++)
//				{
//					System.out.println(i + " = " + SetDeck.deck.get(i).getFace() + " of " + SetDeck.deck.get(i).getSuit() + " rank = " + SetDeck.deck.get(i).getRank());
//				}
//			for (Card c : SetDeck.deck)
//			{
//				System.out.println(c.getRank());
//			}
			}

	}
