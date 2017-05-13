package prova1;

import java.util.ArrayList;
import java.util.Collection;

public class ArvoreBinBusca<Chave extends Comparable<Chave>, Valor> implements IArvoreBinBusca<Chave, Valor> {

	private NoBinBusca<Chave, Valor> root;
	private ArrayList<Valor> list;
	private ArrayList<Valor> listPre;
	private ArrayList<Valor> listOrder;
	private ArrayList<Valor> listPost;

	public ArvoreBinBusca() {
		this.root = null;
		list = new ArrayList<Valor>();
		listPre = new ArrayList<Valor>();
		listOrder = new ArrayList<Valor>();
		listPost = new ArrayList<Valor>();
	}

	// obter raiz
	public NoBinBusca<Chave, Valor> getRoot() {
		return root;
	}

	// obter nó
	@Override
	public NoBinBusca<Chave, Valor> getNode(Chave chave) {
		return getNode(chave, this.root);
	}

	// obter nó
	private NoBinBusca<Chave, Valor> getNode(Chave key, NoBinBusca<Chave, Valor> node) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.getKey()) == 0) {
			return node;
		} else if (key.compareTo(node.getKey()) > 0) {
			return getNode(key, node.getLeft());
		} else {
			return getNode(key, node.getRight());
		}
	}

	// recupera chave
	private Chave recoverKey(NoBinBusca<Chave, Valor> node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node.getKey();
	}

	// limpando árvore
	public void clear() {
		root.setLeft(null);
		root.setRight(null);
		root = null;
	}

	// Inserindo nós
	@Override
	public boolean insert(Chave chave, Valor valor) {
		NoBinBusca<Chave, Valor> node = new NoBinBusca<Chave, Valor>(chave, valor);
		if (root == null) {
			root = node;
			list.add(valor);
			return true;
		} else {
			return insert(node, root);
		}
	}

	// inserindo nós
	public boolean insert(NoBinBusca<Chave, Valor> node, NoBinBusca<Chave, Valor> root) {
		if (root.getKey().compareTo(node.getKey()) < 0) {
			NoBinBusca<Chave, Valor> left = root.getLeft();
			if (left == null) {
				root.setLeft(node);
				node.setRoot(root);
				list.add(node.getValue());
				return true;
			} else {
				return this.insert(node, left);
			}
		} else if (root.compareTo(node.getKey()) > 0) {
			NoBinBusca<Chave, Valor> right = root.getRight();
			if (right == null) {
				root.setRight(node);
				node.setRoot(root);
				list.add(node.getValue());
				return true;
			} else {
				return this.insert(node, right);
			}
		}
		return false;
	}

	// removendo nós
	@Override
	public boolean remove(Chave chave) {
		if (this.getNode(chave) != null) {
			list.remove(this.getNode(chave).getValue());
			this.remove(chave, root);
			return true;
		}
		return false;

	}

	// remover nó
	private NoBinBusca<Chave, Valor> remove(Chave key, NoBinBusca<Chave, Valor> node) {
		if (node == null) {
			return null;
		} else if (key.compareTo(node.getKey()) == 0) {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				node.setKey(recoverKey(node.getLeft()));
				node.setLeft((remove(node.getKey(), node.getLeft())));
			}
		} else {
			if (key.compareTo(node.getKey()) > 0) {
				node.setLeft(remove(key, node.getLeft()));
			} else {

				node.setRight(remove(key, node.getRight()));
			}
		}
		return node;
	}

	@Override
	public Collection<Valor> getValue() {
		return list;
	}

	public Collection<Valor> getPre(NoBinBusca<Chave, Valor> node) {
		if (node != null) {
			listPre.add(node.getValue());
			getPre(node.getRight());
			getPre(node.getRight());
		}
		return listPre;
	}

	public Collection<Valor> getOrder(NoBinBusca<Chave, Valor> node) {
		if (node != null) {
			getOrder(node.getLeft());
			listOrder.add(node.getValue());
			getOrder(node.getRight());
		}
		return listOrder;
	}

	public Collection<Valor> getPos(NoBinBusca<Chave, Valor> node) {
		if (node != null) {
			getPos(node.getLeft());
			getPos(node.getRight());
			listPost.add(node.getValue());
		}
		return listPost;
	}

}
