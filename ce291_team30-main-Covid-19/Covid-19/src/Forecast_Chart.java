import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XIntervalSeriesCollection;
import java.util.Arrays;
import java.util.List;
public class Forecast_Chart {
    public Forecast_Chart(){

    }
    public JFreeChart forcastchart(List<List<Integer>>Data,List<List<Integer>>Prediction){

        DefaultCategoryDataset data = new DefaultCategoryDataset();
        String S1 = "forcast";
        String S2 = "Actual";

        for(List<Integer> i: Prediction){
            data.addValue(i.get(1),S1,i.get(0));
        }
        for(List<Integer> i: Data){
            data.addValue(i.get(1),S2,i.get(0));
        }

        String chartTitle = "Covid deaths/Cases Predictions";
        String categoryAxisLabel = "days";
        String valueAxisLabel = "Cases/deaths";
        JFreeChart chart = ChartFactory.createLineChart(chartTitle,categoryAxisLabel, valueAxisLabel, data, PlotOrientation.VERTICAL,true,true,false);
        return chart;
    }

}
