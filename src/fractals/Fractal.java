/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractals;

import java.util.Vector;
import javafx.scene.canvas.Canvas;
/**
 *
 * @author 740657
 */
public class Fractal {
    
    public static Vector<Complex> getJulia(Canvas cvsJulia,Complex C){
        double PlotRes = 1;
        double MAGNIFICATION = 150;
        Vector<Complex> points = new Vector<Complex>();
        
        double plotWidth = cvsJulia.getWidth();
        double plotHeight = cvsJulia.getHeight();
        double i = -Math.floor(plotWidth / 2);
        double j = -Math.floor(plotHeight / 2);

        while (i < plotWidth / 2)
        {
            while (j < plotHeight / 2)
            {
                Complex z = new Complex(i/MAGNIFICATION, j/MAGNIFICATION);
                if (Bounded_Julia(z,C)) { points.add(new Complex(i, j)); }
                j += PlotRes;
            }
            j = -Math.floor(plotHeight / 2);
            i += PlotRes;
        }
        return points;
    }
    private static boolean Bounded_Julia(Complex z_0,Complex C)
    {
        //
        // Mapping Z_n+1=Z_n^2 + C
        //
        int stepLimit = 40;
        Complex z_old = z_0;
        Complex z_new = z_old;
        int i=0;
        while(i<stepLimit)
        {
            z_new = step_Julia(z_old, C);
            if (z_new.toString().contains("NaN") || z_new.toString().contains("Infinity"))
            {
                return false;
            }
            z_old = z_new;
            i++;
        }
        return true;
    }
    private static Complex step_Julia(Complex z_old,Complex c)
    {
        Complex output = Complex.Add(Complex.Multiply(z_old, z_old),c);
        return output;
    }
    /*
    MANDELBROT
    */
    public static Vector<Complex> getManelbrot(Canvas cvsPlot,double mag, double res){
        
        double PlotRes = res;
        double MAGNIFICATION = mag;
        Vector<Complex> points = new Vector<Complex>();
        
        double plotWidth = cvsPlot.widthProperty().get();
        double plotHeight = cvsPlot.heightProperty().get();
        double i = -Math.floor(plotWidth / 2);
        double j = -Math.floor(plotHeight / 2);

        while (i < plotWidth / 2)
        {
            while (j < plotHeight / 2)
            {
                Complex c = new Complex(i/MAGNIFICATION, j/MAGNIFICATION);
                if (Bounded_Mandelbrot(c)) { points.add(new Complex(i, j)); }
                j += PlotRes;
            }
            j = -Math.floor(plotHeight / 2);
            i += PlotRes;
        }
        return points;
    }
    private static boolean Bounded_Mandelbrot(Complex c)
    {
        //
        // Mapping Z_n+1=Z_n^2 + C, Z_0=0
        //
        int stepLimit = 30;
        Complex z_old = new Complex(0, 0);
        Complex z_new = z_old;
        int i=0;
        while(i<stepLimit)
        {
            z_new = stepMand(z_old, c);
            if (z_new.toString().contains("NaN") || z_new.toString().contains("Infinity"))
            {
                return false;
            }
            z_old = z_new;
            i++;
        }
        return true;
    }
    private static Complex stepMand(Complex z_old,Complex c)
    {
        Complex output = Complex.Add(Complex.Multiply(z_old, z_old),c);
        return output;
    }
}
