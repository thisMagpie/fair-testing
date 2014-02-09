/**
 * ProbabilityUtil.java
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
import java.util.Random;

public class ProbabilityUtil{

    /**
     * percentage
     *                          Work out the percentage of a sample taken from the total.
     * @param expectedError
     *                          The percentageError
     * @param expectedScore
     *                          expectedScore
     * @return
     *                          The percentage of a sample taken from the total as a double
     */
    public static double percentErrorOnEstimate(double expectedError, int expectedScore){
        return (double) expectedError * expectedScore;
    }

    /**
     * predictedScore
     *                          Work out the absolute predicted deviation from each score result
     *                          based on the multiplier which is the predicted error on the data
     *                          which is the error estimate and the number of trials
     *                          taken
     * @param multiplier
     *                          The percentage error on the data as a decimal.
     * @param numberOfTrial
     *                          Total number of trials to take
     * @return
     *                          The predicted scores of a sample taken from the total as a double
                                plus or minus the error estimate on them.
     */
    public static double[] predictedScore(double multiplier, int numberTrials, int expectedResult){
        Random random = new Random();
        double[] temp = new double[numberTrials];
        for (int i = 0; i < numberTrials; i++){
            double tempRandom = random.nextDouble() * multiplier;
            if (random.nextDouble() < 0.5){
                tempRandom = -1.0 * tempRandom;
            }
            temp[i] = tempRandom + expectedResult;
        }
        return temp;
    }
}
