package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.volta.ts.marinollilorenzo.backup.business.BizBackup;

public class SearchFileDirectory extends JPanel{

	private JFileChooser chooser;
	private JTextField t1,t2;
	public SearchFileDirectory(BizBackup business) {
		super();
		this.setLayout(new GridLayout(2,2));
		this.setMaximumSize(new Dimension(500, 100));
	    t1 = new JTextField("<path>", 10);
	    t1.setEditable(false);
	    t1.setFont(new Font("Helvetica", Font.BOLD,14));
	    t1.setBackground(new Color(230, 230, 250));
	    
	    JButton fileButton = new JButton("cerca file");
	    fileButton.setFont(new Font("Helvetica", Font.BOLD,14));
	    fileButton.setBackground(new Color(250, 235, 215));
	    fileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				business.setSourceFile(chooser.getSelectedFile());
				t1.setText(chooser.getSelectedFile().getName());
			}
	    	
	    });
	    
	    t2 = new JTextField("<path>", 10);
	    t2.setEditable(false);
	    t2.setFont(new Font("Helvetica", Font.BOLD,14));
	    t2.setBackground(new Color(230, 230, 250));
	    JButton dirButton = new JButton("cerca cartella");
	    dirButton.setFont(new Font("Helvetica", Font.BOLD,14));
	    dirButton.setBackground(new Color(250, 235, 215));
	    dirButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(null);
				business.setTargetDirectory(chooser.getSelectedFile());
				t2.setText(chooser.getSelectedFile().getName());
			}
	    	
	    });
	    
	    
	    
	    
	    this.add(t1);
	    this.add(fileButton);
	    this.add(t2);
	    this.add(dirButton);
	}
	
	public void clearText() {
		t1.setText("<path>          ");
		t2.setText("<path>          ");
	}
}
