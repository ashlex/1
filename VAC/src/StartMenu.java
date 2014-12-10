import general.MyLayOut;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends MyLayOut {
	private static final long serialVersionUID = 1L;
	private eHandler handler=new eHandler();
	JButton zesar,elgamal;
	JButton rsa;
	/**
	 * @param name - ��������� ����
	 */
	public StartMenu(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		zesar = new JButton("���������� ������");
		rsa = new JButton("������������� RSA");
		elgamal = new JButton("������������� ��� ������");
		zesar.addActionListener(handler);
		rsa.addActionListener(handler);
		elgamal.addActionListener(handler);

		Logger.getLogger("test").info("���������� �� ������1 ������ zesar");
		p1.add(zesar);
		Logger.getLogger("test").fine("���������� �� ������1 ������ rsa");
		p1.add(rsa);
		Logger.getLogger("test").fine("���������� �� ������1 ������ rsa");
		p1.add(elgamal);
		Logger.getLogger("test").fine("���������� �� ������2 ������� ������");
		p2.add(new JLabel("v_1.3"));
		Logger.getLogger("test").fine("���������� ������1 � ���������� � �� ������");
		add(p1, BorderLayout.CENTER);
		Logger.getLogger("test").fine("���������� ������2 � ���������� � �����");
		add(p2,BorderLayout.SOUTH);
	}

	public class eHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
			if(e.getSource()==rsa){
				Logger.getLogger("test").fine("����� ���� rsa");
				new rsa.Window();
			}
			
			if(e.getSource()==zesar){
				Logger.getLogger("test").fine("����� ���� zesar");
				new zesar.Window();
			}
			
			if(e.getSource()==elgamal){
				Logger.getLogger("test").fine("����� ���� elgamal");
				new ElGamal.Window();
			}
			}catch(Exception ex){
				Logger.getLogger("test").severe(ex.toString());
			}

		}
	}

}
