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

    public void insert(MyNode node, int index) {
        // 由于 head 变量不能动，动了就无法从头遍历了，使用辅助变量来完成我们的添加
        MyNode temp = head;
        int tempIndex = 0;
        boolean exist = false;  // 添加的节点是否已经在链表中存在
        while (true) {
            if (temp.next == null) {
                // 如果是链表尾，则跳出循环
                break;
            }
            // 如果他们相等，则表示该位置应该插入节点
            if (tempIndex == index - 1) {
                exist = true;
                break;
            }
            // 没找到，则后移 temp ，继续寻找
            temp = temp.next;
            tempIndex++;
        }

        if (!exist) {
            System.out.printf("标号%d位置无法插入元素 \n", index);
            return;
        }
        // 把节点插入到 temp 和 temp.next 之间
        // temp  ->  node  -> temp.next
        node.next = temp.next;
        temp.next = node;
    }

    public void delete(int index) {
        int tempIndex = 0;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        MyNode temp = head; //注意头结点
        boolean exist = false;  // 是否找到要删除的节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (tempIndex == index - 1) { //下一个节点是目标点，考虑头结点，要减一
                exist = true;
                break;
            }
            tempIndex++;
            temp = temp.next;
        }
        if (!exist) {
            System.out.printf("未找到匹配的编号 %d \n", index);
            return;
        }
        // 删除操作
        temp.next = temp.next.next;
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
        singleLinkedList.delete(2);
        System.out.println("删除");
        singleLinkedList.printList();
        MyNode node5 = new MyNode("伍");
        singleLinkedList.insert(node5, 2);
        System.out.println("插入");
        singleLinkedList.printList();
    }
}
