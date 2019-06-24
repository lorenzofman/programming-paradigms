package pingpong;
public class PingPong {
    
    public static void main(String[] args) {
        Ball ball = new Ball("ping");
        Player pinger = new Player(ball);
        Player ponger = new Player(ball);
        pinger.setName("pinger");
        ponger.setName("ponger");
        pinger.setMate(ponger);
        ponger.setMate(pinger);
        pinger.start();
        ponger.start();
    }
    
}
