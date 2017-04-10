package q10;

public class fn<t> {

	public void fnc(t[] arr, int k, int[] s) {
		int l = arr.length;
		t temp;
		for (int i = 0; i < l; i++) {
			for (int j = 1; j < (l - i); j++) {
				if (s[j - 1] > s[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}
}
