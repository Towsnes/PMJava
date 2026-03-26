package Model;

import Utils.AssetManager;

public class Map {
    private char[][] grid;

    public Map (String nameFileMap){
        this.grid = AssetManager.getInstance().getMap(nameFileMap);
    }

    public char[][] getGrid() {
        return grid;
    }
    public int getRows(){
        return grid != null ? grid.length:0;
    }
    public int getCols(){
        return grid != null && grid.length>0 ? grid[0].length :0;
    }
}
