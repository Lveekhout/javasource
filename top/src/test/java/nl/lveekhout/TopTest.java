package nl.lveekhout;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopTest {
    @Test
    public void ListTest() {
        List<Long> l1 = new ArrayList<>();
        l1.add(0L);
        l1.add(1L);
        l1.add(2L);
        l1.add(3L);
        l1.add(4L);

        List<Long> l2 = new ArrayList<>();
        l2.add(2L);
        l2.add(3L);
        l2.add(4L);
        l2.add(5L);
        l2.add(6L);

        List<Long> deleted = new ArrayList<>(l1);
        deleted.removeAll(l2);

        List<Long> added = new ArrayList<>(l2);
        added.removeAll(l1);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(deleted);
        System.out.println(added);
    }

    @Test
    public void DatumTest() {
        System.out.println(new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").format(new Date()));
    }
}
