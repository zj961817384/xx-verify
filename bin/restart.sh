p=$(pgrep -f verify)
echo $p
kill -9 $p
cd /root/xx/xx-verify
mvn package
nohup java -jar target/verify-1.0-SNAPSHOT.jar &
echo "重启成功，tail -f nohup.out 查看日志"



