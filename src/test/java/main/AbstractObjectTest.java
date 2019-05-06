package main;

import static junit.framework.TestCase.*;

public class AbstractObjectTest<T> {

    public void checkObjectMethods(T clazz1, T clazz2) {
        assertEquals(clazz1.toString(), clazz2.toString());
        assertTrue(clazz1.equals(clazz2) && clazz2.equals(clazz1));
        assertEquals(clazz1.hashCode(), clazz2.hashCode());
    }

    public void checkBuilderMethods(T clazz1, T clazz2) {
        assertEquals(clazz1.toString(), clazz2.toString());
        assertFalse(clazz1.hashCode() == clazz2.hashCode());
    }
}
