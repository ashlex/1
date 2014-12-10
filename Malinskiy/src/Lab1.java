import java.util.ArrayList;
import java.util.Random;


public class Lab1 {
	public  double[][] exp = new double[1000][2];
	public  int N = 1000;
	public ArrayList<Double[]> f = new ArrayList<Double[]>();

	public Lab1() {
		Random rnd = new Random();
		double x, y;
		int i = 0;
		double tmp[] = new double[N];
		while (true) {
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = rnd.nextDouble() * 100;
			}
			x = tmp[rnd.nextInt(tmp.length)];
			y = tmp[rnd.nextInt(tmp.length)];
			if (x > 0 && y > 0) {
				if (y > (x - 2) / 2) {
					if (y < (x / 2) + 3) {
						exp[i][0] = x;
						exp[i][1] = y;
						System.out.println("[" + x + ":" + y + "]");
						i++;
						if (i == N) {
							break;
						}
					}
				}
			}
		}
//		metod1(exp);
		metod2(exp);
	}

	public void metod(double[][] m) {
		double a = 0, b = 0, c = 0, d = 0;
		for (int i = 0; i < m.length; i++) {
			a += m[i][0];
			b += m[i][1];
			c += m[i][0] * m[i][0];
			d += m[i][0] * m[i][1];
		}
		Double[] res = new Double[2];
		// System.out.println("a=" + a + "\nb=" + b + "\nc=" + c + "\nd=" + d);
		res[0] = (a * b - m.length * d) / (a * a - m.length * c);
		res[1] = (b - res[0] * a) / m.length;
		System.out.println("a=" + (double) Math.round(res[1] * 10000) / 10000
				+ "\nb=" + (double) Math.round(res[0] * 10000) / 10000);
		f.add(res);
	}

	/**
	 * Решение задачи
	 * 
	 * @param m
	 */
	public void metod1(double[][] m) {
		Random rnd = new Random();
		double arr[][] = new double[N - 200][2];
		ArrayList<Integer> l = new ArrayList<Integer>(N - 200);
		Integer ind;
		int i = 0;
		double u = 0, v = 0;
		for (int j = 0; j < 1000; j++) {
			while (i < (N - 200)) {
				ind = rnd.nextInt(m.length);
				if (!l.contains(ind)) {
					l.add(ind);
					arr[i] = m[ind];
					i++;
				}
			}
			System.out.println("j=" + j);
			metod(arr);
			l.clear();
			i = 0;
		}
		for (Double[] d : f) {
			u += d[0];
			v += d[1];
		}
		u = u / f.size(); // среднее a
		v = v / f.size(); // среднее b

		double q = 0, r = 0;
		for (Double[] d : f) {
			q += Math.pow((d[0] - u), 2);
			r += Math.pow((d[1] - v), 2);
		}
		q = Math.sqrt((1 / f.size()) * q); // среднеквадр отклонение a
		r = Math.sqrt((1 / f.size()) * r); // среднеквадр отклонение b
	}

	/**
	 * Решение задачи
	 * 
	 * @param m
	 */
	public void metod2(double[][] m) {
		double arr[][];
		double u = 0, v = 0;
		int j = N;
		while (0 < j) {
			arr = new double[j][2];
			for (int i = 0; i < j; i++) {
				arr[i] = m[i];
			}
			System.out.println("arr.lenght=" + arr.length);
			metod(arr);
			j--;
		}
		for (Double[] d : f) {
			u += d[0];
			v += d[1];
		}
		u = u / f.size(); // среднее a
		v = v / f.size(); // среднее b

		double q = 0, r = 0;
		for (Double[] d : f) {
			q += Math.pow((d[0] - u), 2);
			r += Math.pow((d[1] - v), 2);
		}
		q = Math.sqrt((1 / f.size()) * q); // среднеквадр отклонение a
		r = Math.sqrt((1 / f.size()) * r); // среднеквадр отклонение b
	}
}
