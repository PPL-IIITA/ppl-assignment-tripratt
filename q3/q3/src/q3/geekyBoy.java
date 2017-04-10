package q3;

public class geekyBoy extends boy {

	public void happiness(couple c, girl g) {
		c.happinessB = g.intelligenceLevel;
	}

	public void calCost(girl g, couple c, int[] price) {
		int j = 0;
		while (c.giftCost < g.maintenanceCost) {
			c.giftCost += price[j];
			j++;
		}
		if (budget > 0 && budget > price[j])
			c.giftCost += price[j];
	}

}
