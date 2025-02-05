package walking.game.player;

public class MadlyRotatingBuccaneer extends Player{

    private int turnCount;
    private int score;

    public int getScore() {
        return this.score;
    }
    protected walking.game.util.Direction direction = walking.game.util.Direction.UP;
        
    public void addToScore(int score) {
        this.score += score;
    }


    public MadlyRotatingBuccaneer() {

    }
    public void turn() {
        if (getDirection() == walking.game.util.Direction.UP) {
            direction = walking.game.util.Direction.RIGHT;
        }
        if (getDirection() == walking.game.util.Direction.RIGHT) {
            direction = walking.game.util.Direction.DOWN;
        }
        if (getDirection() == walking.game.util.Direction.DOWN) {
            direction = walking.game.util.Direction.LEFT;
        }
        if (getDirection() == walking.game.util.Direction.LEFT) {
            direction = walking.game.util.Direction.UP;
        }
    }

}