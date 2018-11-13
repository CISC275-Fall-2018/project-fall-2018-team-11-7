
public enum Direction {
	NORTH("north"),
	NORTHEAST("northeast"),
	EAST("east"),
	SOUTHEAST("southeast"),
	SOUTH("south"),
	SOUTHWEST("southwest"),
	WEST("west"),
	NORTHWEST("northwest"),
	NONE("none");

	private String name = null;

	private Direction(String s){
		name = s;
	}
	public String getName() {
		return name;
	}
}
