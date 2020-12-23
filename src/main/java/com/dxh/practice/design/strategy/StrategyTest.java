package com.dxh.practice.design.strategy;

/**
 * 策略模式: 定义了算法族，分别封装起来，让他们之前可以互相替换，此模式的变化独立于算法的使用者。
 * 以植物大战僵尸中的僵尸为例
 *
 * @author dongxiaohua
 */
public class StrategyTest {
  public static void main(String[] args) {
    Zombie zombie = new NormalZombie();
    zombie.display();
    zombie.attack();
    zombie.move();

    zombie.setAttackable(new HitAttack());
    zombie.attack();
  }
}


/**
 * 移动接口
 */
interface Moveable {
  void move();
}


/**
 * 攻击接口
 */
interface Attackable {
  void attack();
}


/**
 * 僵尸抽象类(业务中所需要的)
 */
abstract class Zombie {
  abstract public void display();

  Moveable moveable;
  Attackable attackable;

  /**
   * 构造函数
   *
   * @param moveable
   * @param attackable
   */
  Zombie(Moveable moveable, Attackable attackable) {
    this.moveable = moveable;
    this.attackable = attackable;
  }

  abstract void move();

  abstract void attack();

  public Moveable getMoveable() {
    return moveable;
  }

  public void setMoveable(Moveable moveable) {
    this.moveable = moveable;
  }

  public Attackable getAttackable() {
    return attackable;
  }

  public void setAttackable(Attackable attackable) {
    this.attackable = attackable;
  }
}


/**
 * 一步一步移动，实现移动接口
 */
class StepByStepMove implements Moveable {

  @Override
  public void move() {
    System.out.println("一步一步移动");
  }
}


/**
 * 攻击方式 -- 咬
 */
class BiteAttack implements Attackable {

  @Override
  public void attack() {
    System.out.println("咬");
  }
}


/**
 * 攻击方式 -- 打
 */
class HitAttack implements Attackable {

  @Override
  public void attack() {
    System.out.println("打");
  }
}


/**
 * 普通僵尸
 */
class NormalZombie extends Zombie {

  NormalZombie() {
    super(new StepByStepMove(), new BiteAttack());
  }

  @Override
  public void display() {
    System.out.println("我是普通僵尸");
  }

  @Override
  void move() {
    moveable.move();
  }

  @Override
  void attack() {
    attackable.attack();
  }
}


/**
 * 旗手僵尸
 */
class FlogZombie extends Zombie {

  /**
   * 无参构造，传默认行为
   */
  public FlogZombie() {
    super(new StepByStepMove(), new BiteAttack());
  }

  FlogZombie(Moveable moveable, Attackable attackable) {
    super(moveable, attackable);
  }

  @Override
  public void display() {
    System.out.println("我是旗手僵尸");
  }

  @Override
  void move() {
    moveable.move();
  }

  @Override
  void attack() {
    attackable.attack();
  }
}
