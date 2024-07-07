package tdaLista;

import tdaLista.DNodo;
import tdaLista.Position;

public class DNodo <E> implements Position <E>{
	
	private DNodo<E> anterior, siguiente; 
	private E element;
	
	public DNodo(DNodo<E> ant, DNodo<E> sig, E elem){
		
		anterior = ant;
		siguiente = sig;
		element= elem;
	}
	
	public E element(){
		
		return element;
	}
	
	public DNodo<E> getSiguiente(){
		
		return siguiente;
	}
	
	public DNodo<E> getAnterior(){
		
		return anterior;
	}

	public void setElement(E element){
		
		this.element = element;
	}

	public void setSiguiente(DNodo<E> sig){
		
		siguiente=sig;
	}

	public void setAnterior(DNodo<E> ant){
		
		anterior=ant;
	}
}
