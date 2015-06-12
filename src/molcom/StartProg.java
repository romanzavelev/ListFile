package molcom;

/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author zavelev_ri
 *
 */
public class StartProg {

	/**
	 * @param args
	 */
	public static ArrayList<String> fileNames = new ArrayList<String>();
	public static String storeName = "//mlc98/JavaSoft/ListFile/ListName.xml";

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		
		System.out.println("Start: " + new Date());
		String folderStart = "//mlc19/Служебные документы/Файлы контрагентов";
		File file1 = new File(folderStart);
		if (!file1.exists()) {
			AlertMail AM = new AlertMail();
			AM.SendMailAdmin("Не доступна директория: " + folderStart);
			System.exit(0); 
		}
		if (args[0].equals("start")) {
			System.out.println("start");
			if (file1.exists()) {
				Funcsion.ListenFolder(file1.getPath(), fileNames);
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(storeName));
				out.writeObject(fileNames);
				out.close();
			}
		} else if (args[0].equals("work")) {
			System.out.println("work");
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(storeName));
			ArrayList<String> s = (ArrayList<String>)in.readObject();
			in.close();
			Funcsion.ListenFolder(file1.getPath(), fileNames);
			for (String fn : fileNames) {
				if (!(s.contains(fn))) {
					System.out.println(fn);
					UpdateList UL = new UpdateList();
					UL.addName(fn);

					AlertMail AM = new AlertMail();
					AM.SendMail(fn,"Добавлен файл");
				}
			}
			ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(
					storeName));
			ArrayList<String> s1 = (ArrayList<String>) in1.readObject();
			in.close();
			Funcsion.ListenFolder(file1.getPath(), fileNames);
			for (String fn : s1) {
				if (!(fileNames.contains(fn))) {
					System.out.println(fn);
					UpdateList UL = new UpdateList();
					UL.delName(fn);
					AlertMail AM = new AlertMail();
					AM.SendMail(fn,"Удален файл");
				}
			}
		}
		
		System.out.println("Finish: " + new Date());

	}
}
