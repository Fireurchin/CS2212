package statsVisualiser.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
	private static String dataUser, dataPass;
	JPanel panel;
	JLabel labelUser, labelPass;
	JTextField enterUser = new JTextField();
	JPasswordField enterPass = new JPasswordField();
	JButton login, cancel;

	Login() {
		labelUser = new JLabel("Username:");
		labelPass = new JLabel("Password:");
		login = new JButton("Login");
		cancel = new JButton("Cancel");
		createGrid(labelUser, labelPass, enterUser, enterPass, login, cancel);
	}

	public static void main(String[] args) {
		new Login();
	}

	public void createGrid(JLabel userLabel, JLabel passLabel, JTextField userText, JPasswordField passText,
			JButton enter, JButton end) {
		panel = new JPanel(new GridLayout(3, 1));
		panel.add(userLabel);
		panel.add(userText);
		panel.add(passLabel);
		panel.add(passText);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.add(end);
		panel.add(enter);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginTest(e);
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(panel, BorderLayout.CENTER);
		setSize(400, 140);
		setVisible(true);
	}

	public void loginTest(ActionEvent ae) {
		if (!authenticate(enterUser.getText(), enterPass.getText()))
			System.out.println("Incorrect Sign In Detected");
		else
			System.out.println("Welcome User: " + dataUser);
	}

	public static boolean authenticate(String username, String password) {
		return (username.equals(dataUser) && password.equals(dataPass));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}