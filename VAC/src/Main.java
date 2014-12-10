import general.Args;
import general.LogOut;
import general.Vars;

import java.awt.EventQueue;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		
		Args.getInstance().addAllArgs(args);

//		Args.getInstance().addArgs("-log");
//		Args.getInstance().addArgs("-elgamal");
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				if (Args.getInstance().equalsIgnoreCase("-log")) {
					Handler windowHandler = new LogOut("Log");
					windowHandler.setLevel(Level.ALL);
					Logger.getLogger("test").addHandler(windowHandler);
					Logger.getLogger("test").setLevel(Level.ALL);
				} else {
					Logger.getLogger("test").setLevel(Level.OFF);
				}

				if (Args.getInstance().equalsIgnoreCase("-zesar")) {
					new zesar.Window();

				} else if (Args.getInstance().equalsIgnoreCase("-rsa")) {
					new rsa.Window();

				} else if (Args.getInstance().equalsIgnoreCase("-elgamal")) {
					new ElGamal.Window();
				} else {
					Logger.getLogger("test").info(
							Vars.CREATE_OBJECT.getAbbreviation() + "SatrtMenu");
					new StartMenu("Лабораторные работы");
				}

			}
		});
	}

}
