package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * BrickWallModel
 *
 * Represents the brick wall in the game.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class BrickWallModel extends DisplayableElementModel {

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "brickwall";
		flags.isDestructible = true;
		flags.canMove = false;
		flags.impactExplosive = false;
		flags.animate = false;
		priority = 3;
		flags.falling = false;
		collideSound = "touch";
	}

    /**
     * Class constructor
     */
	public BrickWallModel() {
		super();
        this.loadSprite(spriteName);
	}
}
