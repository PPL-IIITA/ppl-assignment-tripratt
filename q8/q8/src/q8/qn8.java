package q8;

import java.io.*;
import java.util.*;

public class qn8 {

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
		in = new FileReader("C:\\Users\\dell\\Desktop\\q8\\log_g.txt");
		in1 = new FileReader("C:\\Users\\dell\\Desktop\\q8\\log_b.txt");
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
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q8\\log_g.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q8\\log_b.txt"));
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
		BufferedReader gr = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q8\\nameGirl.txt"));
		BufferedReader gr1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q8\\nameBoy.txt"));

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
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\q8\\couple.txt");
		for (int z = 0; z < 12; z++) {
			out2.write(g[z].name + " " + g[z].nB + '\n');
		}
		// out2.close();
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

		print(g, b);
		essentialGift[] e = new essentialGift[100];
		luxuryGift[] l = new luxuryGift[100];
		utilityGift[] u = new utilityGift[100];
		for (int p = 0; p < 100; p++) {
			l[p] = new luxuryGift();
			u[p] = new utilityGift();
			e[p] = new essentialGift();
		}
		FileWriter out3 = null;
		FileWriter out4 = null;
		FileWriter out5 = null;
		out3 = new FileWriter("luxuryGifts.txt");
		out4 = new FileWriter("essentialGifts.txt");
		out5 = new FileWriter("utilityGifts.txt");
		Random randomGenerator1 = new Random();
		for (int p = 0; p < 100; p++) {
			e[p].price = randomGenerator1.nextInt(500);
			e[p].value = randomGenerator1.nextInt(20);
			out4.write(String.valueOf(e[p].price) + " ");
			out4.write(String.valueOf(e[p].value) + "\n");
		}
		out4.close();
		for (int p = 0; p < 100; p++) {
			u[p].price = randomGenerator.nextInt(800) + 400;
			u[p].value = randomGenerator.nextInt(50) + 20;
			out5.write(String.valueOf(u[p].price + " "));
			out5.write(String.valueOf(u[p].value + "\n"));
		}
		out5.close();
		for (int p = 0; p < 100; p++) {
			l[p].price = randomGenerator.nextInt(1200) + 800;
			l[p].value = randomGenerator.nextInt(80) + 50;
			out3.write(String.valueOf(l[p].price + " "));
			out3.write(String.valueOf(l[p].value + "\n"));
		}
		out3.close();
		int[] price = new int[300];
		for (int p = 0; p < 100; p++) {
			price[p] = e[p].price;
		}
		int j = 0;
		for (int p = 100; p < 200; p++) {
			price[p] = u[j].price;
			j++;
		}
		int pi = 0;
		for (int p = 200; p < 300; p++) {
			price[p] = l[pi].price;
			pi++;
		}
		int[] n = new int[12];
		for (i = 0; i < 12; i++) {
			n[i] = search(b, g[i].nB);
		}

		Random d = new Random();
		int dr = d.nextInt(2);

		if (dr == 0) {
			System.out.println("implemented with old gifting algorithm ");
			giftmaker1 gf = new giftmaker1();
			for (int v = 0; v < 12; v++) {
				gf.gifting(b, g, n, v, price, c);
			}
		} else if (dr == 1) {
			System.out.println("implemented with new gifting algorithm ");
			giftmaker2 gf = new giftmaker2();
			for (int v = 0; v < 12; v++) {
				gf.gifting(b, g, n, v, price, c);
			}
		}

		else {
			System.out.println("Implemented with Default method of gifting ");
			giftmaker1 gf = new giftmaker1();
			for (int v = 0; v < 12; v++) {
				gf.gifting(b, g, n, v, price, c);
			}
		}
		for (int v = 0; v < 12; v++) {
			c[v].happiness(g, b, n, v);
		}

		for (int v = 0; v < 12; v++) {
			out2.write(c[v].nGirl + " " + c[v].nBoy + " " + c[v].giftCost + "\n");
		}
		out2.close();
		for (int v = 0; v < 12; v++) {
			System.out.println(c[v].nBoy + " gifted " + c[v].nGirl + " gifts worth Rs" + c[v].giftCost);
		}
		int happy[] = new int[12];
		for (int p = 0; p < 12; p++)
			happy[p] = c[p].happiness;
		Arrays.sort(happy);
		
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
