package Patrol.utilities;

import java.io.File;
import java.io.IOException;

public class FilePathUtil {
//	public static String getAbsolutePath(String filePath) {
//        File file = new File(filePath);
//        return file.getAbsolutePath();
//    }
	public static String getAbsolutePath(String filePath) {
	    try {
	        File file = new File(filePath);
	        return file.getCanonicalPath(); // This removes redundant elements like "./"
	    } catch (IOException e) {
	        throw new RuntimeException("Failed to get canonical path: " + filePath, e);
	    }
	}

}