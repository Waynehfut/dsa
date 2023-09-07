class MyNode {
    public String data;
    public MyNode next;

    public MyNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyNode is " + data;
    }
}


/**
 * 单向链表
 */
class SingleLinkedList {
    // 头节点，不保存任何数据，只是用来作为一个起始点
    private MyNode head = new MyNode("");

    /**
     * 添加节点
     * <pre>
     *     不考虑编号顺序时：
     *      1. 找到当前链表的最后节点
     *      2. 将最后整个节点的 next 指向新的节点
     * </pre>
     *
     * @param node
     */
    public void add(MyNode node) {
        // 要遍历到 next 为 null 的时候，才能进行添加
        MyNode temp = head;
        while (true) {
            // 找到链表的最后,就退出循环
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 打印链表中的数据
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        MyNode temp = head.next;
        while (true) {
            // 如果是链表的最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        MyNode hero1 = new MyNode("壹");
        MyNode hero2 = new MyNode("贰");
        MyNode hero3 = new MyNode("弎");
        MyNode hero4 = new MyNode("肆");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }
}
