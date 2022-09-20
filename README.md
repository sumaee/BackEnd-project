# BackEnd 프로젝트

---

## 💪프로젝트 목표

---

- Java의 BackEnd 기술인 Servlet/JSP를 이해하고 이를 활용하여 웹 서버를 구축할 수 있다.
- MVC 구조를 이해하고 이를 활용하여 프로그램을 작성할 수 있다.
- FrontEnd 관통프로젝트를 참고하여 화면과 연계가 필요한 부분의 BackEnd를 완성한다.

---

---

## 💻 요구 사항

---

### ⁉️ 기본 기능

---

- 다양한 운동영상정보와 영상의 리뷰를 위한 백앤드 기능을 구현한다.

- 메인페이지 백앤드 기능 구현

---

### ⁉️ 추가 기능

---

- 사이트의 다양한 기능을 사용하기 위해서 회원가입, 로그인 페이지를 제공한다.
    - 회원가입 페이지
    - 로그인 페이지

---

### ⁉️ 심화 기능

---

- 심화 기능
관심있는 영상에 대한 찜 관리 페이지와 회원간 팔로우 페이지를 제공한다.
회원은 다른 회원을 팔로우 할 수 있다.
    - 회원간 팔로우 관리 페이지
    - 회원의 운동영상 찜 관리 페이지

---

---

## ‼️기능 구현 화면 & 상세 설명

---

### ❗시작화면

---

- 조회수가 가장 높은 3개의 영상을 볼 수 있음
    
   ![Untitled](https://user-images.githubusercontent.com/109265165/191261330-e9cae33f-424f-42ff-a263-d986a88dd094.png)

    
- 부위별 추천 영상을 볼 수 있음
    
   ![Untitled 1](https://user-images.githubusercontent.com/109265165/191261345-ee02097b-0dc6-45bc-978e-fa2b8f4a115b.png)

    
- 로그인 여부에 따라 로그인 / 회원가입 버튼과 로그아웃 버튼이 다르게 나타남.
    
    ![Untitled 2](https://user-images.githubusercontent.com/109265165/191261368-351e9fbf-1020-4b80-9bac-c94877ca1fc7.png)
    
    ![Untitled 3](https://user-images.githubusercontent.com/109265165/191261370-9900a1fa-c3e3-417c-80d2-4cfa2df1e284.png)
    
- 검색창을 통해 찾으려는 운동영상을 검색할 수 있음
    
    ![Untitled 34](https://user-images.githubusercontent.com/109265165/191262809-17bb9f18-e2fc-470b-93cd-b372b38c2d27.png)
    
    ![Untitled 35](https://user-images.githubusercontent.com/109265165/191262990-b37522ec-c4db-467a-a52a-16f5659d1249.png)

- 찾는 결과가 없을 때 화면
    
    ![Untitled 36](https://user-images.githubusercontent.com/109265165/191263051-d66d49d4-2c09-4ef7-b65f-8b98724736aa.png)

    ![Untitled 37](https://user-images.githubusercontent.com/109265165/191263067-98167e71-afc8-4b0e-954b-c0d11eb60ea3.png)

- 빈칸으로 검색하려 할 때 경고창
    
    ![Untitled 38](https://user-images.githubusercontent.com/109265165/191263138-8036aec7-cd25-44d8-804c-1e25bc3c0081.png)


---

❗로그인 화면

---

- 로그인 창
    
	![Untitled 4](https://user-images.githubusercontent.com/109265165/191261375-0390b20f-9786-4b3b-bcca-f8d3f8569622.png)
    
- 없는 정보로 로그인 시 경고창 후 로그인 창으로 다시 이동.
    
![Untitled 5](https://user-images.githubusercontent.com/109265165/191261386-2b34a09c-9172-4d2f-a690-83e0d8603c09.png)
    
- 빈칸으로 로그인 시 경고창
    
![Untitled 6](https://user-images.githubusercontent.com/109265165/191261389-d92e6116-221d-40eb-b9e1-73a53ffad164.png)
    
- 로그인 성공 시 “로그인 성공” 알림을 띄운 후 메인 화면으로 전환
    
![Untitled 7](https://user-images.githubusercontent.com/109265165/191261390-65539779-b6bb-4165-b12b-293071d5266d.png)
    

---

❗회원가입 화면

---

- 회원가입 화면
    
![Untitled 8](https://user-images.githubusercontent.com/109265165/191261384-4c5a2987-9d4d-4397-9363-c76214c47f6e.png)
    
- 빈칸으로 회원가입시 경고창
    
![Untitled 9](https://user-images.githubusercontent.com/109265165/191261515-a2e2fcdb-50f7-4e8e-9adc-5bf1a92afe78.png)
    
- 회원가입 완료 시 “회원가입 성공” 알림을 띄운 후 로그인 화면으로 전환
    
![Untitled 10](https://user-images.githubusercontent.com/109265165/191261518-cfa58a70-85cb-40d9-b9a3-0ed78a43be5b.png)
    

---

❗영상 상세 화면

---

- 운동영상, 조회수, 리뷰들을 볼 수 있음
    
![Untitled 11](https://user-images.githubusercontent.com/109265165/191261521-726c818b-9608-4cd1-9dd5-0a6832458f08.png)
    
- 해당 페이지에 접근할 때마다 조회수가 오름.
    
![Untitled 12](https://user-images.githubusercontent.com/109265165/191261532-16d7ab4c-ce6c-4b71-abd7-b21213ac5d57.png)
    
- 찜하기 버튼을 통해 찜 목록에 추가할 수 있음.(유저 별 찜 목록 구현)
    
![Untitled 13](https://user-images.githubusercontent.com/109265165/191261534-52d5c4dc-7e7e-4840-ba45-4199ccb9223c.png)
    
![Untitled 14](https://user-images.githubusercontent.com/109265165/191261535-17757699-edb6-4a52-935d-ecd6a47c6a58.png)
    
- 이미 찜한 영상의 경우 이미 찜한 영상이라는 것을 알려줌.
    
![Untitled 15](https://user-images.githubusercontent.com/109265165/191261541-4ee6268c-129e-439b-97fb-766816abc496.png)
    
- 리뷰등록 버튼을 통해 리뷰를 등록할 수 있음.
    
![Untitled 16](https://user-images.githubusercontent.com/109265165/191261545-f0979457-56b4-432d-a89b-422908d88b62.png)
    
![Untitled 17](https://user-images.githubusercontent.com/109265165/191261549-e81f28ea-8f99-455d-9793-6b73f9bea91a.png)
    
![Untitled 18](https://user-images.githubusercontent.com/109265165/191261439-8b67514f-49ca-4f0a-9f4b-319673e19bb7.png)
    
- 리뷰의 제목을 클릭하면 리뷰의 상세 내용을 볼 수 있음.
    
![Untitled 19](https://user-images.githubusercontent.com/109265165/191261442-fd4caee8-a5cf-4727-a9e4-9ab508f3dd8d.png)
    
- 리뷰 작성자만 수정, 삭제 버튼이 로딩됨.
- 수정 버튼을 통해 리뷰를 수정할 수 있음.
    
![Untitled 20](https://user-images.githubusercontent.com/109265165/191261447-8174ae60-c73c-4c72-89ad-8efb1270525f.png)
    
- 삭제 버튼을 통해 리뷰를 삭제할 수 있음.
    
![Untitled 21](https://user-images.githubusercontent.com/109265165/191261451-36a85c5e-50db-4413-bb3c-1c5cda585b2b.png)
    
![Untitled 22](https://user-images.githubusercontent.com/109265165/191261455-c66321ec-c61f-42c7-b8c0-52d1daa5994f.png)
    
- 로그인이 되어있고 리뷰 작성자가 아니면 팔로우 버튼이 로딩됨.
    
![Untitled 23](https://user-images.githubusercontent.com/109265165/191261459-0c23a710-ebb9-4237-a99b-ac409426acf4.png)
    
- 팔로우 버튼을 통해 팔로우 목록에 추가할 수 있음.

---

❗팔로우 목록 화면

---

- 유저별 팔로우 목록 구현
- 로그인이 되어있고 자신이 쓴 리뷰가 아니면 팔로우 버튼이 활성화된다.
    
![Untitled 24](https://user-images.githubusercontent.com/109265165/191261462-9cc495bd-207a-4433-b277-9995e8a33f68.png)
    
- 팔로우 버튼을 통해 유저 팔로우 가능.
    
![Untitled 25](https://user-images.githubusercontent.com/109265165/191261465-5a11758d-38ce-4b52-b8a5-97006226cb39.png)
    
- 팔로우 목록 페이지에 들어가면 팔로우에 들어간 것을 확인할 수 있다.
    
![Untitled 26](https://user-images.githubusercontent.com/109265165/191261469-e8d0db08-19c8-4f85-82ab-ffc477c54870.png)
    
- 해당 아이디로 접속하면 팔로워에 아이디가 추가된 것을 확인할 수 있다.
    
![Untitled 27](https://user-images.githubusercontent.com/109265165/191261472-0340ceaf-5171-47cf-b731-a56d50f03977.png)
    
- 해당 사진에서 팔로잉 목록을 삭제하면 해당 유저의 팔로워에서 삭제가 되고, 팔로워 목록을 삭제하면 해당 유저의 팔로잉에서 삭제된다.
    
![Untitled 28](https://user-images.githubusercontent.com/109265165/191261476-cec433a5-4fdf-4519-ae21-f3d46f2478fc.png)
    

---

❗찜 목록 화면

---

- 유저별 찜 목록을 구현하였다.
- 로그인을 하지 않고 찜하기 버튼을 클릭하면 알림창과 함께 로그인 페이지로 이동한다.
    
![Untitled 29](https://user-images.githubusercontent.com/109265165/191261481-8c8677df-da2f-477e-b5ca-36b29e0965c7.png)
    
- 로그인을 한 상태로 찜하기 버튼을 누르면 찜 목록에 추가된다.
    
![Untitled 30](https://user-images.githubusercontent.com/109265165/191261483-fc598a94-c48d-48e4-9874-818354e8836a.png)
    
- 찜 목폭 페이지에서 찜한 영상들을 확인할 수 있고, 삭제 버튼을 통해 찜 목록에서 삭제가 가능하다.
    
![Untitled 31](https://user-images.githubusercontent.com/109265165/191261491-379c7452-b9cb-4203-bb58-db6b51c4c305.png)
    
- 로그아웃을 한 뒤 다른 아이디로 로그인을 하면 찜 목록이 해당 유저의 찜 목록으로 변경된 것을 확인할 수 있다.
    
![Untitled 32](https://user-images.githubusercontent.com/109265165/191261496-4d8ac7d7-3022-4def-8b46-5fbb3e9f3901.png)
    

---

**✌️프로젝트를 하고 난 느낀점**

---

- 이상현
    - 어려워 보이지 않던 기능들도 막상 코딩을 하면 여러 문제들과 마주친다는 것을 알게 되었습니다.
    - 웹 프로젝트는 디버깅 기능을 사용하기가 힘들기 때문에 한번에 코드를 작성하는 것보다 간헐적으로 콘솔창을 통해 내가 작성한 코드가 맞는 뱡항으로 진행되는지 확인하는 것이 중요하다는 것을 알게 되었습니다.
    - 끝이 보이지 않아도 하나하나 기능을 구현해 나가면 완성할 수 있다는 것을 다시 한 번 깨닫게 되었습니다.
- 박수민
    
    웹페이지를 구현하는데 많은 기능이 필요한지 이번 관통프로젝트를 하며 깨달았습니다. 아직 서블릿과 JSP를 사용하는데 익숙하지 않아 하나의 기능을 구현하는데 시간이 오래걸렸으며, 오류가 떴을 때도 왜 오류가 생겼는지 확인하는데 좀 힘들었습니다. 그만큼 더 노력하여 더욱 완벽한 웹페이지는 만드려 노력해야겠다는 생각이 들었습니다. 그래도 프론트보다는 더 즐거웠어서 좋았습니다.
