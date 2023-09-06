# :blue_book: 第三章 栈(Stack)

当你在计算机中启动计算器程序，并按下计算的公式时，你是否想过，`1+2=3`是如何计算的？

![计算器](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309010943297.png)

当我们在浏览网页时，浏览器是怎么记得我们上一步浏览了那个页面呢？

![浏览器历史记录](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309010941772.png)

这一切都需要用到我们本章的内容，为了实现上述需求，有关算法专家设计了称之为 **栈(Stack)** 的数据结构。栈是一类特殊的表，它是限定了仅在表尾进行插入或删除的表。其中加入数据称之为入栈(Push)，出栈称之为(Pop)，它的头尾也有了特殊的别称，执行增删操作的称之为栈顶(Top)，最底层的数据称之为栈底(Bottom)，如果没有数据存储，那这个栈称之为空栈。需要注意的是，栈只有栈顶事可以访存的，那也就意味着先进入到栈中的数据是被“压”在最低端，是一个 **后进先出(Last In First Out, LIFO)** 的结构。
![栈的基本形态](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309011001052.png)

:::info 拓展阅读
栈是较早出现在计算机中的数据结构之一，在计算机内存管理中，栈是实现进程局部优先级控制最有效的办法，例如局部变量的新建和释放、局部函数的参数值传递等等，有兴趣可进一步阅读。[Java Heap Space vs Stack - Memory Allocation in Java | DigitalOcean](https://www.digitalocean.com/community/tutorials/java-heap-space-vs-stack-memory)
:::

## 栈 ADT

在讨论了上述内容后，我们来看下栈的常见操作：

| 操作方法  | 功能描述        |
| --------- | --------------- |
| push(x)   | 将对象 x 压入栈 |
| pop()     | 将栈顶元素移除  |
| getSize() | 获取栈大小      |
| isEmpty() | 是否为空        |
| top()     | 取栈顶          |

上述操作是 Java 接口中对栈的部分相关方法定义，在使用过程中则会有以下的效果

| 操作方法  | 操作           | 栈(右侧为栈顶) | 输出  |
| --------- | -------------- | -------------- | ----- |
| push(5)   | 将 5 压入栈    | (5)            |       |
| push(3)   | 将 3 压入栈    | (5,3)          |       |
| getSize() | 获取当前栈大小 | (5,3)          | 2     |
| pop()     | 移除栈顶       | (5)            |       |
| isEmpty() | 是否为空       | (5)            | false |
| top()     | 取栈顶         | (5)            | 5     |

## 栈的实现

由于栈是一个表，实际上它也和表有类似的实现方式，例如使用`ArrayList`和`LinkedList`分别实现的栈，称之为顺序栈和链栈，Java 中也直接提供了栈的实现`Stack`。

### 顺序栈

```java
public class ArrayStack {
    int[] stack; // 数据存储
    int maxSize; // 栈最大数量
    int top = -1; // 栈顶位置

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 是否已满
     *
     * @return
     */
    public boolean isFull() {
        return maxSize - 1 == top;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return stack[top--];
    }

    /**
     * 显示栈中数据，从栈顶开始显示，也就是按出栈的顺序显示
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("栈中无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("index=%d, value=%d \n", i, stack[i]);
        }
    }
}
```

### 链栈

```java
public class LinkedListStack {
    int maxSize; // 最大支持数
    int size; // 当前栈中元素个数
    // 用来记录栈顶的元素
    Node top;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 是否已满
     *
     * @return
     */
    public boolean isFull() {
        return size == maxSize;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        // 要保证 top 是最后进来的
        Node temp = top;
        top = new Node(value);
        top.next = temp;
        size++;
    }


    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        // top 保存的是最后入栈的元素，直接从 top 取出即可
        Node temp = top;
        top = temp.next;
        size--;
        return temp.value;
    }

    /**
     * 显示栈中数据，从栈顶开始显示，也就是按出栈的顺序显示
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return;
        }
        Node cur = top;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
```

## 栈的应用

那有了栈以后，我们就可以利用它完成前述的工作了，比如完成一个计算器的核心计算逻辑。
例如，我们计算：
$$2*5+6-5*(8-3)=-9$$
在计算器里，我们输入的顺序应当是：
![计算器计算](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309011706838.png)
但是我们按照计算优先级规则，实际上是先计算`2*5=10`后,计算`10+6=16`后，再计算`8-3=5`，接着计算`5*5=25`,最后`16-25=-9`的，我们先把相关表达式放在右侧，如果我们将上述表达式中的数字在前，运算符号在后的顺序排列出来的话，就可以得到`2,5,*,6,+,5,8,3,-,*,-`，再把这些字符按顺序放在左侧。那这和栈又有什么关系呢？
![栈使用情况](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309061631885.png)
我们可以尝试着将这些字符按顺序放到栈里，并规定每次遇到符号的就是就将栈顶的前两个数字按照先右后左的顺序进行运算，并将运算后的结果再放回栈中，再看看会发生什么。
![公式的栈运算](https://raw.githubusercontent.com/Waynehfut/img/img/img/202309061624118.gif)
通过上述动图，我们可以看到每次栈中遇到计算符号时，所进行的运算和我们实际的运算先后顺序是完全一致的，那只要我们按上述字符的顺序将表达式输入栈，那就可以让计算机来为我们处理表达式了，这个特殊的字符串顺序记法称之为后缀记法，对应的表达式字符串称之为**后缀表达式**。相应的，原始的表达式称之为**中缀表达式**。

:::info 后缀表达式的优势
后缀表达式的优势在于，在转换好后缀表达式后几乎不用规定符号或者括号优先级，可以通过$O(N)$的时间复杂度完成对表达式的运算。
:::

### 中缀表达式转后缀表达式

一般来说，最快速的办法是按照上述的思路手工推出来，即：把实际运算过程按顺序写出，但需要注意括号等影响表达式计算顺序的符号。但既然栈可以用来计算后缀表达式的值，那是否可以用栈来转换中缀表达式呢？

下面提供一种基于栈的转换思路：

1. 从左至右，遇到数字直接输出
2. 遇到运算符时：

   - 如果是"("则直接入栈；
   - 若为")"则将栈中的符号依次输出，直到"("，并将"("出栈，但不输出；
   - 若为其他符号，将栈中的符号依次出栈并输出，直到遇到比当前符号优先级更低的符号或者"(",并将当前符号入栈。

3. 遍历完后，将栈中剩余符号输出，其中"("不输出。

我们还是以上述表达式为例：
| 当前元素 | 符号栈 |输出|
| :-: | :-: |:-:|
| 2 | \- |2|
| \* | \* | |
| 5 | \* |5|
| + | + |\*|
| 6 | +| 6 |
| - |\- |+|
| 5 | \-|5|
| \* | \-\*||
| \( |\-\*\( ||
| 8 | \-\*\(|8|
| - | \-\*\(\-||
| 3 | \-\*\(\-|3|
| \) | |\-\*\-|

::: warning 问题 3.1: 中缀表达式转换算法
依据上述规则，可以编制出中缀表达式算法，请思考具体实现。
::: details 参考代码

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 */
public class InfixToSuffix {
    public static void main(String[] args) {
        InfixToSuffix infixToSuffix = new InfixToSuffix();
        // 目标：1+((2+3)*4)-5  转为 1 2 3 + 4 * + 5 -
        // 1. 将中缀表达式转成 List，方便在后续操作中获取数据
        String infixExpression = "1+((2+3)*4)-5";
        List<String> infixList = infixToSuffix.infix2List(infixExpression);
        System.out.println(infixList); // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        // 2. 将中缀表达式转成后缀表达式
        ArrayList<String> suffixList = infixToSuffix.infixList2SuffixList(infixList);
       System.out.println(suffixList); // [1, 2, 3, +, 4, *, +, 5, -]
    }


    /**
     * 将中缀表达式解析成单个元素的 List，
     *
     * @param infixExpression
     * @return 1+((2+3)*4)-5 -> [1,+,(,(,2,+,3,),*,4,),5]
     */
    public List<String> infix2List(String infixExpression) {
        ArrayList<String> res = new ArrayList<>();
        // 扫描并解析
        int index = 0;
        char ch = 0;
        String tempNum = ""; // 支持多位数
        while (index < infixExpression.length()) {
            ch = infixExpression.charAt(index++);
            // 如果不是数字，就是符号，直接添加到容器中
            // 0 = 48, 9 = 57
            if (!(ch >= 48 && ch <= 57)) {
                // 如果拼接的多位数还有值，则添加到容器中
                if (!tempNum.isEmpty()) {
                    res.add(tempNum);
                    tempNum = "";
                }
                res.add(ch + "");
                continue;
            }
            // 如果是数字，则考虑处理多位数
            tempNum += ch;
            // 如果已经是最后一个字符了，则将这个多位数添加到容器中
            if (index == infixExpression.length()) {
                res.add(tempNum);
                tempNum = "";
            }
        }
        return res;
    }

    /**
     * 中缀表达式 List 转为后缀表达式 List
     *
     * @param infixList
     * @return
     */
    private ArrayList<String> infixList2SuffixList(List<String> infixList) {
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 思路是使用栈来存储表达式元素
        // 仔细观察他的解析步骤，会发现：只是在入栈，并未出现出栈操作
        // 而且，最后的结果还要逆序，所以这里使用 list，直接顺序读取出来就是最后的结果了
        ArrayList<String> s2 = new ArrayList<>();

        for (String item : infixList) {
            // 如果是数字，则加入 s2
            if (item.matches("\\d+")) {
                s2.add(item);
            }
            // 如果是左括号，直接压入 s1
            else if (item.equals("(")) {
                s1.push(item);
            }
            // 如果是右括号
            // 则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到 左括号 为止，此时将这一对括号 丢弃
            else if (item.equals(")")) {
                // 如果不是左括号，则取出 s1 中的符号，添加到 s2 中
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // 上面循环完之后，那么就是遇到了左括号
                // 则直接弹出这个左括号丢弃
                s1.pop();
            }
            // 剩下的则是运算符
            else {
                // 如果 s1 为空，或则栈顶运算符为 （，则压入符号栈 s1
                // 如果优先级比栈顶运算符 高，则压入符号栈 s1,否则，否则将 s1 栈顶的运算符弹出，压入 s2 中
                // 上面两句话，转换成下面的描述
                // 上面如果  s1 栈顶符号优先级比 当前符号高，则弹出加入到 s2 中。
                // 因为：如果栈顶符号是 （ 返回优先级为 -1.比当前符号低，则不会走该方法
                while (!s1.isEmpty() && priority(s1.peek().charAt(0)) >= priority(item.charAt(0))) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        // 将 s1 中的运算符依次弹出并加入 s2 中
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 计算操作符号优先级，暂时只支持 + - * /
     *
     * @param ch
     * @return 优先级越高，数值越大
     */
    private int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }
}

```

:::
:::

### 表达式合规检验
