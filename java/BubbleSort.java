/**
* BubbleSort.java
* ===============
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

    public static int[] Ints(int[] data){
        int temp = 0;
        //TODO remove later unsorted array for debugging
        for(int i=0; i<data.length; i++){
            System.out.print(" " + data[i]);
        }

        //Sort Array
        for(int i=1; i<data.length; i++) {
            for(int j=data.length-1; j>=i; j--){

                if(data[j-1]> data[j]){
                    temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }

        //Print Sorted Array TODO remove later
        for(int i =0; i< data.length; i++){
            System.out.print(" " + data[i]);
        }
        return data; //return ... duh!
    }

    public static double[] Doubles(double[] data){
        double temp = 0.0;
        //TODO remove later unsorted array for debugging
        for(int i=0; i<data.length; i++){
            System.out.print(" " + data[i]);
        }

        //Sort Array
        for(int i=1; i<data.length; i++) {
            for(int j=data.length-1; j>=i; j--){

                if(data[j-1]> data[j]){
                    temp = data[j-1];
                    data[j-1] = data[j];
                    data[j] = temp;
                }
            }
        }

        //Print Sorted Array TODO remove later
        for(int i =0; i< data.length; i++){
            System.out.println(i + "    " + data[i] + "\n");
        }
        return data;
    }
}

