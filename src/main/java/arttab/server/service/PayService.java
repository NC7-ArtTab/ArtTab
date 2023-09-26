package arttab.server.service;

import arttab.server.dto.PayDto;
import arttab.server.vo.Art;
import arttab.server.vo.Pay;

public interface PayService {
  void add(Pay pay) throws Exception;

  Pay list(int memberNo, int artNo) throws Exception;

  Art payArtList(int artNo) throws Exception;

  PayDto payList(int memberNo, int artNo) throws Exception;
}
