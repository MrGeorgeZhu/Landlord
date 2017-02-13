
public class Card
	{
		private int rank;
		private String suit;
		private String face;
		
		public Card(int a, String b, String c){
			rank = a;
			suit = b;
			face = c;

		}

		public int getRank()
			{
				return rank;
			}

		public void setRank(int rank)
			{
				this.rank = rank;
			}

		public String getSuit()
			{
				return suit;
			}

		public void setSuit(String suit)
			{
				this.suit = suit;
			}

		public String getFace()
			{
				return face;
			}

		public void setFace(String face)
			{
				this.face = face;
			}
	}
