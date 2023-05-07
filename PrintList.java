//1次元配列を用意し、タイマーごとにその中の数字をウィンドウに写してみる。
//配列の受け渡しが上手くいかない。イラつく。

//最悪、受け渡しをせずにListComponentの方で直接配列を作って出力でも良い。
//確認したいのは連番で指定した文字をウィンドウに写せるかということ。
//これができたら、そこで支持を読み込む形式にすればスライドパズルは動作する。
package Otamesi2;

import javax.swing.*;
import java.awt.*;

public class PrintList extends JFrame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new PrintList().setVisible(true));

    String[] map2 = new String[10];
    for (int i=0; i<10; i++){
      map2[i] = String.valueOf(i);
      System.out.print(map2[i]);
    }  //1次元配列を用意

    ListComponent lc = new ListComponent();
    lc.map3 = map2;
  }
  
  PrintList() {
    super("Title");
    JPanel mainPanel = (JPanel)getContentPane();
    mainPanel.add(new ListComponent(), BorderLayout.CENTER);
    // mainPanel.add(lc, BorderLayout.CENTER);  //なぜかlcだとダメなんだよね
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }
}

class ListComponent extends JComponent {
  String[] map3;
  Timer timer;
  int w = 0;
  
  ListComponent() {
    setPreferredSize(new Dimension(200, 200));
    timer = new Timer(2000, event -> {
      w += 1;
      if (w >= 10)
        w = 0;
      System.out.print(map3[w]);  //こっちは出力される。
      repaint();
    });
    timer.setRepeats(true);
    timer.start();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(w*10, 0, 10, getHeight()/2);
		g.drawString(map3[w], 100, 100);  //"this.map3" is nullとかいうエラーが出ていた。
		// g.drawString("あいうえお", w*10, 100);  //これなら問題なく文字が動かせる。
  }
}