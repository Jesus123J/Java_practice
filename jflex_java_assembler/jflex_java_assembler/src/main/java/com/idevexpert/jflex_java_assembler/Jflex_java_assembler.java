/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.idevexpert.jflex_java_assembler;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jesus Gutierrez
 */
public class Jflex_java_assembler {

    public static void main(String[] args) {
       String ruta = "C:/Users/Jesus Gutierrez/Documents/WorkSpace/jflex_java_assembler/jflex_java_assembler/src/main/java/com/idevexpert/jflex_java_assembler";
       generarLexer(ruta);

//        Lexer lexer = new Lexer(new FileReader("path/to/your/input.asm"));
//        while (true) {
//            Token token = lexer.yylex();
//            if (token == null) {
//                break;
//            }
//            System.out.println(token);
//        }
    }

    private static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
