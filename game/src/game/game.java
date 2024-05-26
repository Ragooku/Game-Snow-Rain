package game;
import java.awt.Component;
import javax.swing.JOptionPane;

public class game {
   public static void main(String[] args) {
      String rez = JOptionPane.showInputDialog((Component)null, "Введите сложность игры от 1 до 7:", "Сложность игры", 1);
      int slogn = rez.charAt(0) - 48;
      if (slogn >= 1 && slogn <= 7) {
         new okno(slogn);
      }

   }
}
