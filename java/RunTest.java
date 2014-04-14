/**
 * RunTest.java
 * ==============
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

import java.util.Scanner;
import java.io.*;

public class RunTest{

    public static void main(String[] argsv) throws IOException, FileNotFoundException {
        Scanner scanEach = new Scanner(new BufferedReader(new FileReader("input/input-params.dat")));

        int numberOfTrials = IOUtil.skipToInt(scanEach);
        int meanScore = IOUtil.skipToInt(scanEach);
        double standardDeviation = IOUtil.skipToDouble(scanEach);
        double estimatedError = IOUtil.skipToDouble(scanEach);
        double errorOnEach = ProbabilityUtil.percentErrorEstimate(estimatedError, meanScore);

        double[] rawResult = ProbabilityUtil.predictedScores(errorOnEach, numberOfTrials, meanScore);
        ArrayIOUtil.writeDoubles(new PrintWriter("output/one/raw-output.dat"), rawResult);

        StatsUtil.mean(rawResult);
        double variance = StatsUtil.variance(rawResult, meanScore);

        double[] gaussianRaw = StatsUtil.gaussian(numberOfTrials, variance, meanScore);
        ArrayIOUtil.writeDoubles(new PrintWriter("output/one/gaussian.dat"), gaussianRaw);
        double sum = 0.0;
        for(int i = 1; i < gaussianRaw.length; i++) {
              System.out.println(i + " " + gaussianRaw[i]);
              sum+=gaussianRaw[i];
        }
        System.out.println("\nSum = " + sum + "\n");
    }
}
