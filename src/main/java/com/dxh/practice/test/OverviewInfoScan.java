package com.dxh.practice.test;

/**
 * @author dongxiaohua
 */
public abstract class OverviewInfoScan {

  private ScanOverviewSource scanOverviewSource;

  public String getOverviewType() {
    return overviewType;
  }

  public void setOverviewType(String overviewType) {
    this.overviewType = overviewType;
  }

  /**
   * 概览类型
   */
  public String overviewType;

  OverviewInfoScan(ScanOverviewSource scanOverviewSource) {
    this.scanOverviewSource = scanOverviewSource;
  }

  abstract public void scan();

  public ScanOverviewSource getScanOverviewSource() {
    return scanOverviewSource;
  }

  public void setScanOverviewSource(ScanOverviewSource scanOverviewSource) {
    this.scanOverviewSource = scanOverviewSource;
  }
}
