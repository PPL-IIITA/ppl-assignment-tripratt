package q7;

import java.io.*;
import java.util.*;

public class qn7 {

	public void gen_couple() throws IOException {
		int i;
		girl[] g = new girl[12];
		boy[] b = new boy[58];
		for (i = 0; i < g.length; i++) {
			g[i] = new girl();
		}
		for (i = 0; i < b.length; i++) {
			b[i] = new boy();
		}
		FileReader in = null;
		FileReader in1 = null;
		FileWriter out = null;
		FileWriter out1 = null;
		in = new FileReader("C:\\Users\\dell\\Desktop\\q7\\log_g.txt");
		in1 = new FileReader("C:\\Users\\dell\\Desktop\\q7\\log_b.txt");
		out = new FileWriter("C:\\Users\\dell\\Desktop\\log_g.txt");
		out1 = new FileWriter("C:\\Users\\dell\\Desktop\\log_b.txt");
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 12; ++idx) {
			int att = randomGenerator.nextInt(10) + 10;
			int intell = randomGenerator.nextInt(10);
			int cost = randomGenerator.nextInt(1000);

			out.write(String.valueOf(att) + ",");
			out.write(String.valueOf(intell) + ",");
			out.write(String.valueOf(cost) + "\n");

		}
		out.close();
		for (int idx = 1; idx <= 58; ++idx) {
			int att_b = randomGenerator.nextInt(10);
			int intell_b = randomGenerator.nextInt(10);
			int low = 1000;
			int high = 3000;
			int budget = randomGenerator.nextInt(high - low) + low;
			int min_attr = randomGenerator.nextInt(5);
			out1.write(String.valueOf(att_b) + ",");
			out1.write(String.valueOf(intell_b) + ",");
			out1.write(String.valueOf(budget) + ",");
			out1.write(String.valueOf(min_attr) + "\n");
		}
		out1.close();
		String line;
		int m = 0;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q7\\log_g.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q7\\log_b.txt"));
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(",");
			g[m].attractiveness = Integer.parseInt(arr[0]);
			g[m].intelligenceLevel = Integer.parseInt(arr[1]);
			g[m].maintenanceCost = Integer.parseInt(arr[2]);
			m++;
		}
		int k = 0;
		while ((line = br1.readLine()) != null) {
			String[] brr = line.split(",");
			b[k].attractiveness = Integer.parseInt(brr[0]);
			b[k].intelligenceLevel = Integer.parseInt(brr[1]);
			b[k].budget = Integer.parseInt(brr[2]);
			b[k].minAttractivenessReq = Integer.parseInt(brr[3]);
			k++;
		}
		int line1;
		int x = 0, y = 0;
		BufferedReader gr = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q7\\nameGirl.txt"));
		BufferedReader gr1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q7\\nameBoy.txt"));
		while ((line1 = gr.read()) != -1 && x < 12) {
			g[x].name = line1;
			x++;
		}
		in.close();
		while ((line1 = gr1.read()) != -1 && y < 58) {
			b[y].name = line1;
			y++;
		}
		in1.close();
		final String seq = "rai";
		final int N = seq.length();
		Random r = new Random();
		for (int z = 0; z < 12; z++) {
			g[z].criteria = seq.charAt(r.nextInt(N));
		}
		final String seq2 = "mgj";
		final int N2 = seq2.length();
		Random r2 = new Random();
		for (int z = 0; z < 12; z++) {
			b[z].type = seq2.charAt(r2.nextInt(N2));
		}
		final String seq3 = "cnd";
		final int N3 = seq3.length();
		Random r3 = new Random();
		for (int z = 0; z < 12; z++) {
			g[z].type = seq3.charAt(r3.nextInt(N3));
		}
		
		int len = b.length;
		int ind;
		for (int z = 0; z < len; z++)
			b[z].isCommitted = 0;
		for (int z = 0; z < 12; z++) {
			if (g[z].criteria == 'r') {
				ind = linearSearch(b, 'r');
				b[ind].isCommitted = 1;
				g[z].nB = b[ind].name;
			} else if (g[z].criteria == 'i') {
				ind = linearSearch(b, 'i');
				b[ind].isCommitted = 1;
				g[z].nB = b[ind].name;
			} else if (g[z].criteria == 'a') {
				ind = linearSearch(b, 'a');
				b[ind].isCommitted = 1;
				g[z].nB = b[ind].name;
			}
		}
		FileWriter out2 = null;
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\couple.txt");
		for (int z = 0; z < 12; z++) {
			out2.write(g[z].name + " " + g[z].nB + '\n');
		}
		out2.close();
		couple[] c = new couple[12];
		for (i = 0; i < c.length; i++) {
			c[i] = new couple();
		}
		for (i = 0; i < c.length; i++) {
			c[i].giftCost = 0;
		}
		for (i = 0; i < 12; i++) {
			c[i].nGirl = g[i].name;
			c[i].nBoy = g[i].nB;
		}
		// print(g,b);
		int[] n = new int[12];
		for (i = 0; i < 12; i++) {
			n[i] = search(b, g[i].nB);
		}
		for (int v = 0; v < 12; v++) {
			c[v].gifting(b, g, n, v);
			c[v].happiness(g, b, n, v);
		}
		int happy[] = new int[12];
		for (int l = 0; l < 12; l++)
			happy[l] = c[l].happiness;
		Arrays.sort(happy);
		int[] arr_b1 = new int[30];
		BufferedReader gr2 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q7\\nameBoy.txt"));
		int line2;
		int yi = 0;
		while ((line2 = gr2.read()) != -1 && yi != 30) {
			arr_b1[yi] = line2;
			yi++;
		}
		int[] res = new int[30];

		Random d = new Random();
		int dr = d.nextInt(3);
		if (dr == 1) {
			System.out.println("Implemented Sorted Array");
			fn2 u = new fn2();
			res = u.search2(g, c, arr_b1);
			for (int q = 0; q < 30; q++) {
				if ("no".equals(res[q]))
					System.out.println(arr_b1[q] + " has no girlfriend");
				else
					System.out.println(arr_b1[q] + " has " + res[q] + " girlfriend");
			}
		} else if (dr == 0) {
			System.out.println("Implementation by Array");
			fn1 u = new fn1();
			res = u.search(g, c, arr_b1);
			for (int q = 0; q < 30; q++) {
				if ("no".equals(res[q]))
					System.out.println(arr_b1[q] + " has no girlfriend");
				else
					System.out.println(arr_b1[q] + " has " + res[q] + " girlfriend");
			}
		} else {
			System.out.println("Implemented Hashing");
			hSearching u = new hSearching();
			for (int q = 0; q < 12; q++) {
				u.storeData(c[q].nBoy, c[q].nGirl);
			}

			for (int q = 0; q < 30; q++) {
				res[q] = u.search(arr_b1[q]);
			}
			for (int q = 0; q < 30; q++) {
				if ("null".equals(res[q]))
					System.out.println(arr_b1[q] + " has no girlfriend");
				else
					System.out.println(arr_b1[q] + " has " + res[q] + " girlfriend");
			}
		}

	}

	public static boolean search_ex(int[] ar, int n) {
		int flag = 0;
		for (int m = 0; m < 4; m++) {
			if (n == ar[m])
				flag = 1;
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	public static int linearSearch(boy[] arr, char c) {
		int size = arr.length;
		int max = 0;
		int m = -1;
		if (c == 'r') {
			for (int i = 0; i < size; i++) {
				if (arr[i].budget > max && arr[i].isCommitted == 0) {
					max = arr[i].budget;
					m = i;
				}
			}
			return m;
		} else if (c == 'a') {
			for (int i = 0; i < size; i++) {
				if (arr[i].attractiveness > max && arr[i].isCommitted == 0) {
					max = arr[i].attractiveness;
					m = i;
				}
			}
			return m;
		} else {
			for (int i = 0; i < size; i++) {
				if (arr[i].intelligenceLevel > max && arr[i].isCommitted == 0) {
					max = arr[i].intelligenceLevel;
					m = i;
				}
			}
			return m;
		}
	}

	public static int search(boy[] arr, int s) {
		int i;
		for (i = 0; i < 58; i++) {
			if (s == arr[i].name)
				break;
		}
		return i;
	}

	public static int search_g(girl[] arr, int s) {
		int i;
		for (i = 0; i < 12; i++) {
			if (s == arr[i].name)
				break;
		}
		return i;
	}

	public void print(girl[] g, boy[] b) {
		System.out.println("The Couples formed are");
		for (int z = 0; z < 12; z++) {
			System.out.println(g[z].name + " " + g[z].nB);
		}
	}
}
