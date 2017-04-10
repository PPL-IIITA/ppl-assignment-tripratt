package q5;

import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class couple {

	int nGirl;
	int nBoy;
	int happinessG;
	int happinessB;
	int happiness;
	int priceG, valueG;
	int giftCost;
	int compatibility;

	public void gifting(boy[] brr, girl[] grr) throws IOException {
		Date date = new Date();
		essentialGift[] e = new essentialGift[100];
		luxuryGift[] l = new luxuryGift[100];
		utilityGift[] u = new utilityGift[100];
		for (int i = 0; i < 100; i++) {
			l[i] = new luxuryGift();
			u[i] = new utilityGift();
			e[i] = new essentialGift();
		}
		couple[] c = new couple[12];
		for (int i = 0; i < c.length; i++) {
			c[i] = new couple();
		}
		for (int i = 0; i < c.length; i++) {
			c[i].giftCost = 0;
		}
		FileWriter out = null;
		FileWriter out1 = null;
		FileWriter out2 = null;
		FileWriter out3 = null;
		out1 = new FileWriter("C:\\Users\\dell\\Desktop\\q5\\luxuryGifts.txt");
		out = new FileWriter("C:\\Users\\dell\\Desktop\\q5\\essentialGifts.txt");
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\q5\\utilltyGifts.txt");
		out3 = new FileWriter("C:\\Users\\dell\\Desktop\\q5\\couple.txt");
		Random randomGenerator = new Random();
		for (int i = 0; i < 100; i++) {
			e[i].price = randomGenerator.nextInt(500);
			e[i].value = randomGenerator.nextInt(20);
			out.write(String.valueOf(e[i].price) + " ");
			out.write(String.valueOf(e[i].value) + "\n");
		}
		out.close();
		for (int i = 0; i < 100; i++) {
			u[i].price = randomGenerator.nextInt(800) + 400;
			u[i].value = randomGenerator.nextInt(50) + 20;
			out2.write(String.valueOf(u[i].price + " "));
			out2.write(String.valueOf(u[i].value + "\n"));
		}
		out2.close();
		for (int i = 0; i < 100; i++) {
			l[i].price = randomGenerator.nextInt(1200) + 800;
			l[i].value = randomGenerator.nextInt(80) + 50;
			out1.write(String.valueOf(l[i].price + " "));
			out1.write(String.valueOf(l[i].value + "\n"));
		}
		out1.close();
		final String alphabet = "mgj";
		final int N = alphabet.length();
		Random r = new Random();
		for (int z = 0; z < 12; z++) {
			brr[z].type = alphabet.charAt(r.nextInt(N));
		}
		int[] price = new int[300];
		for (int i = 0; i < 100; i++) {
			price[i] = e[i].price;
		}
		int j = 0;
		for (int i = 100; i < 200; i++) {
			price[i] = u[j].price;
			j++;
		}
		int k = 0;
		for (int i = 200; i < 300; i++) {
			price[i] = l[k].price;
			k++;
		}
		Arrays.sort(price);
		int[] n = new int[12];
		for (int i = 0; i < 12; i++) {
			if (grr[i].nB == -1)
				n[i] = -1;
			else {
				n[i] = search(brr, grr[i].nB);
			}

		}
		int h = 299;
		for (int i = 0; i < 12; i++) {
			if (brr[n[i]].type == 'm') {
				while (c[i].giftCost < grr[i].maintenanceCost)
					c[i].giftCost += price[i];
			} else if (brr[n[i]].type == 'g') {
				while (c[i].giftCost < grr[i].maintenanceCost)
					c[i].giftCost += price[i];
				if (brr[n[i]].budget > 0 && brr[n[i]].budget > price[h])
					c[i].giftCost += price[h];
			} else {
				while (c[i].giftCost < brr[n[i]].budget) {
					c[i].giftCost += price[h];
					h--;
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			c[i].nGirl = grr[i].name;
			c[i].nBoy = grr[i].nB;
		}
		System.out.println("The details of gifting are:");
		for (int i = 0; i < 12; i++) {
			out3.write(c[i].nGirl + " " + c[i].nBoy + " " + c[i].giftCost + "\n");
			System.out.println(c[i].nBoy + " gifted " + c[i].nGirl + " gifts worth Rs" + c[i].giftCost);
		}
		System.out.println("\n");
		out3.close();
		happiness(c, grr, brr, n);
		int[] happy = new int[12];
		int[] co = new int[12];
		for (int i = 0; i < 12; i++) {
			happy[i] = c[i].happiness;
			co[i] = c[i].compatibility;
		}
		Arrays.sort(happy);
		Arrays.sort(co);
		happy(happy, 4, c);
		compatible(co, 4, c);
	}

	public void happy(int[] h, int k, couple[] c) {
		System.out.println("The " + k + " most happiest couples are");
		int j = 0;
		for (int i = 11; i > 11 - k; i--) {
			j = 0;
			while (h[i] != c[j].happiness)
				j++;
			System.out.println(c[j].nBoy + " " + c[j].nGirl + " " + h[i]);
		}
		System.out.println("\n");
	}

	public void compatible(int[] co, int k, couple[] c) {
		int j = 0;
		System.out.println("The " + k + " most Compatible couples are");
		for (int i = 11; i > 11 - k; i--) {
			j = 0;
			while (co[i] != c[j].compatibility)
				j++;
			System.out.println(c[j].nBoy + " " + c[j].nGirl + " " + co[i]);
		}
		System.out.println("\n");
	}

	public static int search(boy[] arr, int s) {
		int i;
		for (i = 0; i < 58; i++) {
			if (s == arr[i].name)
				break;
		}
		return i;
	}

	public void happiness(couple[] crr, girl[] g, boy[] b, int[] n) {
		final String alphabet = "cnd";
		final int N = alphabet.length();
		Random r = new Random();
		for (int z = 0; z < 12; z++) {
			g[z].type = alphabet.charAt(r.nextInt(N));
		}
		for (int i = 0; i < 12; i++) {
			if (g[i].type == 'c') {
				crr[i].happinessG = abs((int) log(crr[i].giftCost) - g[i].maintenanceCost);
			} else if (g[i].type == 'n')
				crr[i].happinessG = crr[i].giftCost;
			else
				crr[i].happinessG = (int) exp(crr[i].giftCost) - g[i].maintenanceCost;
		}
		for (int i = 0; i < 12; i++) {
			if (b[n[i]].type == 'm')
				crr[i].happinessB = b[n[i]].budget - crr[i].giftCost;
			else if (b[n[i]].type == 'g')
				crr[i].happinessB = g[i].intelligenceLevel;
			else
				crr[i].happinessB = crr[i].happinessG;
		}
		for (int i = 0; i < 12; i++) {
			crr[i].compatibility = abs(b[n[i]].budget - g[i].maintenanceCost)
					+ abs(b[n[i]].intelligenceLevel - g[i].intelligenceLevel)
					+ abs(b[n[i]].attractiveness - g[i].attractiveness);
		}
		for (int i = 0; i < 12; i++)
			crr[i].happiness = abs(crr[i].happinessG + crr[i].happinessB);
	}

}
