package walking.game;

import walking.game.player.Player;

public class WalkingBoardWithPlayers extends WalkingBoard {

    private walking.game.player.Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board);
        round = 0;
        if (playerCount < 2) {
            throw new IllegalArgumentException("nincs elég játékos");
        }
        else {
            initPlayers(playerCount);
        }
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        round = 0;
        if (playerCount < 2) {
            throw new IllegalArgumentException("nincs elég játékos");
        }
        else {
            initPlayers(playerCount);
        }
        
    }

private void initPlayers(int playerCount) {
        players = new Player[playerCount];
        players[0] = new walking.game.player.MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new walking.game.player.Player();
        }
    }


    public int[] walk(int... walk) {
    int i = 0;
    int round = 0;
    int jatszo = 0;
    while (i < walk.length) {
        jatszo = i % players.length;

        if (jatszo == 0 && round == 1) {
            players[0].turn();
        }
        if (jatszo == 0 && round > 1) {
            players[0].turn();
            players[0].turn();
        }
        if (jatszo != 0) {
            players[jatszo].turn();
        }

        if (walk[i] > 13) {
            for (int k = 0; k < 13; k++) {
                moveAndSet(players[jatszo].getDirection(), 2); //nem tudom, hogy mennyi kell maradjon amiutan elleptek, akarmennyi lehet én 2-vel számítottam
                int[] poz = getPosition();
                int x = poz[0];
                int y = poz[1];
                int ertek = getTile(x, y);
                players[jatszo].addToScore(ertek);
            }
        } else {
            for (int k = 0; k < walk[i]; k++) {
                moveAndSet(players[jatszo].getDirection(), 2);
                int[] poz = getPosition();
                int x = poz[0];
                int y = poz[1];
                int ertek = getTile(x, y);
                players[jatszo].addToScore(ertek);
            }
        }
        
        if (jatszo == players.length - 1) {
            round++;
        }
        i++;
    }
    players[0].addToScore(10);
    int[] vege = new int[players.length];
    for (int j = 0; j < players.length; j++) {
        vege[j] = players[j].getScore();
    }
    return vege;
}

}
