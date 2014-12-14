import com.woutwoot.wowpvp.game.GameManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Wout on 14/12/2014 - 23:31.
 */
public class TestGameManager {

    private GameManager gm;

    @Before
    public void setUp() {
        gm = new GameManager();
    }

    @Test
    public void testCreateGameWorks() {
        gm.createGame("test");

        if (!gm.getGame("test").getName().equals("test")) {
            fail("Game was not created.");
        }
    }

    @Test
    public void testRemoveGameWorks() {
        gm.createGame("test");

        if (!gm.getGame("test").getName().equals("test")) {
            fail("Game was not created.");
        }

        gm.removeGame("test");

        if (gm.getGame("test") != null) {
            fail("Game was not removed.");
        }
    }

}
