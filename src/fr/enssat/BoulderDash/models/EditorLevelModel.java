package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.helpers.AudioLoadHelper;

public class EditorLevelModel extends LevelModel {

    public EditorLevelModel(AudioLoadHelper audioLoadHelper) {
        super();

        this.gameRunning = false;

        this.sizeWidth = 25 + 2;
        this.sizeHeight = 25 + 2;

        // Generate dirt
        this.groundGrid = new DisplayableElementModel[this.sizeWidth][this.sizeHeight];

        for (int x = 0; x < this.sizeWidth; x++) {
            for (int y = 0; y < this.sizeHeight; y++) {
                this.groundGrid[x][y] = new DirtModel();
            }
        }

        this.createLimits();
    }

    public EditorLevelModel(String levelName, AudioLoadHelper audioLoadHelper) {
        super(levelName, audioLoadHelper);
    }

}
