package org.knowm.xchange.okcoin;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.FundingRecord.Status;
import org.knowm.xchange.dto.account.FundingRecord.Type;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.okcoin.v3.dto.account.OkexDepositRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexFundingAccountRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexSpotAccountRecord;
import org.knowm.xchange.okcoin.v3.dto.account.OkexWithdrawalRecord;
import org.knowm.xchange.okcoin.v3.dto.marketdata.OkexTokenPairInformation;
import org.knowm.xchange.okcoin.v3.dto.trade.OkexOpenOrder;
import org.knowm.xchange.okcoin.v3.dto.trade.Side;

public class OkexAdaptersV3 {

  public static Balance convert(OkexFundingAccountRecord rec) {
    return new Balance.Builder()
        .currency(Currency.getInstance(rec.getCurrency()))
        .available(rec.getAvailable())
        .frozen(rec.getBalance().subtract(rec.getAvailable()))
        .total(rec.getBalance())
        .build();
  }

  public static Balance convert(OkexSpotAccountRecord rec) {
    return new Balance.Builder()
        .currency(Currency.getInstance(rec.getCurrency()))
        .available(rec.getAvailable())
        .frozen(rec.getBalance().subtract(rec.getAvailable()))
        .total(rec.getBalance())
        .build();
  }

  public static String toInstrument(CurrencyPair pair) {
    return pair == null ? null : pair.base.getCurrencyCode() + "-" + pair.counter.getCurrencyCode();
  }

  public static CurrencyPair toPair(String instrument) {
    return instrument == null ? null : new CurrencyPair(instrument.replace('-', '/'));
  }

  public static Ticker convert(OkexTokenPairInformation i) {
    return new Ticker.Builder()
        .currencyPair(toPair(i.getInstrumentId()))
        .last(i.getLast())
        .bid(i.getBid())
        .ask(i.getAsk())
        .volume(i.getBaseVolume24h())
        .quoteVolume(i.getQuoteVolume24h())
        .timestamp(i.getTimestamp())
        .build();
  }

  public static LimitOrder convert(OkexOpenOrder o) {
    return new LimitOrder.Builder(
            o.getSide() == Side.sell ? OrderType.ASK : OrderType.BID, toPair(o.getInstrumentId()))
        .id(o.getOrderId())
        .limitPrice(o.getPrice())
        .originalAmount(o.getSize())
        .timestamp(o.getCreatedAt())
        .build();
  }

  public static FundingRecord adaptFundingRecord(OkexWithdrawalRecord r) {
    return new FundingRecord.Builder()
        .setAddress(r.getTo())
        .setAmount(r.getAmount())
        .setCurrency(Currency.getInstance(r.getCurrency()))
        .setDate(r.getTimestamp())
        .setInternalId(r.getWithdrawalId())
        .setStatus(convertWithdrawalStatus(r.getStatus()))
        .setBlockchainTransactionHash(r.getTxid())
        .setType(Type.WITHDRAWAL)
        .build();
  }

  /**
   * -3:pending cancel; -2: cancelled; -1: failed; 0 :pending; 1 :sending; 2:sent; 3 :email
   * confirmation; 4 :manual confirmation; 5:awaiting identity confirmation
   */
  private static Status convertWithdrawalStatus(String status) {
    switch (status) {
      case "-3":
      case "-2":
        return Status.CANCELLED;
      case "-1":
        return Status.FAILED;
      case "0":
      case "1":
      case "3":
      case "4":
      case "5":
        return Status.PROCESSING;
      case "2":
        return Status.COMPLETE;
      default:
        throw new ExchangeException("Unknown withdrawal status: " + status);
    }
  }

  public static FundingRecord adaptFundingRecord(OkexDepositRecord r) {
    return new FundingRecord.Builder()
        .setAddress(r.getTo())
        .setAmount(r.getAmount())
        .setCurrency(Currency.getInstance(r.getCurrency()))
        .setDate(r.getTimestamp())
        .setStatus(convertDepositStatus(r.getStatus()))
        .setBlockchainTransactionHash(r.getTxid())
        .setType(Type.DEPOSIT)
        .build();
  }
  /**
   * The status of deposits (0: waiting for confirmation; 1: confirmation account; 2: recharge
   * success);
   */
  private static Status convertDepositStatus(String status) {
    switch (status) {
      case "0":
      case "1":
        return Status.PROCESSING;
      case "2":
        return Status.COMPLETE;
      default:
        throw new ExchangeException("Unknown withdrawal status: " + status);
    }
  }
}
