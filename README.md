# guess_number
##docker for redis
docker pull redis
docker run -d -p 6379:6379 --name guess-redis redis

##build app & run
http://localhost:9090/api/guess_number
