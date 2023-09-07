class MyNode {
    public String data;//数据
    public MyNode next;//默认为空

    public MyNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Current node is " + data;
    }
}


/**
 * 单链表
 */
class MySingleLinkedList {
    //定义头结点
    private MyNode head = new MyNode("");

    public void add(MyNode node) {
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

    //输出链表
    public void printList() {
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
        MyNode node1 = new MyNode("壹");
        MyNode node2 = new MyNode("贰");
        MyNode node3 = new MyNode("弎");
        MyNode node4 = new MyNode("肆");

        MySingleLinkedList singleLinkedList = new MySingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);

        singleLinkedList.printList();
    }
}
