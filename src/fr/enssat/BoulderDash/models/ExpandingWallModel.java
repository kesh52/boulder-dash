package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * ExpandingWallModel
 *
 * Represents a ExpandingWall in the game.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class ExpandingWallModel extends DisplayableElementModel {

	/*
    * Specifies the physical parameters of the object
    */
	{
		spriteName = "expandingwall";
		flags.isDestructible = false;
		flags.canMove = false;
		flags.impactExplosive = false;
		flags.animate = false;
		priority = 10;
		flags.falling = false;
		collideSound = null;
	}

    /**
     * Class constructor
     */
	public ExpandingWallModel() {
		super();
		this.loadSprite(spriteName);
	}
}