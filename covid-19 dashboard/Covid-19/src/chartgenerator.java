import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.DateTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;


public class chartgenerator extends JPanel {


    final private int B_ROW = 4;
    final private int B_COL = 2;
    final private int H_GAP = 5;
    final private int V_GAP = 5;
    final private int WIDTH = 650;
    final private int HEIGHT = 230;
    final private int NOCHART = -1;
    final private int BARCHART = 0;
    final private int LINECHART = 2;
    final private int RINGCHART = 3;
    final private int AREACHART = 4;
    final private int NUMOFCHARTS = 7;
    private final int DAY = 24;
    private final int MILLISECOND = 1000;
    private final int MINUTE = 60;
    private final int HOUR = 3600;
    private final int FORMATTING = 2;
    private JComboBox assingmnet_attributeDropdownBar1;
    private JComboBox assingmnet_attributeDropdownBar2;

    private JTextField menubar123Header;
    private JTextField assingmnet_pieHeader;
    private JButton assingmnet_generateBarButton;
    private JButton assingmnet_generateLineButton;
    private JButton assingmnet_generateRingButton;
    private JButton assingmnet_generateAreaButton;
    private chartdata assignment_dataset;
    private ChartPanel assingmnet_frame;
    private JFrame assingmnet_window;
    private int assingmnet_chartType;
    private JFreeChart assingmnet_chart;
    private final chartdata assingmnet_data;
    public chartgenerator(chartdata data) {

        super(new GridLayout(1, 0));

        assingmnet_data = data;
        assingmnet_chartType = -1;
        assingmnet_chart = null;

    }

    public static void main(String[] args) {

        chartdata testdataset = new chartdata();
        File inputfile = new File("test.csv");
        testdataset.BuildDataSet(inputfile);
        System.out.println("Chart:: Chart()");
        chartgenerator testChart = new chartgenerator(testdataset);
        System.out.println("Chart:: Chart() - Test Passed");
        System.out.println("Chart:: SetWindowVisible()");
        testChart.SetWindowVisible();
        System.out.println("Chart:: SetWindowVisible() - Test Passed");
        System.out.println("Chart:: DisposeWindow()");
        testChart.DisposeWindow();
        System.out.println("Chart:: DisposeWindow() - Test Passed");
    }

    public int GetChartType() {
        return (assingmnet_chartType);
    }

    public boolean SetChartType(int type) {

        if ((type >= 0) && (type < NUMOFCHARTS)) {
            assingmnet_chartType = type;
            return (true);
        } else {
            return (false);
        }
    }

    public JFreeChart GetChart() {
        return (assingmnet_chart);
    }

    public void SetChart(JFreeChart chart) {
        assingmnet_chart = chart;
    }

    public String ConvertTime(long timeMillis) {
        long elapsedTime = timeMillis;
        String format = String.format("%%0%dd", FORMATTING);
        elapsedTime = elapsedTime / MILLISECOND;
        String seconds = String.format(format, elapsedTime % MINUTE);
        String minutes = String.format(format, (elapsedTime % HOUR) / MINUTE);

        int hoursTime = (int) (elapsedTime / HOUR);

        while (hoursTime > DAY) {
            hoursTime = hoursTime - DAY;
        }
        hoursTime++;

        String hours = String.format(format, hoursTime);
        String time = hours + ":" + minutes;// + ":" + seconds;
        return time;
    }

    public void DisposeWindow() {
        assingmnet_window.dispose();
    }

    public void SetWindowVisible() {
        Object[] possibleValues = new Object[NUMOFCHARTS];
        possibleValues[BARCHART] = "Bar Chart";
        possibleValues[LINECHART] = "Line Chart";
        possibleValues[RINGCHART] = "Ring Chart";
        possibleValues[AREACHART] = "Area Chart";


        Object selectedValue = JOptionPane.showInputDialog(null,
                "Type Of Chart", "Covid-19 Assignment",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[BARCHART]);

        if (selectedValue == null) {

        } else if (selectedValue == possibleValues[BARCHART]) {
            SetUpBarChart(assingmnet_data);
        }  else if (selectedValue == possibleValues[LINECHART]) {
            SetUpLineChart(assingmnet_data);
        } else if (selectedValue == possibleValues[RINGCHART]) {
            SetUpRingChart(assingmnet_data);
        } else if (selectedValue == possibleValues[AREACHART]) {
            SetUpAreaChart(assingmnet_data);
        }

        if (selectedValue != null) {
            assingmnet_window.setVisible(true);
            assingmnet_window.setLocationRelativeTo(null);
        }
    }

    public boolean SetUpAreaChart(chartdata data) {
        assignment_dataset = data;
        assingmnet_chartType = NOCHART;
        assingmnet_chart = null;
        assingmnet_window = new JFrame("Select Data");
        assingmnet_window.setSize(WIDTH, HEIGHT);
        assingmnet_window.setResizable(false);
        assingmnet_window.setLayout(new FlowLayout());

        JPanel areaPanel = new JPanel(new GridLayout(B_ROW, B_COL, H_GAP, V_GAP));
        assingmnet_window.add(areaPanel);



        Border areaPanelBorder = BorderFactory
                .createTitledBorder("Area Chart");
        areaPanel.setBorder(areaPanelBorder);

        String[] assingmnet_modelString = new String[data.GetNoOfAttributes()];

        for (int i = 0; i < data.GetNoOfAttributes(); i++) {
            assingmnet_modelString[i] = data.GetAttributeName(i);
        }

        JLabel label = new JLabel("X: Axis (Date Only)");
        areaPanel.add(label);
        assingmnet_attributeDropdownBar1 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar1.setMaximumRowCount(data.GetNoOfAttributes());
        areaPanel.add(assingmnet_attributeDropdownBar1);
        label = new JLabel("Y:Axis (Integer Value Only)");
        areaPanel.add(label);
        assingmnet_attributeDropdownBar2 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar2.setMaximumRowCount(data.GetNoOfAttributes());
        areaPanel.add(assingmnet_attributeDropdownBar2);

        menubar123Header = new JTextField("Covid-19 Area Chart");
        areaPanel.add(menubar123Header);



        assingmnet_generateAreaButton = new JButton("Generate");

        areaPanel.add(assingmnet_generateAreaButton);

        GUIEventHandler assingmnet_eventHandeler = new GUIEventHandler();
        assingmnet_generateAreaButton.addActionListener(assingmnet_eventHandeler);

        return true;
    }

    public boolean SetUpBarChart(chartdata data) {

        assignment_dataset = data;
        assingmnet_chartType = NOCHART;
        assingmnet_chart = null;
        assingmnet_window = new JFrame("Select Data ");
        assingmnet_window.setSize(WIDTH, HEIGHT);
        assingmnet_window.setResizable(false);
        assingmnet_window.setLayout(new FlowLayout());

        JPanel barPanel = new JPanel(new GridLayout(B_ROW, B_COL, H_GAP, V_GAP));
        assingmnet_window.add(barPanel);



        Border barPanelBorder = BorderFactory
                .createTitledBorder("Bar Chart");
        barPanel.setBorder(barPanelBorder);

        String[] assingmnet_modelString = new String[data.GetNoOfAttributes()];

        for (int i = 0; i < data.GetNoOfAttributes(); i++) {
            assingmnet_modelString[i] = data.GetAttributeName(i);
        }

        JLabel label = new JLabel("X:Axis (Date Only)");
        barPanel.add(label);
        assingmnet_attributeDropdownBar1 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar1.setMaximumRowCount(data.GetNoOfAttributes());
        barPanel.add(assingmnet_attributeDropdownBar1);
        label = new JLabel("Y:Axis (Integer Value Only)");
        barPanel.add(label);
        assingmnet_attributeDropdownBar2 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar2.setMaximumRowCount(data.GetNoOfAttributes());
        barPanel.add(assingmnet_attributeDropdownBar2);
        menubar123Header = new JTextField("Covid-19 Bar Chart");
        barPanel.add(menubar123Header);


        assingmnet_generateBarButton = new JButton("Generate");

        barPanel.add(assingmnet_generateBarButton);

        GUIEventHandler assingmnet_eventHandeler = new GUIEventHandler();
        assingmnet_generateBarButton.addActionListener(assingmnet_eventHandeler);

        return true;
    }



    public boolean SetUpLineChart(chartdata data) {
        assignment_dataset = data;
        assingmnet_chartType = NOCHART;
        assingmnet_chart = null;
        assingmnet_window = new JFrame("Select Data");
        assingmnet_window.setSize(WIDTH, HEIGHT);
        assingmnet_window.setResizable(false);
        assingmnet_window.setLayout(new FlowLayout());

        JPanel linePanel = new JPanel(new GridLayout(B_ROW, B_COL, H_GAP, V_GAP));
        assingmnet_window.add(linePanel);


        Border linePanelBorder = BorderFactory
                .createTitledBorder("Line Chart");
        linePanel.setBorder(linePanelBorder);

        String[] assingmnet_modelString = new String[data.GetNoOfAttributes()];

        for (int i = 0; i < data.GetNoOfAttributes(); i++) {
            assingmnet_modelString[i] = data.GetAttributeName(i);
        }

        JLabel label = new JLabel("X:Axis (Date Only)");
        linePanel.add(label);
        assingmnet_attributeDropdownBar1 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar1.setMaximumRowCount(data.GetNoOfAttributes());
        linePanel.add(assingmnet_attributeDropdownBar1);
        label = new JLabel("Y:Axis (Integer Value Only)");
        linePanel.add(label);
        assingmnet_attributeDropdownBar2 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar2.setMaximumRowCount(data.GetNoOfAttributes());
        linePanel.add(assingmnet_attributeDropdownBar2);

        menubar123Header = new JTextField("Covid_19 Line Chart");
        linePanel.add(menubar123Header);



        assingmnet_generateLineButton = new JButton("Generate");

        linePanel.add(assingmnet_generateLineButton);

        GUIEventHandler assingmnet_eventHandeler = new GUIEventHandler();
        assingmnet_generateLineButton.addActionListener(assingmnet_eventHandeler);

        return true;
    }



    public boolean SetUpRingChart(chartdata data) {
        assignment_dataset = data;
        assingmnet_chartType = NOCHART;
        assingmnet_chart = null;
        assingmnet_window = new JFrame("Select Data");
        assingmnet_window.setSize(WIDTH, HEIGHT);
        assingmnet_window.setResizable(false);
        assingmnet_window.setLayout(new FlowLayout());

        JPanel ringPanel = new JPanel(new GridLayout(B_ROW, B_COL, H_GAP, V_GAP));
        assingmnet_window.add(ringPanel);



        Border ringPanelBorder = BorderFactory
                .createTitledBorder("Ring Chart");
        ringPanel.setBorder(ringPanelBorder);

        String[] assingmnet_modelString = new String[data.GetNoOfAttributes()];

        for (int i = 0; i < data.GetNoOfAttributes(); i++) {
            assingmnet_modelString[i] = data.GetAttributeName(i);
        }

        JLabel label = new JLabel("X:Axis (Date Only)");
        ringPanel.add(label);
        assingmnet_attributeDropdownBar1 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar1.setMaximumRowCount(data.GetNoOfAttributes());
        ringPanel.add(assingmnet_attributeDropdownBar1);
        label = new JLabel("Y:Axis (Integer Value)");
        ringPanel.add(label);
        assingmnet_attributeDropdownBar2 = new JComboBox(assingmnet_modelString);
        assingmnet_attributeDropdownBar2.setMaximumRowCount(data.GetNoOfAttributes());
        ringPanel.add(assingmnet_attributeDropdownBar2);
        menubar123Header = new JTextField("Covid_19 Ring Chart");
        ringPanel.add(menubar123Header);


        assingmnet_generateRingButton = new JButton("Generate");

        ringPanel.add(assingmnet_generateRingButton);

        GUIEventHandler assingmnet_eventHandeler = new GUIEventHandler();
        assingmnet_generateRingButton.addActionListener(assingmnet_eventHandeler);

        return true;
    }



    private class GUIEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == assingmnet_generateBarButton) {
                generateBarChart();
            }  else if (event.getSource() == assingmnet_generateLineButton) {
                generateLineChart();
            } else if (event.getSource() == assingmnet_generateRingButton) {
                generateRingChart();
            } else if (event.getSource() == assingmnet_generateAreaButton) {
                generateAreaChart();
            }
        }


        public boolean generateAreaChart() {
            int A1 = assingmnet_attributeDropdownBar1.getSelectedIndex();
            int A2 = assingmnet_attributeDropdownBar2.getSelectedIndex();
            String header = menubar123Header.getText();

            areachart areaChart = new areachart(assignment_dataset);
            areaChart.setDataset(assignment_dataset);
            areaChart.setAttribute1(A1);
            areaChart.setAttribute2(A2);
            areaChart.setHeader(header);
            areaChart.setxAxis(assignment_dataset.GetAttributeName(A1));
            areaChart.setyAxis(assignment_dataset.GetAttributeName(A2));
            JFreeChart chart = areaChart.generatechart();



            areacoloured renderer = new areacoloured(
                    gui.assignment_chartmaker.GetActiveMap());
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            renderer.SetColor(plot, 1);
            plot.setForegroundAlpha(0.5f);
            SetChartType(AREACHART);
            SetChart(chart);
            assingmnet_frame = new ChartPanel(chart);
            removeAll();
            add(assingmnet_frame);
            repaint();
            revalidate();
            GroupJVTApplication.dataVisualizer.ActivateColour();
            GroupJVTApplication.dataVisualizer.SelectChartTab();
            assingmnet_window.setVisible(false);
            return true;
        }


        public boolean generateBarChart() {
            int A1 = assingmnet_attributeDropdownBar1.getSelectedIndex();
            int A2 = assingmnet_attributeDropdownBar2.getSelectedIndex();
            String header = menubar123Header.getText();


            barchart barChart = new barchart(assignment_dataset);
            barChart.setDataset(assignment_dataset);
            barChart.setAttribute1(A1);
            barChart.setAttribute2(A2);
            barChart.setHeader(header);
            barChart.setxAxis(assignment_dataset.GetAttributeName(A1));
            barChart.setyAxis(assignment_dataset.GetAttributeName(A2));
            JFreeChart chart = barChart.generatechart();
            DateTitle dateTitle = new DateTitle();
            Date now = new Date();
            String dateAndTime = dateTitle.getText();
            dateAndTime = dateAndTime + "\n" + ConvertTime(now.getTime());
            dateTitle.setText(dateAndTime);
            chart.addSubtitle(dateTitle);



            barcoloured renderer = new barcoloured(
                    gui.assignment_chartmaker.GetActiveMap());
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            CategoryDataset barDataset = plot.getDataset();
            for (int i = 1; i <= barDataset.getRowCount(); i++) {
                renderer.SetColor(plot, i);
            }


            assingmnet_frame = new ChartPanel(chart);
            SetChartType(BARCHART);
            SetChart(chart);
            removeAll();
            add(assingmnet_frame);
            repaint();
            revalidate();
            GroupJVTApplication.dataVisualizer.ActivateColour();
            GroupJVTApplication.dataVisualizer.SelectChartTab();
            assingmnet_window.setVisible(false);
            return true;
        }




        public boolean generateLineChart() {
            int A1 = assingmnet_attributeDropdownBar1.getSelectedIndex();
            int A2 = assingmnet_attributeDropdownBar2.getSelectedIndex();
            String header = menubar123Header.getText();

            linechart lineChart = new linechart(assignment_dataset);
            lineChart.setDataset(assignment_dataset);
            lineChart.setAttribute1(A1);
            lineChart.setAttribute2(A2);
            lineChart.setHeader(header);
            lineChart.setxAxis(assignment_dataset.GetAttributeName(A1));
            lineChart.setyAxis(assignment_dataset.GetAttributeName(A2));
            JFreeChart chart = lineChart.generatechart();


            linecoloured renderer = new linecoloured(
                    gui.assignment_chartmaker.GetActiveMap());
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            renderer.SetColor(plot, 1);
            SetChartType(LINECHART);
            SetChart(chart);
            assingmnet_frame = new ChartPanel(chart);
            removeAll();
            add(assingmnet_frame);
            repaint();
            revalidate();
            GroupJVTApplication.dataVisualizer.ActivateColour();
            GroupJVTApplication.dataVisualizer.SelectChartTab();
            assingmnet_window.setVisible(false);
            return true;
        }





        public boolean generateRingChart() {
            int A1 = assingmnet_attributeDropdownBar1.getSelectedIndex();
            int A2 = assingmnet_attributeDropdownBar2.getSelectedIndex();
            String header = menubar123Header.getText();

            ringchart ring = new ringchart(assignment_dataset);
            ring.setAttribute1(A1);
            ring.setAttribute2(A2);
            ring.setHeader(header);
            JFreeChart chart = ring.generatechart();


            RingPlot plot = (RingPlot) chart.getPlot();
            PieDataset dataset = plot.getDataset();

            ringcoloured renderer = new ringcoloured(
                    gui.assignment_chartmaker.GetActiveMap());
            renderer.SetColor(plot, dataset);
            SetChartType(RINGCHART);
            SetChart(chart);
            assingmnet_frame = new ChartPanel(chart);
            removeAll();
            add(assingmnet_frame);
            repaint();
            revalidate();
            GroupJVTApplication.dataVisualizer.ActivateColour();
            GroupJVTApplication.dataVisualizer.SelectChartTab();
            assingmnet_window.setVisible(false);
            return true;
        }


    }

} /* end Chart class */