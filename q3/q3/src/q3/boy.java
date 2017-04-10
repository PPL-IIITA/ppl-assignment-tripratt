package q3;

public abstract class boy {

	int name;
	int attractiveness;
	int intelligenceLevel;
	int budget;
	int minAttractivenessReq;
	int isCommitted;

	public abstract void happiness(couple c, girl g);

	public abstract void calCost(girl g, couple c, int[] price);
}
