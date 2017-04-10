package q7;

public class hSearching extends searching {

	log[] table = new log[size];

	public hSearching() {
		for (int i = 0; i < size; i++) {
			table[i] = null;

		}
	}

	int hash(int value) {
		return value * 100;
	}

	public void storeData(int boy_name, int girl_name) {
		int h = hash(boy_name) % size;
		while (table[h] != null)
			h = (h + 1) % size;
		table[h] = new hLog();
		table[h].bf = boy_name;
		table[h].gf = girl_name;

	}

	public int search(int value) {
		int h = hash(value) % size;
		for (int i = 0; i < size; i++) {
			h = (h + i) % size;
			if (table[h].bf == value)
				return table[h].gf;
		}
		return -1;
	}

}
