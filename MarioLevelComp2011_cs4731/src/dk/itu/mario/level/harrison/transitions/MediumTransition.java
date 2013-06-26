package dk.itu.mario.level.harrison.transitions;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;
import dk.itu.mario.level.harrison.segments.Segment;

/**
 * Created By: TJ Harrison
 * Date: 6/25/13
 */
public class MediumTransition extends Segment {
    @Override
    public int attach( int start, Level level )
    {
        for(int y = level.getHeight(); y > level.getHeight() - 2; y-- ){
            level.setBlock(start, y, HarrisonLevel.GROUND);
            level.setBlock(start + 1, y, HarrisonLevel.GROUND);
            level.setBlock(start + 2, y, HarrisonLevel.GROUND);
            level.setBlock(start + 3, y, HarrisonLevel.GROUND);
            level.setBlock(start + 4, y, HarrisonLevel.GROUND);
            level.setBlock(start + 5, y, HarrisonLevel.GROUND);
            level.setBlock(start + 6, y, HarrisonLevel.GROUND);
            level.setBlock(start + 7, y, HarrisonLevel.GROUND);
            level.setBlock(start + 8, y, HarrisonLevel.GROUND);
            level.setBlock(start + 9, y, HarrisonLevel.GROUND);
        }

        level.setBlock(start + 4, level.getHeight() - 2, HarrisonLevel.COIN );
        level.setBlock(start + 5, level.getHeight() - 2, HarrisonLevel.COIN );

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
        return 10;
    }
}
