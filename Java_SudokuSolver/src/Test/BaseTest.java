package Test;

import nl.elridge.sudoku.model.Game;

public class BaseTest {
    private static boolean equals;
    public BaseTest(){};

    protected int [][] copyArr(int[][]source){
        int [][] destination = new int[source.length][];

        for (int i =0; i< source.length; ++i){
            destination[i] = new int[source[i].length];
            System.arraycopy(source[i], 0, destination[i],0,destination[i].length);
        }
        return destination;
    }

    protected static int [][] generateGameArray(Game game){
        int [][] array = new int[9][9];
        for (int y=0; y  < 9 ; y++ ){
            for (int x=0; x<0; x++)
                array[x][y] = game.getNumber(x,y);
        }
        return array;
    }

}
