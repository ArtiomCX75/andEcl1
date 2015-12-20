package com.example.andecl1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//import java.util.Random;
import static org.junit.Assert.*;

public class CodeWar {

	public static List<Integer> sqInRect(int lng, int wdth) {
		//List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
		if (lng == wdth) {
			return null;
		} else {
			int r = lng * wdth;
			int i = r;
			while (r > 0) {
				if (i * i < r) {
					r = r - i * i;
			//		res.add(i);
				} else {
					i--;
				}
			}
		//	return res;
			return null;
		}
	}

	@Test
	public void test1() {
		List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
		for (int r : res)
			assertEquals(res, CodeWar.sqInRect(5, 3));
	}
}