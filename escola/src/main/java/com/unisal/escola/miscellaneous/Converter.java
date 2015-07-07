package com.unisal.escola.miscellaneous;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
	public static Date StringToDate(String dataString){
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date data = new Date();
		try{
			data = (Date)formatter.parse(dataString);  
		}catch(ParseException e){
			return null;
		}
		
		return data; 
	}
}
