package Trees_Representation_And_Traversal_BFS_And_DFS;

import java.util.*;

public class Tree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;


    public Tree(E value, Tree<E>...children) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();
        this.children.addAll(Arrays.asList(children));
    }

    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        ArrayDeque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            result.add(current.value);

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }

        return result;
    }

    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

//        doDfs(this,result);
//        doDfs is the same as orderDfs but with recursion

        Deque<Tree<E>> childrenStack = new ArrayDeque<>();
        childrenStack.push(this);

        while (!childrenStack.isEmpty()) {
            Tree<E> current = childrenStack.pop();

            for (Tree<E> node : current.children) {
                childrenStack.push(node);
            }
            result.add(current.value);

        }

        return result;
    }

    private void doDfs(Tree<E> node,List<E> result) {
        for (Tree<E> child : node.children) {
            this.doDfs(child, result);
        }

        result.add(node.value);
    }


    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = find(parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    private Tree<E> find(E parentKey) {

        ArrayDeque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.value == parentKey) {
                return current;
            }

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }

        }
        return null;

    }

    public void removeNode(E nodeKey) {

    }

    public void swap(E firstKey, E secondKey) {

    }
}



