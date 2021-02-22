package com.siemens;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.siemens.service.CalculationService.minDeletionOfChars;

public class Main {
    private static final Scanner scannerIN = new Scanner(System.in);
    public static void main(String[] args)  {

        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Application is successfully started please enter input file path"+ System.lineSeparator());
        FileWriter writer=null;

        try{
             writer = new FileWriter("src/resources/output.txt",false);
        }catch (IOException e){
            logger.log(Level.SEVERE, "Input-Output Error ", e);
        }

        scannerIN.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int line=1;
        File file = new File(scannerIN.nextLine());
        Scanner scanner=null;

        try {
            scanner= new Scanner(file);
        }catch (FileNotFoundException e){
            logger.log(Level.SEVERE, "File is not found please check the path. ", e);
        }

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int result=0;

            try {
                 result = minDeletionOfChars(s);
            }catch (Exception e) {
                logger.log(Level.SEVERE, "Input file has invalid input string at line : "+ line + System.lineSeparator(), e);
                result=Integer.MIN_VALUE;
            }

            try{
                writer.write( line+ "- "+result + System.lineSeparator());
                writer.flush();
            }catch (IOException e){
                logger.log(Level.SEVERE, "Input-Output Error ", e);
            }
            line++;
        }

        logger.log(Level.INFO, "Output file is created under src/resources/output.txt"+ System.lineSeparator());
        scanner.close();
        logger.log(Level.INFO, "Application is closing ...");

    }
}
