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

    public static void main(String[] argsv) throws IOException,
                                                   FileNotFoundException {

        String input                                    = "input/";
        String output                                   = "../latex/data";
        String population                               = "recorded-population-grades.dat";
        Scanner scanPopulation                          = IOUtil.scanFrom(population);

        PrintWriter outputPopulation                    = new PrintWriter(output + "population.dat");
        PrintWriter outputMaster10                      = new PrintWriter(output + "master10.dat");

        String master10Credits                          = "recorded-individual-master.dat";
        String master20Credits                          = "recorded-individual-master-20.dat";
        Scanner scanMaster10                            = IOUtil.scanFrom(master10Credits);
        Scanner scanMaster20                            = IOUtil.scanFrom(master20Credits);

        //retrieve scanner and length
        double[] recordedPopulationResults = ArrayIOUtil.readDoubles(scanPopulation,
                                                                     IOUtil.skipToInt(scanPopulation));
        double[] recordedMasterResults = ArrayIOUtil.readDoubles(scanPopulation,
                                                                 IOUtil.skipToInt(scanMaster10));

        // write out results and print to terminal and concatinate to organise output file dir location
        writeDistribution(outputPopulation, recordedPopulationResults);
        writeDistribution(outputMaster10, recordedMasterResults);
    }

    public static void writeDistribution(PrintWriter writeTo, double data[]) { //TODO give it a class
        double mean                 = StatsUtil.mean(data);
        double variance             = StatsUtil.variance(data, mean);
        double standardDeviation    = StatsUtil.standardDeviation(
                                                        variance,
                                                        data.length);

        double[] gaussian = StatsUtil.gaussian(data.length, variance, mean);

        System.out.println("The full data range\nMean =" +
                            mean +"\nVariance = " +
                            variance + "\nStandard Deviation " +
                            standardDeviation);

        ArrayIOUtil.writeDoubles(writeTo, gaussian);
        ArrayIOUtil.printDoubles(gaussian);
    }
}
