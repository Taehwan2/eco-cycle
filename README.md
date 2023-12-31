### eco-cycle
## 프로젝트 
### 개요
- "지속가능한 생활 거래 앱"은 당근 마켓 스타일의 사용자 친화적인 인터페이스로 중고, 리사이클링, 업사이클링 상품을 거래할 수 있는 플랫폼을 제공합니다.
- 이 앱은 합리적인 가격으로 고품질의 재활용 상품을 제공함으로써 소비자의 지속 가능한 구매를 촉진하고, 또한 쓰레기 줄이기와 자원 절약에 기여합니다.
- 이 서비스는 사용자가 구매와 판매를 통해 직접 환경 보호에 참여하게 하고, 동시에 정부의 지속가능한 소비 및 자원 관리 정책을 지원하는 데이터를 수집하고 제공합니다.

### 배경

## 개발인원(Member)
|장태환|BE 팀원| 백앤드 개발|
|김덕륜|FE 팀원| 프론트 앱 개발|


## 프로젝트 기술 스택
### Environments
<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

### Development Stack
#### BackEnd

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"><img src="https://img.shields.io/badge/ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/mongodb-47A248?style=for-the-badge&logo=mongodb&logoColor=white">

#### FrontEnd
<img src="https://img.shields.io/badge/flutter-02569B?style=for-the-badge&logo=flutter&logoColor=white">

### Communicatoin
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"><img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white">

## 프로젝트 진행 과정
- 피그마를 이용해 목업 디자인 스케치와 메인 디자인 
- 페이지 별 역할 분담
- 기능 구현
- 배포 테스트 및 기능 수정
- 배포

## 프로젝트 구현 내용

  <img width="364" alt="스크린샷 2023-08-22 오후 3 50 59" src="https://github.com/Taehwan2/eco-cycle/assets/97010824/3fc5e77f-4edc-44e9-b318-c14b6ece3e4b">

- 사용자들이 올린 자원 정보들을 페이징 기법을 이용하여 보내주는 기능

  <img width="365" alt="스크린샷 2023-08-22 오후 3 51 17" src="https://github.com/Taehwan2/eco-cycle/assets/97010824/d6dcea06-d006-4830-a5a8-025a7e229ff4">

- 사진을 찍어서 자원을 등록하면, 사진은 파일시스템에 저장하고 데이터베이스 에는 파일의 경로를 저장하여, 나머지 데이터는 mongodb에 저장하는 기능 구현
  
<img width="364" alt="스크린샷 2023-08-22 오후 3 51 33" src="https://github.com/Taehwan2/eco-cycle/assets/97010824/63396e0a-3f6f-44b0-9f25-e5720ad16b1d">

- 판매 테이블에서 사용자와 대화를 하거나, 다른사람의 판매테이블을 볼 수 있는 기능

### BE
#### 장태환
## 프로젝트 한계 및 개선 방안
1. 수많은 사람들의 구매, 판매 테이블의 정보를 담으려면 mysql에서는 트래픽이 많이 생김 -> 사진은 파일 시스템에 저장하고, 수많은 데이터는 mongoDB에 담는 것으로 해결
2. 프론트와 API 문서에 대해서 충돌이 자주 발생 -> 회의를 통해서 API 공식문서를 먼저 만들고 프로젝트를 진행


  

