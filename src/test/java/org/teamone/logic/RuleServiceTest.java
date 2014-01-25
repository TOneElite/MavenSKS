
package org.teamone.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author Kim
 */
public class RuleServiceTest {
	
	RuleService rs = new RuleService();
	
	/**
	 * Test of replaceLast method, of class RuleService.
	 */
	@Test
	public void testReplaceLast() {
		String input = "Hei du";
		String replace = "u";
		String with = "ubidu";
		
		String expected = "Hei dubidu";
		String actual = rs.replaceLast(input, replace, with);
		assertEquals(expected, actual);
	}

	/**
	 * Test of readTabletoRules method, of class RuleService.
	 */
	@Test
	public void testReadTabletoRules() {
		int[][] input = {{5,1,1,1,1,1,1,1}, {1,1,1,0,0,0,0,0}, {3,0,0,0,1,1,1,0}};
		String expected = "5{1,2,3,4,5,6,7};1{1,2};3{4,5,6}";
		String actual = rs.readTabletoRules(input);
		assertEquals(expected, actual);
	}

	/**
	 * Test of readRuleString method, of class RuleService.
	 */
	@Test
	public void testReadRuleString() {
		int[][] expected = {{5,1,1,1,1,1,1,1}, {1,1,1,0,0,0,0,0}, {3,0,0,0,1,1,1,0}};
		String input = "5{1,2,3,4,5,6,7};1{1,2};3{4,5,6}";
		int[][] actual = rs.readRuleString(7, input);
		
		for(int i=0; i<actual.length; i++){
			for (int j=0; j<actual[i].length; j++){
				assertEquals(expected[i][j], actual[i][j]);
			}
		}
	}

	/**
	 * Test of vertifyRequirements method, of class RuleService.
	 */
	@Test
	public void testVertifyRequirements() {
		boolean[] tasksDone1 = {true, true, false, true, true, true, false};
		int[][] rules = {{5,1,1,1,1,1,1,1}, {1,1,1,0,0,0,0,0}, {3,0,0,0,1,1,1,0}};
		boolean actual = rs.vertifyRequirements(tasksDone1, rules);
		assertTrue(actual);
		
		boolean[] tasksDone2 = {true, true, false, false, true, true, false};
		boolean actual2 = rs.vertifyRequirements(tasksDone2, rules);
		assertFalse(actual2);
	}

	/**
	 * Test of readRulesNOR method, of class RuleService.
	 */
	@Test
	public void testReadRulesNOR() {
		int[][] rules = {{5,1,1,1,1,1,1,1}, {1,1,1,0,0,0,0,0}, {3,0,0,0,1,1,1,0}};
		String expected1 = "Du trenger: 5 av følgende øvinger: 1, 2, 3, 4, 5, 6 og 7";
		String expected2 = "Du trenger: 1 av følgende øvinger: 1 og 2";
		String expected3 = "Du trenger: 3 av følgende øvinger: 4, 5 og 6";
		
		String[] actual = rs.readRulesNOR(rules);
		assertEquals(expected1.trim(), actual[0].trim());
		assertEquals(expected2.trim(), actual[1].trim());
		assertEquals(expected3.trim(), actual[2].trim());
		
	}
}