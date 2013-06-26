package dk.itu.mario.level.harrison;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.RandomLevel;
import dk.itu.mario.level.harrison.segments.*;
import dk.itu.mario.level.harrison.transitions.*;

import java.util.ArrayList;
import java.util.Random;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class HarrisonLevel extends RandomLevel{
   public static final byte BLOCK_EMPTY         = (byte) (0 + 1 * 16);    // 1 * 16
   public static final byte ROCK                = (byte) (9 + 0 * 16);    // 9 * 16
   public static final byte COIN                = (byte) (2 + 2 * 16);    // 4 * 16
   public static final byte TUBE_TOP_LEFT       = (byte) (10 + 0 * 16);   // 10 * 16
   public static final byte TUBE_TOP_RIGHT      = (byte) (11 + 0 * 16);   // 11 * 16
   public static final byte TUBE_SIDE_LEFT      = (byte) (10 + 1 * 16);   // 11 * 16
   public static final byte TUBE_SIDE_RIGHT     = (byte) (11 + 1 * 16);   // 12 * 16
   public static final int  LEVEL_WIDTH         = 100;
   private long             seed;
   private Random           random;
   private GamePlay         metrics;
   private int              difficulty;
   private int              numJumps            = 0;
   private int              numCoins            = 0;
   private int              typeJump            = 0;
   private int              typeGap             = 0;
   private int              typeTransition      = 0;
   private int              typeEnemy           = 0;
   private int              length              = 0;
   //the enemies
   public static SpriteTemplate[][] spriteTemplates;

   public HarrisonLevel(long seed, GamePlay playerMetrics){
      super(HarrisonLevel.LEVEL_WIDTH, 15);
      this.seed = seed;
      this.metrics = playerMetrics;

      width = HarrisonLevel.LEVEL_WIDTH;
      height = 15;
      spriteTemplates = new SpriteTemplate[width][height];
      create();
   }

   public void create(){
      random = new Random(seed);

      difficulty = 10 - (metrics.totalTime + (metrics.timeRunningRight / 4)) / (metrics.timeSpentRunning / 2);
      int numDeaths = (int) (metrics.timesOfDeathByFallingIntoGap + metrics.timesOfDeathByGoomba + metrics.timesOfDeathByGreenTurtle + metrics.timesOfDeathByRedTurtle);
      if(numDeaths == 0){
          difficulty += 1;
      }
       else{
          difficulty -= numDeaths;
      }
      difficulty = Math.max(difficulty, 1);
      difficulty = Math.min(difficulty, 10);

      //transitions
      Segment shortTransition = new ShortTransition();
      Segment mediumTransition = new MediumTransition();
      Segment longTransition = new LongTransition();
      Segment platformTransition = new PlatformTransition();
      //segments
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
      Segment pillarsGapEasy = new PillarsGapEasy();
      Segment runnableGap = new RunnableGap();
      Segment runnableGapLong = new RunnableGapLong();
      Segment pipeSingle = new PipeSingle();
      Segment pipeDouble = new PipeDouble();
      Segment enemyBumpAcross = new EnemyBumpAcross();

      ArrayList<Segment> transitions = new ArrayList<Segment>();
      ArrayList<Segment> segments = new ArrayList<Segment>();
      transitions.add(shortTransition);
      transitions.add(mediumTransition);
      transitions.add(longTransition);
      transitions.add(platformTransition);
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
      segments.add(pillarsGapEasy);
      segments.add(runnableGap);
      segments.add(runnableGapLong);
      segments.add(pipeSingle);
      segments.add(pipeDouble);
      segments.add(enemyBumpAcross);

      boolean transition = false;

      //create the start
      addSegment(longTransition);

      // create all of the medium sections
      while(length < width - 20){
         if(transition){
            int level = difficulty / 2 + random.nextInt(difficulty);
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
            Segment best = segments.get(random.nextInt(segments.size()));
            ArrayList<Segment> possibilities = new ArrayList<Segment>();

               for(Segment segment : segments){
                   if(segment.getDifficulty() == difficulty || segment.getDifficulty() == difficulty + 1 || segment.getDifficulty() == difficulty + 2 || segment.getDifficulty() == difficulty - 2 || segment.getDifficulty() == difficulty - 1){
                       possibilities.add(segment);
                   }
               }

            best = possibilities.get(random.nextInt(possibilities.size()));
            addSegment(best);
            transition = true;
         }
      }

      xExit = width - 8;
      yExit = height - 1;
      //create exit, use this instead of long transition so there are no coins past exit
      while(length < width){
         setBlock(length, getHeight(), HarrisonLevel.ROCK);
         setBlock(length, getHeight() - 1, HarrisonLevel.ROCK);
         length += 1;
      }

      System.out.println("difficulty  : " + difficulty);
      System.out.println("numJumps        : " + numJumps);
      System.out.println("numCoins        : " + numCoins);
      System.out.println("typeJump        : " + typeJump);
      System.out.println("typeGap         : " + typeGap);
      System.out.println("typeTransition  : " + typeTransition);
      System.out.println("typeEnemy       : " + typeEnemy);
      System.out.println("length          : " + length);
      System.out.println("coinsgot          : " + metrics.coinsCollected);
   }

   private void addSegment(Segment segment){
      length += segment.attach(length, this);
      numJumps += segment.getJumps();
      numCoins += segment.getCoins();
      switch (segment.getType()){
         case TRANSITION:
            typeTransition += 1;
            break;
         case JUMP:
            typeJump += 1;
            break;
         case GAP:
            typeGap += 1;
            break;
         default:
            break;
      }
   }

   //public void evaluate(GamePlay playerMetrics){
      // difficultyTime = playerMetrics.completionTime / 12 / 2; // 600 / 10 == 120, thus 12 puts the time to 1-10, divided by 2 to be added to the other component later

      //double a = (playerMetrics.coinsCollected / (double) NUM_COINS);
      //difficultyTime = (int) (a * 10);

      //difficultyGaps = (int) (NUM_GAPS - playerMetrics.timesOfDeathByFallingIntoGap);

      //difficultyJump = (int) ((NUM_JUMPS / (playerMetrics.jumpsNumber - playerMetrics.aimlessJumps)) * 10);
   //}
}
