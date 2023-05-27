package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioDFS {
	
	Grafo<?> grafo;
	HashMap<Integer, String> hashMap;
	
	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.hashMap = new HashMap<>();
	}
	public ArrayList<Integer> sDFS() {
		Iterator<Integer> vertices = grafo.obtenerVertices();
		ArrayList<Integer> salida = new ArrayList<>();
		//por cada vértice V ∈ G  V.color = BLANCO;
		while(vertices.hasNext()) {
			hashMap.put(vertices.next(), "blanco");		
		}
		vertices = grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			if(hashMap.get(vertice) == "blanco") {
				salida.addAll(dfsForest(vertice));
			}
		}
		return salida;
	
	}
	private List<Integer> dfsForest(Integer v){
	    List<Integer> salida = new LinkedList<>(); 
	    List<Integer> aux = new LinkedList<>();
	    hashMap.put(v, "amarillo");
		
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);	
		
		while(adyacentes.hasNext()) {
			Integer vertice = adyacentes.next();
			if(hashMap.get(vertice) == "blanco") {
				aux.addAll(dfsForest(vertice));
			
			}
		}
	
		hashMap.put(v, "negro");
		salida.addAll(aux);	
		salida.add(v);
		
		return salida;
	}

	
}
