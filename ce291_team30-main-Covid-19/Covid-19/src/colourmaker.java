import java.awt.Color;

public class colourmaker {


    public colourmaker(String hexCode) {
        SetHex(hexCode);
        setnewcolour(GenColor(hexCode));
    }
    

    public colourmaker(Color colour) {
        SetHex(GenHexString(colour));
        setnewcolour(colour);
    }
	

    public Color GenColor(String hex) {
        return(Color.decode(hex));
    }


    public String GenHexString(Color colour) {
        

        String hex = "#" + Integer.toHexString((colour.getRGB() & 0x00FFFFFF));

        return(hex);
    }


    public Color choosecolour() {
        return(assignment_colour);
    }
	

    public String GetHex() {
        return(assignment_hexCode);
    }
	

    public boolean SetHex(String hexCode) {
        if (ValidHex(hexCode)) {
            assignment_hexCode = hexCode;
            return(true);
        } else {
            return(false);
        }
    }
	

    public boolean setnewcolour(Color colour) {
        assignment_colour = colour;
        return(true);
    }
	

    public boolean ValidHex(String hexCode) {
        try {
            Color test = Color.decode(hexCode);
        } catch (NumberFormatException e) {
            return(false);
        }
        return(true);
    }
        
    /**The hex code string representing the colour. */
    private String assignment_hexCode;
	
    /** The Color object, which will be used in the recolouring of charts. */
    private Color assignment_colour;


	public static void main(String[] args) {
		//Set up objects to test with.
		colourmaker hexColour = new colourmaker("#FFFFFF");
		colourmaker colorColour = new colourmaker(Color.white);
		
		//Test that constructor works the same whether using hex code or color object.
		System.out.println(hexColour.GetHex());
		System.out.println("Expected: #FFFFFF");
		System.out.println(colorColour.GetHex());
		System.out.println("Expected: #FFFFFF");
		System.out.println();
		System.out.println(hexColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=255,g=255,b=255]");
		System.out.println(colorColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=255,g=255,b=255]");
		System.out.println();
		
		//Test the setHex method.
		hexColour.SetHex("#000000");
		colorColour.SetHex("#000000");
		
		System.out.println(hexColour.GetHex());
		System.out.println("Expected: #000000");
		System.out.println(colorColour.GetHex());
		System.out.println("Expected: #000000");
		System.out.println();
		
		//Test that colour corresponds to new hex.
		System.out.println(hexColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=0,g=0,b=0]");
		System.out.println(colorColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=0,g=0,b=0]");
		System.out.println();
		
		//Test setnewcolour method.
		hexColour.setnewcolour(Color.blue);
		colorColour.setnewcolour(Color.blue);
		
		System.out.println(hexColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=0,g=0,b=255]");
		System.out.println(colorColour.choosecolour().toString());
		System.out.println("Expected: java.awt.Color[r=0,g=0,b=255]");
		System.out.println();
		
		//Test that hex code corresponds to new colour.
		System.out.println(hexColour.GetHex());
		System.out.println("Expected: #0000FF"); 
		System.out.println(colorColour.GetHex());
		System.out.println("Expected: #0000FF");
		System.out.println();
		
		//Test genColor method.
		System.out.println(hexColour.GenColor("#FF0000"));
		System.out.println("Expected: java.awt.Color[r=255,g=0,b=0]");
		System.out.println();
		
		//Test genHexString method.
		System.out.println(hexColour.GenHexString(Color.red));
		System.out.println("Expected: #FF0000");
		System.out.println();
		
		//Test validHex method on various possible cases.
		//Lower border test, hex with numbers.
		System.out.println(hexColour.ValidHex("#000000"));
		System.out.println("True");
		System.out.println();
		
		//Normal test, hex with numbers.
		System.out.println(hexColour.ValidHex("#555555"));
		System.out.println("True");
		System.out.println();
		
		//Upper border test, hex with numbers.
		System.out.println(hexColour.ValidHex("#999999"));
		System.out.println("True");
		System.out.println();
		
		//Lower border test, hex with letters.
		System.out.println(hexColour.ValidHex("#AAAAAA"));
		System.out.println("True");
		System.out.println();
		
		//Normal test, hex with letters.
		System.out.println(hexColour.ValidHex("#CCCCCC"));
		System.out.println("True");
		System.out.println();
		
		//Upper border test, hex with letters.
		System.out.println(hexColour.ValidHex("#FFFFFF"));
		System.out.println("True");
		System.out.println();
		
		//Invalid test, hex without #.
		System.out.println(hexColour.ValidHex("FFFFFF"));
		System.out.println("False");
		System.out.println();
		
		//Invalid test, hex replacing # with other char.
		System.out.println(hexColour.ValidHex("D555555"));
		System.out.println("False");
		System.out.println();
		
		//Invalid test, hex replacing # with other number.
		System.out.println(hexColour.ValidHex("0999999"));
		System.out.println("False");
		System.out.println();
		
		//Invalid test, completely different format string.
		System.out.println(hexColour.ValidHex("Matt Adshead"));
		System.out.println("False");
		System.out.println();
	}
    
} /* end class Colour */