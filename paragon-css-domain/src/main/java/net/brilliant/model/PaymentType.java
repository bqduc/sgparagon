/**
 * 
 */
package net.brilliant.model;

/**
 * @author ducbq
 *
 */
public enum PaymentType {
  Cash, //nakit
  Cheque,  //cek
  PromissoryNote, //senet
  CreditCard, //Kredi kartı
  Instalment, //taksitli ödeme
  DebitCard,  // banka atm kartı
  GiftCheque, //hediye çeki
  Contribution, //katkı payı ödemesi
  BonusPay //kredi kartından puanla ödeme
}
