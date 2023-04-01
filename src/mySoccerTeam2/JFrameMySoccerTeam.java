package mySoccerTeam2;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;


import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public class JFrameMySoccerTeam extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel label_Team;
	private JLabel label_Id;
	private JLabel nameLabel;
	private JLabel label_Vorname;
	private JLabel label_Marktwert;
	private JLabel label_GesamtWert;
	private JComboBox<Team> comboBox_Team;
	private JTextField textField_Id;
	private JTextField textField_Name;
	private JTextField textField_Marktwert;
	private JTextField textField_Vorname;
	private JTextField textField_Gesamtwert;
	private JButton button_first;
	private JButton button_Vorher;
	private JButton button_Nachher;
	private JButton button_Ende;
	private JButton button_Loeschen;
	private JButton button_Hinzufuegen;
	private JButton button_NeuesTeam;
	private JList list;
	DefaultListModel list_Model = new DefaultListModel();
	private JScrollPane scrollPane;
	private JButton button_Beenden;
	/////////////////////////////////////
	private ArrayList<Team> team_list;
	private TeamArtDaoSqlite2 teamDao;
	private Player player;
	private PlayerDaoSqlite2 playerDao;
	private JLabel newLabelLabel_1;
	private JButton newButtonButton;
	private JButton playerBearbeitenButton;
	private JPanel panel;
/////////////////////////////////
	private double gesamtMarktWert = 0;
	private ArrayList gesamtwert_List = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMySoccerTeam frame = new JFrameMySoccerTeam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws DaoException2
	 * @throws ClassNotFoundException
	 */
	public JFrameMySoccerTeam() throws DaoException2, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\Users\\M_Ala\\eclipse-workspace\\JavaSwing\\src\\MySoccerTeam2\\Fotos\\fussball.png"));
		initGUI();
		init();
		list_init();

	}

	private void initGUI() {
		setTitle("SocerTeam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(178, 34, 34)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			label_Team = new JLabel("Team");
			label_Team.setForeground(Color.WHITE);
			label_Team.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_Team.setBounds(10, 36, 103, 25);
			contentPane.add(label_Team);
		}
		{
			label_Id = new JLabel("ID");
			label_Id.setForeground(Color.WHITE);
			label_Id.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_Id.setBounds(10, 100, 103, 25);
			contentPane.add(label_Id);
		}
		{
			nameLabel = new JLabel("Name");
			nameLabel.setForeground(Color.WHITE);
			nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			nameLabel.setBounds(10, 155, 103, 25);
			contentPane.add(nameLabel);
		}
		{
			label_Vorname = new JLabel("Vorname");
			label_Vorname.setForeground(Color.WHITE);
			label_Vorname.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_Vorname.setBounds(10, 221, 103, 25);
			contentPane.add(label_Vorname);
		}
		{
			label_Marktwert = new JLabel("Marktwert");
			label_Marktwert.setForeground(Color.WHITE);
			label_Marktwert.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_Marktwert.setBounds(10, 277, 103, 25);
			contentPane.add(label_Marktwert);
		}
		{
			label_GesamtWert = new JLabel("Gesamtwert in Mio");
			label_GesamtWert.setForeground(Color.WHITE);
			label_GesamtWert.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_GesamtWert.setBounds(10, 529, 135, 31);
			contentPane.add(label_GesamtWert);
		}
		{
			comboBox_Team = new JComboBox();
			comboBox_Team.setFont(new Font("Tahoma", Font.BOLD, 14));
			comboBox_Team.setBounds(251, 36, 198, 25);
			contentPane.add(comboBox_Team);
		}
		{
			textField_Id = new JTextField();
			textField_Id.setEditable(false);
			textField_Id.setBorder(new LineBorder(new Color(47, 79, 79)));
			textField_Id.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_Id.setBounds(251, 100, 198, 25);
			contentPane.add(textField_Id);
			textField_Id.setColumns(10);
		}
		{
			textField_Name = new JTextField();
			textField_Name.setEditable(false);
			textField_Name.setBorder(new LineBorder(new Color(47, 79, 79)));
			textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_Name.setColumns(10);
			textField_Name.setBounds(251, 155, 198, 25);
			contentPane.add(textField_Name);
		}
		{
			textField_Marktwert = new JTextField();
			textField_Marktwert.setEditable(false);
			textField_Marktwert.setBorder(new LineBorder(new Color(47, 79, 79)));
			textField_Marktwert.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_Marktwert.setColumns(10);
			textField_Marktwert.setBounds(251, 277, 198, 25);
			contentPane.add(textField_Marktwert);
		}
		{
			textField_Vorname = new JTextField();
			textField_Vorname.setEditable(false);
			textField_Vorname.setBorder(new LineBorder(new Color(47, 79, 79)));
			textField_Vorname.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_Vorname.setColumns(10);
			textField_Vorname.setBounds(251, 221, 198, 25);
			contentPane.add(textField_Vorname);
		}
		{
			textField_Gesamtwert = new JTextField();
			textField_Gesamtwert.setBorder(new LineBorder(new Color(47, 79, 79)));
			textField_Gesamtwert.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_Gesamtwert.setEditable(false);
			textField_Gesamtwert.setColumns(10);
			textField_Gesamtwert.setBounds(251, 529, 198, 31);
			contentPane.add(textField_Gesamtwert);
		}
		{
			button_first = new JButton("|<");
			button_first.setFocusable(false);
			button_first.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_first.setBackground(new Color(0, 128, 128));
			button_first.setForeground(new Color(255, 255, 255));
			button_first.setFont(new Font("Tahoma", Font.BOLD, 10));
			button_first.addActionListener(this);
			button_first.setBounds(10, 321, 56, 25);
			contentPane.add(button_first);
		}
		{
			button_Vorher = new JButton("<<");
			button_Vorher.setFocusable(false);
			button_Vorher.addActionListener(this);
			button_Vorher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Vorher.setBackground(new Color(0, 128, 128));
			button_Vorher.setForeground(new Color(255, 255, 255));
			button_Vorher.setFont(new Font("Tahoma", Font.BOLD, 10));
			button_Vorher.setBounds(70, 321, 52, 25);
			contentPane.add(button_Vorher);
		}
		{
			button_Nachher = new JButton(">>");
			button_Nachher.setFocusable(false);
			button_Nachher.addActionListener(this);
			button_Nachher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Nachher.setBackground(new Color(0, 128, 128));
			button_Nachher.setForeground(new Color(255, 255, 255));
			button_Nachher.setFont(new Font("Tahoma", Font.BOLD, 10));
			button_Nachher.setBounds(127, 321, 52, 25);
			contentPane.add(button_Nachher);
		}
		{
			button_Ende = new JButton(">|");
			button_Ende.setFocusable(false);
			button_Ende.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Ende.setBackground(new Color(0, 128, 128));
			button_Ende.setForeground(new Color(255, 255, 255));
			button_Ende.setFont(new Font("Tahoma", Font.BOLD, 10));
			button_Ende.addActionListener(this);
			button_Ende.setBounds(184, 321, 56, 25);
			contentPane.add(button_Ende);
		}
		{
			button_Loeschen = new JButton("L\u00F6schen");
			button_Loeschen.setFocusable(false);
			button_Loeschen.addActionListener(this);
			button_Loeschen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Loeschen.setBackground(new Color(178, 34, 34));
			button_Loeschen.setForeground(new Color(255, 255, 255));
			button_Loeschen.setFont(new Font("Tahoma", Font.BOLD, 12));
			button_Loeschen.setBounds(251, 356, 85, 26);
			contentPane.add(button_Loeschen);
		}
		{
			button_Hinzufuegen = new JButton("Hinzuf\u00FCgen");
			button_Hinzufuegen.setFocusable(false);
			button_Hinzufuegen.addActionListener(this);
			button_Hinzufuegen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Hinzufuegen.setBackground(new Color(0, 128, 0));
			button_Hinzufuegen.setForeground(new Color(255, 255, 255));
			button_Hinzufuegen.setFont(new Font("Tahoma", Font.BOLD, 12));
			button_Hinzufuegen.setBounds(346, 357, 103, 25);
			contentPane.add(button_Hinzufuegen);
		}
		{
			button_NeuesTeam = new JButton("Neus Team");
			button_NeuesTeam.addActionListener(this);
			button_NeuesTeam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_NeuesTeam.setBackground(new Color(0, 128, 128));
			button_NeuesTeam.setForeground(new Color(255, 255, 255));
			button_NeuesTeam.setBounds(10, 570, 103, 28);
			contentPane.add(button_NeuesTeam);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 392, 439, 124);
			contentPane.add(scrollPane);
			{
				list = new JList();
				scrollPane.setViewportView(list);
				list.setModel(list_Model);
			}
		}
		{
			button_Beenden = new JButton("Beenden");
			button_Beenden.addActionListener(this);
			button_Beenden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_Beenden.setBackground(new Color(178, 34, 34));
			button_Beenden.setForeground(new Color(255, 255, 255));
			button_Beenden.setBounds(346, 570, 103, 28);
			contentPane.add(button_Beenden);
		}
		{
			newLabelLabel_1 = new JLabel("x");
			newLabelLabel_1.addMouseListener(this);
			newLabelLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			newLabelLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
			newLabelLabel_1.setForeground(Color.WHITE);
			newLabelLabel_1.setBounds(447, -5, 25, 28);
			contentPane.add(newLabelLabel_1);
		}
		{
			newButtonButton = new JButton("Team Bearbeiten");
			newButtonButton.setFocusable(false);
			newButtonButton.addActionListener(this);
			newButtonButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			newButtonButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
			newButtonButton.setForeground(Color.WHITE);
			newButtonButton.setBackground(new Color(0, 128, 128));
			newButtonButton.setBounds(251, 321, 85, 25);
			contentPane.add(newButtonButton);
		}
		{
			playerBearbeitenButton = new JButton("Player Bearbeiten");
			playerBearbeitenButton.setFocusable(false);
			playerBearbeitenButton.addActionListener(this);
			playerBearbeitenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			playerBearbeitenButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
			playerBearbeitenButton.setForeground(Color.WHITE);
			playerBearbeitenButton.setBackground(new Color(0, 128, 128));
			playerBearbeitenButton.setBounds(346, 321, 103, 25);
			contentPane.add(playerBearbeitenButton);
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(178, 34, 34));
			panel.setBounds(10, 356, 230, 26);
			contentPane.add(panel);
		}
	}

	private void list_init() {
		if (list_Model.isEmpty()) {
			scrollPane.setVisible(false);
			textField_Gesamtwert.setVisible(false);
			label_GesamtWert.setVisible(false);
			button_NeuesTeam.setBounds(10, 392, 103, 28);
			button_Beenden.setBounds(346, 392, 103, 28);
			setBounds(100, 100, 473, 470);
		} else {
			scrollPane.setVisible(true);
			textField_Gesamtwert.setVisible(true);
			label_GesamtWert.setVisible(true);
			button_NeuesTeam.setBounds(10, 570, 103, 28);
			button_Beenden.setBounds(346, 570, 103, 28);
			setBounds(100, 100, 473, 638);

		}

	}

	private void init() throws ClassNotFoundException {
		try {
			teamDao = new TeamArtDaoSqlite2();
		} catch (ClassNotFoundException e) {
			showErorrMessage(e.getMessage());
			JOptionPane.showMessageDialog(null, e);
		}
		try {
			fill_comobox();
		} catch (DaoException2 e) {
			showErorrMessage(e.getMessage());
		}
		player = new Player();
		leeren();
	}

	private void fill_comobox() throws DaoException2, ClassNotFoundException {
		team_list = teamDao.read_Team();
		comboBox_Team.removeAllItems();
		for (Team team : team_list) {
			comboBox_Team.addItem(team);
		}
	}

	private void showErorrMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Erorr", JOptionPane.ERROR_MESSAGE);
	}

	private void leeren() {
		textField_Id.setText("");
		textField_Name.setText("");
		textField_Vorname.setText("");
		textField_Marktwert.setText("");
		textField_Gesamtwert.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_Loeschen) {
			do_button_Loeschen_actionPerformed(e);
		}
		if (e.getSource() == button_Hinzufuegen) {
			do_button_Hinzufuegen_actionPerformed(e);
		}
		if (e.getSource() == newButtonButton) {
			do_newButtonButton_actionPerformed(e);
		}
		if (e.getSource() == playerBearbeitenButton) {
			do_playerBearbeitenButton_actionPerformed(e);
		}
		if (e.getSource() == button_NeuesTeam) {
			do_newButtonButton_6_actionPerformed(e);
		}
		if (e.getSource() == button_Beenden) {
			do_button_Beenden_actionPerformed(e);
		}
		if (e.getSource() == button_Nachher) {
			try {
				do_button_Nachher_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == button_Vorher) {
			try {
				do_button_Vorher_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == button_Ende) {
			try {
				do_button_Ende_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == button_first) {
			try {
				try {
					do_button_first_actionPerformed(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (DaoException2 e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void do_button_first_actionPerformed(ActionEvent e) throws DaoException2, ClassNotFoundException {
		try {
			playerDao = new PlayerDaoSqlite2();
			player = playerDao.readPlayer_First();
			fill_Textfielder();
		} catch (DaoException2 e2) {
			showErorrMessage(e2.getMessage());
		}

	}

	/**
	 * 
	 */
	private void fill_Textfielder() {
		for (Team team : team_list) {
			if (player.getTeamId() == team.getId()) {
				comboBox_Team.setSelectedItem(team);
			}
		}

		textField_Id.setText(String.valueOf(player.getId()));
		textField_Name.setText(player.getName());
		textField_Vorname.setText(player.getVorname());
		textField_Marktwert.setText(String.valueOf(player.getMarktwert()));
	}

	protected void do_button_Ende_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		try {
			playerDao = new PlayerDaoSqlite2();
			player = playerDao.readPlayer_last();
			fill_Textfielder();
		} catch (DaoException2 e2) {
			showErorrMessage(e2.getMessage());
		}
	}

	protected void do_button_Vorher_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		try {
			playerDao = new PlayerDaoSqlite2();
			player = playerDao.player_vor(player);
			fill_Textfielder();

		} catch (DaoException2 e2) {
			showErorrMessage(e2.getMessage());
		}

	}

	protected void do_button_Nachher_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		try {
			playerDao = new PlayerDaoSqlite2();
			player = playerDao.player_nach(player);
			fill_Textfielder();

		} catch (DaoException2 e2) {
			showErorrMessage(e2.getMessage());
		}

	}

	protected void do_button_Beenden_actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	protected void do_newButtonButton_6_actionPerformed(ActionEvent e) {
		leeren();
		
		textField_Gesamtwert.setText("");
	}

	protected void do_playerBearbeitenButton_actionPerformed(ActionEvent e) {
		Dialog_Player dialog_Player = new Dialog_Player();
		dialog_Player.setModal(true);
		dialog_Player.setVisible(true);

	}

	protected void do_newButtonButton_actionPerformed(ActionEvent e) {
		Dialog_Team dialog_Team = new Dialog_Team();
		dialog_Team.setModal(true);
		dialog_Team.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == newLabelLabel_1) {
			do_newLabelLabel_1_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_newLabelLabel_1_mouseClicked(MouseEvent e) {
		System.exit(0);
		

	}

	protected void do_button_Hinzufuegen_actionPerformed(ActionEvent e) {

		if (!textField_Id.getText().equals("") || !textField_Name.getText().equals("")
				|| !textField_Vorname.getText().equals("") || !textField_Marktwert.getText().equals("")) {

			list_Model.addElement(player.getName() + ", " + player.getVorname() + ", " + player.getMarktwert());
			gesamtMarktWert = gesamtMarktWert + player.getMarktwert();
			fill_GesamtMarkt_textfield();

			gesamtwert_List.add(player.getMarktwert());
			
		} else {
			showErorrMessage("Sie haben keinen Player ausgesucht");
		}
		list_init();
	}

	protected void do_button_Loeschen_actionPerformed(ActionEvent e) {
		if (list.getSelectedIndex() != -1) {

			double selected_marktwert = (double) gesamtwert_List.get(list.getSelectedIndex());
			gesamtwert_List.remove(list.getSelectedIndex());
			list_Model.removeElementAt(list.getSelectedIndex());
			gesamtMarktWert = gesamtMarktWert - selected_marktwert;

			fill_GesamtMarkt_textfield();
		} else {
			showErorrMessage("bitte ermiteln sie ein wert von der List");
		}
		list_init();
	}

	/**
	 * 
	 */
	private void fill_GesamtMarkt_textfield() {
		textField_Gesamtwert.setText(String.valueOf(Math.round(gesamtMarktWert * 100.) / 100.));
	}
	}
