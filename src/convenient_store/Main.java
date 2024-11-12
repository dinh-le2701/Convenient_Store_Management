package convenient_store;

import convenient_store.dto.DBConnect;
import convenient_store.gui.Home_Gui;
import convenient_store.gui.Login_Gui;

public class Main {
	public static DBConnect connection = new DBConnect();
	public static void main(String[] args) {
//		new Login_Gui();
		new Home_Gui();
		connection.getConnection();
	}
}
