import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
    private double height;
    private double width;
    private double uckurukGenisligi;
    double radius;
    double centerX;
    double centerY;
    private Color kirmizi = new Color(227,10,23);


    private void doDrawing(Graphics g) {
        height = getHeight();
        width = getWidth();
        radius = (height * 0.25) / 2;
        centerX = height * 0.9;
        centerY = height * 0.5;


        uckurukGenisligi = (width * 5) / 100;
        Graphics2D g2d = (Graphics2D) g.create();
        setBackground(kirmizi);


        g2d.setPaint(Color.white); // uçkurluk kısmı
        g2d.fillRect(0, 0, (int) uckurukGenisligi, (int) height);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);


        ay(g2d);

        yildiz(g);

        // yıldız dairesi
        //      g2d.setPaint(Color.green);
        // g2d.fillOval(500, 250, (int) (height * 1/4 ), (int) (height * 1/4));
        // g2d.fillOval((int) ((height * 0.55 + height*1/3) - ((height * 0.20) - (height * 1/16))) , (int) (height* 3/8), (int) (height*1/4), (int) (height*1/4));


        // YILDIZ
        // g2d.drawLine(20, 20, 20, 140);
        // GeneralPath yildiz = new GeneralPath();

        //yildiz.moveTo(points[0][0], points[0][0]); //?

        // for (int k = 0; k < points.length; k++)
        //   yildiz.lineTo(points[k][0], points[k][1]);
        // yildiz.closePath();

        // g2d.fill(yildiz);

        // g2d.dispose();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }

    private void ay(Graphics2D g2d) {
        g2d.setPaint(Color.white); // ayın dış dairesi
        g2d.fillOval((int) (height * 0.30), (int) (height * 0.25), (int) (height * 0.50), (int) (height * 0.50));

        g2d.setPaint(Color.red); // ayın iç dairesi
        g2d.fillOval((int) ((height * 0.55) - (height * 0.20 - height * 1 / 16)), (int) (height * 0.30), (int) (height * 0.40), (int) (height * 0.40));

    }

    public void yildiz(Graphics g) {

        double points[][] = {

                //x2,y2
                {centerX - radius * 2 / 6, centerY - radius * 5.5 / 6},

                //x1,y1
                {centerX - radius * 2 / 6, centerY - radius * 1.4 / 6},

                //x0,y0
                {centerX - radius, centerY},

                //x3,y3
                {centerX - radius * 2 / 6, centerY + radius * 1.4 / 6},

                //x4,y4
                {centerX - radius * 2 / 6, centerY + radius * 5.5 / 6},

                //x5,y5
                {centerX + radius * 0.5 / 6, centerY + radius * 2.2 / 6},

                //x6,y6
                {centerX + radius * 4.8 / 6, centerY + radius * 3.5 / 6},

                //x7,y7
                {centerX + radius * 2.1 / 6, centerY},

                //x8,y8
                {centerX + radius * 4.8 / 6, centerY - radius * 3.5 / 6},

                //x9,y9
                {centerX + radius * 0.5 / 6, centerY - radius * 2.2 / 6},



        };

        Graphics2D g2d = (Graphics2D) g;
        GeneralPath yildiz = new GeneralPath();

        // yıldız dairesi
         g2d.setPaint(kirmizi.darker());

        // g2d.fillOval(500, 250, (int) (height * 1/4 ), (int) (height * 1/4));
         g2d.fillOval((int) ((height * 0.55 + height*1/3) - ((height * 0.20) - (height * 1/16))) , (int) (height* 3/8), (int) (height*1/4), (int) (height*1/4));


        yildiz.moveTo(points[0][0], points[0][1]);
        g2d.setPaint(Color.white);
        for (int k = 1; k < points.length; k++)
            yildiz.lineTo(points[k][0], points[k][1]);

        yildiz.closePath();
        g2d.fill(yildiz);
        g2d.dispose();
    }


}

public class Flag extends JFrame {

    public Flag() {

        add(new Surface());
        double height = 600;
        double width = 1.5 * height;

        setTitle("Bayrak");
        setSize((int) width, (int) height);
        setLocationRelativeTo(null); //?
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        Flag ex = new Flag();
        ex.setVisible(true);

    }

}
