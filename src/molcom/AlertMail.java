package molcom;

import java.util.ArrayList;

public class AlertMail {
	public void SendMail(String newFile,String theme){
		
		ArrayList<String> ListEmail = new ArrayList<String>();
		
		ListEmail.add("roman.zavelev@molcom.ru");
		ListEmail.add("valeria.aleshina@molcom.ru");
		ListEmail.add("Irina.Astakhova@molcom.ru");
		ListEmail.add("nikolay.vasiliev@molcom.ru");
		ListEmail.add("tatiana.orlova@molcom.ru");
		ListEmail.add("yuliya.smorchkova@molcom.ru");
		
		Sender mail = new Sender();
	    mail.send("Изменение электронного архива. " + theme + ".",
	    		theme + ": " + newFile, ListEmail);
	}
	
public void SendMailAdmin(String theme){
		
		ArrayList<String> ListEmail = new ArrayList<String>();
		
		ListEmail.add("roman.zavelev@molcom.ru");
		ListEmail.add("vladislav.voytkevich@molcom.ru");
		
		Sender mail = new Sender();
	    mail.send("Оповещение от системы ListFile !!! ",
	    		theme, ListEmail);
	}
}