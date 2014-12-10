package general;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MyLayOut extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public MyLayOut(String name) {
		super(name);
		setPreferredSize(new Dimension(400,500));
		setMinimumSize(new Dimension(400, 400));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * @param height высота блока
	 * @return Возращает высоту и ширину объекта 
	 */
	public Dimension setFullDisplay(int height) {
		return new Dimension(getWidth()-50, height);
	}
	
	public Point location(JComponent c, int detX, int detY) {
		int x=0,y=0;
		x=c.getLocation().x+detX;
		y=c.getLocation().y+c.getHeight()+detY;
		return new Point(x, y) ;
	}
	public Point location(JComponent c) {
		return location(c, 0, 5);
	}
	public Point location(JComponent c, int detX) {
		return location(c, detX, 5);
	}
	/** Подключает верхнее меню для главного окна
	 * 
	 * @param h объект типа HelpMenu служит для загрузки информации на всплывающие окна
	 */
	public void connectMenu(HelpMenu h){
		final JLabel helpText=new JLabel(h.getHelp());
		JScrollPane inTextScrol = new JScrollPane(helpText);
		
		final JPanel coderTextIn = new JPanel();
		coderTextIn.setLayout(new BorderLayout());
		coderTextIn.add(inTextScrol);

		final JLabel aboutText=new JLabel(h.getAbout());
		JScrollPane inTextScrol2 = new JScrollPane(aboutText);
		final JPanel coderTextIn2 = new JPanel();
		coderTextIn2.setLayout(new FlowLayout());
		inTextScrol2.setBorder(null);
		coderTextIn2.add(inTextScrol2);
		
		JMenuBar header=new JMenuBar();
		setJMenuBar(header);
		JMenu helpMenu=new JMenu("Help");
		JMenuItem aboutVAC=new JMenuItem("About "+getTitle());
		JMenuItem help=new JMenuItem("Help");
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame jf=new JFrame();
				jf.setPreferredSize(new Dimension(400,300));
				jf.setMinimumSize(new Dimension(600, 300));
				jf.setLocationRelativeTo(null);
				jf.setResizable(true);
				jf.setVisible(true);
				jf.add(coderTextIn);
			}
		});
		aboutVAC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame jf=new JFrame();
				jf.setPreferredSize(new Dimension(400,300));
				jf.setMinimumSize(new Dimension(600, 300));
				jf.setLocationRelativeTo(null);
				jf.setResizable(false);
				jf.setVisible(true);
				jf.add(coderTextIn2);
			}
		});
		helpMenu.add(help);
		helpMenu.add(aboutVAC);
		header.add(helpMenu);
	}
	
}
