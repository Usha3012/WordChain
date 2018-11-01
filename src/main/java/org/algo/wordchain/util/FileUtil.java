package org.algo.wordchain.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFile(InputStream file) throws FileNotFoundException, IOException{
    	List<String> dict=new ArrayList<String>();
    	try(BufferedReader reader=new BufferedReader(new InputStreamReader(file));){
    		
    		for (String line; (line = reader.readLine()) != null;) {
    		    if(line!=null&&!line.isEmpty()){
    		    	String[] words=line.split("\\s+");
    		    	for(String word:words){
    		    	    dict.add(word);	
    		    	}
    		    	
    		    }
    		}
    	}
		return dict;
    }
}
