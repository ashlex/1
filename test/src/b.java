import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;




class b{
	JFrame jf;
	JButton b1,b2;
	JLabel l1;
	JPanel pan1,pan2;
	JScrollPane pan;
	Hand hand=new Hand();
	b(){
		jf=new JFrame("TEST");
		jf.setSize(300 , 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1=new JButton();
		b1.addActionListener(hand);
		b2=new JButton();
		b2.addActionListener(hand);
		l1=new JLabel("<html>"+
				"<h1>Здравствуйте, Алексей Шаров.</h1><br>Сейчас на Rabota.ru <br>" +
				"размещено ваше резюме «Помощник программиста». В <br>" +
				"течение недели вы не обновляли дату его публикации.<br>" +
				"Рекомендуем вам каждый день обновлять дату своего <br>" +
				"резюме — тогда работодатели будут видеть его на <br>" +
				"первых позициях в результатах поиска. Для обновления <br>" +
				"даты достаточно в списке резюме нажать на ссылку <br>" +
				"«Обновить дату».");
		pan1=new JPanel();
		pan2=new JPanel();
		pan=new JScrollPane();
		pan1.setLayout(new GridLayout( 2, 1, 5, 5));
		pan1.setBackground(Color.blue);
		pan2.setBackground(Color.cyan);
		pan1.setOpaque(true);
		pan2.setOpaque(true);
		pan.setViewportView(pan1);
		pan1.add(b1);
		pan1.add(l1);
		//pan.add(pan1);
		pan2.add(b2);
		jf.add(pan);
		jf.setVisible(true);
	}
	class Hand implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1){
				pan.setViewportView(pan2);
			}
			if(e.getSource()==b2){
				pan.setViewportView(pan1);
			}
		}
		
	}
}