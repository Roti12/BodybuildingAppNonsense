package no.uib.info216.assignment.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7513854125040781915L;
	private JPanel contentPane; // Panel

	private JButton btnUpdate; // updates the search field in the search tab.
	private JTabbedPane tabbedPane;
	private List equipmentList;

	private JMenuItem menuNewProgram; // menuitem for importing xml file.
	private JMenuItem menuMyProgram;
	private JMenuItem menuExitAppliction; // menuitem to exit the application.
	private JMenuItem menuSettingsAddUser; // menuitems to add user.

	JButton deadliftButton;
	JButton squatButton;
	JButton benchPressButton;
	JButton overheadPressButton;
	private JSplitPane splitPane; // splits the pane.
	private static GUI instance = null;


	/**
	 * Create the frame.
	 * 
	 * @param title
	 *            the title of the no.uib.info216.assignment.GUI frame. Sets up the graphical interface,
	 *            adds relevant items onto it.
	 */
	public GUI(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenSize.getWidth() / 2;
		Double height = screenSize.getHeight() / 2;

		setBounds(100, 100, width.intValue(), height.intValue());
		// center on user screen, because why not
		setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel programPanel = new JPanel();
		tabbedPane.addTab("My Program", null, programPanel, null);

		SpringLayout sl_panel = new SpringLayout();
		programPanel.setLayout(sl_panel);

		JComboBox<String> experienceOptions = new JComboBox<>();
		experienceOptions.addItem("None");
		experienceOptions.addItem("Less than 6 months");
		experienceOptions.addItem("More than 6 months");
		experienceOptions.addItem("Less than a year");
		experienceOptions.addItem("More than a year");
		experienceOptions.addItem("Less than 2 years");
		experienceOptions.addItem("More than 2 years");

		JLabel chooseExperience = new JLabel("Please select your previous experience with weightlifting");

		sl_panel.putConstraint(SpringLayout.VERTICAL_CENTER, chooseExperience, -100, SpringLayout.VERTICAL_CENTER, programPanel);
		sl_panel.putConstraint(SpringLayout.EAST, chooseExperience, -250, SpringLayout.EAST, programPanel);
		programPanel.add(chooseExperience);

		JButton createProgram = new JButton("CREATE PROGRAM");

		sl_panel.putConstraint(SpringLayout.VERTICAL_CENTER, createProgram, 50, SpringLayout.VERTICAL_CENTER, programPanel);
		sl_panel.putConstraint(SpringLayout.EAST, createProgram, -335, SpringLayout.EAST, programPanel);
		programPanel.add(createProgram);


		sl_panel.putConstraint(SpringLayout.VERTICAL_CENTER, experienceOptions, 0, SpringLayout.VERTICAL_CENTER, programPanel);
		sl_panel.putConstraint(SpringLayout.EAST, experienceOptions, -335, SpringLayout.EAST, programPanel);
		programPanel.add(experienceOptions);


		createProgram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == createProgram && experienceOptions.getSelectedItem().equals("None")) {
					System.out.println("Program not yet finished");
				}
			}
		});



		JPanel excercisePanel = new JPanel();
		tabbedPane.addTab("Excercises", null, excercisePanel, null);

		SpringLayout ex_panel = new SpringLayout();
		excercisePanel.setLayout(ex_panel);

		this.deadliftButton = new JButton("Deadlift");
		this.squatButton = new JButton("Squat");
		this.benchPressButton = new JButton("Bench Press");
		this.overheadPressButton = new JButton("Overhead Press");


		ex_panel.putConstraint(SpringLayout.NORTH, deadliftButton, 15, SpringLayout.NORTH, excercisePanel);
		ex_panel.putConstraint(SpringLayout.WEST, deadliftButton, 40, SpringLayout.WEST, excercisePanel);
		ex_panel.putConstraint(SpringLayout.EAST, deadliftButton, -500, SpringLayout.EAST, excercisePanel);
		excercisePanel.add(deadliftButton);

		ex_panel.putConstraint(SpringLayout.NORTH, squatButton, 70, SpringLayout.NORTH, excercisePanel);
		ex_panel.putConstraint(SpringLayout.WEST, squatButton, 45, SpringLayout.WEST, excercisePanel);
		ex_panel.putConstraint(SpringLayout.EAST, squatButton, -500, SpringLayout.EAST, excercisePanel);
		excercisePanel.add(squatButton);

		ex_panel.putConstraint(SpringLayout.NORTH, benchPressButton, 125, SpringLayout.NORTH, excercisePanel);
		ex_panel.putConstraint(SpringLayout.WEST, benchPressButton, 50, SpringLayout.WEST, excercisePanel);
		ex_panel.putConstraint(SpringLayout.EAST, benchPressButton, -500, SpringLayout.EAST, excercisePanel);
		excercisePanel.add(benchPressButton);

		ex_panel.putConstraint(SpringLayout.NORTH, overheadPressButton, 180, SpringLayout.NORTH, excercisePanel);
		ex_panel.putConstraint(SpringLayout.WEST, overheadPressButton, 35, SpringLayout.WEST, excercisePanel);
		ex_panel.putConstraint(SpringLayout.EAST,overheadPressButton, -500, SpringLayout.EAST, excercisePanel);
		excercisePanel.add(overheadPressButton);

		JPanel machinePanel = new JPanel(new SpringLayout());
		tabbedPane.addTab("Machines", machinePanel);

		JButton latPulldown = new JButton("Lat Pulldown Machine");
		machinePanel.add(latPulldown);

		latPulldown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == latPulldown) {
					PopupMachines pop = new PopupMachines(latPulldown.getText());
				}
			}
		});


		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Equipment", null, scrollPane, null);

		equipmentList = new List();
		equipmentList.add("Bench");
		equipmentList.add("Bench Press Rack");
		equipmentList.add("Squat Rack");
		equipmentList.add("Olympic Barbell Men");
		equipmentList.add("Cap Barbell Dumbells");
		equipmentList.add("Rounded Dumbells");
		equipmentList.add("Hexagonal Dumbells");
		equipmentList.add("Squared Dumbells");
		equipmentList.add("Kettlebells");
		equipmentList.add("Weighted Plates");
		
		scrollPane.setViewportView(equipmentList);

		JLabel lblAllUsers = new JLabel("Gym Equipment");

		scrollPane.setColumnHeaderView(lblAllUsers);
		

		getContentPane().add(contentPane);

		
		JMenuBar menuBar = new JMenuBar(); // menubar at the top of the frame.
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Program"); // creates a new JMenu and adds it
												// to menuBar.
		menuBar.add(mnNewMenu);

		menuNewProgram = new JMenuItem("New Program");
		mnNewMenu.add(menuNewProgram);
		
		menuMyProgram = new JMenuItem("My Program");
		mnNewMenu.add(menuMyProgram);

		menuExitAppliction = new JMenuItem("Exit");
		menuExitAppliction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();

			}
		});

		mnNewMenu.add(menuExitAppliction);

		JMenu mnSettings = new JMenu("Help");
		menuBar.add(mnSettings);

		menuSettingsAddUser = new JMenuItem("Info");
		mnSettings.add(menuSettingsAddUser);
		setVisible(true);
	}
	
	
	
	public JButton getDeadliftButton() {
		return deadliftButton;
	}
	public JButton getSquatButton() {
		return squatButton;
	}
	public JButton getBenchPressButton() {
		return benchPressButton;
	}
	public JButton getoverheadPressButton() {
		return overheadPressButton;
	}

	public void setDeadliftButton(JButton deadliftButton) {
		this.deadliftButton = deadliftButton;
	}



	public static synchronized GUI getInstance() {
		if (instance == null) {
			instance = new GUI("");
		}
		return instance;
	}

	/**
	 * @return the btnUpdate button.
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}


	/**
	 * @param btnUpdate
	 *            to be the new value of btnUpdate field.
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}


	/**
	 * @return userList the list of users.
	 */
	public List getEquipmentList() {
		return equipmentList;
	}

	/**
	 * @return the tabbedPane.
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * @return the menuImportData
	 */
	public JMenuItem getMenuNewProgram() {
		return menuNewProgram;
	}
	
	public JMenuItem getMenuMyProgram() {
		return menuMyProgram;
	}

	/**
	 * @return the menuExitAppliction
	 */
	public JMenuItem getMenuExitAppliction() {
		return menuExitAppliction;
	}

	/**
	 * @return the menuSettingsAddUser
	 */
	public JMenuItem getMenuSettingsAddUser() {
		return menuSettingsAddUser;
	}

}
