
package com.badlogic.gdx.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector2Test {
    @Test
    public void testToString() {
        assertEquals("(-5.0,42.00055)", new Vector2(-5f, 42.00055f).toString());
    }

    @Test
    public void testFromString() {
        assertEquals(new Vector2(-5f, 42.00055f), new Vector2().fromString("(-5,42.00055)"));
    }

    @Test
    public void testAngle() {
        assertEquals(270f, new Vector2(0, -1f).angleDeg(), MathUtils.FLOAT_ROUNDING_ERROR);
    }

    @Test
    public void testAngleRelative() {
        assertEquals(270f, new Vector2(0, -1f).angleDeg(Vector2.X), MathUtils.FLOAT_ROUNDING_ERROR);
    }

    @Test
    public void testAngleRad() {
        assertEquals(-MathUtils.HALF_PI, new Vector2(0, -1f).angleRad(), MathUtils.FLOAT_ROUNDING_ERROR);
    }

    @Test
    public void testAngleRadRelative() {
        assertEquals(-MathUtils.HALF_PI, new Vector2(0, -1f).angleRad(Vector2.X), MathUtils.FLOAT_ROUNDING_ERROR);
    }


    @Test
    public void testLenLen2() {
        {
            for (int i = 0; i < 1000; i++) {
                float random1 = MathUtils.random(100f);
                float random2 = MathUtils.random(100f);

                Vector2 v2 = new Vector2(random1, random2);
                Vector2 v2Nor = new Vector2(v2);
                v2Nor.nor();
                float len = v2Nor.len();
                float len2 = v2Nor.len2();
                System.out.println("=========");
                System.out.println("V2 = " + v2.toString() + "   nor=" + v2Nor.toString());

                if (len != 1f) {
                    System.out.println("error : len()=" + len + "  != 1f");
                }
                if (len2 != 1f) {
                    System.out.println("error : len2()=" + len2 + " != 1f");
                }
                if (!MathUtils.isEqual(len, 1f)) {
                    System.out.println("error : len()=" + len + " != 1f with FLOAT_ROUNDING_ERROR");
                }
                if (!MathUtils.isEqual(len2, 1f)) {
                    System.out.println("error : len2()=" + len2 + " != 1f for  FLOAT_ROUNDING_ERROR tolerance ");
                }
            }
        }
    }
}
