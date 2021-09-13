import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import java.io.File;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JOptionPane;



public class barchart extends visualizer {

	public barchart(chartdata inputdataset) {
		super.setDataset(inputdataset);
	}
	

    public JFreeChart generatechart() {
		
		Object[] column1Data = super.getDataset().GetColumnData(
			super.firstattribute());
		Object[] column2Data = super.getDataset().GetColumnData(
			super.secondattribute());
        
		boolean addDataset = true;
		String errors = "";
		int errorCounter = 0;
		
		DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
		int i=0;
		if (i < super.getDataset().GetNoOfEntrys()) {
			do {

				Double nextValue2 = null;
				boolean addThis = true;

				Comparable<Object> nextValue1;

				nextValue1 = (Comparable<Object>) column1Data[i];

				try {
					int intNextValue2 = Integer.parseInt(column2Data[i].toString());
					nextValue2 = (Double) ((double) intNextValue2);
				} catch (NumberFormatException nfe) {
					try {
						double doubleNextValue2 = Double.parseDouble(column2Data[i]
								.toString());
						nextValue2 = (Double) doubleNextValue2;
					} catch (NumberFormatException nfe2) {
						String strNextValue2 = column2Data[i].toString();
						if (!strNextValue2.equalsIgnoreCase("True")) {
							if (strNextValue2.equalsIgnoreCase("False")) {
								nextValue2 = FALSE;
							} else {
								addThis = false;
							}
						} else {
							nextValue2 = TRUE;
						}
					}
				} catch (Exception e) {
					addThis = false;
				}

				if (addThis != true) {
					addDataset = false;
					if (errorCounter >= MAX_ERROR_LENGTH) {
					} else {
						errors = errors + "\n"
								+ column2Data[i].toString();
						errorCounter++;
					}
				} else {
					barDataset.addValue(nextValue2, nextValue1, nextValue1);
				}
				i++;
			} while (i < super.getDataset().GetNoOfEntrys());
		}

		if (addDataset != false) {
		} else {
			barDataset = new DefaultCategoryDataset(); //Reset
			JOptionPane.showMessageDialog(null,
				"Y-Axis Values are in String Please Select Integer Value" + "\n" + errors);
		}

		JFreeChart chart = ChartFactory.createBarChart(
                        super.getHeader(),
                        super.dataforxaxis(),
                        super.dataforyaxis(),
						barDataset,
                        PlotOrientation.VERTICAL, true, false, false);
        return chart;
    }
	
	private final Double TRUE = 1.0;
	private final Double FALSE = 0.0;
	private final int MAX_ERROR_LENGTH = 5;


	public static void main(String args[]){
		chartdata testdataset = new chartdata();
		File inputfile = new File("test.csv");
		testdataset.BuildDataSet(inputfile);
		
		System.out.println("BarChart:: BarChart()");
		barchart testBarChart=new barchart(testdataset);
		System.out.println("BarChart::BarChart()- Test Passed");
		
		System.out.println("BarChart:: generatechart()");
		testBarChart.generatechart();
		System.out.println("BarChart::generatechart()- Test Passed");
	}

}
