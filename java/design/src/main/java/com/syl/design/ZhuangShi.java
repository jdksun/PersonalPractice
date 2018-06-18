package com.syl.design;

public class ZhuangShi {
    public static void main(String[] args) {
        NaiCha naiCha = new BuDingNaiCha();
        System.out.println(naiCha);
        naiCha = new Milk(naiCha);
        System.out.println(naiCha);
        naiCha = new ZhenZhu(naiCha);
        System.out.println(naiCha);
    }
}
abstract class NaiCha{
    protected String desc;
    public abstract int cost();

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return getDesc() + " " + cost() + "元";
    }
}
abstract class CondimentDecorator extends NaiCha{
    public abstract String getDesc();
}

class BuDingNaiCha extends NaiCha{
    public BuDingNaiCha() {
        desc = "布丁奶茶";
    }

    public int cost() {
        return 12;
    }
}
class Milk extends CondimentDecorator{
    private NaiCha naiCha;

    public Milk(NaiCha naiCha) {
        this.naiCha = naiCha;
    }

    public int cost() {
        return naiCha.cost() + 6;
    }

    public String getDesc() {
        return naiCha.getDesc() + ",加安慕希";
    }
}
class ZhenZhu extends CondimentDecorator{
    private NaiCha naiCha;

    public ZhenZhu(NaiCha naiCha) {
        this.naiCha = naiCha;
    }
    public int cost() {
        return naiCha.cost() + 3;
    }

    public String getDesc() {
        return naiCha.getDesc() + ",加珍珠";
    }
}