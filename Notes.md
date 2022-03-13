docker exec -it mqtt-server /bin/sh
# subscribe to the house topic with the mqtt client
mosquitto_sub -h localhost -t house/#

