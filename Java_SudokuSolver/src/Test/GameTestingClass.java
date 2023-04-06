package Test;

import nl.elridge.sudoku.controller.ButtonController;
import nl.elridge.sudoku.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class GameTestingClass extends BaseTest {


    @InjectMocks
    private ButtonController buttonController;
    @Mock
    private Game game;

    private static Game games = new Game();
    @BeforeEach
    public void startSudoku(){
        games.newGame();
    }

    @BeforeEach
    public void initialize(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void newGameTest(){
       ActionEvent event = mock(ActionEvent.class);
        buttonController = new ButtonController(game);
        when(event.getActionCommand()).thenReturn("New");
        doNothing().when(game).newGame();
        buttonController.actionPerformed(event);
        verify(game, times(1)).newGame();



    }
    @Test
    public void testCheckGame(){
        ActionEvent actionEvent = mock(ActionEvent.class);
        buttonController = new ButtonController(game);
        when(actionEvent.getActionCommand()).thenReturn("Check");
        doNothing().when(game).checkGame();

        buttonController.actionPerformed(actionEvent);
        verify(game, times(1)).checkGame();
    }

    @Test
    public void isTestCheckValidForValidIndexesTest(){
        boolean[][] check = {{true, false}, {false,true}};
        Assertions.assertTrue( game.isCheckValid(0,0));
        Assertions.assertFalse(game.isCheckValid(1,0));
        Assertions.assertFalse(game.isCheckValid(0,1));
        Assertions.assertTrue(game.isCheckValid(1,1));
    }



    @Test
    public void setHelpOnTest(){
        games.setHelp(true);
        Assertions.assertTrue(games.isHelp());
    }

    @Test
    public void setHelpOff(){
        game.setHelp(false);
        Assertions.assertFalse(game.isHelp(), "Help is not checked");
    }


    @Test
    public void generateNewArrayAfterNewGame() {
        int[][] tmp = copyArr(BaseTest.generateGameArray(games));
        games.newGame();
        Assertions.assertTrue(Arrays.deepEquals(generateGameArray(games), tmp));
    }


    @Test
    public void writeNumberInSelectedField(){
        int x = 1;
        int y = 2;
        int z = 3;
        games.setSelectedNumber(z);
        games.setNumber(x , y , games.getSelectedNumber());
        Assertions.assertEquals(games.getSelectedNumber(),games.getNumber(x,y), "Number is not there");

    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9 })
    public void isSelectedNumberCandidateValidTrue(int n) {

        game.checkGame();
        game.setSelectedNumber(n);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (game.isSelectedNumberCandidate(x, y) && game.isCheckValid(x, y)) {
                    game.setNumber(x, y, game.getSelectedNumber());
                    Assertions.assertTrue(game.isCheckValid(x, y));
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints ={10 , 22 , 33 }  )
    public void isSelectedNumberCandidateValidFalse(int n) {
        game.checkGame();
        game.setSelectedNumber(n);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (game.isSelectedNumberCandidate(x, y) && !game.isCheckValid(x, y)) {
                    game.setNumber(x, y, game.getSelectedNumber());
                    Assertions.assertFalse(game.isCheckValid(x, y));
                }
            }
        }
    }

    @Test
    public void testisSelectedNumberCandidate_SelectedNumber(){
         game.isSelectedNumberCandidate(1,9);

    }





















}
