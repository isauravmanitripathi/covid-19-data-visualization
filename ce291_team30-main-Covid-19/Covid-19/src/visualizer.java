import java.io.File;


public class visualizer {
	

    public int firstattribute() {
        return assignment_attribute1;
    }
	

    public int secondattribute() {
        return assignment_attribute2;
    }
	

    public chartdata getDataset() {
        return assignment_dataset;
    }
	

    public String getHeader() {
        return assignment_header;
    }
	

    public String dataforxaxis() {
        return assignment_xAxis;
    }
	

    public String dataforyaxis() {
        return assignment_yAxis;
    }
	

    public boolean setAttribute1 (int attribute1) {
        assignment_attribute1 = attribute1;
        return true;
    }
	

    public boolean setAttribute2 (int attribute2) {
        assignment_attribute2 = attribute2;
        return true;
    }
	

	public boolean setDataset (chartdata dataset) {
        assignment_dataset = dataset;
        return true;
    }
	

    public boolean setHeader (String header) {
        assignment_header = header;
        return true;
    }
	

    public boolean setxAxis (String xAxis) {
        assignment_xAxis = xAxis;
        return true;
    }
	

    public boolean setyAxis (String yAxis) {
        assignment_yAxis = yAxis;
        return true;
    }
	
	private chartdata assignment_dataset;
    private int assignment_attribute1;
    private int assignment_attribute2;
    private String assignment_header;
    private String assignment_xAxis;
    private String assignment_yAxis;

	public static void main(String args[]){
		
		final int TEST_DATA = 100;
		

		System.out.println("Visualization:: Visualization()");
		visualizer testVisualization=new visualizer();
		System.out.println("Visualization:: Visualization() - Test Passed");
		

		chartdata testdataset = new chartdata();
		File inputfile = new File("test.csv");
		testdataset.BuildDataSet(inputfile);
		

		System.out.println("Visualization:: setDataset()");
		testVisualization.setDataset(testdataset);
		System.out.println("Visualization:: setDataset() - Test Passed");
		

		System.out.println("Visualization:: setAttribute1()");
		boolean testSetAttribute1=testVisualization.setAttribute1(TEST_DATA);
		System.out.println("Visualization:: setAttribute1() - Test Passed");
		

		System.out.println("Visualization:: setAttribute2()");
		boolean testSetAttribute2=testVisualization.setAttribute2(TEST_DATA);
		System.out.println("Visualization:: setAttribute2() - Test Passed");
		

		System.out.println("Visualization:: setHeader()");
		boolean testSetHeader=testVisualization.setHeader("Visulization");
		System.out.println("Visualization:: setHeader() - Test Passed");
		

		System.out.println("Visualization:: setxAxis()");
		boolean testSetxAxis=testVisualization.setxAxis("xAxis");
		System.out.println("Visualization:: setxAxis() - Test Passed");
		

		System.out.println("Visualization:: setyAxis()");
		boolean testSetyAxis=testVisualization.setyAxis("yAxis");
		System.out.println("Visualization:: setyAxis() - Test Passed");
		

		System.out.println("Visualization:: getDataset()");
		testVisualization.getDataset();
		System.out.println("Visualization:: getDataset() - Test Passed");
		

		System.out.println("Visualization:: firstattribute()");
		int testfirstattribute=testVisualization.firstattribute();
		System.out.println("Visualization:: firstattribute() - Test Passed");
		

		System.out.println("Visualization:: secondattribute()");
		int testsecondattribute=testVisualization.secondattribute();
		System.out.println("Visualization:: secondattribute() - Test Passed");
		

		System.out.println("Visualization:: getHeader()");
		String testGetHeader=testVisualization.getHeader();
		System.out.println("Visualization:: getHeader() - Test Passed");
		

		System.out.println("Visualization:: dataforxaxis()");
		String dataforxaxis=testVisualization.dataforxaxis();
		System.out.println("Visualization:: dataforxaxis - Test Passed");
		

		System.out.println("Visualization:: dataforyaxis()");
		String testdataforyaxis=testVisualization.dataforyaxis();
		System.out.println("Visualization:: dataforyaxis() - Test Passed");
	}
	
} /* End of Visualization Class */