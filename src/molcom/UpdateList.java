package molcom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class UpdateList {
	
	void addName(String newName) {
		try {
		ObjectInputStream in= new ObjectInputStream(
					new FileInputStream(StartProg.storeName));
			ArrayList<String> currentList = (ArrayList<String>) in.readObject();
			currentList.add(newName);
			
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(StartProg.storeName));
			out.writeObject(currentList);
			out.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void delName(String newName) {
		try {
		ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(StartProg.storeName));
			ArrayList<String> currentList = (ArrayList<String>) in.readObject();
			Iterator<String> iter = currentList.iterator();
			while (iter.hasNext()) {
			        String s = iter.next();		 
			        if (s.equals(newName)) {
			                iter.remove();
			        }
			}
			
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(StartProg.storeName));
			out.writeObject(currentList);
			out.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
