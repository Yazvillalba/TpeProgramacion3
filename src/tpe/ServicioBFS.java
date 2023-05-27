package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ServicioBFS {

	Grafo<?> grafo;
	HashMap<Integer, Boolean> hashMap;
	List<Integer> fila ; 
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.hashMap = new HashMap<>();
        this.fila =new LinkedList<>();
	}
	
	public List<Integer> ServicioBFS() { 
	
		List<Integer> lista= new ArrayList<>();
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while(vertices.hasNext()) {
			hashMap.put(vertices.next(), false);		
		}
		
		vertices = grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			if(hashMap.get(vertice) == false) {
				lista.addAll(bfsForest(vertice));
			}
		}
		return lista;
	}
	private List<Integer> bfsForest(Integer v){
		List<Integer> aux = new LinkedList<>();
		 hashMap.put(v, true);
		 fila.add(v);
		 while(!fila.isEmpty()) {
			Integer u = fila.remove(0);
			aux.add(u); 
			Iterator<Integer> h = grafo.obtenerAdyacentes(u);
			
			while(h.hasNext()) {
				Integer vertice = h.next();
				if(hashMap.get(vertice) == false) {				
					 hashMap.put(vertice, true);
					 fila.add(vertice);
			
				}
			}
		 }
		 return aux;
		 
		
	}
		

}
