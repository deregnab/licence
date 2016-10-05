package fil.coo.dungeon.rooms;

/**
 * This class describe an exist room.
 * 
 * @author boinc
 */
public class Exit extends Room {

    public Exit(String name) {
        super(name);
    }
    
    /**
     * Return if this instance is an exit room.
     * @return true if it is an exit room.
     */
    @Override
    public boolean isExit() {
        return true;
    }
    
}
