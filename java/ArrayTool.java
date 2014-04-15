/**
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
    * multiply
    *               Function to multiply each element of a 1D array of doubles to analysis
    *               single double instance value.and then return a 1D array of the result
    *
    * @param
    *               Multiply elements of array by a double instance
    * @return
    *               return 1D array of doubles
    *
    */
    public static double[] multiply(double[] data, double value) {
        for (int i = 0; i < data.length; i++) {
            data[i] *= value;
            System.out.println("CHECK "+ data[i]);//TODO remove later
        }
        return data;
    }
}
