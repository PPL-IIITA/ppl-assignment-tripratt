package q3;

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

	public void gifting(boy[] brr, girl[] grr, int[] n, int f, char[] type_g, char[] type_b) throws IOException {
		Date date = new Date();
		essentialGift[] e = new essentialGift[100];
		luxuryGift[] l = new luxuryGift[100];
		utilityGift[] u = new utilityGift[100];
		for (int i = 0; i < 100; i++) {
			l[i] = new luxuryGift();
			u[i] = new utilityGift();
			e[i] = new essentialGift();
		}
		FileWriter out = null;
		FileWriter out1 = null;
		FileWriter out2 = null;
		FileWriter out3 = null;
		out1 = new FileWriter("C:\\Users\\dell\\Desktop\\q3\\luxuryGifts.txt");
		out = new FileWriter("C:\\Users\\dell\\Desktop\\q3\\essentialGifts.txt");
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\q3\\utilityGifts.txt");
		out3 = new FileWriter("C:\\Users\\dell\\Desktop\\q3\\couple.txt");
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
		int h = 299;

		brr[n[f]].calCost(grr[f], this, price);

		out3.write(nGirl + " " + nBoy + " " + giftCost + "\n");

		out3.close();
	}

	public void happy(int[] h, int[] n, int i, girl[] g, boy[] b) {
		System.out.println("The " + 4 + " most happiest couples are");
		int j = 0;

		j = 0;
		while (h[i] != this.happiness)
			j++;
		System.out.println(g[n[j]].name + " " + b[n[j]].name + " " + h[i]);

	}

	public void compatible(int[] co, int i, int[] n, girl[] g, boy[] b) {
		int j = 0;
		System.out.println("The " + 4 + " most Compatible couples are");

		j = 0;
		while (co[i] != this.compatibility)
			j++;
		System.out.println(g[n[j]].name + " " + b[n[j]].name);

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

	public void happinesss(girl[] g, boy[] b, int[] n, int i, char[] type_g, char[] type_b) {

		g[i].happiness(g[i], this);
		b[n[i]].happiness(this, g[i]);

		this.compatibility = abs(b[n[i]].budget - g[i].maintenanceCost)
				+ abs(b[n[i]].intelligenceLevel - g[i].intelligenceLevel)
				+ abs(b[n[i]].attractiveness - g[i].attractiveness);

		this.happiness = abs(this.happinessG + this.happinessB);

	}

}
