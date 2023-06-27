# spring-guides-Messaging-with-Redis

https://spring.io/guides/gs/messaging-redis/

## (1) Redis Server 실행
      docker run redis

## (2) Redis Message Receiver 생성 

message를 전송받을 클래스 생성
- MessageListerAdapter에 등록할 메서드만 생성해주면 된다
- 클래스, 메서드명 자유

## (3) Listener 등록 & message 전송

주요 설정
- connecton factory : redis server 연결
- message listener container : listener 등록
- redis template : messaging 구현
  

Redis template 객체의 인터페이스를 이용해 message를 보낼 수 있다 

// redis는 key-value 형태의 NoSQL로 사용되므로, 가장 활용도가 높은 String 데이터 타입을 위한
StringRedisTemplate을 Bean으로 등록


앞서 생성한 Receiver는 MessageListenerAdapter에 자신의 기본메서드와 함께 등록해주고,
MessageListernerAdapter는 RedisMessageListenerContainer에 한번에 Listener로 등록한다

// MessageListener를 등록할 때 channel 명도 함께 등록


RedisConnectionFactory 객체는 레디스 서버와 연결을 도와주는 객체로 모든 Config에 매개변수로 주입해준다

Tempalte -> channel 확인 후 message 전송 -> addMessageListener() -> Receiver 메서드 -> message 전송 완료  



