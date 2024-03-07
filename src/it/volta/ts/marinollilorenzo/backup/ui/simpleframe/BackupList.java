package it.volta.ts.marinollilorenzo.backup.ui.simpleframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import it.volta.ts.marinollilorenzo.backup.business.BizBackup;

public class BackupList extends JPanel {

    private DefaultListModel<String> listModel;
    private JList<String> list;
	private BizBackup business;

	public BackupList(BizBackup business){

		this.business = business;
		this.setBackground(new Color(224, 255, 255));
		setBorder(new EmptyBorder(20,20, 20, 20));
		setLayout(new BorderLayout(20, 20));

        listModel  = new DefaultListModel<String>();
		list       = new JList<String>();
		list.setBackground(new Color(135, 206, 235));
		list.setFont(new Font("Helvetica", Font.BOLD,14));
		ScrollPane scrollPane = new ScrollPane();

		this.setMinimumSize(new Dimension(220, 250));
		this.setSize(new Dimension(320, 250));
		list.setMinimumSize(new Dimension(200, 200));
		list.setSize(new Dimension(200, 300));
        scrollPane.setMinimumSize(new Dimension(250, 300));
        scrollPane.setSize(new Dimension(250, 300));

        list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
		// scrollPane.setBackground(Pallette.sfondoElementi);
		scrollPane.add(list);

        // test
		add(scrollPane, BorderLayout.CENTER);


    }

    public void aggiornaList()
	{
		listModel.clear();

		for (String file : business.listExistingBackups()){
			listModel.addElement(file);
		}

		list.setModel(listModel);
	}
}