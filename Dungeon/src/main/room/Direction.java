package main.room;
public enum Direction {
    EAST, NORTH, NORTHEAST, NORTHWEST, SOUTH, SOUTHEAST, SOUTHWEST, WEST;
    
    /**
     * Which direction {NSEW} is left of this direction? 
     * This direction must be one of {NSEW}. 
     * @return Direction on left;
     */
    public Direction left() {
        return null;
    }
    
    /**
     * Which direction {NSEW} is right of this direction? 
     * This direction must be one of {NSEW}. 
     * @return Direction on right;
     */
    public Direction right() {
        return null;
    }
    
    /**
     * Which direction is opposite this direction? 
     * @return The opposite direction
     */
    public Direction opposite() {
        return null;
    }
}