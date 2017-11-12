package com.algorithm.tree;

class TreeProcessor {
	public static int lookup(String k, int defaultval, Tree t) {
		if (t == null)
			return defaultval;
		if (k.equals(t.getKey())) {
			return t.getVal();
		}
		return lookup(k, defaultval, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
	}

	public static void update(String k, int newval, Tree t) {
		if (t == null) {
			/* should add a new node */ } else if (k.equals(t.getKey()))
			t.setVal(newval);
		else
			update(k, newval, k.compareTo(t.getKey()) < 0 ? t.getLeft() : t.getRight());
	} // other methods processing a Tree

	public static Tree updateAdd(String k, int newval, Tree t) {
		if (t == null)
			t = new Tree(k, newval, null, null);
		else if (k.equals(t.getKey()))
			t.setVal(newval);
		else if (k.compareTo(t.getKey()) < 0)
			t.setLeft(updateAdd(k, newval, t.getLeft()));
		else
			t.setRight(updateAdd(k, newval, t.getRight()));
		return t;
	}

	// Using a functional approach
	//	fupdate is purely functional. It creates a new Tree as a result
	//	but sharing as much as it can with its argument.
	// page 358 of Java 8 in Action
	public static Tree fupdate(String k, int newval, Tree t) {
		return (t == null) ? new Tree(k, newval, null, null)
				: k.equals(t.getKey()) ? new Tree(k, newval, t.getLeft(), t.getRight())
						: k.compareTo(t.getKey()) < 0
								? new Tree(t.getKey(), t.getVal(), fupdate(k, newval, t.getLeft()), t.getRight())
								: new Tree(t.getKey(), t.getVal(), t.getLeft(), fupdate(k, newval, t.getRight()));
	}
}