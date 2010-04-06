package net.godcode.seal.f;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * FunctionalLinkedList
 * 
 * $Id$
 * 
 * @author clewis Mar 31, 2010
 *
 */
public class FunctionalLinkedListTest {
	
	public static interface FunctionalIterator<A> {
		
		public <B> List<B> map(Function1<A, B> f);
		
		public <B> B reduceLeft(Function2<B, A, B> f);
		
		public <B> Function1<Function2<A, B, B>, B> foldLeft(final B init);
		
	}
	
	public static class FunctionalLinkedList<A> extends LinkedList<A> implements FunctionalIterator<A> {
		
		private static final long serialVersionUID = -5468603652354597997L;

		public <B> List<B> map(Function1<A, B> f) {
			List<B> list = new FunctionalLinkedList<B>();
			for(A a : this) {
				list.add(f.apply(a));
			}
			return list;
		}
		
		public <B> B reduceLeft(Function2<B, A, B> f) {
			B b = null;
			for(A a : this) {
				b = f.apply(b, a);
			}
			return b;
		}
		
		// A curried function: F -> F -> B
		public <B> Function1<Function2<A, B, B>, B> foldLeft(final B init) {
			return new Function1<Function2<A, B, B>, B>() {
				public B apply(Function2<A, B, B> f) {
					B b = init;
					for(A a : FunctionalLinkedList.this) {
						b = f.apply(a, b);
					}
					return b;
				}
			};
		}

	}

	@Test
	public void test() {
		FunctionalLinkedList<Integer> ints = new FunctionalLinkedList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		
		Integer result = ints.foldLeft(4).apply(new Function2<Integer, Integer, Integer>() {
			public Integer apply(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});
		
		result = ints.reduceLeft(new Function2<Integer, Integer, Integer>() {
			public Integer apply(Integer i1, Integer i2) {
				return i1 == null ? i2 : i1 + i2;
			}
		});
		
		System.out.println("FunctionalLinkedListTest.test() " + result);

	}
	
}