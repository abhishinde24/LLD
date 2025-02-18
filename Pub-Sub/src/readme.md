## Design Pub-Sub message queue

Function-Requirement
- Topic where publisher will push a message
- Consumers/subscribers which subscribe to topic

Bonus
- push a message to the consumer asynchronous manner
- 

Class
- Topic -> will have consumers, also having off-set
- Queue -> have multiple topics
- Message -> Handling messages differently



### Thought process :
- First commit
  - Queue Interface to push messages
  - Consumer consuming message 
  - Topic with subscriber
  
  what was missing
  - Consumer level offset
  - async message push to consumer

- Second commit 
  - Adding Consumer level offset, by separating Consumer and Subscriber class.
  - Adding topicHandler to handle message push asynchronously. 

Aysnc message push idea is borrowed from https://github.com/anomaly2104/low-level-design-messaging-queue-pub-sub/tree/main repo
