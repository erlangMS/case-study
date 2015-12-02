package br.unb.questionario.infra.extension;

import java.util.Date;

public class ValidateFields {
	
	
	public static boolean isDateValid(Date field){
		return (field != null ? true :  false);
	}

	public static boolean compareDate(Date field,Date field02){
		return (field != null && field!=null && field.after(field02) ? true :  false);
	}
	
	public static boolean isFieldStrValid(String field){
		return (field!=null && !field.isEmpty() ? true : false);
	}
	
	public static boolean isFieldObjectValid(Object obj){
		return (obj != null  ? true : false);
		
	}

}
