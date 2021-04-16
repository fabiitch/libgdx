
package com.badlogic.gdx.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vector3Test {
    @Test
    public void testToString() {
        assertEquals("(-5.0,42.00055,44444.32)", new Vector3(-5f, 42.00055f, 44444.32f).toString());
    }

    @Test
    public void testFromString() {
        assertEquals(new Vector3(-5f, 42.00055f, 44444.32f), new Vector3().fromString("(-5,42.00055,44444.32)"));
    }


    @Test
    public void testLenLen2() {
        {
            for (int i = 0; i < 1000; i++) {
                float random1 = MathUtils.random(100f);
                float random2 = MathUtils.random(100f);
                float random3 = MathUtils.random(100f);
                Vector3 v3 = new Vector3(random1, random2,random3);
                Vector3 v3Nor = new Vector3(v3);
                v3Nor.nor();
                float len = v3Nor.len();
                float len2 = v3Nor.len2();
                System.out.println("=========");
                System.out.println("V2 = " + v3.toString() + "   nor=" + v3Nor.toString());

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
