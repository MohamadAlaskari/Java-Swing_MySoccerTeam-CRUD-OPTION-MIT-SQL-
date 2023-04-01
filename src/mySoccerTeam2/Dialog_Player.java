package mySoccerTeam2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_Player extends JDialog implements MouseListener, ActionListener {
	////////////////////////// panel_SideBar ///////////////////////////////////////

	private JPanel panel_SideBar;
	private JPanel panel_1;
	private JPanel panel_Sidbare_Menue;
	private JScrollPane scrollPane;
	private JPanel panel_li_1;
	private JPanel panel_li_2;
	private JPanel panel_li_3;
	private JPanel panel_li_4;
	private JButton Button_Suchen;
	private JButton button_Einfuegen;
	private JButton button_Aendern;
	private JButton button_Loeschen;
	private JLabel label_Logo;
	private JLabel label_player;
	///////////////// panel_PlayerSection ///////////////////////
	///////////////// ///////////////////////////////////////
	private JLabel label_Image_Hintergrund;
	private JPanel panel_PlayerSection;
	private JLabel label_Team;
	private JLabel label_Id;
	private JLabel label_Name;
	private JLabel label_Vorname;
	private JLabel label_MarktWert;
	private JTextField textField_Id;
	private JTextField textField_Name;
	private JTextField textField_Vorname;
	private JTextField textField_MarktWert;
	private JComboBox<Team> comboBox_Team;
	////////////////////////// Variable ///////////////////////////////////////
	private Team team;
	private TeamArtDaoSqlite2 team_Dao;
	private ArrayList<Team> team_List;
	private Player player;
	private PlayerDaoSqlite2 player_Dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_Player dialog = new Dialog_Player();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_Player() {
		initGUI();
		init();
	}

	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Users\\M_Ala\\eclipse-workspace\\JavaSwing\\src\\MySoccerTeam2\\Fotos\\fussballspieler-mit-ball.png"));
		setTitle("Players Bearbeiten");
		getContentPane().setBackground(new Color(47, 79, 79));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setBounds(100, 100, 450, 260);
		getContentPane().setLayout(null);
		{
			panel_PlayerSection = new JPanel();
			panel_PlayerSection.setBackground(new Color(47, 79, 79));
			panel_PlayerSection.setBounds(127, 0, 309, 225);
			getContentPane().add(panel_PlayerSection);
			panel_PlayerSection.setLayout(null);
			{
				label_Id = new JLabel("Id");
				label_Id.setForeground(Color.WHITE);
				label_Id.setBounds(10, 68, 95, 22);
				panel_PlayerSection.add(label_Id);
				label_Id.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				label_Name = new JLabel("Name");
				label_Name.setForeground(Color.WHITE);
				label_Name.setBounds(10, 109, 95, 22);
				panel_PlayerSection.add(label_Name);
				label_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				label_Vorname = new JLabel("Vorname");
				label_Vorname.setForeground(Color.WHITE);
				label_Vorname.setBounds(10, 151, 95, 22);
				panel_PlayerSection.add(label_Vorname);
				label_Vorname.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				label_MarktWert = new JLabel("Marktswert");
				label_MarktWert.setForeground(Color.WHITE);
				label_MarktWert.setBounds(10, 190, 95, 22);
				panel_PlayerSection.add(label_MarktWert);
				label_MarktWert.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				label_Team = new JLabel("Team");
				label_Team.setForeground(Color.WHITE);
				label_Team.setBounds(10, 26, 95, 22);
				panel_PlayerSection.add(label_Team);
				label_Team.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				textField_Id = new JTextField();
				textField_Id.setBounds(137, 68, 143, 22);
				panel_PlayerSection.add(textField_Id);
				textField_Id.setColumns(10);
			}
			{
				textField_Name = new JTextField();
				textField_Name.setColumns(10);
				textField_Name.setBounds(137, 113, 143, 22);
				panel_PlayerSection.add(textField_Name);
			}
			{
				textField_Vorname = new JTextField();
				textField_Vorname.setColumns(10);
				textField_Vorname.setBounds(137, 155, 143, 22);
				panel_PlayerSection.add(textField_Vorname);
			}
			{
				textField_MarktWert = new JTextField();
				textField_MarktWert.setColumns(10);
				textField_MarktWert.setBounds(137, 193, 143, 22);
				panel_PlayerSection.add(textField_MarktWert);
			}
			{
				comboBox_Team = new JComboBox();
				comboBox_Team.setBounds(137, 28, 143, 22);
				panel_PlayerSection.add(comboBox_Team);
			}
			{
				label_Image_Hintergrund = new JLabel("");
				label_Image_Hintergrund.setBounds(0, 0, 321, 225);
				panel_PlayerSection.add(label_Image_Hintergrund);
				label_Image_Hintergrund.setIcon(new ImageIcon("D:\\Users\\M_Ala\\eclipse-workspace\\JavaSwing\\src\\MySoccerTeam2\\Fotos\\fussball (3).png"));
			}
		}
		{
			panel_SideBar = new JPanel();
			panel_SideBar.setBackground(new Color(0, 128, 128));
			panel_SideBar.setBounds(0, 0, 117, 225);
			getContentPane().add(panel_SideBar);
			panel_SideBar.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.setBackground(new Color(47, 79, 79));
				panel_1.setBounds(0, 0, 117, 63);
				panel_SideBar.add(panel_1);
				panel_1.setLayout(null);
				{
					label_Logo = new JLabel("");
					label_Logo.setBounds(0, 0, 117, 62);
					panel_1.add(label_Logo);
					label_Logo
							.setIcon(new ImageIcon("C:\\Users\\M_Ala\\Pictures\\Logo Alaskari Coding\\KLEIN LOGO.png"));
				}
				{
					label_player = new JLabel("Player");
					label_player.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
					label_player.setForeground(new Color(95, 158, 160));
					label_player.setFocusable(false);
					label_player.setBounds(46, 10, 73, 27);
					panel_1.add(label_player);
				}
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setAutoscrolls(true);
				scrollPane.setViewportBorder(null);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(0, 59, 117, 166);
				panel_SideBar.add(scrollPane);
				{
					panel_Sidbare_Menue = new JPanel();
					panel_Sidbare_Menue.setBorder(null);
					panel_Sidbare_Menue.setBackground(new Color(0, 128, 128));
					scrollPane.setViewportView(panel_Sidbare_Menue);
					panel_Sidbare_Menue.setLayout(null);
					{
						panel_li_1 = new JPanel();
						panel_li_1.setBackground(new Color(47, 79, 79));
						panel_li_1.setBounds(0, 22, 115, 22);
						panel_Sidbare_Menue.add(panel_li_1);
						panel_li_1.setLayout(null);
						{
							Button_Suchen = new JButton("Suchen");
							Button_Suchen.addActionListener(this);
							Button_Suchen.setFocusable(false);
							Button_Suchen.setBorder(null);
							Button_Suchen.addMouseListener(this);
							Button_Suchen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							Button_Suchen.setBackground(new Color(0, 128, 128));
							Button_Suchen.setFont(new Font("Tahoma", Font.BOLD, 12));
							Button_Suchen.setForeground(new Color(255, 255, 255));
							Button_Suchen.setBounds(10, 0, 105, 22);
							panel_li_1.add(Button_Suchen);
						}
					}
					{
						panel_li_2 = new JPanel();
						panel_li_2.setBackground(new Color(47, 79, 79));
						panel_li_2.setBounds(0, 61, 115, 22);
						panel_Sidbare_Menue.add(panel_li_2);
						panel_li_2.setLayout(null);
						{
							button_Einfuegen = new JButton("Einf\u00FCgen");
							button_Einfuegen.addActionListener(this);
							button_Einfuegen.setFocusable(false);
							button_Einfuegen.setBorder(null);
							button_Einfuegen.addMouseListener(this);
							button_Einfuegen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Einfuegen.setBackground(new Color(0, 128, 128));
							button_Einfuegen.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Einfuegen.setForeground(new Color(255, 255, 255));
							button_Einfuegen.setBounds(10, 0, 105, 22);
							panel_li_2.add(button_Einfuegen);
						}
					}
					{
						panel_li_3 = new JPanel();
						panel_li_3.setBackground(new Color(47, 79, 79));
						panel_li_3.setBounds(0, 100, 115, 22);
						panel_Sidbare_Menue.add(panel_li_3);
						panel_li_3.setLayout(null);
						{
							button_Aendern = new JButton("\u00C4ndern");
							button_Aendern.addActionListener(this);
							button_Aendern.setFocusable(false);
							button_Aendern.setBorder(null);
							button_Aendern.addMouseListener(this);
							button_Aendern.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Aendern.setBackground(new Color(0, 128, 128));
							button_Aendern.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Aendern.setForeground(new Color(255, 255, 255));
							button_Aendern.setBounds(10, 0, 105, 22);
							panel_li_3.add(button_Aendern);
						}
					}
					{
						panel_li_4 = new JPanel();
						panel_li_4.setBackground(new Color(47, 79, 79));
						panel_li_4.setBounds(0, 136, 115, 22);
						panel_Sidbare_Menue.add(panel_li_4);
						panel_li_4.setLayout(null);
						{
							button_Loeschen = new JButton("L\u00F6schen");
							button_Loeschen.addActionListener(this);
							button_Loeschen.setFocusable(false);
							button_Loeschen.setBorder(null);
							button_Loeschen.addMouseListener(this);
							button_Loeschen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Loeschen.setBackground(new Color(0, 128, 128));
							button_Loeschen.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Loeschen.setForeground(new Color(255, 255, 255));
							button_Loeschen.setBounds(10, 0, 105, 22);
							panel_li_4.add(button_Loeschen);
						}
					}
				}
			}
		}
	}

	private void showErorrMesage(String message) {
		JOptionPane.showMessageDialog(null, message, "Erorr", JOptionPane.ERROR_MESSAGE);
	}

	private void showInfoMesage(String message) {
		JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void leeren() {
		textField_Id.setText("");
		textField_Name.setText("");
		textField_Vorname.setText("");
		textField_MarktWert.setText("");
		comboBox_Team.setSelectedIndex(0);
	}

	private void comoboBox_ausfullen() throws DaoException2 {
		team_List = new ArrayList<>();
		team_List = team_Dao.read_Team();
		comboBox_Team.removeAllItems();
		for (Team team : team_List) {
			comboBox_Team.addItem(team);

		}
	}

	private void init() {
		try {
			team_Dao = new TeamArtDaoSqlite2();
		} catch (ClassNotFoundException e) {
			showErorrMesage(e.getMessage());
		}
		try {
			comoboBox_ausfullen();
		} catch (DaoException2 e) {
			showErorrMesage(e.getMessage());
		}
		player = new Player();
		leeren();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == button_Loeschen) {
			do_button_Loeschen_mouseEntered(e);
		}
		if (e.getSource() == button_Aendern) {
			do_button_Aendern_mouseEntered(e);
		}
		if (e.getSource() == button_Einfuegen) {
			do_button_Ubdate_mouseEntered(e);
		}
		if (e.getSource() == Button_Suchen) {
			do_Button_Suchen_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {

//////////////
		button_Loeschen.setBackground(new Color(0, 128, 128));
		Button_Suchen.setBackground(new Color(0, 128, 128));
		button_Einfuegen.setBackground(new Color(0, 128, 128));
		button_Aendern.setBackground(new Color(0, 128, 128));

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_Button_Suchen_mouseEntered(MouseEvent e) {
		Button_Suchen.setBackground(new Color(95, 158, 160));

	}

	protected void do_button_Ubdate_mouseEntered(MouseEvent e) {
		button_Einfuegen.setBackground(new Color(95, 158, 160));

	}

	protected void do_button_Aendern_mouseEntered(MouseEvent e) {
		button_Aendern.setBackground(new Color(95, 158, 160));

	}

	protected void do_button_Loeschen_mouseEntered(MouseEvent e) {
		button_Loeschen.setBackground(new Color(95, 158, 160));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_Loeschen) {
			try {
				do_button_Loeschen_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == button_Aendern) {
			try {
				do_button_Aendern_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == Button_Suchen) {
			try {
				do_Button_Suchen_actionPerformed(e);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == button_Einfuegen) {
			try {
				do_button_Einfuegen_actionPerformed(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void do_button_Einfuegen_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		try {
			player_Dao = new PlayerDaoSqlite2();
			player = creat_newplayer();
			player_Dao.insert_Player(player);
			showInfoMesage("Es wurde erfolgreich hinzufügt");

		} catch (DaoException2 e2) {
			showErorrMesage(e2.getMessage());
		}

	}

	private void showPlayer_textfielder_como(Player player) {
		for (Team team : team_List) {
			if (player.getTeamId() == team.getId()) {
				comboBox_Team.setSelectedItem(team);
			}
		}

		textField_Id.setText(String.valueOf(player.getId()));
		textField_Name.setText(player.getName());
		textField_Vorname.setText(player.getVorname());
		textField_MarktWert.setText(String.valueOf(player.getMarktwert()));

	}

	private Player creat_newplayer() {
		try {

			player.setId(Integer.parseInt(textField_Id.getText()));
			player.setName(textField_Name.getText());
			player.setVorname(textField_Vorname.getText());
			player.setMarktwert(Double.parseDouble(textField_MarktWert.getText()));
			player.setTeamId(((Team) comboBox_Team.getSelectedItem()).getId());
		} catch (NumberFormatException e) {
			showErorrMesage("bitte gültige Eingabe eingeben");
		}
		return player;
	}

	protected void do_Button_Suchen_actionPerformed(ActionEvent e)
			throws ClassNotFoundException, NumberFormatException, SQLException {
		try {
			player_Dao = new PlayerDaoSqlite2();
			player = player_Dao.suchen_Player(Integer.parseInt(textField_Id.getText()));
			showPlayer_textfielder_como(player);
		} catch (DaoException2 e2) {
			showErorrMesage(e2.getMessage());
		} catch (NumberFormatException e2) {
			showErorrMesage("bitte gültige Eingabe eingeben");
		}
	}

	protected void do_button_Aendern_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		try {
			player_Dao = new PlayerDaoSqlite2();
			player = creat_newplayer();
			player_Dao.update_Player(player);
			showInfoMesage("Es wurde Erfolgreich geändert werden");
		} catch (DaoException2 e2) {
			showErorrMesage(e2.getMessage());
		}
	}

	private int showQuestionPane() {
		int result = JOptionPane.showConfirmDialog(null, "Möchtest du das sicher löschen", "Confirm Frage",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		return result;
	}

	protected void do_button_Loeschen_actionPerformed(ActionEvent e) throws ClassNotFoundException {

		switch (showQuestionPane()) {
		case JOptionPane.YES_OPTION: {
			try {
				player_Dao = new PlayerDaoSqlite2();
				player = creat_newplayer();
				player_Dao.loeschen_Player(player);
				showInfoMesage("Es wurde Erfolgreich gelöscht werden");
				leeren();
			} catch (DaoException2 e2) {
				showErorrMesage(e2.getMessage());
			}

			break;
		}
		case JOptionPane.NO_OPTION: {
			break;
		}
		}

	}
}
