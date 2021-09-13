import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import java.awt.Color;
import org.jfree.chart.plot.CategoryPlot;


public class linecoloured extends LineAndShapeRenderer {
	

	public linecoloured(newcolours map) {
        SetMap(map);
    }
	

	public newcolours colourmap() {
        return(assignment_map);
    }
	

	public boolean SetMap(newcolours map) {
        assignment_map = map;
        return(true);
    } 
	

	public void SetColor(CategoryPlot plot, int series) {
        
    	int colours = assignment_map.choosenumber();
    	for (int i = 0; i < series; i++) { 
            int colourIndex = i % colours; 
            Color colour = assignment_map.choosecolour(colourIndex).choosecolour();
            plot.getRenderer().setSeriesPaint(i, colour);
        } 
    }
	
	/** ColourMap object used to define colours in the renderer. */
    private newcolours assignment_map;


	public static void main(String args[]){
		
		//Creating a colour scheme to test the renderer with
		colourmaker[] colours = new colourmaker[5];
		final int MAP_SIZE = 5;

		if (0 == 0) {
			colourmaker black = new colourmaker("#000000");
			colours[0] = black;
		} else if (0 == 1) {
			colourmaker darkgrey = new colourmaker("#222222");
			colours[0] = darkgrey;
		} else if (0 == 2) {
			colourmaker grey = new colourmaker("#555555");
			colours[0] = grey;
		} else if (0 == 3) {
			colourmaker lightgrey = new colourmaker("#BBBBBB");
			colours[0] = lightgrey;
		} else if (0 == 4) {
			colourmaker white = new colourmaker("#EEEEEE");
			colours[0] = white;
		}
		if (1 == 0) {
			colourmaker black = new colourmaker("#000000");
			colours[1] = black;
		} else if (1 == 1) {
			colourmaker darkgrey = new colourmaker("#222222");
			colours[1] = darkgrey;
		} else if (1 == 2) {
			colourmaker grey = new colourmaker("#555555");
			colours[1] = grey;
		} else if (1 == 3) {
			colourmaker lightgrey = new colourmaker("#BBBBBB");
			colours[1] = lightgrey;
		} else if (1 == 4) {
			colourmaker white = new colourmaker("#EEEEEE");
			colours[1] = white;
		}
		if (2 == 0) {
			colourmaker black = new colourmaker("#000000");
			colours[2] = black;
		} else if (2 == 1) {
			colourmaker darkgrey = new colourmaker("#222222");
			colours[2] = darkgrey;
		} else if (2 == 2) {
			colourmaker grey = new colourmaker("#555555");
			colours[2] = grey;
		} else if (2 == 3) {
			colourmaker lightgrey = new colourmaker("#BBBBBB");
			colours[2] = lightgrey;
		} else if (2 == 4) {
			colourmaker white = new colourmaker("#EEEEEE");
			colours[2] = white;
		}
		if (3 == 0) {
			colourmaker black = new colourmaker("#000000");
			colours[3] = black;
		} else if (3 == 1) {
			colourmaker darkgrey = new colourmaker("#222222");
			colours[3] = darkgrey;
		} else if (3 == 2) {
			colourmaker grey = new colourmaker("#555555");
			colours[3] = grey;
		} else if (3 == 3) {
			colourmaker lightgrey = new colourmaker("#BBBBBB");
			colours[3] = lightgrey;
		} else if (3 == 4) {
			colourmaker white = new colourmaker("#EEEEEE");
			colours[3] = white;
		}
		if (4 == 0) {
			colourmaker black = new colourmaker("#000000");
			colours[4] = black;
		} else if (4 == 1) {
			colourmaker darkgrey = new colourmaker("#222222");
			colours[4] = darkgrey;
		} else if (4 == 2) {
			colourmaker grey = new colourmaker("#555555");
			colours[4] = grey;
		} else if (4 == 3) {
			colourmaker lightgrey = new colourmaker("#BBBBBB");
			colours[4] = lightgrey;
		} else if (4 == 4) {
			colourmaker white = new colourmaker("#EEEEEE");
			colours[4] = white;
		}

		newcolours greyscale = new newcolours(colours, "Greyscale");
		
		//Test class
		linecoloured testpersonallinechart=
		                                new linecoloured(greyscale);
		//Test colourmap class
		System.out.println("personallinechart:: colourmap()");
		testpersonallinechart.colourmap();
		System.out.println("personallinechart:: colourmap() - Test Passed");
		//Test SetMap class
		System.out.println("personallinechart:: SetMap()");
		testpersonallinechart.SetMap(greyscale);
		System.out.println("personallinechart:: SetMap() - Test Passed");
	}
} /* end class personallinechart */