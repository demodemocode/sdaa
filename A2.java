import java.util.*;

class a2 {
	public static int ma(int[] pro, int[] dead, int[] seq, int n, int m) {
		List<int[]> jobs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			jobs.add(new int[] { pro[i], dead[i], seq[i] });

		}
		jobs.sort((a, b) -> Integer.compare(b[0], a[0]));
		int[] total = new int[m + 1];
		int[] total1 = new int[m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = jobs.get(i)[1]; j > 0; j--) {
				if (total[j] == 0) {
					total[j] = jobs.get(i)[0];
					total1[j] = jobs.get(i)[2];
					break;

				}
			}
		}
		int max = Arrays.stream(total).sum();
		System.out.println(Arrays.toString(total1));
		return max;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ennter n");
		int n = sc.nextInt();
		int pro[] = new int[n];
		int dead[] = new int[n];
		int seq[] = new int[n];
		int m = 0;

		System.out.println("Ennter prof");
		for (int i = 0; i < n; i++) {
			pro[i] = sc.nextInt();
			seq[i] = i + 1;
		}
		System.out.println("Ennter dead");
		for (int i = 0; i < n; i++) {
			dead[i] = sc.nextInt();
			if (m < dead[i]) {
				m = dead[i];
			}

		}
		int max = ma(pro, dead, seq, n, m);
		System.out.println(max);

	}
}