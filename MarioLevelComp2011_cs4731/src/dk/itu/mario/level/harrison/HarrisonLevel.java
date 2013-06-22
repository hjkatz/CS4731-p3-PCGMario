package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class HarrisonLevel extends Level{
   public static final byte BLOCK_EMPTY         = (byte) (0 + 1 * 16);
   public static final byte BLOCK_POWERUP       = (byte) (4 + 2 + 1 * 16);
   public static final byte BLOCK_COIN          = (byte) (4 + 1 + 1 * 16);
   public static final byte GROUND              = (byte) (1 + 9 * 16);
   public static final byte ROCK                = (byte) (9 + 0 * 16);
   public static final byte COIN                = (byte) (2 + 2 * 16);

   public static final byte LEFT_GRASS_EDGE     = (byte) (0 + 9 * 16);
   public static final byte RIGHT_GRASS_EDGE    = (byte) (2 + 9 * 16);
   public static final byte RIGHT_UP_GRASS_EDGE = (byte) (2 + 8 * 16);
   public static final byte LEFT_UP_GRASS_EDGE  = (byte) (0 + 8 * 16);
   public static final byte LEFT_POCKET_GRASS   = (byte) (3 + 9 * 16);
   public static final byte RIGHT_POCKET_GRASS  = (byte) (3 + 8 * 16);

   public static final byte HILL_FILL           = (byte) (5 + 9 * 16);
   public static final byte HILL_LEFT           = (byte) (4 + 9 * 16);
   public static final byte HILL_RIGHT          = (byte) (6 + 9 * 16);
   public static final byte HILL_TOP            = (byte) (5 + 8 * 16);
   public static final byte HILL_TOP_LEFT       = (byte) (4 + 8 * 16);
   public static final byte HILL_TOP_RIGHT      = (byte) (6 + 8 * 16);

   public static final byte HILL_TOP_LEFT_IN    = (byte) (4 + 11 * 16);
   public static final byte HILL_TOP_RIGHT_IN   = (byte) (6 + 11 * 16);

   public static final byte TUBE_TOP_LEFT       = (byte) (10 + 0 * 16);
   public static final byte TUBE_TOP_RIGHT      = (byte) (11 + 0 * 16);

   public static final byte TUBE_SIDE_LEFT      = (byte) (10 + 1 * 16);
   public static final byte TUBE_SIDE_RIGHT     = (byte) (11 + 1 * 16);

   // The level's width and height
   public int               width;
   public int               height;

   // These are the place of the end of the level
   public int               xExit;
   public int               yExit;
}
