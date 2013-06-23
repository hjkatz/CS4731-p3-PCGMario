package dk.itu.mario.level.harrison;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.level.Level;

import java.util.Random;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class HarrisonLevel extends Level{
   // you sure these are correct? a lot of them are the same numbers, also since they are bytes in can only go from
   // -128 to 127 but 17 * 16 is 272 so thats no good, didnt want to change anything cause i could be missing something?
   // and i realize this is from MyLevel, but lets take hints from our last project lessons learned and not use their stuff in any way
   // - tj
   public static final byte BLOCK_EMPTY         = (byte) (0 + 1 * 16);    // 1 * 16
   public static final byte BLOCK_POWERUP       = (byte) (4 + 2 + 1 * 16); // 7 * 16
   public static final byte BLOCK_COIN          = (byte) (4 + 1 + 1 * 16); // 6 * 16
   public static final byte GROUND              = (byte) (1 + 9 * 16);    // 10 * 16
   public static final byte ROCK                = (byte) (9 + 0 * 16);    // 9 * 16
   public static final byte COIN                = (byte) (2 + 2 * 16);    // 4 * 16
   public static final byte LEFT_GRASS_EDGE     = (byte) (0 + 9 * 16);    // 9 * 16
   public static final byte RIGHT_GRASS_EDGE    = (byte) (2 + 9 * 16);    // 11 * 16
   public static final byte RIGHT_UP_GRASS_EDGE = (byte) (2 + 8 * 16);    // 10 * 16
   public static final byte LEFT_UP_GRASS_EDGE  = (byte) (0 + 8 * 16);    // 8 * 16
   public static final byte LEFT_POCKET_GRASS   = (byte) (3 + 9 * 16);    // 12 * 16
   public static final byte RIGHT_POCKET_GRASS  = (byte) (3 + 8 * 16);    // 11 * 16
   public static final byte HILL_FILL           = (byte) (5 + 9 * 16);    // 14 * 16
   public static final byte HILL_LEFT           = (byte) (4 + 9 * 16);    // 13 * 16
   public static final byte HILL_RIGHT          = (byte) (6 + 9 * 16);    // 15 * 16
   public static final byte HILL_TOP            = (byte) (5 + 8 * 16);    // 13 * 16
   public static final byte HILL_TOP_LEFT       = (byte) (4 + 8 * 16);    // 12 * 16
   public static final byte HILL_TOP_RIGHT      = (byte) (6 + 8 * 16);    // 14 * 16
   public static final byte HILL_TOP_LEFT_IN    = (byte) (4 + 11 * 16);   // 15 * 16
   public static final byte HILL_TOP_RIGHT_IN   = (byte) (6 + 11 * 16);   // 17 * 16
   public static final byte TUBE_TOP_LEFT       = (byte) (10 + 0 * 16);   // 10 * 16
   public static final byte TUBE_TOP_RIGHT      = (byte) (11 + 0 * 16);   // 11 * 16
   public static final byte TUBE_SIDE_LEFT      = (byte) (10 + 1 * 16);   // 11 * 16
   public static final byte TUBE_SIDE_RIGHT     = (byte) (11 + 1 * 16);   // 12 * 16
   // These are the place of the end of the level
   private long             seed;
   private Random           random;
   private GamePlay         playerMetrics;

   public HarrisonLevel(long seed, GamePlay playerMetrics){
      super(320, 15);
      this.seed = seed;
      this.playerMetrics = playerMetrics;
      width = 320;
      height = 15;
      create();
   }

   public void create(){
      random = new Random(seed);

      Segment transition = new Transition();

      // create the start location
      int length = 0;
      length += transition.attach(length, this);

      // create all of the medium sections
      while(length < width - 8){
         length += transition.attach(length, this);
      }

      xExit = width - 8;
      yExit = height - 1;

      // fills the end piece
      for(int x = length; x < width; x++){
         for(int y = height; y < height - 2; y++){
            setBlock(x, y, GROUND);
         }
      }
   }

   @Override public Level clone() throws CloneNotSupportedException{
      return super.clone();
   }
}
