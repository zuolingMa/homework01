package com.mzl.homework01;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToolsNGTest {
	
	public ToolsNGTest() {
	}
	@Test(enabled = true)
	public void testToBinary() {
		System.out.println("toBinary");
    	int num = 128;
    	String expResult = "10000000";
    	assertEquals(Tools.toBinary(num),expResult);
	}
	@Test(enabled = true)
	public void testToOctal() {
		System.out.println("toOctal");
    	int num = -37;
    	String expResult = "-45";
    	assertEquals(Tools.toOctal(num),expResult);
	}
	@Test(enabled = true)
    public void testToHexadecimal() {
		System.out.println("toHexadecimal");
    	int num = 355;
    	String expResult = "163";
    	assertEquals(Tools.toHexadecimal(num),expResult);
    }
	@Test(enabled = true)
    public void testToOther() {
		System.out.println("toOther");
    	int num = -25;
    	int d = 8;
    	String expResult = "-31";
    	assertEquals(Tools.toOther(num,d),expResult);
    }
	@Test
    public void testToChar() {
        Object[][] datas = new Object[][] {{1, '1'},
            {5,'5'}, {10,'A'}, {11, 'B'}, {12, 'C'},
            {13, 'D'}, {14,'E'}, {15,'F'}
        };
        for (Object[] data : datas) {
            char result = Tools.toChar((Integer)data[0]);
            char expResult = (Character)data[1];
            assertEquals(result, expResult);
        }
    }
	@DataProvider(name="dataForMatch")
    public Object[][] dataForIsMatch() {
        return new Object[][] { {"12+[(12+23)*4)*5", false},
                {"12+[(12+23)+15]*12", true},
                {"[[(])]", false},
                {"([])()[]", true}};
    }
	@Test(dataProvider="dataForMatch")
    public void testIsMatch(String exp, boolean expResult) {
        System.out.println("isMatch");
        boolean result = Tools.isMatch(exp);
        assertEquals(result, expResult);
    }
}
