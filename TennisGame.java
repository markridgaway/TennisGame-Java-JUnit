
public class TennisGame {
    private int serverPoints;
    private int receiverPoints;
    private String[] pointsText = new String[] {"Love","15","30", "40"};
    
    public TennisGame() {
        serverPoints = 0;
        receiverPoints = 0;
    }

    public String Score() {
        if ((this.serverPoints < 3) && (this.receiverPoints < 3) ||
            (this.serverPoints == 3) && (this.receiverPoints < 3) ||
            (this.serverPoints < 3) && (this.receiverPoints == 3)) 
        {
            return this.pointsText[this.serverPoints] + " - " + this.pointsText[this.receiverPoints];
        }
        
        if (this.serverPoints == this.receiverPoints) {
            return "Deuce";
        }
        
        if (((3 < this.serverPoints) || (3 < this.receiverPoints)) &&
            (1 < Math.abs(this.serverPoints - this.receiverPoints)))
        {
            if (this.receiverPoints < this.serverPoints) {
                return "Game Server";
            }
            else {
                return "Game Receiver";
            }
        }
        
        if ((3 <= this.serverPoints) && (3 <= this.receiverPoints)) {
            if (this.receiverPoints < this.serverPoints) {
                return "Advantage Server";
            }
            else {
                return "Advantage Receiver";
            }
        }
        
        return "YOU CAN NOT BE SERIOUS!!";
    }
    
    public void ServerScoresPoint() {
        this.serverPoints += 1;
    }
    
    public int getServerPoints() { return this.serverPoints; }
    private void setServerPoints() { }
    
    public void ReceiverScoresPoint() {
        this.receiverPoints += 1;
    }
    
    public int getReceiverPoints() { return this.receiverPoints; }
    private void setReceiverPoints() { }
}
