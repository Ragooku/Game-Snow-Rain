package game;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

class okno extends JFrame {
   private pole gameP;
   private int slogn;

   public okno(int slogn) {
      this.slogn = slogn;
      this.addKeyListener(new okno.myKey((okno.myKey)null));
      this.setFocusable(true);
      this.setBounds(0, 0, 800, 600);
      this.setTitle("Игра: Новогодний дождь");
      this.setResizable(false);
      this.setDefaultCloseOperation(3);
      this.gameP = new pole(slogn);
      Container con = this.getContentPane();
      con.add(this.gameP);
      this.setVisible(true);
   }

   private class myKey implements KeyListener {
      private myKey() {
      }

      public void keyPressed(KeyEvent e) {
         int key_ = e.getKeyCode();
         if (key_ == 27) {
            System.exit(0);
         } else {
            pole var10000;
            if (key_ == 37) {
               if (okno.this.gameP.x - 30 > -48) {
                  var10000 = okno.this.gameP;
                  var10000.x -= 30;
               } else {
                  okno.this.gameP.x = 752;
               }
            } else if (key_ == 39) {
               if (okno.this.gameP.x + 30 < 752) {
                  var10000 = okno.this.gameP;
                  var10000.x += 30;
               } else {
                  okno.this.gameP.x = -48;
               }
            }
         }

      }

      public void keyReleased(KeyEvent e) {
      }

      public void keyTyped(KeyEvent e) {
      }

      // $FF: synthetic method
      myKey(okno.myKey var2) {
         this();
      }
   }
}
