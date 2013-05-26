package at.outdated.bitcoin.exchange.bitstamp;

import at.outdated.bitcoin.exchange.api.currency.Currency;
import at.outdated.bitcoin.exchange.api.jaxb.StringNumberAdapter;
import at.outdated.bitcoin.exchange.api.market.TickerValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ebirn
 * Date: 25.05.13
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BitstampTickerValue {

    // {"high": "129.94", "last": "128.48", "bid": "128.30", "volume": "12260.32110601", "low": "124.00", "ask": "128.48"}

    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number last;

    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number high;

    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number low;

    // what you need to pay for buying
    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number bid;

    // what you get for selling
    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number ask;

    @XmlElement @XmlJavaTypeAdapter(StringNumberAdapter.class)
    Number volume;

    Date timeStamp = new Date();

    public TickerValue getTickerValue() {

        TickerValue ticker = new TickerValue();
        ticker.setTimestamp(timeStamp);

        ticker.setLast(last.doubleValue());
        ticker.setHigh(high.doubleValue());
        ticker.setLow(low.doubleValue());

        ticker.setAsk((ask).doubleValue());
        ticker.setBid((bid).doubleValue());

        ticker.setVolume((volume).doubleValue());

        ticker.setCurrency(Currency.USD);

        return ticker;
    }
}