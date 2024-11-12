package btnhom_QLCHTL;

import javax.swing.SwingUtilities;

import nopBaiSach.Regex_QLSach.FrmDanhMucSach;

public class Starting {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrmDanhMucSach frm = new FrmDanhMucSach();
				frm.setVisible(true);
			}
		});
	}
}