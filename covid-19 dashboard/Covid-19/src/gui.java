import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.category.CategoryDataset;
import javax.swing.ImageIcon;



public final class gui extends JFrame {
    public gui() {

        assignment_event_handler = new GUIEventHandler();
        FILE_CHOOSER = new JFileChooser();
		
        this.setJMenuBar(createMenuBar());
        createControlPanel();	
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        

        setMinimumSize(new Dimension(MIN_FRAME_WIDTH, MIN_FRAME_HEIGHT));
        

        assignment_chartmaker = new choosecolour();
        assignment_chartmaker.setVisible(false);
    }
	

    public void ActivateColour() {
        assignment_exportVisualization_Button.setEnabled(true);
        assignment_editMenuIteassignment_ChangeColourScheme.setEnabled (true);
        assignment_ChangeColourScheme_Button.setEnabled (true);
    }
	

    public void DisactivateColour() {
        
        assignment_editMenuIteassignment_ChangeColourScheme.setEnabled (false);
        assignment_ChangeColourScheme_Button.setEnabled (false);
    }
    

    public void RedrawChartColour() {
    	
        JFreeChart chart;
		final int NOCHART = -1;
		final int BARCHART = 0;
		final int LINECHART = 1;
		final int RINGCHART = 2;
		final int AREACHART = 3;
    	if (assignment_chart.GetChart() == null) {
            System.out.println("Error: No chart object found.");
    	} else {
            chart = assignment_chart.GetChart();
            
            if (assignment_chart.GetChartType() == NOCHART) {
                System.out.println("Error: No chart object found.");
                    
            } else {
                if (assignment_chart.GetChartType() == BARCHART) {
                    barcoloured renderer = new barcoloured(
                            gui.assignment_chartmaker.GetActiveMap());
                    CategoryPlot plot = (CategoryPlot) chart.getPlot();
                    CategoryDataset barDataset = plot.getDataset();
                    int i = 1;
                    while (i <= barDataset.getRowCount()) {
                        renderer.SetColor(plot, i);
                        i++;
                    }
                } else {
                        if (assignment_chart.GetChartType() == LINECHART) {
                            linecoloured renderer = new linecoloured(
                                    assignment_chartmaker.GetActiveMap());
                            CategoryPlot plot = (CategoryPlot) chart.getPlot();
                            renderer.SetColor(plot, 1);
                        } else {
                            if (assignment_chart.GetChartType() == RINGCHART) {
                                RingPlot plot = (RingPlot) chart.getPlot();
                                PieDataset dataset = plot.getDataset();
                                ringcoloured renderer = new ringcoloured(
                                        assignment_chartmaker.GetActiveMap());
                                renderer.SetColor(plot, dataset);
                            } else {
                                if (assignment_chart.GetChartType() == AREACHART) {
                                    areacoloured renderer = new areacoloured(
                                            assignment_chartmaker.GetActiveMap());
                                    CategoryPlot plot = (CategoryPlot) chart.getPlot();
                                    plot.setForegroundAlpha(0.5f);
                                    renderer.SetColor(plot, 1);
                                }
                            }
                        }
                    }
                }
            }
    	}

	

    public void SelectChartTab() {
        
    	assignment_tabbedPanel.setSelectedIndex(CHART_PANEL);
    }
   

    private void generateandexport() {
     
        assignment_drawchartbutton.setEnabled (true);
        assignment_exportVisualization_Button.setEnabled (true);
        assignment_editMenuIteassignment_DrawChart.setEnabled (true);
        assignment_file_menu_Iteassignment_Export.setEnabled (true);
        assignment_Forecast_Button.setEnabled(true);
        assignment_editMenuIteassignment_Forecast.setEnabled(true);
    }  
	

    private JPanel createButtonPanel(){

        ImageIcon openImg = new ImageIcon();
        assignment_newFile1_Button = new JButton(openImg);
        assignment_newFile1_Button.setOpaque(false);
        assignment_newFile1_Button.setContentAreaFilled(false);
        assignment_newFile1_Button.setBorderPainted(false);

        assignment_newFile1_Button.addActionListener(assignment_event_handler);

        ImageIcon exportImg = new ImageIcon();
        assignment_exportVisualization_Button = new JButton(exportImg);
        assignment_exportVisualization_Button.setOpaque(false);
        assignment_exportVisualization_Button.setContentAreaFilled(false);
        assignment_exportVisualization_Button.setBorderPainted(false);

        assignment_exportVisualization_Button.addActionListener(assignment_event_handler);

        ImageIcon chartImg = new ImageIcon();
        assignment_drawchartbutton = new JButton(chartImg);
        assignment_drawchartbutton.setOpaque(false);
        assignment_drawchartbutton.setContentAreaFilled(false);
        assignment_drawchartbutton.setBorderPainted(false);

        assignment_drawchartbutton.addActionListener(assignment_event_handler);

        ImageIcon colourPickerImg = new ImageIcon();
        assignment_ChangeColourScheme_Button = new JButton(colourPickerImg);
        assignment_ChangeColourScheme_Button.setOpaque(false);
        assignment_ChangeColourScheme_Button.setContentAreaFilled(false);
        assignment_ChangeColourScheme_Button.setBorderPainted(false);


        assignment_ChangeColourScheme_Button.addActionListener(assignment_event_handler);

        ImageIcon forecastImg = new ImageIcon();
        assignment_Forecast_Button = new JButton(forecastImg);
        assignment_Forecast_Button.setOpaque(false);
        assignment_Forecast_Button.setContentAreaFilled(false);
        assignment_Forecast_Button.setBorderPainted(false);

        assignment_Forecast_Button.addActionListener(assignment_event_handler);



        JPanel panel = new JPanel();




        return panel;
    }


    private void createControlPanel() {
    	
    	JPanel assignment_buttonPanel = createButtonPanel();
    	JTabbedPane tabPanel = newTabPanel();


    	JPanel controlPanel = new JPanel();
    	controlPanel.setLayout(new GridLayout(1,1));
    	controlPanel.add(assignment_buttonPanel);


    	add(controlPanel, BorderLayout.NORTH);
    	add(tabPanel);
    } 
    

    private JMenu editingmenu() {
        

        assignment_editMenu = new JMenu("Edit");
        menubar123.add(assignment_editMenu);
        

        assignment_editMenuIteassignment_DrawChart = new JMenuItem("Draw Chart");

        assignment_editMenuIteassignment_DrawChart.addActionListener(assignment_event_handler);

        assignment_editMenuIteassignment_ChangeColourScheme = new JMenuItem(
        		);

        assignment_editMenuIteassignment_ChangeColourScheme.addActionListener(assignment_event_handler);

        assignment_editMenuIteassignment_Forecast = new JMenuItem("Forecast");


        assignment_editMenuIteassignment_Forecast.addActionListener(assignment_event_handler);

        assignment_editMenuIteassignment_DrawChart.setEnabled (false);
        assignment_editMenuIteassignment_ChangeColourScheme.setEnabled (false);
        assignment_editMenuIteassignment_Forecast.setEnabled(false);
 

        assignment_editMenu.add(assignment_editMenuIteassignment_DrawChart);
        assignment_editMenu.add(assignment_editMenuIteassignment_ChangeColourScheme);
        assignment_editMenu.add(assignment_editMenuIteassignment_Forecast);
    	
        return assignment_editMenu;
    }
	

    private JMenu newfilemenu() {
         

        assignment_file_menu_ = new JMenu("CSV FILE");
        menubar123.add(assignment_file_menu_);
        

        assignment_file_menu_Iteassignment_Open = new JMenuItem("Open");

        assignment_file_menu_Iteassignment_Open.addActionListener(assignment_event_handler);
        
        assignment_file_menu_Iteassignment_Export = new JMenuItem("Save Chart");

        assignment_file_menu_Iteassignment_Export.addActionListener(assignment_event_handler);
        
        assignment_file_menu_Iteassignment_Exit = new JMenuItem("Exit");

        assignment_file_menu_Iteassignment_Exit.addActionListener(assignment_event_handler);


        

        assignment_file_menu_Iteassignment_Export.setEnabled (false);
 

        assignment_file_menu_.add(assignment_file_menu_Iteassignment_Open);
        assignment_file_menu_.add(assignment_file_menu_Iteassignment_Export);
        assignment_file_menu_.addSeparator();
        assignment_file_menu_.add(assignment_file_menu_Iteassignment_Exit);
    	
        return assignment_file_menu_;
    }
    

	

    private JMenuBar createMenuBar() {//creates the menu bar at the top
    	
    	menubar123 = new JMenuBar();
    	newfilemenu();
    	editingmenu();
    	return menubar123;
    }
	

    private JTabbedPane newTabPanel(){//creates the tabs

        assignment_tabbedPanel = new JTabbedPane();

        assignemnt_gui_panel1 = new JPanel();
        assignemnt_gui_panel1.setLayout(new GridLayout(1, 1));
        assignment_tabbedPanel.addTab( "CSV File", assignemnt_gui_panel1);

        assignment_gui_panel2 = new JPanel();
        assignment_gui_panel2.setLayout(new GridLayout(1, 1));
        assignment_tabbedPanel.addTab( "Chart", assignment_gui_panel2 );
        add(assignment_tabbedPanel, BorderLayout.CENTER);


		
        return assignment_tabbedPanel;
    }


    private Boolean newFile1(){


    	assignment_dataSetBackup = assignment_dataSet;
    	//opens file and then outputs it into a table as well as gets the data ready in  formal to put into charts


        if (openingfilefirst) {
                openingfilefirst = false;
                FileFilter extensionFilter = new FileNameExtensionFilter(
                                    "CSV Files (.csv)", "csv");
                FILE_CHOOSER.addChoosableFileFilter(extensionFilter);
                        }

        int returnVal = FILE_CHOOSER.showOpenDialog(gui.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File assignment_file = FILE_CHOOSER.getSelectedFile();

            assignment_dataSet = new chartdata();
            if (assignment_dataSet.BuildDataSet(assignment_file)) {

                DisactivateColour();
                assignemnt_gui_panel1.removeAll();
                assignemnt_gui_panel1.add(new multiplefilechooser(assignment_dataSet));
                assignemnt_gui_panel1.repaint();
                assignemnt_gui_panel1.revalidate();
                assignment_tabbedPanel.setSelectedIndex(TABLE_PANEL);

                if (loadingfile) {

                    assignment_chart = new chartgenerator(assignment_dataSet);
                    loadingfile = false;
                } else {

                    assignment_chart.DisposeWindow();
                    assignment_chart = new chartgenerator(assignment_dataSet);
                }

                assignment_gui_panel2.removeAll();
                assignment_gui_panel2.add(assignment_chart);

                assignment_chartmaker.setVisible(false);
            } else {

                assignment_dataSet = assignment_dataSetBackup;
                return false;

            }
        } else {
            return false;
        }
    	return true;
    }
   

    private class GUIEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == assignment_file_menu_Iteassignment_Open
                    || event.getSource() == assignment_newFile1_Button) {
        try {
        if (newFile1()) {

        generateandexport();
        assignment_exportVisualization_Button.setEnabled(false);
        } else {

        }
        } catch (NullPointerException e) {

        }

        } else {

                if (event.getSource() != assignment_file_menu_Iteassignment_Exit) {
                    if(event.getSource()== assignment_Forecast_Button || event.getSource() == assignment_editMenuIteassignment_Forecast){
                        System.out.println("bruh");
                        Linear_Regression lr = new Linear_Regression();//starts linear regression. Opens in a new frame
                        lr.Setup(assignment_dataSet);



                    }
                    else if (event.getSource() == assignment_exportVisualization_Button ||
                            event.getSource() == assignment_file_menu_Iteassignment_Export) {

                        int chartwidth = assignment_gui_panel2.getSize().width;
                        int chartheight = assignemnt_gui_panel1.getSize().height;

                        graphsaver saver = new graphsaver(assignment_chart, chartwidth, chartheight);

                        saver.setJPanel(assignment_gui_panel2);

                    } else {
                        if (event.getSource() != assignment_drawchartbutton
                                && event.getSource() != assignment_editMenuIteassignment_DrawChart) {
                                    if (event.getSource() == assignment_editMenuIteassignment_ChangeColourScheme
                                            || event.getSource() == assignment_ChangeColourScheme_Button) {
                                            assignment_chartmaker.setVisible(true);


                                    }
                                } else {
                            try {
                                assignment_chart.SetWindowVisible();
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                } else {

                    dispose();

                }
            }
        }
    } /* end class GUIEventHandler */
   	
    public static choosecolour assignment_chartmaker;
    

    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 600;
    private final int MIN_FRAME_WIDTH = 500;
    private final int MIN_FRAME_HEIGHT = 500;
    

    private final int TABLE_PANEL = 0;
    private final int CHART_PANEL = 1;

    private final JFileChooser FILE_CHOOSER;
    

    private Boolean openingfilefirst = true;
    private Boolean loadingfile = true;
    
    private GUIEventHandler assignment_event_handler;
    

    private JMenuBar menubar123;
    private JMenu assignment_file_menu_;
    private JMenu assignment_editMenu;

    

    private JMenuItem assignment_file_menu_Iteassignment_Open;
    private JMenuItem assignment_file_menu_Iteassignment_Export;
    private JMenuItem assignment_file_menu_Iteassignment_Exit;
    

    private JMenuItem assignment_editMenuIteassignment_DrawChart;
    private JMenuItem assignment_editMenuIteassignment_ChangeColourScheme;
    private JMenuItem assignment_editMenuIteassignment_Forecast;

    

    private JButton assignment_newFile1_Button;
    private JButton assignment_exportVisualization_Button;
    private JButton assignment_drawchartbutton;
    private JButton assignment_ChangeColourScheme_Button;
    private JButton assignment_Forecast_Button;
    private JTabbedPane assignment_tabbedPanel;
    

    private JPanel assignemnt_gui_panel1;
    private JPanel assignment_gui_panel2;


    private chartdata assignment_dataSet;


    private chartdata assignment_dataSetBackup;
    private chartgenerator assignment_chart;


    public static void main(String[] args) {  
        gui dataVisualizer = new gui();
        dataVisualizer.setLocationRelativeTo(null);
        dataVisualizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dataVisualizer.setTitle("Data Visualizer");
        dataVisualizer.setVisible(true);
    } /* end main */
} /* end class DataVisualizerGUI */

