package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if (mat == null || mat.length == 0 || num <= 0) {
			return false;
		}
		boolean todosMultEnAlgunaFila = false;
		for (int f = 0; f < mat.length; f++) {
			todosMultEnAlgunaFila = todosMultEnAlgunaFila || todaColMultPorNum(mat[f], num);
		}
		return todosMultEnAlgunaFila;
	}
	
	private boolean todaColMultPorNum(int[] filas, int num) {
		boolean todosMultiplo = true;
		for (int c = 0; c < filas.length; c++) {
			todosMultiplo = todosMultiplo && esMultiplo(filas[c], num);
		}
		return todosMultiplo;
	}

	private boolean esMultiplo(int numToCompare, int numCalculator) {
		return numToCompare % numCalculator == 0;
	}
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0 || mat1.length != mat2.length) {
			return false;
		}
		boolean hayInterTodasFilas = true;
		for (int f1 = 0; f1 < mat1.length; f1++) {
			hayInterTodasFilas = hayInterTodasFilas && hayInterEntreFilas(mat1[f1], mat2[f1]);
		}
		
		return hayInterTodasFilas;
	}
	
	private boolean hayInterEntreFilas(int[] filas1, int[] filas2) {
		boolean hayInterEnFilas = false;
		for (int c1 = 0; c1 < filas1.length; c1++) {
			for (int c2 = 0; c2 < filas2.length; c2++) {
				hayInterEnFilas = hayInterEnFilas || filas1[c1] == filas2[c2];
			}
		}
		return hayInterEnFilas;
	}

	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		if (mat == null || mat.length == 0 || nColum <= 0 || nColum > mat.length-1) {
			return false;
		}
		boolean algunaFilaSumaMas = false;
		for (int f = 0; f < mat.length; f++) {
			algunaFilaSumaMas = algunaFilaSumaMas || sumarElementos(mat[f]) > sumarElementos(mat[nColum]);
		}
		
		return algunaFilaSumaMas;
	}
	
	private int sumarElementos(int[] arr) {
		int sumTot = 0;
		for (int i = 0; i < arr.length; i++) {
			sumTot += arr[i];
		}
		return sumTot;
	}

	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de cada
	 * matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz está
	 * vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		if (mat1 == null || mat1.length == 0 || mat2 == null || mat2.length == 0 || mat1[0].length != mat2[0].length) {
			return false;
		}
		boolean todasLasColsTienenInter = true;
		for (int c1 = 0; c1 < mat1[0].length; c1++) {
			todasLasColsTienenInter  = todasLasColsTienenInter  && hayInterEntreColumnas(mat1, mat2, c1);
		}
		
		return todasLasColsTienenInter ;
	}

	private boolean hayInterEntreColumnas(int[][] mat1, int[][] mat2, int columna) {
		boolean hayInterseccion = false;
		for (int f1 = 0; f1 < mat1.length; f1++) {
			for (int f2 = 0; f2 < mat2.length; f2++) {
				hayInterseccion = hayInterseccion || mat1[f1][columna] == mat2[f2][columna]; 
			}
		}
		return hayInterseccion;
	}
}
