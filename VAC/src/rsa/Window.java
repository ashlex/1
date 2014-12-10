package rsa;

import general.MyLayOut;
import general.Vars;

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
import java.math.BigInteger;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends MyLayOut {
	private static final long serialVersionUID = 1L;
	static int i = 0;

	public Window() {
		super("RSA");
		Logger.getLogger("test").info("Подключение Menu");
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
		final JCheckBox chb[] = { new JCheckBox("Ё"), new JCheckBox("Й") };
		ButtonGroup coderGroup = new ButtonGroup();
		final JRadioButton var[] = {
				new JRadioButton("Автоматическая генерация ключей"),
				new JRadioButton("Указать p и q вручную") };
		coderBar.setLayout(null);
		coderBar.add(chb[0]);
		coderBar.add(chb[1]);
		coderBar.add(var[0]);
		coderBar.add(var[1]);
		chb[0].setSize(35, 20);
		chb[0].setLocation(10, 20);
		chb[0].setOpaque(true);
		chb[1].setSize(35, 20);
		chb[1].setLocation(location(chb[0], 40, -20));
		chb[1].setOpaque(true);
		var[0].setSize(240, 20);
		var[0].setLocation(location(chb[0]));
		var[0].setSelected(true);;
		var[0].setOpaque(true);
		var[1].setSize(170, 20);
		var[1].setLocation(location(var[0]));
		var[1].setOpaque(true);
		coderGroup.add(var[0]);
		coderGroup.add(var[1]);

		final JPanel coderBar2 = new JPanel();
		coderBar2.setLayout(null);
		coderBar2.setLocation(location(var[1], 10));
		coderBar2.setSize(200, 25);
		coderBar2.setVisible(false);
		final JLabel fieldName[] = { new JLabel("p="), new JLabel("q=") };
		final JTextField key[] = { new JTextField(), new JTextField() };
		coderBar2.add(fieldName[0]);
		coderBar2.add(key[0]);
		coderBar2.add(fieldName[1]);
		coderBar2.add(key[1]);
		fieldName[0].setSize(20, 20);
		fieldName[0].setLocation(0, 0);
		fieldName[0].setOpaque(true);
		key[0].setSize(40, 20);
		key[0].setLocation(20, 0);
		key[0].setOpaque(true);
		fieldName[1].setSize(20, 20);
		fieldName[1].setLocation(80, 0);
		fieldName[1].setOpaque(true);
		key[1].setSize(40, 20);
		key[1].setLocation(100, 0);
		key[1].setOpaque(true);
		coderBar.add(coderBar2);

		coderBar.setSize(setFullDisplay(105));
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
					coderBar.setSize(setFullDisplay(105));
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
					coderBar.setSize(setFullDisplay(130));
					coderSubmit.setLocation(location(coderBar, 0, 5));
					coderTextOut.setLocation(location(coderSubmit, 0, 5));
				}
			}
		});


		coderSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int v = -1;
				if (chb[0].isSelected()) {
					// если алфавит с Ё без Й
					v = 0;
					if (chb[1].isSelected()) {
						// если алфавит с Ё и Й
						v = 2;
					}
				} else {
					v = 1;
					if (chb[1].isSelected()) {
						// если алфавит с Й без Ё
						v = 3;
					}
				}
				if (v != -1) {
					Coder c = null;
					if (var[0].isSelected()) {
						Logger.getLogger("test").info(Vars.CREATE_OBJECT.getAbbreviation()+"Coder с автоматической генерацией ключей");
						c = new Coder(coderInText.getText(), v);
					} else if (var[1].isSelected()) {
						Logger.getLogger("test").info(Vars.CREATE_OBJECT.getAbbreviation()+"Coder с ручным вводом p и q");
						try{
						c = new Coder(coderInText.getText(), v, new BigInteger(
								key[0].getText()), new BigInteger(key[1]
								.getText()));
						}catch(Exception ex){

							Logger.getLogger("test").severe(ex.toString());
							JOptionPane.showMessageDialog(getGlassPane(), "ERROR\nПоля не должны быть пустыми");
						}
					} else {
						JOptionPane.showMessageDialog(getGlassPane(), "ERROR");
						dispose();
					}
					if (c != null) {
						String a = "p=" + c.getP() + " q=" + c.getQ() + " e="
								+ c.getE() + " d=" + c.getD() + " m=" + c.getM() + " n="+ c.getN() + "\n"
								+ c.getCodeText();
						outText.setText(a);
					}

				} else {
					JOptionPane.showMessageDialog(getGlassPane(), "ERROR");
					dispose();
				}

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
		final JCheckBox decoderChb[] = { new JCheckBox("Ё"), new JCheckBox("Й") };
		ButtonGroup decoderGroup = new ButtonGroup();
		final JRadioButton decoderVar[] = { new JRadioButton(),
				new JRadioButton() };
		final JPanel decoderBar2[] = { new JPanel(), new JPanel() };

		decoderBar.setLayout(null);
		decoderBar.add(decoderChb[0]);
		decoderBar.add(decoderChb[1]);
		decoderBar.add(decoderBar2[0]);
		decoderBar.add(decoderBar2[1]);
		decoderBar.add(decoderVar[0]);
		decoderBar.add(decoderVar[1]);

		decoderChb[0].setSize(35, 20);
		decoderChb[0].setLocation(10, 20);
		decoderChb[0].setOpaque(true);
		decoderChb[1].setSize(35, 20);
		decoderChb[1].setLocation(location(decoderChb[0], 40, -20));
		decoderChb[1].setOpaque(true);

		decoderVar[0].setSize(20, 20);
		decoderVar[0].setLocation(location(decoderChb[0]));
		decoderVar[0].setSelected(true);
		;
		decoderVar[0].setOpaque(true);

		decoderBar2[0].setLayout(null);
		decoderBar2[0].setLocation(location(decoderVar[0], 30, -20));
		decoderBar2[0].setSize(200, 25);
		decoderBar2[0].setVisible(true);
		final JLabel decoderFieldName[] = { new JLabel("d="), new JLabel("m=") };
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

		decoderVar[1].setSize(20, 20);
		decoderVar[1].setLocation(location(decoderVar[0]));
		decoderVar[1].setOpaque(true);

		decoderBar2[1].setLayout(null);
		decoderBar2[1].setLocation(location(decoderVar[1], 30, -20));
		decoderBar2[1].setSize(250, 25);
		decoderBar2[1].setVisible(true);
		final JLabel decoderFieldName2[] = { new JLabel("p="),
				new JLabel("q="), new JLabel("e=") };
		final JTextField decoderKey2[] = { new JTextField(), new JTextField(),
				new JTextField() };
		for (JTextField jTextField : decoderKey2) {
			jTextField.setEnabled(false);
		}
		decoderBar2[1].add(decoderFieldName2[0]);
		decoderBar2[1].add(decoderKey2[0]);
		decoderBar2[1].add(decoderFieldName2[1]);
		decoderBar2[1].add(decoderKey2[1]);
//		decoderBar2[1].add(decoderFieldName2[2]);
//		decoderBar2[1].add(decoderKey2[2]);
		decoderFieldName2[0].setSize(20, 20);
		decoderFieldName2[0].setLocation(0, 0);
		decoderFieldName2[0].setOpaque(true);
		decoderKey2[0].setSize(40, 20);
		decoderKey2[0].setLocation(20, 0);
		decoderKey2[0].setOpaque(true);
		decoderFieldName2[1].setSize(20, 20);
		decoderFieldName2[1].setLocation(80, 0);
		decoderFieldName2[1].setOpaque(true);
		decoderKey2[1].setSize(40, 20);
		decoderKey2[1].setLocation(100, 0);
		decoderKey2[1].setOpaque(true);
		decoderFieldName2[2].setSize(20, 20);
		decoderFieldName2[2].setLocation(160, 0);
		decoderFieldName2[2].setOpaque(true);
		decoderKey2[2].setSize(40, 20);
		decoderKey2[2].setLocation(180, 0);
		decoderKey2[2].setOpaque(true);

		decoderGroup.add(decoderVar[0]);
		decoderGroup.add(decoderVar[1]);

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

		decoderVar[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (decoderVar[0].isSelected()) {
					for (JTextField jTextField : decoderKey) {
						jTextField.setEnabled(true);
					}
					for (JTextField jTextField : decoderKey2) {
						jTextField.setEnabled(false);
					}
				}
			}
		});
		decoderVar[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (decoderVar[1].isSelected()) {
					for (JTextField jTextField : decoderKey) {
						jTextField.setEnabled(false);
					}
					for (JTextField jTextField : decoderKey2) {
						jTextField.setEnabled(true);
					}
				}
			}
		});

		decoderSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int v = -1;
				if (decoderChb[0].isSelected()) {
					// если алфавит с Ё без Й
					v = 0;
					if (decoderChb[1].isSelected()) {
						// если алфавит с Ё и Й
						v = 2;
					}
				} else {
					v = 1;
					if (decoderChb[1].isSelected()) {
						// если алфавит с Й без Ё
						v = 3;
					}
				}
				if (v != -1) {
					Decoder d = null;
					if (decoderVar[0].isSelected()) {
						d = new Decoder(decoderInText.getText(), v,
								new BigInteger(decoderKey[0].getText()),
								new BigInteger(decoderKey[1].getText()));
					} else if (decoderVar[1].isSelected()) {
						d = new Decoder(decoderInText.getText(), v,
								new BigInteger(decoderKey2[0].getText()),
								new BigInteger(decoderKey2[1].getText()), BigInteger.valueOf(0));
					} else {
						JOptionPane.showMessageDialog(getGlassPane(), "ERROR");
						dispose();
					}
					if (d != null) {
						 String
						 a=d.getCodeText();
						 decoderOutText.setText(a);
					}

				} else {
					JOptionPane.showMessageDialog(getGlassPane(), "ERROR");
					dispose();
				}

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