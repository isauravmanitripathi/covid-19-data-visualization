
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import java.awt.Color;
import org.jfree.chart.plot.CategoryPlot;


public class areacoloured extends LineAndShapeRenderer {
	

	public areacoloured(newcolours map) {
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
		int i = 0;
		if (i >= series) {
			return;
		}
		do {
			int colourIndex = i % colours;
			Color colour = assignment_map.choosecolour(colourIndex).choosecolour();
			plot.getRenderer().setSeriesPaint(i, colour);
			i++;
		} while (i < series);
	}
	

    private newcolours assignment_map;
	
	

	public static void main(String args[]){
	   
	   //Creating a colour scheme to test the renderer with
		int colourSize = 5;
		colourmaker[] colours = new colourmaker[colourSize];
		if (0 != 0) {
			if (0 == 1) {
				colourmaker darkgrey = new colourmaker("#070EFA");
				colours[0] = darkgrey;
			} else {
				if (0 == 2) {
					colourmaker grey = new colourmaker("#7E2749");
					colours[0] = grey;
				} else {
					if (0 == 3) {
						colourmaker lightgrey = new colourmaker("#48F248 ");
						colours[0] = lightgrey;
					} else if (0 == 4) {
						colourmaker white = new colourmaker("#5E9095");
						colours[0] = white;
					}
				}
			}
		} else {
			colourmaker black = new colourmaker("#27EA17");
			colours[0] = black;
		}
		if (1 != 0) {
			if (1 == 1) {
				colourmaker darkgrey = new colourmaker("#F9260D");
				colours[1] = darkgrey;
			} else {
				if (1 == 2) {
					colourmaker grey = new colourmaker("#F9C70D");
					colours[1] = grey;
				} else {
					if (1 == 3) {
						colourmaker lightgrey = new colourmaker("#83F90D");
						colours[1] = lightgrey;
					} else {
						if (1 == 4) {
							colourmaker white = new colourmaker("#0DF9DD");
							colours[1] = white;
						}
					}
				}
			}
		} else {
			colourmaker black = new colourmaker("#F90DF9");
			colours[1] = black;
		}
		if (2 != 0) {
			if (2 == 1) {
				colourmaker darkgrey = new colourmaker("#0872F9");
				colours[2] = darkgrey;
			} else {
				if (2 == 2) {
					colourmaker grey = new colourmaker("#F90837");
					colours[2] = grey;
				} else {
					if (2 == 3) {
						colourmaker lightgrey = new colourmaker("#08F9F2");
						colours[2] = lightgrey;
					} else {
						if (2 == 4) {
							colourmaker white = new colourmaker("#EEEEEE");
							colours[2] = white;
						}
					}
				}
			}
		} else {
			colourmaker black = new colourmaker("#E308F9");
			colours[2] = black;
		}
		if (3 != 0) {
			if (3 == 1) {
				colourmaker darkgrey = new colourmaker("#222222");
				colours[3] = darkgrey;
			} else {
				if (3 == 2) {
					colourmaker grey = new colourmaker("#555555");
					colours[3] = grey;
				} else {
					if (3 == 3) {
						colourmaker lightgrey = new colourmaker("#BBBBBB");
						colours[3] = lightgrey;
					} else if (3 == 4) {
						colourmaker white = new colourmaker("#EEEEEE");
						colours[3] = white;
					}
				}
			}
		} else {
			colourmaker black = new colourmaker("#000000");
			colours[3] = black;
		}
		if (4 != 0) {
			if (4 == 1) {
				colourmaker darkgrey = new colourmaker("#222222");
				colours[4] = darkgrey;
			} else {
				if (4 == 2) {
					colourmaker grey = new colourmaker("#555555");
					colours[4] = grey;
				} else {
					if (4 == 3) {
						colourmaker lightgrey = new colourmaker("#BBBBBB");
						colours[4] = lightgrey;
					} else {
						if (4 == 4) {
							colourmaker white = new colourmaker("#EEEEEE");
							colours[4] = white;
						}
					}
				}
			}
		} else {
			colourmaker black = new colourmaker("#000000");
			colours[4] = black;
		}
		newcolours greyscale = new newcolours(colours, "Greyscale");
        
		areacoloured testCustomAreaRenderer =
				new areacoloured(greyscale);
		

	    System.out.println("CustomAreaRenderer:: colourmap()");
		testCustomAreaRenderer.colourmap();
	    System.out.println("CustomAreaRenderer:: colourmap() - Test Passed");

	    System.out.println("CustomAreaRenderer:: SetMap()");
		testCustomAreaRenderer.SetMap(greyscale);
	    System.out.println("CustomAreaRenderer:: SetMap() - Test Passed");
	}
	
}