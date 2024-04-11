public class TimeKeeper extends Thread{
    private final Game game;
    private final int time;

    public TimeKeeper(Game game, int time) {
        this.game = game;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
            game.stopGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
