package com.study.bbs;
 
import java.io.File;
 
public class UploadCk {
  public static synchronized String getUploadDir() {
    String path = "";
    if (File.separator.equals("\\")) {
      path = "C:\\deploy\\ckstorage";
      System.out.println("Windows 10: " + path);
 
    } else {
      // System.out.println("Linux");
      path = "/home/ubuntu/deploy/ckstorage/";
    }
 
    return path;
  }
}