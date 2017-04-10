package q3;

import java.io.*;
import java.util.Random;
import java.util.Arrays;

public class qn3 {

	public void fnc() throws FileNotFoundException, IOException {
		girl[] g = new girl[12];
		boy[] b = new boy[58];
		char[] cateG = new char[12];
		char[] cateB = new char[58];
		final String seq3 = "cnd";
		final int N3 = seq3.length();
		Random r3 = new Random();
		for (int z = 0; z < 12; z++) {
			cateG[z] = seq3.charAt(r3.nextInt(N3));
		}
		final String seq2 = "mgj";
		final int N2 = seq2.length();
		Random r2 = new Random();
		for (int z = 0; z < 58; z++) {
			cateB[z] = seq2.charAt(r2.nextInt(N2));
		}
		FileReader in = null;
		FileReader in1 = null;
		FileWriter out = null;
		FileWriter out1 = null;
		in = new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_g.txt");
		in1 = new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_b.txt");
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
		String line;
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
		int m = 0, k = 0;
		for (int i = 0; i < 12; i++) {
			if (cateG[i] == 'c') {
				g[i] = new choosyGirl();

				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_g.txt"));
				line = br.readLine();

				String[] arr = line.split(",");
				g[m].attractiveness = Integer.parseInt(arr[0]);
				g[m].intelligenceLevel = Integer.parseInt(arr[1]);
				g[m].maintenanceCost = Integer.parseInt(arr[2]);
				m++;

			} else if (cateG[i] == 'n') {
				g[i] = new normalGirl();

				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_g.txt"));
				line = br.readLine();

				String[] arr = line.split(",");
				g[m].attractiveness = Integer.parseInt(arr[0]);
				g[m].intelligenceLevel = Integer.parseInt(arr[1]);
				g[m].maintenanceCost = Integer.parseInt(arr[2]);
				m++;

			} else {
				g[i] = new desparateGirl();

				BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_g.txt"));
				line = br.readLine();
				{
					String[] arr = line.split(",");
					g[m].attractiveness = Integer.parseInt(arr[0]);
					g[m].intelligenceLevel = Integer.parseInt(arr[1]);
					g[m].maintenanceCost = Integer.parseInt(arr[2]);
					m++;
				}
			}
		}
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\log_b.txt"));
		for (int i = 0; i < 58; i++) {
			if (cateB[i] == 'm') {
				b[i] = new miserBoy();

				line = br1.readLine();

				String[] brr = line.split(",");
				b[k].attractiveness = Integer.parseInt(brr[0]);
				b[k].intelligenceLevel = Integer.parseInt(brr[1]);
				b[k].budget = Integer.parseInt(brr[2]);
				b[k].minAttractivenessReq = Integer.parseInt(brr[3]);
				k++;

			} else if (cateB[i] == 'g') {
				b[i] = new geekyBoy();
				line = br1.readLine();

				String[] brr = line.split(",");
				b[k].attractiveness = Integer.parseInt(brr[0]);
				b[k].intelligenceLevel = Integer.parseInt(brr[1]);
				b[k].budget = Integer.parseInt(brr[2]);
				b[k].minAttractivenessReq = Integer.parseInt(brr[3]);
				k++;

			} else {
				b[i] = new generousBoy();
				line = br1.readLine();

				String[] brr = line.split(",");
				b[k].attractiveness = Integer.parseInt(brr[0]);
				b[k].intelligenceLevel = Integer.parseInt(brr[1]);
				b[k].budget = Integer.parseInt(brr[2]);
				b[k].minAttractivenessReq = Integer.parseInt(brr[3]);
				k++;

			}
		}
		int line1;
		int x = 0, y = 0;
		BufferedReader gr = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\nameGirl.txt"));
		BufferedReader gr1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q3\\nameBoy.txt"));
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
		gen_criteria(g);
		int ind;
		for (int z = 0; z < 58; z++)
			b[z].isCommitted = 0;
		int[] ind_b = new int[58];
		for (int i = 0; i < 58; i++)
			ind_b[i] = -1;
		for (int z = 0; z < 12; z++) {
			if (g[z].criteria == 'r') {
				ind = linearSearch(b, 'r');
				b[ind].isCommitted = 1;
				ind_b[z] = ind;
				g[z].nB = b[ind].name;
			} else if (g[z].criteria == 'i') {
				ind = linearSearch(b, 'i');
				b[ind].isCommitted = 1;
				ind_b[z] = ind;
				g[z].nB = b[ind].name;
			} else if (g[z].criteria == 'a') {
				ind = linearSearch(b, 'a');
				b[ind].isCommitted = 1;
				ind_b[z] = ind;
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
		for (int i = 0; i < c.length; i++) {
			c[i] = new couple();
		}
		for (int i = 0; i < c.length; i++) {
			c[i].giftCost = 0;
		}
		for (int i = 0; i < 12; i++) {
			c[i].nGirl = g[i].name;
			c[i].nBoy = g[i].nB;
		}
		print(g, b);
		int[] n = new int[12];
		for (int i = 0; i < 12; i++) {
			n[i] = search(b, g[i].nB);
		}

		for (int v = 0; v < 12; v++) {
			c[v].gifting(b, g, n, v, cateG, cateB);
			c[v].happinesss(g, b, n, v, cateG, cateB);
		}

		int[] happy = new int[12];
		int[] co = new int[12];
		for (int i = 0; i < 12; i++) {
			happy[i] = c[i].happiness;
			co[i] = c[i].compatibility;
		}

		int ki = 4;
		Arrays.sort(happy);
		Arrays.sort(co);

		System.out.println("The " + 4 + " most happiest couples are");
		for (int i = 11; i > 11 - ki; i--) {
			int j = 0;
			j = 0;
			while (happy[i] != c[j].happiness)
				j++;
			// System.out.println(n[j]);
			System.out.println(c[j].nGirl + " " + c[j].nBoy + " " + happy[i]);
		}
		System.out.println("The " + 4 + " most Compatible couples are");
		for (int i = 11; i > 11 - ki; i--) {
			int j = 0;
			j = 0;
			while (co[i] != c[j].compatibility)
				j++;
			System.out.println(c[j].nGirl + " " + c[j].nBoy);
		}
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

	public void print(girl[] g, boy[] b) {
		System.out.println("The couples formed are");
		for (int z = 0; z < 12; z++) {
			System.out.println(g[z].name + " " + g[z].nB);
		}
	}

	public void gen_criteria(girl[] g) {
		final String seq = "rai";
		final int N = seq.length();
		Random r = new Random();
		for (int z = 0; z < 12; z++) {
			g[z].criteria = seq.charAt(r.nextInt(N));
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

}
