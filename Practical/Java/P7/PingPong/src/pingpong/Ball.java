package pingpong;

public class Ball {
    private String turn;
    public void setTurn(String turn)
    {
        this.turn = turn;
    }
    
    public String getTurn()
    {
        return turn;
    }
    
    public void waitTurn(String t)
    {
        while(t.equals(turn))
        {
            
        }
    }
    
    public Ball(String turn)
    {
        this.turn = turn;
    }
    
}
