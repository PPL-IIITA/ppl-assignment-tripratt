package q5;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class qn5 {

	public void gen_couple() throws IOException {
		girl[] g = new girl[12];
		boy[] b = new boy[58];
		for (int i = 0; i < g.length; i++) {
			g[i] = new girl();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = new boy();
		}
		FileReader in = null;
		FileReader in1 = null;
		FileWriter out = null;
		FileWriter out1 = null;
		in = new FileReader("C:\\Users\\dell\\Desktop\\q5\\log_g.txt");
		in1 = new FileReader("C:\\Users\\dell\\Desktop\\q5\\log_b.txt");
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
		int i = 0;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q5\\log_g.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q5\\log_b.txt"));
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(",");
			g[i].attractiveness = Integer.parseInt(arr[0]);
			g[i].intelligenceLevel = Integer.parseInt(arr[1]);
			g[i].maintenanceCost = Integer.parseInt(arr[2]);
			i++;
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
		BufferedReader gr = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q5\\nameGirl.txt"));
		BufferedReader gr1 = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\q5\\nameBoy.txt"));
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

		girl t;
		boy s;
		int p;
		for (i = 0; i < 11; i++) {
			p = 0;
			for (int j = 0; j < 11 - i; j++) {
				if (g[j].maintenanceCost > g[j + 1].maintenanceCost) {
					t = g[j];
					g[j] = g[j + 1];
					g[j + 1] = t;
					p = 1;
				}
			}
			if (p == 0)
				break;
		}
		for (i = 0; i < 57; i++) {
			p = 0;
			for (int j = 0; j < 57 - i; j++) {
				if (b[j].attractiveness > b[j + 1].attractiveness) {
					s = b[j];
					b[j] = b[j + 1];
					b[j + 1] = s;
					p = 1;
				}
			}
			if (p == 0)
				break;
		}
		final String seq = "rai";
		final int N = seq.length();
		Random r = new Random();
		for (int z = 0; z < 12; z++) {
			g[z].criteria = seq.charAt(r.nextInt(N));
		}
		int it2 = 0, it1 = 0, ind;
		int len = b.length;
		for (int z = 0; z < len; z++)
			b[z].isCommitted = 0;
		for (int z = 0; z < 12; z++)
			g[z].isCommitted = 0;

		for (int z = 0; z < 12; z++) {
			if (z % 2 == 0) {
				it1 = 0;
				while (g[it1].isCommitted != 0) {
					it1++;
					if (it1 == 11)
						it1 = 0;
				}

				if (g[it1].criteria == 'r') {
					ind = linearSearch(b, 'r');
					if (b[ind].isCommitted == 0) {
						b[ind].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[ind].nG = g[it1].name;
					} else {
						while (b[ind].isCommitted != 0) {
							ind++;
							if (ind == 57)
								ind = 0;
						}
						b[ind].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[ind].nG = g[it1].name;
					}
				} else if (g[it1].criteria == 'i') {
					ind = linearSearch(b, 'i');

					if (b[ind].isCommitted == 0) {
						b[ind].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[ind].nG = g[it1].name;
					} else {
						while (b[ind].isCommitted != 0) {

							ind++;
							if (ind == 57)
								ind = 0;
						}

						b[ind].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[ind].nG = g[it1].name;
					}
				} else if (g[it1].criteria == 'a') {
					ind = linearSearch(b, 'a');
					if (b[ind].isCommitted == 0) {
						b[ind].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[ind].nG = g[it1].name;
					} else {
						while (b[it2].isCommitted != 0) {
							it2++;
							if (it2 == 57)
								it2 = 0;
						}
						b[it2].isCommitted = 1;
						g[it1].isCommitted = 1;
						g[it1].nB = b[ind].name;
						b[it2].nG = g[it1].name;
					}
				}
			} else {
				int maxi;
				it2 = 0;
				while (b[it2].isCommitted != 0) {
					it2++;
					if (it2 == 57)
						it2 = 0;
				}

				maxi = search_g(g);
				if (g[maxi].isCommitted == 0) {
					b[it2].isCommitted = 1;
					g[maxi].isCommitted = 1;
					g[maxi].nB = b[it2].name;
					b[it2].nG = g[maxi].name;
				} else {
					int ni = maxi;
					if (maxi == 11)
						maxi = 0;

					while (g[maxi].isCommitted != 0 && maxi != ni - 1) {
						maxi++;
						if (maxi == 11)
							maxi = 0;

					}
					b[it2].isCommitted = 1;
					g[maxi].isCommitted = 1;
					g[maxi].nB = b[it2].name;
					b[it2].nG = g[maxi].name;
				}
			}
		}
		for (int ti = 0; ti < 12; ti++) {
			int ho = 0;
			if (g[ti].nB == -1) {
				while (b[ho].isCommitted != 0)
					ho++;
				b[ho].isCommitted = 1;
				g[ti].isCommitted = 1;
				g[ti].nB = b[ho].name;
				b[ho].nG = g[ti].name;
			}
		}
		FileWriter out2 = null;
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\q5\\couple.txt");
		for (int z = 0; z < 12; z++) {
			out2.write(g[z].name + " " + g[z].nB + '\n');
		}
		out2.close();
		print(g, b);
		couple c = new couple();
		c.gifting(b, g);
	}

	public static int search_g(girl[] g) {
		int maxi = 0;
		int maxa = g[0].attractiveness;
		for (int l = 1; l < 12; l++) {
			if (g[l].attractiveness > maxa) {
				maxa = g[l].attractiveness;
				maxi = l;
			}
		}
		return maxi;
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

}
