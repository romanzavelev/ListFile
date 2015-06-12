package molcom;

import java.io.File;
import java.util.ArrayList;

public class Funcsion {
	public static int namber = 0;
	public static void ListenFolder(String folder,ArrayList<String> fileNames) {
		try {
			for (File file : new File(folder).listFiles()) {
				String tecName = file.getAbsolutePath();
				if (fileNames.contains(tecName)){
				 return;	
				}
				fileNames.add(tecName);
				//System.out.println(tecName);
				if (file.isDirectory()){
					Funcsion.ListenFolder(tecName,fileNames);
				}	
				}	
			}
		 catch (Exception e) {
			// TODO: handle exception
		}	
	  }
	}

