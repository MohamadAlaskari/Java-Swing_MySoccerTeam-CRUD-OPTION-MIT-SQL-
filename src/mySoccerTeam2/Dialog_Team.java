package mySoccerTeam2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Dialog_Team extends JDialog implements MouseListener  {
	private JLabel newLabelLabel;
	private JLabel idLabel;
	private JPanel panel;
	private JTextField textField;
	private JPanel panel_SideBar;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton Button_Suchen;
	private JButton button_Ubdate;
	private JButton button_Aendern;
	private JButton button_Loeschen;
	private JLabel newLabelLabel_1;
	private JTextField textField_1;
	private JLabel newLabelLabel_2;
	private JLabel newLabelLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_Team dialog = new Dialog_Team();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_Team() {
		initGUI();
	}
	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Users\\M_Ala\\eclipse-workspace\\JavaSwing\\src\\MySoccerTeam2\\Fotos\\fussball-ball.png"));
		setTitle("Teams Bearbeiten");
		getContentPane().setBackground(new Color(47, 79, 79));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setBounds(100, 100, 450, 260);
		getContentPane().setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(47, 79, 79));
			panel.setBounds(116, 0, 320, 225);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				idLabel = new JLabel("Id");
				idLabel.setForeground(Color.WHITE);
				idLabel.setBounds(20, 86, 95, 22);
				panel.add(idLabel);
				idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				newLabelLabel = new JLabel("Team");
				newLabelLabel.setForeground(Color.WHITE);
				newLabelLabel.setBounds(20, 122, 95, 22);
				panel.add(newLabelLabel);
				newLabelLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				textField = new JTextField();
				textField.setBounds(147, 125, 143, 22);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(147, 89, 143, 22);
				panel.add(textField_1);
			}
			{
				newLabelLabel_3 = new JLabel("");
				newLabelLabel_3.setIcon(new ImageIcon("D:\\Users\\M_Ala\\eclipse-workspace\\JavaSwing\\src\\MySoccerTeam2\\Fotos\\fussball-ball.png"));
				newLabelLabel_3.setBounds(-97, 0, 417, 225);
				panel.add(newLabelLabel_3);
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
					newLabelLabel_1 = new JLabel("");
					newLabelLabel_1.setBounds(0, 0, 117, 63);
					panel_1.add(newLabelLabel_1);
					newLabelLabel_1.setIcon(new ImageIcon("C:\\Users\\M_Ala\\Pictures\\Logo Alaskari Coding\\KLEIN LOGO.png"));
				}
				{
					newLabelLabel_2 = new JLabel("Teams");
					newLabelLabel_2.setBounds(0, 12, 118, 27);
					panel_1.add(newLabelLabel_2);
					newLabelLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					newLabelLabel_2.setHorizontalTextPosition(SwingConstants.LEADING);
					newLabelLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
					newLabelLabel_2.setForeground(new Color(95, 158, 160));
				}
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(null);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(0, 59, 117, 166);
				panel_SideBar.add(scrollPane);
				{
					panel_2 = new JPanel();
					panel_2.setBorder(null);
					panel_2.setBackground(new Color(95, 158, 160));
					scrollPane.setViewportView(panel_2);
					panel_2.setLayout(null);
					{
						panel_3 = new JPanel();
						panel_3.setBackground(new Color(47, 79, 79));
						panel_3.setBounds(0, 22, 115, 22);
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						{
							Button_Suchen = new JButton("Suchen");
							Button_Suchen.setFocusable(false);
							Button_Suchen.setBorder(null);
							Button_Suchen.addMouseListener(this);
							Button_Suchen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							Button_Suchen.setBackground(new Color(95, 158, 160));
							Button_Suchen.setFont(new Font("Tahoma", Font.BOLD, 12));
							Button_Suchen.setForeground(new Color(255, 255, 255));
							Button_Suchen.setBounds(10, 0, 105, 22);
							panel_3.add(Button_Suchen);
						}
					}
					{
						panel_4 = new JPanel();
						panel_4.setBackground(new Color(47, 79, 79));
						panel_4.setBounds(0, 61, 115, 22);
						panel_2.add(panel_4);
						panel_4.setLayout(null);
						{
							button_Ubdate = new JButton("Einf\u00FCgen");
							button_Ubdate.setFocusable(false);
							button_Ubdate.setBorder(null);
							button_Ubdate.addMouseListener(this);
							button_Ubdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Ubdate.setBackground(new Color(95, 158, 160));
							button_Ubdate.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Ubdate.setForeground(new Color(255, 255, 255));
							button_Ubdate.setBounds(10, 0, 105, 22);
							panel_4.add(button_Ubdate);
						}
					}
					{
						panel_5 = new JPanel();
						panel_5.setBackground(new Color(47, 79, 79));
						panel_5.setBounds(0, 100, 115, 22);
						panel_2.add(panel_5);
						panel_5.setLayout(null);
						{
							button_Aendern = new JButton("\u00C4ndern");
							button_Aendern.setFocusable(false);
							button_Aendern.setBorder(null);
							button_Aendern.addMouseListener(this);
							button_Aendern.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Aendern.setBackground(new Color(95, 158, 160));
							button_Aendern.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Aendern.setForeground(new Color(255, 255, 255));
							button_Aendern.setBounds(10, 0, 105, 22);
							panel_5.add(button_Aendern);
						}
					}
					{
						panel_6 = new JPanel();
						panel_6.setBackground(new Color(47, 79, 79));
						panel_6.setBounds(0, 136, 115, 22);
						panel_2.add(panel_6);
						panel_6.setLayout(null);
						{
							button_Loeschen = new JButton("L\u00F6schen");
							button_Loeschen.setFocusable(false);
							button_Loeschen.setBorder(null);
							button_Loeschen.addMouseListener(this);
							button_Loeschen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							button_Loeschen.setBackground(new Color(95, 158, 160));
							button_Loeschen.setFont(new Font("Tahoma", Font.BOLD, 12));
							button_Loeschen.setForeground(new Color(255, 255, 255));
							button_Loeschen.setBounds(10, 0, 105, 22);
							panel_6.add(button_Loeschen);
						}
					}
				}
			}
		}
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
		if (e.getSource() == button_Ubdate) {
			do_button_Ubdate_mouseEntered(e);
		}
		if (e.getSource() == Button_Suchen) {
			do_Button_Suchen_mouseEntered(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		Button_Suchen.setBackground(new Color(95, 158, 160));
		button_Ubdate.setBackground(new Color(95, 158, 160));
		button_Aendern.setBackground(new Color(95, 158, 160));
		button_Loeschen.setBackground(new Color(95, 158, 160));

		


	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_Button_Suchen_mouseEntered(MouseEvent e) {
		Button_Suchen.setBackground(new Color(0, 128, 128));

		
	}
	protected void do_button_Ubdate_mouseEntered(MouseEvent e) {
		button_Ubdate.setBackground(new Color(0, 128, 128));

	}
	protected void do_button_Aendern_mouseEntered(MouseEvent e) {
		button_Aendern.setBackground(new Color(0, 128, 128));

	}
	protected void do_button_Loeschen_mouseEntered(MouseEvent e) {
		button_Loeschen.setBackground(new Color(0, 128, 128));

	}
}
