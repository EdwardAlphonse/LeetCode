package other;
import java.util.ArrayList;
import java.util.Random;


public class WeiXinRedPackage {
    public static void main(String[] args) {
        double sum = 0;
        ArrayList<Double> result
                = getRandomMoney(100, 20);
        for (double money : result) {
            sum += money;
            System.out.print(money + " ");
        }
        System.out.println();
        System.out.println(sum);
    }

    private static ArrayList<Double> getRandomMoney(double remainMoney, int remainSize) {
        ArrayList<Double> result
                = new ArrayList(remainSize);
        Random random = new Random();
        //产生[0,1)之间的随机数
        while (remainSize > 1) {
            //最大的红包为：两倍的平均红包大小
            double max = (remainMoney / remainSize) * 2;
            //抢到的红包区间[0,max)
            double r = random.nextDouble();
            double money = r * max;
            money = money <= 0.01 ? 0.01 : money;
            money = Math.floor(money * 100) / 100;
            result.add(money);
            remainSize--;
            remainMoney -= money;
        }
        //最后一个红包为剩余余额
        result.add(Math.floor(remainMoney * 100) / 100);
        return result;
    }


}
