# Frame-Backend-Core

## Explain 

Frame 메인 서비스 백엔드 어플리케이션 입니다.

## Git commit Convention

### 1. 기본적으로 commit message는 아래와 같이 제목, 내용으로 구성한다.

```
[{type}] {issue(pr) number} {content}
```

### 2. commit type

- CREATE: 새 파일 생성
- ADD : 파일에 기능 추가
- FIX: 버그 수정
- DOCS: 문서 수정
- REFACTOR: 코드 리팩토링
- TEST: 테스트 코드, 리팩토링 테스트 코드 추가

### 3. content

- 내용은 60자를 넘기지 않는다.
- 무엇을 했는지를 기록한다.
- 과거시제를 사용하지 않고 명령어로 작성한다.
  
### 4. issue(pr) number

- 이슈 또는 Pr에 관한 번호를 적는다
- 예시 : #1
## Skills

### 언어(Language)

- Java

### 프레임워크(Framework)

- Spring Boot

### Gitflow

1. 자신의 Pull Request는 스스로 merge 합니다.
2. 머지가 완료된 feature 브랜치는 머지와 동시에 삭제합니다.

- main(master) : 제품으로 출시될 수 있는 브랜치
- develop : 다음 출시 버전을 개발하는 브랜치
- feature : 기능을 개발하는 브랜치
- release : 이번 출시 버전을 준비하는 브랜치
- hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치

### Branch Naming Convention

```
[관련 도메인] 또는 [관련 도메인]-[제작 상세]

[관련 기능] 또는 [제작 상세]에서 띄어쓰기는 '_(언더바)'로 구분한다.

ex) login-ui
ex) login-server_communication
ex) login-middleware
ex) login-plugin
```

## Build Setup

```bash
# gradle build
$ ./gradlew build

# server run
$ java -jar {file_name}.jar
```
