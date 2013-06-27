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
public class TripleEnemy extends Segment {

    @Override
    public int attach(int start, Level level) {
        int y = level.getHeight() - 2;
        for(int i = level.getHeight(); i > y; i--){
            level.setBlock(start, i, HarrisonLevel.ROCK);
            level.setBlock(start + 1, i, HarrisonLevel.ROCK);
            level.setBlock(start + 2, i, HarrisonLevel.ROCK);
            level.setBlock(start + 3, i, HarrisonLevel.ROCK);
            level.setBlock(start + 4, i, HarrisonLevel.ROCK);
            level.setBlock(start + 5, i, HarrisonLevel.ROCK);
            level.setBlock(start + 6, i, HarrisonLevel.ROCK);

            int enemyType = (int) HarrisonLevel.enemyTypes.get(HarrisonLevel.random.nextInt(HarrisonLevel.enemyTypes.size()));
            level.setSpriteTemplate(start + 1, y - 1, new SpriteTemplate(enemyType, false));
            level.setSpriteTemplate(start + 3, y - 1, new SpriteTemplate(enemyType, false));
            level.setSpriteTemplate(start + 5, y - 1, new SpriteTemplate(enemyType, false));
        }

        return getLength();
    }

    @Override
    public int getDifficulty() {
        return 3;
    }

    @Override
    public int getLength() {
        return 7;
    }

    @Override
    public int getCoins() {
        return 0;
    }

    @Override
    public TYPE getType() {
        return TYPE.JUMP;
    }

    @Override
    public int getJumps() {
        return 1;
    }
}
