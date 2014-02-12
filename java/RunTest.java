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
        PrintWriter printRawDataToFile = new PrintWriter("output/one/raw-output.dat");

        int numberOfTrials = IOUtil.skipToInt(scanEach);
        int estimatedScore = IOUtil.skipToInt(scanEach);

        double estimatedError = IOUtil.skipToDouble(scanEach);

        double errorOnEach = ProbabilityUtil.percentErrorEstimate(estimatedError, estimatedScore);
        double[] rawResult = ProbabilityUtil.predictedScores(errorOnEach, numberOfTrials, estimatedScore);

        ArrayIOUtil.writeDoubles(printRawDataToFile, rawResult);

        // Gaussian Stuff
        PrintWriter printGaussianToFile = new PrintWriter("output/one/gaussian.dat");

        double mean = StatsUtil.mean(rawResult);
        double variance = StatsUtil.variance(rawResult, mean);
        double[] gaussianRaw = StatsUtil.gaussian(numberOfTrials, variance, mean);

        int count = 0;

        for(int i=0; i < gaussianRaw.length; i++){
            if (gaussianRaw[i] > 0.0) {
                count += 1;
            }
        }
        double[] gaussian = new double[count];
        count = 0;
        for (int i = 1; i < gaussianRaw.length + 1; i++){
            if (gaussianRaw[i - 1] > 0.0) {
                gaussian[count] = gaussianRaw[i - 1];
                System.out.println(count + " " + gaussian[count]); // TODO sort
                count += 1;
            }
        }
        
       // ArrayIOUtil.writeDoubles(printGaussianToFile, gaussian);
    }
}
