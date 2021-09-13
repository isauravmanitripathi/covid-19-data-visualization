

public class customnewcolours extends newcolours {
	

	public customnewcolours(colourmaker[] colour, String name){
		super(colour, name);
		this.SetMapSize(colour.length);
		assignment_colourMap = new colourmaker[this.colourmapSize()];
		this.InitMap();
		
		for (int i = 0; i < this.colourmapSize(); i++) {
			assignment_colourMap[i] = colour[i];
		}		
	}
	

	public colourmaker choosecolour(int i) {
        if (i < assignment_mapSize) {
			return assignment_colourMap[i];
		} else {
			i = i - assignment_mapSize;
			return choosecolour(i);
		}
    }
	

	public int colourmapSize() {
		return assignment_mapSize;
	}
	 

    public int choosenumber() {
        int num = 0;
        for (int i=0; i<assignment_colourMap.length; i++) {
            if (!(assignment_colourMap[i].equals(null))) {
                num++; 
            }
        }
        return(num);
    }
	

    public void InitMap() {
        for (int i=0; i<assignment_mapSize; i++) {
            setnewcolour(i, null);
        }
    }
	

    public boolean setnewcolour(int i, colourmaker colour) {
        if (i < assignment_mapSize) {
			assignment_colourMap[i] = colour;
			return(true);
		} else {
			return false;
		}
    }
	

    public boolean SetMapSize(int size) {
		assignment_mapSize = size;
		return true;
	}	
	private int assignment_mapSize;
	private colourmaker[] assignment_colourMap;
	

	public static void main(String[] args) {
		//Setting up some objects to test.
		colourmaker[] four = new colourmaker[4];
		colourmaker[] five = new colourmaker[5];
		colourmaker[] six = new colourmaker[6];
		
		colourmaker white = new colourmaker("#FFFFFF");
		four[0] = white;
		five[0] = white;
		six[0] = white;
		colourmaker black = new colourmaker("#000000");
		four[1] = black;
		five[1] = black;
		six[1] = black;
		colourmaker red = new colourmaker("#FF0000");
		four[2] = red;
		five[2] = red;
		six[2] = red;
		colourmaker green = new colourmaker("#00FF00");
		four[3] = green;
		five[3] = green;
		six[3] = green;
		colourmaker blue = new colourmaker("#0000FF");
		five[4] = blue;
		six[4] = blue;
		colourmaker bluegreen = new colourmaker("#00FFFF");
		six[5] = bluegreen;
		

		customnewcolours fourcolours = new customnewcolours(four, "Four");
		System.out.println("Expected: No output.");
		System.out.println();
		

		customnewcolours fivecolours = new customnewcolours(five, "Five");
		System.out.println("Expected: No output.");
		System.out.println();
		

		customnewcolours sixcolours = new customnewcolours(six, "Six");
		System.out.println("Expected: No output.");
		System.out.println();


		{
			int i=0;
			while (i<fivecolours.colourmapSize()) {
				System.out.print(fivecolours.choosecolour(i).GetHex() + " ");
				i++;
			}
		}
		System.out.println();
		System.out.println("Expected: #FFFFFF #000000 #FF0000 #00FF00 #0000FF");
		System.out.println();

		{
			int i=0;
			while (i<sixcolours.colourmapSize()) {
				System.out.print(sixcolours.choosecolour(i).GetHex() + " ");
				i++;
			}
		}
		System.out.println();
		System.out.println(
			"Expected: #FFFFFF #000000 #FF0000 #00FF00 #0000FF #00FFFF");
		System.out.println();
		

		{
			int i=0;
			while (i<fivecolours.colourmapSize()) {
				fivecolours.setnewcolour(i, new colourmaker("#FFFFFF"));
				i++;
			}
		}
		int i=0;
		while (i<fivecolours.colourmapSize()) {
			System.out.print(fivecolours.choosecolour(i).GetHex() + " ");
			i++;
		}
		System.out.println();
		System.out.println("Expected: #FFFFFF #FFFFFF #FFFFFF #FFFFFF #FFFFFF ");
		System.out.println();
		

		System.out.println(fivecolours.colourmapSize());
		System.out.println("Expected: Five");
		System.out.println();
		
		System.out.println(sixcolours.colourmapSize());
		System.out.println("Expected: Six");
		System.out.println();
		

		System.out.println(fivecolours.choosenumber());
		System.out.println("Expected: Five");
		System.out.println();
		
		System.out.println(sixcolours.choosenumber());
		System.out.println("Expected: Six");
		System.out.println();
	
	
	}
}