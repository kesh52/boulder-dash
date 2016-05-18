package fr.enssat.BoulderDash.models;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * MagicWallModel
 *
 * Represents the magic wall.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class MagicWallModel extends DisplayableElementModel {

    /**
     * Stores the frames
     * Used for the sprites
     */
	private ArrayList<BufferedImage> frames;

	private long previousTime;
	private int currentFrame;
	private long speed;

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "magicwall";
		flags.isDestructible = false;
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
	public MagicWallModel() {
		super();
		this.currentFrame = 0;
		this.speed =  100;
		this.initSprites();
	}

	/**
	 * Function to animate the sprite
	 */
	public void update(long time) {
		if (time - this.previousTime >= this.speed) {
			// Update animation
			this.previousTime = time;

			try {
				this.currentFrame += 1;

				this.setSprite(this.frames.get(this.currentFrame));
			} catch (IndexOutOfBoundsException e) {
				this.currentFrame = 0;
			}
		}
	}

	/**
	 * Init the subimages
	 */
	private void initSprites() {
		this.frames = new ArrayList<BufferedImage>();
		/* INIT SPRITE FOR DIAMOND */
		this.frames.add(this.grabSprite(this.loadSprite(spriteName), 0, 0, 16, 16));
		this.frames.add(this.grabSprite(this.loadSprite(spriteName), 24, 0, 16, 16));
		this.frames.add(this.grabSprite(this.loadSprite(spriteName), 48, 0, 16, 16));
		this.frames.add(this.grabSprite(this.loadSprite(spriteName), 72, 0, 16, 16));
	}
}
