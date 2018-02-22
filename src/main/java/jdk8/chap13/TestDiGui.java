package jdk8.chap13;

/**
 * Created by Administrator on 2017/5/24.
 */

//当编译器检测到一个函数调用是尾递归的时候，它就覆盖当前的活动记录而不是在栈中去创建一个新的。
//编译器可以做到这点，因为递归调用是当前活跃期内最后一条待执行的语句，
//于是当这个调用返回时栈帧中并没有其他事情可做，因此也就没有保存栈帧的必要了。
//通过覆盖当前的栈帧而不是在其之上重新添加一个，这样所使用的栈空间就大大缩减了，
//这使得实际的运行效率会变得更高。
public class TestDiGui {

    public static void main(String[] args) {
        TestDiGui diGui = new TestDiGui();
        long start = System.currentTimeMillis();
        System.out.println(diGui.facttail(10, 1));
        System.out.println("用时: " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        System.out.println(diGui.facttailOld(10));
        System.out.println("用时2: " + (System.currentTimeMillis() - start2));

    }

    int facttail(int n, int a)
    {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (n == 1)
            return a;
        else
            return facttail(n - 1, n * a);
    }

    int facttailOld(int n){
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else
            return facttailOld(n - 1)*n;
    }

}
