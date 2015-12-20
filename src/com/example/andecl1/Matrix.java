package com.example.andecl1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	public static double d[][];
	public static String s = "matrix has you";

	public static void main(String args[]) {
		System.out.println(s);
		
		 d = new double[3][3]; 
		 d[0][0] = 1; 
		 d[0][1] = 2; 
		 d[0][2] = 2; 
		 d[1][0] = 1; 
		 d[1][1] = 3; 
		 d[1][2] = 1; 
		 d[2][0] = 2; 
		 d[2][1] = 3; 
		 d[2][2] = 1;
		
	/*	d = new double[2][2];
		d[0][0]=2;
		d[0][1]=5;
		d[1][0]=5;
		d[1][1]=8;
	/*	d = new double[7][7];
		d[0][0]=2;
		d[0][1]=5;
		d[0][2]=5;
		d[0][3]=8;
		d[0][4]=4;
		d[0][5]=8;
		d[0][6]=4;
		d[1][0]=1;
		d[1][1]=6;
		d[1][2]=8;
		d[1][3]=7;
		d[1][4]=6;
		d[1][5]=1;
		d[1][6]=2;
		d[2][0]=7;
		d[2][1]=8;
		d[2][2]=8;
		d[2][3]=9;
		d[2][4]=8;
		d[2][5]=0;
		d[2][6]=1;
		d[3][0]=1;
		d[3][1]=2;
		d[3][2]=2;
		d[3][3]=5;
		d[3][4]=8;
		d[3][5]=7;
		d[3][6]=7;
		d[4][0]=3;
		d[4][1]=3;
		d[4][2]=3;
		d[4][3]=3;
		d[4][4]=7;
		d[4][5]=4;
		d[4][6]=5;
		d[5][0]=5;
		d[5][1]=9;
		d[5][2]=8;
		d[5][3]=1;
		d[5][4]=2;
		d[5][5]=2;
		d[5][6]=2;
		d[6][0]=2;
		d[6][1]=3;
		d[6][2]=9;
		d[6][3]=6;
		d[6][4]=6;
		d[6][5]=4;
		d[6][6]=3;
		*/
		
		System.out.println(calcM(d));
		System.exit(0);
	}

	public static int calc(int i) {
		// System.out.println(i);
		return i * i;
	}

	public static double calc2x2(double[][] d) {
		if ((d.length != 2) | (d[0].length != 2)) {
			// System.out.println("not 2*2");
			return 0;
		}
		double d2 = d[1][1] * d[0][0] - d[0][1] * d[1][0];
		System.out.println("2*2 " + d[1][1] + " " + d[0][0] + " " + d[0][1] + " " + d[1][0]);
		System.out.println("2*2 = " + d2);
		return d2;
	}

	public static double calcM(double[][] d) {
		double res = 0;
		System.out.println("matrix               size " + d.length + "  " + d[0].length);
		for (int g1 = 0; g1 < d.length; g1++) {
			for (int g2 = 0; g2 < d[g1].length; g2++) {
				System.out.print(d[g1][g2] + "  ");
			}
			System.out.println("");
		}

		for (int i1 = 0; i1 < d.length; i1++) {
			System.out.println("i1 " + i1);
			// System.out.println("3*3 " + i1);
			// res += d[i1][0] * (Math.pow(-1, i1)) * calc2x2(calcAlgDop(d,
			// i1));
			res += d[i1][0] * (Math.pow(-1, i1)) * calcCommon(d, i1);
			System.out.println("d[i1][0] " + d[i1][0]);
			System.out.println("ii1 " + i1);
			System.out.println("d[i1][0] * (Math.pow(-1, i1)) " + d[i1][0] * (Math.pow(-1, i1)));
			System.out.println("res1 " + res);
		}
		System.out.println("                                           res = " + res);
		return res;
	}

	private static double calcCommon(double[][] d2, int i) {
		double res = 0;
		d2 = calcAlgDop(d2, i);

		if ((d2.length == 2) & (d2[0].length == 2))
			res = calc2x2(d2);
		else
			res=calcM(d2);
		return res;
	}

	private static double[][] calcAlgDop(double[][] d2, int i) {
		System.out.println("m1 before size " + d2.length + "  " + d2[0].length);
		double tempMatrix[][] = new double[d2.length - 1][d2[0].length - 1];

		int coun1 = 0;
		int coun2 = 0;
		// System.out.println("row "+d2.length+" col "+d2[0].length);
		b1: for (int i1 = 0; i1 < d2.length; i1++) {
			for (int i2 = 0; i2 < d2[0].length; i2++) {
				// System.out.println(" " + i1 + " " + i2 + " d = " +
				// d2[i1][i2]+" coun1 "+coun1+" coun2 "+coun2);
				if ((i1 != i) & (i2 != 0)) {
					// System.out.println("true " + i1 + " " + i2 + " d = " +
					// d2[i1][i2]);
					// System.out.println("true");
					tempMatrix[i1 - coun1][i2 - coun2] = d2[i1][i2];
					// break;
				}
				if (i1 == i) {
					coun1 = 1;
					// continue b1;
				}
				if (i2 == 0) {
					coun2 = 1;
					// continue b1;
				}
				// tempMatrix[i1 - coun1][i2 - coun2] = 0;

			}
		}
		// System.out.println("tempMatrix= " + tempMatrix[0][0] + " " +
		// tempMatrix[0][1] + " " + tempMatrix[1][0] + " " + tempMatrix[1][1]);
		System.out.println("m1 after size " + tempMatrix.length + "  " + tempMatrix[0].length);
		return tempMatrix;
	}	
}
