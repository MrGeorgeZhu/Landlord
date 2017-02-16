
public class Rules
	{
		public static void o(){				
				if (Main.a.size()==1){if(Main.b.get(0).getRank()>Main.a.get(0).getRank()){Main.a.remove(0); Main.a.add(Main.b.get(0)); Main.b.remove(0);}else{System.out.println("Illegal!"); Main.play();}}
				if (Main.a.size()==2){
					if(Main.a.get(0).getFace().equals(Main.a.get(0).getFace())){
						
				    } else if ((Main.a.get(0).getRank() == 14 || Main.a.get(0).getRank() == 15) && (Main.a.get(1).getRank() == 14 || Main.a.get(1).getRank() == 15)){
				    	System.out.println("Wow! The biggest bomb in game, you can lead the new round.");
				    	for(int i = 0; i < Main.a.size(); i++){
				    		Main.a.remove(i);
				    	}
				    	for(int i = 0; i < Main.b.size(); i++){
				    		Main.b.remove(i);
				    	}
				    } else {
				    	System.out.println("Illegal!"); 
				    	Main.play();
				    }
				}
			}
			
	}
	
