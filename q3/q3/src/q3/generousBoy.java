package q3;

public class generousBoy extends boy {

	public void happiness(couple c, girl g) {
		c.happinessB = c.happinessG;
	}

	public void calCost(girl g, couple c, int[] price) {
		int j = 0;
		while (c.giftCost < budget) {
			c.giftCost += price[j];
			j++;
		}
	}

}
