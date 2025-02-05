package walking.game.player;

public class Player {

    private int score;

    public int getScore() {
        return this.score;
    }

    protected walking.game.util.Direction direction = walking.game.util.Direction.UP;

    public walking.game.util.Direction getDirection() {
        return direction;
    }

    public Player() {
    }

    public void addToScore(int score) {
        this.score += score;
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