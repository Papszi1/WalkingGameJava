package walking.game;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class WalkingBoardTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 3, 1, 6})
    public void testSimpleInit(int size) {

        WalkingBoard board = new WalkingBoard(size);


        int[][] tiles = board.getTiles();
        int[][] megold = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                megold[i][j] = walking.game.WalkingBoard.BASE_TILE_SCORE;
            }
        }
        assertArrayEquals(tiles, megold);


        assertEquals(walking.game.WalkingBoard.BASE_TILE_SCORE, tiles[0][0]);
        assertEquals(walking.game.WalkingBoard.BASE_TILE_SCORE, tiles[0][size-1]);
        assertEquals(walking.game.WalkingBoard.BASE_TILE_SCORE, tiles[size-1][size-1]);
        assertEquals(walking.game.WalkingBoard.BASE_TILE_SCORE, tiles[size-1][0]);
    }

    //testCustomInit(x, y, expected)
    @ParameterizedTest
    @CsvSource({
            "2, 2, {{1,2},{2,3}}",
            "3, 2, {{2,6},{2,5},{1,1}}"
    })
    public void testCustomInit(int x, int y, String expected) {
        int[][] bemenet = stringToIntArray(expected);

        WalkingBoard val = new WalkingBoard(bemenet);
        int[][] joe = val.getTiles();

        int[][] megold = new int[bemenet.length][bemenet[0].length];
        for (int i = 0; i < bemenet.length; i++) {
            for (int j = 0; j < bemenet[i].length; j ++) {
                if (bemenet[i][j] > 3) {
                    megold[i][j] = bemenet[i][j];
                }
                else {
                    megold[i][j] = 3;
                }
            }
        }
        assertArrayEquals(megold, joe);

        bemenet[0][0] = 99;
        int[][] masolat = joe;
        assertArrayEquals(masolat, joe);


        
        bemenet[0][0] = 99;
        int[][] cseres = val.getTiles();

        assertArrayEquals(cseres, joe);

    }


    @Test
    public void nehez(){
        int[][] megold = {{2,1},{3,1}};
        WalkingBoard val = new WalkingBoard(megold);
        int[][] valami = val.getTiles();
        int[][] jo = new int[megold.length][megold[0].length];
        for (int i = 0; i < megold.length; i ++) {
            for (int j = 0; j < megold[i].length; j ++) {
                if (megold[i][j] > 3) {
                    jo[i][j] = megold[i][j];
                }
                else {
                    jo[i][j] = 3;
                }
            }
        }
        assertArrayEquals(jo, valami);

    }
    

    public int[][] stringToIntArray(String bem) {
        String[] rows = bem.split("},\\s*\\{");

       int numRows = rows.length;
       int numCols = rows[0].split(",").length;

       int[][] result = new int[numRows][numCols];


        for (int i = 0; i < numRows; i++) {
            String[] values = rows[i].replaceAll("[{}]", "").split(",");
           for (int j = 0; j < numCols; j++) {
               result[i][j] = Integer.parseInt(values[j].trim());
            }
        }
        return result;
    }

    @Test
    public void testMoves() {
        WalkingBoard board = new WalkingBoard(5);
        int[][] initialState = board.getTiles();

        board.moveAndSet(walking.game.util.Direction.RIGHT, 1);

        int[] pozicio = board.getPosition();
        int[] beirt = {1, 0}; 
        assertArrayEquals(beirt, pozicio); 



        board.moveAndSet(walking.game.util.Direction.RIGHT, 6);

        pozicio = board.getPosition();
        beirt = new int[]{2, 0}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.RIGHT, 1);

        pozicio = board.getPosition();
        beirt = new int[]{3, 0}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.DOWN, 3);

        pozicio = board.getPosition();
        beirt = new int[]{3, 1}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.DOWN, 3);

        pozicio = board.getPosition();
        beirt = new int[]{3, 2}; 
        assertArrayEquals(beirt, pozicio);         
        
        board.moveAndSet(walking.game.util.Direction.DOWN, 3);

        pozicio = board.getPosition();
        beirt = new int[]{3, 3}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.UP, 2);

        pozicio = board.getPosition();
        beirt = new int[]{3, 2}; 
        assertArrayEquals(beirt, pozicio); 
                
        board.moveAndSet(walking.game.util.Direction.RIGHT, 3);

        pozicio = board.getPosition();
        beirt = new int[]{4, 2}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.RIGHT, 3);

        pozicio = board.getPosition();
        beirt = new int[]{4, 2}; 
        assertArrayEquals(beirt, pozicio); 

        board.moveAndSet(walking.game.util.Direction.RIGHT, 3);

        pozicio = board.getPosition();
        beirt = new int[]{4, 2}; 
        assertArrayEquals(beirt, pozicio); 


    }

}