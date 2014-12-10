package zesar;

import general.MyLayOut;
import general.WordObj;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;





public class Window extends MyLayOut {
	private static final long serialVersionUID = 1L;
	final static JPanel totalPanel=new JPanel();
	int xy[];
	JTable outTable;
	public Window() {
		super("Шифрование Цезаря");
		connectMenu(new Help());
		final Map<Integer, ArrayList<WordObj>> w=new TreeMap<Integer, ArrayList<WordObj>>();
		
		totalPanel.setLayout(null);
		
		
		
		final JPanel Panel[] = new JPanel[3];
		
		Panel[0]=new JPanel();
		Panel[0].setLayout(new GridLayout());
		Panel[0].setOpaque(true);
		Panel[0].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Текст для обработки"));
		Panel[0].setSize(setFullDisplay(100));
		Panel[0].setLocation(5, 5);
		final JTextArea inText=new JTextArea();
		inText.setWrapStyleWord(true);
		inText.setLineWrap(true);
		JScrollPane inTextScrol=new JScrollPane(inText);
		Panel[0].add(inTextScrol);
		
		JButton goButton=new JButton("Выполнить");
		goButton.setSize(new Dimension(100, 20));
		goButton.setLocation(location(Panel[0], 10));
		
		final JCheckBox chb[]=new JCheckBox[2];
		chb[0]=new JCheckBox("Ё");
		chb[0].setLocation(location(Panel[0], 110));
		chb[0].setSize(35, 20);
		chb[1]=new JCheckBox("Й");
		chb[1].setLocation(location(Panel[0], 150));
		chb[1].setSize(35, 20);

		
		Panel[1]=new JPanel();
		Panel[1].setLayout(new GridLayout());
		Panel[1].setOpaque(true);
		Panel[1].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Таблица с обработанными результатами"));
		Panel[1].setSize(setFullDisplay(200));
		Panel[1].setLocation(location(goButton,-10));
		
		outTable=new JTable();
		outTable.setSelectionBackground(Color.orange);
		outTable.setColumnSelectionAllowed(true);
		outTable.setRowSelectionAllowed(true);
//		outTable.setCellSelectionEnabled(true);
		outTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
//		outTable.setPreferredScrollableViewportSize(new Dimension(400, 198));
		JScrollPane tableScrl=new JScrollPane(outTable);
		Panel[1].add(tableScrl);

//		Panel[2]=new JPanel();
//		Panel[2].setOpaque(true);
//		Panel[2].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Готовый текст"));
//		Panel[2].setSize(setFullDisplay(200));
//		Panel[2].setLocation(location(Panel[1]));
		
//		System.out.println(Panel[0].getLocation.x);
//		System.out.println(Panel[1].getLocation());
		totalPanel.add(Panel[0]);
		totalPanel.add(goButton);
		totalPanel.add(chb[0]);
		totalPanel.add(chb[1]);
//		totalPanel.add(test);
		totalPanel.add(Panel[1]);
//		totalPanel.add(Panel[2]);
		
		
//		System.out.println(totalPanel.getComponent(totalPanel.getComponentCount()-1).getLocation().y+totalPanel.getComponent(totalPanel.getComponentCount()-1).getHeight());
		totalPanel.setPreferredSize(new Dimension(getWidth()-35,totalPanel.getComponent(totalPanel.getComponentCount()-1).getLocation().y+totalPanel.getComponent(totalPanel.getComponentCount()-1).getHeight()));
//		System.out.println(totalPanel.getPreferredSize());
		JScrollPane scrl=new JScrollPane(totalPanel);
		add(scrl);
		
		addComponentListener(new ComponentListener() {

			
			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				Component[] collection=totalPanel.getComponents();
				for (int i=0;i<collection.length;i++) {
					if(collection[i].getClass().getSimpleName().equalsIgnoreCase("JPanel")){
//						System.out.println("SimpleName = "+collection[i].getClass().getSimpleName().length());
					collection[i].setSize(setFullDisplay(collection[i].getHeight()));
					}
				}
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		goButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int v=-1;
				if(chb[0].isSelected()){
					//если алфавит с Ё без Й
					v=0;
					if(chb[1].isSelected()){
						//если алфавит с Ё и Й
						v=2;
					}
				}else {
					v=1;
					if(chb[1].isSelected()){
						//если алфавит с Й без Ё
						v=3;
					}
				}



				TableModel model2 = new MyTableModel(w);
				((MyTableModel) model2).setAlphabit(v);
				outTable.setModel(model2);
				
//				System.out.println(v);
				if(v!=-1){
				Decoder d=new Decoder(inText.getText(), v);
				w.clear();
				w.putAll(d.getDecodeWord());
				outTable.updateUI();
				xy=new int[outTable.getRowCount()];
				
				}else{
					JOptionPane.showMessageDialog(getGlassPane(), "ERROR");
					dispose();
				}
			}
		});
		final Point pp=new Point();
		ListSelectionListener ls=new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (e.getValueIsAdjusting()) {
                    return ;
                }
                int row = outTable.getSelectionModel().getLeadSelectionIndex();
                int col = outTable.getColumnModel().getSelectionModel().getLeadSelectionIndex();
                if (p.x != row || p.y != col) {
                    p.move(row, col);
//                    System.out.println(row + " " + col);
                    pp.setLocation(p);
//                    DefaultTableCellRenderer tcr = (DefaultTableCellRenderer) outTable.getCellRenderer(row, col);
//tcr.setBackground(Color.blue);
            		outTable.setSelectionForeground(Color.black);
                    
                }
            }
          
            private Point p = new Point(-1, -1);
		};
        outTable.getColumnModel().getSelectionModel().addListSelectionListener(ls);
        outTable.getSelectionModel().addListSelectionListener(ls);
        

        
//		System.out.println(getWidth());
	}
	
}
