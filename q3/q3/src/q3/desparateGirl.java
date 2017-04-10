package q3;

import static java.lang.Math.*;

public class desparateGirl extends girl {

	public void happiness(girl g, couple c) {
		c.happinessG = (int) exp(c.giftCost) - g.maintenanceCost;
	}

}
