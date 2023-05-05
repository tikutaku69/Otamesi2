//こっちのほうが単純でわかりやすい。40行しかないし。
//次回は、これでウィンドウを更新する方法を把握してくれ。
package Otamesi2;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MyFrame().setVisible(true));
  }
  
  MyFrame() {
    super("Title");
    JPanel mainPanel = (JPanel)getContentPane();
    mainPanel.add(new MyComponent(), BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }
}

class MyComponent extends JComponent {
  Timer timer;
  int w = 0;
  
  MyComponent() {
    setPreferredSize(new Dimension(200, 200));
    timer = new Timer(500, event -> {
      w += 10;
      if (w >= getWidth())
        w = 0;
      repaint();
    });
    timer.setRepeats(true);
    timer.start();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(0, 0, w, getHeight());
  }
}