package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

class pole extends JPanel {
   private Image shapka;
   private Image fon;
   public int x = 400;
   private int slogn;
   private int ockhi = 0;
   private podar[] gamePodar;
   private Image end_game;
   public Timer timerUpdate;
   public Timer timerDraw;

   public pole(int slogn) {
      this.slogn = slogn;

      try {
         this.shapka = ImageIO.read(new File("./shapka.png"));
      } catch (IOException var7) {
      }

      try {
         this.fon = ImageIO.read(new File("./fon.png"));
      } catch (IOException var6) {
      }

      try {
         this.end_game = ImageIO.read(new File("./end_game.png"));
      } catch (IOException var5) {
      }

      this.gamePodar = new podar[7];

      for(int i = 0; i < 7; ++i) {
         try {
            this.gamePodar[i] = new podar(ImageIO.read(new File("./p" + i + ".png")));
         } catch (IOException var4) {
         }
      }

      this.timerUpdate = new Timer(3000, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pole.this.updateStart();
         }
      });
      this.timerUpdate.start();
      this.timerDraw = new Timer(50, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pole.this.repaint();
         }
      });
      this.timerDraw.start();
   }

   public void paintComponent(Graphics gr) {
      super.paintComponent(gr);
      gr.drawImage(this.fon, 0, 0, (ImageObserver)null);
      gr.drawImage(this.shapka, this.x, 465, (ImageObserver)null);
      gr.setFont(new Font("Edwardian Script ITC", 0, 40));
      gr.setColor(Color.RED);
      gr.drawString("Score: " + this.ockhi, 50, 50);

      for(int i = 0; i < 7; ++i) {
         this.gamePodar[i].draw(gr);
         if (this.gamePodar[i].act && this.gamePodar[i].y + this.gamePodar[i].img.getHeight((ImageObserver)null) >= 470) {
            if (Math.abs(this.gamePodar[i].x - this.x) > 75) {
               gr.drawImage(this.end_game, 300, 300, (ImageObserver)null);
               this.timerDraw.stop();
               this.timerUpdate.stop();
               break;
            }

            ++this.ockhi;
            this.gamePodar[i].act = false;
         }
      }

   }

   private void updateStart() {
      int kol = 0;

      for(int i = 0; i < 7; ++i) {
         if (!this.gamePodar[i].act) {
            if (kol < this.slogn) {
               this.gamePodar[i].start();
               break;
            }
         } else {
            ++kol;
         }
      }

   }
}
