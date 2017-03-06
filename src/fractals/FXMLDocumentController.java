/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractals;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author 740657
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas cvsPlot,cvsJulia;
    @FXML
    private TextField tfMagnification,tfResolution,tfC_R,tfC_I;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfMagnification.setText("100");
        tfResolution.setText("1");
        tfC_R.setText("-0.123");
        tfC_I.setText("0.745");
    }
    @FXML
    private void handlebtnJuliaAction(ActionEvent e)
    {
        double plotWidth = cvsJulia.getWidth();
        double plotHeight = cvsJulia.getHeight();
        double C_R = Double.parseDouble(tfC_R.getText());
        double C_I = Double.parseDouble(tfC_I.getText());
        Complex C = new Complex(C_R,C_I);
        Vector<Complex> points = Fractal.getJulia(cvsJulia,C);
        
        GraphicsContext gc = cvsJulia.getGraphicsContext2D();
        gc.clearRect(0, 0, plotWidth, plotHeight);
        gc.setFill(Color.rgb(0,0,0));

        for(Complex c : points){
            gc.fillRect(c.X+plotWidth/2,c.Y+plotHeight/2,1,1);
        }
    }
    @FXML
    private void handlebtnMandelbrotAction(ActionEvent e)
    {
        double plotWidth = cvsPlot.getWidth();
        double plotHeight = cvsPlot.getHeight();
        
        Vector<Complex> points = Fractal.getManelbrot(cvsPlot,Double.parseDouble(tfMagnification.getText()),Double.parseDouble(tfResolution.getText()));
        
        GraphicsContext gc = cvsPlot.getGraphicsContext2D();
        gc.clearRect(0, 0, plotWidth, plotHeight);
        gc.setFill(Color.rgb(0,0,0));

        for(Complex c : points){
            gc.fillRect(c.X+plotWidth/2,c.Y+plotHeight/2,1,1);
        }
    }
}