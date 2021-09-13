import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import java.io.File;
import javax.swing.JOptionPane;


public class linechart extends visualizer {
	

	public linechart(chartdata inputdataset) {
		super.setDataset(inputdataset);
	}
	

	public JFreeChart generatechart() {
		
		DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
		
		Object[] column1Data = super.getDataset().GetColumnData(
			super.firstattribute());
		Object[] column2Data = super.getDataset().GetColumnData(
			super.secondattribute());
		
		String column2Header = super.getDataset().GetAttributeName(
			super.secondattribute());
		
		boolean addDataset = true;
		String errors = "";
		int errorCounter = 0;
		
		for (int i=0; i<super.getDataset().GetNoOfEntrys();i++) {	
            
			Comparable<Object> nextValue1;
            nextValue1 = (Comparable<Object>) column1Data[i];
            
			Double nextValue2 = null;
			
			boolean addThis = true;
			
			try {
				int intNextValue2 = Integer.parseInt(column2Data[i].toString());
				nextValue2 = (Double) ((double) intNextValue2);
			} catch (NumberFormatException nfe) {
				try {
					double doubleNextValue2 = Double.parseDouble(
							column2Data[i].toString());
					nextValue2 = (Double) doubleNextValue2;
				} catch (NumberFormatException nfe2) {
					String strNextValue2 = column2Data[i].toString();
					if (strNextValue2.equalsIgnoreCase("True")) {
						nextValue2 = TRUE;
					} else if (strNextValue2.equalsIgnoreCase("False")) {
						nextValue2 = FALSE;
					} else {
						addThis = false;
					}
				}
			} catch (Exception e) {
				addThis = false;
			}
			
			if (addThis == true) {
				lineDataset.addValue( nextValue2, column2Header, nextValue1 );
			} else {
				addDataset = false;
				if (errorCounter < MAX_ERROR_LENGTH) {
					errors = errors + "\n"
					+ column2Data[i].toString();
					errorCounter++;
				}
			} 
        }
		
		if (addDataset == false) {
			lineDataset = new DefaultCategoryDataset(); //Reset
			JOptionPane.showMessageDialog(null, 
				"Please Select on Integer Value For This Axis"
					+ errors);
		}
		
		 JFreeChart chart = ChartFactory.createLineChart( 
                        super.getHeader(),
						super.dataforyaxis(),
						super.dataforyaxis(),
						lineDataset,
						PlotOrientation.VERTICAL,
                        true, //include legend
                        true,
                        false );
        return chart;
	}
	private final Double TRUE = 1.0;
	private final Double FALSE = 0.0;
	private final int MAX_ERROR_LENGTH = 5;
	

	public static void main(String args[]){
		chartdata testdataset = new chartdata();
		File inputfile = new File("test.csv");
		testdataset.BuildDataSet(inputfile);
		
		System.out.println("LineChart:: LineChart()");
		linechart testLineChart=new linechart(testdataset);
		System.out.println("LineChart::LineChart()- Test Passed");
		
		System.out.println("LineChart:: generatechart()");
		testLineChart.generatechart();
		System.out.println("LineChart::generatechart()- Test Passed");
	}
}