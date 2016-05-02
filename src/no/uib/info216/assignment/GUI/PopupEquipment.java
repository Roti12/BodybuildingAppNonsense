package no.uib.info216.assignment.GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

public class PopupEquipment extends JFrame {

	private static final long serialVersionUID = -4062320114203994593L;
	private JPanel contentPane; // panel to be used to add elements to.
	private JLabel labelUsername, lblUsername, lblFirstName, lblLastName;  
	private JTextField textFieldUsername; // field so user can enter username.
	private JTextField textFieldFirstname;
	private JTextField textFieldLastname;
	private JButton btnSave;  // button for saving the user.
	private JButton btnClose; // button to close the user view.
	private JTextField textFieldNewPassword;
	private JLabel lblNewPassword;
	private boolean newUser = false;
	private JTabbedPane tabbedPane;
	private JPanel panel;

	/**
	 * Constructor for the UserView, initializes all necessary components and
	 * classes
	 * 
	 * @param user
	 * @param iTracker
	 * @param setup
	 */
	public PopupEquipment(String equipmentName) {

		setTitle("Equipment");

		createComponents();
		addComponents(equipmentName);
		
		init();

	}

	/*
	 * Sets default close ,location and makes the View visible
	 */
	private void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 236);

		setLocationRelativeTo(GUI.getInstance());
		setVisible(true);
	}

	/*
	 * Creates the components of for the UserView
	 */
	private void createComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		if (!newUser) {
			labelUsername = new JLabel();

			labelUsername.setToolTipText("Username\r\n");
		} else {
			textFieldUsername = new JTextField(15);
			textFieldUsername.setToolTipText("Username\r\n");
		}

	}

	/*
	 * Adds the components created by createComponents to the contentPane
	 */
	private void addComponents(String equipmentName) {

		
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab(equipmentName, null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		lblUsername = new JLabel("Username:");
		panel.add(lblUsername);
		
		if (!newUser) {
			panel.add(labelUsername);
		}

		if (newUser){
			panel.add(textFieldUsername);
		}

		lblFirstName = new JLabel("First Name:");
		panel.add(lblFirstName);

		textFieldFirstname = new JTextField(15);
		panel.add(textFieldFirstname);
		textFieldFirstname.setToolTipText("First Name");

		lblLastName = new JLabel("Last Name:");
		panel.add(lblLastName);

		textFieldLastname = new JTextField(15);
		panel.add(textFieldLastname);
		textFieldLastname.setToolTipText("Last Name");
		

		
		lblNewPassword = new JLabel("New Password:");
		panel.add(lblNewPassword);

		textFieldNewPassword = new JPasswordField(15);
		panel.add(textFieldNewPassword);

		btnClose = new JButton("Close");
		panel.add(btnClose);
		btnSave = new JButton("Save");
		panel.add(btnSave);

	}


	/**
	 * @return the labelUsername
	 */
	public JLabel getLabelUsername() {
		return labelUsername;
	}

	/**
	 * @return the textFieldFirstname
	 */
	public JTextField getTextFieldFirstname() {
		return textFieldFirstname;
	}

	/**
	 * @return the textFieldLastname
	 */
	public JTextField getTextFieldLastname() {
		return textFieldLastname;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

	/**
	 * @return the btnClose
	 */
	public JButton getBtnClose() {
		return btnClose;
	}

}

