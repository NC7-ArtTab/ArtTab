package arttab.server.service;

import arttab.server.dao.PayDao;
import arttab.server.dto.PayDto;
import arttab.server.vo.Art;
import arttab.server.vo.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DefaultPayService implements PayService {

  private final PayDao payDao;

  @Autowired
  public DefaultPayService(PayDao payDao) {
    this.payDao = payDao;
  }

  @Override
  public void add(Pay pay) throws Exception {
    payDao.insertPay(pay);
  }

  @Override
  public Pay list(int memberNo, int artNo) throws Exception {
    return payDao.findAll(memberNo, artNo);
  }

  @Override
  public Pay list(int artNo) throws Exception {
    return payDao.findAll(artNo);
  }

  @Override
  public Art payArtList(int artNo) throws Exception {
    return payDao.findArt(artNo);
  }

  @Override
  public PayDto payList(int memberNo, int artNo) throws Exception {
    return payDao.payDetail(memberNo, artNo);
  }

}
