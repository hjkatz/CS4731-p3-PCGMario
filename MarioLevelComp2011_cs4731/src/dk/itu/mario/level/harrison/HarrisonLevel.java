package dk.itu.mario.level.harrison;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.level.RandomLevel;
import dk.itu.mario.level.harrison.segments.*;
import dk.itu.mario.level.harrison.transitions.*;

import java.util.ArrayList;
import java.util.Random;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class HarrisonLevel extends RandomLevel{
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
   private final int        NUM_COINS           = 230;
   private final int        NUM_JUMPS           = 21;
   private final int        NUM_GAPS            = 10;
   private long             seed;
   private Random           random;
   private GamePlay         playerMetrics;
   // Player Metrics for Level Design
   private int              difficultyJump;
   private int              difficultyGaps;
   private int              difficultyEnemy;
   private int              difficultyTime;
   private int              numjumps            = 0;
   private int              numCoins            = 0;
   private int              typeJump            = 0;
   private int              typeGap             = 0;
   private int              typeTransition      = 0;
   private int              typeEnemy           = 0;
   private int              length              = 0;

   public HarrisonLevel(long seed, GamePlay playerMetrics, int difficulty){
      super(600, 15);
      if(difficulty >= 1 && difficulty <= 10){
         difficultyEnemy = difficulty;
         difficultyTime = difficulty;
         difficultyJump = difficulty;
         difficultyGaps = difficulty;
      }
      else{
         evaluate(playerMetrics);
      }
      this.seed = seed;
      this.playerMetrics = playerMetrics;
      width = 600;
      height = 15;
      create();
   }

   public void create(){
      random = new Random(seed);

      Segment singletonTransition = new SingletonTransition();
      Segment shortTransition = new ShortTransition();
      Segment mediumTransition = new MediumTransition();
      Segment longTransition = new LongTransition();
      Segment platformTransition = new PlatformTransition();
      Segment ceilingJumpUp = new CeilingJumpUp();
      Segment ceilingJumpUpDown = new CeilingJumpUpDown();
      Segment wallJumpUp = new WallJumpUp();
      Segment wallJumpUpDown = new WallJumpUpDown();
      Segment gapSmall = new GapSmall();
      Segment gapMedium = new GapMedium();
      Segment gapLarge = new GapLarge();
      Segment gapExtraLarge = new GapExtraLarge();
      Segment jumpMedium = new JumpMedium();
      Segment jumpLarge = new JumpLarge();
      Segment pillars = new Pillars();
      Segment pillarsGap = new PillarsGap();
      Segment runnableGap = new RunnableGap();
      Segment runnableGapLong = new RunnableGapLong();
      Segment pipeSingle = new PipeSingle();
      Segment pipeDouble = new PipeDouble();

      ArrayList<Segment> segments = new ArrayList<Segment>();
      // segments.add(singletonTransition);
      // segments.add(shortTransition);
      // segments.add(mediumTransition);
      segments.add(longTransition);
      // segments.add(platformTransition);
      segments.add(ceilingJumpUp);
      segments.add(ceilingJumpUpDown);
      segments.add(wallJumpUp);
      segments.add(wallJumpUpDown);
      segments.add(gapSmall);
      segments.add(gapMedium);
      segments.add(gapLarge);
      segments.add(gapExtraLarge);
      segments.add(jumpMedium);
      segments.add(jumpLarge);
      segments.add(pillars);
      segments.add(pillarsGap);
      segments.add(runnableGap);
      segments.add(runnableGapLong);
      segments.add(pipeSingle);
      segments.add(pipeDouble);

      boolean transition = true;

      // create all of the medium sections
      while(length < width - 20){
         if(transition){
            ArrayList<Segment> transitions = new ArrayList<Segment>();
            for(Segment segment : segments){
               if(segment.getType() == Segment.TYPE.TRANSITION){
                  transitions.add(segment);
               }
            }

            int level = difficultyTime / 2 + random.nextInt(difficultyTime);
            Segment best = transitions.get(random.nextInt(transitions.size()));
            for(Segment segment : transitions){
               if(segment.getDifficulty() == level){
                  best = segment;
                  break;
               }
            }
            addSegment(best);
            transition = false;
         }
         else{
            Segment.TYPE which = Segment.TYPE.JUMP;
            if(typeGap < typeJump){
               which = Segment.TYPE.GAP;
            }

            ArrayList<Segment> types = new ArrayList<Segment>();
            for(Segment segment : segments){
               if(segment.getType() == which){
                  types.add(segment);
               }
            }

            int level = 5;
            if(which == Segment.TYPE.JUMP){
               level = Math.min(difficultyTime, difficultyJump / 2 + random.nextInt(difficultyJump));
            }
            if(which == Segment.TYPE.GAP){
               level = Math.min(difficultyTime, difficultyGaps / 2 + random.nextInt(difficultyGaps));
            }

            Segment best = types.get(random.nextInt(types.size()));
            for(Segment segment : types){
               if(segment.getDifficulty() == level){
                  best = segment;
                  break;
               }
            }
            addSegment(best);
            transition = true;
         }

         // length += longTransition.attach(length, this);
         // length += runnableGapLong.attach(length, this);
         // length += pipeSingle.attach(length, this);
         // length += pipeDouble.attach(length, this);
         // length += shortTransition.attach(length, this);
         // length += runnableGap.attach(length, this);
         // length += ceilingJumpUp.attach(length, this);
         // length += platformTransition.attach(length, this);
         // length += wallJumpUp.attach(length, this);
         // length += singletonTransition.attach(length, this);
         // length += ceilingJumpUpDown.attach(length, this);
         // length += mediumTransition.attach(length, this);
         // length += platformTransition.attach(length, this);
         // length += wallJumpUpDown.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += gapSmall.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += gapMedium.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += gapLarge.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += gapExtraLarge.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += jumpMedium.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += jumpLarge.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += pillars.attach(length, this);
         // length += longTransition.attach(length, this);
         // length += pillarsGap.attach(length, this);
      }

      xExit = width - 8;
      yExit = height - 1;

      while(length < width){
         length += longTransition.attach(length, this);
      }

      System.out.println("difficultyJump  : " + difficultyJump);
      System.out.println("difficultyGaps  : " + difficultyGaps);
      System.out.println("difficultyEnemy : " + difficultyEnemy);
      System.out.println("difficultyTime  : " + difficultyTime);
      System.out.println("numjumps        : " + numjumps);
      System.out.println("numCoins        : " + numCoins);
      System.out.println("typeJump        : " + typeJump);
      System.out.println("typeGap         : " + typeGap);
      System.out.println("typeTransition  : " + typeTransition);
      System.out.println("typeEnemy       : " + typeEnemy);
      System.out.println("length          : " + length);
   }

   private void addSegment(Segment segment){
      length += segment.attach(length, this);
      numjumps += segment.getJumps();
      numCoins += segment.getCoins();
      switch (segment.getType()){
         case TRANSITION:
            typeTransition += 1;
            break;
         case JUMP:
            typeJump += 1;
            break;
         case ENEMY:
            typeEnemy += 1;
            break;
         case GAP:
            typeGap += 1;
            break;
         default:
            break;
      }
   }

   public void evaluate(GamePlay playerMetrics){
      difficultyTime = playerMetrics.completionTime / 12 / 2; // 600 / 10 == 120, thus 12 puts the time to 1-10, divided by 2 to be added to the other component later

      difficultyTime += playerMetrics.coinsCollected / NUM_COINS * 10;

      difficultyGaps = (int) (NUM_GAPS - playerMetrics.timesOfDeathByFallingIntoGap);

      difficultyJump = (int) (NUM_JUMPS / (playerMetrics.jumpsNumber - playerMetrics.aimlessJumps) * 10);

      difficultyEnemy = 5;
   }
}
