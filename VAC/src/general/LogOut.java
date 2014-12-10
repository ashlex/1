package general;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogOut extends StreamHandler {
	private JFrame frame;
	
	public LogOut(String name) {
		frame = new JFrame(name);
		final JTextArea output=new JTextArea();
		output.setBackground(Color.BLACK);
		output.setForeground(Color.GREEN);
		output.setEditable(false);
		frame.setSize(400, 400);
		frame.add(new JScrollPane(output));
		frame.setVisible(true);
		setOutputStream(new OutputStream() {
			
			@Override
			public void write(int arg0) throws IOException {
				// TODO Auto-generated method stub	
			}
			public void write(byte [] b, int off, int len) {
				output.append(new String(b , off, len));
			}
		});
	}
	
	public void publish(LogRecord record){
//		if(!frame.isVisible()){
			super.publish(record);
			flush();
//		}
	}
	

}
