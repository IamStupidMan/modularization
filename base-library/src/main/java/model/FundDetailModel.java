package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SummerDear on 2018/3/19.
 */

public class FundDetailModel implements Serializable {

    /**
     * investmentStrategy : null
     * accumulateNav : 3.143
     * dividendUpdateEnable : 0
     * fundSizeDate : 1511280000000
     * investmentScope : null
     * launchPrice : 1
     * specializeSector : 一般
     * sevenDaysAnnualizedYield : null
     * fundManagers : {"39504":"崔莹"}
     * isMMFund : 1
     * isQDII : 1
     * minRspAmount : 1
     * fundStatus : 1
     * chargeMode : 0
     * yearToDate : 0.0442
     * managementFee : 1.5
     * investmentObjective : null
     * isSwitchEnable : 0
     * year1 : -0.016
     * fundHouseCode : 1701
     * sinceLaunch : 2.9244
     * buyConfirmLag : 1
     * riskDisclosure : null
     * fundCustodian : 中国工商银行股份有限公司
     * month6 : 0.1079
     * month1 : -0.0167
     * minSubseqBuyAmout : 1
     * nav : 2.763
     * isRspEnable : 0
     * defaultDividendInstruction : 1
     * year5 : 3.0668
     * minSubseqIpoAmount : 1
     * redemptionSettleLag : 3
     * month3 : 0.0522
     * isBuyEnable : 0
     * ipoStartDate : 1342540800000
     * salesServiceFee : 0
     * maxBuyAmount : 5000000
     * minSubseqIpoAmout : 1
     * minRedemptionUnit : 1
     * fundCode : 040035
     * week1 : -0.0153
     * fundName : 华安逆向策略混合
     * riskRate : 4
     * launchDate : 1342540800000
     * fundFullName : 华安逆向策略混合型证券投资基金
     * minRetainUnit : 1
     * navDate : 1511280000000
     * fundHouse : 华安基金管理有限公司
     * day1Performance : -0.93
     * isRecommended : 0
     * isSellEnable : 0
     * currency : 156
     * maxRspAmount : 4999997
     * ipoEndDate : 1344927599000
     * minSubseqBuyAmount : 1
     * minInitialIpoAmount : 1
     * year3 : 1.4131
     * minInitialBuyAmount : 1
     * custodianFee : 0.25
     * earningsPer10000 : null
     * launchSize : 2.3241
     * fundSize : 20.5709
     * maxIpoAmount : 999999999
     * geographicalSector : china.onshore
     * fundType : MIXED
     */

    private String investmentStrategy;
    private String accumulateNav;
    private String dividendUpdateEnable;
    private String fundSizeDate;
    private String investmentScope;
    private String launchPrice;
    private String specializeSector;
    private String sevenDaysAnnualizedYield;
    private String fundManagers;
    private String isMMFund;
    private String isQDII;
    private String minRspAmount;
    private String fundStatus;
    private String fundStatusTxt;
    private String chargeMode;
    private String yearToDate;
    private String managementFee;
    private String investmentObjective;
    private String isSwitchEnable;
    private String year1;
    private String fundHouseCode;
    private String sinceLaunch;
    private String buyConfirmLag;
    private String riskDisclosure;
    private String fundCustodian;
    private String month6;
    private String month1;
    private List<ManagersModel> fundManagersList;
    private String minSubseqBuyAmout;
    private String nav;
    private String isRspEnable;
    private String defaultDividendInstruction;
    private String year5;
    private String minSubseqIpoAmount;
    private String redemptionSettleLag;
    private String month3;
    private String isBuyEnable;//0=可以购买，1=不能购买
    private String ipoStartDate;
    private String salesServiceFee;
    private String maxBuyAmount;
    private String minSubseqIpoAmout;
    private String minRedemptionUnit;
    private String fundCode;
    private String week1;
    private String fundName;
    private int riskRate;
    private String launchDate;
    private String fundFullName;
    private String minRetainUnit;
    private String navDate;
    private String fundHouse;
    private String day1Performance;
    private String isRecommended;
    private String isSellEnable;
    private String currency;
    private String maxRspAmount;
    private String ipoEndDate;
    private String minSubseqBuyAmount;
    private String minInitialIpoAmount;
    private String year3;
    private String minInitialBuyAmount;
    private String custodianFee;
    private String earningsPer10000;
    private String launchSize;
    private String fundSize;
    private String maxIpoAmount;
    private String geographicalSector;
    private String fundType;
    private String expectedCofirmedDate;
    private String expectedDealToBankDate;
    private String favourite;//0 是关注， 1未关注
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getExpectedCofirmedDate() {
        return expectedCofirmedDate;
    }

    public void setExpectedCofirmedDate(String expectedCofirmedDate) {
        this.expectedCofirmedDate = expectedCofirmedDate;
    }

    public String getExpectedDealToBankDate() {
        return expectedDealToBankDate;
    }

    public void setExpectedDealToBankDate(String expectedDealToBankDate) {
        this.expectedDealToBankDate = expectedDealToBankDate;
    }

    public List<ManagersModel> getFundManagersList() {
        return fundManagersList;
    }

    public void setFundManagersList(List<ManagersModel> fundManagersList) {
        this.fundManagersList = fundManagersList;
    }

    public String getInvestmentStrategy() {
        return investmentStrategy;
    }

    public void setInvestmentStrategy(String investmentStrategy) {
        this.investmentStrategy = investmentStrategy;
    }

    public String getFundStatusTxt() {
        return fundStatusTxt;
    }

    public void setFundStatusTxt(String fundStatusTxt) {
        this.fundStatusTxt = fundStatusTxt;
    }

    public String getAccumulateNav() {
        return accumulateNav;
    }

    public void setAccumulateNav(String accumulateNav) {
        this.accumulateNav = accumulateNav;
    }

    public String getDividendUpdateEnable() {
        return dividendUpdateEnable;
    }

    public void setDividendUpdateEnable(String dividendUpdateEnable) {
        this.dividendUpdateEnable = dividendUpdateEnable;
    }

    public String getFundSizeDate() {
        return fundSizeDate;
    }

    public void setFundSizeDate(String fundSizeDate) {
        this.fundSizeDate = fundSizeDate;
    }

    public String getInvestmentScope() {
        return investmentScope;
    }

    public void setInvestmentScope(String investmentScope) {
        this.investmentScope = investmentScope;
    }

    public String getLaunchPrice() {
        return launchPrice;
    }

    public void setLaunchPrice(String launchPrice) {
        this.launchPrice = launchPrice;
    }

    public String getSpecializeSector() {
        return specializeSector;
    }

    public void setSpecializeSector(String specializeSector) {
        this.specializeSector = specializeSector;
    }

    public String getSevenDaysAnnualizedYield() {
        return sevenDaysAnnualizedYield;
    }

    public void setSevenDaysAnnualizedYield(String sevenDaysAnnualizedYield) {
        this.sevenDaysAnnualizedYield = sevenDaysAnnualizedYield;
    }

    public String getFundManagers() {
        return fundManagers;
    }

    public void setFundManagers(String fundManagers) {
        this.fundManagers = fundManagers;
    }

    public String getIsMMFund() {
        return isMMFund;
    }

    public void setIsMMFund(String isMMFund) {
        this.isMMFund = isMMFund;
    }

    public String getIsQDII() {
        return isQDII;
    }

    public void setIsQDII(String isQDII) {
        this.isQDII = isQDII;
    }

    public String getMinRspAmount() {
        return minRspAmount;
    }

    public void setMinRspAmount(String minRspAmount) {
        this.minRspAmount = minRspAmount;
    }

    public String getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    public String getYearToDate() {
        return yearToDate;
    }

    public void setYearToDate(String yearToDate) {
        this.yearToDate = yearToDate;
    }

    public String getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(String managementFee) {
        this.managementFee = managementFee;
    }

    public String getInvestmentObjective() {
        return investmentObjective;
    }

    public void setInvestmentObjective(String investmentObjective) {
        this.investmentObjective = investmentObjective;
    }

    public String getIsSwitchEnable() {
        return isSwitchEnable;
    }

    public void setIsSwitchEnable(String isSwitchEnable) {
        this.isSwitchEnable = isSwitchEnable;
    }

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public String getFundHouseCode() {
        return fundHouseCode;
    }

    public void setFundHouseCode(String fundHouseCode) {
        this.fundHouseCode = fundHouseCode;
    }

    public String getSinceLaunch() {
        return sinceLaunch;
    }

    public void setSinceLaunch(String sinceLaunch) {
        this.sinceLaunch = sinceLaunch;
    }

    public String getBuyConfirmLag() {
        return buyConfirmLag;
    }

    public void setBuyConfirmLag(String buyConfirmLag) {
        this.buyConfirmLag = buyConfirmLag;
    }

    public String getRiskDisclosure() {
        return riskDisclosure;
    }

    public void setRiskDisclosure(String riskDisclosure) {
        this.riskDisclosure = riskDisclosure;
    }

    public String getFundCustodian() {
        return fundCustodian;
    }

    public void setFundCustodian(String fundCustodian) {
        this.fundCustodian = fundCustodian;
    }

    public String getMonth6() {
        return month6;
    }

    public void setMonth6(String month6) {
        this.month6 = month6;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getMinSubseqBuyAmout() {
        return minSubseqBuyAmout;
    }

    public void setMinSubseqBuyAmout(String minSubseqBuyAmout) {
        this.minSubseqBuyAmout = minSubseqBuyAmout;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getIsRspEnable() {
        return isRspEnable;
    }

    public void setIsRspEnable(String isRspEnable) {
        this.isRspEnable = isRspEnable;
    }

    public String getDefaultDividendInstruction() {
        return defaultDividendInstruction;
    }

    public void setDefaultDividendInstruction(String defaultDividendInstruction) {
        this.defaultDividendInstruction = defaultDividendInstruction;
    }

    public String getYear5() {
        return year5;
    }

    public void setYear5(String year5) {
        this.year5 = year5;
    }

    public String getMinSubseqIpoAmount() {
        return minSubseqIpoAmount;
    }

    public void setMinSubseqIpoAmount(String minSubseqIpoAmount) {
        this.minSubseqIpoAmount = minSubseqIpoAmount;
    }

    public String getRedemptionSettleLag() {
        return redemptionSettleLag;
    }

    public void setRedemptionSettleLag(String redemptionSettleLag) {
        this.redemptionSettleLag = redemptionSettleLag;
    }

    public String getMonth3() {
        return month3;
    }

    public void setMonth3(String month3) {
        this.month3 = month3;
    }

    public String getIsBuyEnable() {
        return isBuyEnable;
    }

    public void setIsBuyEnable(String isBuyEnable) {
        this.isBuyEnable = isBuyEnable;
    }

    public String getIpoStartDate() {
        return ipoStartDate;
    }

    public void setIpoStartDate(String ipoStartDate) {
        this.ipoStartDate = ipoStartDate;
    }

    public String getSalesServiceFee() {
        return salesServiceFee;
    }

    public void setSalesServiceFee(String salesServiceFee) {
        this.salesServiceFee = salesServiceFee;
    }

    public String getMaxBuyAmount() {
        return maxBuyAmount;
    }

    public void setMaxBuyAmount(String maxBuyAmount) {
        this.maxBuyAmount = maxBuyAmount;
    }

    public String getMinSubseqIpoAmout() {
        return minSubseqIpoAmout;
    }

    public void setMinSubseqIpoAmout(String minSubseqIpoAmout) {
        this.minSubseqIpoAmout = minSubseqIpoAmout;
    }

    public String getMinRedemptionUnit() {
        return minRedemptionUnit;
    }

    public void setMinRedemptionUnit(String minRedemptionUnit) {
        this.minRedemptionUnit = minRedemptionUnit;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public int getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(int riskRate) {
        this.riskRate = riskRate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getFundFullName() {
        return fundFullName;
    }

    public void setFundFullName(String fundFullName) {
        this.fundFullName = fundFullName;
    }

    public String getMinRetainUnit() {
        return minRetainUnit;
    }

    public void setMinRetainUnit(String minRetainUnit) {
        this.minRetainUnit = minRetainUnit;
    }

    public String getNavDate() {
        return navDate;
    }

    public void setNavDate(String navDate) {
        this.navDate = navDate;
    }

    public String getFundHouse() {
        return fundHouse;
    }

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
    }

    public String getDay1Performance() {
        return day1Performance;
    }

    public void setDay1Performance(String day1Performance) {
        this.day1Performance = day1Performance;
    }

    public String getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(String isRecommended) {
        this.isRecommended = isRecommended;
    }

    public String getIsSellEnable() {
        return isSellEnable;
    }

    public void setIsSellEnable(String isSellEnable) {
        this.isSellEnable = isSellEnable;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMaxRspAmount() {
        return maxRspAmount;
    }

    public void setMaxRspAmount(String maxRspAmount) {
        this.maxRspAmount = maxRspAmount;
    }

    public String getIpoEndDate() {
        return ipoEndDate;
    }

    public void setIpoEndDate(String ipoEndDate) {
        this.ipoEndDate = ipoEndDate;
    }

    public String getMinSubseqBuyAmount() {
        return minSubseqBuyAmount;
    }

    public void setMinSubseqBuyAmount(String minSubseqBuyAmount) {
        this.minSubseqBuyAmount = minSubseqBuyAmount;
    }

    public String getMinInitialIpoAmount() {
        return minInitialIpoAmount;
    }

    public void setMinInitialIpoAmount(String minInitialIpoAmount) {
        this.minInitialIpoAmount = minInitialIpoAmount;
    }

    public String getYear3() {
        return year3;
    }

    public void setYear3(String year3) {
        this.year3 = year3;
    }

    public String getMinInitialBuyAmount() {
        return minInitialBuyAmount;
    }

    public void setMinInitialBuyAmount(String minInitialBuyAmount) {
        this.minInitialBuyAmount = minInitialBuyAmount;
    }

    public String getCustodianFee() {
        return custodianFee;
    }

    public void setCustodianFee(String custodianFee) {
        this.custodianFee = custodianFee;
    }

    public String getEarningsPer10000() {
        return earningsPer10000;
    }

    public void setEarningsPer10000(String earningsPer10000) {
        this.earningsPer10000 = earningsPer10000;
    }

    public String getLaunchSize() {
        return launchSize;
    }

    public void setLaunchSize(String launchSize) {
        this.launchSize = launchSize;
    }

    public String getFundSize() {
        return fundSize;
    }

    public void setFundSize(String fundSize) {
        this.fundSize = fundSize;
    }

    public String getMaxIpoAmount() {
        return maxIpoAmount;
    }

    public void setMaxIpoAmount(String maxIpoAmount) {
        this.maxIpoAmount = maxIpoAmount;
    }

    public String getGeographicalSector() {
        return geographicalSector;
    }

    public void setGeographicalSector(String geographicalSector) {
        this.geographicalSector = geographicalSector;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }


    public static class ManagersModel implements Serializable {

        private String managerCode;
        private String managerName;

        public String getManagerCode() {
            return managerCode;
        }

        public void setManagerCode(String managerCode) {
            this.managerCode = managerCode;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }
    }

    @Override
    public String toString() {
        return "FundDetailModel{" +
                "investmentStrategy='" + investmentStrategy + '\'' +
                ", accumulateNav='" + accumulateNav + '\'' +
                ", dividendUpdateEnable='" + dividendUpdateEnable + '\'' +
                ", fundSizeDate='" + fundSizeDate + '\'' +
                ", investmentScope='" + investmentScope + '\'' +
                ", launchPrice='" + launchPrice + '\'' +
                ", specializeSector='" + specializeSector + '\'' +
                ", sevenDaysAnnualizedYield='" + sevenDaysAnnualizedYield + '\'' +
                ", fundManagers='" + fundManagers + '\'' +
                ", isMMFund='" + isMMFund + '\'' +
                ", isQDII='" + isQDII + '\'' +
                ", minRspAmount='" + minRspAmount + '\'' +
                ", fundStatus='" + fundStatus + '\'' +
                ", fundStatusTxt='" + fundStatusTxt + '\'' +
                ", chargeMode='" + chargeMode + '\'' +
                ", yearToDate='" + yearToDate + '\'' +
                ", managementFee='" + managementFee + '\'' +
                ", investmentObjective='" + investmentObjective + '\'' +
                ", isSwitchEnable='" + isSwitchEnable + '\'' +
                ", year1='" + year1 + '\'' +
                ", fundHouseCode='" + fundHouseCode + '\'' +
                ", sinceLaunch='" + sinceLaunch + '\'' +
                ", buyConfirmLag='" + buyConfirmLag + '\'' +
                ", riskDisclosure='" + riskDisclosure + '\'' +
                ", fundCustodian='" + fundCustodian + '\'' +
                ", month6='" + month6 + '\'' +
                ", month1='" + month1 + '\'' +
                ", fundManagersList=" + fundManagersList +
                ", minSubseqBuyAmout='" + minSubseqBuyAmout + '\'' +
                ", nav='" + nav + '\'' +
                ", isRspEnable='" + isRspEnable + '\'' +
                ", defaultDividendInstruction='" + defaultDividendInstruction + '\'' +
                ", year5='" + year5 + '\'' +
                ", minSubseqIpoAmount='" + minSubseqIpoAmount + '\'' +
                ", redemptionSettleLag='" + redemptionSettleLag + '\'' +
                ", month3='" + month3 + '\'' +
                ", isBuyEnable='" + isBuyEnable + '\'' +
                ", ipoStartDate='" + ipoStartDate + '\'' +
                ", salesServiceFee='" + salesServiceFee + '\'' +
                ", maxBuyAmount='" + maxBuyAmount + '\'' +
                ", minSubseqIpoAmout='" + minSubseqIpoAmout + '\'' +
                ", minRedemptionUnit='" + minRedemptionUnit + '\'' +
                ", fundCode='" + fundCode + '\'' +
                ", week1='" + week1 + '\'' +
                ", fundName='" + fundName + '\'' +
                ", riskRate=" + riskRate +
                ", launchDate='" + launchDate + '\'' +
                ", fundFullName='" + fundFullName + '\'' +
                ", minRetainUnit='" + minRetainUnit + '\'' +
                ", navDate='" + navDate + '\'' +
                ", fundHouse='" + fundHouse + '\'' +
                ", day1Performance='" + day1Performance + '\'' +
                ", isRecommended='" + isRecommended + '\'' +
                ", isSellEnable='" + isSellEnable + '\'' +
                ", currency='" + currency + '\'' +
                ", maxRspAmount='" + maxRspAmount + '\'' +
                ", ipoEndDate='" + ipoEndDate + '\'' +
                ", minSubseqBuyAmount='" + minSubseqBuyAmount + '\'' +
                ", minInitialIpoAmount='" + minInitialIpoAmount + '\'' +
                ", year3='" + year3 + '\'' +
                ", minInitialBuyAmount='" + minInitialBuyAmount + '\'' +
                ", custodianFee='" + custodianFee + '\'' +
                ", earningsPer10000='" + earningsPer10000 + '\'' +
                ", launchSize='" + launchSize + '\'' +
                ", fundSize='" + fundSize + '\'' +
                ", maxIpoAmount='" + maxIpoAmount + '\'' +
                ", geographicalSector='" + geographicalSector + '\'' +
                ", fundType='" + fundType + '\'' +
                ", expectedCofirmedDate='" + expectedCofirmedDate + '\'' +
                ", expectedDealToBankDate='" + expectedDealToBankDate + '\'' +
                ", favourite='" + favourite + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
