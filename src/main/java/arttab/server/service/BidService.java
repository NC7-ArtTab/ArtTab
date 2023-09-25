package arttab.server.service;

import arttab.server.dto.ArtDetailDto;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import java.util.List;

public interface BidService {

    List<Bid> list() throws Exception;

    // 작품 정보 조회
    ArtDetailDto findArtInfo(int artNo) throws Exception;

    // 특정 작품에 대한 입찰 정보 조회
    ArtDetailDto findBidInfo(int artNo) throws Exception;

    // 입찰하기
    void insertBid(Bid bid) throws Exception;

}
