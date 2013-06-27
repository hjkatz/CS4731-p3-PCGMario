package dk.itu.mario.level.generator;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.level.harrison.HarrisonLevel;

import java.util.Random;

public class MyLevelGenerator extends CustomizedLevelGenerator implements LevelGenerator{

   public LevelInterface generateLevel(GamePlay playerMetrics){
      // LevelInterface level = new MyLevel(320, 15, new Random().nextLong(), 1, LevelInterface.TYPE_OVERGROUND, playerMetrics);
      LevelInterface level = new HarrisonLevel(new Random().nextLong(), playerMetrics, -1); // based on metrics
      //LevelInterface level = new HarrisonLevel(new Random().nextLong(), playerMetrics, 3); // easy
      //LevelInterface level = new HarrisonLevel(new Random().nextLong(), playerMetrics, 5); // medium
      //LevelInterface level = new HarrisonLevel(new Random().nextLong(), playerMetrics, 7); // hard
      //LevelInterface level = new HarrisonLevel(new Random().nextLong(), playerMetrics, 9); // harder
      return level;
   }

   @Override public LevelInterface generateLevel(String detailedInfo){
      // TODO Auto-generated method stub
      return null;
   }

}
