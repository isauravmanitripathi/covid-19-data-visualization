import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


public class graphsaver {
		

	public graphsaver(chartgenerator chart, int defaultchartwidth,
					  int defaultchartheight) {
		assignment_chart = chart;
		assignment_Frame = new JFrame("Save Chart");
		assignment_Frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		assignment_Frame.setResizable(false);
		assignment_Frame.setLocationRelativeTo(null);
        assignment_Frame.setLayout(new FlowLayout());
		
		assignment_panel = new JPanel(new GridLayout(ROWS,COLUMNS));
		
		Border border = BorderFactory
                .createTitledBorder("Save Settings");
        assignment_panel.setBorder(border);
		
        assignment_Frame.add(assignment_panel);
		
		JLabel label = new JLabel("File Title");
		assignment_panel.add(label);
		assignment_fileTitle = new JTextField("Untitled");
        assignment_panel.add(assignment_fileTitle);
		
		label = new JLabel("Chart Width");
		assignment_panel.add(label);
		assignment_chartWidth = new JTextField(Integer.toString(
			defaultchartwidth));
        assignment_panel.add(assignment_chartWidth);
		
		label = new JLabel("Chart Height      ");
		assignment_panel.add(label);
		assignment_chartHeight = new JTextField(Integer.toString(
			defaultchartheight));
        assignment_panel.add(assignment_chartHeight);
		
		JLabel blankLabel1 = new JLabel("");
        assignment_panel.add(blankLabel1);
		JLabel blankLabel2 = new JLabel("");
		assignment_panel.add(blankLabel2);
		JLabel blankLabel3 = new JLabel("");
		assignment_panel.add(blankLabel3);
		
		assignment_Save = new JButton("Save");
		assignment_panel.add(assignment_Save);
		
		SaveEventHandler eventHandeler = new SaveEventHandler();
        assignment_Save.addActionListener(eventHandeler);
		
		assignment_Frame.setVisible(true);
		
	}
	

	public JPanel getJPanel() {
		return assignment_ChartPanel;
	}
	

	public boolean setJPanel(JPanel panel) {
		assignment_ChartPanel = panel;
		return true;
	}
	
	

    private class SaveEventHandler implements ActionListener {
		
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource()== assignment_Save){
                Save();                  
			}
		}	

	public boolean Save() {
		String filename = assignment_fileTitle.getText();
		
		//Stop saving if no filename is given.
		if (filename.isEmpty()) {
			JOptionPane.showMessageDialog(null, 
				"No filename");
			return false;
		}
		
		int width;
		int height;
		String str_width = assignment_chartWidth.getText().toString();
		String str_height = assignment_chartHeight.getText().toString();
		try {
			width = Integer.valueOf(str_width);
			height = Integer.valueOf(str_height);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
				"Width and Height entered not numbers");
			return false;
		}
		       
		try {
			
			BufferedImage bi = new BufferedImage(width, 
           		height, BufferedImage.TYPE_INT_ARGB);       
			Graphics g = bi.createGraphics();
			assignment_ChartPanel.paint(g);  //this == JComponent
			g.dispose();
			
			ImageIO.write(bi,"png",new File(filename + ".png"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
				"Save unsuccessful");
			return false;
		}
	
		JOptionPane.showMessageDialog(null, "Save successful");
		assignment_Frame.setVisible(false);
		return true;
	}
			
        
	
	}

	final private int DEFAULT_WIDTH = 200;

	final private int DEFAULT_HEIGHT = 200;

	final private int ROWS = 5;

	final private int COLUMNS = 2;

	private JPanel assignment_ChartPanel;

	private JPanel assignment_panel;

	private JButton assignment_Save;

	private chartgenerator assignment_chart;

	private JFrame assignment_Frame;

	private JTextField assignment_fileTitle;

	private JTextField assignment_chartWidth;

	private JTextField assignment_chartHeight;
	

	public static void main(String args[]){
		chartdata testdataset = new chartdata();
		File inputfile = new File("test.csv");
		testdataset.BuildDataSet(inputfile);
		chartgenerator testChart = new chartgenerator(testdataset);
		int width = 400;
		int height = 400;
		System.out.println("GraphSaver:: GraphSaver()");
		graphsaver testSave = new graphsaver(testChart, width, height);
		System.out.println("GraphSaver:: GraphSaver() - Test Passed");
	}
}