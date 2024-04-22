public class TimeKeeper implements Runnable {
    private long startTime;
    private long timeLimit;
    public TimeKeeper(long timeLimit) {
        this.startTime = System.currentTimeMillis();
        this.timeLimit = timeLimit;
    }
    @Override
    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > timeLimit) {
                System.out.println("Time limit exceeded. Stopping the game.");
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
