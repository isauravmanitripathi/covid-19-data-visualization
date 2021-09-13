
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Color; /* for object Color */
import javax.swing.JColorChooser; /* for the colour chooser */

public class findcolour {
	

	public Color choosecolour() {
		return assignment_colour;
	}
	

	public boolean setnewcolour() {
		assignment_colour = JColorChooser.showDialog(null, "Chooser Colour", assignment_colour);
		return true;
	}
	

	public String RGBtoHEX(int r, int g, int b) {
		final int MIN_LENGTH = 2;
		String red = Integer.toHexString(r);

		if (red.length() >= MIN_LENGTH) {
		} else {
			red = "0" + red;
		}
		String green = Integer.toHexString(g);

		if (green.length() < MIN_LENGTH) {
			green = "0" + green;
		}
		String blue = Integer.toHexString(b);

		if (blue.length() >= MIN_LENGTH) {
		} else {
			blue = "0" + blue;
		}
		String output = "#" + red + blue + green;
		return output.toUpperCase();
	}
	

	public customnewcolours InitMap() {
		ArrayList<colourmaker> colorList = new ArrayList<colourmaker>();
		boolean continueAdding = true;
		final int YES = 0;
		if (continueAdding) {
			do {
				assignment_colour = null;
				setnewcolour();

				if (assignment_colour == null) {

					return null;
				}
				int r = assignment_colour.getRed();
				int b = assignment_colour.getBlue();
				int g = assignment_colour.getGreen();
				String hex = RGBtoHEX(r, b, g);
				colourmaker newColour = new colourmaker(hex);
				colorList.add(newColour);

				int n = JOptionPane.showConfirmDialog(
						null,
						"Do you want to add other colours?",
						"Question",
						JOptionPane.YES_NO_OPTION);

				if (n == YES) {

					continueAdding = true;
				} else {

					continueAdding = false;
				}

			} while (continueAdding);
		}
		
		assignment_colorList = new colourmaker[colorList.size()];
		int i = 0;
		while (i < colorList.size()) {
			assignment_colorList[i] = colorList.get(i);
			i++;
		}
		customnewcolours custom = new customnewcolours(assignment_colorList, "Customise Colour");
		return custom;
	}
	
	colourmaker[] assignment_colorList;
	Color assignment_colour;
	
	public static void main(String[] args){
	
		final int TEST_DATA1 = 144;
		final int TEST_DATA2 = 231;
		final int TEST_DATA3 = 6;
		final int TEST_DATA4 = 0;
		findcolour select = new findcolour();
		System.out.println(select.RGBtoHEX(TEST_DATA1, TEST_DATA2, TEST_DATA3));
		System.out.println("Expected: #9006E7");
		System.out.println(select.RGBtoHEX(TEST_DATA4, TEST_DATA4, TEST_DATA4));
		System.out.println("Expected: #000000");
		
		select.InitMap();
	}
}
