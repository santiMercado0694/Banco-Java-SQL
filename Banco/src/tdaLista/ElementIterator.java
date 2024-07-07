package tdaLista;


import java.util.NoSuchElementException;
import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E>{
	
	protected PositionList<E> lista;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> l){
		
		lista=l;
		if(lista.isEmpty()) 
			cursor=null;
		else
			try 
			{
				cursor=lista.first();
			} 
			catch (EmptyListException e) 
			{
				e.printStackTrace();
			}
	}
	
	public boolean hasNext(){
		
		return (cursor!=null);
	}
	public E next() throws NoSuchElementException{
		
		if(cursor==null)
			throw new NoSuchElementException("No hay Siguiente");
		
		E toReturn= cursor.element();
		try 
		{
			cursor = (cursor == lista.last())? null : lista.next(cursor);
		}
		catch (InvalidPositionException | EmptyListException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public void remove(){
		
	}

}