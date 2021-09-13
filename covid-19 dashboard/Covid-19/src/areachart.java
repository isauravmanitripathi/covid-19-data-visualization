import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;


public class areachart extends visualizer {


    private final Double TRUE = 1.0;
    private final Double FALSE = 0.0;
    private final int MAX_ERROR_LENGTH = 5;

    public areachart(chartdata inputdataset) {
        super.setDataset(inputdataset);
    }

    public static void main(String[] args) {
        chartdata testdataset = new chartdata();
        File inputfile = new File("test.csv");
        testdataset.BuildDataSet(inputfile);

        System.out.println("AreaChart:: AreaChart()");
        areachart testAreaChart = new areachart(testdataset);
        System.out.println("AreaChart::BarChart()- Test Passed");

        System.out.println("AreaChart:: generatechart()");
        testAreaChart.generatechart();
        System.out.println("AreaChart::generatechart()- Test Passed");
    }

    public JFreeChart generatechart() {

        DefaultCategoryDataset areaDataset = new DefaultCategoryDataset();

        Object[] column1Data = super.getDataset().GetColumnData(
                super.firstattribute());
        Object[] column2Data = super.getDataset().GetColumnData(
                super.secondattribute());

        String column2Header = super.getDataset().GetAttributeName(
                super.secondattribute());

        boolean addDataset = true;
        String errors = "";
        int errorCounter = 0;

        int i = 0;
        while (i < super.getDataset().GetNoOfEntrys()) {

            Comparable<Object> nextValue1;
            //First value can have be any comparable object.

            nextValue1 = (Comparable<Object>) column1Data[i];
            Double nextValue2 = null;
            boolean addThis = true;
            //Second value can only be integer, double or boolean.

            try {
                int intNextValue2 = Integer.parseInt(column2Data[i].toString());
                nextValue2 = (Double) ((double) intNextValue2);
            } catch (NumberFormatException nfe) {
                try {
                    double doubleNextValue2 = Double.parseDouble(
                            column2Data[i].toString());
                    nextValue2 = doubleNextValue2;
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

            if (addThis == true) {
                areaDataset.addValue(nextValue2, column2Header, nextValue1);
            } else {
                addDataset = false;
                if (errorCounter >= MAX_ERROR_LENGTH) {
                } else {
                    errors = errors + "\n"
                            + column2Data[i].toString();
                    errorCounter++;
                }
            }
            i++;
        }

        if (addDataset != false) {
        } else {
            areaDataset = new DefaultCategoryDataset(); //Reset
            JOptionPane.showMessageDialog(null,
                    "Y-axis is a string, please select an integer value" + "\n"
                            + errors);
        }

        JFreeChart chart = ChartFactory.createAreaChart(
                super.getHeader(),
                super.dataforxaxis(),
                super.dataforyaxis(),
                areaDataset,
                PlotOrientation.VERTICAL,
                true, //include legend
                true,
                false);
        return chart;
    }

}

/*end AreaChart class */