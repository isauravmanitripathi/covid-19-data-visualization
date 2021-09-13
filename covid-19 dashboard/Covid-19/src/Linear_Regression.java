import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Linear_Regression extends JFrame {
    List<List<Integer>> copy = new ArrayList<>();
    List<List<Integer>> forcast_data = new ArrayList<>();
    int days = 0;
    final private int B_ROW = 4;
    final private int B_COL = 2;
    final private int H_GAP = 5;
    final private int V_GAP = 5;
    final private int WIDTH = 650;
    final private int HEIGHT = 230;
    JComboBox dropdown;
    String[] weeks ={"2","4","6"};
    JTextField paneltitle;
    JButton confirmbutton;
    JFrame forecastwindow;
    ChartPanel panel;

    public Linear_Regression(){}

    public void Linear_Regression(List<List<Integer>> test)  {
        //uses y' =bx + a where:
        int a = 0;//the intercept
        int b = 0;//the slope
        int xsquared = 0;//sum of each x value after it is squared
        int ysquared = 0;//sum of each y value after it is squared
        int xysum = 0;//sum of all xy pairs (when they are added together) value after it is squared
        int xsum = 0;//sum of all x values
        int ysum = 0;//sum of all y values
        int n = test.size();
        for (List<Integer> data : test) {
            int x = data.get(0);
            int y = data.get(1);
            xsquared += x * x;
            ysquared += y * y;
            xysum += x * y;
            ysum += y;
            xsum += x;
        }
        /*System.out.println("xsum; " +xsum);
        System.out.println("ysum; " +ysum);
        System.out.println("xsquared; " +xsquared);
        System.out.println("ysquared; " +ysquared);
        System.out.println("xysum; " +xysum);
        System.out.println("n; " +n);*/ //Testing reasons

        a = ((n*xysum)-(xsum*ysum))/((n*xsquared)-(xsum*xsum));
        b = ((xsquared*ysum)-(xsum-xysum))/((n*xsquared)-(xsum*xsum));
        /*System.out.println("a; " +a);
        System.out.println("b; " +b);*/

        for (int i = 0; i < days; i++) {//prediction is made, this is very simple and isnt very accurate
            System.out.println(test.size());
            int prediction = a + (b * (test.size() + i));
            System.out.println(test.size()+i + " " + prediction);
            List<Integer> input = Arrays.asList(test.size() + i,prediction);
            forcast_data.add(input);
        }
        Forecast_Chart forecastChart = new Forecast_Chart();
        panel =  new ChartPanel(forecastChart.forcastchart(copy,forcast_data));
        JButton save = new JButton("Save");//save button

        this.add(panel,BorderLayout.CENTER);
        this.add(save,BorderLayout.SOUTH);//display chart and save button
        save.addActionListener(new buttonhandler2(this,paneltitle,panel));
        setSize(640, 480);
        forecastwindow.setVisible(false);
        this.setVisible(true);

    }
    public void Setup (chartdata ds){
        //this allows the user to set up how long they want the forcast for


        forecastwindow = new JFrame("Forecast");
        forecastwindow.setSize(WIDTH, HEIGHT);
        forecastwindow.setResizable(false);
        forecastwindow.setLayout(new FlowLayout());
        JPanel linePanel = new JPanel(new GridLayout(B_ROW, B_COL, H_GAP, V_GAP));
        forecastwindow.add(linePanel);
        Border linePanelBorder = BorderFactory.createTitledBorder("Line Chart");
        linePanel.setBorder(linePanelBorder);
        JLabel label = new JLabel("Select the number of weeks");
        linePanel.add(label);
        dropdown = new JComboBox(weeks);
        dropdown.setMaximumRowCount(3);
        linePanel.add(dropdown);
        paneltitle = new JTextField("Forcast Chart");
        linePanel.add(paneltitle);
        confirmbutton = new JButton("Confirm");
        confirmbutton.addActionListener(new buttonhandler(this,dropdown,ds));
        linePanel.add(confirmbutton);
        forecastwindow.setVisible(true);
    }

    public List<List<Integer>> datacon(chartdata ds,int option) {
        //takes only the data needed and converts to integer
        if(option == 0){
            days = 14;

        }
        else if(option == 1){
            days = 28;
        }
        else{
            days = 56;
        }
        List<List<String>> data = new ArrayList<>();
        for(Object[] a: ds.GetData()){
            String[] stringArray = Arrays.stream(a)
                    .toArray(String[]::new);
            data.add(Arrays.asList(stringArray));
        }

        List<List<Integer>> Stuff = new ArrayList<>();
        Collections.reverse(data);// reverses array list at the most reacent date is at the top
        int counter = data.size() - 1;
        int index = 0;
        while (counter > 0) {
            List<String> t = data.get(index);
            int number = Integer.parseInt(t.get(4));
            if (counter > days) {
                Stuff.add(Arrays.asList((index + 1), number));
            } else {
                copy.add(Arrays.asList((index + 1), number));
            }
            index++;
            counter--;
        }
        System.out.println(Stuff);
        return Stuff;
    }

}
class buttonhandler implements ActionListener{
    private Linear_Regression mainpanel;
    chartdata ds;
    JComboBox options;
    int option = 1;
    public buttonhandler(Linear_Regression mainpanel, JComboBox options,chartdata data){
        this.mainpanel = mainpanel;
        this.options = options;
        this.ds = data;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (options.getSelectedItem() == "2"){
            option = 0;

        }else if (options.getSelectedItem() == "4"){
            option = 1;

        }else{
            option = 2;

        }
        mainpanel.Linear_Regression(mainpanel.datacon(ds,option));
    }
}
class buttonhandler2 implements ActionListener{
    private Linear_Regression mainpanel;
    JTextField paneltitle;
    ChartPanel panel;
    public buttonhandler2(Linear_Regression mainpanel, JTextField paneltitle,ChartPanel panel){
        this.mainpanel = mainpanel;
        this.paneltitle = paneltitle;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String filename = paneltitle.getText();

        //taken from graphsaver by saurav
        if (filename.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No filename");
        }else{
            try {
                BufferedImage bi = new BufferedImage(700,500, BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                panel.paint(g);
                g.dispose();
                ImageIO.write(bi,"png",new File(filename + ".png"));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Save unsuccessful");
            }
            JOptionPane.showMessageDialog(null, "Save successful");
        }
    }
}


