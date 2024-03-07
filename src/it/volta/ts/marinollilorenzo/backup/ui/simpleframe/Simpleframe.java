package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.volta.ts.marinollilorenzo.backup.business.BizBackup;


public class Simpleframe extends JPanel {

    private static int HGAP = 2;
    private static int VGAP = 3;
    private BackupList backupList;
    public Simpleframe(BizBackup business) {
    	 backupList = new BackupList(business);
    	this.setLayout(new BorderLayout(HGAP, VGAP));
    	JButton b = new JButton("Backup");
    	b.setFont(new Font("Helvetica", Font.BOLD,14));
    	b.setBackground(new Color(127, 255, 0));
    	SearchFileDirectory sFileDir = new SearchFileDirectory(business);
    	b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				business.creaBackup();
				backupList.aggiornaList();
				business.setFileDirectory();
				sFileDir.clearText();
				
			}
		});
    	
    	JLabel benvenuto = new JLabel("Benvenuto");
    	benvenuto.setFont(new Font("Helvetica", Font.BOLD,14));
    	this.add(benvenuto, BorderLayout.NORTH);
    	JComponent cont = new JPanel();
    	this.setBackground(new Color(224, 255, 255));
    	cont.setBackground(new Color(224, 255, 255));
    	cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
    	cont.add(sFileDir);
    	cont.add(b);
    	this.add(cont, BorderLayout.CENTER);
    	this.add(backupList, BorderLayout.EAST);
    }
    public BackupList setBackupList() {
    	return backupList;
    }

}