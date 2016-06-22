package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.helpers.AudioLoadHelper;

public class LevelModelFactory {

    public LevelModel createLevelModel(String mode, String levelName, AudioLoadHelper audioLoadHelper) {
        if (mode.equals("game")) {
            return new GameLevelModel(levelName, audioLoadHelper);
        } else if (mode.equals("editor")) {
            return new EditorLevelModel(levelName, audioLoadHelper);
        } else {
            return null;
        }
    }

    public LevelModel createLevelModel(AudioLoadHelper audioLoadHelper) {
        return new EditorLevelModel(audioLoadHelper);
    }

}
