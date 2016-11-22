

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class PointTest {

    private final double DELTA = 0.000001;

    @Test(timeout = 100)
    public void testDefaultConstructorInitializeXYtoZero() {
        Point p = new Point();

        Class<? extends Point> cl = p.getClass();

        Field[] declaredFields = cl.getDeclaredFields();

        boolean isInitializedXtoZero = false;
        boolean isInitializedYtoZero = false;

        for (Field f : declaredFields) {
            try {
                f.setAccessible(true);
                if (f.getName().equals("x") && (f.getInt(p) == 0)) {
                    isInitializedXtoZero = true;
                } else if (f.getName().equals("y") && (f.getInt(p) == 0)) {
                    isInitializedYtoZero = true;
                }
                f.setAccessible(false);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String message1 = "Point(): member variable \"x\" should be initialized to 0";
        String message2 = "Point(): member variable \"y\" should be initialized to 0";

        assertTrue(message1, isInitializedXtoZero);
        assertTrue(message2, isInitializedYtoZero);
    }

    @Test(timeout = 100)
    public void testHasParameterizedConstructor() {
        Point p = new Point();

        Class<? extends Point> cl = p.getClass();

        Constructor<?>[] cons = cl.getConstructors();

        boolean hasParameterizedConstructor = false;

        String message = "The class must have a constructor with two arguments of type \"int\"";

        for (Constructor<?> c : cons) {
            if (c.getName().equals("Point") && c.getParameterCount() == 2) {
                Class<?>[] paramTypes = c.getParameterTypes();
                for (Class<?> type : paramTypes) {
                    if (!type.getName().equals("int")) {
                        assertTrue(message, hasParameterizedConstructor);
                    }
                }
                hasParameterizedConstructor = true;
            }
        }

        assertTrue(message, hasParameterizedConstructor);
    }

    @Test(timeout = 100)
    public void testParameterizedConstructorInitializeXY() {
        int xExpected = 79;
        int yExpected = 33;

        Point p = new Point(xExpected, yExpected);

        Class<? extends Point> cl = p.getClass();

        Field[] fields = cl.getDeclaredFields();

        String message1 = "Member variable \"x\" not initialized correctly";
        String message2 = "Member variable \"y\" not initialized correctly";

        for (Field f : fields) {
            try {
                if (f.getName().equals("x")) {
                    f.setAccessible(true);
                    assertEquals(message1, xExpected, f.getInt(p));
                    f.setAccessible(false);
                } else if (f.getName().equals("y")) {
                    f.setAccessible(true);
                    assertEquals(message2, yExpected, f.getInt(p));
                    f.setAccessible(false);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 100)
    public void testGetX() {
        int x = 13;
        int y = 7;
        Point p = new Point(x, y);

        int xActual = p.getX();
        String message = "getX(): method did not return correct value for \"x\"";

        assertEquals(message, x, xActual);
    }

    @Test(timeout = 100)
    public void testSetX() {
        int x = -24;
        int y = -17;
        Point p = new Point(x, y);

        int xExpected = -91;
        int xActual = 0;
        p.setX(xExpected);

        Class<? extends Point> cl = p.getClass();

        Field[] declaredFields = cl.getDeclaredFields();

        for (Field f : declaredFields) {
            if (f.getName().equals("x")) {
                f.setAccessible(true);
                try {
                    xActual = f.getInt(p);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }

        String message = "setX(): member variable \"x\" was not set correctly";

        assertEquals(message, xExpected, xActual);
    }

    @Test(timeout = 100)
    public void testGetY() {
        int x = 13;
        int y = 7;
        Point p = new Point(x, y);

        int yActual = p.getY();
        String message = "getY(): method did not return correct value for \"y\"";

        assertEquals(message, y, yActual);
    }

    @Test(timeout = 100)
    public void testSetY() {
        int x = -24;
        int y = -17;
        Point p = new Point(x, y);

        int yExpected = -91;
        int yActual = 0;
        p.setY(yExpected);

        Class<? extends Point> cl = p.getClass();

        Field[] declaredFields = cl.getDeclaredFields();

        for (Field f : declaredFields) {
            if (f.getName().equals("y")) {
                f.setAccessible(true);
                try {
                    yActual = f.getInt(p);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }

        String message = "setY(): member variable \"y\" was not set correctly";

        assertEquals(message, yExpected, yActual);
    }

    @Test(timeout = 100)
    public void testHasDistanceMethodCorrectHeader() {
        Point p = new Point();

        Class<? extends Point> cl = p.getClass();

        Method[] methods = cl.getMethods();

        boolean hasCorrectMethod = false;

        for (Method m : methods) {
            if (m.getName().equals("distance") && m.getReturnType().getName().equals("double")
                    && m.getModifiers() == Modifier.PUBLIC && m.getParameterTypes().length == 1) {
                Class<?>[] c = m.getParameterTypes();
                if (c[0].getTypeName().equals("Point")) {
                    hasCorrectMethod = true;
                }
            }
        }

        String message = "distance(): method header is incorrect";
        assertTrue(message, hasCorrectMethod);
    }

    @Test(timeout = 100)
    public void testDistanceOriginOrigin() {
        Point p1 = new Point();
        Point p2 = new Point();

        double expectedDistance = 0;
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points on the origin";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceSameCoordinate() {
        Point p1 = new Point(7, 9);
        Point p2 = new Point(7, 9);

        double expectedDistance = 0;
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points have the same coordinate";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceOriginToQuadrantOne() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        double expectedDistance = 5;
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is the origin and the other is in the first quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceOriginaToQuadrantTwo() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-2, 2);

        double expectedDistance = Math.sqrt(8);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is the origin and the other is in the second quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceOriginToQuadrantThree() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-3, -7);

        double expectedDistance = Math.sqrt(58);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is the origin and the other is in the third quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceOriginToQuadrantFour() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(9,-13);

        double expectedDistance = Math.sqrt(250);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is the origin and the other is in the fourth quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantOneToQuadrantOne() {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(9, 2);

        double expectedDistance = Math.sqrt(45);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points are in in the first quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantOneToQuadrantTwo() {
        Point p1 = new Point(7, 11);
        Point p2 = new Point(-3, 6);

        double expectedDistance = Math.sqrt(125);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is in the first quadrant and one in the second quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantOneToQuadrantThree() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-4, -1);

        double expectedDistance = Math.sqrt(29);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is in the first quadrant and one in the third quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantOneToQuadrantFour() {
        Point p1 = new Point(14, 5);
        Point p2 = new Point(1, -12);

        double expectedDistance = Math.sqrt(458);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when one point is in the first quadrant and one in the fourth quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantTwoToQuadrantTwo() {
        Point p1 = new Point(-5, 7);
        Point p2 = new Point(-3, 1);

        double expectedDistance = Math.sqrt(40);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points are in the second quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantTwoToQuadrantThree() {
        Point p1 = new Point(-5, 9);
        Point p2 = new Point(-6, -4);

        double expectedDistance = Math.sqrt(170);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both ont point is in the second quadrant and one in the third quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantTwoToQuadrantFour() {
        Point p1 = new Point(-1, 1);
        Point p2 = new Point(1, -1);

        double expectedDistance = Math.sqrt(8);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both ont point is in the second quadrant and one in the fourth quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantThreeToQuadrantThree() {
        Point p1 = new Point(-3, -3);
        Point p2 = new Point(-7, -2);

        double expectedDistance = Math.sqrt(17);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points are in the third quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantThreeToQuadrantFour() {
        Point p1 = new Point(-11, -2);
        Point p2 = new Point(7, -9);

        double expectedDistance = Math.sqrt(373);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both ont point is in the third quadrant and one in the fourth quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }

    @Test(timeout = 100)
    public void testDistanceQuadrantFourToQuadrantFour() {
        Point p1 = new Point(8, -4);
        Point p2 = new Point(6, -9);

        double expectedDistance = Math.sqrt(29);
        double actualDistance1 = p2.distance(p1);
        double actualDistance2 = p1.distance(p2);

        String message = "distance(): check when both points are in the fourth quadrant";

        assertEquals(message, expectedDistance, actualDistance1, DELTA);

        assertEquals(message, expectedDistance, actualDistance2, DELTA);
    }
}
