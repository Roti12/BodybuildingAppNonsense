package no.uib.info216.assignment.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import no.uib.info216.assignment.SPARQLQueries.QueryItems;
import no.uib.info216.assignment.SPARQLQueries.strings.QueryStrings;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7513854125040781915L;
	private JPanel contentPane; // Panel
	private JComboBox<String> userBox; // dropdown menu for different search
										// options.
	private JButton btnUpdate; // updates the search field in the search tab.
	private JTabbedPane tabbedPane;
	private JButton btnNewIssue; // button to add new issues to allIssues tab.
	private List equipmentList;
	private JTextField searchByIDField;
	private JMenuItem menuNewProgram; // menuitem for importing xml file.
	private JMenuItem menuMyProgram;
	private JMenuItem menuExitAppliction; // menuitem to exit the application.
	private JMenuItem menuSettingsAddUser; // menuitems to add user.
	private JButton btnGetHighPriority; // button to retrieve high priority
										// issues.
	private JSplitPane splitPane; // splits the pane.
	private static GUI instance = null;
	private PopupExcercises popEx;
	private PopupEquipment popEq;

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

		JPanel panel = new JPanel();
		tabbedPane.addTab("My Program", null, panel, null);

		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton testButton = new JButton("Deadlift"); 
		
		testButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == testButton) {
					System.out.println("Hello, you have pressed a button");
					popEx = new PopupExcercises(testButton.getText());
					QueryItems.queryOntology("Workout Planner", QueryStrings.queryDeadlift);
				}
				
			}
		});
																
		sl_panel.putConstraint(SpringLayout.NORTH, testButton, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, testButton, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, testButton, -399, SpringLayout.EAST, panel);
		panel.add(testButton);
		
		splitPane = new JSplitPane();
		tabbedPane.addTab("Excercises", null, splitPane, null);

		btnNewIssue = new JButton("New issue");
		btnNewIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		splitPane.setLeftComponent(btnNewIssue);

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
		
		MouseClicks(equipmentList);
		
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

		menuSettingsAddUser = new JMenuItem("Add user");
		mnSettings.add(menuSettingsAddUser);
		setVisible(true);
	}
	
	
	public void MouseClicks(Object e) {
		((Component) e).addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (e.getSource() == equipmentList) {
						String x = e.getComponent().toString().substring(41);
						popEq = new PopupEquipment(x);
					}
				}
			}
			
		});
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

	public JTextField getSearchByIDField() {
		return this.searchByIDField;
	}

	/**
	 * @param btnUpdate
	 *            to be the new value of btnUpdate field.
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	/**
	 * @return the userBox.
	 */
	public JComboBox<String> getUserBox() {
		return userBox;
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
	 * @return the btnNewIssue button.
	 */
	public JButton getBtnNewIssue() {
		return btnNewIssue;
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

	/**
	 * @return the btnGetHighPriority
	 */
	public JButton getBtnGetHighPriority() {
		return btnGetHighPriority;
	}
}
