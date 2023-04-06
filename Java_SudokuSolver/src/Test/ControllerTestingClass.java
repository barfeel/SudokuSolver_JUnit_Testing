package Test;

import nl.elridge.sudoku.controller.SudokuController;
import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.view.Field;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static nl.elridge.sudoku.view.SudokuPanel.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ControllerTestingClass extends BaseTest {
      private static Game game = new Game();
      private static SudokuPanel sudokuPanel = new SudokuPanel();
      private static SudokuController sudokuController ;

      @Test
      public void mouseClicked(){
          SudokuController sudoku = new SudokuController(sudokuPanel,game);
          sudoku.mouseClicked(null);

      }
      @Test
      public void mouseEntered(){
            SudokuController sudokuController1 = new SudokuController(sudokuPanel,game);
           sudokuController1.mouseEntered(null);
      }
      @Test
      public void mouseExited(){
            SudokuController sudokuController1 = new SudokuController(sudokuPanel,game);
            sudokuController1.mouseExited(null);
      }
      @Test
      public void mouseReleased(){
            SudokuController sudokuController1 = new SudokuController(sudokuPanel, game);
            sudokuController1.mouseReleased(null);
      }

      @Test
      public void SetCandidateTest(){
             Game gameMock = mock(Game.class);
            Field[][] fieldsMock = new Field[9][9];
            for (int y =0; y<9; y++){
                  for (int x = 0; x<9; x++){
                        fieldsMock[y][x] = mock(Field.class);

                  }
            }
            sudokuPanel = new SudokuPanel();

            when(gameMock.isHelp()).thenReturn(true);
            when(gameMock.isSelectedNumberCandidate(anyInt(),anyInt())).thenReturn(true);

            sudokuPanel.setCandidates(gameMock);

            for (int y = 0; y < 9; y++) {
                  for (int x = 0; x < 9; x++) {
                        Field fieldMock = fieldsMock[y][x];
                        verify(fieldMock).setBackground(Color.WHITE);
                        verify(fieldMock, times(gameMock.isSelectedNumberCandidate(x, y) ? 1 : 0)).setBackground(COLOR_CANDIDATE);
                  }
            }


      }








}
