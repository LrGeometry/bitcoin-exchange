package at.outdated.bitcoin.exchange.bitkonan;

import at.outdated.bitcoin.exchange.api.client.ExchangeClient;
import at.outdated.bitcoin.exchange.api.currency.Currency;
import at.outdated.bitcoin.exchange.api.market.Market;
import at.outdated.bitcoin.exchange.api.market.transfer.TransferMethod;
import at.outdated.bitcoin.exchange.api.market.transfer.TransferType;

/**
 * Created with IntelliJ IDEA.
 * User: ebirn
 * Date: 26.05.13
 * Time: 23:41
 * To change this template use File | Settings | File Templates.
 */
public class BitkonanMarket extends Market {


    public BitkonanMarket() {
        super("bitkonan", "http://bitkonan.com", "BitKonan");

        addDeposit(new TransferMethod(Currency.BTC, TransferType.VIRTUAL));
        addDeposit(new TransferMethod(Currency.LTC, TransferType.VIRTUAL));
        addDeposit(new TransferMethod(Currency.USD, TransferType.BANK));

        addWithdrawal(new TransferMethod(Currency.BTC, TransferType.VIRTUAL));
        addWithdrawal(new TransferMethod(Currency.LTC, TransferType.VIRTUAL));
        addWithdrawal(new TransferMethod(Currency.USD, TransferType.BANK));

        addAsset(Currency.BTC, Currency.USD);
        addAsset(Currency.LTC, Currency.USD);
    }

    @Override
    public ExchangeClient createClient() {
        return new BitkonanApiClient(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

}
