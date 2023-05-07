//こっちのほうが単純でわかりやすい。40行しかないし。
//次回は、これでウィンドウを更新する方法を把握してくれ。

//paintComponentで定義してから繰り返しrepaintしてるな。
//道筋は見えたが、ウィンドウインスタンスと画面配列インスタンスの関係性がわかっていない。
//このコードの解説を探してくれ。

//細かい所はわからないが、大体の構造はわかった。
//このコードを基にして改変していく。
package Otamesi2;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MyFrame().setVisible(true));  //ここか？
  }
  
  MyFrame() {  //ここもコンストラクターか
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
  
  MyComponent() {  //これはコンストラクターで必ず実行？
    setPreferredSize(new Dimension(200, 200));
    timer = new Timer(500, event -> {
      w += 10;
      if (w >= getWidth())
        w = 0;
      repaint();  //ここで更新してるな
    });
    timer.setRepeats(true);
    timer.start();
  }
  
  @Override  //オーバーライドだと？
  public void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    // g.fillRect(0, 0, w, getHeight());
    g.fillRect(w, 0, 10, getHeight()/2);
  }
}