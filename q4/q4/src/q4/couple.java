package q4;

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

	public void gifting(boy[] brr, girl[] grr, int[] n, int f) throws IOException {
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
		out1 = new FileWriter("C:\\Users\\dell\\Desktop\\q4\\luxuryGifts.txt");
		out = new FileWriter("C:\\Users\\dell\\Desktop\\q4\\essentialGifts.txt");
		out2 = new FileWriter("C:\\Users\\dell\\Desktop\\q4\\utilityGifts.txt");
		out3 = new FileWriter("C:\\Users\\dell\\Desktop\\q4\\couple.txt");
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

		if (brr[n[f]].type == 'm') {
			while (giftCost < grr[f].maintenanceCost)
				giftCost += price[f];
		} else if (brr[n[f]].type == 'g') {
			while (giftCost < grr[f].maintenanceCost)
				giftCost += price[f];
			if (brr[n[f]].budget > 0 && brr[n[f]].budget > price[h])
				giftCost += price[h];
		} else {
			while (giftCost < brr[n[f]].budget) {
				giftCost += price[h];
				h--;
			}
		}

		out3.write(nGirl + " " + nBoy + " " + giftCost + "\n");

		out3.close();

	}

	public void happy(int[] h, int k, int[] n, girl[] g, boy[] b) {

		int j = 0;
		for (int i = 11; i > 11 - k; i--) {
			j = 0;
			while (h[i] != happiness)
				j++;
			System.out.println(g[n[j]].name + " " + b[n[j]].name + " " + h[i]);
		}

	}

	public void compatible(int[] co, int k, couple[] c) {
		int j = 0;
		System.out.println("The " + k + " Most compatible couples are");
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

	public void happiness(girl[] g, boy[] b, int[] n, int i) {

		if (g[i].type == 'c') {
			happinessG = abs((int) log(giftCost) - g[i].maintenanceCost);
		} else if (g[i].type == 'n')
			happinessG = giftCost;
		else
			happinessG = (int) exp(giftCost) - g[i].maintenanceCost;

		if (b[n[i]].type == 'm')
			happinessB = b[n[i]].budget - giftCost;
		else if (b[n[i]].type == 'g')
			happinessB = g[i].intelligenceLevel;
		else
			happinessB = happinessG;

		compatibility = abs(b[n[i]].budget - g[i].maintenanceCost)
				+ abs(b[n[i]].intelligenceLevel - g[i].intelligenceLevel)
				+ abs(b[n[i]].attractiveness - g[i].attractiveness);
		happiness = abs(happinessG + happinessB);
	}

}
