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
 * @author Magdalen Berns
 * @version 1.0
 * @since 1.0
 */

    public static void main(String[] argsv) throws IOException, FileNotFoundException {
        String population = "population-grades.dat";
        Scanner scan = IOUtil.scanFrom("input/recorded-" + population);

        BubbleSort.Doubles(data);

        //retrieve scanner and length
        double[] recordedPopulationResults = ArrayIOUtil.readDoubles(scan, IOUtil.skipToInt(scan));

        writeDistribution(IOUtil.writeTo("population-grades.dat" + population), recordedPopulationResults);
        ArrayIOUtil.printDoubles(recordedPopulationResults);
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
        ArrayIOUtil.printDoubles(gaussian); //TODO remove later. For dbug
    }
}
