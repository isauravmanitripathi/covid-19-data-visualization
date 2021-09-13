import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class choosecolour extends JFrame {
	

    public choosecolour() {
        integermaps();
        InitGUI();
		this.setLocationRelativeTo(null);
        setSize(new Dimension(Cassingmnet_WIDTH, Cassingmnet_HEIGHT));
        setTitle("Colour Options");
    }
	 

    public void CloseFrame() {
        setVisible(false);
    }
	

    public newcolours GetActiveMap() {
        if (assingmnet_activeMap == CUSTOM) {
			return assingmnet_custom;
		} else {
			return(assingmnet_colourMaps[assingmnet_activeMap]);
		}
    }
	

    public barcoloured GetBarRenderer() {
        return(menubar123Renderer);
    }




	

    public newcolours colourmap(int mapIndex) {
        return(assingmnet_colourMaps[mapIndex]);
    }
	




	public linecoloured GetLineRenderer() {
		return(assingmnet_lineRenderer);
	}
	

	public ringcoloured GetRingRenderer() {
		return(assingmnet_ringRenderer);
	}
	




	

	

    public JPanel DrawSwatches(int mapIndex) {
        
        JPanel swatchPanel = new JPanel();
        Border swatchPanelBorder = BorderFactory.createTitledBorder("Preview");
        swatchPanel.setBorder(swatchPanelBorder);

        Dimension swatchSize = new Dimension(S_WIDTH, S_HEIGHT);
        int borderWidth = 1;
        Color borderColour = Color.black;

        Border swatchOutline = BorderFactory.createMatteBorder(
			borderWidth,
			borderWidth,
			borderWidth,
			borderWidth,
			borderColour );
		
		Color colour;
		
		if (mapIndex == CUSTOM) {
			
			for (int colourIndex=0; colourIndex<MAPCOUNT; colourIndex++) {
                if (colourIndex == 0 || colourIndex == 2) {
                    JPanel colour1 = new JPanel();
                    colour1.setSize(swatchSize);
                    colour1.setBorder(swatchOutline);
                    colour = assingmnet_custom.choosecolour(colourIndex)
                            .choosecolour();
                    colour1.setBackground(colour);
                    swatchPanel.add(colour1);
                } else if (colourIndex == 1) {
                    JPanel colour2 = new JPanel();
                    colour2.setSize(swatchSize);
                    colour2.setBorder(swatchOutline);
                    colour = assingmnet_custom.choosecolour(colourIndex)
                            .choosecolour();
                    colour2.setBackground(colour);
                    swatchPanel.add(colour2);
                } else if (colourIndex == 3) {
                    JPanel colour4 = new JPanel();
                    colour4.setSize(swatchSize);
                    colour4.setBorder(swatchOutline);
                    colour = assingmnet_custom.choosecolour(colourIndex)
                            .choosecolour();
                    colour4.setBackground(colour);
                    swatchPanel.add(colour4);
                } else if (colourIndex == 4) {
                    JPanel colour5 = new JPanel();
                    colour5.setSize(swatchSize);
                    colour5.setBorder(swatchOutline);
                    colour = assingmnet_custom.choosecolour(colourIndex)
                            .choosecolour();
                    colour5.setBackground(colour);
                    swatchPanel.add(colour5);
                }
			}
			
		} else {
			
			newcolours map = colourmap(mapIndex);
			
			for (int colourIndex=0; colourIndex<MAPCOUNT; colourIndex++) {
                if (colourIndex == 0) {
                    JPanel colour1 = new JPanel();
                    colour1.setSize(swatchSize);
                    colour1.setBorder(swatchOutline);
                    colour = map.choosecolour(colourIndex)
                            .choosecolour();
                    colour1.setBackground(colour);
                    swatchPanel.add(colour1);
                } else if (colourIndex == 1) {
                    JPanel colour2 = new JPanel();
                    colour2.setSize(swatchSize);
                    colour2.setBorder(swatchOutline);
                    colour = map.choosecolour(colourIndex)
                            .choosecolour();
                    colour2.setBackground(colour);
                    swatchPanel.add(colour2);
                } else if (colourIndex == 2) {
                    JPanel colour3 = new JPanel();
                    colour3.setSize(swatchSize);
                    colour3.setBorder(swatchOutline);
                    colour = map.choosecolour(colourIndex)
                            .choosecolour();
                    colour3.setBackground(colour);
                    swatchPanel.add(colour3);
                } else if (colourIndex == 3) {
                    JPanel colour4 = new JPanel();
                    colour4.setSize(swatchSize);
                    colour4.setBorder(swatchOutline);
                    colour = map.choosecolour(colourIndex)
                            .choosecolour();
                    colour4.setBackground(colour);
                    swatchPanel.add(colour4);
                } else if (colourIndex == 4) {
                    JPanel colour5 = new JPanel();
                    colour5.setSize(swatchSize);
                    colour5.setBorder(swatchOutline);
                    colour = map.choosecolour(colourIndex)
                            .choosecolour();
                    colour5.setBackground(colour);
                    swatchPanel.add(colour5);
                }
			}
		
		}
        return(swatchPanel);
    }	


    public void InitGUI() {
        
        cmActionListener listener = new cmActionListener();

        Container assingmnet_container = getContentPane();
        assingmnet_container.setLayout(new FlowLayout());
        
        JPanel optionsPanel = new JPanel(new GridLayout(UI_ROW,UI_COL));
        assingmnet_container.add(optionsPanel);

        JLabel dropboxText = new JLabel("Select colour scheme: ");
        optionsPanel.add(dropboxText);

        String[] colourMaps = new String[MAPCOUNT];
        for (int i=0; i<MAPCOUNT; i++) {
            colourMaps[i] = colourmap(i).colourmapName();
        }
		
        assingmnet_mapList = new JComboBox(colourMaps);
		assingmnet_mapList.setEnabled(true);
        assingmnet_mapList.setPreferredSize(new Dimension(UI_WIDTH, UI_HEIGHT));
        assingmnet_mapList.addActionListener(listener);
        optionsPanel.add(assingmnet_mapList);

        JLabel blankLabel1 = new JLabel("");
        optionsPanel.add(blankLabel1);

        assingmnet_previewContainer = new JPanel();
        optionsPanel.add(assingmnet_previewContainer);

        assingmnet_previewPanel = DrawSwatches(assingmnet_mapList.getSelectedIndex());
        assingmnet_previewContainer.add(assingmnet_previewPanel);

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setSize(new Dimension(CP_WIDTH, CP_HEIGHT));
        optionsPanel.add(spacerPanel1);

		
		
        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setSize(new Dimension(CP_WIDTH, CP_HEIGHT));
        optionsPanel.add(spacerPanel2);
		
		assingmnet_CustomButton = new JButton("Custom Colours");
		assingmnet_CustomButton.addActionListener(listener);
		spacerPanel2.add(assingmnet_CustomButton);
		
        JLabel blankLabel2 = new JLabel("");
        optionsPanel.add(blankLabel2);

		
		
        JPanel buttonPanel = new JPanel(new FlowLayout());
        optionsPanel.add(buttonPanel);
				
        assingmnet_saveButton = new JButton("OK");
        assingmnet_saveButton.addActionListener(listener);
        buttonPanel.add(assingmnet_saveButton);

        assingmnet_closeButton = new JButton("Cancel");
        assingmnet_closeButton.addActionListener(listener);
        buttonPanel.add(assingmnet_closeButton);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        if (assignemnt_chartmakerFirstTimeOpen) {
            setVisible(false);
            assignemnt_chartmakerFirstTimeOpen = false;
        } else {
            setVisible(true);
        }
    }


    public void integermaps() {
        colourmaker[] colours = new colourmaker[MAPCOUNT];

        if (0 == 0) {
            colourmaker black = new colourmaker("#000000");
            colours[0] = black;
        } else if (0 == 1) {
            colourmaker darkgrey = new colourmaker("#222222");
            colours[0] = darkgrey;
        } else if (0 == 2) {
            colourmaker grey = new colourmaker("#555555");
            colours[0] = grey;
        } else if (0 == 3) {
            colourmaker lightgrey = new colourmaker("#BBBBBB");
            colours[0] = lightgrey;
        } else if (0 == 4) {
            colourmaker white = new colourmaker("#EEEEEE");
            colours[0] = white;
        }
        if (1 == 0) {
            colourmaker black = new colourmaker("#000000");
            colours[1] = black;
        } else if (1 == 1) {
            colourmaker darkgrey = new colourmaker("#222222");
            colours[1] = darkgrey;
        } else if (1 == 2) {
            colourmaker grey = new colourmaker("#555555");
            colours[1] = grey;
        } else if (1 == 3) {
            colourmaker lightgrey = new colourmaker("#BBBBBB");
            colours[1] = lightgrey;
        } else if (1 == 4) {
            colourmaker white = new colourmaker("#EEEEEE");
            colours[1] = white;
        }
        if (2 == 0) {
            colourmaker black = new colourmaker("#000000");
            colours[2] = black;
        } else if (2 == 1) {
            colourmaker darkgrey = new colourmaker("#222222");
            colours[2] = darkgrey;
        } else if (2 == 2) {
            colourmaker grey = new colourmaker("#555555");
            colours[2] = grey;
        } else if (2 == 3) {
            colourmaker lightgrey = new colourmaker("#BBBBBB");
            colours[2] = lightgrey;
        } else if (2 == 4) {
            colourmaker white = new colourmaker("#EEEEEE");
            colours[2] = white;
        }
        if (3 == 0) {
            colourmaker black = new colourmaker("#000000");
            colours[3] = black;
        } else if (3 == 1) {
            colourmaker darkgrey = new colourmaker("#222222");
            colours[3] = darkgrey;
        } else if (3 == 2) {
            colourmaker grey = new colourmaker("#555555");
            colours[3] = grey;
        } else if (3 == 3) {
            colourmaker lightgrey = new colourmaker("#BBBBBB");
            colours[3] = lightgrey;
        } else if (3 == 4) {
            colourmaker white = new colourmaker("#EEEEEE");
            colours[3] = white;
        }
        if (4 == 0) {
            colourmaker black = new colourmaker("#000000");
            colours[4] = black;
        } else if (4 == 1) {
            colourmaker darkgrey = new colourmaker("#222222");
            colours[4] = darkgrey;
        } else if (4 == 2) {
            colourmaker grey = new colourmaker("#555555");
            colours[4] = grey;
        } else if (4 == 3) {
            colourmaker lightgrey = new colourmaker("#BBBBBB");
            colours[4] = lightgrey;
        } else if (4 == 4) {
            colourmaker white = new colourmaker("#EEEEEE");
            colours[4] = white;
        }
        newcolours greyscale = new newcolours(colours, "Greyscale");
        SetMap(GREY, greyscale);


        switch (0) {
            case 0:
                colourmaker colour1 = new colourmaker("#FF0099");
                colours[0] = colour1;
                break;
            case 1:
                colourmaker colour2 = new colourmaker("#F3F315");
                colours[0] = colour2;
                break;
            case 2:
                colourmaker colour3 = new colourmaker("#83F52C");
                colours[0] = colour3;
                break;
            case 3:
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[0] = colour4;
                break;
            case 4:
                colourmaker colour5 = new colourmaker("#6E0DD0");
                colours[0] = colour5;
                break;
        }
        switch (1) {
            case 0:
                colourmaker colour1 = new colourmaker("#FF0099");
                colours[1] = colour1;
                break;
            case 1:
                colourmaker colour2 = new colourmaker("#F3F315");
                colours[1] = colour2;
                break;
            case 2:
                colourmaker colour3 = new colourmaker("#83F52C");
                colours[1] = colour3;
                break;
            case 3:
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[1] = colour4;
                break;
            case 4:
                colourmaker colour5 = new colourmaker("#6E0DD0");
                colours[1] = colour5;
                break;
        }
        switch (2) {
            case 0:
                colourmaker colour1 = new colourmaker("#FF0099");
                colours[2] = colour1;
                break;
            case 1:
                colourmaker colour2 = new colourmaker("#F3F315");
                colours[2] = colour2;
                break;
            case 2:
                colourmaker colour3 = new colourmaker("#83F52C");
                colours[2] = colour3;
                break;
            case 3:
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[2] = colour4;
                break;
            case 4:
                colourmaker colour5 = new colourmaker("#6E0DD0");
                colours[2] = colour5;
                break;
        }
        switch (3) {
            case 0:
                colourmaker colour1 = new colourmaker("#FF0099");
                colours[3] = colour1;
                break;
            case 1:
                colourmaker colour2 = new colourmaker("#F3F315");
                colours[3] = colour2;
                break;
            case 2:
                colourmaker colour3 = new colourmaker("#83F52C");
                colours[3] = colour3;
                break;
            case 3:
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[3] = colour4;
                break;
            case 4:
                colourmaker colour5 = new colourmaker("#6E0DD0");
                colours[3] = colour5;
                break;
        }
        switch (4) {
            case 0:
                colourmaker colour1 = new colourmaker("#FF0099");
                colours[4] = colour1;
                break;
            case 1:
                colourmaker colour2 = new colourmaker("#F3F315");
                colours[4] = colour2;
                break;
            case 2:
                colourmaker colour3 = new colourmaker("#83F52C");
                colours[4] = colour3;
                break;
            case 3:
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[4] = colour4;
                break;
            case 4:
                colourmaker colour5 = new colourmaker("#6E0DD0");
                colours[4] = colour5;
                break;
        }
        newcolours neon = new newcolours(colours, "Neon");
        SetMap(NEON, neon);
        

        for (int i=0; i<MAPCOUNT; i++) {
            if (i == 0) {
                colourmaker colour1 = new colourmaker("#FFFF00");
                colours[i] = colour1;
            } else if (i == 1) {
                colourmaker colour2 = new colourmaker("#FFCC00");
                colours[i] = colour2;
            } else if (i == 2) {
                colourmaker colour3 = new colourmaker("#FF9900");
                colours[i] = colour3;
            } else if (i == 3) {
                colourmaker colour4 = new colourmaker("#FF6600");
                colours[i] = colour4;
            } else if (i == 4) {
                colourmaker colour5 = new colourmaker("#FF3300");
                colours[i] = colour5;
            }
        }
        newcolours warm = new newcolours(colours, "Warm");
        SetMap(WARM, warm);


        if (0 == 0) {
            colourmaker colour1 = new colourmaker("#33FFFF");
            colours[0] = colour1;
        } else if (0 == 1) {
            colourmaker colour2 = new colourmaker("#3399FF");
            colours[0] = colour2;
        } else if (0 == 2) {
            colourmaker colour3 = new colourmaker("#3333FF");
            colours[0] = colour3;
        } else if (0 == 3) {
            colourmaker colour4 = new colourmaker("#9933FF");
            colours[0] = colour4;
        } else if (0 == 4) {
            colourmaker colour5 = new colourmaker("#5C00B8");
            colours[0] = colour5;
        }
        if (1 == 0) {
            colourmaker colour1 = new colourmaker("#33FFFF");
            colours[1] = colour1;
        } else if (1 == 1) {
            colourmaker colour2 = new colourmaker("#3399FF");
            colours[1] = colour2;
        } else if (1 == 2) {
            colourmaker colour3 = new colourmaker("#3333FF");
            colours[1] = colour3;
        } else if (1 == 3) {
            colourmaker colour4 = new colourmaker("#9933FF");
            colours[1] = colour4;
        } else if (1 == 4) {
            colourmaker colour5 = new colourmaker("#5C00B8");
            colours[1] = colour5;
        }
        if (2 == 0) {
            colourmaker colour1 = new colourmaker("#33FFFF");
            colours[2] = colour1;
        } else if (2 == 1) {
            colourmaker colour2 = new colourmaker("#3399FF");
            colours[2] = colour2;
        } else if (2 == 2) {
            colourmaker colour3 = new colourmaker("#3333FF");
            colours[2] = colour3;
        } else if (2 == 3) {
            colourmaker colour4 = new colourmaker("#9933FF");
            colours[2] = colour4;
        } else if (2 == 4) {
            colourmaker colour5 = new colourmaker("#5C00B8");
            colours[2] = colour5;
        }
        if (3 == 0) {
            colourmaker colour1 = new colourmaker("#33FFFF");
            colours[3] = colour1;
        } else if (3 == 1) {
            colourmaker colour2 = new colourmaker("#3399FF");
            colours[3] = colour2;
        } else if (3 == 2) {
            colourmaker colour3 = new colourmaker("#3333FF");
            colours[3] = colour3;
        } else if (3 == 3) {
            colourmaker colour4 = new colourmaker("#9933FF");
            colours[3] = colour4;
        } else if (3 == 4) {
            colourmaker colour5 = new colourmaker("#5C00B8");
            colours[3] = colour5;
        }
        if (4 == 0) {
            colourmaker colour1 = new colourmaker("#33FFFF");
            colours[4] = colour1;
        } else if (4 == 1) {
            colourmaker colour2 = new colourmaker("#3399FF");
            colours[4] = colour2;
        } else if (4 == 2) {
            colourmaker colour3 = new colourmaker("#3333FF");
            colours[4] = colour3;
        } else if (4 == 3) {
            colourmaker colour4 = new colourmaker("#9933FF");
            colours[4] = colour4;
        } else if (4 == 4) {
            colourmaker colour5 = new colourmaker("#5C00B8");
            colours[4] = colour5;
        }
        newcolours cold = new newcolours(colours, "Cold");
        SetMap(COLD, cold);


        if (0 == 0) {
            colourmaker colour1 = new colourmaker("#00E000");
            colours[0] = colour1;
        } else if (0 == 1) {
            colourmaker colour2 = new colourmaker("#64D88B");
            colours[0] = colour2;
        } else if (0 == 2) {
            colourmaker colour3 = new colourmaker("#99CC66");
            colours[0] = colour3;
        } else if (0 == 3) {
            colourmaker colour4 = new colourmaker("#66FF99");
            colours[0] = colour4;
        } else if (0 == 4) {
            colourmaker colour5 = new colourmaker("#CAFF7A");
            colours[0] = colour5;
        }
        if (1 == 0) {
            colourmaker colour1 = new colourmaker("#00E000");
            colours[1] = colour1;
        } else if (1 == 1) {
            colourmaker colour2 = new colourmaker("#64D88B");
            colours[1] = colour2;
        } else if (1 == 2) {
            colourmaker colour3 = new colourmaker("#99CC66");
            colours[1] = colour3;
        } else if (1 == 3) {
            colourmaker colour4 = new colourmaker("#66FF99");
            colours[1] = colour4;
        } else if (1 == 4) {
            colourmaker colour5 = new colourmaker("#CAFF7A");
            colours[1] = colour5;
        }
        if (2 == 0) {
            colourmaker colour1 = new colourmaker("#00E000");
            colours[2] = colour1;
        } else if (2 == 1) {
            colourmaker colour2 = new colourmaker("#64D88B");
            colours[2] = colour2;
        } else if (2 == 2) {
            colourmaker colour3 = new colourmaker("#99CC66");
            colours[2] = colour3;
        } else if (2 == 3) {
            colourmaker colour4 = new colourmaker("#66FF99");
            colours[2] = colour4;
        } else if (2 == 4) {
            colourmaker colour5 = new colourmaker("#CAFF7A");
            colours[2] = colour5;
        }
        if (3 == 0) {
            colourmaker colour1 = new colourmaker("#00E000");
            colours[3] = colour1;
        } else if (3 == 1) {
            colourmaker colour2 = new colourmaker("#64D88B");
            colours[3] = colour2;
        } else if (3 == 2) {
            colourmaker colour3 = new colourmaker("#99CC66");
            colours[3] = colour3;
        } else if (3 == 3) {
            colourmaker colour4 = new colourmaker("#66FF99");
            colours[3] = colour4;
        } else if (3 == 4) {
            colourmaker colour5 = new colourmaker("#CAFF7A");
            colours[3] = colour5;
        }
        if (4 == 0) {
            colourmaker colour1 = new colourmaker("#00E000");
            colours[4] = colour1;
        } else if (4 == 1) {
            colourmaker colour2 = new colourmaker("#64D88B");
            colours[4] = colour2;
        } else if (4 == 2) {
            colourmaker colour3 = new colourmaker("#99CC66");
            colours[4] = colour3;
        } else if (4 == 3) {
            colourmaker colour4 = new colourmaker("#66FF99");
            colours[4] = colour4;
        } else if (4 == 4) {
            colourmaker colour5 = new colourmaker("#CAFF7A");
            colours[4] = colour5;
        }
        newcolours meadow = new newcolours(colours, "Meadow");
        SetMap(MEADOW, meadow);
		

        SetActiveMap(GREY);
        SetRenderers();
    }


    public void SaveAndClose() {
        
		if (assingmnet_mapList.isEnabled()) {
			SetActiveMap(assingmnet_mapList.getSelectedIndex());
		} else {
			SetActiveMap(CUSTOM);
		}
		
        GroupJVTApplication.dataVisualizer.RedrawChartColour();
        assingmnet_mapList.setEnabled(true);
		setVisible(false);
    }
	

    public boolean SetActiveMap(int mapIndex) {
        assingmnet_activeMap = mapIndex;
        SetRenderers();
        return(true);
    }
	

    public boolean SetMap(int mapIndex, newcolours map) {
        assingmnet_colourMaps[mapIndex] = map;
        SetRenderers();
        return(true);
    }
	

    public boolean SetRenderers() {
        menubar123Renderer = new barcoloured(GetActiveMap());
		assingmnet_lineRenderer = new linecoloured(GetActiveMap());
		assingmnet_areaRenderer = new areacoloured(GetActiveMap());
        return(true);
    } 


    private class cmActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /* When combo box changed, redraw preview panel. */
            if (e.getSource()==assingmnet_mapList) {
                
                assingmnet_previewContainer.removeAll();
                assingmnet_previewPanel = DrawSwatches(assingmnet_mapList.getSelectedIndex());
                assingmnet_previewContainer.add(assingmnet_previewPanel);
                assingmnet_previewPanel.repaint();
                assingmnet_previewPanel.revalidate();
            }
            
            if (e.getSource()==assingmnet_closeButton) {
                assingmnet_mapList.setEnabled(true);
				CloseFrame();
            }
        
            if (e.getSource()==assingmnet_saveButton) {
                GroupJVTApplication.dataVisualizer.SelectChartTab(); //line added
                SaveAndClose();
            }
			
			if (e.getSource() == assingmnet_CustomButton) {
			
				findcolour select = new findcolour();
				assingmnet_custom = select.InitMap();
				if (assingmnet_custom == null) {
					
				} else {
					assingmnet_mapList.setEnabled(false);
					assingmnet_previewContainer.removeAll();
					assingmnet_previewPanel = DrawSwatches(CUSTOM);
					assingmnet_previewContainer.add(assingmnet_previewPanel);
					assingmnet_previewPanel.repaint();
					assingmnet_previewPanel.revalidate();
				}
			
			}
        }
    }
            	

    private final int MAPCOUNT = 5;


    private newcolours[] assingmnet_colourMaps = new newcolours[MAPCOUNT];


    private int assingmnet_activeMap;
	

	private final int CUSTOM = MAPCOUNT + 1;
	

	private newcolours assingmnet_custom;


    private barcoloured menubar123Renderer;

	

	private linecoloured assingmnet_lineRenderer;
	

	private ringcoloured assingmnet_ringRenderer;




	private areacoloured assingmnet_areaRenderer;



    private JComboBox assingmnet_mapList;


    private JPanel assingmnet_previewPanel;


    private JPanel assingmnet_previewContainer;


    private JButton assingmnet_saveButton;


    private JButton assingmnet_closeButton;
	

	private JButton assingmnet_CustomButton;


    private Boolean assignemnt_chartmakerFirstTimeOpen = true;
    private final int GREY = 0;
	private final int NEON = 1;
	private final int WARM = 2;
	private final int COLD = 3;
	private final int MEADOW = 4;
    private int Cassingmnet_WIDTH = 350;
    private int Cassingmnet_HEIGHT = 250;
    private int UI_WIDTH = 150;
    private int UI_HEIGHT = 10;
    private int CP_WIDTH = 10;
    private int CP_HEIGHT = 400;
    private int S_WIDTH = 20;
    private int S_HEIGHT = 20;
    private int UI_ROW = 4;
    private int UI_COL = 2;
   
   

	public static void main(String[] args) {
		choosecolour test = new choosecolour();
		int grey = 0;
		int neon = 1;
		int warm = 2;
		int cold = 3;
		int meadow = 4;
		
		test.SetActiveMap(grey);
		System.out.println("ColourManager:: GetActiveMap()");
		if (test.GetActiveMap() == test.colourmap(grey)) {
			System.out.println("ColourManager:: GetActiveMap() - Test Passed");
		} else {
			System.out.println("ColourManager:: GetActiveMap() - Test Failed");
		}
		
		test.setVisible(true);
	}
   
}
