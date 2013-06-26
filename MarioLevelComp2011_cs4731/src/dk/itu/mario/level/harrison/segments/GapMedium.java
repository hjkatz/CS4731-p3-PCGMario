
package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class GapMedium extends Segment
{
    
    @Override
    public int attach( int start, Level level )
    {
        for ( int x = start; x < getLength() + start; x++ )
        {
            if ( x <= ( start + getLength() / 2 - 3 ) || x >= ( start + getLength() / 2 + 3 ) )
            {
                level.setBlock( x, level.getHeight() - 1, HarrisonLevel.ROCK );
            }
            else
            {
                level.setBlock( x, level.getHeight() - 5, HarrisonLevel.COIN );
            }
        }
        
        return getLength();
    }
    
    @Override
    public int getDifficulty()
    {
        return 2;
    }
    
    @Override
    public int getLength()
    {
        return 15;
    }
}
