package arttab.server.dao;

import arttab.server.dto.PayDto;
import arttab.server.vo.Art;
import arttab.server.vo.Pay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
  // Pay 객체를 삽입하는 메서드
  void insertPay(Pay pay);

  // memberNo와 artNo를 기반으로 Pay 객체를 조회하는 메서드
  Pay findAll(int memberNo, int artNo);

  Pay findAll(int artNo);

  Art findArt(int artNo);

  PayDto payDetail(int memberNo, int artNo);
}
