package ElGamal;

import general.MyLayOut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigInteger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rsa.Help;


public class Window extends MyLayOut {
	private static final long serialVersionUID = 1L;
	public Window() {
		super("ElGamal");

		connectMenu(new Help());
		
		Font font = new Font("Verdana", Font.PLAIN, 10);
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font);
		

		final JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());

		final JTextArea coderInText = new JTextArea();
		coderInText.setWrapStyleWord(true);
		coderInText.setLineWrap(true);
		JScrollPane inTextScrol = new JScrollPane(coderInText);
		JPanel coderTextIn = new JPanel();
		coderTextIn.setLayout(new GridLayout());
		coderTextIn.setSize(setFullDisplay(150));
		coderTextIn.setLocation(10, 10);
		coderTextIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Текст для обработки"));
		coderTextIn.add(inTextScrol);

		final JPanel coderBar = new JPanel();
		ButtonGroup coderGroup = new ButtonGroup();
		final JRadioButton var[] = {
				new JRadioButton("Автоматическая генерация ключей"),
				new JRadioButton("Указать p, x и g вручную") };
		coderBar.setLayout(null);
		coderBar.add(var[0]);
		var[0].setSize(240, 20);
		var[0].setLocation(10,20);
		var[0].setSelected(true);;
		var[0].setOpaque(true);
		
		coderGroup.add(var[0]);

		final JSlider slider=new JSlider(32,256,32);
		final JPanel sliderPane=new JPanel();
		sliderPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Bit"));
		sliderPane.setLayout(new BorderLayout());
		final JTextField valueSlider=new JTextField(slider.getValue()+"", 3);
		
		valueSlider.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				slider.setValue(Integer.parseInt(valueSlider.getText()));
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		JPanel te=new JPanel();
		te.add(valueSlider);
		sliderPane.add(te, BorderLayout.NORTH);
		sliderPane.setLocation(location(var[0], 10));
		sliderPane.setSize(300, 100);
		sliderPane.setVisible(true);
		sliderPane.add(slider, BorderLayout.CENTER);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				JSlider source= (JSlider) arg0.getSource();
				valueSlider.setText(source.getValue()+"");
			}
		});
		
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(32);
		slider.setMinorTickSpacing(8);
		slider.setPaintLabels(true);
		coderBar.add(sliderPane);
		

		coderBar.add(var[1]);
		var[1].setSize(170, 20);
		var[1].setLocation(location(sliderPane, -10));
		var[1].setOpaque(true);
		

		coderGroup.add(var[1]);
		
		final JPanel coderBar2 = new JPanel();
		coderBar2.setLayout(null);
		coderBar2.setLocation(location(var[1], 10));
		coderBar2.setSize(230, 80);
		coderBar2.setVisible(false);
		final JLabel fieldName[] = { new JLabel("p="), new JLabel("x="), new JLabel("g=") };
		final JTextField key[] = { new JTextField(), new JTextField(), new JTextField() };
		coderBar2.add(fieldName[0]);
		coderBar2.add(key[0]);
		coderBar2.add(fieldName[1]);
		coderBar2.add(key[1]);
		coderBar2.add(fieldName[2]);
		coderBar2.add(key[2]);
		
		fieldName[0].setSize(20, 20);
		fieldName[0].setLocation(0, 0);
		fieldName[0].setOpaque(true);
		key[0].setSize(200, 20);
		key[0].setLocation(20, 0);
		key[0].setOpaque(true);
		
		fieldName[1].setSize(20, 20);
		fieldName[1].setLocation(location(fieldName[0]));
		fieldName[1].setOpaque(true);
		key[1].setSize(200, 20);
		key[1].setLocation(location(fieldName[0],20));
		key[1].setOpaque(true);
		
		fieldName[2].setSize(20, 20);
		fieldName[2].setLocation(location(fieldName[1]));
		fieldName[2].setOpaque(true);
		key[2].setSize(200, 20);
		key[2].setLocation(location(fieldName[1],20));
		key[2].setOpaque(true);
		coderBar.add(coderBar2);

		coderBar.setSize(setFullDisplay(180));
		coderBar.setLocation(location(coderTextIn, 0, 10));
		coderBar.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLUE), "Опции"));

		final JButton coderSubmit = new JButton("Выполнить");
		coderSubmit.setSize(100, 20);
		coderSubmit.setLocation(location(coderBar, 0, 5));
		coderSubmit.setOpaque(true);


		final JTextArea outText = new JTextArea();
		outText.setWrapStyleWord(true);
		outText.setLineWrap(true);
		outText.setEditable(false);
		JScrollPane outTextScrol = new JScrollPane(outText);
		final JPanel coderTextOut = new JPanel();
		coderTextOut.setLayout(new GridLayout());
		coderTextOut.setSize(setFullDisplay(150));
		coderTextOut.setLocation(location(coderSubmit, 0));
		coderTextOut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Результат"));
		coderTextOut.add(outTextScrol);

		final JPanel coder = new JPanel();
		coder.setLayout(null);
		JScrollPane coderScrl = new JScrollPane(coder);
		JScrollBar jsp = coderScrl.getVerticalScrollBar();
		jsp.setUnitIncrement(5);
		
		coder.add(coderTextIn);
		coder.add(coderBar);
		coder.add(coderSubmit);
		coder.add(coderTextOut);

		var[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (var[0].isSelected()) {
					coderBar2.setVisible(false);
					sliderPane.setVisible(true);
					var[1].setLocation(location(sliderPane,-10));
					coderBar.setSize(setFullDisplay(180));
					coderSubmit.setLocation(location(coderBar, 0, 5));
					coderTextOut.setLocation(location(coderSubmit, 0, 5));
				}
			}
		});
		var[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (var[1].isSelected()) {
					coderBar2.setVisible(true);
					sliderPane.setVisible(false);
					var[1].setLocation(location(var[0]));
					coderBar2.setLocation(location(var[1], 10));
					coderBar.setSize(setFullDisplay(160));
					coderSubmit.setLocation(location(coderBar, 0, 5));
					coderTextOut.setLocation(location(coderSubmit, 0, 5));
				}
			}
		});


		coderSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Coder coder;
				if(var[1].isSelected()){
					coder=new Coder(new BigInteger(key[0].getText()),new BigInteger(key[2].getText()),new BigInteger(key[1].getText()));
				}else{
					coder=new Coder(slider.getValue());
				}
				outText.setText("p="+coder.getP()+" g="+coder.getG()+" x="+coder.getX()+" y="+coder.getY()+"\n"+coder.getCode(coderInText.getText()).toString());
				

			}
		});
		
		
		
		
		
		final JTextArea decoderInText = new JTextArea();
		decoderInText.setWrapStyleWord(true);
		decoderInText.setLineWrap(true);
		JScrollPane decoderInTextScrol = new JScrollPane(decoderInText);
		JPanel decoderTextIn = new JPanel();
		decoderTextIn.setLayout(new GridLayout());
		decoderTextIn.setSize(setFullDisplay(150));
		decoderTextIn.setLocation(10, 10);
		decoderTextIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Текст для обработки"));
		decoderTextIn.add(decoderInTextScrol);

		final JPanel decoderBar = new JPanel();
		final JPanel decoderBar2[] = { new JPanel(), new JPanel() };

		decoderBar.setLayout(null);
		decoderBar.add(decoderBar2[0]);
		decoderBar.add(decoderBar2[1]);



		decoderBar2[0].setLayout(null);
		decoderBar2[0].setLocation(10, 20);
		decoderBar2[0].setSize(200, 25);
		decoderBar2[0].setVisible(true);
		final JLabel decoderFieldName[] = { new JLabel("x="), new JLabel("p=") };
		final JTextField decoderKey[] = { new JTextField(), new JTextField() };
		decoderBar2[0].add(decoderFieldName[0]);
		decoderBar2[0].add(decoderKey[0]);
		decoderBar2[0].add(decoderFieldName[1]);
		decoderBar2[0].add(decoderKey[1]);
		decoderFieldName[0].setSize(20, 20);
		decoderFieldName[0].setLocation(0, 0);
		decoderFieldName[0].setOpaque(true);
		decoderKey[0].setSize(40, 20);
		decoderKey[0].setLocation(20, 0);
		decoderKey[0].setOpaque(true);
		decoderFieldName[1].setSize(20, 20);
		decoderFieldName[1].setLocation(80, 0);
		decoderFieldName[1].setOpaque(true);
		decoderKey[1].setSize(40, 20);
		decoderKey[1].setLocation(100, 0);
		decoderKey[1].setOpaque(true);


		decoderBar2[1].setLayout(null);
		decoderBar2[1].setLocation(20,20);
		decoderBar2[1].setSize(250, 25);
		decoderBar2[1].setVisible(true);

		decoderBar.setSize(setFullDisplay(105));
		decoderBar.setLocation(location(decoderTextIn, 0, 10));
		decoderBar.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLUE), "Опции"));

		final JButton decoderSubmit = new JButton("Выполнить");
		decoderSubmit.setSize(100, 20);
		decoderSubmit.setLocation(location(decoderBar, 0, 5));
		decoderSubmit.setOpaque(true);

		final JTextArea decoderOutText = new JTextArea();
		decoderOutText.setWrapStyleWord(true);
		decoderOutText.setLineWrap(true);
		JScrollPane decoderOutTextScrol = new JScrollPane(decoderOutText);
		final JPanel decoderTextOut = new JPanel();
		decoderTextOut.setLayout(new GridLayout());
		decoderTextOut.setSize(setFullDisplay(150));
		decoderTextOut.setLocation(location(decoderSubmit, 0));
		decoderTextOut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Результат"));
		decoderTextOut.add(decoderOutTextScrol);

		final JPanel decoder = new JPanel();
		decoder.setLayout(null);
		JScrollPane decoderScrl = new JScrollPane(decoder);

		decoder.add(decoderTextIn);
		decoder.add(decoderBar);
		decoder.add(decoderSubmit);
		decoder.add(decoderTextOut);

		decoderSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Decoder decoder=new Decoder(new BigInteger(decoderKey[0].getText()), new BigInteger(decoderKey[1].getText()));
				decoderOutText.setText(decoder.getDecode(decoderInText.getText()));
			}
		});

		tabbedPane.addTab("Шифрование", coderScrl);
		coder.setPreferredSize(new Dimension(getWidth() - 35, coder
				.getComponent(coder.getComponentCount() - 1).getLocation().y
				+ coder.getComponent(coder.getComponentCount() - 1).getHeight()));

		tabbedPane.addTab("Дешифрация", decoderScrl);
		decoder.setPreferredSize(new Dimension(getWidth() - 35, decoder
				.getComponent(decoder.getComponentCount() - 1).getLocation().y
				+ decoder.getComponent(decoder.getComponentCount() - 1)
						.getHeight()));

		totalPanel.add(tabbedPane, BorderLayout.CENTER);

		getContentPane().add(totalPanel);
		pack();

		addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				Component[] collection = coder.getComponents();
				for (int i = 0; i < collection.length; i++) {
					if (collection[i].getClass().getSimpleName()
							.equalsIgnoreCase("JPanel")) {
						// System.out.println("SimpleName = "+collection[i].getClass().getSimpleName().length());
						collection[i].setSize(setFullDisplay(collection[i]
								.getHeight()));
					}
				}
				collection = decoder.getComponents();
				for (int i = 0; i < collection.length; i++) {
					if (collection[i].getClass().getSimpleName()
							.equalsIgnoreCase("JPanel")) {
						// System.out.println("SimpleName = "+collection[i].getClass().getSimpleName().length());
						collection[i].setSize(setFullDisplay(collection[i]
								.getHeight()));
					}
				}
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}
