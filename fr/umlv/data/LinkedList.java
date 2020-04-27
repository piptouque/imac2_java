

package fr.umlv.data;

import java.util.Arrays;

public class LinkedList<T> {
  private Link<T> _first;

  public LinkedList(final T... vals) {
    _first = new Link<T>(vals);
  }
  public LinkedList(final LinkedList<T> l) {
    _first = new Link<T>(l._first);
  }

  public void  pushFront(final T... vals) {
    _first = new Link<T>(vals);
    _first.pushBack(vals); 
  }
  public T value(int index) {
    try {
      return _first.next(index).value();
    } catch(IndexOutOfBoundsException e) {
      throw e;
    }
  }
  public boolean contains(T val) {
	  return _first.containsNext(new Link<T>(val)) != -1;
  }
  @Override
  public String toString() {
    return _first.toString();
  }
  @Override
  public int hashCode() {
    return _first.hashCode();
  }
  @Override
  public boolean equals(Object o) {
	return _first.equals(o);
  }
}


class Link<T> {
  private final T _val;
  private Link _next;

  private static int _MAX_NUMBER_LINKS = 1000;

  public Link(final T... vals) {
    if(vals.length == 0 || vals[0] == null) {
      _val = null;
      _next = null;
    } else {
      _val = vals[0];
      if(vals.length > 1) {
         T tail[] = Arrays.copyOfRange(vals, 1, vals.length);
        _next = new Link<T>(tail);
      } else {
	_next = null;	
      }
    } 
  }
  public Link(final Link<T> l) {
    _val = l._val;
    /*
     * deep copy
     * recursive.
     */
    _next = new Link<T>(l._next);
  }
  public boolean hasNext() {
    return _next != null;
  }
  public Link<T> next() {
    return _next;
  }
  public Link<T> next(int offset) {
    if(offset < 0) {
      throw new IndexOutOfBoundsException();
    }
    int i=0;
    Link l=this;
    while(l.hasNext() && i < offset) {
      l = l.next();
    }
    if(l == null) {
      throw new IndexOutOfBoundsException();
    }
    return l;
  }
  public T value() {
    return _val;
  }
  private Link<T> last() {
    Link l=this;
    while(l.hasNext()){
      l = l.next();
      return l;
    }
    return null;
  }
  public void pushBack(final T... vals) {
     last()._next = new Link<T>(vals);	
  }
  public int containsNext(final Link<T> l) {
    return accContainsNext(l, 0);
  }
  private int accContainsNext(final Link<T> l, int acc) {
    if(l == null) {
      return -1;
    }
    if(_val.equals(l._val)) {
      return acc;
    }
    if(hasNext()) {
      return next().accContainsNext(l, acc + 1);  
    }
    return -1;
  }
  @Override
  public String toString() {
    var str = new StringBuilder();
    Link l = this;
    while(l.hasNext()) {
	str.append(l.value() + ", ");
	l = l.next();
    }
    return str.toString();
  }
  @Override
  public int hashCode() {
    return accHashCode(0);
  }
  private int accHashCode(int acc) {
	  return next().accHashCode(_val.hashCode()%_MAX_NUMBER_LINKS + acc*_MAX_NUMBER_LINKS);
  }
  @Override
  public boolean equals(Object o) {
    // unsafe, but whatever
    if(!(o instanceof Link)) {
	    return false;
    }
    var l = (Link<T>)o;
    boolean linkOk = l._val == _val;
    if (l.hasNext() && hasNext()) {
	    return linkOk && next().equals(l.next()); 
    } else if(!l.hasNext() && !hasNext()) {
	    return linkOk;
    }
    return false;
  }
}
