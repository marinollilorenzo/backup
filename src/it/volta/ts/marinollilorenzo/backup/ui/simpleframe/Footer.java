package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Footer extends JPanel {
    
    public Footer() {
    	this.setBackground(new Color(224, 255, 255));
        this.add(new JLabel("by Lorenzo Marinolli 4E"));
        this.setFont(new Font("Helvetica", Font.BOLD,14));
    }
}