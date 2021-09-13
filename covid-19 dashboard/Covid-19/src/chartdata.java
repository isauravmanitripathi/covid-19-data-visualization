import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class chartdata {


    public String GetAttributeName(int columnNo){

        if (columnNo < assignment_attributeCount) {
            return assignment_attributes[columnNo];
        } else {
             JPanel frame = new JPanel();
             JOptionPane.showMessageDialog(frame,
                 "Data Out Of Bound",
                 "Error",
                 JOptionPane.ERROR_MESSAGE);
         }
        return null;
    }
	

    public String[] GetAttributes() {
            
        return assignment_attributes;
    }
	

    public Object[] GetColumnData(int columnNo){

        if (columnNo < assignment_attributeCount) {
            assignment_columnData = new Object[assignment_entryCount];
            for(int i = 0; i<assignment_entryCount; i++){
                assignment_columnData[i] = assignment_data[i][columnNo];
            }
            return assignment_columnData;
        } else {
			JPanel frame = new JPanel();
			JOptionPane.showMessageDialog(frame,
                "Column Index out of bounds",
                "File error",
                JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
	

    public Object [][] GetData() {  
        return assignment_data;
    }
	

    public int GetNoOfAttributes(){
        return assignment_attributeCount;
    }
	

    public int GetNoOfEntrys(){
        return assignment_entryCount;
    
    }
	

    public Boolean BuildDataSet (File dataFile) {
        
		boolean test = false;
		
        if(!checkForValidFile(dataFile)){
            return false;
        }
        
        try {
            assignment_fileScan = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
        }
        
        assignment_attributes = new String[assignment_attributeCount];
        assignment_lineScanner = new Scanner(assignment_fileScan.nextLine());
        assignment_lineScanner.useDelimiter(assignment_delimiter);

        {
            int i=0;
            while (i<assignment_attributeCount) {
                assignment_attributes[i]=assignment_lineScanner.next();
                i++;
            }
        }
        
        assignment_data = new Object[assignment_entryCount][assignment_attributeCount];

        int i=0;
        while (i<assignment_entryCount) {
            assignment_lineScanner = new Scanner(assignment_fileScan.nextLine());
            assignment_lineScanner.useDelimiter(assignment_delimiter);

            int n=0;
            while (n<assignment_attributeCount) {
                if(!(assignment_lineScanner.hasNext())){
                    i--;
                    break;
                }

                assignment_dataEntry=assignment_lineScanner.next();
                switch (assignment_dataEntry) {
                    case "" -> n--;
                    default -> assignment_data[i][n] = assignment_dataEntry;
                }
                n++;
            }
            i++;
        }
        if (test) {
			System.out.println("Data Set Built");
		}
        return true;
    }
	

    private boolean checkForAttributes(File dataFile) {
		
        try {
            assignment_fileScan = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
			return false;
        }
        assignment_delimiter=",";
        assignment_lineScanner= new Scanner(assignment_fileScan.nextLine());
        assignment_lineScanner.useDelimiter(assignment_delimiter);
        
        while(assignment_lineScanner.hasNext()){
            try {  
                Double.parseDouble(assignment_lineScanner.next());
            } catch(NumberFormatException nfe) {  
                return true;  
            }
        }
        return false; 
    }
	

    private Boolean checkForCommas (File dataFile) {
        
        assignment_delimiter="";
        
        try {
            assignment_fileScan = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
			return false;
        }
        assignment_fileScan.useDelimiter(assignment_delimiter);

        if (!assignment_fileScan.hasNext()) {
            return false;
        }
        do {
            String assignment_charCheck = assignment_fileScan.next();
            if (!assignment_charCheck.equals(",")) {
            } else {
                return true;
            }
        } while (assignment_fileScan.hasNext());
        return false;
    }
	

    private boolean checkForConsistentData(File dataFile) {
		
        try {
            assignment_fileScan = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
        }
        
        assignment_entryCount=0;
        assignment_attributeCount=countAttributes(dataFile);
        assignment_delimiter=",";

        if (assignment_fileScan.hasNextLine()) {
            do {
                assignment_lineScanner = new Scanner(assignment_fileScan.nextLine());
                assignment_lineScanner.useDelimiter(assignment_delimiter);
                assignment_lineDataCount = 0;
                assignment_emptyEntryCount = 0;

                if (assignment_lineScanner.hasNext()) {
                    do {
                        assignment_dataEntry = assignment_lineScanner.next();
                        if (assignment_dataEntry.equals("")) {
                            assignment_emptyEntryCount++;
                        }
                        assignment_lineDataCount++;
                    } while (assignment_lineScanner.hasNext());
                }

                if (assignment_lineDataCount - assignment_emptyEntryCount == assignment_attributeCount) {
                } else {
                    if (!(assignment_lineDataCount - assignment_emptyEntryCount == 0)) {
                        return false;
                    } else {
                        assignment_entryCount--;
                    }
                }
                assignment_entryCount++;
            } while (assignment_fileScan.hasNextLine());
        }
        return true;
    }
	

    private Boolean checkForValidFile(File dataFile){
        
        final JPanel frame = new JPanel();
        if (checkForCommas(dataFile)) {
            if (!checkForAttributes(dataFile)) {
                JOptionPane.showMessageDialog(frame,
                        "File Corrupted",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!checkForConsistentData(dataFile)) {
                JOptionPane.showMessageDialog(frame,
                        "Missing Values In Some Cells",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,
                    "There are no Commas In File",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
	

    private int countAttributes(File dataFile) {

        assignment_numberOfAttributes = 0;
        assignment_delimiter=",";

        try {
            assignment_fileScan = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
        }
        assignment_lineScanner = new Scanner(assignment_fileScan.nextLine());
        assignment_lineScanner.useDelimiter(assignment_delimiter);
        while(assignment_lineScanner.hasNext()){
			assignment_lineScanner.next();
            assignment_numberOfAttributes++;
        }
        return assignment_numberOfAttributes;
    }
	   

    private Scanner assignment_fileScan;


    private String assignment_delimiter;


    private Scanner assignment_lineScanner;


    private int assignment_attributeCount;


    private int assignment_entryCount;


    private int assignment_lineDataCount;


    private String[] assignment_attributes;


    private Object[][] assignment_data;


    private String assignment_dataEntry;


    private int assignment_emptyEntryCount;


    private Object[] assignment_columnData;


    private int assignment_numberOfAttributes;

		 public static void main(String[] args) {
		//Test Class
		chartdata testDataSet = new chartdata();
		//Test One
		System.out.println("DataSet:: GetData()");
		Object[][] test1Object = testDataSet.GetData();
		System.out.println("DataSet:: GetData() - Test Passed");
		//Test Two
		System.out.println("DataSet:: GetAttirbutes()");
		String[] test2Attributes = testDataSet.GetAttributes();
		System.out.println("DataSet:: GetAttributes() - Test Passed");
        //Test Three
		System.out.println("DataSet:: GetColumnData(2) - No File");
		Object[] test3Object = testDataSet.GetColumnData(2);
		//Getting random information from a testDataSet
		//No file has been given, so no data should exist.
		//Expecting null.
		if (test3Object == null) {
			System.out.println("DataSet:: GetColumnData(2) - Test Passed");
		} else {
			System.out.println("DataSet:: GetColumnData(2) - Unexpected Error");
			System.out.println(test3Object);
		}
		//Test Four
		System.out.println("DataSet:: GetAttributeName(2)");
		String test4AttributeName = testDataSet.GetAttributeName(2);
		//Getting random information from a testDataSet
		//No File - Expecting null
		if (test4AttributeName == null) {
			System.out.println("DataSet:: GetAttributeName(2) - Test Passed");
		} else {
			System.out.println("DataSet:: GetAttributeName(2) - Test Failed");
			System.out.println(test4AttributeName);
		}
		//Test Five
		System.out.println("DataSet:: GetNoOfEntrys()");
		int test5entries = testDataSet.GetNoOfEntrys();
		System.out.println("DataSet:: GetNoOfEntrys() - Test Passed");
		//Test Six
		System.out.println("DataSet:: GetNoOfAttributes()");
		int test6entries = testDataSet.GetNoOfAttributes();
		System.out.println("DataSet:: GetNoOfAttributes() - Test Passed");

		System.out.println("DataSet:: BuildDataSet(Typical File)");
		File inputfile = new File("test.csv");

		//Test Seven
		boolean test7 = testDataSet.BuildDataSet(inputfile);
		if (test7) {
			System.out.println("DataSet:: BuildDataSet - Test Passed");
		} else {
			System.out.println("DataSet:: BuildDataSet - Unexpected Error");
		}
		//Test Eight
		System.out.println("DataSet:: GetNoOfEntrys()");
		int test8entries = testDataSet.GetNoOfEntrys();
		final int ENTRIES = 11;
		if (test8entries == ENTRIES) {
			System.out.println("DataSet:: GetNoOfEntrys() - Test Passed");
		} else {
			System.out.println("DataSet:: GetNoOfEntrys() - Test Failed");
			System.out.println(test8entries);
		}
		//Test Nine
		System.out.println("DataSet:: GetNoOfAttributes()");
		int test9entries = testDataSet.GetNoOfAttributes();
		final int ATTRIBUTES = 2;
		if (test9entries == ATTRIBUTES) {
			System.out.println("DataSet:: GetNoOfAttributes() - Test Passed");
		} else {
			System.out.println("DataSet:: GetNoOfAttributes() - Test Failed");
			System.out.println(test9entries);
		}
	}
}