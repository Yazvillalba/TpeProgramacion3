package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {

	HashMap<Integer, ArrayList<Arco<T>>> hashMap = new HashMap<Integer, ArrayList<Arco<T>>>();

	// Agrega un vertice
	public void agregarVertice(int verticeId) {
		// corroborar q no este y agregarlo
		if (!contieneVertice(verticeId)) {

			hashMap.put(verticeId, new ArrayList<Arco<T>>());
		} else {
			System.out.println("No se pueden agregar vertices repetidos");
		}

	};

	// Borra un vertice
	public void borrarVertice(int verticeId) {
		if(contieneVertice(verticeId)) {
			hashMap.remove(verticeId);
			borrarArco(verticeId, verticeId);
		}

	};

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
			if(!existeArco(verticeId2, verticeId2)) {
				Arco<T> nuevoArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
				hashMap.get(verticeId1).add(nuevoArco);
			}
			
		}
	}

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void borrarArco(int verticeId1, int verticeId2) {
		if(existeArco(verticeId1, verticeId2)) {
			Arco<T> nuevo = obtenerArco(verticeId1, verticeId2);
			hashMap.get(verticeId1).remove(nuevo);
			
		}
		
	};

	// Verifica si existe un vertice
	public boolean contieneVertice(int verticeId) {
		return hashMap.containsKey(verticeId);

	};

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(int verticeId1, int verticeId2) {
		return (obtenerArco(verticeId1, verticeId2) != null);

	};

	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (contieneVertice(verticeId1)) {
			for (Arco<T> i : hashMap.get(verticeId1)) {
				if (i.getVerticeDestino() == verticeId2) {
					return i;  
				}
			}
		}
		return null;
	}

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices() {
		return hashMap.size();
	};

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos() {
		int cantidad = 0;
		for (ArrayList<Arco<T>> i : hashMap.values()) {
			cantidad += i.size();
		}
		return cantidad;

	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Set <Integer> keys = hashMap.keySet();
		return keys.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (Arco<T> i : this.hashMap.get(verticeId)) {
			aux.add(i.getVerticeDestino());
				
		}
		return aux.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
		for (Integer vertice : hashMap.keySet()) {
			aux.addAll(hashMap.get(vertice));
		}
		
		return aux.iterator();
		
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) { 
		ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
		if(contieneVertice(verticeId)) {
			return this.hashMap.get(verticeId).iterator();
		}
		return null;
	}
}


