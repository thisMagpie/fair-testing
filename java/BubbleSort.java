/**
* Copyright (C) 2014  Magdalen Berns
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

public class BubbleSort {

/**
 * Bubblesort class for performing bubblesort through data to arrange in order
 * of size.
 *
 * This file is a part of a program which serves as a utility for prediction and
 * data analysis of experimental and simulated data Test Class to run Simulation
 * of system of fair trials.
 *
 * @author Magdalen Berns
 * @version 1.0
 * @since 1.0
 */

   /**
    * intSort
    *               Function to sort each element of a 1D array of ints in order of size
    *
    * @param data
    *               1D int array of data to be sorted
    * @return
    *               return sorted 1D array of ints
    *
    */
    public static int[] intSort(int[] data){
        int temp = 0;

        for(int i=1; i<data.length; i++) {
            for(int j=data.length-1; j>=i; j--){

                if(data[j-1]> data[j]){
                    temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data; //return ... duh!
    }

   /**
    * doubleSort
    *               Function to sort each element of a 1D array of doubles in order of size
    *
    * @param data
    *               1D double array of data to be sorted
    * @return
    *               return sorted 1D array of doubles
    *
    */
    public static double[] doubleSort(double[] data){
        double temp = 0.0;

        for(int i=1; i < data.length; i++) {
            for(int j=data.length-1; j>= i; j--) {
                if(data[j-1] > data[j]) {
                    temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }
}
