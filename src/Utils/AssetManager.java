package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetManager {
    private static AssetManager instance;
    private HashMap<String, BufferedImage> imageCache;
    private HashMap<String, char[][]> mapCache;

    private AssetManager (){
        imageCache = new HashMap<>();
        mapCache = new HashMap<>();
    }
    public static AssetManager getInstance() {
        if (instance == null){
            instance = new AssetManager();
        }
        return instance;
    }
    public BufferedImage getImage (String imageName){
        if (!imageCache.containsKey(imageName)){
            try {
                InputStream is = getClass().getResourceAsStream("/assets/"+imageName+".png");
                if (is!= null){
                    imageCache.put(imageName, ImageIO.read(is));
                }else {
                    System.err.println("Not found Image");
                }
            } catch (Exception e) {
                System.err.println("Cannot read Image " +imageName);
            }
        }
        return imageCache.get(imageName);
    }
    public char[][] getMap (String nameMap){
        if(!mapCache.containsKey(nameMap)){
                mapCache.put(nameMap,loadMapFromChar(nameMap));
        }
        return mapCache.get(nameMap);
    }
    private char[][] loadMapFromChar(String nameMap){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/"+nameMap+".txt");
            if (is== null){
                System.err.println("Not found map " + nameMap);
                return null;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while((line= br.readLine()) != null){
                if (!line.isEmpty()){
                    lines.add(line);
                }
            }
            br.close();

            int rows = lines.size();
            int cols = lines.get(0).length();
            char [][] mapData = new char[rows][cols];

            for (int i=0; i<rows; i++){
                String currentLine = lines.get(i);
                for (int j=0; j<cols; j++){
                    if (j < currentLine.length()){
                        mapData[i][j]= currentLine.charAt(j);
                    }else {
                        mapData[i][j]= ' ';
                    }                }
            }
            return mapData;
        }catch (Exception e){
            System.err.println("Error!");
            return null;
        }
    }
}

