package AcidRain;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.com.show.GameChooseUI;

public class StartFrame extends JFrame implements ActionListener {
	
	public static USER user = new USER();
		
	StartFrame SF;
	Signup SU = new Signup();
	private JPanel Mainpanel;
	private JButton Login, Newmember;
	private JLabel Gamename, name, id, pw;
	private JTextField idtext;
	private JPasswordField pwtext;
	
	
	
	String stid, stpw;

	GameChooseUI chosseUI = new GameChooseUI();

	public StartFrame() {

		setTitle("Sonagi");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Mainpanel = new JPanel();
		setContentPane(Mainpanel);

		Login = new JButton("·Î±×ÀÎ");
		Newmember = new JButton("È¸¿ø°¡ÀÔ");

		Gamename = new JLabel("Á¾¹Î¾¾ÀÇ Àç¹Õ´Â ÇÑ±Û³îÀÌ");
		id = new JLabel("ID : ");
		pw = new JLabel("PW : ");

		idtext = new JTextField();
		pwtext = new JPasswordField();

		idtext.setText("");
		pwtext.setText("");
		pwtext.setEchoChar('*');

		Gamename.setFont(new Font("±Ã¼­", Font.PLAIN, 30));
		id.setFont(new Font("±Ã¼­", Font.PLAIN, 15));
		pw.setFont(new Font("±Ã¼­", Font.PLAIN, 15));

		getContentPane().setLayout(null);

		// button
		Login.setBounds(150, 450, 100, 50);
		Newmember.setBounds(330, 450, 100, 50);

		// JLabel
		Gamename.setBounds(100, 50, 400, 100);
		id.setBounds(81, 196, 100, 20);
		pw.setBounds(81, 269, 100, 20);

		// TextField
		idtext.setBounds(200, 196, 200, 20);
		pwtext.setBounds(200, 269, 200, 20);

		Mainpanel.add(Login);
		Mainpanel.add(Newmember);

		Mainpanel.add(Gamename);
		Mainpanel.add(id);
		Mainpanel.add(pw);

		Mainpanel.add(idtext);
		Mainpanel.add(pwtext);

		Login.addActionListener(this);
		Newmember.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "·Î±×ÀÎ") {

			stid = idtext.getText();
			stpw = pwtext.getText();

			WarningDialog wd = new WarningDialog();

			DataBase database = new DataBase();

			if (stid.length() == 0 || stpw.length() == 0) {
				wd.Logindialog();
			}

			else {
				if (database.Loginselect(stid, stpw) == 1) {
					dispose();
					
					user.setUSER_ID(stid);
					
					chosseUI.showUI();
					// GF.setVisible(true);
				}

				else if (database.Loginselect(stid, stpw) == -1) {
					wd.PWdialog();
					idtext.setText("");
					pwtext.setText("");
				}

				else {
					wd.IDdialog();
					idtext.setText("");
					pwtext.setText("");
				}
			}

		}

		else if (e.getActionCommand() == "È¸¿ø°¡ÀÔ") {
			SU.setVisible(true);
		}
	}
}
