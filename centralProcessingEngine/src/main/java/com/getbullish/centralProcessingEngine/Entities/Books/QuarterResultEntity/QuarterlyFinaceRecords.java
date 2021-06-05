package com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "quarterlyfinancerecords")
@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class QuarterlyFinaceRecords extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @OneToOne
  @JoinColumn(name = "stock", nullable = false)
  Stock stock;

  @Column(name = "quarter")
  String quarter;

  @Column(name = "year")
  String year;

  @Column(name = "cumulative")
  boolean cumulative;

  @Column(name = "consolidated")
  boolean consolidated;

  @Column(name = "audited")
  boolean audited;


  @Column(name = "basicearningslosspersharefromcontinuinganddiscontinuedoperat")
  Double basicEarningsLossPerShareFromContinuingAndDiscontinuedOperations;


  @Column(name = "basicearningslosspersharefromcontinuingoperations")
  Double basicEarningsLossPerShareFromContinuingOperations;


  @Column(name = "basicearningslosspersharefromdiscontinuedoperations")
  Double basicEarningsLossPerShareFromDiscontinuedOperations;


  @Column(name = "changesininventoriesoffinishedgoodsworkinprogressandstockint")
  Double changesInInventoriesOfFinishedGoodsWorkInProgressAndStockInTrade;


  @Column(name = "comprehensiveincomefortheperiod")
  Double comprehensiveIncomeForThePeriod;


  @Column(name = "comprehensiveincomefortheperiodattributabletoownersofparent")
  Double comprehensiveIncomeForThePeriodAttributableToOwnersOfParent;


  @Column(name = "comprehensiveincomefortheperiodattributabletoownersofparentn")
  Double comprehensiveIncomeForThePeriodAttributableToOwnersOfParentNonControllingInterests;


  @Column(name = "costofmaterialsconsumed")
  Double costOfMaterialsConsumed;


  @Column(name = "currenttax")
  Double currentTax;


  @Column(name = "dateofendoffinancialyear")
  Date dateOfEndOfFinancialYear;


  @Column(name = "dateofendofreportingperiod")
  Date dateOfEndOfReportingPeriod;


  @Column(name = "dateofstartoffinancialyear")
  Date dateOfStartOfFinancialYear;


  @Column(name = "dateofstartofreportingperiod")
  Date dateOfStartOfReportingPeriod;


  @Column(name = "dateonwhichpriorintimationofthemeetingforconsideringfinancia")
  Date dateOnWhichPriorIntimationOfTheMeetingForConsideringFinancialResultsWasInformedToTheExchange;


  @Column(name = "deferredtax")
  Double deferredTax;


  @Column(name = "depreciationdepletionandamortisationexpense")
  Double depreciationDepletionAndAmortisationExpense;


  @Column(name = "descriptionofotherexpenses")
  Double descriptionOfOtherExpenses;


  @Column(name = "descriptionofpresentationcurrency")
  Double descriptionOfPresentationCurrency;


  @Column(name = "descriptionofsinglesegment")
  Double descriptionOfSingleSegment;


  @Column(name = "dilutedearningslosspersharefromcontinuinganddiscontinuedoper")
  Double dilutedEarningsLossPerShareFromContinuingAndDiscontinuedOperations;


  @Column(name = "dilutedearningslosspersharefromcontinuingoperations")
  Double dilutedEarningsLossPerShareFromContinuingOperations;


  @Column(name = "dilutedearningslosspersharefromdiscontinuedoperations")
  Double dilutedEarningsLossPerShareFromDiscontinuedOperations;


  @Column(name = "employeebenefitexpense")
  Double employeeBenefitExpense;


  @Column(name = "exceptionalitemsbeforetax")
  Double exceptionalItemsBeforeTax;


  @Column(name = "expenses")
  Double expenses;


  @Column(name = "facevalueofequitysharecapital")
  Double faceValueOfEquityShareCapital;


  @Column(name = "financecosts")
  Double financeCosts;


  @Column(name = "income")
  Double income;


  @Column(name = "iscompanyreportingmultisegmentorsinglesegment")
  String isCompanyReportingMultisegmentOrSingleSegment;


  @Column(name = "levelofroundingusedinfinancialstatements")
  String levelOfRoundingUsedInFinancialStatements;


  @Column(name = "natureofreportstandaloneconsolidated")
  String natureOfReportStandaloneConsolidated;


  @Column(name = "netmovementinregulatorydeferralaccountbalancesrelatedtoprofi")
  Double netMovementInRegulatoryDeferralAccountBalancesRelatedToProfitOrLossAndTheRelatedDeferredTaxMovement;


  @Column(name = "othercomprehensiveincomenetoftaxes")
  Double otherComprehensiveIncomeNetOfTaxes;


  @Column(name = "otherexpenses")
  Double otherExpenses;


  @Column(name = "otherincome")
  Double otherIncome;


  @Column(name = "paidupvalueofequitysharecapital")
  Double paidUpValueOfEquityShareCapital;


  @Column(name = "profitbeforeexceptionalitemsandtax")
  Double profitBeforeExceptionalItemsAndTax;


  @Column(name = "profitbeforetax")
  Double profitBeforeTax;


  @Column(name = "profitlossforperiod")
  Double profitLossForPeriod;


  @Column(name = "profitlossforperiodfromcontinuingoperations")
  Double profitLossForPeriodFromContinuingOperations;


  @Column(name = "profitlossfromdiscontinuedoperationsaftertax")
  Double profitLossFromDiscontinuedOperationsAfterTax;


  @Column(name = "profitlossfromdiscontinuedoperationsbeforetax")
  Double profitLossFromDiscontinuedOperationsBeforeTax;


  @Column(name = "purchasesofstockintrade")
  Double purchasesOfStockInTrade;


  @Column(name = "reportingquarter")
  Double reportingQuarter;


  @Column(name = "revenuefromoperations")
  Double revenueFromOperations;


  @Column(name = "shareofprofitlossofassociatesandjointventuresaccountedforusi")
  Double shareOfProfitLossOfAssociatesAndJointVenturesAccountedForUsingEquityMethod;


  @Column(name = "symbol")
  String symbol;


  @Column(name = "taxexpense")
  Double taxExpense;


  @Column(name = "taxexpenseofdiscontinuedoperations")
  Double taxExpenseOfDiscontinuedOperations;


  @Column(name = "whetherresultsareauditedorunaudited")
  String whetherResultsAreAuditedOrUnaudited;



}
