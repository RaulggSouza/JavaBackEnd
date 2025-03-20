public class Team {
    private final String name;
    private final String baseLocation;
    private final String coachName;
    private final Player[] players = new Player[18];
    private Player captain;
    private int numberOfPlayers;

    public Team(String name, String baseLocation, String coachName){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        numberOfPlayers = 0;
    }

    public void addPlayer(Player player){
        if (numberOfPlayers >= 18) return;
        players[numberOfPlayers] = player;
        numberOfPlayers++;
    }

    public void removePlayer(Player player){
        if (numberOfPlayers > 0) {
            players[numberOfPlayers] = null;
            numberOfPlayers--;
        } else {
            System.out.println("Team is empty");
        }
    }

    public void substitute(Player substitute, Player starter){
        for (int i = 0; i < numberOfPlayers; i++){
            if (players[i] == starter){
                starter.removeFromField();
                substitute.field();
                players[i] = substitute;
            }
        }
        System.out.println("Exit: " + starter.getStateAsString());
        System.out.println("Enter: " + substitute.getStateAsString());
    }

    public void setCaptain(Player captain){
        this.captain = captain;
    }

    public Player[] getFieldedPlayers(){
        Player[] fieldedPlayers = new Player[11];
        for (int i = 0; i < numberOfPlayers; i++){
            if (players[i].isFielded()){
                fieldedPlayers[i] = players[i];
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers(){
        Player[] outfieldedPlayers = new Player[7];
        for (int i = 0; i < numberOfPlayers; i++){
            if (!players[i].isFielded()){
                outfieldedPlayers[i] = players[i];
            }
        }
        for (Player outfieldedPlayer : outfieldedPlayers) {
            outfieldedPlayer.getStateAsString();
        }
        return outfieldedPlayers;
    }
}