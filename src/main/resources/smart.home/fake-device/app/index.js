const http = require('http')

http.createServer(function (req, res) {
    res.writeHead(200, { 'Content-Type': 'application/json' })

    res.write(JSON.stringify({
            "id" : "fake-device",
            "location" : "bathroom",
            "category" : "http",
            "sensors" : [ {
                "temperature" : {
                    "unit" : "Celsius",
                    "value" : 18.0
                }
            }, {
                "humidity" : {
                    "unit" : "%",
                    "value" : 50.5
                }
            }, {
                "eCO2" : {
                    "unit" : "ppm",
                    "value" : 45100.0
                }
            } ]
        }
    ))
    res.end()
}).listen(8099)
