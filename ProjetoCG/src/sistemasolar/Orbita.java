package sistemasolar;

import java.util.ArrayList; 
import java.util.List;

/**
 * Algoritmo da {@link ElipseBa} do ponto medio.
 * Algoritmo do site: http://www.old.w3professors.com/Data/Courses/Computer-Graphics/Programs/program-to-draw-an-ellipse-using-mid-point-algorithm.pdf
 * 
 */
public class Orbita {

	List<Ponto> listaPontos;
	
	public void midpointElipse(int a, int b){
		listaPontos = new ArrayList<Ponto>();
		int x = 0;
		int y = 0;
		double d1 = 0; 
		double d2 = 0;
		
		/* Valores iniciais */
		x = 0;
		y = b;
		d1 = b * b - a * a * b + a * a / 4.0;
		
		printPixel(x, y);
		
		while(a * a * (y - 0.5) > b * b * (x + 1)){
			
			if (d1 < 0){
				d1 = d1 + b * b * (2 * x + 3);
				x++;
			}else{
				d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
				x++;
				y--;
			}
			printPixel(x, y);
		}
		
		d2 = b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b;
		while(y > 0){
			 
			if (d2 < 0){
				d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
				x++;
				y--;
			}else{
				d2 = d2 + a * a * (-2 * y + 3);
				y--;
			}
			printPixel(x, y);
		} 
	}
	
	private void printPixel(int x, int y) {
		
		listaPontos.add(new Ponto(x, y, 0)); 
		listaPontos.add(new Ponto(x, -y, 0)); 
		listaPontos.add(new Ponto(-x, y, 0));
		listaPontos.add(new Ponto(-x, -y, 0)); 
			
	}

	/**
	 * @return the listaPontos
	 */
	public List<Ponto> getListaPontos() {
		
		return listaPontos;
	}

	/**
	 * @param listaPontos the listaPontos to set
	 */
	public void setListaPontos(List<Ponto> listaPontos) {
		this.listaPontos = listaPontos;
	}

	public boolean contem(Ponto p, List<Ponto> lista) {
		for (Ponto ponto : lista) {
			if (ponto.getX() == p.getX() && ponto.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}

}
