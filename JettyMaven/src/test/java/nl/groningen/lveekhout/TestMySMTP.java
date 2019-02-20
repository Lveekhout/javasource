package nl.groningen.lveekhout;

import org.junit.Test;

/**
 * Created by eekhout.l on 16-11-2016.
 * class TestMySMTP
 */
public class TestMySMTP {
    @Test
    public void testMain() throws Exception {
        MySMTP smtp = new MySMTP();
        smtp.main(null);
    }
}
