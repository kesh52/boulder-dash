package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * DirtModel
 *
 * Represents the dirt in the game.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class DirtModel extends DisplayableElementModel {

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "dirt";
		flags.isDestructible = true;
		flags.canMove = false;
		flags.impactExplosive = false;
		flags.animate = false;
		priority = 0;
		flags.falling = false;
		collideSound = null;
	}

    /**
     * Class constructor
     */
	public DirtModel() {
		super();
        this.loadSprite(spriteName);
	}
}