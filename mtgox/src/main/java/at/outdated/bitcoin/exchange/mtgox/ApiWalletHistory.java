package at.outdated.bitcoin.exchange.mtgox;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: ebirn
 * Date: 10.05.13
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class ApiWalletHistory extends ApiResponse {


    @XmlElement(name="data")
    private MtGoxWalletHistory walletHistory;

    public MtGoxWalletHistory getData() {
        return walletHistory;
    }
}
