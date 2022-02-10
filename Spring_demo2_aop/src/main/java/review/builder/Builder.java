package review.builder;

import review.product.Product;
//抽象的建造者
public abstract class Builder {
    abstract void    build1(); //原料
    abstract void build2(); //制作零部件
    abstract void build3(); //底部
    abstract void build4(); //颜色
    //得到产品
    abstract Product getProduct();
}
