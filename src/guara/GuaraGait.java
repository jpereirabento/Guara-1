package guara;

public abstract class GuaraGait {

	/*
	 * Esta é uma classe abstrata que implementa a interface , que são os
	 * métodos e variáveis abstratas e concretas das andaduras. Cada andadura
	 * terá uma classe concreta para as variáveis e métodos abstratos
	 * necessários .
	 */

	// Variáveis
	double ciclosDeApoio, ciclosDeApoioCom4patas, ciclosDeVoo, totalDeCiclos;
	int matrizDeAndadura[][];
	int[] vetorPatas;
	double[] xyz;
	double deltaX;
	double a2, a3, a4;
	String name;

	// variáveis de teste
	double DeltaX() {
		return deltaX = (double) ((6.0 * 1000.0 / 3600.0) * (4.0 / 1000.0)); // =
																				// velocidade
																				// [m/s]/DT;
	}

	// (DT=4/10000)

	public GuaraGait() {
		// TODO Auto-generated constructor stub
	}

	// Métodos

	double getCiclosDeApoio() {
		return ciclosDeApoio;
	};

	double getCiclosDeApoioCom4patas() {
		return ciclosDeApoioCom4patas;
	}

	double getCiclosDeVo() {
		return ciclosDeVoo;
	}

	double TotalDeCiclos() {
		return totalDeCiclos;
	}

	String getName() {
		return name;
	}

	double[] trajPata(int iPata, int iSetPoint, double x4, double y4,
			double z4, double deltaX) {
		return xyz;
	};

	// double[] trajVoo(double[] vetorPatas, double x4, double y4, double z4,
	// double velRobo, double deltaX) {
	// return xyz;
	// }

	// double[] getVetorPatas(int iCiclo) {
	// //
	// int i = (int) (iCiclo > 16 ? iCiclo - (iCiclo - 1) * totalDeCiclos
	// : iCiclo);
	// //
	// vetorPatas[0] = matrizDeAndadura[i]; // pata0
	// vetorPatas[1] = matrizDeAndadura[(int) (i + totalDeCiclos)]; // pata1
	// vetorPatas[2] = matrizDeAndadura[(int) (i + 2 * totalDeCiclos)];// pata2
	// vetorPatas[3] = matrizDeAndadura[(int) (i + 3 * totalDeCiclos)];// pata3
	// //
	// return vetorPatas;
	// }

}
