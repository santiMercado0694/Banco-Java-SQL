package tdaLista;

import java.util.Iterator;

import tdaLista.BoundaryViolationException;
import tdaLista.DNodo;
import tdaLista.DoubleLinkedList;
import tdaLista.ElementIterator;
import tdaLista.EmptyListException;
import tdaLista.InvalidPositionException;
import tdaLista.Position;
import tdaLista.PositionList;

/**
 * Implementación de lista doblemente enlazada con nodos centinela
 * @author Luciano Fuentes.
 */

public class DoubleLinkedList<E> implements PositionList<E> {
	
	protected int nroElem;
	protected DNodo<E> header,trailer;
	
	public DoubleLinkedList(){
		
		nroElem = 0;
		header  = new DNodo<E>(null,null,null);
		trailer = new DNodo<E>(header,null,null);
		
		header.setSiguiente(trailer);
	}
    
	public void addFirst(E element){
		
		DNodo<E> nuevoNodo = new DNodo<E> (header, header.getSiguiente(), element);
		
		header.getSiguiente().setAnterior(nuevoNodo);
		header.setSiguiente(nuevoNodo);
		
		nroElem++;
	}
	
	public void addLast(E element){
		
		DNodo<E> nuevoNodo = new DNodo<E> (trailer.getAnterior(), trailer, element);
		
		trailer.setAnterior(nuevoNodo);	
		nuevoNodo.getAnterior().setSiguiente(nuevoNodo);
		
		nroElem++;
	}
		
	public void addAfter(Position<E> p , E element) throws InvalidPositionException{
		
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E> (n, n.getSiguiente(), element);
		
		n.setSiguiente(nuevo);
		nuevo.getSiguiente().setAnterior(nuevo);
		
		nroElem++;
	}
	
	public void addBefore(Position <E> p, E element) throws InvalidPositionException{
		
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevoNodo = new DNodo<E> (n.getAnterior(), n , element);
		
		n.getAnterior().setSiguiente(nuevoNodo);
		n.setAnterior(nuevoNodo);
		
		nroElem++;
	}	
		
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		
		DNodo<E> n = checkPosition(p);
		
		if (n.getSiguiente()== trailer) 
			throw new BoundaryViolationException("La posicion pasada es la ultima de la lista");
		
		return n.getSiguiente();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		
		DNodo<E> n    = checkPosition(p);
		DNodo<E> prev = n.getAnterior();
		
		if (prev==header) 
			throw new BoundaryViolationException ("La posicion ingresada es al primera en la lista");
		
		return prev;
	}	
	
	public int size(){
		
		return nroElem;   
	}
		
	public boolean isEmpty(){
		
		return (nroElem==0);
	}
	
	public Position<E> first() throws EmptyListException{
		
		if(isEmpty()) 
			throw new EmptyListException ("Lista vacía");
		
		return header.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		
		if (isEmpty()) 
			throw new EmptyListException("Lista vacía");
		
		return trailer.getAnterior();
	}
				
	public E remove(Position<E> p) throws InvalidPositionException{
		
		DNodo<E> n = checkPosition(p);
		
		DNodo<E> nAnt = n.getAnterior();
		DNodo<E> nSig = n.getSiguiente();
		
		nAnt.setSiguiente(nSig);
		nSig.setAnterior(nAnt);
		
		E nElem = n.element();
		n.setSiguiente(null);
		n.setAnterior(null);
		nroElem--;
		
		return nElem;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException{
		
		DNodo<E> n = checkPosition(p);
		E viejoElem = n.element();
		n.setElement(element);
		
		return viejoElem;
	}

	public Iterator<E> iterator() {
	
		return (new ElementIterator<E>(this));
	}

	public Iterable<Position<E>> positions() {
		
		PositionList<Position<E>> P = new DoubleLinkedList<Position<E>>();
		if(!isEmpty()){
			try	{
				Position<E> p = first();
				while(true) {
					P.addLast(p);
					if (p==last())
						break;
					p = next(p);
				}
			}
			catch(EmptyListException | InvalidPositionException | BoundaryViolationException ee)
			{
				ee.printStackTrace();
			}
		}
		return P;
	}
	
	private DNodo<E> checkPosition(Position<E> p)throws InvalidPositionException {
		
		if (p==null)
			throw new InvalidPositionException("La posicion es incorrecta");
		
		if (p==header) 
			throw new InvalidPositionException("La cabeza del nodo no es una posicion valida");
		
		if (p==trailer)
			throw new InvalidPositionException("La cola del nodo no es una posicion valida");
		
		try{
			DNodo<E> temp=(DNodo<E>)p;
			if ((temp.getAnterior()==null) || (temp.getSiguiente()==null))
				throw new InvalidPositionException("No es una posicion valida en la lista");
			return temp;
		}
		catch (ClassCastException e) {
			throw new InvalidPositionException("La posicion no pertenece a la lista"); 
		}
	}
	
	public boolean existe(E elemento) {
		boolean existe = false;
		if (nroElem > 0) {
			System.out.println("Numero de elementos en lista = "+nroElem);
			DNodo<E> actual = header.getSiguiente();
			while ((existe == false) && (actual != trailer)) {
				if (actual.element().equals(elemento)) {
					existe = true;
				}
				actual = actual.getSiguiente();
			}
		}
		return existe;
	}

}
