/**
 * ArrayIOUtil.java
 * ==============
 *
 * This file is a part of a program which serves as a utility for prediction
 * and data analysis of experimental and simulated data
 *
 * Copyright (C) 2014 Magdalen Berns <m.berns@sms.ed.ac.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.*;
import java.util.Scanner;

public class ArrayIOUtil extends IOUtil{

    public static void printDoubles(double[] data) {
         for (int i=1; i < data.length + 1; i++){
            System.out.println(i + " " + data[i - 1]);
        }
    }

    public static void writeDoubles(PrintWriter toFile, double[] data){
        for (int i = 1; i< data.length + 1; i++){
            toFile.write(i + " " + data[i - 1]+"\r\n");
        }
        toFile.close();
    }

    public static void writeDoubles(PrintWriter toFile, double[][] data){
        for(int i=0; i<data.length;i++){
            toFile.printf("%2.5f %2.5f", data[i][0], data[i][1]);
            toFile.println();
        }
    }

    public static double[] readDoubles(Scanner scanned, int length){
        double[] data=new double[length];
        for (int i=0;i<data.length;i++) data[i] = IOUtil.skipToDouble(scanned);
        return data;
    }

    public static double[][] readDoubles(Scanner scanned, int length, int numberOfColumns){
        double[][] data = new double[length][numberOfColumns];
        for (int i=0;i<data.length;i++){
            for (int j=0;j<data[0].length;j++){
                data[i][j] = IOUtil.skipToDouble(scanned); //TODO check
            }
        }
        return data;
    }

    public static int[][] initArray(int length){
        return new int[length][length];
    }
}
