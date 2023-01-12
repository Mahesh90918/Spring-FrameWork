package com.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class JsonFileReading {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "src/main/java/com/gson/Employee.json";
		FileReader file;
		try {
			// 1.way Read
			file = new FileReader(json);
			JsonElement json1 = gson.fromJson(file, JsonElement.class);
			System.out.println(json1);
			System.out.println("=============");
			
			ArrayList json2 = gson.fromJson(file, ArrayList.class);
			ArrayList al=new ArrayList<>(json2);
			Iterator i = al.iterator();
			while (i.hasNext() ) {
				System.out.println(i.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
