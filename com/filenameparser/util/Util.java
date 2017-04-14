package com.filenameparser.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Util {

  public static void copyFile(String sourceFile, String destFile) {
    FileInputStream fis;
    FileOutputStream fos;
    byte[] buffer = new byte[128];
    try {
      fis = new FileInputStream(sourceFile);
      fos = new FileOutputStream(destFile);
      while(fis.read(buffer) != -1) {
        // System.out.println(buffer);
        fos.write(buffer);
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
