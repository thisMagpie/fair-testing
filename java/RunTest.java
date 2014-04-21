/**
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

public class RunTest {

/**
 * This file is a part of a program which serves as a utility for prediction and
 * data analysis of experimental and simulated data Test Class to run Simulation
 * of system of fair trials.
 *
 * @author Magdalen Berns Copyright (C) 2014
 * @email <m.berns@sms.ed.ac.uk>
 * @version 1.0
 */

    public static void main(String[] argsv) throws IOException, FileNotFoundException {
        int N = 24;
        double err = 2.0;

        System.out.printf("Welcome to Magdalen Berns' Honours Algorithm Tester Program.'");
        System.out.printf("Enter mean:\n");
        double mean                                     = Double.parseDouble(IO.typedInput());

        String input                                    = "../latex/data/";
        String output                                   = "../latex/images/";

        String population                               = "population.dat";
        String master                                   = "master.dat";
        String transfer                                 = "transfer.dat";
        String finalYear                                = "finalYear.dat";
        String ordinary                                 = "ordinary.dat";
        String ordinaryPre                              = "ordinarypre.dat";
        String bachelor                                 = "bachelors.dat";
        String phd                                      = "phd.dat";
        String engineer                                 = "engineer.dat";

        StatsIO.write(population, IO.writeTo(output + population),
                                  ArrayIO.readDoubles(IO.scanFrom(input + population), N)
                                 );
        StatsIO.write(master, IO.writeTo(output + master),
                                  ArrayIO.readDoubles(IO.scanFrom(input + master), N)
                                  );
        StatsIO.write(transfer, IO.writeTo(output + transfer),
                                  ArrayIO.readDoubles(IO.scanFrom(input + transfer), N)
                                  );
        StatsIO.write(finalYear, IO.writeTo(output + finalYear),
                                  ArrayIO.readDoubles(IO.scanFrom(input + finalYear), N)
                                  );
        StatsIO.write(ordinary, IO.writeTo(output + ordinary),
                                  ArrayIO.readDoubles(IO.scanFrom(input + ordinary), N)
                                  );
        StatsIO.write(ordinaryPre, IO.writeTo(output + ordinaryPre),
                                  ArrayIO.readDoubles(IO.scanFrom(input + ordinaryPre), N)
                                  );
        StatsIO.write(bachelor, IO.writeTo(output + bachelor),
                                  ArrayIO.readDoubles(IO.scanFrom(input + bachelor), N)
                                  );
        StatsIO.write(phd, IO.writeTo(output + phd),
                                  ArrayIO.readDoubles(IO.scanFrom(input + phd), N)
                                  );
        StatsIO.write(engineer, IO.writeTo(output + engineer),
                                  ArrayIO.readDoubles(IO.scanFrom(input + engineer), N)
                                  );

        double variances                                = 0.0;
        
        double[] score                                  = new double[N];
        System.out.print("\n\nModelled Averages\n\n");
        for (int i=0; i < N; i++){
            variances =  err * Math.random();
            if(Math.random() >0.49) {
                variances = -1.0 * variances;

            }
            score[i] = mean + variances;
            System.out.print(score[i] + " \n");
        }
        StatsIO.write("Model", IO.writeTo(output + "model.dat"), score);
    }
}
