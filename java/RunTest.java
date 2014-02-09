/**
 * RunTest.java
 * ==============
 *
 * This file is a part of a program which serves as a utility for prediction
 * and data analysis of experimental and simulated data
 *
 * Copyright (C) 2014  Magdalen Berns <m.berns@sms.ed.ac.uk>
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
        Scanner scanEach = new Scanner(new BufferedReader(new FileReader("input-params.dat")));
        int numberOfTrials = IOUtil.skipToInt(scanEach);
        int estimatedScore = IOUtil.skipToInt(scanEach);
        double estimatedErrorOnScore = IOUtil.skipToDouble(scanEach);
        double error = ProbabilityUtil.percentErrorOnEstimate(estimatedErrorOnScore , estimatedScore );
        System.out.println(error);
        double[] predictedScore = ProbabilityUtil.predictedScore(error, numberOfTrials, estimatedScore);
        for (int i=0; i< 100; i++){
            System.out.println(predictedScore[i]);
        }
    }
}
