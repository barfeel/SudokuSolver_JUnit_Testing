package Test;

import nl.elridge.sudoku.view.ButtonPanel;
import nl.elridge.sudoku.view.Field;
import nl.elridge.sudoku.view.Sudoku;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static java.awt.Color.BLUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUItest  extends BaseTest {

    public static ButtonPanel buttonPanel = new ButtonPanel();
    public static Field field = new Field(1,2);
    public static Sudoku sudoku = new Sudoku();
    public static SudokuPanel sudokuPanel = new SudokuPanel();


    @Test
    public void testStartGui() {
        Sudoku.main(null);
    }
    @Test
    public void getFieldX_test(){
        assertEquals(field.getFieldX(),1);

    }

    @Test
    public void getFieldY_test(){
        assertEquals(field.getFieldY(),2);

    }

    @Test
    public void SetNumberOfUserInput(){
        field.setNumber(1,true);
        assertEquals(field.getForeground(), BLUE);
        field.setNumber(1, false);
        assertEquals(field.getForeground(),Color.BLACK);

    }

    @Test
    public void SetNumber_Number(){
        field.setNumber(1,true);
        assertEquals(field.getText(),"1");
        field.setNumber(0, true);
        assertEquals(field.getText(),"");
    }

    @Test
    public void MousePressedTest(){


    }

}



