package dk.itu.mario.level.harrison;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.level.Level;

import java.util.Random;

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
      while(length < width - 64){
         length += transition.attach(length, this);
      }

      // set the end piece
      int floor = height - 1 - random.nextInt(4);

      xExit = length + 8;
      yExit = height;

      // fills the end piece
      for(int x = length; x < width; x++){
         for(int y = 0; y < height; y++){
            if(y >= floor){
               setBlock(x, y, GROUND);
            }
         }
      }
   }

   @Override public Level clone() throws CloneNotSupportedException{
      return super.clone();
   }
}
