package com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity;

import java.time.Year;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.getbullish.centralProcessingEngine.Entities.Stock;
import lombok.Data;

@Data
public class QuarterlyFinaceRecords {

  @OneToMany
  @JoinColumn(name = "id", nullable = false)
  Stock stock;

  @Column(name = "")
  Quarter quarter;

  @Column(name = "")
  Year year;

  @Column(name = "")
  boolean cumulative;

  @Column(name = "")
  boolean consolidated;


  @Column(name = "BasicEarningsLossPerShareFromContinuingAndDiscontinuedOperat")
  Double basicEarningsLossPerShareFromContinuingAndDiscontinuedOperations;


  @Column(name = "BasicEarningsLossPerShareFromContinuingOperations")
  Double basicEarningsLossPerShareFromContinuingOperations;


  @Column(name = "BasicEarningsLossPerShareFromDiscontinuedOperations")
  Double basicEarningsLossPerShareFromDiscontinuedOperations;


  @Column(name = "ChangesInInventoriesOfFinishedGoodsWorkInProgressAndStockInT")
  Double changesInInventoriesOfFinishedGoodsWorkInProgressAndStockInTrade;


  @Column(name = "ComprehensiveIncomeForThePeriod")
  Double comprehensiveIncomeForThePeriod;


  @Column(name = "ComprehensiveIncomeForThePeriodAttributableToOwnersOfParent")
  Double comprehensiveIncomeForThePeriodAttributableToOwnersOfParent;


  @Column(name = "ComprehensiveIncomeForThePeriodAttributableToOwnersOfParentN")
  Double comprehensiveIncomeForThePeriodAttributableToOwnersOfParentNonControllingInterests;


  @Column(name = "CostOfMaterialsConsumed")
  Double costOfMaterialsConsumed;


  @Column(name = "CurrentTax")
  Double currentTax;


  @Column(name = "DateOfEndOfFinancialYear")
  Date dateOfEndOfFinancialYear;


  @Column(name = "DateOfEndOfReportingPeriod")
  Date dateOfEndOfReportingPeriod;


  @Column(name = "DateOfStartOfFinancialYear")
  Date dateOfStartOfFinancialYear;


  @Column(name = "DateOfStartOfReportingPeriod")
  Date dateOfStartOfReportingPeriod;


  @Column(name = "DateOnWhichPriorIntimationOfTheMeetingForConsideringFinancia")
  Date dateOnWhichPriorIntimationOfTheMeetingForConsideringFinancialResultsWasInformedToTheExchange;


  @Column(name = "DeferredTax")
  Double deferredTax;


  @Column(name = "DepreciationDepletionAndAmortisationExpense")
  Double depreciationDepletionAndAmortisationExpense;


  @Column(name = "DescriptionOfOtherExpenses")
  Double descriptionOfOtherExpenses;


  @Column(name = "DescriptionOfPresentationCurrency")
  Double descriptionOfPresentationCurrency;


  @Column(name = "DescriptionOfSingleSegment")
  Double descriptionOfSingleSegment;


  @Column(name = "DilutedEarningsLossPerShareFromContinuingAndDiscontinuedOper")
  Double dilutedEarningsLossPerShareFromContinuingAndDiscontinuedOperations;


  @Column(name = "DilutedEarningsLossPerShareFromContinuingOperations")
  Double dilutedEarningsLossPerShareFromContinuingOperations;


  @Column(name = "DilutedEarningsLossPerShareFromDiscontinuedOperations")
  Double dilutedEarningsLossPerShareFromDiscontinuedOperations;


  @Column(name = "EmployeeBenefitExpense")
  Double employeeBenefitExpense;


  @Column(name = "ExceptionalItemsBeforeTax")
  Double exceptionalItemsBeforeTax;


  @Column(name = "Expenses")
  Double expenses;


  @Column(name = "FaceValueOfEquityShareCapital")
  Double faceValueOfEquityShareCapital;


  @Column(name = "FinanceCosts")
  Double financeCosts;


  @Column(name = "Income")
  Double income;


  @Column(name = "IsCompanyReportingMultisegmentOrSingleSegment")
  String isCompanyReportingMultisegmentOrSingleSegment;


  @Column(name = "LevelOfRoundingUsedInFinancialStatements")
  String levelOfRoundingUsedInFinancialStatements;


  @Column(name = "NatureOfReportStandaloneConsolidated")
  String natureOfReportStandaloneConsolidated;


  @Column(name = "NetMovementInRegulatoryDeferralAccountBalancesRelatedToProfi")
  Double netMovementInRegulatoryDeferralAccountBalancesRelatedToProfitOrLossAndTheRelatedDeferredTaxMovement;


  @Column(name = "OtherComprehensiveIncomeNetOfTaxes")
  Double otherComprehensiveIncomeNetOfTaxes;


  @Column(name = "OtherExpenses")
  Double otherExpenses;


  @Column(name = "OtherIncome")
  Double otherIncome;


  @Column(name = "PaidUpValueOfEquityShareCapital")
  Double paidUpValueOfEquityShareCapital;


  @Column(name = "ProfitBeforeExceptionalItemsAndTax")
  Double profitBeforeExceptionalItemsAndTax;


  @Column(name = "ProfitBeforeTax")
  Double profitBeforeTax;


  @Column(name = "ProfitLossForPeriod")
  Double profitLossForPeriod;


  @Column(name = "ProfitLossForPeriodFromContinuingOperations")
  Double profitLossForPeriodFromContinuingOperations;


  @Column(name = "ProfitLossFromDiscontinuedOperationsAfterTax")
  Double profitLossFromDiscontinuedOperationsAfterTax;


  @Column(name = "ProfitLossFromDiscontinuedOperationsBeforeTax")
  Double profitLossFromDiscontinuedOperationsBeforeTax;


  @Column(name = "PurchasesOfStockInTrade")
  Double purchasesOfStockInTrade;


  @Column(name = "ReportingQuarter")
  Double reportingQuarter;


  @Column(name = "RevenueFromOperations")
  Double revenueFromOperations;


  @Column(name = "ShareOfProfitLossOfAssociatesAndJointVenturesAccountedForUsi")
  Double shareOfProfitLossOfAssociatesAndJointVenturesAccountedForUsingEquityMethod;


  // @Column(name = "Symbol")
  // String symbol;


  @Column(name = "TaxExpense")
  Double taxExpense;


  @Column(name = "TaxExpenseOfDiscontinuedOperations")
  Double taxExpenseOfDiscontinuedOperations;


  @Column(name = "WhetherResultsAreAuditedOrUnaudited")
  String whetherResultsAreAuditedOrUnaudited;



}
