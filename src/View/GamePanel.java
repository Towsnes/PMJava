package View;


import Model.Map;
import Utils.AssetManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private Map map;

    public static final int TITLE_SIZE = 32;

    public GamePanel(){
        map = new Map("level1");
        map.getGrid();
        setPreferredSize(new Dimension(608, 672));
        setBackground(Color.BLACK);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<map.getRows(); i++){
            for (int j=0; j<map.getCols();j++){
                int x = j * TITLE_SIZE;
                int y = i * TITLE_SIZE;
                switch (map.getGrid()[i][j]){
                    case 'X':  BufferedImage wall = AssetManager.getInstance().getImage("wall");
                        if (wall != null) {
                            g.drawImage(wall, x, y, TITLE_SIZE, TITLE_SIZE, null); // Lệnh VẼ ảnh
                        }
                        break;
                    case '.': BufferedImage cherry = AssetManager.getInstance().getImage("cherry");
                        if (cherry != null) {
                            // Căn giữa trái cherry cho đẹp (nếu ảnh cherry nhỏ hơn 32px)
                            g.drawImage(cherry, x, y,TITLE_SIZE,TITLE_SIZE, null);
                        }
                        break;
                }
            }
        }
    }
}
