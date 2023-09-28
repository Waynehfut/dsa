/*2.1 顺序表*/
public class MyListClass<E>    //顺序表泛型类
{
    final int initcapacity = 10;    //顺序表的初始容量(常量)
    public E[] data;        //存放顺序表中元素
    public int size;        //存放顺序表的长度
    private int capacity;        //存放顺序表的容量

    public MyListClass()    //构造方法，实现data和length的初始化
    {
        data = (E[]) new Object[initcapacity];  //强制转换为E类型数组
        capacity = initcapacity;
        size = 0;

    }

    //线性表的基本运算算法
    private void updatecapacity(int newcapacity)
    //改变顺序表的容量为newcapacity
    {
        E[] newdata = (E[]) new Object[newcapacity];
        for (int i = 0; i < size; i++)        //复制原来的元素
            newdata[i] = data[i];
        capacity = newcapacity;        //设置新容量
        data = newdata;            //仍由data标识数组
    }


    public void CreateList(E[] a)            //由a整体建立顺序表
    {
        size = 0;
        for (int i = 0; i < a.length; i++) {
            if (size == capacity)                    //出现上溢出时
                updatecapacity(2 * size);        //扩大容量
            data[size] = a[i];
            size++;                                    //添加的元素个数增加1
        }
    }


}
