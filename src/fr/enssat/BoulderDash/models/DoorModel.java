package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * DoorModel
 *
 * Represents escape door.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class DoorModel extends DisplayableElementModel {
    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "door";
		flags.isDestructible = false;
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
	public DoorModel() {
		super();
		this.loadSprite(spriteName);
	}
}
