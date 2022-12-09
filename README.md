# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
2. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
3. 상점주인은 주문을 수락하거나 거절할 수 있다
4. 상점주인은 요리시작때와 완료 시점에 시스템에 상태를 입력한다
5. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
6. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
7. 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
8. 고객이 주문상태를 중간중간 조회한다
9. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
10. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
11. (추가) 고객은 요리를 먹은 뒤 리뷰를 남길 수 있다.
12. (추가) 고객이 리뷰를 남기면 상점주인에게 알림이 간다.


비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven


## Model
![msa](https://user-images.githubusercontent.com/80758607/206376850-4045670f-c8be-4531-a418-13b71d21c3d9.png)



요구사항을 커버하는지 검증

![기본 요구사항](https://user-images.githubusercontent.com/80758607/206606481-dadd8954-e7f4-4a55-8cce-617607e17efe.png)
1. 고객이 메뉴를 선택하여 주문한다.
2. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
3. 상점주인은 주문을 수락하거나 거절할 수 있다
4. 상점주인은 요리시작때와 완료 시점에 시스템에 상태를 입력한다
5. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
6. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
7. 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
8. 고객이 주문상태를 중간중간 조회한다
9. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
10. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
    
![추가 요구사항](https://user-images.githubusercontent.com/80758607/206606473-9759ec31-6dbc-4be7-8ec9-397580850070.png)


11. (추가) 고객은 요리를 먹은 뒤 리뷰를 남길 수 있다.
12. (추가) 고객이 리뷰를 남기면 상점주인에게 알림이 간다.

# 체크포인트
## 1. Saga(Pub/Sub)
orders로 post 요청을 보내면 OrderPlaced에서 pay에 있는 pay커맨드로 요청을 전달한다.(req/res : 동기)
그 후에 pay에서 PaymentApproved이벤트를 거쳐 store에 있는 receipt정책으로 이벤트를 전달한다.(Pub/Sub : 비동기)
아래는 orders post요청으로 3개의 테이블에 데이터가 들어간 것을 확인한 증적이다.

### 요청
![image]![saga 패턴1](https://user-images.githubusercontent.com/80758607/206377519-eb51d896-6ffd-45d6-a1a7-be69ef3ed860.png)


### 결과
![image]![saga 패턴2](https://user-images.githubusercontent.com/80758607/206377560-42a2faa5-15d8-4eec-8f1c-eca1cc9fd4fe.png)


## 2. CQRS 
![image]![CQRS8081](https://user-images.githubusercontent.com/80758607/206378157-1cab8840-0ddd-40ab-b8fa-e0b25687658f.png)

![image]![CQRS 8084](https://user-images.githubusercontent.com/80758607/206378185-f477644a-b930-4db2-a4c7-3cd0d3c98633.png)


## 3. Request / Response

![image]![화면 캡처 2022-12-07 190252](https://user-images.githubusercontent.com/80758607/206378256-3dffe258-acda-401d-8f15-b767e446fa45.png)


## 4. Gateway
![image]![게이트웨이](https://user-images.githubusercontent.com/80758607/206591733-d12be552-88c3-4d45-8a13-bc188b1169db.png)
