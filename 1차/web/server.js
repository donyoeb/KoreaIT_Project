var http = require("http");
var express = require("express");//외부모듈(설치완료)
var static = require("serve-static");//외부모듈(설치완료)
var ejs = require("ejs");//외부모듈(설치완료)
var mysql = require("mysql");//외부모듈(설치완료)
var mymodule=require("./lib/mymodule.js");

var expressSession=require("express-session"); //서버측 세션을 관리하는 모듈

const conStr={
    url:"localhost",
    user:"root",
    password:"1234",
    database:"stocksite"
};

var app = express();
app.use(static(__dirname+"/static"));
app.use(express.urlencoded({
    extended:true
}));//post 요청의 파라미터 받기 위함.

app.use(expressSession({
    secret:"key secret",
    resave:true,
    saveUninitialized:true
}));

//템플릿 뷰 엔진 등록(서버 스크립트 위치 등록)
app.set("view engine", "ejs");//등록 후에는 자동으로 무조건 view하위에서 ejs를 찾아간다.(따라서 view라는 정해진 디렉토리 무조건 존재 시켜야 한다.)

//메인화면
app.get("/coin/main", function(request, response){
    response.render("main");
   //checkUserSession(request,response,"main"); //로그인 처리
    //나중엔 메인만 그냥  response.render("main");
    //처리하고 나머지에다가 로그인 처리세션 넣기
});

app.get("/coin/usermain", function(request, response){
    
    checkUserSession(request,response,"main"); //로그인 처리
});

app.get("/coin/main/investment", function(request, response){
    
    checkUserSession(request,response,"investment"); //로그인 처리
    
});

/*
//테트리스
app.get("/coin/game/tetris", function(request, response){
    response.render("../tetis/table.html");
});
//리듬게임
app.get("/coin/game/rhythm", function(request, response){
    response.render("../rhythm_game/intro.html");
});
*/
//회원가입 폼 요청
app.get("/coin/main/signupform", function(request, response){
    
    response.render("signup");
    
});

//회원가입 폼 요청 처리
app.post("/coin/main/signup", function(request, response){
    
    var user_id=request.body.user_id;
    var user_pass=request.body.user_pass;
    var user_name = request.body.user_name;
    
    console.log("입력 데이터 : " +user_id,user_pass,user_name);

    var sql="insert into member(user_id,user_pass,user_name)";
    sql+= " values(?,?,?)";
    var con=mysql.createConnection(conStr);
    con.query(sql, [user_id, user_pass, user_name] , function(err,  result , fields){
        if(err){
            console.log("등록 실패", err);
            response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
            response.end(mymodule.getMsgBack("가입 실패"));
       
        }else{
            
            console.log("등록 성공", user_id,user_name,user_pass);
            
            response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
            response.end(mymodule.getMsgUrl("회원가입 성공","/coin/main/loginform"));
        }

        con.end();
    });
});

//로그인 폼 요청
app.get("/coin/main/loginform", function(request, response){
    response.render("login");
});

//로그인 폼 요청 처리
app.post("/coin/main/login", function(request, response){
    var user_id=request.body.user_id;
    var user_pass=request.body.user_pass;
    console.log(user_id , user_pass);
    

    var sql="select * from member";
    sql +=" where user_id=? and user_pass=?";

    var con=mysql.createConnection(conStr);
    con.query(sql, [user_id, user_pass] , function(err,  result , fields){
        if(err){
            console.log("조회 실패", err);
        }else{
            //로그인이 일치 하는지 않하는지? 
            if(result.length <1){
                console.log("로그인 실패");
                response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
                response.end(mymodule.getMsgBack("로그인 정보가 올바르지 않습니다"));
            }else{
                console.log("로그인 성공",result);
               
                request.session.user={
                    member_id: result[0].member_id,
                    user_id:result[0].user_id,
                    user_pass:result[0].user_pass,
                    user_name:result[0].user_name,
                    user_money : result[0].user_money
                };
               
                response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
                response.end(mymodule.getMsgUrl("로그인성공","/coin/usermain"));
            }
        }
        con.end();
    });
  //  http://localhost:7777/coin/main


});

//로그아웃처리
app.post("/coin/logout", function(request, response){
    
    delete request.session.user;
    response.render("/coin/main");
   
});


/*---------------------------------------------------
세션 체크
---------------------------------------------------*/
function checkUserSession(request, response, url){
    if(request.session.user){ //  undefined가 아니라면..
        response.render(url, {
            joinUser:request.session.user
        });
    }else{
        response.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
        response.end(mymodule.getMsgBack("로그인이 필요한 서비스입니다.","/coin/main/loginform"));
    }
}

var server = http.createServer(app);
server.listen(7777, function(){
    console.log("Take your money...");
    
});