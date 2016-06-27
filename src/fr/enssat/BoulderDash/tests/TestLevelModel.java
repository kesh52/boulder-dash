package fr.enssat.BoulderDash.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.enssat.BoulderDash.exceptions.LevelConstraintNotRespectedException;
import fr.enssat.BoulderDash.helpers.AudioLoadHelper;
import fr.enssat.BoulderDash.models.DisplayableElementModel;
import fr.enssat.BoulderDash.models.DoorModel;
import fr.enssat.BoulderDash.models.GameInformationModel;
import fr.enssat.BoulderDash.models.LevelModel;
import fr.enssat.BoulderDash.models.LevelModelFactory;

public class TestLevelModel {
    private AudioLoadHelper mockAudioLoadHelper;

    @Before
    public void setUp() {
        this.mockAudioLoadHelper = new AudioLoadHelper();
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

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void testIsRockfordInModel() throws LevelConstraintNotRespectedException {
        LevelModel levelModel = new LevelModelFactory().createLevelModel(this.mockAudioLoadHelper);
        levelModel.transformThisBoulderIntoADiamond(0, 0);
        levelModel.transformThisBoulderIntoADiamond(1, 0);
        levelModel.transformThisBoulderIntoADiamond(2, 0);

        expectedEx.expect(LevelConstraintNotRespectedException.class);
        levelModel.checkConstraints();
        expectedEx.expectMessage("Add Rockford on the map!");
    }

    @Test(expected=LevelConstraintNotRespectedException.class)
    public void testCheckConstraints() throws LevelConstraintNotRespectedException {
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
