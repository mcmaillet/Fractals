package fractals;

/**
 *
 * @author 740657
 */
public class Complex {
    
    public double X;
    public double Y;
    private static double tolerance = 0.000000001;
    
    public Complex()
    {
        X = 0;
        Y = 0;
    }
    public Complex(double x, double y)
    {
        X = x;
        Y = y;
    }
    /*
    COMPLEX OPERATIONS
    */
    public static Complex Add(Complex c1, Complex c2)
    {
        return new Complex(c1.X+c2.X,c1.Y+c2.Y);
    }
    public static Complex Subtract(Complex c1, Complex c2)
    {
        return new Complex(c1.X - c2.X, c1.Y - c2.Y);
    }
    public static Complex Multiply(Complex c1, Complex c2)
    {
        return new Complex (c1.X * c2.X - c1.Y * c2.Y, c1.X * c2.Y + c1.Y * c2.X);
    }
    public static Complex Divide(Complex c1, Complex c2)
    {
        double c2Norm = c2.X * c2.X + c2.Y * c2.Y;
        if (c2Norm != 0) {
            return new Complex ((c1.X*c2.X + c1.Y*c2.Y)/c2Norm, (c1.Y*c2.X-c1.X*c2.Y)/c2Norm );
        } else { return null; }
    }
    public static Complex Conjugate(Complex c)
    {
        return new Complex (c.X, -c.Y);
    }
    public static Complex Exp(Complex c, int n)
    {
        if (n == 0) { return new Complex( 1, 0); }
        Complex z = c;
        for (int i = 1; i < n; i++)
        {
            z = Complex.Multiply(z, c);
        }
        return z;
    }
    public static double Norm(Complex c)
    {
        return 0;
    }
    /*
    TOSTRING
    */
    @Override
    public String toString()
    {
        return X + " " + ((Y >= 0) ? "+" : "-") + " i" + ((Y >= 0) ? Y : (-Y));
    }
}