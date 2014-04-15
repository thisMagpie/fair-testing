/**
 * ArrayTool.java
 * ================
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

class ArrayTool {

   /**
    * @initArray
    *
    * @param length
    *
    *
    * @return
    *               Initialised 2D integer array
    */
    public static int[][] initArray(int length){
        return new int[length][length];
    }

   /**
    * @multiply
    *               Function to multiply array
    *
    * @param
    *
    *
    * @return
    *
    */
    public static double[] multiply(double[] data, double value) {
        for (int i = 0; i < data.length; i++) {
            data[i] *= value;
            System.out.println("CHECK "+ data[i]);
        }
        return data;
    }
}
