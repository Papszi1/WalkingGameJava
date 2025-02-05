package walking.game;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class WalkingBoardWithPlayersTest {
    
    @Test
    public void walk1() {
        int jatekosok = 2;
        int palyameret = 5;
        WalkingBoardWithPlayers jatszma = new WalkingBoardWithPlayers(palyameret, jatekosok);

        int[] lepesek= {1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
        int[] megold = jatszma.walk(lepesek);

        int[] jo = {42,48};
        assertArrayEquals(jo, megold);
    }
        @Test
    public void walk2() {
        int jatekosok = 4;
        int palyameret = 5;
        WalkingBoardWithPlayers jatszma = new WalkingBoardWithPlayers(palyameret, jatekosok);

        int[] lepesek= {1,2,3,4,3,4,1,2,5,1,0,3,4};
        int[] megold = jatszma.walk(lepesek);

        int[] jo = {36,14,8,18};
        assertArrayEquals(jo, megold);
    }
}