package AcidRain;

import javax.swing.JOptionPane;

public class WarningDialog extends JOptionPane {

	public void Warningdialog() {
		showMessageDialog(null, "��� ��ĭ�� ä���ֽʽÿ�.");
	}

	public void PWdialog() {
		showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
	}

	public void IDdialog() {
		showMessageDialog(null, "ID�� �����ϴ�.");
	}
	
	public void Logindialog()
	{
		showMessageDialog(null, "ID�� ��й�ȣ �� �� �Է����ּ���");
	}
	
	public void PWnotequaltdialog()
	{
		showMessageDialog(null, "��й�ȣ�� ���� �ʽ��ϴ�.");
	}

}
