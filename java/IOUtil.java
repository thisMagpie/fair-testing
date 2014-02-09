/**
* IOUtil.java
* ============
* Copyright (C) 2012-2014  Magdalen Berns
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* This file provides a library of static methods for handling common 
* IO requirements.
*/

import java.util.Scanner;
import java.io.*;

public class IOUtil{

    /**
    * skipToDouble
    *                   Method to read only numbers in decimal form from a given input file
    *                   This makes it possible to input data with handy human readable labels 
    * @param scanner
    *                   Scanned characters from an input file
    * @return 
    *                   The first decimal number (separated by spaces) found as a double
    */
    public static double skipToDouble(Scanner scanner){
        while (scanner.hasNext() && !scanner.hasNextDouble()){
            scanner.next();
        }
        return scanner.hasNextDouble() ? scanner.nextDouble() : Double.NaN;
    }

    public static FileReader file(String fileName) throws FileNotFoundException {
        return new FileReader(fileName);
    }
    //read the user input
    public static String typedInput() throws IOException {
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        return keyIn.readLine();
    }

    /**
    * skipToInt
    *                   Method to read only numbers in integer form from a given input file
    *                   This makes it possible to input data with handy human readable labels 
    * @param scanner
    *                   Scanned characters from an input file
    * @return 
    *                   The first integer number (separated by spaces) found as a int
    */
    public static int skipToInt(Scanner scanner) {
        while (scanner.hasNext() && !scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.hasNextInt() ? scanner.nextInt() : (int) Double.NaN;//workaround
    }

    /**
    * Call this every time wrong thing is typed.
    */
    public static void abuse() { //TODO probably wont need this
        System.out.println("Invalid entry.");
        System.out.println("Abusive statement.");
        System.exit(0);
    }

    public static String fileName() throws IOException { //TODO probably wont need this
        System.out.printf("Type file name or hit '!' \n"); 
        String typed= typedInput();
        System.out.printf("Found %s \n", typed); 
        return typed;
    }

    public static String enterValue(String kindOf) { //TODO probably wont need this
        return "Enter " + kindOf + "value:";
    }
}
