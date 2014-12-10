public class my {
	public static void main(String args[]) {
		int a[] = { 0, 3, 5, -4, 2, 7 };
		sort(a);
	}

	public static void sort(int A[]) {
		int max = A[0];
		int min = A[0];
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
			if (min > A[i]) {
				min = A[i];
			}
		}
		int TMP[] = new int[max - min + 1];
		for (int i = 0; i < A.length; i++) {
			TMP[A[i] - min]++;
		}
		int j = 0;
		for (int i = 0; i < TMP.length; i++) {
			while (TMP[i] > 0) {
				A[j++] = i + min;
				TMP[i]--;
			}
		}
	}

	public static void sort2(int[] A, int start, int end) {
		int i = start;
		int j = end;
		int x = A[(start + end) / 2];
		do {
			while (A[i] < x)
				++i;
			while (A[j] > x)
				--j;
			if (i <= j) {
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				i++;
				j--;
			}
		} while (i <= j);
		if (start < j)
			sort2(A, start, j);
		if (i < end)
			sort2(A, i, end);
	}
}