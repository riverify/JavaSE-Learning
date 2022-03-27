package com.river.test;

public class Fish extends Animal {
    //子类特有的方法
    private double weight;
    //无参构造
    public Fish() {
    }
    //有参构造
    public Fish(int age, double weight){
        super(age);
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {
        return "Fish{" +
                "age=" + super.getAge() +
                "weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        //先调用父类的equals()方法，如果父类的先满足了，才需要继续判断，否则就直接return false
        boolean flag = super.equals(obj);
        if (flag){
            //将obj对象强制转化为Fish类，才能进行下面判断
            Fish other = (Fish)obj;
            if (this.weight == other.weight){
                return true;
            }else return false;
        }else return false;
    }

    public void introduce(){
        System.out.println("我是一条鱼，今年"+getAge()+"岁了,我有"+weight+"斤重");
    }

    public void swim(){
        System.out.println("我在水里真不错");
    }
}
