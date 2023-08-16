/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigos.postales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author CM
 */
public class CodigosPostales {
    public static void main(String[] args) {
       List<String> asentamientos = new ArrayList<>();


        String filePath = "C:\\Users\\CM\\OneDrive\\Escritorio\\Asentamientos.txt";

        try {

            Scanner scanner = new Scanner(new File(filePath));


            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                asentamientos.add(linea);
            }

            scanner.close();


            Map<String, Integer> codigoPostalCount = new HashMap<>();
            for (String asentamiento : asentamientos) {
                String[] parts = asentamiento.split("\t");
                if (parts.length >= 1) {
                    String codigoPostal = parts[0];
                    codigoPostalCount.put(codigoPostal, codigoPostalCount.getOrDefault(codigoPostal, 0) + 1);
                }
            }


            for (Map.Entry<String, Integer> entry : codigoPostalCount.entrySet()) {
                String codigoPostal = entry.getKey();
                int cantidadAsentamientos = entry.getValue();

                System.out.println("Código Postal: " + codigoPostal + " - Cantidad de Asentamientos: " + cantidadAsentamientos);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
    }
    }
    

