# 상점 서비스

상점서비스는 상점에서 관리하는 서비스이다.<br/>
상점에서는 가게 정보 등록 및 수정을 할 수 있다. <br/>

## 1. 서비스 가입

사업자는 먼저 사용자 등록을 해야 한다. <br/>
만약 사전에 등록이 된 사용자라면 이 작업은 진행하지 않고 로그인을 하면 된다. <br/>
서비스에 가입할 때 양식은 다음과 같다.

- 사업자 로그인 이메일
- 사업자 이름
- 비밀번호
- 비밀번호 확인

추후 간편로그인을 통해 일반 로그인을 대체할 예정.

### 요청 예제

```json
{
    "nickname": "seunggu",
    "email": "leesg107@naver.com",
    "password": "1234",
    "confirmPassword": "1234"
}
```

### 실패 시

```json
{
    "success": false,
    "response": null,
    "message": "이미 존재하는 계정입니다.",
    "status": 400
}
```

### 성공 시

```json
{
    "accountId": "d372c3d3-d0c4-4ba1-9caa-5a64e7030d25",
    "nickname": "seunggu",
    "email": "leesg107@naver.com",
    "accountStatus": "NORMAL",
    "accountKind": null
}
```

## 2. 상점 등록 신청

사업주는 상점 신청을 통해 가입을 할 수 있다.<br/>
가입 신청을 하게 되면 관리자가 승인을 할 때까지 대기 상태에 머물게 되며, 거절을 하게 되면 상점을 이용하지 못하게 되고 승인이 된 이후에 가게에 대한 상세 정보를 입력할 수 있다.

- 사업자 등록번호
- 프랜차이즈 식별자 ( 선택 )
- 상점 이름
- 상점 게시 일자 ( 영업 개시일 )
- 상점 주소

### 요청 정보

```json
{
    "bizNo": "120-81-47521",
    "storeUserId": "fb2330da-c492-4ea8-8e7a-5b64ab4770cf",
    "storeType": "SOLE_PROPRIETOR",
    "storeName": "고기리 막국수",
    "address": {
        "zonecode": "16800",
        "address": "경기 용인시 수지구 이종무로 157",
        "addressEnglish": "157, Leejongmu-ro, Suji-gu, Yongin-si, Gyeonggi-do, Korea",
        "addressType": "R",
        "bcode": "4146510400",
        "bname": "고기동",
        "bnameEnglish": "Gogi-dong",
        "bname1": "",
        "bname1English": "",
        "bname2": "고기동",
        "bname2English": "Gogi-dong",
        "sido": "경기",
        "sidoEnglish": "Gyeonggi-do",
        "sigungu": "용인시 수지구",
        "sigunguEnglish": "Suji-gu Yongin-si",
        "sigunguCode": "41465",
        "userLanguageType": "K",
        "query": "경기 용인시 수지구 이종무로 157",
        "buildingName": "",
        "buildingCode": "4146510400105930004000001",
        "apartment": "N",
        "jibunAddress": "경기 용인시 수지구 고기동 593-4",
        "jibunAddressEnglish": "593-4, Gogi-dong, Suji-gu, Yongin-si, Gyeonggi-do, Korea",
        "roadAddress": "경기 용인시 수지구 이종무로 157",
        "roadAddressEnglish": "157, Leejongmu-ro, Suji-gu, Yongin-si, Gyeonggi-do, Korea",
        "autoRoadAddress": "",
        "autoRoadAddressEnglish": "",
        "autoJibunAddress": "",
        "autoJibunAddressEnglish": "",
        "userSelectedType": "R",
        "noSelected": "N",
        "hname": "",
        "roadnameCode": "3205017",
        "roadname": "이종무로",
        "roadnameEnglish": "Leejongmu-ro"
    }
}
```

### 성공 시 응답

```json
{
    "success": true,
    "response": {
        "store": {
            "storeId": "1ceb4c6c-9a99-4e2f-bd63-5165f6cdf20e",
            "bizNo": "424-88-02352",
            "address": {
                "zonecode": "16800",
                "address": "경기 용인시 수지구 이종무로 157",
                "addressEnglish": "157, Leejongmu-ro, Suji-gu, Yongin-si, Gyeonggi-do, Korea",
                "addressType": "R",
                "userSelectedType": "R",
                "roadAddress": "경기 용인시 수지구 이종무로 157",
                "jibunAddress": "경기 용인시 수지구 고기동 593-4",
                "buildingCode": "4146510400105930004000001",
                "buildingName": "",
                "apartment": "N",
                "sido": "경기",
                "sigungu": "용인시 수지구",
                "sigunguCode": "41465",
                "roadnameCode": "3205017",
                "bcode": "4146510400",
                "bname": "고기동"
            },
            "franchiseName": null,
            "storeType": "개인 사업자",
            "storeName": "한신포차 죽전점",
            "storeStatus": "대기",
            "startedAt": "2024-09-28"
        }
    },
    "message": "처리되었습니다.",
    "status": 200
}
```

### 실패시 응답

```json
{
    "success": false,
    "response": null,
    "message": "이미 등록된 상점입니다.",
    "status": 400
}
```

### 사업자 중복 등록 응답

```json
    {
        "success": false,
        "response": null,
        "message": "이미 등록된 사업자입니다.",
        "status": 400
    }
    ```

## 3. 상점 정보 등록

상점에 대한 승인이 되면 상점 정보를 등록해야 하며, 정보가 등록되지 않은 상점은 게시를 시작할 수 없다.
등록이 필요한 정보는 다음과 같다.

- 최소 주문 금액
- 영업 시간
- 휴식 시간(선택)
- 휴무일 (선택)
- 원산지 정보

