import javax.swing.*;
import java.awt.*;


final public class Animation {

    JFrame frame;
    DrawPanel drawpanel;
    private int oneX = 7;
    private int oneY = 7;

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;

    public static void main(String[] args){
        new Animation().go();

    }
    private void go(){
        frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawpanel= new DrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER,drawpanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(400,400);
        frame.setLocation(375,55);
        moveIT();
    }

    class DrawPanel extends JPanel{
        public void printComponent(Graphics g){

            g.setColor(Color.GREEN);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.RED);
            g.fillRect(3,3,this.getWidth()-6,this.getHeight()-6);
            g.setColor(Color.white);
            g.fillRect(6,6,this.getWidth()-12,this.getHeight()-12);
            g.setColor(Color.BLACK);
            g.fillRect(oneX,oneY,6,6);

        }
    }
    private void moveIT(){
        while(true){
            if(oneY>=283){
                right = false;
                left = true;
            }
            if(oneX<=7){
                right= true;
                left = false;
            }
            if (oneY>=259){
                up = true;
                down = false;
            }
            if(oneY<=7){
                up = false;
                down = true;
            }
            if (up){
                oneY--;
            }
            if (down){
                oneY++;
            }
            if (left){
                oneX++;

            }
            if (right){
                oneX--;
            }
            try {
                Thread.sleep(10);
            }
            catch (Exception e){
                frame.repaint();
            }

        }
    }


}
