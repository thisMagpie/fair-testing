/**
 * Copyright (C) 2012-2014  Magdalen Berns <http://thismagpie.com>
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
public class Stats {

/**
 * Stats.java
 * 
 * This file is a part of a program which serves as a utility for prediction
 * and data analysis of experimental and simulated data
 *
 * @author Magdalen Berns
 * @email <m.berns@sms.ed.ac.uk>
 * @version 1.0
 */

    private static final double period = 2 * Math.PI;
    /**
     * mean
     *                   Works out the mean value of supplied data
     * @param data
     *                   Array of doubles holding the x and y values in [i][0] and [j][1] respectively
     *
     * @return
     *                  The covariance as a double giving the fit difference of least squares
     */
    public static double mean(double[] data){
        double sum = 0.0;
        for(int i = 0; i < data.length; i++) sum += data[i];
        return sum / (double) data.length - 1;
    }

    /**
     * covariance
     *                   Works out the fit of the data
     * @param xVariance
     *                   Array of doubles holding the x variance values
     * @param yVariance
     *                   Array of doubles holding the y variance values
     * @param data
     *                   Array of doubles holding the x and y values in [i][0]
     *                   and [j][1] respectively
     *
     * @return
     *                  The covariance as a double giving the fit difference of
     *                  least squares
     */
    public static double covariance(double xVariance, double yVariance, double[][] data){
        double covariance = 0.0;
        for (int i = 0; i < data.length; i++) covariance += (data[i][0] - xVariance) * (data[i][1] - yVariance);
        return covariance;
    }

    /**
     * covariance
     *                  Works out the fit of the data
     * @param xVariance
     *                  Array of doubles holding the x variance values
     * @param yVariance
     *                  Array of doubles holding the y variance values
     * @param x
     *                  Array of doubles holding the x values
     * @param y
     *                  Array of doubles holding the y values
     *
     * @return
     *                  The covariance as a double giving the fit difference of least squares
     */
    public static double covariance(double xVariance, double yVariance, double[] x, double[] y) {
        double covariance = 0.0;
        for (int i = 0; i < x.length; i++) covariance += (x[i] - xVariance) * (y[i] - yVariance);
        return covariance;
    }

    /**
     * standardDeviation
     *                  Works out the Standard Deviation
     * @param data
     *                  The data being analysed
     * @param mean
     *                  The mean of the data
     *
     * @return
     *                  The the biased Standard Deviation as a double
     */
    public static double standardDeviation(double[] data, double mean){
        double variance = 0.0;
        for (int i = 0; i < data.length; i++) variance += Math.pow((data[i] - mean), 2);
        return Math.sqrt(variance) / ((double)data.length);
    }

    /**
     * s2
     *                  Works out the difference of least squares squares on a single datapoint
     * @param dataPoint An individual data point from an array of data
     * @param mean      The mean of the data
     *
     * @return          The variances of a single datapoint a double
     */
    public static double s2(double dataPoint, double mean) {
        return Math.pow((dataPoint - mean), 2);
    }

    /**
     * s2               Works out the biased difference of least squares fit
     * @param data
     *                  A 1D array of data
     * @param mean      The mean of the data
     *
     * @return          The biased variance squared double
     */
    public static double s2(double[] data, double mean) {
        double s2 = 0;
        for(int i=0; i<data.length; i++) {
            s2 += Math.pow((data[i] - mean), 2);
        }
        return s2/data.length;
    }

    /**
     * s2Unbiased       Works out the unbiased difference of least squares fit
     * @param data
     *                  An individual data point from an array of data
     * @param mean
     *                  The mean of the data
     *
     * @return
     *                  The sum of all the variances as a double
     */
    public static double s2Unbiased(double[] data, double mean) {
        double s2 = 0;
        for(int i=0; i<data.length; i++) {
            s2 += Math.pow((data[i] - mean), 2);
        }
        return s2 /(data.length - 1);
    }

    /**
     * s
     *                  Works out the difference of least squares fit
     * @s2              The biased or unbiased variance
     * @return
     *                  Standard Error on the Mean
     */
    public static double s(double s2) {
        return Math.sqrt(s2);
    }
    /**
     * standardError
     *                        Works out the standard deviation of the sampling distribution based
                              upon the individual deviations

     * @param variance
     *                        The variance of the data being analysed
     * @param n
     *                        The integer length of the data array
     *
     * @return
     *                        The the standard deviation of least squares fit as a double
     */
    public static double standardError(double[] data, double mean) {
        double stdError = 0.0;
        for(int i=0; i<data.length; i++) {
            if(data.length > 0) stdError = s2(data[i], mean) / Math.sqrt(data.length);
        }
        return stdError;
    }

    /**
     * gradient
     *                   Works out the standard deviation of least squares fit
     * @param covariance
     *                   The covariance of the data being analysed
     * @param xVariance
     *                   The integer length of the data array
     * @return
     *          The the standard deviation of least squares fit as a double
     */
    public static double gradient(double covariance, double xVariance){
        return covariance / xVariance;
    }

    /**
     * yIntercept
     *                   Works out the offset of the data (i.e the constant
     *                   Value by which y is offset)
     * @param xMean
     *                   The mean value of the x coordinate of the data being analysed
     * @param yMean
     *                   The mean value of the y coordinate of the data being analysed
     * @param gradient
     *                  The gradient
     * @return
     *          The the standard deviation of least squares fit as a double
     */
    public static double yIntercept(double xMean, double yMean, double gradient){
        return yMean - gradient * xMean;
    }

    /**
     * fit
     *                   Works out the fit of a linear data set from a 2D array,
     *                   where x = [i][0] and y = [j][1]
     * @param data
     *                   Array of doubles holding the x and y values in [i][0] and [j][1] respectively
     * @param gradient
     *                  The gradient
     * @param offset
     *                  The offset constant value on the y axis
     * @return
     *                  The the least squares fit as an array of doubles
     */
    public static double[] fit(double[][] data, double gradient, double offset){
        double[] fit=new double[data.length];
        for(int i=0; i<data.length; i++)
            fit[i] = gradient*data[i][0] + offset;
        return fit;
    }

    /**
     * fit
     *                   Works out the fit of the data
     * @param x
     *                   Array of doubles holding the x values
     * @param gradient
     *                  The gradient
     * @param offset
     *                  The offset constant value on the y axis
     * @return
     *                  The the least squares fit as an array of doubles
     */
    public static double[] fit(double[] x, double gradient, double offset){
        double[] fit=new double[x.length];
        for(int i = 0; i < x.length; i++) fit[i] = gradient*x[i] + offset;
        return fit;
    }

    /**
     * standardDeviation
     *                  Gives the residual sum of squares.
     * @param data
     *                  Array of doubles holding the x and y values in [i][0]
     *                  and [i][1] respectively
     * @param fit
     *                  The the least squares fit as an array of doubles
     * @return
     *                  Standard error in mean of y as a double value
     */
    public static double standardDeviation(double[][] data, double[] fit) {
        double rss = 0.0; //standard error in mean i.e. residual sum of squares
        for (int i = 0; i < data.length; i++) rss += (fit[i] - data[i][1]) * (fit[i] - data[i][1]);
        return rss;
    }

    /**
     * standardError
     *                              Gives the residual sum of squares.
     * @param N
     *                              Number of Samples as an integer
     *
     * @param standardDeviation
     *                              standard deviation from mean
     * @return
     *                              Standard variance of mean i.e. as a double
     */
    public static double standardError(int N, double s2) {
        return Math.sqrt(s2 /(double)N);
    }

    /**
     * standardError
     *                  Gives the residual sum of squares.
     * @param y
     *                  Array of doubles holding the y values
     *
     * @param fit
     *                  The the least squares fit as an array of doubles
     * @return
     *                  Standard error in mean i.e. residual sum of squares
     *                  as a double
     */
    public static double standardError(double[] y, double[] fit) {
        double rss = 0.0;
        for (int i = 0; i < y.length; i++)
            rss += (fit[i] - y[i]) * (fit[i] - y[i]);
        return rss;
    }

    /**
     * regressionSumOfSquares
     *                               Calculates regression sum of squares
     * @param fit
     *                               The the least squares fit as an array of doubles
     * @param mean
     *                               Array of doubles holding the mean y values
     * @return
     *                               The regression sum of squares as a double
     */
    public static double regressionSumOfSquares(double[] fit, double mean) {
        double ssr = 0.0; // initialise and instansiate regression sum of squres variable
        for (int i = 0; i < fit.length; i++) ssr += (fit[i] - mean) * (fit[i] - mean);
        return ssr;
    }

    /**
     * residuals
     *                  Difference between y from the least squares fit and the actual data
     * @param y
     *                  Array of doubles holding the y values
     * @param fit
     *                  The the least squares fit as an array of doubles
     * @return
     *                  Array of doubles holding the data's residual points
     */
    public static double[] residuals(double[] y, double[] fit) {
        double[] residuals=new double[y.length];
        for (int i = 0; i < y.length; i++)
            residuals[i] = y[i] - fit[i];
        return residuals;
    }

    /**
     * linearCorrelationCoefficient
     *                              Linear correlation coefficient found when we
     *                              calculate the regression sum of squares over
     *                              the variance given in y.
     *
     * @param regressionSumOfSquares
     *                              Standard error of mean from having calculated
     *                              the regression sum of squares.
     *
     * @param yVariance
     *                              Variance in y as an array of double values
     *
     * @return
     *                              Linear correlation coefficient of data as a double
     */
    public static double linearCorrelationCoefficient(double regressionSumOfSquares, double yVariance) {
        return regressionSumOfSquares / yVariance;
    }

    /**
     * errorOffset
     *              Gives the error in the offset in a linear fit
     * @param n
     *              Integer length of the array of data doubles
     * @param xVariance
     *              Variance in x as an array of double values
     * @param xMean
     *              Array of doubles holding the mean x values
     * @param rss
     *              The regression sum of squares as a double
     * @return
     *              Error in the y offset constant value of the line of best fit as a double
     */
    public static double errorOffset(double n, double xVariance, double xMean, double rss) {
        double degreesFreedom = n - 2;  //Assumes that data has only 2 degrees of freedom.
        double sigma = rss / degreesFreedom;
        double sVariance = (sigma / xVariance);
        return Math.sqrt( sigma / n + Math.pow(xMean, 2) * sVariance);
    }

    /**
     * errorGradient
     *                  Gives the error in the gradient
     * @param xVariance
     *                  Double holding the value of the variance in x
     * @param rss
     *                  Standard error in the mean of x
     * @return
     *                  Error in the line of best fit's gradient calculation as a double
     */
    public static double errorGradient(double xVariance, double rss, int n){
        double degreesFreedom = n - 2;
        double stdVariance = rss / degreesFreedom;
        return Math.sqrt(stdVariance/ xVariance);
    }

    public static double errorFit(double stdFit){
        return Math.sqrt(stdFit);
    }

   /**
    * gaussian
    *                         Transform data into a normalised gaussian
    * @param N
    *                         sample number appropriate to size of original data array
    * @param variance                    
    *                         variance of data
    * @param mean
    *                         mean of data
    * @return
    *                         normalised gaussian in the form of 1D array of doubles
    */
    public static double[] gaussian(double[] data, double mean) {
        int N = data.length;
        double[] gaussian = new double[N];
        double tempGaussian= 0.0;

        for (int i=0; i < N; i++) {
            gaussian[i] = (1.0 / Math.sqrt( s2(data, mean)*period)) * Math.exp((float) (-1.0 * s2(data[i], mean)) / 2* s2(data, mean));
            tempGaussian += gaussian[i];
        }
        
        for (int i = 0; i< N; i++){
            gaussian[i] /= tempGaussian;
        }
        return gaussian;
    }


    /**
     * convolve
     *                          convolve data with a normalised gaussian in order
     *                          to smooth the output after reducing sample rate
     * @param data
     *                          1D integer data array to be smoothed
     * @param gaussian
     *                          normalised gaussian in the form of 1D array of doubles for y axis
     * @param N
     *                          sample number appropriate to size of original data array
     * @return
     *                          Smoothed data as array of doubles 
     */ 
    public static double[] convolve(int[] data, double[] gaussian, int N){
        double convolved[] = new double[data.length - (N + 1)];
        for (int i=0; i < convolved.length; i++){
            convolved[i] = 0.0;
            for (int j = i, k = 0; j < i + N; j++, k++){
                convolved[i] +=  data[j] * gaussian[k];
            }
        }
        return convolved;
    }

    /**
     * convolve
     *                         convolve two normalised gaussian spreads to get
     *                         distribution of probabilities.
     * @param g1
     *                         1D double containing the first normalised gaussian
     *                         to convolve
     * @param g2
     *                         1D double containing the second normalised gaussian
     *                         to convolve
     * @return
     *                         Array of doubles containing the normalised gaussian convolution
     *                         as an array of doubles 
     */ 
    public static double[] convolve(double[] g1, double[] g2) { //TODO test
        double convolved[] = new double[g1.length - (g2.length + 1)];

        for (int i=0; i < convolved.length; i++) {
            convolved[i] = 0.0;
            for (int j=i, k=0; j < i + g2.length; j++, k++) convolved[i] += g1[j] * g2[k];
        }
        return convolved;
    }
}
