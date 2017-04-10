package q8;

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

	public void gifting(boy[] brr, girl[] grr, int[] n, int f, int[] price) throws IOException {

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
