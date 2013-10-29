package at.outdated.bitcoin.exchange.kraken;

import at.outdated.bitcoin.exchange.api.ExchangeApiClient;
import at.outdated.bitcoin.exchange.api.Market;
import at.outdated.bitcoin.exchange.api.currency.Currency;
import at.outdated.bitcoin.exchange.api.market.AssetPair;
import at.outdated.bitcoin.exchange.api.market.transfer.TransferMethod;
import at.outdated.bitcoin.exchange.api.market.transfer.TransferType;

/**
 * Created with IntelliJ IDEA.
 * User: ebirn
 * Date: 17.09.13
 * Time: 18:28
 * To change this template use File | Settings | File Templates.
 */
public class KrakenMarket extends Market {

    public KrakenMarket() {
        super("kraken", "http://www.kraken.com", "Kraken", Currency.EUR);

        addWithdrawal(new TransferMethod(Currency.BTC, TransferType.VIRTUAL, null));
        addWithdrawal(new TransferMethod(Currency.LTC, TransferType.VIRTUAL, null));
        addWithdrawal(new TransferMethod(Currency.XRP, TransferType.VIRTUAL, null));

        addWithdrawal(new TransferMethod(Currency.EUR, TransferType.BANK, null));
        addWithdrawal(new TransferMethod(Currency.USD, TransferType.BANK, null));


        addDeposit(new TransferMethod(Currency.BTC, TransferType.VIRTUAL, null));
        addDeposit(new TransferMethod(Currency.LTC, TransferType.VIRTUAL, null));
        addDeposit(new TransferMethod(Currency.XRP, TransferType.VIRTUAL, null));

        addDeposit(new TransferMethod(Currency.EUR, TransferType.BANK, null));
        addDeposit(new TransferMethod(Currency.USD, TransferType.BANK, null));

        addAsset(Currency.BTC, Currency.EUR);
        addAsset(Currency.BTC, Currency.USD);
        addAsset(Currency.BTC, Currency.XRP);
        addAsset(Currency.USD, Currency.XRP);
        addAsset(Currency.EUR, Currency.XRP);
        addAsset(Currency.BTC, Currency.LTC);
        addAsset(Currency.LTC, Currency.USD);
        addAsset(Currency.LTC, Currency.EUR);
        addAsset(Currency.LTC, Currency.XRP);
    }

    @Override
    public ExchangeApiClient getApiClient() {
        return new KrakenClient(this);
    }

}
