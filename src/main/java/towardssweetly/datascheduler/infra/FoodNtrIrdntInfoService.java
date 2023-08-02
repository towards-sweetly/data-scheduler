package towardssweetly.datascheduler.infra;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import towardssweetly.datascheduler.infra.dto.FoodNtrIrdntInfoResponse;

/**
 * <a href="https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15057436">식품의약품안전처_식품 영양성분 정보</a>에서 데이터를 추출한다.
 * <h3>요청</h3>
 * API를 요청할 때, 전달해야할 파라미터는 페이지 번호, 한 페이지 결과 수, 인증키(공공데이터포털에서 발급받은 인증키), 데이터 포맷(응답데이터 형식(xml/json))이다.
 * <h3>응답</h3>
 * API 응답 결과에는 결과코드, 결과메시지, 한 페이지 결과수, 페이지 번호, 전체 결과 수, 식품이름, 1회제공량 (g), 열량 (kcal), 탄수화물 (g),
 * 단백질 (g), 지방 (g), 당류 (g), 나트륨 (mg), 콜레스테롤 (mg), 포화지방산 (g), 트랜스지방산 (g) 정보가 포함된다.
 * <h3>주의할 점</h3>
 * 응답으로 반환되는 파라미터 필드명이 <strong>NUTR_CONT*</strong>로 표기되어 혼동할 수 있으니 주의하자.
 */
@Service
public class FoodNtrIrdntInfoService {
    private static final String URL = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1";
    private final RestTemplate restTemplate;

    public FoodNtrIrdntInfoService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public FoodNtrIrdntInfoResponse getFoodNtrIrdntInfoResponse(int pageNo, int numOfRows, String type, String serviceKey) {
        final var uri = UriComponentsBuilder.fromUriString(URL)
                .queryParam("pageNo", pageNo)
                .queryParam("serviceKey", serviceKey)
                .queryParam("numOfRows", numOfRows)
                .queryParam("type", type)
                .encode()
                .build()
                .toUri();

        final var requestEntity = RequestEntity
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        return restTemplate.exchange(requestEntity, FoodNtrIrdntInfoResponse.class)
                .getBody();
    }
}
