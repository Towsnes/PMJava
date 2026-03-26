package View;

import javax.swing.*;

public class GameWindow extends JFrame {
    private GamePanel gpl;
    public GameWindow (){
        gpl = new GamePanel(); // Chuyền map cho Panel để nó biết đường vẽ
        add(gpl);
        pack();
        setTitle("PacMan MVC");
        setResizable(false); // Nên thêm dòng này để người chơi không kéo giãn làm méo map
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
