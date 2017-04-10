package q8;

import java.io.IOException;

public class giftmaker2 {

	public void gifting(boy[] brr, girl[] grr, int[] n, int f, int[] price, couple[] c) throws IOException {
		int i = 0, j = 100, k = 200;
		if (brr[n[f]].type == 'm') {
			c[f].giftCost += price[i++] + price[j++] + price[k++];
			while (c[f].giftCost < grr[f].maintenanceCost)
				c[f].giftCost += price[f];
		} else if (brr[n[f]].type == 'g') {
			c[f].giftCost += price[i++] + price[j++] + price[k++];
			while (c[f].giftCost < grr[f].maintenanceCost)
				c[f].giftCost += price[f];
			if (brr[n[f]].budget > 0 && brr[n[f]].budget > price[f])
				c[f].giftCost += price[f];
		} else {
			c[f].giftCost += price[i++] + price[j++] + price[k++];
			while (c[f].giftCost < brr[n[f]].budget) {
				c[f].giftCost += price[f];
			}
		}
	}
}
