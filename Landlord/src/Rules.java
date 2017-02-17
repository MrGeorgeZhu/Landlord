
public class Rules
	{
		public static void o(){				
				if (Main.b.size()==1){if(Main.b.get(0).getRank()>Main.a.get(0).getRank()){Main.a.remove(0); Main.a.add(Main.b.get(0)); Main.b.remove(0);}else{illegal();}}
				if (Main.b.size()==2){
					if(Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(0).getRank()>Main.a.get(0).getRank()){
						removea();
						replace();
						removeb();
				    } else if ((Main.b.get(0).getRank() == 14 || Main.b.get(0).getRank() == 15) && ((Main.b.get(1).getRank() == 14 || Main.b.get(1).getRank() == 15))){
				    	System.out.println("Wow! The biggest bomb in game, you can lead the new round.");
				    	removea();
				    	removeb();
				    } else {
				    	illegal();
				    }
				}
				if(Main.b.size()==3){
					if(Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) && Main.b.get(0).getRank()>Main.a.get(0).getRank()){
						removea();
						replace();
						removeb();
					} else {illegal();}
				}
				if(Main.b.size()==4){
					if(Main.b.get(0).getFace().equals(Main.b.get(1).getFace()) && Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) &&  Main.b.get(1).getFace().equals(Main.b.get(2).getFace()) && Main.b.get(2).getFace().equals(Main.b.get(3).getFace())){
						System.out.println("Wow!" + Main.b.get(0).getFace() + "bomb! You can start the new round.");
						removea();
						removeb();
					}
				}
			}
			
		public static int check(){
			if(Main.a.size()==2){
				if(Main.a.get(0).getFace().equals(Main.a.get(1).getFace())){
					return 1;
				} else if((Main.a.get(0).getRank() == 14 || Main.a.get(0).getRank() == 15) && (Main.a.get(1).getRank() == 14 || Main.a.get(1).getRank() == 15)){
					return 1;
				} else{
					return 0;
				}					
			} else if (Main.a.size()==3 && Main.a.get(0).getFace().equals(Main.a.get(1).getFace()) && Main.a.get(1).getFace().equals(Main.a.get(2).getFace())){
				return 1;			
			} else if(Main.a.size()==4 && Main.a.get(0).getFace().equals(Main.a.get(1).getFace()) && Main.a.get(1).getFace().equals(Main.a.get(2).getFace()) &&  Main.a.get(1).getFace().equals(Main.a.get(2).getFace()) && Main.a.get(2).getFace().equals(Main.a.get(3).getFace())){
				return 1;
			} else {
				removea();
			    return 0;
			}
		}
		
		public static void illegal(){
			System.out.println("Illegal!"); 
			System.out.println("Here are the moves you could make:");
			System.out.println("1. Single");
			System.out.println("2. Double(2 of a kind)");
			System.out.println("3. Trio(3 of a kind)");
			System.out.println("4. Bomb(4 of a kind or 2 jokers)");
			Main.delay(); 
			Main.play();
		}
		
		public static void removea(){
			for(int i = 0; i < Main.a.size(); i++){
	    		Main.a.remove(i);
	    	}
		}
		
		public static void removeb(){
			for(int i = 0; i < Main.b.size(); i++){
	    		Main.b.remove(i);
	    	}
		}
		
		public static void replace(){
			for(int i = 0; i < Main.b.size(); i++){
				Main.a.add(Main.b.get(i));
			}
		}
	}
	
