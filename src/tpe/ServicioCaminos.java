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
	    Iterator<Arco<T>> adyacentes = this.grafo.obtenerArcos(origen);

	    while (adyacentes.hasNext()) {
	        Arco<T> arco = adyacentes.next();
	        Integer vertice = arco.getVerticeDestino();
	        if (!arcosV.contains(arco)) {
	            List<Integer> nuevoCaminoParcial = new LinkedList<>(caminoParcial);
	            nuevoCaminoParcial.add(vertice);
	            arcosV.add(arco);
	            if (vertice == destino && arcosV.size() <= lim) {
	                this.camino.add(new LinkedList<>(nuevoCaminoParcial));
	            }
	            servicioCamino(vertice, nuevoCaminoParcial);
	            arcosV.remove(arco);
	        }
	    }
	}

	
}
