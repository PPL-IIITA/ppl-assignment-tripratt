package q3;

import static java.lang.Math.*;

public class choosyGirl extends girl {

	public void happiness(girl g, couple c) {
		c.happinessG = abs((int) log(c.giftCost) - g.maintenanceCost);
	}
}
