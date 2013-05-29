import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ListTypeJavaTest {

    @Test
    public void m1() {
        List<Long> list = new ArrayList<Long>();
        list.add(new Long(1));
        uncheckCastMethod(list);
        list.add(2L);
        ma(list);
        m3(list);
        m4(list);
    }

    void uncheckCastMethod(Object arg) {
        List<String> list = (List<String>) arg;
        list.add("I know my code will always be dealing with lists of strings, I'm good");
    }

    void ma(List arg) {
        arg.add("Look Ma, I'm adding a String");
    }

    void m3(List list) {
        for (Object o : list) {
            System.out.println("index : " + list.indexOf(o) + " class : " + o.getClass());
        }
    }

    void m4(List list) {
        Object[] contained = {1L, 2L, "I know my code will always be dealing with lists of strings, I'm good", "Look Ma, I'm adding a String"};
        for (Object o : contained) {
            assertTrue(list.contains(o));
        }

    }


}
