package fr.enssat.BoulderDash.tests;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.enssat.BoulderDash.exceptions.LevelConstraintNotRespectedException;
import fr.enssat.BoulderDash.helpers.AudioLoadHelper;
import fr.enssat.BoulderDash.models.DiamondModel;
import fr.enssat.BoulderDash.models.DisplayableElementModel;
import fr.enssat.BoulderDash.models.DoorModel;
import fr.enssat.BoulderDash.models.GameInformationModel;
import fr.enssat.BoulderDash.models.LevelModel;
import fr.enssat.BoulderDash.models.LevelModelFactory;
import fr.enssat.BoulderDash.models.RockfordModel;

public class TestLevelModel {
    private AudioLoadHelper mockAudioLoadHelper;

    @Before
    public void setUp() {
        String collisionSound = null;
        this.mockAudioLoadHelper = new AudioLoadHelper();
        //AudioLoadHelper spy = Mockito.spy(mockAudioLoadHelper);
        //Mockito.doNothing().when(spy).playSound(collisionSound);;

    }

    @Test
    public void testSpawnExitMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        LevelModel levelModel = new LevelModel("level01", this.mockAudioLoadHelper);

        Method spawnExitMethod = levelModel.getClass().getDeclaredMethod("spawnExit", null);
        spawnExitMethod.setAccessible(true);
        spawnExitMethod.invoke(levelModel, null);

        boolean doorModelExist = false;
        DisplayableElementModel[][] groundGrid = levelModel.getGroundLevelModel();
        for (int x = 0; x < levelModel.getSizeWidth(); x++) {
            for (int y = 0; y < levelModel.getSizeHeight() ; y++) {
                if(groundGrid[x][y] instanceof DoorModel) {
                    doorModelExist = true;
                }
            }
        }

        assertEquals(true, doorModelExist);
    }

    // Mit diesem Test testet man sowohl die Methode isRockfordInModel als auch die geworfene Exception
    @Test(expected=LevelConstraintNotRespectedException.class)
    public void testIsRockfordInModelIndirectly() throws LevelConstraintNotRespectedException {
        LevelModel levelModel = new LevelModelFactory().createLevelModel(this.mockAudioLoadHelper);
        levelModel.checkConstraints();
    }

    @Test
    public void testSetPositionOfRockford() {
        LevelModel levelModel = new LevelModelFactory().createLevelModel("game", "level01", this.mockAudioLoadHelper);

        levelModel.setPositionOfRockford(4, 2);
        GameInformationModel gameInfoModel = levelModel.getGameInformationModel();
        assertEquals(1, gameInfoModel.getScore());
    }
}
