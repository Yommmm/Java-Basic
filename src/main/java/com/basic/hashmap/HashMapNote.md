## HashMap

#### 全局变量

DEFAULT_INITIAL_CAPACITY 默认初始容量 16 1<<30

DEFAULT_LOAD_FACTOR 默认加载因子 0.75f

MAXIMUM_CAPACITY 最大容量 2^30

TREEIFY_THRESHOLD 红黑树化临界值 8

UNTREEIFY_THRESHOLD 链表化临界值 6

MIN_TREEIFY_CAPACITY 红黑树最小容量 64

transient Node<K,V>[] table 哈希表数组

transient int size 哈希表数据量

transient int modCount 计数器

int threshold 阈值（capacity * load factor）

final float loadFactor 加载因子

#### 方法
---
##### hash方法

    static final int hash(Object key) {
        int h;
        // 键不为空的前提下
        // 键的哈希值 异或 键的哈希值无符号右移16位
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

##### 元素位置

    tab[(n - 1) & hash]
    
##### 查询方法

    public V get(Object key) {
        Node<K,V> e;
        // 对传入的key键值进行hash计算
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    
    final Node<K,V> getNode(int hash, Object key) {
        // 数据数组
        Node<K,V>[] tab; 
        // 查到的hash节点数据
        Node<K,V> first, e; 
        // 数组长度
        int n; 
        K k;
        // 数组、hash节点数据判空
        if ((tab = table) != null && (n = tab.length) > 0 &&
            // 拿到并对hash节点的数据判空
            // tab[(n - 1) & hash]为hash值hash节点
            (first = tab[(n - 1) & hash]) != null) {
            // 节点第一个数据是不是想要的？
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                // 红黑树里面找
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                // 链表里面找
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

##### put方法
    
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }