public class BSNode <T> {
    public String key;
    public T data;
    public BSNode<T> left;
    public BSNode <T>right;

    public BSNode(String k, T val) {
        key = k;
        data = val;
        left = right = null;
    }
    public BSNode(String k, T val, BSNode<T> l, BSNode<T> r) {
        key = k;
        data = val;
        left = l;
        right = r;
    }
}