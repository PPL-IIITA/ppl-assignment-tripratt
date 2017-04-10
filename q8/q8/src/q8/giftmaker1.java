package q8;

import java.io.IOException;

public class giftmaker1 {

	public void gifting(boy[] brr, girl[] grr, int[] n, int f, int[] price, couple[] c) throws IOException {
		if (brr[n[f]].type == 'm') {
			while (c[f].giftCost < grr[f].maintenanceCost)
				c[f].giftCost += price[f];
		} else if (brr[n[f]].type == 'g') {
			while (c[f].giftCost < grr[f].maintenanceCost)
				c[f].giftCost += price[f];
			if (brr[n[f]].budget > 0 && brr[n[f]].budget > price[f])
				c[f].giftCost += price[f];
		} else {
			while (c[f].giftCost < brr[n[f]].budget) {
				c[f].giftCost += price[f];
			}
		}
	}

}
