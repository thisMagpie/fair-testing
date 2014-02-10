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

public class ArrayIOUtil extends IOUtil{

    public static void printDoubles(double[] data) {
         for (int i=1; i < data.length + 1; i++){
            System.out.println(i + " " + data[i - 1]);
        }
    }

    public static void writeDoubles(PrintWriter printToFile, double[] data){
        for (int i = 1; i< data.length + 1; i++){
            printToFile.write(i + " " + data[i - 1]+"\r\n");
        }
        printToFile.close();
    }
}
