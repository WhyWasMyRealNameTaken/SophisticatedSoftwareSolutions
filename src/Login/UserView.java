import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

public class UserView extends JFrame implements ActionListener {
	JLabel appName, description, organization, version, search;
	JTextField nameTF, descriptionTF, orgTF, versionTF, searchTF;
	JButton addButton, saveButton, Logout;
	JTextArea appTA;
	
	public User() {
		super("Appdex");
		
		search = new JLabel("Search: ");
		searchTF = new JTextField(50);
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout());
		searchPanel.add(search);
		searchPanel.add(searchTF);
		
		
		
		appName = new JLabel("Application Name: ");
		description = new JLabel("Description:");
		organization = new JLabel("Organization:");
		version = new JLabel("Version(s):");
		nameTF = new JTextField(50);
		descriptionTF = new JTextField(50);
		orgTF = new JTextField(50);
		versionTF = new JTextField(50);
		addButton = new JButton("Add Post");
		Logout= new JButton("Log-out");

		JPanel addNewAppPanel = new JPanel();
		addNewAppPanel.setLayout(new GridLayout(10, 1));
		addNewAppPanel.setBorder(new TitledBorder("Enter New Application Information"));
		
		addNewAppPanel.add(appName, 0);
		addNewAppPanel.add(nameTF, 1);
		addNewAppPanel.add(description, 2);
		addNewAppPanel.add(descriptionTF, 3);
		addNewAppPanel.add(organization, 4);
		addNewAppPanel.add(orgTF, 5);
		addNewAppPanel.add(version, 6);
		addNewAppPanel.add(versionTF, 7);
		addNewAppPanel.add(addButton, 8);
		addNewAppPanel.add(Logout, 9);
		addButton.addActionListener(this);
		Logout.addActionListener(this);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new TitledBorder("Applications:"));
		appTA = new JTextArea(20, 80);
		displayPanel.add(appTA);
		
		add(searchPanel, BorderLayout.NORTH);
		add(addNewAppPanel, BorderLayout.CENTER);
		add(displayPanel, BorderLayout.SOUTH);
	}

	public static void main (String[] args) {
		HomePage hp =  new HomePage();
		hp.setSize(670, 670);
		hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		hp.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Add Post")) {
			appTA.append("Application name: " + nameTF.getText() + ". Description: " + descriptionTF.getText() + ". Organization: " + orgTF.getText() + ". Versions: " + versionTF.getText() + "\n");
			nameTF.setText("");
			descriptionTF.setText("");
			orgTF.setText("");
			versionTF.setText("");
		}
		
		if (arg0.getActionCommand().equals("Log-out")) {
			HomePage frame = new HomePage();
			frame.setBounds(300, 90, 900, 600);
			frame.setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dispose();
		}
	}
}