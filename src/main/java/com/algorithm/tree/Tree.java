package com.algorithm.tree;

class Tree {
	private String key;
	private int val;
	private Tree left, right;

	public Tree(String k, int v, Tree l, Tree r) {
		key = k;
		val = v;
		left = l;
		right = r;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Tree getLeft() {
		return left;
	}

	public void setLeft(Tree left) {
		this.left = left;
	}

	public Tree getRight() {
		return right;
	}

	public void setRight(Tree right) {
		this.right = right;
	}
}
