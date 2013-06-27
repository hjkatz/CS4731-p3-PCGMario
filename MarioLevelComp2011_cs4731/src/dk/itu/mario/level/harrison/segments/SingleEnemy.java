package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.engine.sprites.Enemy;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created By: TJ Harrison
 * Date: 6/26/13
 */
public class SingleEnemy extends Segment {

    @Override
    public int attach(int start, Level level) {
        int y = level.getHeight() - 2;
        for(int i = level.getHeight(); i > y; i--){
            level.setBlock(start, i, HarrisonLevel.ROCK);
            level.setBlock(start + 1, i, HarrisonLevel.ROCK);
            level.setBlock(start + 2, i, HarrisonLevel.ROCK);

            level.setSpriteTemplate(start + 1, y - 1, new SpriteTemplate((int) HarrisonLevel.enemyTypes.get(HarrisonLevel.random.nextInt(HarrisonLevel.enemyTypes.size())), false));
        }

        return getLength();
    }

    @Override
    public int getDifficulty() {
        return 1;
    }

    @Override
    public int getLength() {
        return 3;
    }
}
