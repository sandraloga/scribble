import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);  
        myCanvas.erase();
        random = new Random();
    }

    /**
     * permite dibujar un triangulo verde en las coordenadas enteras x e y pasadas como parámetro.
     */
    public void drawTriangle(int x , int y)
    {
        Pen pen = new Pen (x, y, myCanvas);
        pen.setColor(Color.GREEN);
        for (int i=0 ; i < 3 ; i++)
        {
            pen.move(150);
            pen.turn(-120);

        }

    }

    /**
     *  permite dibujar un pentágono verde.
     */
    public void drawPentagon()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        for (int i=0; i<5 ; i++)
        {
            pen.move(100);
            pen.turn(-72);
        }

    }
    /**
     * permit dibujar un polígono regular con n lados, es decir, si n vale 3, será un triángulo, si vale 4 será un cuadrado, etc
     */

    public void drawPolygon(int n)
    {
        Pen pen = new Pen(320, 260, myCanvas);
        for (int i=0; i<n ; i++)
        {
            pen.move(60);
            pen.turn(-360/n);
        }
    }
    /**
     * dibuj una espiral
     */
    public void drawSpiral()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        int numero=5;
        for(int i = 1; i<200; i++)
        {
            numero= numero+2;
            pen.move(numero);
            pen.turn(-90);
        }
    }


    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
