package q3;

public class miserBoy extends boy {

	public void happiness(couple c, girl g) {
		c.happinessB = budget - c.giftCost;
	}

	public void calCost(girl g, couple c, int[] price) {
		int j = 0;
		while (c.giftCost < g.maintenanceCost) {
			c.giftCost += price[j];
			j++;
		}
	}

}
