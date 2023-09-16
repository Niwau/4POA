package pjrSerializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Helicopter heli = new Helicopter("Mil Mi-24", 8000);
		try {
			File f = new File("c:/a/");
			if(!f.exists()) f.mkdir();
			FileOutputStream arqOSer = new FileOutputStream("c:/a/helicopter.ser");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(heli);
			oOSer.close();
			System.out.println("---------------Antes de alterar o modelo -------------");
			System.out.println(heli);
			heli.setModel("Mil Mi-28");
			System.out.println("---------------Depois de alterar o modelo -------------");
			System.out.println(heli);
			FileInputStream arqISer = new FileInputStream("c:/a/helicopter.ser");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			heli = (Helicopter) iOSer.readObject();
			iOSer.close();
			System.out.println("---------------Depois de recuperar os valores-------------");
			System.out.println(heli);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


