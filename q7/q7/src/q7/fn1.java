package q7;

public class fn1 {

	int[] arr = new int[50];
	int ind = -1;

	void insert(int name) {
		arr[++ind] = name;
	}

	int[] search(girl[] g, couple[] c, int[] b) {
		int len = b.length;
		int[] res = new int[len];

		for (int i = 0; i < len; i++) {
			int flag = 1;
			int j = 0;
			while (b[i] != c[j].nBoy) {
				j++;
				if (j == 12) {
					flag = 0;
					break;
				}
			}

			if (flag == 0)
				res[i] = -1;
			else
				res[i] = c[j].nGirl;
		}
		return res;
	}
}
