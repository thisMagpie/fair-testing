/**
 * RunTest.java
 * ============
 *
 * This file is a part of a program which serves as a utility for prediction
 * and data analysis of experimental and simulated data
 *
 * Copyright (C) 2014 Magdalen Berns <m.berns@sms.ed.ac.uk>
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.*;
import java.util.Scanner;

public class RunTest {

    public static void main(String[] argsv) throws IOException, FileNotFoundException {
        String population = "/recorded-population-grades.dat";
        Scanner scan = IOUtil.scanFrom("input" + population);

        //retrieve scanner and length of data range of results
        // which has already been indicated in input file
        double[] recordedPopulationResults = ArrayIOUtil.readDoubles(scan, IOUtil.skipToInt(scan));
        writeDistribution(IOUtil.writeTo("output" + population), recordedPopulationResults);
        ArrayIOUtil.printDoubles(recordedPopulationResults);
    }

    public static void writeDistribution(PrintWriter writeTo, double data[]) {
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
        ArrayIOUtil.printDoubles(gaussian); //TODO remove later
    }
}
