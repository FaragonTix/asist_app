
package assistapp;

import java.awt.EventQueue;
import javax.swing.*;

public class mainq {

	
public static void main(String[] args) {
//Person person = new Person();
//person.name="Tom";
//settler.SetToXml(person);
//remover.RemoveFromXml("1");
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				aframe frame = new aframe();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	//reader.GetFromXml();
}


public static int getRandomNumber(int min, int max) {
	max=max+1;
    return (int) ((Math.random() * (max - min)) + min);
}

public static void ShowError() {
	JOptionPane.showMessageDialog(null,
            "Please, fill all fields.",
            "Error",
            JOptionPane.INFORMATION_MESSAGE);
}



	{
}
}