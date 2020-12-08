# posgresqlkafkamongo

### Project Details

1. posgreskafka: This project read data from postgres DB and after that publish the message to kafka. REST api to initiate dbase sync http://localhost:17102/kafka
2. datamigration: This project consumes message from kafka topics published by first project and then save them in mongodb.
