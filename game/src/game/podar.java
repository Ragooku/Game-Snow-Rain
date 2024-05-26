package game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.Timer;

class podar {
   public Image img;
   public int x;
   public int y;
   public Boolean act;
   Timer timerUpdate = new Timer(500, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         podar.this.vniz();
      }
   });

   public podar(Image img) {
      this.img = img;
      this.act = false;
   }

   public void start() {
      this.timerUpdate.setDelay(300);
      this.timerUpdate.start();
      this.y = 0;
      this.x = (int)(Math.random() * 700.0D);
      this.act = true;
   }

   public void vniz() {
      if (this.act) {
         this.y += 6;
      }

      if (this.y + this.img.getHeight((ImageObserver)null) >= 470) {
         this.timerUpdate.stop();
      }

   }

   public void draw(Graphics gr) {
      if (this.act) {
         gr.drawImage(this.img, this.x, this.y, (ImageObserver)null);
      }

   }
}
