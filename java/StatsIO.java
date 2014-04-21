/**
 * Copyright (C) 2012-2014  Magdalen Berns <m.berns@sms.ed.ac.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
 
import java.io.*;
import java.util.Scanner;

public class StatsIO extends IO {

/**
 * StatsIO.java
 *
 * A Utility class for Statistical Operations with Input and Output
 *
 * @author Magdalen Berns
 * @email <m.berns@sms.ed.ac.uk>
 * @version 1.0
 */

    public static void write(String fileName, PrintWriter writeTo, double data[]) {
        int N = data.length;
        double mean                 = Stats.mean(data);
        double s                    = Stats.s(Stats.s2(data, mean));

        double[] gaussian = Stats.gaussian(data, mean);

        System.out.printf("\n\nThe full data range of %s\nmean = %4.2f sigma= %4.2f\n\n",
                           fileName,
                           mean,
                           s
                           );
        int a = - 6;
        double xAxis = a * s;

        for (int i = 0; i < gaussian.length; i++) {
            if (a == 0) a = -1 * a;
                writeTo.write(xAxis +" " + gaussian[i]+ " \n");
                System.out.printf("%4.2f %4.4f \n",xAxis, gaussian[i]);
                a++;
                xAxis = a* s;
                
        }
        writeTo.close();
    }
}
