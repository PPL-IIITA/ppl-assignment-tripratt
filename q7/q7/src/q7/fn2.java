package q7;

public class fn2 {

	int[] arr = new int[50];
	int ind = -1;

	void insert2(int name) {
		arr[++ind] = name;
	}

	int[] search2(girl[] g, couple[] c, int[] b) {
		int len = b.length;
		int[] res1 = new int[len];
		int[] res = new int[len];
		int[] sorted_name = new int[12];
		for (int i = 0; i < 12; i++) {
			sorted_name[i] = c[i].nBoy;
		}
		couple temp;
		for (int i = 0; i < 12; i++) {
			for (int j = 1; j < 12; j++) {
				if (c[j - 1].nBoy > c[j].nBoy) {
					temp = c[j - 1];
					c[j - 1] = c[j];
					c[j] = temp;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			int start = 0;
			int end = 11, mid = -1;
			int key = b[i];
			while (start <= end) {
				mid = (start + end) / 2;
				if (key == c[mid].nBoy) {
					res[i] = mid;
					break;
				}
				if (key < c[mid].nBoy) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			if (start > end)
				res[i] = -1;
			else
				res[i] = mid;
		}
		for (int i = 0; i < len; i++) {
			if (res[i] == -1)
				res1[i] = -1;
			else
				res1[i] = c[res[i]].nGirl;
		}
		return res1;
	}
}
