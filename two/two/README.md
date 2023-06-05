
# 개발툴 설치
 - JDK 1.8+
 - IntelliJ Community Edition(or Eclipse)
<br/>

# 샘플소스 불러오기
 - File > New > Project from version control...
    - Repository Url
        - version control : git
        - Url : https://github.com/oyslala/one.git
        - Directory : 설치할 디렉토리 선택
<br/>

# Rest API 호출하여 hello world 실행
 - MainController.java 
 - http://localhost:8080/hello?name=world 호출
 - 스웨거로 확인 ( http://localhost:8080/swagger-ui.html )
     ```
     @GetMapping("/hello")
     @ResponseBody
     public String helloName(@RequestParam String name) {
         return "Hello " + name;
     }
     ```
 - HTTP Method에 대한 이해 : 
    - @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
    - @RequestParam, @PathVariable, @RequestBody, @ModelAttribute
<br/>

# 데이타생성
 - 데이타베이스 설치 (postgres)
 - 테이블생성 
    ```
    CREATE TABLE tb_color (
      color_id character varying(100) PRIMARY KEY,
      color_name character varying(100) NOT NULL
    );
    ```
<br/>

# Rest API 호출하여 tb_color 테이블 CRUD
 - MainController.java, MainService.java, mainSQL.xml 파일 확인
 - CRUD
    ```
    @PostMapping("/insertColor")
    @ResponseBody
    public String insertColor(@RequestBody Color color) {
        mainService.insertColor(color);
        return "Insert OK";
    }

    @PostMapping("/updateColor")
    @ResponseBody
    public String updateColor(@RequestBody Color color) {
        mainService.updateColor(color);
        return "Update OK";
    }

    @GetMapping("/selectColor/{colorId}")
    @ResponseBody
    //public Color selectColor(@RequestParam String colorId) {
    public Color selectColor(@PathVariable String colorId) {
        Color color = mainService.selectColor(colorId);
        return color;
    }

    @DeleteMapping("/deleteColor")
    @ResponseBody
    public String deleteColor(@RequestParam String colorId) {
        mainService.deleteColor(colorId);
        return "Delete OK";
    }
    ```

    
