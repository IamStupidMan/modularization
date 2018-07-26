package model;

import java.io.Serializable;

/**
 *
 */

public class FundInfoModel implements Serializable {


    /**
     * accumulateNav : 4.6299
     * fundType : MIXED
     * nav : 0.3521
     * specializeSector : 一般
     * isMMFund : 1
     * isBuyEnable : 0
     * yearToDate : 0.272
     * week1 : 0.0405
     * sinceLaunch : 6.4731
     * geographicalSector : china.onshore
     * month1 : 0.0851
     * month6 : 0.2557
     * sevenDaysAnnualizedYield : null
     * navDate : 1511280000000
     * fundStatus : 1
     * fundName : 工银核心价值混合A
     * month3 : 0.1567
     * fundSize : 44.7753
     * fundHouse : 工银瑞信基金管理有限公司
     * year1 : 0.2009
     * year5 : 1.2544
     * riskRate : 4
     * isRecommended : 1
     * fundManagers : {"39369":"何肖颉"}
     * year3 : 0.5164
     * day1Performance : -0.42
     * isQDII : 1
     * earningsPer10000 : null
     * fundFullName : 工银瑞信核心价值混合型证券投资基金
     * fundCode : 481001
     * fundHouseCode : 1410
     */

    private String accumulateNav;
    private boolean isShowDel;//是否显示删除按钮
    private String searchWord;//本地添加字段，用于改变搜索词的颜色
    private String fundType;
    private String nav;
    private String specializeSector;
    private String isMMFund;//"是否是货币型基金。0=货币型基金，1=非货币型基金",
    private String isBuyEnable;
    private String yearToDate;
    private String week1;
    private String sinceLaunch;
    private String geographicalSector;
    private String month1;
    private String month6;
    private String sevenDaysAnnualizedYield;
    private String navDate;
    private String fundStatus;
    private String fundName;
    private String month3;
    private String fundSize;
    private String fundHouse;
    private String year1;
    private String year5;
    private int riskRate;
    private String isRecommended;
    private String year3;
    private String day1Performance;
    private String isQDII;
    private String earningsPer10000;
    private String fundFullName;
    private String fundCode;
    private String fundHouseCode;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public boolean isShowDel() {
        return isShowDel;
    }

    public void setShowDel(boolean showDel) {
        isShowDel = showDel;
    }

    public String getAccumulateNav() {
        return accumulateNav;
    }

    public void setAccumulateNav(String accumulateNav) {
        this.accumulateNav = accumulateNav;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getSpecializeSector() {
        return specializeSector;
    }

    public void setSpecializeSector(String specializeSector) {
        this.specializeSector = specializeSector;
    }

    public String getIsMMFund() {
        return isMMFund;
    }

    public void setIsMMFund(String isMMFund) {
        this.isMMFund = isMMFund;
    }

    public String getIsBuyEnable() {
        return isBuyEnable;
    }

    public void setIsBuyEnable(String isBuyEnable) {
        this.isBuyEnable = isBuyEnable;
    }


    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getSinceLaunch() {
        return sinceLaunch;
    }

    public void setSinceLaunch(String sinceLaunch) {
        this.sinceLaunch = sinceLaunch;
    }

    public String getGeographicalSector() {
        return geographicalSector;
    }

    public void setGeographicalSector(String geographicalSector) {
        this.geographicalSector = geographicalSector;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getMonth6() {
        return month6;
    }

    public void setMonth6(String month6) {
        this.month6 = month6;
    }

    public String getSevenDaysAnnualizedYield() {
        return sevenDaysAnnualizedYield;
    }

    public void setSevenDaysAnnualizedYield(String sevenDaysAnnualizedYield) {
        this.sevenDaysAnnualizedYield = sevenDaysAnnualizedYield;
    }

    public void setEarningsPer10000(String earningsPer10000) {
        this.earningsPer10000 = earningsPer10000;
    }

    public String getNavDate() {
        return navDate;
    }

    public void setNavDate(String navDate) {
        this.navDate = navDate;
    }

    public String getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getMonth3() {
        return month3;
    }

    public void setMonth3(String month3) {
        this.month3 = month3;
    }

    public String getFundSize() {
        return fundSize;
    }

    public void setFundSize(String fundSize) {
        this.fundSize = fundSize;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
    }

    public int getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(int riskRate) {
        this.riskRate = riskRate;
    }

    public String getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(String isRecommended) {
        this.isRecommended = isRecommended;
    }

    public String getYearToDate() {
        return yearToDate;
    }

    public void setYearToDate(String yearToDate) {
        this.yearToDate = yearToDate;
    }

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public String getYear5() {
        return year5;
    }

    public void setYear5(String year5) {
        this.year5 = year5;
    }

    public String getYear3() {
        return year3;
    }

    public void setYear3(String year3) {
        this.year3 = year3;
    }

    public String getEarningsPer10000() {
        return earningsPer10000;
    }

    public String getDay1Performance() {
        return day1Performance;
    }

    public void setDay1Performance(String day1Performance) {
        this.day1Performance = day1Performance;
    }

    public String getIsQDII() {
        return isQDII;
    }

    public void setIsQDII(String isQDII) {
        this.isQDII = isQDII;
    }

    public String getFundFullName() {
        return fundFullName;
    }

    public void setFundFullName(String fundFullName) {
        this.fundFullName = fundFullName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundHouseCode() {
        return fundHouseCode;
    }

    public void setFundHouseCode(String fundHouseCode) {
        this.fundHouseCode = fundHouseCode;
    }


    @Override
    public String toString() {
        return "FundInfoModel{" +
                "accumulateNav=" + accumulateNav +
                ", fundType='" + fundType + '\'' +
                ", nav=" + nav +
                ", specializeSector='" + specializeSector + '\'' +
                ", isMMFund='" + isMMFund + '\'' +
                ", isBuyEnable='" + isBuyEnable + '\'' +
                ", yearToDate=" + yearToDate +
                ", week1=" + week1 +
                ", sinceLaunch=" + sinceLaunch +
                ", geographicalSector='" + geographicalSector + '\'' +
                ", month1=" + month1 +
                ", month6=" + month6 +
                ", sevenDaysAnnualizedYield=" + sevenDaysAnnualizedYield +
                ", navDate=" + navDate +
                ", fundStatus='" + fundStatus + '\'' +
                ", fundName='" + fundName + '\'' +
                ", month3=" + month3 +
                ", fundSize=" + fundSize +
                ", fundHouse='" + fundHouse + '\'' +
                ", year1=" + year1 +
                ", year5=" + year5 +
                ", riskRate=" + riskRate +
                ", isRecommended='" + isRecommended + '\'' +
                ", year3=" + year3 +
                ", day1Performance=" + day1Performance +
                ", isQDII='" + isQDII + '\'' +
                ", earningsPer10000=" + earningsPer10000 +
                ", fundFullName='" + fundFullName + '\'' +
                ", fundCode='" + fundCode + '\'' +
                ", fundHouseCode=" + fundHouseCode +
                '}';
    }
}
