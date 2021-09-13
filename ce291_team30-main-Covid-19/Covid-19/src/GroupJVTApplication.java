import javax.swing.JFrame;



public class GroupJVTApplication {  
	
   public static gui dataVisualizer = new gui();
    

    public static void main(String[] args) {  
        dataVisualizer = new gui();
        dataVisualizer.setLocationRelativeTo(null);
        dataVisualizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dataVisualizer.setTitle("Data Visualizer");
        dataVisualizer.setVisible(true);
    } /* end main */
} /* end Class GroupFGMApplication */