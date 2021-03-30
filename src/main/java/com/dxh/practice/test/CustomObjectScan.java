package com.dxh.practice.test;

/**
 * @author dongxiaohua
 */
public class CustomObjectScan extends OverviewInfoScan {

  CustomObjectScan() {
    super(new PgScanOverviewSource());
  }

  @Override
  public void scan() {
  }
}


class MeaningOfThis{
  public final int value = 4;
  public void doit(){
    int value = 6;
    Runnable r = new Runnable() {
      public final int value = 5;
      @Override
      public void run() {
        int value = 10;
        System.out.println(this.value);
      }
    };
    r.run();
  }

  public static void main(String[] args) {
    MeaningOfThis m = new MeaningOfThis();
    m.doit();
  }
}
