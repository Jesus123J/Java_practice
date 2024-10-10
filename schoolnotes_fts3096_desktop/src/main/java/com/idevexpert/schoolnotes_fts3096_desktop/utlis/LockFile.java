/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.utlis;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public abstract class LockFile {

    public static final String LOCK_FILE_PATH = "myapp.lock";
    private static boolean running = true; // Indicador para el hilo de monitoreo

    // Método para verificar si el archivo de bloqueo ya existe
    public static void deleteFile() {
        Path path = Paths.get(LOCK_FILE_PATH);

        try {
            if (Files.exists(path)) {
                // Si el archivo es de solo lectura, primero quitar esa propiedad
                File lockFile = path.toFile();
                if (!lockFile.canWrite()) {
                    lockFile.setWritable(true); // Cambiar permisos antes de eliminar
                }

                Files.delete(path);
                System.out.println("Archivo de bloqueo eliminado correctamente.");
            } else {
                System.out.println("El archivo de bloqueo no existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar el archivo de bloqueo: " + e.getMessage());
        }
    }

    public static boolean checkLockFile() {
        File lockFile = new File(LOCK_FILE_PATH);

        // Verifica si el archivo existe
        if (lockFile.exists()) {
            // Comprobamos que tenga permisos de lectura
            if (!lockFile.canRead()) {
                System.err.println("No tienes permiso para leer el archivo de bloqueo.");
                return false;
            }

            // Comprobamos si está marcado como solo lectura (opcional)
            if (!lockFile.canWrite()) {
                System.out.println("El archivo de bloqueo está protegido.");
            }

            return true;
        }

        // El archivo no existe, por lo que no debería abrirse la aplicación
        return false;
    }

    // Método para crear el archivo de bloqueo y marcarlo como solo lectura
    public static void createLockFile() {
        Path path = Paths.get(LOCK_FILE_PATH);

        // Verificar si el archivo ya existe
        if (Files.exists(path)) {
            System.out.println("El archivo de bloqueo ya existe.");
            return;
        }

        try {
            // Crear el archivo
            Files.createFile(path);
            System.out.println("Archivo de bloqueo creado correctamente.");

            // Marcar el archivo como solo lectura para que no pueda ser eliminado o modificado
            File lockFile = path.toFile();
            if (lockFile.setReadOnly()) {
                System.out.println("El archivo ha sido marcado como solo lectura.");
            } else {
                System.err.println("No se pudo marcar el archivo como solo lectura.");
            }

        } catch (IOException e) {
            System.err.println("Error al crear el archivo de bloqueo: " + e.getMessage());
        }
    }

    // Método para monitorear si el archivo es eliminado y recrearlo si es necesario
    public static void startLockFileMonitor() {
        new Thread(() -> {
            while (running) {
                try {
                    File lockFile = new File(LOCK_FILE_PATH);

                    // Si el archivo no existe, lo recreamos
                    if (!lockFile.exists()) {
                        System.out.println("El archivo de bloqueo fue eliminado. Volviendo a crear...");
                        createLockFile();
                    }

                    // Pausa breve antes de la próxima verificación
                    Thread.sleep(2000); // Verifica cada 2 segundos

                } catch (InterruptedException e) {
                    System.err.println("Error en el hilo de monitoreo: " + e.getMessage());
                }
            }
        }).start();
    }

    // Método para detener el hilo de monitoreo cuando la aplicación se cierre
    public static void stopLockFileMonitor() {
        running = false;
    }
}
