
import java.awt.Color;

import org.jfree.data.general.PieDataset;
import org.jfree.chart.plot.RingPlot;


 
 public class ringcoloured {
	

    public ringcoloured(newcolours map) {
        SetMap(map);
    }
	

    public newcolours colourmap() {
        return(assignment_map);
    }
	

    public boolean SetMap(newcolours map) {
        assignment_map = map;
        return(true);
    } 
	

    public void SetColor(RingPlot plot, PieDataset dataset) {
        
    	int colours = assignment_map.choosenumber();
    	for (int i = 0; i < dataset.getItemCount(); i++) { 
            int colourIndex = i % colours; 
            Color colour = assignment_map.choosecolour(colourIndex).choosecolour();
            plot.setSectionPaint(dataset.getKey(i), colour);
        } 
    }
	

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
        
		ringcoloured testCustomRingRenderer =
				new ringcoloured(greyscale);
				
		//Test colourmap method
	    testCustomRingRenderer.colourmap();
	    System.out.println("CustomRingRenderer:: colourmap() - Test Passed");
	    //Test SetMap method
	    testCustomRingRenderer.SetMap(greyscale);
	    System.out.println("CustomRingRenderer:: SetMap() - Test Passed");
		}
 }