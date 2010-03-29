package net.godcode.seal.f;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple container monad, heavily inspired by scala.Option
 * {@link http://www.scala-lang.org/docu/files/api/scala/Option.html}.
 * 
 * $Id$
 * 
 * @author clewis Mar 27, 2010
 *
 */
public abstract class Option<A> implements Iterable<A> {

	private static final None<?> none = new None<Object>();
	
	private A a;
	
	private Option(A a) {
		this.a = a;
	}
	
	public Iterator<A> iterator() {
		return toCollection().iterator();
	}
	
	public boolean isSome() {
		return this instanceof Some<?>;
	}
	
	public boolean isNone() {
		return ! isSome();
	}
	
	public A get() {
		if(isSome()) {
			return a;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public A getOr(A orA) {
		return isSome() ? a : orA;
	}
	
	public Collection<A> toCollection() {
		return new AbstractCollection<A>() {
			public Iterator<A> iterator() {
				return new Iterator<A>() {

					public boolean hasNext() {
						return a != null;
					}
					
					public A next() {
						if(a != null) {
							A ret = a;
							a = null;
							return ret;
						} else {
							throw new NoSuchElementException();
						}
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}
					
				};
			}
			
			public int size() {
				return Option.this.isSome() ? 1 : 0;
			}
			
		};
	}
	
	public static <B> Option<B> some(B b) {
		return new Some<B>(b);
	}
	
	@SuppressWarnings("unchecked")
	public static <B> Option<B> none() {
		return (Option<B>)none;
	}
	
	private static class Some<A> extends Option<A> {
		public Some(A a) {
			super(a);
		}
	}
	
	private static class None<A> extends Option<A> {
		private None() {
			super(null);
		}
	}
	
}
