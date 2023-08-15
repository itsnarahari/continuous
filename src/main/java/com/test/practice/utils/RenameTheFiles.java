package com.test.practice.utils;

import java.io.File;

public class RenameTheFiles {
    public static void main(String[] args) {
        renameFiles();
    }

    public static void renameFiles() {
        String rootFile = "/Users/naraharig/Documents/Music/Music";
        String pattern = "[iSongs.info] 08 - ";
        File dir = new File(rootFile);

        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles()) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (f.getName().startsWith(pattern)) {
                        stringBuilder.append(f.getName());
                        String newName = String.valueOf(stringBuilder.replace(0, pattern.length(), ""));
                        System.out.println(newName);
                        File newfile = new File(String.format("%s/%s", rootFile, newName));
                        System.out.println(newfile.getAbsolutePath());
                        if (f.renameTo(newfile)) {
                            System.out.println("Rename succesful");
                        }

                    }

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }

        }
    }
}
