package arttab.server.service;

import arttab.server.vo.Pay;

import java.util.List;

public interface MyPayService {
    List<Pay> getPurchaseHistory(int memberNo);
}
