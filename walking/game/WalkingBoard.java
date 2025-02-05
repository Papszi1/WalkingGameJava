package walking.game;

public class WalkingBoard {

    private int[][] tiles;

    public int[][] getTiles() {
        int[][] vissza = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i ++) {
            vissza[i] = new int[tiles[i].length];
            for (int j = 0; j < tiles[i].length; j++) {
                vissza[i][j] = tiles[i][j];
            }
        }
        
        return vissza;
    }
    
    private int x;
    private int y;
    
    public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size){
        tiles = new int[size][size];
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles) {
        this.tiles = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            this.tiles[i] = new int[tiles[i].length];
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] > BASE_TILE_SCORE) {
                    this.tiles[i][j] = tiles[i][j];
                } else {
                    this.tiles[i][j] = BASE_TILE_SCORE;
                }
            }
        }
    }


    public int[] getPosition() {
        int[] valami = new int[2];
        valami[0] = x;
        valami[1] = y;
        
        return valami;
    }

public boolean isValidPosition(int x, int y) {
    boolean valid;
    if (x >= 0 && y >= 0 && x < tiles.length) {
        if (y < tiles[x].length) {
            valid = true;
        } else {
            valid = false;
        }
    } else {
        valid = false;
    }
    return valid;
    }



    public int getTile(int x, int y) {
        if (isValidPosition(x, y)) {
        return tiles[x][y];
        } 
        else {
        throw new IllegalArgumentException("Érvénytelen pozíció: x vagy y");
        }
    }

    public static int getXStep(walking.game.util.Direction direction) {
        int x = 0;
        if (direction == walking.game.util.Direction.RIGHT) {
            x = 1;
        }
        if (direction == walking.game.util.Direction.LEFT) {
            x = -1;
        }

        return x;
    }

    public static int getYStep(walking.game.util.Direction direction) {
        int x = 0;
        if (direction == walking.game.util.Direction.DOWN) {
            x = 1;
        }
        if (direction == walking.game.util.Direction.UP) {
            x = -1;
        }
        return x;
    }

    public int moveAndSet(walking.game.util.Direction Valami ,int TODOname) {
        boolean erv = false;
        if (x + getXStep(Valami) < tiles.length && x + getXStep(Valami) >= 0) {
            x += getXStep(Valami);
            erv = true;
        }
        if (y + getYStep(Valami) < tiles[0].length && y + getYStep(Valami) >= 0) {
            y += getYStep(Valami);
            erv = true;
        }

        if (erv) {
            tiles[x][y] = TODOname;
            int ertek = getTile(x - getXStep(Valami), y - getYStep(Valami));
            return ertek;
        }
        else {
            int ertek = getTile(x, y);
            return ertek;
        }
    }


}