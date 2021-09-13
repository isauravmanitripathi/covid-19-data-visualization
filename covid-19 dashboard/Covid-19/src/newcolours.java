

public class newcolours {
		

    public newcolours(colourmaker[] colours, String name) {
        InitMap(); //First initialises array to null.

		if (colours.length > assignment_mapSize) {

			int i=0;
			while (i<assignment_mapSize) {

				setnewcolour(i, colours[i]);
				i++;
			}
		} else {

			int i=0;
			if (i < colours.length) {
				do {
					setnewcolour(i, colours[i]);
					i++;
				} while (i < colours.length);
			}
		}

        SetMapName(name);
    }
	

    public colourmaker choosecolour(int i) {
		if (i < assignment_mapSize) {
			return assignment_colourMap[i];
		} else {
			i = i - assignment_mapSize;
			return choosecolour(i);
		}
	}
	 

    public String colourmapName() {
        return(assignment_mapName);
    }
	 

    public int choosenumber() {
        int num = 0;
		int i=0;
		if (i < assignment_colourMap.length) {
			do {
				if (!assignment_colourMap[i].equals(null)) {
					num++;
				}
				i++;
			} while (i < assignment_colourMap.length);
		}
		return(num);
    }
	 

    public void InitMap() {
        for (int i=0; i<assignment_mapSize; i++) {
            setnewcolour(i, null);
        }
    }
	

	public int colourmapSize() {
		return assignment_mapSize;
	}
	

    public boolean setnewcolour(int i, colourmaker colour) {
        assignment_colourMap[i] = colour;
        return(true);
    }
	

    public boolean SetMapName(String name) {
        assignment_mapName = name;
        return(true);
    }

    public boolean setMapSize() {
		assignment_mapSize = 5;
		return true;
	}


    private int assignment_mapSize = 5;


    private colourmaker[] assignment_colourMap = new colourmaker[assignment_mapSize];

    private String assignment_mapName;
    

	public static void main(String[] args){

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
		
		

		newcolours fourcolours = new newcolours(four, "Four");
		System.out.println("Expected: No output.");
		System.out.println();
		

		newcolours fivecolours = new newcolours(five, "Five");
		System.out.println("Expected: No output.");
		System.out.println();
		

		newcolours sixcolours = new newcolours(six, "Six");
		System.out.println("Expected: No output");
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
		

		System.out.println(fivecolours.colourmapName());
		System.out.println("Expected: Five");
		System.out.println();
		

		fivecolours.SetMapName("ELEPHANT");
		
		System.out.println(fivecolours.colourmapName());
		System.out.println("Expected: ELEPHANT");
		System.out.println();
		

		System.out.println(fivecolours.choosenumber());
		System.out.println("Expected: 5");
		System.out.println();
		System.out.println(sixcolours.choosenumber());
		System.out.println("Expected: 5");
		System.out.println();		
	}
}