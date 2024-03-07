package it.volta.ts.marinollilorenzo.backup;

import java.io.IOException;

import javax.swing.JFrame;

import it.volta.ts.marinollilorenzo.backup.business.BizBackup;
import it.volta.ts.marinollilorenzo.backup.ui.simpleframe.BackupUi;



public class Main {

	public static void main(String[] args) throws IOException{

		BizBackup business = new BizBackup();
		JFrame frame = new BackupUi(business);
		frame.setVisible(true);

	}

}
