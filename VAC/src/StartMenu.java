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
	 * @param name - Заголовок окна
	 */
	public StartMenu(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		zesar = new JButton("Шифрование Цезаря");
		rsa = new JButton("Криптосистема RSA");
		elgamal = new JButton("Криптосистема Эль Гамаля");
		zesar.addActionListener(handler);
		rsa.addActionListener(handler);
		elgamal.addActionListener(handler);

		Logger.getLogger("test").info("Добавление на панель1 кнопки zesar");
		p1.add(zesar);
		Logger.getLogger("test").fine("Добавление на панель1 кнопки rsa");
		p1.add(rsa);
		Logger.getLogger("test").fine("Добавление на панель1 кнопки rsa");
		p1.add(elgamal);
		Logger.getLogger("test").fine("Добавление на панель2 надписи версии");
		p2.add(new JLabel("v_1.3"));
		Logger.getLogger("test").fine("Добавление панели1 и размещение её по центру");
		add(p1, BorderLayout.CENTER);
		Logger.getLogger("test").fine("Добавление панели2 и размещение её внизу");
		add(p2,BorderLayout.SOUTH);
	}

	public class eHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
			if(e.getSource()==rsa){
				Logger.getLogger("test").fine("Вызов окна rsa");
				new rsa.Window();
			}
			
			if(e.getSource()==zesar){
				Logger.getLogger("test").fine("Вызов окна zesar");
				new zesar.Window();
			}
			
			if(e.getSource()==elgamal){
				Logger.getLogger("test").fine("Вызов окна elgamal");
				new ElGamal.Window();
			}
			}catch(Exception ex){
				Logger.getLogger("test").severe(ex.toString());
			}

		}
	}

}
