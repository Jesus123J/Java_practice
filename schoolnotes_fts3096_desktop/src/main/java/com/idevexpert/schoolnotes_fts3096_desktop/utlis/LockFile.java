/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.utlis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Jesus Gutierrez
 */
public abstract  class LockFile {
    
    
    public static final String LOCK_FILE_PATH = "myapp.lock";

    public static boolean checkLockFile() {
        return new File(LOCK_FILE_PATH).exists();
    }

    public static void fileCreated() {
        try {
            Files.createFile(Paths.get(LOCK_FILE_PATH));
            System.out.println("file created");
        } catch (IOException e) {
            System.out.println("file not created");
        }
    }

    public static void deletedfile() {
        try {
            Files.deleteIfExists(Paths.get(LOCK_FILE_PATH));
        } catch (IOException e) {
            System.err.println("deleted not file");
        }
    }
}
