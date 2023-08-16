#eco-cycle
## 프로젝트 
### 개요
- 사용자가 자신의 자산과 입출금을 관리할 수 있는 서비스 ‘💰MoneyMade‘
- 내가 가지고있는 자산(개인계좌, 투자계좌)을 한눈에 보는 서비스 구축
- 내가 사용한 소비내역 입력을 통한 지출계획을 한눈에 보는 서비스 구축

### 배경

## 개발인원(Member)
|이름|역할|담당|이름|역할|담당|
|--|--|--|
|장태환|BE 팀원| 기능 구현|


## 프로젝트 기술 스택
### Environments
<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

### Development Stack
#### BackEnd

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"><img src="https://img.shields.io/badge/ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">


#### FrontEnd
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=white">

### Communicatoin
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"><img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white">

## 프로젝트 진행 과정
- 피그마를 이용해 목업 디자인 스케치와 메인 디자인 
- 페이지 별 역할 분담
- 기능 구현
- 배포 테스트 및 기능 수정
- 배포

## 프로젝트 구현 내용
  
### BE
#### 장태환
## 프로젝트 한계 및 개선 방안
### FE
#### 한계
- 프로젝트 초기 단계에서 웹과 앱을 동시에 구현하기 위해 PWA 셋팅을 하였지만 후반으로 갈 수록 PWA에 관해서는 다뤄보지 못함.
프로젝트를 반응형으로 만들면 간단하게 해결될 문제일 줄 알았는데 반응형을 좀 더 정교하게 만들었어야 했다는 생각이 듦.
- 메인페이지 섹션별 스크롤 이벤트를 구현 하였는데 마우스 휠로는 구현이 잘 됬지만 트랙패드의 경우 버벅거리는 에러를 발견.
- 일일 페이지에서 일이동 여러번 클릭해야 원하는 날짜로 이동할 수 있음
- 현금 자산을 등록해야, 일일 소비내역을 입력할 수 있도록 알림창을 띄워놓았는데, 알림창이 아닌 아예 논클릭으로 실행불가능하도록 구현해야 함

#### 개선 방안
- 모바일까지 생각한 반응형 웹의 경우 최소 크기에서부터 컴포넌트들을 배치 하면서 점점 페이지 크기를 키워가면서 구현.
- 일일 페이지에서 단순히 일이동 버튼을 눌러서 +1,-1 로 이동하는 것이 아니라, 특정 날짜를 입력할 수 있다면, 사용자가 편리할 것이라고 생각함.
- 기존 현금자산보다 더 높은 금액을 input 창에 입력하면, 등록버튼을 눌러도 화면이 넘어가지 않도록 구현.
  
### BE
