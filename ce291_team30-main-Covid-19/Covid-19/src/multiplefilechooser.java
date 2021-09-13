import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File; /* Used in testing */



public class multiplefilechooser extends JPanel {
	

    public multiplefilechooser(chartdata ds) {
        	
        super(new GridLayout(1, 0));

        final JTable table = new JTable(ds.GetData(), ds.GetAttributes()) {
            private static final long serialVersionUID = 1L;
            
            public boolean getScrollableTracksViewportWidth(){ 
                return getPreferredSize().width < getParent().getWidth();
            }
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disable cell editing
            }
        };

        table.setFillsViewportHeight(true);

        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for(int i=0 ; i < ds.GetNoOfAttributes(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }    
        

        JScrollPane scrollPane = new JScrollPane(table);
        
        this.add(scrollPane);		
        this.setOpaque(true);
    }
	

    public static void main(String args[]) {
		File inputfile = new File("test.csv");
		chartdata data = new chartdata();
		data.BuildDataSet(inputfile);
		System.out.println("TableView:: TableView(testdata)");
		multiplefilechooser table = new multiplefilechooser(data);
		table.show();
		System.out.println("TableView:: TableView(testdata) - Test Passed");
	}
	
	
} /* end TableView class */
