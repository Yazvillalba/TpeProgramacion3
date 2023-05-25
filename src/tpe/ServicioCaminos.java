package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminos<T> {
	
	Grafo<T> grafo;
	int origen;
	int destino;
	int lim;
	List<List<Integer>> camino;
	List<Arco<?>> arcosV = new LinkedList<>();
	public ServicioCaminos(Grafo<T> grafo, int origen, int destino, int
			lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.camino = new LinkedList<>();
		this.arcosV = new LinkedList<>();
	}
			
	
	
	
	public List<List<Integer>> caminos(){
		
		List<Integer> caminoParcial = new LinkedList<>();
		caminoParcial.add(origen);
		
		servicioCamino(origen, caminoParcial);
		
		return camino;
	}  
	
	private void servicioCamino(int origen, List<Integer> caminoParcial) {
//		List<Integer> caminoParcial = new LinkedList<>();
		Iterator<Arco<T>> adyacentes = this.grafo.obtenerArcos(origen);

		if(origen == destino) {
			if(this.arcosV.size() <= this.lim) {
				this.camino.add(new LinkedList<>(caminoParcial));
			}
		}else {
			while (adyacentes.hasNext()) {
				Arco<T> arco = adyacentes.next();
				Integer vertice = arco.getVerticeDestino();
				if(!arcosV.contains(arco)) {
					caminoParcial.add(vertice);
					arcosV.add(arco);
					servicioCamino(vertice, caminoParcial);
					caminoParcial.remove(caminoParcial.get(caminoParcial.size()-1));
					arcosV.remove(arco);
				}
				
			}
		}
		
	}
}
