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
