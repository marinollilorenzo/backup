package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banner extends JPanel {

	public Banner(){

		try {
			this.setBackground(new Color(224, 255, 255));
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			BufferedImage wPic = ImageIO.read(new File("logo.png"));
			Image image = wPic.getScaledInstance(wPic.getWidth()/6, wPic.getHeight()/6, Image.SCALE_SMOOTH);

			JLabel wIcon = new JLabel(new ImageIcon(image));
			wIcon.setSize( wPic.getWidth()/6, wPic.getHeight()/6);
			wIcon.setPreferredSize(wIcon.getSize());
			wIcon.setBounds(0,0, wIcon.getWidth(), wIcon.getHeight());
			wIcon.setAlignmentX(Component.LEFT_ALIGNMENT);
			wIcon.setHorizontalAlignment(JLabel.LEFT);
			this.setAlignmentX(Component.LEFT_ALIGNMENT);
			this.add(wIcon);

		} catch (IOException ioe) {
		}
	}
}
