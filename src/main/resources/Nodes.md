### Test redis

    docker exec -it redis-server /bin/sh
    redis-cli
    127.0.0.1:6379> ping
    PONG


### Test mosquittoo

    docker exec -it mqtt-server /bin/sh
    Subscriber
    mosquitto_sub -h localhost -t house/#
    Publisher
    mosquitto_pub -h localhost -m "hello world" -t house


### Test fake device

    docker exec -it fake-device /bin/sh
    node index.js:
