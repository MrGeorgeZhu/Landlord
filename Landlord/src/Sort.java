import java.util.*;
public class Sort implements Comparator<Card>
	{
		public int compare (Card c1, Card c2){
			if(c1.getRank() < c2.getRank()) {
				return 1;	
			} else if (c1.getRank() == c2.getRank()){
				return 0;
			} else {
				return -1;
			}
		}
	}
