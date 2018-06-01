package guara;

public class GuaraWaveGait extends GuaraGait {

	/*
	 * Esta andadura eÌ� regular e e simeÌ�trica, ou seja, Î²Î¹ = Î² = constante para
	 * todas as patas e duas patas correspondentes em lados opostos, estaraÌƒo a
	 * 180 graus, ou 0.5*T fora de fase
	 */

	GuaraKinematics cin = new GuaraKinematics();

	// variÃ¡veis de teste

	double raio = 0.1; // raio para geraÃ§Ã£o da cicloide de voo
	double hRobo = 0.3; //yet fixed

	int matrizDeAndadura[][] = new int[][] {

			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
					0, 0, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1 } };

	public GuaraWaveGait() {
		//
		name = "WaveGait";
		ciclosDeApoio = 27;
		ciclosDeApoioCom4patas = 3;
		ciclosDeVoo = 5;
		totalDeCiclos = 32;
		//
	}

	double[] trajPata(int iPata, int iSP, double x4, double y4, double z4) {
		System.out.println("andadura3");

		double[] xyz = { 0.0, 0.0, 0.0 };

		int iCiclos = (int) (iSP / totalDeCiclos); // contador de ciclos da

		// andadura
		int i = matrizDeAndadura[iPata][(int) (iSP - iCiclos * totalDeCiclos) - 1];

		switch (i) {
		case 0: // pata em voo
			// o voo Ã© uma trajetÃ³ria em ciclÃ³ide
			xyz[0] = x4 + DeltaX();
			xyz[1] = y4;
			xyz[2] = z4;
			break;
		case 1: // pata em apoio
			//andar reto sem movimento lateral
			//o apoio Ã© uma trajetÃ³ria reta paralela Ã  plataforma
			double deltaX = DeltaX();
			double teta = deltaX / raio;

			xyz[0] = x4 + DeltaX();
			xyz[1] = y4;
			xyz[2] = z4 + (1 - Math.cos(teta)) * raio;
			break;
		}
		return xyz;
	}

	double[] juntasPerna(int iPerna, int iSP, double x4, double y4, double z4) {// ,
		// double deltaX) {

		double[] xyz = trajPata(iPerna, iSP, x4, y4, z4);// , deltaX);
		double[] juntas = cin.cinInv(xyz);

		return juntas;
	}
}
