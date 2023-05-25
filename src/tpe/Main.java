package tpe;

public class Main {

	public static void main(String[] args) {
		 Grafo<Integer> grafo = new GrafoDirigido<>();
		 
	        grafo.agregarVertice(1);
	        grafo.agregarVertice(2);
	        grafo.agregarVertice(3);
	        grafo.agregarVertice(4);
	        grafo.agregarVertice(5);
	        grafo.agregarVertice(6);
	        grafo.agregarVertice(7);


	        grafo.agregarArco(1, 2, 10);
	        grafo.agregarArco(1, 3, 20);
	        grafo.agregarArco(2, 5, 30);
	        grafo.agregarArco(3, 4, 40);
	        grafo.agregarArco(4, 5, 50);
	        grafo.agregarArco(5, 6, 50);
	        grafo.agregarArco(5, 7, 50);

	            
//	        System.out.println(grafo.cantidadArcos());
//	        System.out.println(grafo.existeArco(1, 3));
//	        System.out.println(grafo.existeArco(1, 5));
//	       
//	        System.out.println(grafo.cantidadVertices());
//	        System.out.println(grafo.contieneVertice(6));
//	        System.out.println(grafo.contieneVertice(9));
//	        
//	        grafo.borrarArco(1, 3);
//	        System.out.println(grafo.cantidadArcos());
//	        grafo.borrarVertice(8);
//	        System.out.println(grafo.cantidadVertices());
//	        
       //System.out.println(grafo.obtenerAdyacentes(1));
//	        System.out.println(grafo.obtenerArco(1, 5)); //NO ANDA RETORNA NULL
//	        System.out.println(grafo.obtenerArcos());
//	        System.out.println(grafo.obtenerVertices());
//	          ServicioDFS dfs = new ServicioDFS(grafo);   
//	          System.out.println(dfs.sDFS());
          ServicioBFS bfs = new ServicioBFS(grafo);
        System.out.println(bfs.ServicioBFS());
//	        ServicioCaminos<Integer> servicioCaminos = new ServicioCaminos<>(grafo, 1, 7, 5);
//	        System.out.println(servicioCaminos.caminos());
	}
}