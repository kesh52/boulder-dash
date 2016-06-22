package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.helpers.AudioLoadHelper;

public class GameLevelModel extends LevelModel {

    public GameLevelModel(String levelName, AudioLoadHelper audioLoadHelper) {
        super(levelName, audioLoadHelper);
        this.initRockford();
        this.initThreadAnimator();
    }
}
