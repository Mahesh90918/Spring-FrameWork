package com.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

public class JsonFileReading2 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "src/main/java/com/gson/Employee.json";
		FileReader file;
		try {
			// 1.way Read
			file = new FileReader(json);
			ArrayList json2 = gson.fromJson(file, ArrayList.class);
			System.out.println(json2);
			System.out.println("==========");
			ArrayList al = new ArrayList<>(json2);
			Iterator i = al.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			System.out.println("------------------");
			ArrayList al2 = new ArrayList<>(json2);
			for (Object employee : al2) {
				System.out.println(employee);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
