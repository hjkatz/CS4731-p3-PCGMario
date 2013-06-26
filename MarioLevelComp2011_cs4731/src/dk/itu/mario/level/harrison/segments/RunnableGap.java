package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison
 * Date: 6/26/13
 */
public class RunnableGap extends Segment {
    @Override
    public int attach( int start, Level level )
    {
        for ( int y = level.getHeight(); y > level.getHeight() - 2; y-- )
        {
            level.setBlock(start,     y, HarrisonLevel.ROCK);
            level.setBlock(start + 1, y, HarrisonLevel.ROCK);
            level.setBlock(start + 3, y, HarrisonLevel.ROCK);
            //level.setBlock(start + 3, y, HarrisonLevel.ROCK);
            level.setBlock(start + 5, y, HarrisonLevel.ROCK);
        }

        level.setBlock(start + 3, level.getHeight() - 2, HarrisonLevel.COIN );

        return getLength();
    }

    @Override
    public int getDifficulty()
    {
        return 1;
    }

    @Override
    public int getLength()
    {
        return 6;
    }
}
