public class Player {
    private final String name;
    private final int number;
    private final String position;
    private boolean isFielded;
    private final Team team;

    public Player(String name, int number, String position, boolean isFielded, Team team) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.team = team;
    }

    public String getStateAsString(){
        return "Name: " + name + " Number: " + number + " Position: " + position + "is fielded: " + ((isFielded) ? "Yes" : "No") + " Team: " + team;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void removeFromField(){
        isFielded = false;
    }

    public void field(){
        isFielded = true;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }
}
