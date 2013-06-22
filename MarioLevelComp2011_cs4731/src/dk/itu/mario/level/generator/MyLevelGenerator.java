package dk.itu.mario.level.generator;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.level.MyLevel;

import java.util.Random;

public class MyLevelGenerator extends CustomizedLevelGenerator implements LevelGenerator{

   public LevelInterface generateLevel(GamePlay playerMetrics){
      LevelInterface level = new MyLevel(320, 15, new Random().nextLong(), 1, LevelInterface.TYPE_OVERGROUND, playerMetrics);
      return level;
   }

   @Override public LevelInterface generateLevel(String detailedInfo){
      // TODO Auto-generated method stub
      return null;
   }

}
