/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema4;

/**
 *
 * @author lam_m
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

        private static class Node<E> implements Position<E> {
            private E element;
            private Node<E> prev;// Anterior
            private Node<E> next;// Siguiente

            public Node(E e, Node<E> p, Node<E> n) {
                    element = e;
                    prev = p;
                    next = n;
            }

            @Override
            public E getElement() throws IllegalStateException {
                    if (next == null) // Nodo no valido
                            throw new IllegalStateException("Posicion invalida");
                    return element;
            }

            public void setElement(E e) {
                    element = e;
            }

            public Node<E> getPrev() {
                    return prev;
            }

            public void setPrev(Node<E> prev) {
                    this.prev = prev;
            }

            public Node<E> getNext() {
                    return next;
            }

            public void setNext(Node<E> next) {
                    this.next = next;
            }

	}
    
	private Node<E> header = null;// Referencia
	private Node<E> trailer = null;
	private int size = 0;

	public PositionalLinkedList(){
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
                header.setNext(trailer);
	}
        
        private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
	
	/**
	 * "Empaca" un nodo como posicion a menos que sea header o trailer
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}
       
    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    @Override
    public Position<E> first() {return position(header.getNext());}

    @Override
    public Position<E> last() {return position(trailer.getPrev());}

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
            Node<E> newest = new Node<>(e, pred, succ);
            pred.setNext(newest);
            succ.setPrev(newest);
            size++;
            return newest;
    }
    
    @Override
    public Position<E> addFirst(E e) {
            return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {return addBetween(e, trailer.getPrev(), trailer);}

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
	return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
	return position(node.getNext());
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
	return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
	return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException  {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    @Override
    public Position<E> positionAtIndex(int i) {
        Node n = header.getNext();
        int count = 0;		
        while(n != null)
        {       if(count == i -1)
            {
                return n;
            }
            else
            {
                count++;
                n = n.getNext();
            }
        }
        return null;
    }
    
    
}
