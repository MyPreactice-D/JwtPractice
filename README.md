### 1. 회원가입
![image](https://github.com/user-attachments/assets/f6f208fb-a464-42e6-99c2-f690153ac446)
1. 실습 코드에서는 회원가입에서도 토큰을 생성하여 return하는 것을 보여줬지만, 회원가입에서 굳이 token을 생성해야하는 의문이 들어서 저는 token 생성을 제외하고 등록된 회원id, 이메일을 보여주는 형식으로 했습니다.

### 2. 로그인
![image](https://github.com/user-attachments/assets/263c10c9-d29a-4caf-ac06-7fc13ea8313a)
1. 로그인을 하면 발급된 토큰이 보이게끔 했습니다.

### 3. 회원 조회
![image](https://github.com/user-attachments/assets/cab3268e-1ad9-4a9e-9d29-19193e2815d6)
1. 발급된 토큰을 넣어야지 조회가 가능합니다.

### 4. 회원 비밀번호 변경
![image](https://github.com/user-attachments/assets/75113d4b-e2fe-4117-b291-b80024b6dfc5)
![image](https://github.com/user-attachments/assets/76765b9b-0470-4de4-a5ed-e98d0f276240)

1. 기존 비밀번호는 DB에 저장된 비밀번호와 동일해야지 통과
2. 새 비밀번호는 기존 비밀번호를 중복해서 사용할 수 없음
3. 발급된 토큰 없이는 실행 불가

