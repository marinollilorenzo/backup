package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.volta.ts.marinollilorenzo.backup.business.BizBackup;

@SuppressWarnings("serial")
public class BackupUi extends JFrame{

	private static int HGAP = 2;
	private static int VGAP = 3;
	/**
	 * <b>Documentazione<b> classe BackupUi
	 */

	public BackupUi(BizBackup business) {


		setMinimumSize(new Dimension(1000, 550));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		setResizable(false);

		JComponent container = new JPanel();
		container.setBackground(new Color(224, 255, 255));
		container.setLayout(new BorderLayout(HGAP, VGAP));
		container.setAlignmentX(Container.LEFT_ALIGNMENT);
		JComponent cont = new JPanel();
		
		cont.setLayout(new BoxLayout(cont, BoxLayout.X_AXIS));
		cont.setBackground(new Color(224, 255, 255));
		Simpleframe sf = new Simpleframe(business);
		sf.setBackground(new Color(224, 255, 255));
		container.add(new Banner(), BorderLayout.NORTH);
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setBackground(Color.red);
		btnElimina.setFont(new Font("Helvetica", Font.BOLD,14));
		btnElimina.setForeground(new Color(245, 245, 245));
		btnElimina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				JFileChooser fileChooser = new JFileChooser();	
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showSaveDialog(null);
				business.deleteBackup(fileChooser.getSelectedFile());
				sf.setBackupList().aggiornaList();
				}catch (Exception e1) {
					// TODO: handle exception
				}

			}
		});
		cont.add(sf);
		cont.add(btnElimina);
		container.add(cont, BorderLayout.CENTER);
		container.add(new Footer(), BorderLayout.SOUTH);

		this.setContentPane(container);
		pack();

	}
}