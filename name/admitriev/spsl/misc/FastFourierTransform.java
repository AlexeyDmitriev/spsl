package name.admitriev.spsl.misc;

public class FastFourierTransform {
    public void fft(double[] x, double[] y, boolean invert) {
        int count = x.length;
        for (int i = 1, j = 0; i < count; i++) {
            int bit = count >> 1;
            for (; j >= bit; bit >>= 1)
                j -= bit;
            j += bit;
            if (i < j) {
                double temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                temp = y[i];
                y[i] = y[j];
                y[j] = temp;
            }
        }
        for (int len = 2; len <= count; len <<= 1) {
            int halfLen = len >> 1;
            double angle = 2 * Math.PI / len;
            if (invert)
                angle = -angle;
            double wLenA = Math.cos(angle);
            double wLenB = Math.sin(angle);
            for (int i = 0; i < count; i += len) {
                double wX = 1;
                double wY = 0;
                for (int j = 0; j < halfLen; j++) {
                    double uA = x[i + j];
                    double uB = y[i + j];
                    double vA = x[i + j + halfLen] * wX - y[i + j + halfLen] * wY;
                    double vB = x[i + j + halfLen] * wY + y[i + j + halfLen] * wX;
                    x[i + j] = uA + vA;
                    y[i + j] = uB + vB;
                    x[i + j + halfLen] = uA - vA;
                    y[i + j + halfLen] = uB - vB;
                    double nextWA = wX * wLenA - wY * wLenB;
                    wY = wX * wLenB + wY * wLenA;
                    wX = nextWA;
                }
            }
        }
        if (invert) {
            for (int i = 0; i < count; i++) {
                x[i] /= count;
                y[i] /= count;
            }
        }
    }

    public long[] multiply(long[] x, long[] y) {
        int resultSize = Integer.highestOneBit(Math.max(x.length, y.length) - 1) << 2;
        resultSize = Math.max(resultSize, 1);
        double[] xReal = new double[resultSize];
        double[] yReal = new double[resultSize];
        double[] xImaginary = new double[resultSize];
        double[] yImaginary = new double[resultSize];

        for (int i = 0; i < x.length; i++)
            xReal[i] = x[i];
        for (int i = 0; i < y.length; i++)
            yReal[i] = y[i];
        fft(xReal, xImaginary, false);
        fft(yReal, yImaginary, false);
        for (int i = 0; i < resultSize; i++) {
            double real = xReal[i] * yReal[i] - xImaginary[i] * yImaginary[i];
            xImaginary[i] = xImaginary[i] * yReal[i] + yImaginary[i] * xReal[i];
            xReal[i] = real;
        }
        fft(xReal, xImaginary, true);
        long[] result = new long[resultSize];
        for (int i = 0; i < resultSize; i++)
            result[i] = Math.round(xReal[i]);
        return result;
    }
}